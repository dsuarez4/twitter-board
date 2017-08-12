package com.mechanitis.demo.sense.infrastructure

import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Subject
import javax.websocket.Session
import javax.websocket.RemoteEndpoint

/**
 * Created by davidsuarez on 7/14/17.
 */
class BroadcastingServerEndpointSpecification extends Specification {
    @Subject
    def endpoint = new BroadcastingServerEndpoint()

    @Ignore("2")
    def 'should accept messages and publish the toString() representation'() {
        given:
        def session = Mock(Session)
        session.isOpen() >> true

        def remoteEndpoint = Mock(RemoteEndpoint.Basic)
        session.getBasicRemote() >> remoteEndpoint

        endpoint.onOpen(session, null)

        when:
        endpoint.onMessage(new StubMessage())

        then:
        remoteEndpoint.sendText("StubMessage{}")
    }

    @Ignore("2")
    def 'should forward messages to all open sessions'() {
        given:
        def session = Mock(Session)
        endpoint.onOpen(session, null)
        session.isOpen() >> true

        def remoteEndpoint = Mock(RemoteEndpoint.Basic)
        session.getBasicRemote() >> remoteEndpoint

        def tweet = "Some Tweet"

        when:
        endpoint.onMessage(tweet)

        then:
        1 * remoteEndpoint.sendText(tweet);
    }

    @Ignore("2")
    def 'should not try to forward messages to closed sessions'() {
        given:
        def session = Mock(Session)
        endpoint.onOpen(session, null)

        when:
        endpoint.onMessage("Some Tweet")

        then:
        0 * session./get.*Remote/()
    }

    private static class StubMessage {
        @Override
        public String toString() {
            return "StubMessage{}";
        }
    }
}
