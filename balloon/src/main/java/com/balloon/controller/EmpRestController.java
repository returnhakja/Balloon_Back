package com.balloon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.balloon.entity.Cal;
import com.balloon.service.CalServiceImpl;

@RestController
public class EmpRestController {
	@Autowired
	CalServiceImpl calService;
	
	@GetMapping("/")
	public String home() {
		return "되긴하네";
	}
	

	@CrossOrigin(origins = {"http://localhost:3000", "https://localhost:4000"})
	@GetMapping(value = "/calall")
	public List<Cal> findAll(){
		System.out.println("--ㄴ-ㅁㄴㅇ-ㅁㄴㅇ-ㅁㄴㅇ-ㅁㄴㅇ-ㄴ");
		return calService.findAll();
	}
	
//	@CrossOrigin(origins = {"http://localhost:3000", "https://localhost:4000"})
//	@GetMapping(value = "/calall/{scheduleId}")
//	public Cal CalByScheduleId(@PathVariable Long scheduleid) {
//		System.out.println("스케쥬우우울");
//		return calService.getCalByscheduleId(scheduleid);
//	}
	
}
