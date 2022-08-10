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

//	@Override
//	public PageResultDTO<BizRptDTO, BusinessReport> getList(PageRequestDTO pageRequestDTO) {
//		Pageable pageable = pageRequestDTO.getPageable(Sort.by("businessReportId").descending());
//
//		Page<BusinessReport> result = bizRptRepo.findAll(pageable);
//
//		Function<BusinessReport, BizRptDTO> function = (businessReport -> businessReport.toDTO(businessReport));
//
//		return new PageResultDTO<BizRptDTO, BusinessReport>(result, function);
//	}

	@Override
	public List<DocVO> getDoc(String empId) {
		String id = empId;
		List<DocVO> voList = new ArrayList<DocVO>();
		List<BusinessReport> businessReportsList = bizRptRepo
				.findBusinessReportIdAndDocumentTitleAndUpdateDateByEmpEmpId(id);
		for (BusinessReport businessReport : businessReportsList) {
			System.out.println(businessReport.getDocumentTitle());
			System.out.println(businessReport.getUpdateDate());
			System.out.println(businessReport.getBusinessReportId());
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
	public void deleteBizRptByBizRptId(String bizRptId) {
		bizRptRepo.deleteById(bizRptId);
	}

}
