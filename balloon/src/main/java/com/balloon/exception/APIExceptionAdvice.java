//package com.balloon.exception;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import com.balloon.entity.APIExceptionEntity;
//
//
////@ControllerAdvice	// Controller 사용할 떄 사용, response 없음
//@RestControllerAdvice	// 화면 출력 시 json 형태
//public class APIExceptionAdvice {
//
//	@ExceptionHandler({Exception.class})
//	public ResponseEntity<APIExceptionEntity> excpetionHandler(HttpServletRequest request, final Exception e){
//		e.printStackTrace();
////		return ResponseEntity
////				.status(ExceptionEnum.NOT_FOUND.getStatus())
////				.body(APIExceptionEntity.builder()
////						.errorCode(ExceptionEnum.NOT_FOUND.getCode())
////						.errorMessage(e.getMessage())
////						.build());
//		return null;
//	}
//}
