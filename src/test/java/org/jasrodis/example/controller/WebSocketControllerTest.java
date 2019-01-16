package org.jasrodis.example.controller;

import static java.util.Arrays.asList;
import static java.util.concurrent.TimeUnit.SECONDS;

import java.lang.reflect.Type;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSession.Subscription;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

/**
 * Tests the websocket subscription
 * 
 * @author jasrodis
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class WebSocketControllerTest {

	private static final String WEBSOCKET_URI = "ws://localhost:8080/data-info";
	private static final String WEBSOCKET_TOPIC = "/info";

	private WebSocketStompClient stompClient;

	@Before
	public void setup() {
		stompClient = new WebSocketStompClient(
				new SockJsClient(asList(new WebSocketTransport(new StandardWebSocketClient()))));
	}

	@Test
	public void shouldCreateASubscription() throws Exception {
		StompSession session = stompClient.connect(WEBSOCKET_URI, new StompSessionHandlerAdapter() {
		}).get(5, SECONDS);
		Subscription subscription = session.subscribe(WEBSOCKET_TOPIC, new DefaultStompFrameHandler());
		Assert.assertNotNull(subscription.getSubscriptionId());
	}

	class DefaultStompFrameHandler implements StompFrameHandler {
		@Override
		public Type getPayloadType(StompHeaders stompHeaders) {
			return byte[].class;
		}

		@Override
		public void handleFrame(StompHeaders stompHeaders, Object o) {
		}
	}
}
