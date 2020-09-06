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

	public void addNewDebtor(Long requesterId, Long debtorId) {
		DebtorEntity debtor = debtorRepository.findByUserIdAndDebtorId(requesterId, debtorId)
				.orElse(DebtorEntity.builder()
						.userId(requesterId)
						.debtorId(debtorId)
						.build());
		debtorRepository.save(debtor);
	}

	public void isDebtor(Long requesterId, Long debtorId) {
		debtorRepository.findByUserIdAndDebtorId(requesterId, debtorId).orElseThrow(NoSuchDebtorException::new);
	}


}
