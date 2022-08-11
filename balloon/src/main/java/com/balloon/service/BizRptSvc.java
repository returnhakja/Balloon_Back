package com.balloon.service;

import java.util.List;

import com.balloon.dto.BizRptDTO;
import com.balloon.vo.DocVO;

public interface BizRptSvc {
	public void insertBizRpt(BizRptDTO bizRptDTO);

//	public PageResultDTO<BizRptDTO, BusinessReport> getList(PageRequestDTO pageRequestDTO);

	public List<DocVO> getDoc(String empId);

	public BizRptDTO getBizRptByBizRptId(String businessReportId);

	public void deleteBizRptByBizRptId(String businessReportId);

}
