package com.mechanitis.demo.sense.infrastructure;

/**
 * Created by davidsuarez on 7/12/17.
 */

@FunctionalInterface
public interface MessageHandler<T> {
    T processMessage(String message);
}
