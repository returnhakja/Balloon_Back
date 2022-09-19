package com.balloon.api;

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

import com.balloon.dto.BizTpDTO;
import com.balloon.service.BizTpSvcImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BizTpRestController {

	private final BizTpSvcImpl BizTpSvc;

	// CREATE -------------------------------
	@PostMapping(value = "/biztp", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertBizTP(@RequestBody BizTpDTO bizTpDTO) {
		BizTpSvc.insertBizTp(bizTpDTO);
	}

	// READ ---------------------------------
	@GetMapping(value = "/biztp/{bizTpId}")
	public BizTpDTO getBizTpByBizTpId(@PathVariable("bizTpId") String bizTpId) {
		return BizTpSvc.getBizTpByBizTpId(bizTpId);
	}

	@GetMapping(value = "/biztp/wd")
	public BizTpDTO getLatestBizTp() {
		return BizTpSvc.getBizTpWD();
	}

	// UPDATE -------------------------------
	@PutMapping(value = "/biztp/{bizTpId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateBizTpByBizTpId(@PathVariable("bizTpId") String bizTpId, @RequestBody BizTpDTO bizTpDTO) {
		bizTpDTO.setBusinessTripId(bizTpId);
		BizTpSvc.insertBizTp(bizTpDTO);
	}

	// DELETE -------------------------------
	@CrossOrigin(origins = { "http://localhost:3000" })
	@DeleteMapping(value = "/biztp/{bizTpId}")
	public void deleteBizTpByBizTpId(@PathVariable("bizTpId") String bizTpId) {
		BizTpSvc.deleteBizTpByBizTpId(bizTpId);
	}

}
