package pl.uw.mim.jnp.smartebt.front_server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.uw.mim.jnp.smartebt.front_server.models.dto.NewDebtDto;
import pl.uw.mim.jnp.smartebt.front_server.usecases.AddDebt;

@RestController
public class RabbitMessageController {

	@Autowired
	private AddDebt addDebt;

	@PostMapping("/debt")
	@CrossOrigin
	public ResponseEntity<?> addDebt(@RequestBody NewDebtDto newDebtDto){
		addDebt.execute(newDebtDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
