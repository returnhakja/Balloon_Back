package com.balloon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.balloon.entity.Unit;

@Repository
public interface UnitRepository extends JpaRepository<Unit, String> {

	public List<Unit> findUnitByUnitCodeEndsWith(String halfCode);

	public Unit findUnitByUnitCode(String unitCode);

//	public String findUnitCodeByParentUnitParentUnitOrderByUnitCodeDesc(String parentUnit);
	@Query(value = "SELECT MAX(unit_code) FROM unit WHERE parent_unit = :parentUnit ; ", nativeQuery = true)
	public String findTopUnitCodeByParentUnitOrderByUnitCodeDesc(String parentUnit);

	public void deleteUnitByUnitCode(String unitCode);

}
