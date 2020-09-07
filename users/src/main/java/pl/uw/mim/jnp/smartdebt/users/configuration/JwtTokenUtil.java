package pl.uw.mim.jnp.smartdebt.users.configuration;


import io.jsonwebtoken.SignatureAlgorithm;
import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;



import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@UtilityClass
public class JwtTokenUtil implements Serializable {
	private final long serialVersionUID = -2550185165626007488L;
	private final long JWT_VALIDITY = 60 * 60 * 10;

	@Value("${jwt.secret")
	private String secret;

	public String getUsernameFromJwt(String jwt){
		return getSingleClaimFromJwt(jwt, Claims::getSubject);
	}

	public Date getExpirationDateFromJwt(String token) {
		return getSingleClaimFromJwt(token, Claims::getExpiration);
	}

	public <T> T getSingleClaimFromJwt(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromJwt(token);
		return expiration.before(new Date());
	}

	public String generateJwt(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, userDetails.getUsername());
	}

	private String doGenerateToken(Map<String, Object> claims, String subject) {

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	public Boolean validateToken(String jwt, UserDetails userDetails) {
		final String username = getUsernameFromJwt(jwt);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(jwt));
	}
}
