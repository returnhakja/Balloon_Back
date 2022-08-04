package com.balloon.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.balloon.dto.EmpDTO;
import com.balloon.dto.EmpRequestDTO;
import com.balloon.dto.EmpResponseDTO;
import com.balloon.dto.TokenDTO;
import com.balloon.service.AuthServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping( method = {RequestMethod.POST, RequestMethod.GET})
@RequiredArgsConstructor
public class AuthRestController {
    private final AuthServiceImpl authSvc;

    @GetMapping("/loginPage")
    public String loginPage() {
    	return "loginPage.html";
    }
    
    @GetMapping("/accesDenied")
    public String accesDeniedPage() {
    	return "access Deny. but why?";
    }
    
    
    
    @PostMapping("/auth/signup")
    public ResponseEntity<EmpResponseDTO> signup(@Valid @RequestBody EmpRequestDTO requestDto) {
    	return ResponseEntity.ok(authSvc.signup(requestDto));
    }

    @PostMapping("/auth/login")
    public ResponseEntity<TokenDTO> login(@Valid @RequestBody EmpRequestDTO requestDto) {
        return ResponseEntity.ok(authSvc.login(requestDto));
    }
    
    

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginEmp(@Valid @RequestBody EmpRequestDTO requestDto, HttpServletResponse response) {
    	
        return ResponseEntity.ok(authSvc.loginUser(requestDto,response ));
    }
}