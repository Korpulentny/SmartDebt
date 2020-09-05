package pl.uw.mim.jnp.smartdebt.debts.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.uw.mim.jnp.smartdebt.debts.mappers.DebtorHistoryDtoMapper;
import pl.uw.mim.jnp.smartdebt.debts.models.debtHistory.DebtorHistoryDto;
import pl.uw.mim.jnp.smartdebt.debts.repositories.DebtRepository;
import pl.uw.mim.jnp.smartdebt.debts.repositories.entities.DebtEntity;

import java.util.List;

@Service
@AllArgsConstructor
public class DebtService {
	DebtRepository debtRepository;

	public DebtorHistoryDto getDebtorHistory(Long questionerId, Long debtorId){
		List<DebtEntity> debts = debtRepository.findAllBySecondUserIdOrderByCreationTimestampDesc(debtorId);
		return DebtorHistoryDtoMapper.map(questionerId, debtorId, debts);

	}
}
