package pl.uw.mim.jnp.smartdebt.users.configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class JwtTokenUtil implements Serializable {
	private final static long serialVersionUID = -2550185165626007488L;
	private final static long JWT_VALIDITY = 60 * 60 * 10;

	@Value("${jwt.secret}")
	private String secret;

	public String getUsernameFromJWT(String jwt){
		return getSingleClaimFromJWT(jwt, Claims::getSubject);
	}

	private Claims getAllClaimsFromJWT(String jwt){
		return Jwts.parser().setSigningKey(secret).parse
	}




}
