package com.balloon.service;

import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.balloon.entity.Employee;
import com.balloon.repository.EmpRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService{
	private final EmpRepository empRepo;
	
	
	@Override
	public UserDetails loadEmployeeByEmpName(String empName) throws UsernameNotFoundException{
		return empRepo.findByEmpId(empName)
				.map(this::createEmpDetails)
				.orElseThrow(() -> new UsernameNotFoundException(empName + "을(를) DB에서 찾을 수 없습니다.") );
	};
	
	private UserDetails createEmpDetails(Employee employee) {
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(employee.getUserRoleGrade().toString());
		return new User(
				String.valueOf(employee.getEmpId()), 
				employee.getPassword(), 
				Collections.singleton(grantedAuthority)
		);
				
	}

}
