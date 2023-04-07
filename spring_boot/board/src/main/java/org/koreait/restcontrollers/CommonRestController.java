package org.koreait.restcontrollers;

import jakarta.servlet.http.HttpServletResponse;
import org.koreait.commons.errors.CommonException;
import org.koreait.commons.rests.JSONResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("org.koreait.restcontrollers")
public class CommonRestController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<JSONResult<Object>> errorHandler(Exception e) {
        JSONResult<Object> jsonResult = JSONResult.builder()
                .message(e.getMessage())
                .success(false)
                .build();

       if (e instanceof CommonException) {
            CommonException common = (CommonException)e;
            jsonResult.setStatus(common.getStatus());
       } else {
           jsonResult.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
       }

       return ResponseEntity
               .status(jsonResult.getStatus())
               .body(jsonResult);
    }
}
