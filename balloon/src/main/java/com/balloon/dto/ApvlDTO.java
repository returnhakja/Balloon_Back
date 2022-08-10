package com.balloon.dto;

import java.time.LocalDateTime;

import com.balloon.entity.ApprovalList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

public class ApvlDTO {
	private Integer approvalId;

	private Byte approvalStatus;

	private String approvalContent;

	private String approverName;

	private String position;

	private String drafterName;

	private LocalDateTime processDate;

	private String empId;

	private String businessReportId;

	private String businessTripId;

	private String personnelAppointmentId;

	public ApprovalList toEntity(ApvlDTO apvlDTO) {
		ApprovalList approvalList = ApprovalList.builder().approvalId(apvlDTO.getApprovalId())
				.approvalStatus(apvlDTO.getApprovalStatus()).approvalContent(apvlDTO.getApprovalContent())
				.approverName(apvlDTO.getApproverName()).position(apvlDTO.getPosition())
				.drafterName(apvlDTO.getDrafterName()).processDate(apvlDTO.getProcessDate()).empId(apvlDTO.getEmpId())
				.businessReportId(apvlDTO.getBusinessReportId()).businessTripId(apvlDTO.getBusinessTripId())
				.personnelAppointmentId(apvlDTO.getPersonnelAppointmentId()).build();
		return approvalList;
	}

}
