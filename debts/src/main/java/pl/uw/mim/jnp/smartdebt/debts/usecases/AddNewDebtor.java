package pl.uw.mim.jnp.smartdebt.debts.usecases;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import pl.uw.mim.jnp.smartdebt.debts.services.DebtorService;

@Component
@AllArgsConstructor
public class AddNewDebtor {
	DebtorService debtorService;
	public void execute(String username, String debtorUsername){
		debtorService.addNewDebtor(username, debtorUsername);
	}
}
