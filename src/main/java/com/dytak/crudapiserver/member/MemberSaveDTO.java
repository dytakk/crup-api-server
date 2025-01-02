package com.dytak.crudapiserver.member;


import com.dytak.crudapiserver.util.PasswordEncrypt;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.security.NoSuchAlgorithmException;

@Getter
@Builder
@AllArgsConstructor
public class MemberSaveDTO {


    private String username;
    private String password;
    private String name;
    private String grade;
    @JsonValue(value = true)
    private String mailAddress;

    public Member toEntity() throws NoSuchAlgorithmException {
        return Member.builder().username(username).password(PasswordEncrypt.sha256(password)).name(name).grade(grade).mailAddress(mailAddress).build();
    }

}
