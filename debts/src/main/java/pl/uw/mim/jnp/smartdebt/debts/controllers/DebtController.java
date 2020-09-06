package pl.uw.mim.jnp.smartdebt.debts.controllers;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.uw.mim.jnp.smartdebt.debts.models.debtHistory.DebtorHistoryDto;
import pl.uw.mim.jnp.smartdebt.debts.usecases.GetDebtorHistory;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/debt")
public class DebtController {

	private GetDebtorHistory getDebtorHistory;

	@GetMapping("/history")
	public DebtorHistoryDto getDebtorHistory(@RequestParam Long questionerId, @RequestParam Long debtorId) {
		return getDebtorHistory.execute(questionerId, debtorId);
	}

	@PostMapping("/debt")
	public ResponseEntity<?> addNewDebt(@RequestParam Long requesterId, @RequestParam Long debtorId){
		return ResponseEntity.ok().build();
	}

}
