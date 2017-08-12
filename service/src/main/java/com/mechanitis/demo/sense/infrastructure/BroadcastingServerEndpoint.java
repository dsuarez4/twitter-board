package com.mechanitis.demo.sense.infrastructure;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.Session;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;

import static java.util.logging.Level.FINE;

/**
 * Created by davidsuarez on 7/14/17.
 */
public class BroadcastingServerEndpoint<T> extends Endpoint implements MessageListener<T> {
    private static final Logger LOGGER = Logger.getLogger(BroadcastingServerEndpoint.class.getName());
    // We will be iterating across the collection of sessions often
    private final List<Session> sessions = new CopyOnWriteArrayList<>();

    @Override
    public void onMessage(T message) {
        sessions.stream()
                .filter(Session::isOpen)
                .forEach(session -> sendMessageToClient(message.toString(), session));
    }

    private void sendMessageToClient(String message, Session session) {
        try {
            LOGGER.log(FINE, "MessageBroadcastingEndpoint sending: tweet = [" + message + "]");
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onOpen(Session session, EndpointConfig config) {
        sessions.add(session);
    }
}
