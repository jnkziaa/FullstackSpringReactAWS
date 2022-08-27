package com.example.fullstackspringreactaws.dataStore;

import com.example.fullstackspringreactaws.profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class UserProfileDataStore {

    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();
    static {
        USER_PROFILES.add(new UserProfile(UUID.fromString("079a0979-8ea4-46ef-abda-31434f4dec44"), "jinkaza", null));
        USER_PROFILES.add(new UserProfile(UUID.fromString("0d715417-7e25-4469-aa2f-e4ecb7a79efb"), "antoniobanderas", null));
    }

    public UserProfileDataStore() {
    }

    public List<UserProfile> getUserProfiles(){
        return USER_PROFILES;
    }
}
