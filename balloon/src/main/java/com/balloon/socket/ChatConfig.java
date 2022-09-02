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
		// registry.addEndpoint("/chatstart").setAllowedOrigins("http://localhost:3000").withSockJS();

		// websocket에 접근하기위한 Endpoint -> localhost:8000/chatstart/topic 으로 발행 또는 구독시에만
		// 메세지 발행, 구독이 가능하다.
		registry.addEndpoint("/chatstart").setAllowedOrigins("*").withSockJS();
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		// "/topic" 접두사가 붙은 url을 구독하는 대상들에 한하여 브로커가 메세지를 전달한다.
		config.enableSimpleBroker("/topic"); // 1:n / 1:1

		// "/app" 접두사가 붙은 url로 발행한 메세지만 핸들러로 라우팅
		config.setApplicationDestinationPrefixes("/app");
	}
}
