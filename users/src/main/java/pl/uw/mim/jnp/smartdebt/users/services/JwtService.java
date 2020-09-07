package pl.uw.mim.jnp.smartdebt.users.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pl.uw.mim.jnp.smartdebt.users.configuration.JwtTokenUtil;
import pl.uw.mim.jnp.smartdebt.users.models.jwt.JwtRequest;
import pl.uw.mim.jnp.smartdebt.users.models.jwt.JwtResponse;
import pl.uw.mim.jnp.smartdebt.users.exceptions.WrongUsernameOrPasswordException;

@Service
public class JwtService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	public JwtResponse createAuthenticationToken(JwtRequest authenticationRequest) {
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//		return new JwtResponse(JwtTokenUtil.generateJwt(userDetails));
		return JwtResponse.builder()
				.setJwt(JwtTokenUtil.generateJwt(userDetails))
				.build();
	}

	private void authenticate(String username, String password) throws WrongUsernameOrPasswordException {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (BadCredentialsException e) {
			throw new WrongUsernameOrPasswordException();
		}
	}

}
