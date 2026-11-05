package com.dytak.crudapiserver.authentication;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Date;
import org.springframework.security.core.Authentication;

public class JWTProvider {

  static final int tokeBeginIndex = 7;

  static Algorithm algorithm = Algorithm.HMAC256("test_salt");

//  public static String issueToken(Optional<Member> member) {
//    String token = "a";
//    JWT.decode(token).getSubject();
//
//    return JWT.create()
//        .withSubject(member.get().getUsername())
//        .withClaim("id", member.get().getId())
//        .withClaim("grade", member.get().getGrade())
//        .sign(algorithm);
//  }

  public static String issueToken(Authentication authentication) {

    Date now = new Date();
    Date expireDate = new Date(now.getTime() + 1000 * 60 * 60);

    //Authentication객체를 기반으로 getPrincipal을 통해 계저정보를 가져오고 캐스티을 통해 UserDetails객체로 리턴
    CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
    return JWT.create()
        .withSubject(customUserDetails.getUsername())
        .withClaim("id", customUserDetails.getId())
        // .withClaim("grade", member.get().getGrade())
        .withIssuedAt(now)
        .withExpiresAt(expireDate)
        .sign(algorithm);
  }


  public static boolean verifyAccessToken(HttpServletRequest request) {
    String bearerToken = request.getHeader("Authorization");

    if (bearerToken == null || !bearerToken.startsWith("Bearer ")) {
      return false;
    }

    String token = bearerToken.substring(tokeBeginIndex);

    if (token.isBlank()) {
      return false;
    }

    try {
      JWT.require(algorithm)
          .withClaimPresence("exp")
          .build()
          .verify(token);
      return true;
    } catch (TokenExpiredException e) {
      System.out.println("TOKEN EXPIRED! = " + e.getMessage());
    } catch (JWTVerificationException e) {
      System.out.println("TOKEN ERROR " + e.getMessage());
    }
    return false;
  }


}
