package com.dytak.crudapiserver.util;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordEncryptTest {

    @Test
    @DisplayName("password hash 테스트")
    public void test() throws NoSuchAlgorithmException {
        String enc = PasswordEncrypt.sha256("encrypt_test").toUpperCase();
        //하단 SHA256 값. 참조 사이트 : https://www.convertstring.com/ko/Hash/SHA256
        String encAnswer= "A0ACF59543512497757B171B4B58330C82DE7924D2110E63264E53D4FD85AD9F";
        assertThat(enc).isEqualTo(encAnswer);
    }
}
