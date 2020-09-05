package pl.uw.mim.jnp.smartdebt.debts.usecases;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.uw.mim.jnp.smartdebt.debts.models.debtHistory.DebtorHistoryDto;
import pl.uw.mim.jnp.smartdebt.debts.services.DebtService;

@Component
@AllArgsConstructor
public class GetDebtorHistory {
	DebtService debtService;

	public DebtorHistoryDto execute(Long questionerId, Long debtorId) {
		return debtService.getDebtorHistory(questionerId, debtorId);
	}
}
