package com.balloon.service;

import java.util.List;

import com.balloon.dto.EmpDTO;
import com.balloon.dto.PageRequestDTO;
import com.balloon.dto.PageResultDTO;
import com.balloon.entity.Employee;

public interface EmpService {

	public PageResultDTO<EmpDTO, Employee> findEmpList(PageRequestDTO pageRequestDTO);

	public Employee findEmpByEmpId(String empId);

	public List<Employee> findEmpListInUnitCode(String unitCode);

	public List<Employee> getEmp();

	public List<EmpDTO> findEmpListInSameUnit(String empId);

	public List<EmpDTO> findEmps();

	public void deleteByEmpId(String empId);

}
