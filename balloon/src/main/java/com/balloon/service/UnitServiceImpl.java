package com.balloon.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.balloon.dto.UnitDTO;
import com.balloon.entity.Unit;
import com.balloon.repository.UnitRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UnitServiceImpl implements UnitService{
	
	private final UnitRepository unitRepo;
	
	@Transactional
	@Override
	public List<Unit> findUnitAll(){
		return unitRepo.findAll();
	}

	@Transactional
	@Override
	public Unit findUnitByUnitCode(String unitCode) {
		return unitRepo.findUnitByUnitCode(unitCode);
	};

	@Transactional
	@Override
	public void insertUnit(UnitDTO unitDTO) {
		Unit unitEntity = unitDTO.toEntity(unitDTO);
		
		unitRepo.save(unitEntity);
	};
	
	@Transactional
	@Override
	public void updateUnit(UnitDTO unitDTO) {
		/* 부서의 모든 정보를 수정할 때 */
		Unit unitEntity = unitDTO.toEntity(unitDTO);
		
//		/* 부서 정보의 일부분만 수정할 때 */
//		Unit unit = findUnitByUnitCode(unitDTO.getUnitCode());
//		/* 부서전화번호만 수정할 때 */
//		unit.updateBell(unitDTO);
//		/* 부서전화번호와 부서명만 수정할 때 */
//		unit.updateUnitNameAndBell(unitDTO);
		
		unitRepo.save(unitEntity);
	};
	
	@Transactional
	@Override
	public void deleteUnitByUnitCode(String unitCode) {
		unitRepo.deleteUnitByUnitCode(unitCode);
	};

	
}
