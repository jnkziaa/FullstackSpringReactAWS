package com.example.fullstackspringreactaws.profile.dataStore;

import com.example.fullstackspringreactaws.profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class UserProfileDataStore {

    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();
    static {
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "jinkaza", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "antoniobanderas", null));
    }

    public UserProfileDataStore() {
    }

    public List<UserProfile> getUserProfiles(){
        return USER_PROFILES;
    }
}
