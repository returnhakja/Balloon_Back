package com.balloon.service;

import java.util.List;

import com.balloon.entity.Chat;
import com.balloon.vo.MessageDTO;

public interface ChatService {
	
	public List<Chat> getChat();
	
	public Chat getOneChat(Long chatroomId);
	
	public Chat getChatContent(String chatContent);

	public void insertChat(MessageDTO messageDTO);

}
