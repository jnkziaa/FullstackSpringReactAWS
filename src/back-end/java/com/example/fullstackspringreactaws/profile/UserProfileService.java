package com.example.fullstackspringreactaws.profile;

import com.example.fullstackspringreactaws.bucket.BucketName;
import com.example.fullstackspringreactaws.fileStore.FileStore;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;

@Service
public class UserProfileService {
    private final UserProfileDataAccessService userProfileDataAccessService;
    private final FileStore fileStore;

    public UserProfileService(UserProfileDataAccessService userProfileDataAccessService, FileStore fileStore) {
        this.userProfileDataAccessService = userProfileDataAccessService;
        this.fileStore = fileStore;
    }

    @Autowired


    List<UserProfile> getUserProfiles(){
        return userProfileDataAccessService.getUserProfile();
    }

    public void uploadUserProfileImage(UUID userProfileId, MultipartFile file) {
        //check if image is not empty
        //check if file an image
        //check if user exists in the database
        //grab some metadata from file if any
        //store the image in s3 and update database with s3 image link

        isEmpty(file);
        isImage(file);
        UserProfile user = getUserProfile(userProfileId);

        Map<String, String> metaData = new HashMap<>();
        metaData.put("Content-Type", file.getContentType());
        metaData.put("Content-Length", String.valueOf(file.getSize()));

        String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), userProfileId);
        String fileName = String.format("%s-%s", file.getOriginalFilename(), UUID.randomUUID());
        try {
            fileStore.save(path, fileName, Optional.of(metaData), file.getInputStream());
            user.setUserProfileImageLink(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public byte[] downloadUserProfileImage(UUID userProfileId) {
        Predicate<? super UserProfile> userProfilePredicate = a->a.getUserProfileId().equals(userProfileId);
        Optional<UserProfile> userProfileOptional = userProfileDataAccessService.getUserProfile().stream().filter(userProfilePredicate).findFirst();
        if(userProfileOptional.isEmpty()){
            throw new IllegalStateException("User does not exist");
        }
        UserProfile user = userProfileOptional.get();
        String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), user.getUserProfileId());

        return user.getUserProfileImageLink().map(key -> fileStore.download(path, key)).orElse(new byte[0]);


    }

    private UserProfile getUserProfile(UUID userProfileId) {
        Predicate<? super UserProfile> userProfilePredicate = a->a.getUserProfileId().equals(userProfileId);
        Optional<UserProfile> userProfileOptional = userProfileDataAccessService.getUserProfile().stream().filter(userProfilePredicate).findFirst();
        if(userProfileOptional.isEmpty()){
            throw new IllegalStateException("User does not exist");
        }
        return userProfileOptional.get();
    }

    private void isImage(MultipartFile file) {
        if(Arrays.asList(ContentType.IMAGE_JPEG, ContentType.IMAGE_GIF, ContentType.IMAGE_PNG)
                .contains(file.getContentType())){
            throw new IllegalStateException("File must be an Image");
        }
    }

    private void isEmpty(MultipartFile file) {
        if(file.isEmpty()){
            throw new IllegalStateException("File is empty");
        }
    }


}
