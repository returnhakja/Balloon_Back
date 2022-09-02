package com.balloon.service;

import java.util.List;

import com.balloon.dto.ChatroomDTO;

public interface ChatroomService {

	public List<ChatroomDTO> getAllChatroom();

	public ChatroomDTO getOneChatroom(Long chatroomId);

	public Long getCreateChatroom(ChatroomDTO chatroomDTO);

	public List<ChatroomDTO> getCreateSchroom(List<ChatroomDTO> chatroomDTO);

	public void getUpdateChatroom(ChatroomDTO chatroomDTO);

	public void deleteChatroom(Long chatroomId);

}