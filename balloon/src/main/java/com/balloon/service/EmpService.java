package com.balloon.service;

import com.balloon.dto.EmpDTO;
import com.balloon.dto.PageRequestDTO;
import com.balloon.dto.PageResultDTO;
import com.balloon.entity.Employee;

public interface EmpService{

	public PageResultDTO<EmpDTO, Employee> findEmpList(PageRequestDTO pageRequestDTO);
	
	public Employee findEmpByEmpId(String empId);
}
