package com.balloon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.balloon.dto.CalDTO;
import com.balloon.entity.Cal;



@Repository
public interface CalRepository extends JpaRepository<Cal, Long>{

		public List<Cal> findAll();
	
//		public Cal findAllByscheduleId(Long scheduleId);
		
}
