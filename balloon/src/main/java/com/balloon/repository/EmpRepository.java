package com.balloon.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.balloon.dto.EmpResponseDTO;
import com.balloon.entity.Employee;


@Repository
public interface EmpRepository extends JpaRepository<Employee, String>{
	
	public Employee findEmpByEmpId(String empId);
	
	@Query(value = "SELECT *  " + 
					"FROM employee e " + 
					"WHERE unit_code " + 
					"IN ( SELECT u.unit_code " + 
					"	  FROM unit u" + 
					"     WHERE u.parent_unit = :unitCode);", nativeQuery = true)
	public List<Employee> findEmpListInUnitCode(@Param("unitCode") String uniCode);
	
	Optional<Employee> findByEmpId(String empId);
	EmpResponseDTO getByEmpId(String empId);
	boolean existsEmpByEmpId(String empId);
	
	public List<Employee> findAll();
	
	
}
