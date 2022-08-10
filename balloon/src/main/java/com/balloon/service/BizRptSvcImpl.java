package com.balloon.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.balloon.dto.BizRptDTO;
import com.balloon.dto.PageRequestDTO;
import com.balloon.dto.PageResultDTO;
import com.balloon.entity.BusinessReport;
import com.balloon.repository.BizRptRepository;
import com.balloon.vo.DocVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BizRptSvcImpl implements BizRptSvc {
	private final BizRptRepository bizRptRepo;

	@Override
	public void insertBizRpt(BizRptDTO bizRptDTO) {
		BusinessReport bizRptEntity = bizRptDTO.toEntity(bizRptDTO);
		bizRptRepo.save(bizRptEntity);
	}

	@Override
	public PageResultDTO<BizRptDTO, BusinessReport> getList(PageRequestDTO pageRequestDTO) {
		Pageable pageable = pageRequestDTO.getPageable(Sort.by("businessReportId").descending());

		Page<BusinessReport> result = bizRptRepo.findAll(pageable);

		Function<BusinessReport, BizRptDTO> function = (businessReport -> businessReport.toDTO(businessReport));

		return new PageResultDTO<BizRptDTO, BusinessReport>(result, function);
	}

	public List<DocVO> getDoc() {
//		SecurityUtil.getCurrentEmpId();
		String id = "A0000006"; // 테스트용
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

}
