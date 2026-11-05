package com.dytak.crudapiserver.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


public class JWTTest {

    Algorithm algorithm = Algorithm.HMAC256("test_salt");
    public String test(){

        HashMap headerMap = new HashMap();
        headerMap.put("hi","hello");
        String jwt = JWT.create()
                .withHeader(headerMap)
                .withClaim("username","username")
                .withClaim("name","name")
                .withClaim("id",1L)
                .sign(algorithm);
        return jwt;
    }

    @Test
    @DisplayName("decode")
    public void decode()throws JWTVerificationException {

        String str = "2024/05/01 00:59:29";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date strToDate = null;
        try {
            strToDate = formatter.parse(str);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        //JWT생성 과정
        String jwt = JWT.create()
                .withIssuer("api이름")
                .withSubject("사용자아이디?")
                .withClaim("ID",1L)
                .withClaim("ROLE","A")
                .withExpiresAt(strToDate)
                .sign(algorithm);


        System.out.println("jwt2 = " + jwt);

        //JWT 검증 및 검증이 완료되면 내부의 값을 불러올수있음 (subject, payload, claim, issuer...등등)
        DecodedJWT decodedJWT = JWT.require(algorithm)
                .build()
                .verify(jwt);

        System.out.println("decodedJWT = " + decodedJWT);



    }
}
