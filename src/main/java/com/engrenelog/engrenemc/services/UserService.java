package com.engrenelog.engrenemc.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.engrenelog.engrenemc.security.UserSS;

public class UserService {
	public static UserSS authenticated() {
		try {
		return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch(Exception e) {
			return null;
		}
	}
}
