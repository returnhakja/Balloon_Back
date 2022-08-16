package com.balloon.dto;

import java.time.LocalDate;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.balloon.entity.UserRole;
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
	
	private String responsibility;
	
	private Float salary;
	
	private Float commission;
	
	private LocalDate hiredate;
	
	private String empBell;

	private String empMail;
	
	private String mobile;
	
	private String photo;
	
	private LocalDate birthday;
	
	private String address;
	
	private String licensePlate;
	
	private Unit unit;
	
	private UserRole userRoleGrade;

	
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
				.position(position)
				.responsibility(responsibility)
				.salary(salary)
				.commission(commission)
				.hiredate(hiredate)
				.unit(unit)
				.empBell(empBell)
				.empMail(empMail)
				.mobile(mobile)
				.userRoleGrade(userRoleGrade)
				.birthday(birthday)
				.address(address)
				.licensePlate(licensePlate)
				.photo(photo)
				.build();
	}
	
	public UsernamePasswordAuthenticationToken toAuthentication() {
		return new UsernamePasswordAuthenticationToken(empId, password);
	}
	
	
}
