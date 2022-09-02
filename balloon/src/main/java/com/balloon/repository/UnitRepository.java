package com.balloon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.balloon.entity.Unit;

@Repository
public interface UnitRepository extends JpaRepository<Unit, String> {

	public List<Unit> findUnitByUnitCodeEndsWith(String halfCode);

	public Unit findUnitByUnitCode(String unitCode);

	public void deleteUnitByUnitCode(String unitCode);

}
