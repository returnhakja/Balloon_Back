package com.balloon.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ChatroomEmployeeId implements Serializable{
	
	private Long chatroomId;
	
	private String empId;
}
