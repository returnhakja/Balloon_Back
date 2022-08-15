package com.balloon.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

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

	private final ChatRepository chatRepository;

	@Override
	@Transactional
	public List<ChatDTO> getChat(Employee empId) {
		List<Chat> chatEntityList = chatRepository.findAll(empId);
		List<ChatDTO> chatDTOList = new ArrayList<ChatDTO>();

		chatEntityList.forEach(chatEntity -> chatDTOList.add(chatEntity.toDTO(chatEntity)));

		return chatDTOList;
	}

	@Override
	@Transactional
	public void insertChat(MessageDTO messageDTO) {
		Chat chat = messageDTO.toChat(messageDTO);
		chatRepository.save(chat);
	}

	@Override
	@Transactional
	public List<ChatDTO> getChatroomId(Long chatroomId) {
		List<ChatDTO> ChatList = new ArrayList<ChatDTO>();
		for (Chat chat : chatRepository.findAllByChatroomChatroomId(chatroomId)) {
			ChatList.add(chat.toChatDTO(chat));
		}
		return ChatList;
	}

//	@Override
//	public void getInsertChat(ChatDTO chatDTO) {
//		Chat chatEntity = chatDTO.toEntity(chatDTO);
//		chatRepository.save(chatEntity);
//	}

}
