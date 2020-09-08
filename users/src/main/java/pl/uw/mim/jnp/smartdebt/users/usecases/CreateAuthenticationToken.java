package pl.uw.mim.jnp.smartdebt.users.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.uw.mim.jnp.smartdebt.users.models.jwt.JwtRequest;
import pl.uw.mim.jnp.smartdebt.users.models.jwt.JwtResponse;
import pl.uw.mim.jnp.smartdebt.users.services.JwtService;

@Component
public class CreateAuthenticationToken {

	@Autowired
	private JwtService jwtService;

	public JwtResponse execute(JwtRequest authenticationRequest) {
		return jwtService.createAuthenticationToken(authenticationRequest);
	}
}
