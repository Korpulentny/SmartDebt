package pl.uw.mim.jnp.smartdebt.debts.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.uw.mim.jnp.smartdebt.debts.exceptions.NoSuchDebtorException;
import pl.uw.mim.jnp.smartdebt.debts.repositories.DebtorRepository;
import pl.uw.mim.jnp.smartdebt.debts.repositories.entities.DebtorEntity;

@Service
@AllArgsConstructor
public class DebtorService {
	DebtorRepository debtorRepository;

	public void addNewDebtor(String requesterUsername, String debtorUsername) {
		DebtorEntity debtor = debtorRepository.findByUsernameAndDebtorUsername(requesterUsername, debtorUsername)
				.orElse(DebtorEntity.builder()
						.username(requesterUsername)
						.debtorUsername(debtorUsername)
						.build());
		debtorRepository.save(debtor);
	}

	public void isDebtor(String requesterUsername, String debtorUsername) {
		debtorRepository.findByUsernameAndDebtorUsername(requesterUsername, debtorUsername).orElseThrow(NoSuchDebtorException::new);
	}


}
