package com.balloon.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.balloon.service.ChatServiceImpl;
import com.balloon.vo.MessageDTO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000"})
public class MessageController {
	//특정 broker로 메세지를 전달
	private final SimpMessagingTemplate template;
	private final ChatServiceImpl chatService;
	@MessageMapping(value = "/chat/message")
		public void message(@Payload MessageDTO messageDTO) {
		System.out.println(messageDTO);
		System.out.println("연결성공");
		chatService.insertChat(messageDTO);
		template.convertAndSend("/topic/message",messageDTO);
	}
	
}
