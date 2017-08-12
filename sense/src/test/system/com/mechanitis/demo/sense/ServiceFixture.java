package com.mechanitis.demo.sense;

import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;

/**
 * Created by davidsuarez on 8/8/17.
 */
public class ServiceFixture {

    public static boolean connectAndWaitForSuccess() {

        WebSocketContainer container = ContainerProvider.getWebSocketContainer();

    }
}
