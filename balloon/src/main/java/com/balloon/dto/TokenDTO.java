package com.balloon.dto;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenDTO {
	private String grantType;
	private String accessToken;
	private Long tokenExpiresIn;
	
	@OneToOne
	@JoinColumn(name = "emp_id")
	private String partitionKey;
}
