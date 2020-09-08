package pl.uw.mim.jnp.smartdebt.debts.controllers;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.uw.mim.jnp.smartdebt.debts.models.debtHistory.DebtorHistoryDto;
import pl.uw.mim.jnp.smartdebt.debts.usecases.AddNewDebt;
import pl.uw.mim.jnp.smartdebt.debts.usecases.AddNewDebtor;
import pl.uw.mim.jnp.smartdebt.debts.usecases.GetDebtorHistory;

import java.math.BigDecimal;

@RestController
public class DebtController {

	@Autowired
	private GetDebtorHistory getDebtorHistory;

	@Autowired
	private AddNewDebt addNewDebt;

	@Autowired
	private AddNewDebtor addNewDebtor;

	@GetMapping("/history")
	public DebtorHistoryDto getDebtorHistory(@RequestParam Long questionerId, @RequestParam Long debtorId) {
		return getDebtorHistory.execute(questionerId, debtorId);
	}

	@PostMapping("/debt")
	public void addNewDebt(@RequestParam Long requesterId, @RequestParam Long debtorId,
			@RequestParam BigDecimal amount, @RequestParam Boolean isRequesterOwned) {
		addNewDebt.execute(requesterId, debtorId, amount, isRequesterOwned);
	}

	@PostMapping("/debtor")
	public void addNewDebtor(@RequestParam String requesterUsername, @RequestParam String debtorUsername) {
		addNewDebtor.execute(requesterUsername, debtorUsername);
	}

}
