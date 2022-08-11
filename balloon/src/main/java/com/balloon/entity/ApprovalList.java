package com.balloon.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.balloon.dto.ApvlDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "approval_list")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EntityListeners(AuditingEntityListener.class)
public class ApprovalList {

	@Id
	@Column(name = "approval_id")
	private Integer approvalId;

	@NotNull
	@Column(name = "approval_status", length = 1)
	private Byte approvalStatus;

	@Column(name = "approval_content", length = 200)
	private String approvalContent;

	@NotNull
	@Column(name = "approver_name", length = 30)
	private String approverName;

	@NotNull
	@Column(name = "position", length = 20)
	private String position;

	@NotNull
	@Column(name = "drafter_name", length = 30)
	private String drafterName;

	@Column(name = "process_date")
	private LocalDateTime processDate;

	@JsonIgnore
	@ManyToOne(targetEntity = Employee.class)
	@NotNull
	@JoinColumn(name = "emp_id")
	private String empId;

	@JsonIgnore
	@ManyToOne(targetEntity = BusinessReport.class)
	@JoinColumn(name = "business_report_id")
	private String businessReportId;

	@JsonIgnore
	@ManyToOne(targetEntity = BusinessTripPlan.class)
	@JoinColumn(name = "business_trip_id")
	private String businessTripId;

	@JsonIgnore
	@ManyToOne(targetEntity = PersonnelAppointment.class)
	@JoinColumn(name = "personnel_appointment_id")
	private String personnelAppointmentId;

	public ApvlDTO toDTO(ApprovalList approvalList) {
		ApvlDTO apvlDTO = ApvlDTO.builder().approvalId(approvalList.getApprovalId())
				.approvalStatus(approvalList.getApprovalStatus()).approvalContent(approvalList.getApprovalContent())
				.approverName(approvalList.getApproverName()).position(approvalList.getPosition())
				.drafterName(approvalList.getDrafterName()).processDate(approvalList.getProcessDate())
				.empId(approvalList.getEmpId()).businessReportId(approvalList.getBusinessReportId())
				.businessTripId(approvalList.getBusinessTripId())
				.personnelAppointmentId(approvalList.getPersonnelAppointmentId()).build();
		return apvlDTO;
	}

}
