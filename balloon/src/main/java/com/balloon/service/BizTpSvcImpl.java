package com.balloon.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.balloon.dto.BizTpDTO;
import com.balloon.entity.BusinessTripPlan;
import com.balloon.repository.BizTpRepository;
import com.balloon.vo.DocVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BizTpSvcImpl implements BizTpSvc {
	private final BizTpRepository bizTpRepo;

	@Override
	public void insertBizTp(BizTpDTO bizTpDTO) {
		BusinessTripPlan bizTpEntity = bizTpDTO.toEntity(bizTpDTO);
		bizTpRepo.save(bizTpEntity);
	}

	public List<DocVO> getDoc() {
		String id = "A0000006"; // 테스트용
		List<DocVO> voList = new ArrayList<DocVO>();
		List<BusinessTripPlan> businessTripPlanList = bizTpRepo
				.findBusinessTripIdAndDocumentTitleAndUpdateDateByEmpEmpId(id);
		for (BusinessTripPlan businessTripPlan : businessTripPlanList) {
			voList.add(businessTripPlan.toVO(businessTripPlan));
		}
		return voList;
	}

}
