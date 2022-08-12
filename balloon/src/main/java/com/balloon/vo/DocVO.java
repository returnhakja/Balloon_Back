package com.balloon.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class DocVO {

	// 문서 번호
	private String docId;

	// 기안 제목
	private String documentTitle;

	// 상신일
	private LocalDateTime updateTime;

	// 문서 상태
//	private Byte documentStatus;

	// 부서 번호
//	private Unit unit;

}
