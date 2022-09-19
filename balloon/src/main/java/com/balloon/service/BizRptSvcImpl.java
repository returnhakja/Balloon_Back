package com.balloon.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.balloon.dto.BizRptDTO;
import com.balloon.entity.BusinessReport;
import com.balloon.repository.BizRptRepository;
import com.balloon.vo.DocVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class BizRptSvcImpl implements BizRptSvc {
	private final BizRptRepository bizRptRepo;

	@Override
	public void insertBizRpt(BizRptDTO bizRptDTO) {
		BusinessReport bizRptEntity = bizRptDTO.toEntity(bizRptDTO);
		bizRptRepo.save(bizRptEntity);
	}

	@Override
	public List<DocVO> getDocbyEmpIdAndDocStatus(String empId, Byte docStatus) {
		String id = empId;
		Byte status = docStatus;
		List<DocVO> voList = new ArrayList<DocVO>();
		List<BusinessReport> businessReportsList = bizRptRepo
				.findBusinessReportIdAndDocumentTitleAndUpdateDateByEmpEmpIdAndDocumentStatus(id, status);
		for (BusinessReport businessReport : businessReportsList) {
			voList.add(businessReport.toVO(businessReport));
		}
		return voList;
	}

	@Override
	public List<DocVO> getDocbyUnitCode(String unitCode) {
		String code = unitCode.substring(0, 4);
		Byte status = 2;
		List<DocVO> voList = new ArrayList<DocVO>();
		List<BusinessReport> businessReportsList = bizRptRepo
				.findBusinessReportIdAndDocumentTitleAndUpdateDateByUnitUnitCodeStartingWithAndDocumentStatus(code,
						status);
		for (BusinessReport businessReport : businessReportsList) {
			voList.add(businessReport.toVO(businessReport));
		}
		return voList;
	}

	@Override
	public BizRptDTO getBizRptByBizRptId(String bizRptId) {
		BusinessReport businessReport = bizRptRepo.findBusinessReportByBusinessReportId(bizRptId);
		BizRptDTO bizRptDTO = businessReport.toDTO(businessReport);
		return bizRptDTO;
	}

	@Override
	public BizRptDTO getBizRptWD() {
		if (bizRptRepo.findTopByOrderByWriteDateDesc() != null) {
			BusinessReport businessReport = bizRptRepo.findTopByOrderByWriteDateDesc();
			BizRptDTO bizRptDTO = businessReport.toDTO(businessReport);
			return bizRptDTO;
		} else {
			return null;
		}
	}

	@Override
	public void deleteBizRptByBizRptId(String bizRptId) {
		bizRptRepo.deleteById(bizRptId);
	}

}
