package com.balloon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.balloon.entity.BusinessReport;

@Repository
public interface BizRptRepository extends JpaRepository<BusinessReport, String> {

	public BusinessReport findBusinessReportByBusinessReportId(String businessReportId);

//	public List<BusinessReport> findAllByEmpEmpId(String empId);

	public List<BusinessReport> findBusinessReportIdAndDocumentTitleAndUpdateDateByEmpEmpId(String empId);

//	public BusinessReport findBusinessReportByEmpId(String empId);

}
