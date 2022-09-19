package com.balloon.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.balloon.entity.BusinessReport;

@Repository
public interface BizRptRepository
		extends JpaRepository<BusinessReport, String>, JpaSpecificationExecutor<BusinessReport> {

	public BusinessReport findBusinessReportByBusinessReportId(String businessReportId);

	public List<BusinessReport> findBusinessReportIdAndDocumentTitleAndUpdateDateByEmpEmpIdAndDocumentStatus(
			String empId, Byte documentStatus);

	public List<BusinessReport> findBusinessReportIdAndDocumentTitleAndUpdateDateByEmpEmpIdAndDocumentStatusAndWriteDateBetween(
			String empId, Byte documentStatus, LocalDateTime sunDay, LocalDateTime saturDay);

	public List<BusinessReport> findBusinessReportIdAndDocumentTitleAndUpdateDateByUnitUnitCodeStartingWithAndDocumentStatus(
			String unitCode, Byte documentStatus);

	public BusinessReport findTopByOrderByWriteDateDesc();

}
