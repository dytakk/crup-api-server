package com.dytak.crudapiserver.member;


import com.dytak.crudapiserver.util.PasswordEncrypt;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.security.NoSuchAlgorithmException;

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

    public Member toEntity() throws NoSuchAlgorithmException {
        return Member.builder().username(username).password(PasswordEncrypt.sha256(password)).name(name).grade(grade).mailAddress(mailAddress).build();
    }

}
