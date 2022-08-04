//package com.balloon.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//public class HandlerException {
//	@ExceptionHandler
//	public ResponseEntity<String> handleExcpetion(Exception e){
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//	}
//}
