package com.balloon.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balloon.entity.Chat;
import com.balloon.repository.ChatRepository;
import com.balloon.vo.MessageDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {
	
	@Autowired
	private final ChatRepository chatRepository;
	
	@Override
	@Transactional
	public List<Chat> getChat() {
		return chatRepository.findAll();
	}

	@Override
	@Transactional
	public Chat getOneChat(Long chatroomId) {
		return chatRepository.findChatByChatroomId(chatroomId);
	}

	@Override
	@Transactional
	public Chat getChatContent(String chatContent) {
		return chatRepository.findChatByChatContent(chatContent);
	}

	@Override
	public void insertChat(MessageDTO messageDTO) {
		Chat chat = messageDTO.toChat(messageDTO);
		chatRepository.save(chat);
	}

	
	
	
	
	
	
	
}
