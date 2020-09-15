package pl.uw.mim.jnp.smartebt.front_server.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.uw.mim.jnp.smartebt.front_server.models.dto.NewDebtDto;

@Service
public class RabbitManagementService {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	static final String topicExchangeName = "spring-boot-exchange";

	static final String queueName = "debts-queue";


	public void addNewDebt(NewDebtDto newDebtDto) {
		String message = newDebtDto.getRequesterUsername() + "&" + newDebtDto.getDebtorUsername() + "&" + newDebtDto.getAmount().toString() + "&" + newDebtDto.getIsRequesterOwned().toString();
		rabbitTemplate.convertAndSend(topicExchangeName, "foo.bar.baz", message);

	}
}
