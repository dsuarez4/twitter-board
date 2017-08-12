package com.mechanitis.demo.sense.infrastructure;

/**
 * Created by davidsuarez on 7/14/17.
 */
@FunctionalInterface
public interface MessageListener<T> {
    void onMessage(T message);
}
