package com.balloon.dto;

import com.balloon.entity.Chatroom;
import com.balloon.entity.ChatroomEmployee;
import com.balloon.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChatroomEmployeeDTO {
	
	private ChatroomDTO chatroomId;
	
	private EmpDTO empId;
	
	
	public ChatroomEmployee toEntity(ChatroomEmployeeDTO chatroomEmployeeDTO) {
		ChatroomDTO chatroomDTO = chatroomEmployeeDTO.getChatroomId();
		EmpDTO employeeDTO = chatroomEmployeeDTO.getEmpId();
		ChatroomEmployee chatroomEmployeeEntity = ChatroomEmployee.builder()
																		.chatroomId(chatroomDTO.toEntity(chatroomDTO))
																		.empId(employeeDTO.toEntity(employeeDTO))
																		.build();
		return chatroomEmployeeEntity;
	}
}
