package com.balloon.service;

import java.util.List;

import com.balloon.dto.CalDTO;
import com.balloon.entity.Cal;
import com.balloon.entity.Employee;




public interface CalService {
	
	public List<Cal> findAll();
	
	public Cal getCalByscheduleId(Long scheduleId);
	
	public void deleteByCalId(Long scheduleId);
	
	public void insertBycal(CalDTO calDTO);
	
	public void updateByCal(CalDTO calDTO);
	
	public List<Cal> getCalByempId(Employee empId);
	
}
