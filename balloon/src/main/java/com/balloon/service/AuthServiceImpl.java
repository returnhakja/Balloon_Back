package com.balloon.service;

import javax.transaction.Transactional;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.balloon.dto.EmpRequestDTO;
import com.balloon.dto.EmpResponseDTO;
import com.balloon.dto.TokenDTO;
import com.balloon.entity.Employee;
import com.balloon.jwt.TokenProvider;
import com.balloon.repository.EmpRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthServiceImpl implements AuthService{
    private final AuthenticationManagerBuilder managerBuilder;
    private final EmpRepository empRepo;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    @Override
    public EmpResponseDTO signup(EmpRequestDTO requestDto) {
    	System.out.println(requestDto.getEmpId());
        if ((empRepo.existsEmpByEmpId(requestDto.getEmpId())) == true) {
        	throw new RuntimeException("이미 가입되어 있는 유저입니다");
        } else {
        	Employee employee = requestDto.toEmployee(passwordEncoder);
        	return EmpResponseDTO.of(empRepo.save(employee));
        }

    }
    
    @Override
    public TokenDTO login(EmpRequestDTO requestDto) {
    	System.out.println(requestDto.getEmpId());
    	System.out.println(requestDto.getPassword());
    	UsernamePasswordAuthenticationToken authenticationToken = requestDto.toAuthentication();
    	System.out.println("-----------------------------------");
    	System.out.println(authenticationToken.getPrincipal());
    	System.out.println(authenticationToken.getName());
    	System.out.println(authenticationToken.getCredentials());
    	System.out.println(authenticationToken.getDetails());
    	System.out.println(authenticationToken.getAuthorities());
    	System.out.println("-----------------------------------");
    	Authentication authentication = managerBuilder.getObject().authenticate(authenticationToken);
        System.out.println(authentication.getCredentials());
        System.out.println(authentication.getDetails());
        System.out.println(authentication.getName());
        System.out.println(authentication.getPrincipal());
        System.out.println(authentication.getAuthorities());
        
        return tokenProvider.generateTokenDTO(authentication);
    }

}