package com.ula.authentication.util;

import com.ula.authentication.config.security.SecurityConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTUtils {

	@Value("${auth.token.secret}")
	private String secret;

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

	public Object getRoles(String token) {

		Object roles;
		try {
			Claims claims = this.getClaims(token);
			roles = claims.get("roles");
		} catch (Exception e) {
			roles = null;
		}
		return roles;
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

	public ArrayList<String> extractRoles(UserDetails userDetails) {
		ArrayList<String> roles = new ArrayList<>();
		for (GrantedAuthority ga : userDetails.getAuthorities()) {
			roles.add(ga.getAuthority());
		}
		return roles;
	}


	/*
	 * @desc - Generates token based on given UserDetails
	 * 
	 */
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("sub", userDetails.getUsername());
		claims.put("created", new Date(System.currentTimeMillis()));
		claims.put("roles", this.extractRoles(userDetails));


		return Jwts.builder().setClaims(claims)
				.setExpiration(new Date(System.currentTimeMillis()
						+ SecurityConstants.EXPIRATION_TIME))
				.signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, this.secret).compact();
	}
}
