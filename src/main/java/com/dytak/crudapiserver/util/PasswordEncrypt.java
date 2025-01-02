package com.dytak.crudapiserver.util;
import org.springframework.beans.factory.annotation.Value;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncrypt {


    public static String sha256(String msg) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(msg.getBytes());
        return bytesToHex(md.digest());
    }

    public static String bytesToHex(byte[] bytes){
        StringBuilder builder = new StringBuilder();
        for(byte b: bytes){
            builder.append(String.format("%02x",b));
        }
        return builder.toString();
    }


}
