package com.balloon.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.balloon.dto.ChatroomDTO;
import com.balloon.dto.ChatroomEmployeeDTO;
import com.balloon.dto.EmpDTO;
import com.balloon.entity.ChatroomEmployee;
import com.balloon.entity.ChatroomEmployeeId;
import com.balloon.entity.Employee;
import com.balloon.repository.ChatREmpRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatREmpServiceImpl implements ChatREmpService {

	private final ChatREmpRepository chatREmpRepository;

	@Override
	@Transactional
	public List<ChatroomEmployee> getallChatEmp() {
		return chatREmpRepository.findAll();
	}

	@Override
	public List<ChatroomEmployee> getChatroomEmp(Long chatroomId) {
		return chatREmpRepository.findAllByChatroomIdChatroomId(chatroomId);
	}

	@Override
	@Transactional
	public List<ChatroomEmployee> getBotchatroom(List<String> empId) {
		return chatREmpRepository.findChatroomEmployeeByempId(empId);
	}

	@Override
	@Transactional
	public List<ChatroomEmployee> getInsertChatEmp(List<ChatroomEmployeeDTO> chatroomEmployeeDTO) {
		List<ChatroomEmployee> chatroomEmployeeEntity = new ArrayList<ChatroomEmployee>();
		for (ChatroomEmployeeDTO chatEmpDTO : chatroomEmployeeDTO) {
			chatroomEmployeeEntity.add(chatEmpDTO.toEntity(chatEmpDTO));
		}

		return chatREmpRepository.saveAll(chatroomEmployeeEntity);

	}

	@Override
	@Transactional
	public Employee getInsertSchChat(ChatroomEmployeeDTO chatroomEmployeeDTO) {
		ChatroomEmployee chatroomEmployeeEntity = chatroomEmployeeDTO.toEntity(chatroomEmployeeDTO);
		return chatREmpRepository.save(chatroomEmployeeEntity).getEmpId();
	}

	@Override
	@Transactional
	public void getdeleteChatroom(Long chatroomId, String empId) {
		ChatroomEmployeeDTO chatroomEmployeeDTO = new ChatroomEmployeeDTO();
		ChatroomDTO chatroomDTO = new ChatroomDTO();
		chatroomDTO.setChatroomId(chatroomId);
		chatroomEmployeeDTO.setChatroomId(chatroomDTO);

		EmpDTO empDTO = new EmpDTO();
		empDTO.setEmpId(empId);
		chatroomEmployeeDTO.setEmpId(empDTO);

		ChatroomEmployeeId chatroomEmployeeIdEntity = chatroomEmployeeDTO.toId(chatroomEmployeeDTO);
		chatREmpRepository.deleteById(chatroomEmployeeIdEntity);

	}

}
