package com.engrenelog.engrenemc.resources;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.engrenelog.engrenemc.security.JWTUtil;
import com.engrenelog.engrenemc.security.UserSS;
import com.engrenelog.engrenemc.services.UserService;


@RestController
@RequestMapping(value="/auth")
public class AuthResource {
	
	@Autowired
	private  JWTUtil jwtUtil;

	
	
	@RequestMapping(value="/refresh_token",method=RequestMethod.POST)
	public ResponseEntity<Void> refreshToken(HttpServletResponse response){
		UserSS user = UserService.authenticated();
		String token = jwtUtil.generationToken(user.getUsername());
		response.addHeader("Authorization", "Bearer " + token);
		return ResponseEntity.noContent().build();
	}
}
