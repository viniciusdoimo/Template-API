package com.viniciusdoimo.template.api.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {

	private static final Logger log = LoggerFactory.getLogger(PasswordUtils.class);

	public PasswordUtils() {
	}

	public static String generateBCrypt(String password) {
		if (password == null) {
			return password;
		}
		BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
		return bCryptEncoder.encode(password);
	}

	public static boolean validatePassword(String password, String passwordEncoded){
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder.matches(password, passwordEncoded);
	}
}
