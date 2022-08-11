package com.balloon.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.balloon.dto.ApvlDTO;
import com.balloon.service.ApvlSvcImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ApvlRestController {
	private final ApvlSvcImpl ApvlSvc;
	
	// CREATE -------------------------------
	@PostMapping(value = "/apvl")
	public void insertApvl(@RequestBody ApvlDTO apvlDTO) {
		ApvlSvc.insertApvl(apvlDTO);
	}
	
	// READ   -------------------------------
	
	
	// UPDATE -------------------------------
	
	// DELETE -------------------------------
	
}
