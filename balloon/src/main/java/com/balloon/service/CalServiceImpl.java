package com.balloon.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balloon.dto.CalDTO;
import com.balloon.entity.Cal;
import com.balloon.repository.CalRepository;

@Service
public class CalServiceImpl implements CalService{
	@Autowired
	private CalRepository CalRepository;


	
	@Override
	public List<Cal> findAll() {
		return CalRepository.findAll();
	}



	@Override
	public Cal getCalByscheduleId(Long scheduleId) {
		
		return CalRepository.findAllByscheduleId(scheduleId);
	}



	@Override
	public void deleteByCalId(Long scheduleId) {
		CalRepository.deleteById(scheduleId);
	}



	@Override
	public void insertBycal(CalDTO calDTO) {
		Cal calEntity = calDTO.toEntity(calDTO);
		CalRepository.save(calEntity);
	}



	@Override
	public void updateByCal(CalDTO calDTO) {
		Cal cal = getCalByscheduleId(calDTO.getScheduleId());
		cal.updateCal(calDTO);
		CalRepository.save(cal);
	}



	@Override
	public List<Cal> getCalByempId(String empId) {
		return CalRepository.findAllByempId(empId);
		
	}
	
	


	
	
}
