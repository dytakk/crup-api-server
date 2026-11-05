package com.dytak.crudapiserver.common;


import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonExceptionHandler {

  @ExceptionHandler(NullPointerException.class)
  protected ResponseEntity<ResponseVO> nullPointerException(NullPointerException e) {
    return ResponseEntity.ok().body(
        ResponseVO.builder()
            .code(ResCodeMsg.NOT_FOUND.getCode())
            .msg(ResCodeMsg.NOT_FOUND)
            .data(null).build());
  }

  @ExceptionHandler(BadCredentialsException.class)
  protected ResponseEntity<ResponseVO> badCredentialsException(BadCredentialsException e) {
    ResponseVO vo = ResponseVO.builder()
        .code(ResCodeMsg.UNAUTHORIZED.getCode())
        .msg(ResCodeMsg.UNAUTHORIZED)
        .data("아이디 또는 비밀번호가 일치하지 않습니다.").build();
    return ResponseEntity.status(vo.getCode()).body(vo);
  }

}
