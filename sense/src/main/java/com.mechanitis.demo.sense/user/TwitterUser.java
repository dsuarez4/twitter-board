package com.mechanitis.demo.sense.user;

/**
 * Created by davidsuarez on 7/22/17.
 */
public class TwitterUser {
    private String twitterHandle;

    TwitterUser(String twitterHandle) {
        this.twitterHandle = twitterHandle;
    }

    @Override
    public String toString() {
        return twitterHandle;
    }
}
