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
	public List<UnitDTO> findUnitAll(){
		List<Unit> unitList = unitRepo.findAll();
		List<UnitDTO> unitDTOList = new ArrayList<UnitDTO>();
		unitList.forEach(unitEntity -> unitDTOList.add(unitEntity.toDTO(unitEntity)));
		
		return unitDTOList;
	}

	@Transactional
	@Override
	public UnitDTO findUnitByUnitCode(String unitCode) {
		Unit unitEntity = unitRepo.findUnitByUnitCode(unitCode);
		if (unitEntity == null) {
				throw new Exception("조직 번호가 존재하지 않습니다.");
			}
		UnitDTO unitDTO = unitEntity.toDTO(unitEntity)
		return unitDTO;
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
