package com.balloon.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.balloon.dto.ChatDTO;
import com.balloon.entity.Employee;
import com.balloon.service.ChatServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = { "http://localhost:3000" })
public class ChatRestController {

	private final ChatServiceImpl chatServiceImpl;

	// 마지막으로 보낸 채팅내용 -> 채팅방리스트
	@GetMapping(value = "/allChat/{empId}")
	public List<ChatDTO> allChat(@PathVariable(name = "empId") Employee empId) {
		return chatServiceImpl.getChat(empId);
	}

	// 채팅방 기록남기기
	@GetMapping(value = "/chatRecord/{chatroomId}")
	public List<ChatDTO> chattingRecord(@PathVariable(value = "chatroomId") Long chatroomId) {
		return chatServiceImpl.getChatroomId(chatroomId);
	}

}
