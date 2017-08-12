package com.mechanitis.demo.sense.user;


import com.mechanitis.demo.sense.infrastructure.DaemonThreadFactory;
import com.mechanitis.demo.sense.twitter.CannedTweetsService;
import org.junit.Ignore;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.ClassLoader.getSystemResource;
import static com.mechanitis.demo.sense.ServiceFixture.connectAndWaitForSuccess;

public class UserServiceTest {

    private final ExecutorService executor = Executors.newFixedThreadPool(2, new DaemonThreadFactory());

    @Test
    @Ignore("5")
    public void shouldStartupAndAllowClientToConnectAndRecieveMessage() throws Exception {
        // start the Tweet Service server, User Service connects to this
        CannedTweetsService tweetsService = startCannedTweetsService();

        // start the mood service, the service under test
        UserService userService = new UserService();

    }

    private CannedTweetsService startCannedTweetsService() {
//        Path path = Paths.get()
        return null;
    }


}
