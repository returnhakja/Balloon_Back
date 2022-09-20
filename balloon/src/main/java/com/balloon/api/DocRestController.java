package com.balloon.api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.balloon.service.BizRptSvcImpl;
import com.balloon.service.BizTpSvcImpl;
import com.balloon.service.PASvcImpl;
import com.balloon.vo.DocDateVO;
import com.balloon.vo.DocVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/box")
@RequiredArgsConstructor
public class DocRestController {

	private final BizRptSvcImpl BizRptSvc;
	private final BizTpSvcImpl BizTpSvc;
	private final PASvcImpl PASvc;

	@GetMapping(value = { "/empdocs/{empId}/{docStatus}" })
	public List<DocVO> getDocbyEmpId(@PathVariable("empId") String empId, @PathVariable("docStatus") Byte docStatus) {
		System.out.println(empId);
		System.out.println(docStatus);
		List<DocVO> list = new ArrayList<DocVO>();
		list.addAll(BizRptSvc.getDocbyEmpIdAndDocStatus(empId, docStatus));
		list.addAll(BizTpSvc.getDocbyEmpIdAndDocStatus(empId, docStatus));
		list.addAll(PASvc.getDocbyEmpIdAndDocStatus(empId, docStatus));

//		System.out.println(list); -> stackoverflow
		return list;
	}

	@PostMapping(value = "/empdocs/date/{empId}/{docStatus}")
	public List<DocVO> getDocbyEmpIdByDate(@PathVariable("empId") String empId,
			@PathVariable("docStatus") Byte docStatus, @RequestBody DocDateVO docDateVO) {
		System.out.println("aaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbba");
		System.out.println(docDateVO);

		LocalDateTime sunDay = LocalDateTime.parse(docDateVO.getSunDay() + " 00:00:00",
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		LocalDateTime saturDay = LocalDateTime.parse(docDateVO.getSunDay() + " 00:00:00",
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		List<DocVO> list = new ArrayList<DocVO>();
		list.addAll(BizRptSvc.getDocbyEmpIdAndDocStatusByDate(empId, docStatus, sunDay, saturDay));
		list.addAll(BizTpSvc.getDocbyEmpIdAndDocStatusByDate(empId, docStatus, sunDay, saturDay));
		list.addAll(PASvc.getDocbyEmpIdAndDocStatusByDate(empId, docStatus, sunDay, saturDay));

		return list;
//		return null;
	}

	@GetMapping(value = "/unitdocs/{unitCode}")
	public List<DocVO> getDocbyUnitCode(@PathVariable("unitCode") String unitCode) {
		List<DocVO> list = new ArrayList<DocVO>();
		list.addAll(BizRptSvc.getDocbyUnitCode(unitCode));
		list.addAll(BizTpSvc.getDocbyUnitCode(unitCode));
		list.addAll(PASvc.getDocbyUnitCode(unitCode));

		return list;
	}

//	@GetMapping(value = "/apvldocs/{empName}")
//	public List<DocVO> getDocByApvrName(@PathVariable("empName") String empName) {
//		List<DocVO> list = new ArrayList<DocVO>();
//		list.addAll(BizRptSvc.getDocByEmpName(empName));
//		list.addAll(BizTpSvc.getDocByEmpName(empName));
//		list.addAll(PASvc.getDocByEmpName(empName));
//		return list;
//	}

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
