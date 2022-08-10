package com.balloon.service;

import com.balloon.dto.BizRptDTO;
import com.balloon.dto.PageRequestDTO;
import com.balloon.dto.PageResultDTO;
import com.balloon.entity.BusinessReport;

public interface BizRptSvc {
	public void insertBizRpt(BizRptDTO bizRptDTO);

	public PageResultDTO<BizRptDTO, BusinessReport> getList(PageRequestDTO pageRequestDTO);
}
