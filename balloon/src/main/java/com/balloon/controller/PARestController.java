package com.balloon.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.balloon.service.PASvcImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PARestController {
	private final PASvcImpl PASvc;
	
	// CREATE -------------------------------
	// READ   -------------------------------
	// UPDATE -------------------------------
	// DELETE -------------------------------
}
