package com.dytak.crudapiserver.authentication;

import javax.security.sasl.AuthenticationException;


public interface AuthenticationService {

  String getAuth(AuthenticationDTO authenticationDTO) throws AuthenticationException;
}
