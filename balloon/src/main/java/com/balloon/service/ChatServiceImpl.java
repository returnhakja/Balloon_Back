package com.balloon.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balloon.dto.ChatDTO;
import com.balloon.entity.Chat;
import com.balloon.entity.Employee;
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
	public List<Chat> getChat(Employee empId) {
		return chatRepository.findAll(empId);
	}

	@Override
	public void insertChat(MessageDTO messageDTO) {
		Chat chat = messageDTO.toChat(messageDTO);
		chatRepository.save(chat);
	}
	
	@Override
	public List<ChatDTO> getChatroomId(Long chatroomId) {
		List<ChatDTO> ChatList = new ArrayList<ChatDTO>();
		for(Chat chat: chatRepository.findAllByChatroomChatroomId(chatroomId)) {
			ChatList.add(chat.toChatDTO(chat));
		}
		return ChatList;
	}
	
	
	
	
	
	
	
	
}
