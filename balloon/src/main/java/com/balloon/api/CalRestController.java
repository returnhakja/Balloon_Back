package com.balloon.api;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.balloon.dto.CalDTO;
import com.balloon.entity.Cal;

import com.balloon.entity.Employee;

import com.balloon.service.CalServiceImpl;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4000"})
public class CalRestController {
	@Autowired
	private final CalServiceImpl calService;
	//캘린더
	
		@GetMapping(value = "/cal/list")

		public List<Cal> findAll(){
			System.out.println("--ㄴ-ㅁㄴㅇ-ㅁㄴㅇ-ㅁㄴㅇ-ㅁㄴㅇ-ㄴ");

			return calService.findAll();
		}
		

		@GetMapping(value = "/cal/all/{scheduleId}")

		public Cal CalByScheduleId(@PathVariable(name = "scheduleId") Long scheduleid) {
			System.out.println("스케쥬우우울");
			return calService.getCalByscheduleId(scheduleid);
		}
		
		@DeleteMapping(value = "/cal/delete/{scheduleId}")
		public void scheduleIdDelete(@PathVariable(name = "scheduleId") Long scheduleid) {
			calService.deleteByCalId(scheduleid);
		}
		
		@PostMapping(value = "/cal/insert",  consumes = { MediaType.APPLICATION_JSON_VALUE })
		public void CalByInsert(@Valid @RequestBody CalDTO calDTO) {
			
			calService.insertBycal(calDTO);
		}
		
		@PutMapping(value = "/cal/update", consumes = { MediaType.APPLICATION_JSON_VALUE })
		public void updateCalByscheduleId(@RequestBody CalDTO calDTO) {
			calService.updateByCal(calDTO);
		}
		
		@GetMapping(value = "/cal/{empId}")

		public List<Cal> CalByScheduleId(@PathVariable(name = "empId") Employee empId) {
			System.out.println("이엠피아이디");

			return calService.getCalByempId(empId);
		}
}
