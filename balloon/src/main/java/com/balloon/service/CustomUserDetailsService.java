package com.balloon.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.balloon.entity.Employee;


public interface CustomUserDetailsService {

	public UserDetails loadEmployeeByEmpName(String empName) throws UsernameNotFoundException;
	
}
