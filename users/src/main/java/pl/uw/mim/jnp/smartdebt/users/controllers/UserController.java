package pl.uw.mim.jnp.smartdebt.users.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.uw.mim.jnp.smartdebt.users.models.user.UserDto;
import pl.uw.mim.jnp.smartdebt.users.usecases.RegisterNewUser;


@RestController
@RequestMapping
public class UserController {

	@Autowired
	private RegisterNewUser registerNewUser;

	@PostMapping("/register")
	ResponseEntity<?> registerNewUser(@RequestBody UserDto userDto) {
		return ResponseEntity.ok(registerNewUser.execute(userDto));
	}


}
