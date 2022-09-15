package com.balloon.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {

	private SecurityUtil() {
	}

	public static String getCurrentEmpId() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication == null || authentication.getName() == null) {
			throw new RuntimeException("Security Context에 인증 정보가 없습니다.");
		}

		System.out.println(authentication.getName());
		return authentication.getName();
	}
}