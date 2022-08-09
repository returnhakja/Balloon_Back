package com.balloon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.balloon.entity.ChatroomEmployee;
import com.balloon.entity.ChatroomEmployeeId;

@Repository
public interface ChatREmpRepository extends JpaRepository<ChatroomEmployee, ChatroomEmployeeId>{
	
	public ChatroomEmployee findChatroomEmployeeBychatroomId(Long chatroomId);
}
