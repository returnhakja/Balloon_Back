package com.balloon.service;

import java.util.List;

import com.balloon.dto.UnitDTO;

public interface UnitService {
	public List<UnitDTO> findUnitAll();

	public UnitDTO findUnitByUnitCode(String unitCode) throws Exception;

	public List<UnitDTO> findByHigherOrganization();

	public String findMaxUnitCodeByParentUnit(String parentUnit);

	public void insertUnit(UnitDTO unitDTO) throws Exception;

	public boolean insertUnitList(List<UnitDTO> requestDtoList);

	public void updateUnit(UnitDTO unitDTO) throws Exception;

	public void deleteUnitByUnitCode(String unitCode);

}
