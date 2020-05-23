package com.ula.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JWTUtils {

	@Value("${token.secret}")
	private String secret;

	@Value("${token.expiration}")
	private Long expiration;

	private Claims getClaims(String token) {
		Claims claims;

		try {
			claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			claims = null;
		}

		return claims;
	}

	private boolean isExpired(String token) {
		final Date expiration = this.getExpirationDate(token);
		return expiration.before(new Date(System.currentTimeMillis()));
	}

	public String getUsername(String token) {
		String username;

		try {
			Claims claims = this.getClaims(token);
			username = claims.getSubject();
		} catch (Exception e) {
			username = null;
		}

		return username;
	}

	public String getEmail(String token) {
		String email;
		
		try {
			Claims claims = this.getClaims(token);
			email = claims.getSubject();
		} catch (Exception e) {
			email = null;
		}
		return email;
	}

	public Date getExpirationDate(String token) {
		Date expiration;

		try {
			final Claims claims = this.getClaims(token);
			expiration = claims.getExpiration();
		} catch (Exception e) {
			expiration = null;
		}

		return expiration;
	}

	public boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsername(token);
		return (username.equals(userDetails.getUsername()) && !isExpired(token));
	}

	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("sub", userDetails.getUsername());
		claims.put("created", new Date(System.currentTimeMillis()));

		return Jwts.builder().setClaims(claims)
				.setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
				.signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, this.secret).compact();
	}
}
