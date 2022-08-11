package com.balloon.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.balloon.dto.PADTO;
import com.balloon.entity.PersonnelAppointment;
import com.balloon.repository.PARepository;
import com.balloon.vo.DocVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PASvcImpl implements PASvc {
	private final PARepository PARepo;

	@Override
	public void insertPA(PADTO paDTO) {
		PersonnelAppointment PAEntity = paDTO.toEntity(paDTO);
		PARepo.save(PAEntity);
	}

	@Override
	public List<DocVO> getDoc(String empId) {
		String id = empId; // 테스트용
		List<DocVO> voList = new ArrayList<DocVO>();
		List<PersonnelAppointment> personnelAppointmentList = PARepo
				.findPersonnelAppointmentIdAndDocumentTitleAndUpdateDateByEmpEmpId(id);
		for (PersonnelAppointment personnelAppointment : personnelAppointmentList) {
			voList.add(personnelAppointment.toVO(personnelAppointment));
		}
		return voList;
	}

	@Override
	public PADTO getPAByPAId(String PAId) {
		PersonnelAppointment personnelAppointment = PARepo.findPersonnelAppointmentByPersonnelAppointmentId(PAId);
		PADTO paDTO = personnelAppointment.toDTO(personnelAppointment);
		return paDTO;
	}

	@Override
	public void deletePAByPAId(String PAId) {
		PARepo.deleteById(PAId);
	}

}
