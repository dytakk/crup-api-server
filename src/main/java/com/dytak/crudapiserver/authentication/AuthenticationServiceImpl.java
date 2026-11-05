package com.dytak.crudapiserver.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

  private final AuthenticationManager authenticationManager;

  @Autowired
  private AuthenticationServiceImpl(AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;
  }

  @Override
  public String getAuth(AuthenticationDTO authenticationDTO) {
    try {
      Authentication authentication =
          new UsernamePasswordAuthenticationToken(
              authenticationDTO.getUsername(), authenticationDTO.getPassword()
          );
      Authentication auth = authenticationManager.authenticate(authentication);
      return JWTProvider.issueToken(auth);
    } catch (BadCredentialsException e) {
      throw new BadCredentialsException("아아디체크", e);
    }
  }
}
