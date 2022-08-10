package com.balloon.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.balloon.service.BizRptSvcImpl;
import com.balloon.service.BizTpSvcImpl;
import com.balloon.service.PASvcImpl;
import com.balloon.vo.DocVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/box")
@RequiredArgsConstructor
public class DocRestController {

	private final BizRptSvcImpl BizRptSvc;
	private final BizTpSvcImpl BizTpSvc;
	private final PASvcImpl PASvc;

	// READ -------------------------------
//	@GetMapping(value = "/dd")
//	public PageResultDTO<BizRptDTO, BusinessReport> getAlldd(PageRequestDTO pageRequestDTO) {
//		PageResultDTO<BizRptDTO, BusinessReport> pageResultDTO = BizRptSvc.getList(pageRequestDTO);
//		return pageResultDTO;
//	}

	@GetMapping(value = "/docs/{empId}")
	public List<DocVO> getDocbyEmpId(@PathVariable("empId") String empId) {
		System.out.println(empId);
		List<DocVO> list = new ArrayList<DocVO>();
		list.addAll(BizRptSvc.getDoc(empId));
		list.addAll(BizTpSvc.getDoc(empId));
		list.addAll(PASvc.getDoc(empId));

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
