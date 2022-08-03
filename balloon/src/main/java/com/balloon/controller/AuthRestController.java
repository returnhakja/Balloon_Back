package com.balloon.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.balloon.dto.EmpRequestDTO;
import com.balloon.dto.EmpResponseDTO;
import com.balloon.dto.TokenDTO;
import com.balloon.service.AuthServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/auth", method = {RequestMethod.POST, RequestMethod.GET})
@RequiredArgsConstructor
public class AuthRestController {
    private final AuthServiceImpl authSvc;

    @PostMapping("/signup")
    public ResponseEntity<EmpResponseDTO> signup(@RequestBody EmpRequestDTO requestDto) {
    	return ResponseEntity.ok(authSvc.signup(requestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody EmpRequestDTO requestDto) {
        return ResponseEntity.ok(authSvc.login(requestDto));
    }
}