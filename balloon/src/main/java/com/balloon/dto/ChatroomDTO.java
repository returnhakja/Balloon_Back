package com.balloon.dto;

import com.balloon.entity.Chatroom;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChatroomDTO {
	
	private Long chatroomId;
	
	private String chatroomName;
	
	private Long headCount;
	
	public Chatroom toEntity(ChatroomDTO chatroomDTO) {
		Chatroom chatroomEntity = Chatroom.builder()
												.chatroomId(chatroomDTO.getChatroomId())
												.chatroomName(chatroomDTO.getChatroomName())
												.headCount(chatroomDTO.getHeadCount())
												.build();
		return chatroomEntity;
	}
}
