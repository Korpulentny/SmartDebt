package pl.uw.mim.jnp.smartdebt.debts.rabbitmessaging;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.uw.mim.jnp.smartdebt.debts.usecases.AddNewDebt;

@Component
public class Receiver {

	private final CountDownLatch latch = new CountDownLatch(1);

	@Autowired
	private AddNewDebt addNewDebt;

	public void receiveMessage(String message) {
		System.out.println("Received <" + message + ">");
		var messages = message.split("&");

		addNewDebt.execute(messages[0],messages[1],new BigDecimal(messages[2]), Boolean.valueOf(messages[3]));


		latch.countDown();
	}

	public CountDownLatch getLatch() {
		return latch;
	}

}