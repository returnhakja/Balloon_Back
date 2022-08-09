package com.balloon.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.balloon.dto.ChatDTO;
import com.balloon.entity.Chat;
import com.balloon.entity.Employee;
import com.balloon.service.ChatServiceImpl;
import com.balloon.service.EmpServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000"})
public class ChatRestController {
	
	private final EmpServiceImpl empSvc;
	private final ChatServiceImpl chatServiceImpl;
	
	@GetMapping(value = "/allEmp")
	public List<Employee> allEmp() {
		return empSvc.getEmp();
	}
	
	@GetMapping(value = "/allChat/{empId}")
	public List<Chat> allChat(@PathVariable(name = "empId") Employee empId) {
		return chatServiceImpl.getChat(empId);
	}
	
	@GetMapping(value = "/onechatroom/{chatroomId}")
	public List<ChatDTO> oneChatoom(@PathVariable(value = "chatroomId") Long chatroomId) {
		return chatServiceImpl.getChatroomId(chatroomId);
	}	
}
