package com.balloon.vo;

import java.time.LocalDate;

import com.balloon.dto.ChatroomDTO;
import com.balloon.dto.EmpDTO;
import com.balloon.entity.Chat;
import com.balloon.entity.Chatroom;
import com.balloon.entity.Employee;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MessageDTO {
	
	String chatroomId;
	
	String writer;
	
	String chatContent;
	
	
	public Chat toChat(MessageDTO messageDTO) {
		//---------------chatRoomId 값을 entity로 변환해준 것-----------------------
		ChatroomDTO chatroomDTO = new ChatroomDTO();
		chatroomDTO.setChatroomId(Long.parseLong(messageDTO.getChatroomId()));
		Chatroom chatRoomId = chatroomDTO.toEntity(chatroomDTO);
		//--------------------------------------------------
		//---------------EmployeeId 값을 entity로 변환해준 것-----------------------
		EmpDTO employeeDTO = new EmpDTO();
		employeeDTO.setEmpId(messageDTO.getWriter());
		Employee employeeId = employeeDTO.toEntity(employeeDTO);
		// ---------------------------------------------
		Chat chatEntity = Chat.builder()
				.chatroom(chatRoomId)
				.chatContent(messageDTO.getChatContent())
				.employee(employeeId)
				
				.build();
		return chatEntity; 
	}
}
