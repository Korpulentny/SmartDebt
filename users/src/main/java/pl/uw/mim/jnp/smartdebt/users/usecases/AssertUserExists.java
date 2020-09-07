package pl.uw.mim.jnp.smartdebt.users.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import pl.uw.mim.jnp.smartdebt.users.services.UserDetailsServiceImpl;

@Component
public class AssertUserExists {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	public Boolean execute(String username) {
		if (!userDetailsService.userExists(username)) {
			throw new UsernameNotFoundException(username);
		}
		return true;
	}
}
