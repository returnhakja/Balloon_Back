package com.balloon.service;

import java.util.List;

import com.balloon.dto.ChatroomEmployeeDTO;
import com.balloon.entity.ChatroomEmployee;

public interface ChatREmpService {
	
	public List<ChatroomEmployee> getallChatEmp();
	
	public ChatroomEmployee getoneChatEmp(Long chatroomId);
	
	public void getInsertChatEmp(ChatroomEmployeeDTO chatroomEmployeeDTO);
}
