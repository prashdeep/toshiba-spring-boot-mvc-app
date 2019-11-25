package com.toshiba.assetmgmtapp.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptPasswordGenerator {

    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword1 = passwordEncoder.encode("admin");
        String encodedPassword2 = passwordEncoder.encode("admin");

        System.out.println("encrypted Password 1 "+encodedPassword1);
        System.out.println("encrypted Password 2 "+encodedPassword2);

        System.out.println(new BCryptPasswordEncoder().matches("welcome", encodedPassword2));
    }
}