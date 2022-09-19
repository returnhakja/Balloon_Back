package com.balloon.socket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class ChatConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {

<<<<<<< HEAD
		registry.addEndpoint("/chatstart").setAllowedOrigins("http://54.180.148.125", "http://localhost:3000")
				.withSockJS();

//      .setAllowedOrigins("http://15.164.224.26")
//				.setAllowedOrigins("http://54.180.148.125")
//				.withSockJS();
=======
		registry.addEndpoint("/chatstart").setAllowedOrigins("http://localhost:3000").withSockJS();
>>>>>>> 28cd69fa1279cfc7504235ebc9523ad34ec3d86b

		// websocket에 접근하기위한 Endpoint -> localhost:8000/chatstart/topic 으로 발행 또는 구독시에만
		// 메세지 발행, 구독이 가능하다.
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
<<<<<<< HEAD

		config.enableSimpleBroker("/topic"); // 1:n / 1:1

=======
		config.enableSimpleBroker("/topic");

>>>>>>> 28cd69fa1279cfc7504235ebc9523ad34ec3d86b
		// "/app" 접두사가 붙은 url로 발행한 메세지만 핸들러로 라우팅
		config.setApplicationDestinationPrefixes("/app");
	}
}
