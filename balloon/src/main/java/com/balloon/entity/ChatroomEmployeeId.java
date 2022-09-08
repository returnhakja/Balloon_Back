package com.balloon.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatroomEmployeeId implements Serializable {

	private Long chatroomId;

	private String empId;

}