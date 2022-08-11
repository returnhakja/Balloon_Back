package com.balloon.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.balloon.dto.ChatroomDTO;
import com.balloon.dto.ChatroomEmployeeDTO;
import com.balloon.entity.ChatroomEmployee;
import com.balloon.entity.Employee;
import com.balloon.service.ChatREmpServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = { "http://localhost:3000" })
public class ChatREmpRestController {

	private final ChatREmpServiceImpl chatREmpServicImpl;

	@GetMapping(value = "/allChatEmp")
	public List<ChatroomEmployee> allChatEmp() {
		return chatREmpServicImpl.getallChatEmp();
	}

	@GetMapping(value = "/OneChatEmp/{chatroomId}")
	public ChatroomEmployee oneChatEmp(Long chatroomId) {
		return chatREmpServicImpl.getoneChatEmp(chatroomId);
	}

	@PostMapping(value = "/insertChatEmp/{chatroomId}")
	public Employee insertChatEmp(@PathVariable(name = "chatroomId") Long chatroomId,
			@RequestBody ChatroomEmployeeDTO chatroomEmployeeDTO) {
		ChatroomDTO chatroomDTO = new ChatroomDTO();
		chatroomDTO.setChatroomId(chatroomId);
		chatroomEmployeeDTO.setChatroomId(chatroomDTO);
		System.out.println(chatroomEmployeeDTO);
		return chatREmpServicImpl.getInsertChatEmp(chatroomEmployeeDTO);
	}

	@DeleteMapping(value = "/deleteroom/{chatroomId}/{empId}")
	public void deleteChat(@PathVariable("chatroomId") Long chatroomId, @PathVariable("empId") String empId) {
		chatREmpServicImpl.getdeleteChatroom(chatroomId, empId);
	}

}
