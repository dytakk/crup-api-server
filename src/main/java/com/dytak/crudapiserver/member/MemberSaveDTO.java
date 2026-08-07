package com.dytak.crudapiserver.member;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.security.NoSuchAlgorithmException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MemberSaveDTO {


  private String username;
  private String password;
  private String name;
  private String grade;
  private String mailAddress;
  private String accessToken;

  public Member toEntity(String password) throws NoSuchAlgorithmException {
    return Member
        .builder()
        .username(username)
        .password(password)
        .name(name)
        .grade(grade)
        .mailAddress(mailAddress)
        .build();
  }

}
