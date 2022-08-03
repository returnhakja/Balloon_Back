package com.balloon.service;

import com.balloon.dto.EmpRequestDTO;
import com.balloon.dto.EmpResponseDTO;
import com.balloon.dto.TokenDTO;

public interface AuthService {

	public EmpResponseDTO signup(EmpRequestDTO requestDto);
	
	public TokenDTO login(EmpRequestDTO requestDto);
}
