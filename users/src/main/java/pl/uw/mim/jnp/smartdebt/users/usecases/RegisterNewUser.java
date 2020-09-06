package pl.uw.mim.jnp.smartdebt.users.usecases;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.uw.mim.jnp.smartdebt.users.models.user.UserDto;
import pl.uw.mim.jnp.smartdebt.users.respositories.entities.UserEntity;
import pl.uw.mim.jnp.smartdebt.users.services.UserDetailsServiceImpl;

@Component
@AllArgsConstructor
public class RegisterNewUser {
	UserDetailsServiceImpl userDetailsServiceImpl;
	public UserEntity execute(UserDto userDto){
		return userDetailsServiceImpl.saveUser(userDto);
	}
}
