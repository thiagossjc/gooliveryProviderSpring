package com.engrenelog.engrenemc.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {
	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private long expiration;

	public String generationToken(String email) {
		return Jwts.builder().setSubject(email).setExpiration(new Date(System.currentTimeMillis() + expiration))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes()).compact();
	}

	public boolean tokenValid(String token) {
		// Claims é um tipo de jwt que armazena las revindicações do token
		Claims claims = getClaims(token);
		if (claims != null) {
			// funcao do claim para pegar o usuário
			String username = claims.getSubject();
			Date expirationDate = claims.getExpiration();
			Date now = new Date(System.currentTimeMillis());
			// Testar se el token está expirado
			if (username != null && expirationDate != null && now.before(expirationDate)) {
				return true;
			}

		}
		return false;
	}
	
	public String getUsername(String token) {
		Claims claims = getClaims(token);
		if (claims!= null) {
			String username = claims.getSubject();
			return username;
		}
		return null;
	}
	

	private Claims getClaims(String token) {
		try {
			// TODO Auto-generated method stub
			return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			return null;
		}
	}
}
