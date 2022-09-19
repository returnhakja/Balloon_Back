package com.balloon.service;

import java.time.LocalDateTime;
import java.util.List;

import com.balloon.dto.PADTO;
import com.balloon.vo.DocVO;

public interface PASvc {
	public void insertPA(PADTO paDTO);

	public List<DocVO> getDocbyEmpIdAndDocStatus(String empId, Byte documentStatus);

	public List<DocVO> getDocbyEmpIdAndDocStatusByDate(String empId, Byte docStatus, LocalDateTime sunDay,
			LocalDateTime saturDay);

	public List<DocVO> getDocbyUnitCode(String unitCode);

	public PADTO getPAByPAId(String personnelAppointmentId);

	public void deletePAByPAId(String personnelAppointmentId);

	public PADTO getPAWD();

}
