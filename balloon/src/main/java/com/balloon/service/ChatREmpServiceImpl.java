package com.balloon.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.balloon.dto.ChatroomDTO;
import com.balloon.dto.ChatroomEmployeeDTO;
import com.balloon.dto.EmpDTO;
import com.balloon.entity.Chatroom;
import com.balloon.entity.ChatroomEmployee;
import com.balloon.entity.ChatroomEmployeeId;
import com.balloon.entity.Employee;
import com.balloon.repository.ChatREmpRepository;
import com.balloon.repository.ChatroomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatREmpServiceImpl implements ChatREmpService {

	private final ChatREmpRepository chatREmpRepository;
	private final ChatroomRepository chatroomRepository;

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
	public Employee getInsertChatEmp(ChatroomEmployeeDTO chatroomEmployeeDTO) {
		ChatroomEmployee chatEmpEntity = chatroomEmployeeDTO.toEntity(chatroomEmployeeDTO);
		Employee emp = chatREmpRepository.save(chatEmpEntity).getEmpId();
		if (emp != null) {
			Chatroom chatroomId = chatroomRepository.findById(chatroomEmployeeDTO.getChatroomId().getChatroomId())
					.get();
			// 생성자 패턴 사용할 예정
			// 생성자 생성 후 처음 chatroomDTO.setChatroomId();만 해줄 시 값은 null임
			// set메소드로 ChatroomDTO에 있는 id,name,count값을 가져와서 넣어줌
			ChatroomDTO chatroomDTO = new ChatroomDTO();
			chatroomDTO.setChatroomId(chatroomId.getChatroomId());
			chatroomDTO.setChatroomName(chatroomId.getChatroomName());
			chatroomDTO.setHeadCount(chatroomId.getHeadCount() + 1);
			// 사람 많이 추가 시 Controller에서 List로 받아옴, List.size()만큼 head_Counter를 추가해준다
			chatroomRepository.save(chatroomDTO.toEntity(chatroomDTO));
		}
		return emp;
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

		System.out.println(chatroomEmployeeDTO);

		ChatroomEmployeeId chatroomEmployeeIdEntity = chatroomEmployeeDTO.toId(chatroomEmployeeDTO);
		chatREmpRepository.deleteById(chatroomEmployeeIdEntity);
	}

}
