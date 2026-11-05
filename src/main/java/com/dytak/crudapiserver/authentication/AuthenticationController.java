package com.dytak.crudapiserver.authentication;

import com.dytak.crudapiserver.common.ResCodeMsg;
import com.dytak.crudapiserver.common.ResponseVO;
import javax.security.sasl.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/auth")
@RestController
public class AuthenticationController {

  private final AuthenticationService authenticationService;

  @Autowired
  public AuthenticationController(AuthenticationService authenticationService) {
    this.authenticationService = authenticationService;
  }

  @PostMapping
  public ResponseEntity<?> getAuth(@RequestBody AuthenticationDTO dto)
      throws AuthenticationException {

    String token = authenticationService.getAuth(dto);
    ResponseVO vo = ResponseVO.builder()
        .code(HttpStatus.OK.value())
        .msg(ResCodeMsg.SUCCESS)
        .data(token)
        .build();

    return ResponseEntity
        .status(HttpStatus.OK.value())
        .body(vo);
  }
}
