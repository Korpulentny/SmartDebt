package pl.uw.mim.jnp.smartdebt.users.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

	@PostMapping("/register")
	ResponseEntity<?> registerNewUser(@RequestParam String username, @RequestParam String password){
		return ResponseEntity.ok().build();
	}



}
