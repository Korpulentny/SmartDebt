package pl.uw.mim.jnp.smartdebt.debts.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.uw.mim.jnp.smartdebt.debts.repositories.entities.DebtorEntity;
import pl.uw.mim.jnp.smartdebt.debts.services.DebtorService;

import java.util.List;

@Component
public class GetDebtorsList {
	@Autowired
	private DebtorService debtorService;

	public List<DebtorEntity> execute(String requesterUsername) {
		return debtorService.getUserDebtors(requesterUsername);
	}
}
