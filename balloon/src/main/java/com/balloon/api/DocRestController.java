package com.balloon.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.balloon.dto.BizRptDTO;
import com.balloon.dto.BizTpDTO;
import com.balloon.dto.PADTO;
import com.balloon.dto.PageRequestDTO;
import com.balloon.dto.PageResultDTO;
import com.balloon.entity.BusinessReport;
import com.balloon.service.BizRptSvcImpl;
import com.balloon.service.BizTpSvcImpl;
import com.balloon.service.PASvcImpl;
import com.balloon.vo.DocVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/box")
@RequiredArgsConstructor
public class DocRestController {

	private final BizRptSvcImpl BizRptSvc;
	private final BizTpSvcImpl BizTpSvc;
	private final PASvcImpl PASvc;

	// CREATE -------------------------------

	@PostMapping(value = "/uu", produces = MediaType.APPLICATION_JSON_VALUE)
	public void insertBizRpt(@RequestBody BizRptDTO bizRptDTO) {
		bizRptDTO.setBusinessReportId(bizRptDTO.getBusinessReportId());
		bizRptDTO.setDocumentTitle(bizRptDTO.getDocumentTitle());
		bizRptDTO.setDocumentContent(bizRptDTO.getDocumentContent());
		bizRptDTO.setDocumentStatus((byte) 1);
		bizRptDTO.setEmpName(bizRptDTO.getEmpName());
		bizRptDTO.setPosition(bizRptDTO.getPosition());
		bizRptDTO.setUnitName(bizRptDTO.getUnitName());
		bizRptDTO.setUnit(bizRptDTO.getUnit());
		bizRptDTO.setEmp(bizRptDTO.getEmp());
//		bizRptDTO.setUnitCode(bizRptDTO.getUnitCode());
//		bizRptDTO.setEmpId(bizRptDTO.getEmpId());

		BizRptSvc.insertBizRpt(bizRptDTO);
	}

	@PostMapping(value = "/zz", produces = MediaType.APPLICATION_JSON_VALUE)
	public void insertBizTP(@RequestBody BizTpDTO bizTpDTO) {
		bizTpDTO.setBusinessTripId(bizTpDTO.getBusinessTripId());
		bizTpDTO.setDocumentTitle(bizTpDTO.getDocumentTitle());
		bizTpDTO.setDocumentContent(bizTpDTO.getDocumentContent());
		bizTpDTO.setDocumentStatus((byte) 1);
		bizTpDTO.setStartDate(bizTpDTO.getStartDate());
		bizTpDTO.setEndDate(bizTpDTO.getEndDate());
		bizTpDTO.setDestination(bizTpDTO.getDestination());
		bizTpDTO.setVisitingPurpose(bizTpDTO.getVisitingPurpose());
		bizTpDTO.setEmpName(bizTpDTO.getEmpName());
		bizTpDTO.setPosition(bizTpDTO.getPosition());
		bizTpDTO.setUnitName(bizTpDTO.getUnitName());
		bizTpDTO.setUnit(bizTpDTO.getUnit());
		bizTpDTO.setEmp(bizTpDTO.getEmp());

		BizTpSvc.insertBizTp(bizTpDTO);
	}

	@PostMapping(value = "/ee", produces = MediaType.APPLICATION_JSON_VALUE)
	public void insertPA(@RequestBody PADTO paDTO) {
		paDTO.setPersonnelAppointmentId(paDTO.getPersonnelAppointmentId());
		paDTO.setDocumentTitle(paDTO.getDocumentTitle());
		paDTO.setDocumentContent(paDTO.getDocumentContent());
		paDTO.setDocumentStatus((byte) 1);
		paDTO.setPersonnelDate(paDTO.getPersonnelDate());
		paDTO.setPosition(paDTO.getPosition());
		paDTO.setUnitName(paDTO.getUnitName());
		paDTO.setMovedEmpName(paDTO.getMovedEmpName());
		paDTO.setEmpName(paDTO.getEmpName());
		paDTO.setMovedEmpId(paDTO.getMovedEmpId());
		paDTO.setEmp(paDTO.getEmp());
		paDTO.setUnit(paDTO.getUnit());

		PASvc.insertPA(paDTO);
	}

	// READ -------------------------------
	@GetMapping(value = "/dd")
	public PageResultDTO<BizRptDTO, BusinessReport> getAlldd(PageRequestDTO pageRequestDTO) {
		PageResultDTO<BizRptDTO, BusinessReport> pageResultDTO = BizRptSvc.getList(pageRequestDTO);
		return pageResultDTO;
	}

	@GetMapping(value = "/dddd")
	public List<DocVO> getAlldddd() {
		List<DocVO> list = new ArrayList<DocVO>();
		list.addAll(BizRptSvc.getDoc());
		list.addAll(BizTpSvc.getDoc());
		list.addAll(PASvc.getDoc());

		return list;
	}

	// UPDATE -------------------------------

	// DELETE -------------------------------

//	// CREATE -------------------------------
//	// READ   -------------------------------
////	@GetMapping(value = "/dd")
////	public PageResultDTO<DTO, EN> getAlldd(PageRequestDTO pageRequestDTO) {
////		PageResultDTO<DTO, EN> pageResultDTO = Svc.getList(pageRequestDTO);
////		return pageResultDTO;
////	}
//	
//	@GetMapping(value = "/dc")
//	@GetMapping(value = "/ds")
//	@GetMapping(value = "/dr")
//	@GetMapping(value = "/dd/{doc_id}")
//	@GetMapping(value = "/dc/{doc_id}")
//	@GetMapping(value = "/ds/{doc_id}")
//	@GetMapping(value = "/dr/{doc_id}")
//	
//	// UPDATE -------------------------------
//	@PutMapping(value = "/dd/{doc_id}")
//	@PutMapping(value = "/ds/{doc_id}")
//	@PutMapping(value = "/dr/{doc_id}")
//	
//	// DELETE -------------------------------
//	@DeleteMapping(value = "/dd/{doc_id}")
//	@DeleteMapping(value = "/ds/{doc_id}")
//	@DeleteMapping(value = "/dr/{doc_id}")

}
