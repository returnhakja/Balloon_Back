package com.balloon.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.balloon.config.SecurityUtil;
import com.balloon.dto.EmpDTO;
import com.balloon.dto.EmpResponseDTO;
import com.balloon.dto.PageRequestDTO;
import com.balloon.dto.PageResultDTO;
import com.balloon.entity.Employee;
import com.balloon.repository.EmpRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpServiceImpl implements EmpService {

	private final EmpRepository empRepo;
	private final PasswordEncoder passwordEncoder;

	@Transactional(readOnly = true)
	@Override
	public PageResultDTO<EmpDTO, Employee> findEmpList(PageRequestDTO pageRequestDTO) {
		Pageable pageable = pageRequestDTO.getPageable(Sort.by("empId").descending());
		Page<Employee> result = empRepo.findAll(pageable);
		Function<Employee, EmpDTO> function = (empEntity -> empEntity.toDTO(empEntity));

		return new PageResultDTO<EmpDTO, Employee>(result, function);
	};

	@Transactional(readOnly = true)
	@Override
	public List<EmpDTO> findEmps() {
		List<Employee> empEntityList = empRepo.findAll();
		List<EmpDTO> empDTOList = new ArrayList<EmpDTO>();

		empEntityList.forEach(empEntity -> empDTOList.add(empEntity.toDTO(empEntity)));

		return empDTOList;
	};

	@Transactional(readOnly = true)
	@Override
	public Employee findEmpByEmpId(String empId) {
		return empRepo.findEmpByEmpId(empId);
	}

	/**/
	@Transactional(readOnly = true)
	public EmpResponseDTO getMyInfoBySecurity() {
		if (SecurityUtil.getCurrentEmpId() == null) {
			throw new RuntimeException("로그인 유저 정보가 없습니다.");
		}

		return empRepo.getByEmpId(SecurityUtil.getCurrentEmpId());

	}

	@Transactional
	public EmpResponseDTO changeEmpName(String empId, String empName) {
		Employee employee = empRepo.findEmpByEmpId(empId);
		if (employee == null) {
			throw new RuntimeException("로그인 유저 정보가 없습니다.");
		}
		employee.updateEmpName(empName);
		return EmpResponseDTO.of(empRepo.save(employee));
	}

	@Transactional
	public EmpResponseDTO changePassword(String empId, String exPasssword, String newPassword) {
		Employee employee = empRepo.findEmpByEmpId(empId);
		if (employee == null) {
			throw new RuntimeException("로그인 유저 정보가 없습니다.");
		}
		if (!passwordEncoder.matches(exPasssword, employee.getPassword())) {
			throw new RuntimeException("비밀번호가 맞지 않습니다.");
		}
		employee.updatePassword(passwordEncoder.encode(newPassword));
		return EmpResponseDTO.of(empRepo.save(employee));
	}

	@Override
	public List<Employee> findEmpListInUnitCode(String unitCode) {
		return empRepo.findEmpListInUnitCode(unitCode);
	}

	/* site 참조 */
//	@Transactional(readOnly = true)
//	public EmpDTO getEmpInfo(String empId) {
//		return empRepo.findByEmpId(empId)
//				.map(EmpDTO::isEmpty)
//				.orElseThrow(() -> new RuntimeException("유저정보가 없습니다."));
//				
//	}
//	

	/* site 참조 */

	@Override
	public List<Employee> getEmp() {
		return empRepo.findAll();
	}
}
