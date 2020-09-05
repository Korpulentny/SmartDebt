package pl.uw.mim.jnp.smartdebt.debts.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.uw.mim.jnp.smartdebt.debts.models.debtHistory.DebtorHistoryDto;
import pl.uw.mim.jnp.smartdebt.debts.usecases.GetDebtorHistory;

@RestController
@RequestMapping("/debt")
public class DebtController {

	private GetDebtorHistory getDebtorHistory;

	@GetMapping("/history")
	public DebtorHistoryDto getDebtorHistory(@RequestParam Long questionerId, @RequestParam Long debtorId) {
		return getDebtorHistory.execute(questionerId, debtorId);
	}

}
