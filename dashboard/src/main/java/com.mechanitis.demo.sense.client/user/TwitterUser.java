package com.mechanitis.demo.sense.client.user;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by davidsuarez on 7/14/17.
 */
public class TwitterUser {
    private final SimpleStringProperty twitterHandle = new SimpleStringProperty();
    private final SimpleIntegerProperty tweetCount = new SimpleIntegerProperty();
    private AtomicInteger count = new AtomicInteger(0);

    public TwitterUser(String twitterHandle) {
        this.twitterHandle.set(twitterHandle);
    }

    public SimpleStringProperty getTwitterHandle() {
        return twitterHandle;
    }

    public int getTweetCount() {
        return tweetCount.get();
    }

    public SimpleIntegerProperty tweetCountProperty() {
        return tweetCount;
    }

    public int incrementCount() {
        int newValue = count.incrementAndGet();
        tweetCount.set(newValue);
        return newValue;
    }

}
