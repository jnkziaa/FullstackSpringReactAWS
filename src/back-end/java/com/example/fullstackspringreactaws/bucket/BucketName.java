package com.example.fullstackspringreactaws.bucket;

public enum BucketName {
    PROFILE_IMAGE("jnkziaacode-image-upload-1234");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
