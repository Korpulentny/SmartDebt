package pl.uw.mim.jnp.smartdebt.debts.usecases;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.uw.mim.jnp.smartdebt.debts.services.DebtService;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class AddNewDebt {

	DebtService debtService;

	public void execute(Long requesterId, Long debtorId, BigDecimal amount, Boolean isRequesterOwed) {
		debtService.addNewDebt(requesterId, debtorId, amount, isRequesterOwed);
	}

}
