package com.balloon.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.balloon.service.BizRptSvcImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BizRptRestController {
	private final BizRptSvcImpl BizRptSvc;
	// CREATE -------------------------------
	// READ   -------------------------------
	// UPDATE -------------------------------
	// DELETE -------------------------------
}
