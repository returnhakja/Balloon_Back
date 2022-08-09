package com.balloon.service;

import java.util.List;

import com.balloon.dto.ChatDTO;
import com.balloon.entity.Employee;
import com.balloon.vo.MessageDTO;

public interface ChatService {
	
	public List<ChatDTO> getChat(Employee empId);
	
	public void insertChat(MessageDTO messageDTO);
	
	public List<ChatDTO> getChatroomId(Long chatroomId);

}
