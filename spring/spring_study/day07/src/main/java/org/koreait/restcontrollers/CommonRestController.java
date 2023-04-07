package org.koreait.restcontrollers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonRestController {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<JSONResult<Object>> errorHandler(Exception e){
		
		// 상태 코드, 헤더, 바디
		JSONResult<Object> jsonResult = new JSONResult<>();
		jsonResult.setSuccess(false);
		jsonResult.setMessage(e.getMessage());
		
		// responseEntity : 응답 상태, 헤더 정보 추가
		// .status() : 코드 상태
		// .body(T data) : 응답 body가 있을 때, | build() : 응답 body가 없을 때
		return ResponseEntity.internalServerError().body(jsonResult);
	}
}
