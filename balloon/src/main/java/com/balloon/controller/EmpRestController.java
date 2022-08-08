package com.balloon.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.balloon.dto.ChangePasswordRequestDTO;
import com.balloon.dto.EmpDTO;
import com.balloon.dto.EmpRequestDTO;
import com.balloon.dto.EmpResponseDTO;
import com.balloon.dto.PageRequestDTO;
import com.balloon.dto.PageResultDTO;
import com.balloon.entity.Employee;
import com.balloon.service.EmpServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
//@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4000"})
public class EmpRestController {
	
	
	private final EmpServiceImpl empSvc;

	@GetMapping("/emp/list")
	public PageResultDTO<EmpDTO, Employee> findEmpList(PageRequestDTO pageRequestDTO) throws Exception{
		try {
			if(pageRequestDTO == null) {
				throw new Exception("입력받은 page, size 값이 없습니다.");
			} else {
				PageResultDTO<EmpDTO, Employee> pageResultDTO = empSvc.findEmpList(pageRequestDTO);
				return pageResultDTO;
			}
		} catch (Exception e) {
			e.getMessage();
			throw new Exception("출력할 사원 정보가 없습니다.");
		}
	}
	
	@GetMapping(value = "/emp/{empId}")
	public EmpDTO findEmpByEmpId(@Valid @PathVariable String empId) throws Exception{
		try {
			if(empId == null) {
				throw new Exception("사원번호를 입력받지 못했습니다.");
			} else {
				Employee empEntity = empSvc.findEmpByEmpId(empId);
				if (empEntity == null) {
					throw new Exception("사원번호가 존재하지 않습니다.");
				} else {
					return empEntity.toDTO(empEntity);
				}
			}
		} catch (Exception e) {
			throw new Exception("입력받은 사원번호가 없습니다.");
		}
	}
	
	/**/
	@GetMapping("/emp/me")
	public EmpResponseDTO getMyEmpInfo(){
		EmpResponseDTO myInfoBySecurity = empSvc.getMyInfoBySecurity();
		
		return myInfoBySecurity;
	}
	
	@PostMapping("/empName")
	public ResponseEntity<EmpResponseDTO> updateEmpName(@RequestBody EmpRequestDTO empRequestDTO){
		return ResponseEntity.ok(empSvc.changeEmpName(empRequestDTO.getEmpId(), empRequestDTO.getEmpName()));
	}

	@PostMapping("/password")
	public ResponseEntity<EmpResponseDTO> updatePassword(@RequestBody ChangePasswordRequestDTO requestDTO){
		return ResponseEntity.ok(empSvc.changePassword(requestDTO.getEmpId(), requestDTO.getExPassword(), requestDTO.getNewPassword()));
	}
	
	@GetMapping("/approval/line/{unitCode}")
	public List<EmpDTO> findEmpListInUnitCode(@Valid @PathVariable String unitCode) throws Exception{
		try {
			if(unitCode == null) {
				throw new Exception("조직이 존재하지 않습니다.");
			} else {
				List<Employee> empEntityList = empSvc.findEmpListInUnitCode(unitCode);
				if (empEntityList == null) {
//					throw new Exception("사원이 존재하지 않습니다.");
					return null;
				} else {
					List<EmpDTO> empDTOList = new ArrayList<EmpDTO>();
					
					empEntityList.forEach(empEntity -> empDTOList.add(empEntity.toDTO(empEntity)));
				
					
					return empDTOList;
				}
			}
		} catch (Exception e) {
			throw new Exception("입력받은 조직번호가 없습니다.");
		}
		
	}
	
	
//	  private UserMapper userMapper;
//	  private Bcrypt bcrypt;
//
//	  public EmpRestController(UserMapper userMapper, Bcrypt bcrypt) {
//	    this.userMapper = userMapper;
//	    this.bcrypt = bcrypt;
//	  }
//
//	  // create
//	  @PostMapping("/user") 
//	  public ResponseEntity<Map<String,String>> CreateUser(@RequestBody User req) {
//	    String hashpassword = bcrypt.HashPassword(req.getPassword());
//	    req.setPassword(hashpassword);
//	    userMapper.Create(req);
//	    Map<String,String> map = new HashMap<>();
//	    map.put("result", "success");
//
//	    return new ResponseEntity<>(map, HttpStatus.OK);
//	  }
//
//	  // read
//	  @GetMapping("/users")
//	  public List<User> AllUser() {
//	    return userMapper.findAll();
//	  }
//
//	  // update
//	  @PostMapping("/update") 
//	  public ResponseEntity<Map<String,String>> UpdateUser(@RequestBody User req) {
//	    userMapper.Update(req);
//	    
//	    Map<String,String> map = new HashMap<>();
//	    map.put("result", "success");
//
//	    return new ResponseEntity<>(map, HttpStatus.OK);
//	  }
//
//	  // delete
//	  @PostMapping("/delete") 
//	  public ResponseEntity<Map<String,String>> DeleteUser(@RequestBody User req) {
//	    userMapper.Delete(req);
//	    
//	    Map<String,String> map = new HashMap<>();
//	    map.put("result", "success");
//
//	    return new ResponseEntity<>(map, HttpStatus.OK);
//	  }
//
//
//	  @GetMapping("/hello") // get /api/hello
//	  public ResponseEntity<Map<String,String>> Hello() { // ResponseEntity 리턴타입 Map 키와 값을 하나의 쌍으로 저장
//	    Map<String,String> map = new HashMap<>(); // map 선언, HashMap은 Map 인터페이스를 구현한 대표적인 Map 컬렉션
//	    map.put("result", "hello world"); // map에 값 넣기
//
//	    return new ResponseEntity<>(map, HttpStatus.OK); // 생성자로 ResponseEntity를 만들어서 map이랑 status클라이언트에 보내줌
//	  }


	
}
