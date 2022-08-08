package com.balloon.api;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

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

//    @GetMapping("/loginPage")
//    public String loginPage() {
//    	return "loginPage.html";
//    }
//    
//    @GetMapping("/accesDenied")
//    public String accesDeniedPage() {
//    	return "access Deny. but why?";
//    }
    
    
    @PostMapping("/signup")
    public ResponseEntity<EmpResponseDTO> signup(@Valid @RequestBody EmpRequestDTO requestDto) {
    	return ResponseEntity.ok(authSvc.signup(requestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@Valid @RequestBody EmpRequestDTO requestDto, HttpServletResponse response) throws Exception {
    	TokenDTO tokenDTO = authSvc.login(requestDto);
    	
    	if(tokenDTO != null) {
    		// 로그인 완료 후 토큰을 cookie에 넣어주기
    		Cookie createCookie = new Cookie("accessToken", tokenDTO.getAccessToken());
    		
    		createCookie.setMaxAge(5 * 60 *60); 	// 시간 분 초 
    		createCookie.setPath("/");
    		response.addCookie(createCookie);
    		
//    		return 
    	} else {
    		throw new Exception("토큰 생성 에러입니다.");
    	}
    	
    	
    	return ResponseEntity.ok(tokenDTO);
    }
}