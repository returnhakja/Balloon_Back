package com.balloon.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.balloon.entity.Authority;
import com.balloon.entity.Employee;
import com.balloon.entity.Unit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmpRequestDTO {
	
	private String empId;
	
	private String password;	
	
	private String empName;

	private String position;
	
	private String mobile;
	
	private LocalDate hiredate;
	
	private Float salary;
	
	private Float commission;
	
	private String empMail;
	
	private String photo;
	
	private String empBell;
	
	private LocalDate birthday;
	
	private String address;
	
	private String licensePlate;
	
	private String responsibility;
	
	private Unit unit;
	
	private Authority userRoleGrade;

	
	public Employee toEntity(EmpRequestDTO employeeDTO) {
		Employee employeeEntity = Employee.builder()
									.empId(employeeDTO.getEmpId())
									.password(employeeDTO.getPassword())
									.empName(employeeDTO.getEmpName())
									.build();
		
		return employeeEntity;
	}
	
	public Employee toEmployee(PasswordEncoder passwordEncoder) {
		return Employee.builder()
				.empId(empId)
				.password(passwordEncoder.encode(password))
				.empName(empName)
				.salary(salary)
				.commission(commission)
				.unit(unit)
				.empBell(empBell)
				.position(position)
				.responsibility(responsibility)
				.mobile(mobile)
				.empMail(empMail)
				.hiredate(hiredate)
				.userRoleGrade(userRoleGrade)
				.build();
	}
	
	public UsernamePasswordAuthenticationToken toAuthentication() {
		System.out.println(empId);
		System.out.println(password);
		return new UsernamePasswordAuthenticationToken(empId, password);
	}
	
	
}
