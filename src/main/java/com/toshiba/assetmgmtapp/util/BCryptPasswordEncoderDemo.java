package com.toshiba.assetmgmtapp.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderDemo {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encoded1 = encoder.encode("admin");
        System.out.println(encoded1);

    }
}