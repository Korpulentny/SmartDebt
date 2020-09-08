package pl.uw.mim.jnp.smartdebt.users.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.uw.mim.jnp.smartdebt.users.models.jwt.JwtRequest;
import pl.uw.mim.jnp.smartdebt.users.services.UserDetailsServiceImpl;
import pl.uw.mim.jnp.smartdebt.users.usecases.CreateAuthenticationToken;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private CreateAuthenticationToken createAuthenticationToken;


	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) {
		return ResponseEntity.ok(createAuthenticationToken.execute(authenticationRequest));
	}


}
