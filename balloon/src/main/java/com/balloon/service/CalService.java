package com.balloon.service;

import java.util.List;

import com.balloon.dto.CalDTO;

public interface CalService {

	public List<CalDTO> findAll();

	public CalDTO getCalByscheduleId(Long scheduleId);

	public void deleteByCalId(Long scheduleId);

	public void insertBycal(CalDTO calDTO);

	public void updateByCal(CalDTO requestDTO) throws Exception;

	public List<CalDTO> getCalByempId(String empId);

	public void scheduleListAdd(List<CalDTO> calDTOs);

}
