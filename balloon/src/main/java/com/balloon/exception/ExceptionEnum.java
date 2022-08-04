//package com.balloon.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatus.Series;
//
//import lombok.Getter;
//import lombok.ToString;
//
//@Getter
//@ToString
//public enum ExceptionEnum {
//	BAD_REQUEST(HttpStatus.BAD_REQUEST, "400", "Bad Request"),
//	UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "401", "Unauthorized"),
//	PAYMENT_REQUIRED(HttpStatus.PAYMENT_REQUIRED, "402", "Payment Required"),
//	FORBIDDEN(HttpStatus.FORBIDDEN, "403", "Forbidden"),
//	NOT_FOUND(HttpStatus.NOT_FOUND, "404", "Not Found"),
//	
////	INTERB
//	SECURITY_001(HttpStatus.NOT_FOUND, "404", "Not Found");
////	SECURITY_001(HttpStatus.BAD_REQUEST, "401", "Bad Request");
//	
//	private final HttpStatus status;
//	private final String code;
//	private String message;
//	
//	ExceptionEnum(HttpStatus status, String code) {
//		this.status = status;
//		this.code = code;
//	}
//	
//	ExceptionEnum(HttpStatus status, String code, String message) {
//		this.status = status;
//		this.code = code;
//		this.message = message;
//	}
//
//	
//	
//}
