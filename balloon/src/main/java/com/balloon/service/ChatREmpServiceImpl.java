package com.balloon.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.balloon.dto.ChatroomEmployeeDTO;
import com.balloon.entity.ChatroomEmployee;
import com.balloon.repository.ChatREmpRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatREmpServiceImpl implements ChatREmpService{
	
	private final ChatREmpRepository chatREmpRepository;

	@Override
	@Transactional
	public List<ChatroomEmployee> getallChatEmp() {
		return chatREmpRepository.findAll();
	}

	@Override
	@Transactional
	public ChatroomEmployee getoneChatEmp(Long chatroomId) {
		return chatREmpRepository.findChatroomEmployeeBychatroomId(chatroomId);
	}

	@Override
	@Transactional
	public void getInsertChatEmp(ChatroomEmployeeDTO chatroomEmployeeDTO) {
		ChatroomEmployee chatEmpEntity = chatroomEmployeeDTO.toEntity(chatroomEmployeeDTO);
		chatREmpRepository.save(chatEmpEntity);
		
	}
}
