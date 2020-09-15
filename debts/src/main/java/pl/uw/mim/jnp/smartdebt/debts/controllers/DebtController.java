package pl.uw.mim.jnp.smartdebt.debts.controllers;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.uw.mim.jnp.smartdebt.debts.models.debtHistory.DebtorHistoryDto;
import pl.uw.mim.jnp.smartdebt.debts.models.newDebtor.DebtorDto;
import pl.uw.mim.jnp.smartdebt.debts.usecases.AddNewDebt;
import pl.uw.mim.jnp.smartdebt.debts.usecases.AddNewDebtor;
import pl.uw.mim.jnp.smartdebt.debts.usecases.GetDebtorHistory;
import pl.uw.mim.jnp.smartdebt.debts.usecases.GetDebtorsList;

import java.math.BigDecimal;
import java.net.http.HttpResponse;

@CrossOrigin
@RestController
public class DebtController {

	@Autowired
	private GetDebtorHistory getDebtorHistory;

	@Autowired
	private AddNewDebt addNewDebt;

	@Autowired
	private AddNewDebtor addNewDebtor;

	@Autowired
	private GetDebtorsList getDebtorsList;

	@GetMapping("/history")
	public DebtorHistoryDto getDebtorHistory(@RequestParam String requesterUsername, @RequestParam String debtorUsername) {
		return getDebtorHistory.execute(requesterUsername, debtorUsername);
	}

	@PostMapping("/debt")
	public void addNewDebt(@RequestParam String requesterUsername, @RequestParam String debtorUsername,
			@RequestParam BigDecimal amount, @RequestParam Boolean isRequesterOwed) {
		addNewDebt.execute(requesterUsername, debtorUsername, amount, isRequesterOwed);
	}

	@PostMapping("/debtor")
	public void addNewDebtor(@RequestBody DebtorDto newDebtor) {
		addNewDebtor.execute(newDebtor.getRequesterId(), newDebtor.getDebtorId());
	}

	@GetMapping("/debtor-list")
	public ResponseEntity<?> getDebtorsList(@RequestParam String requesterUsername) {
		return ResponseEntity.ok(getDebtorsList.execute(requesterUsername));
	}

}
