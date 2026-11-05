package com.dytak.crudapiserver.authentication;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class AuthenticationDTO {

  private String username;
  private String password;
}
