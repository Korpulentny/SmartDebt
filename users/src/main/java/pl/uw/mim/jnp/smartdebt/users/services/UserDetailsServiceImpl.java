package pl.uw.mim.jnp.smartdebt.users.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pl.uw.mim.jnp.smartdebt.users.exceptions.SuchUsernameExistsException;
import pl.uw.mim.jnp.smartdebt.users.models.user.UserDto;
import pl.uw.mim.jnp.smartdebt.users.repositories.UserRepository;
import pl.uw.mim.jnp.smartdebt.users.repositories.entities.UserEntity;

import java.util.Collections;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(user.getUsername(), user.getPassword(), Collections.emptyList());
	}

	public Boolean userExists(String username){
		return userRepository.existsByUsername(username);
	}

	public UserEntity saveUser(UserDto userDto)  throws SuchUsernameExistsException {
		if (userRepository.existsByUsername(userDto.getUsername())) {
			throw new SuchUsernameExistsException();
		}
		return userRepository.save(UserEntity.builder()
				.username(userDto.getUsername())
				.password(bCryptPasswordEncoder.encode(userDto.getPassword()))
				.build());
	}


}
