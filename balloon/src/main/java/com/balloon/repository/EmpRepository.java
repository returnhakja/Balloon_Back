package com.balloon.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.balloon.dto.EmpResponseDTO;
import com.balloon.entity.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, String>{
	
	public Employee findEmpByEmpId(String empId);
	
	Optional<Employee> findByEmpId(String empId);
	EmpResponseDTO getByEmpId(String empId);
	boolean existsEmpByEmpId(String empId);
}
