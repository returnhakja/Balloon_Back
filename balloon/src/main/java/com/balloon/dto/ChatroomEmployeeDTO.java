package com.balloon.dto;

import com.balloon.entity.ChatroomEmployee;
import com.balloon.entity.ChatroomEmployeeId;

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
				.chatroomId(chatroomDTO.toEntity(chatroomDTO)).empId(employeeDTO.toEntity(employeeDTO)).build();
		return chatroomEmployeeEntity;
	}

	public ChatroomEmployeeId toId(ChatroomEmployeeDTO chatroomEmployeeDTO) {
		ChatroomDTO chatroomDTO = chatroomEmployeeDTO.getChatroomId();
		EmpDTO employeeDTO = chatroomEmployeeDTO.getEmpId();
		ChatroomEmployeeId chatroomEmployeeIdEntity = ChatroomEmployeeId.builder()
				.chatroomId(chatroomDTO.toEntity(chatroomDTO).getChatroomId())
				.empId(employeeDTO.toEntity(employeeDTO).getEmpId()).build();
		return chatroomEmployeeIdEntity;
	}

}
