package pl.uw.mim.jnp.smartebt.front_server.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.uw.mim.jnp.smartebt.front_server.models.dto.NewDebtDto;
import pl.uw.mim.jnp.smartebt.front_server.services.RabbitManagementService;

@Component
public class AddDebt {

	@Autowired
	private RabbitManagementService rabbitManagementService;

	public void execute(NewDebtDto newDebtDto) {
		rabbitManagementService.addNewDebt(newDebtDto);
	}
}
