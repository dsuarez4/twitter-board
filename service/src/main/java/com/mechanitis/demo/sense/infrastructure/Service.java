package com.mechanitis.demo.sense.infrastructure;

import javax.websocket.DeploymentException;
import java.io.IOException;
import java.util.logging.Logger;

import static java.util.logging.Level.FINE;

/**
 * Created by davidsuarez on 7/12/17.
 */
public class Service implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(Service.class.getName());

    private final String endpointToConnectTo;
    private final String serviceEndpointPath;
    private final int servicePort;

    private ClientEndpoint<String> clientEndpoint;
    private MessageHandler<String> messageHandler;

    public Service(String endpointToConnectTo, String serviceEndpointPath, int servicePort,
                   MessageHandler<String> messageHandler) {
        this.endpointToConnectTo = endpointToConnectTo;
        this.messageHandler = messageHandler;
        this.serviceEndpointPath = serviceEndpointPath;
        this.servicePort = servicePort;
    }

    public static void main(String[] args) throws IOException, DeploymentException {
        new Service("ws://localhost:8081/tweets/", "/testing/", 8090,
                originalText -> originalText).run();
    }

    @Override
    public void run() {
        LOGGER.setLevel(FINE);
        try {
            BroadcastingServerEndpoint<String> broadcastingServerEndpoint = new BroadcastingServerEndpoint<>();


            // Run the Jetty server for the server endpoint that clients will connect to.
            // The endpoint simply informs all listeners of all messages

        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
        }
    }

    public void stop() throws Exception {

    }
}
