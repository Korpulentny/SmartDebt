package pl.uw.mim.jnp.smartdebt.debts.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.uw.mim.jnp.smartdebt.debts.mappers.DebtorHistoryDtoMapper;
import pl.uw.mim.jnp.smartdebt.debts.models.debtHistory.DebtorHistoryDto;
import pl.uw.mim.jnp.smartdebt.debts.repositories.DebtRepository;
import pl.uw.mim.jnp.smartdebt.debts.repositories.DebtorRepository;
import pl.uw.mim.jnp.smartdebt.debts.repositories.entities.DebtEntity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class DebtService {
	DebtRepository debtRepository;

	DebtorService debtorService;

	public DebtorHistoryDto getDebtorHistory(Long questionerId, Long debtorId) {
		List<DebtEntity> debts = debtRepository.findAllByFirstUserIdAndSecondUserIdOrderByCreationTimestampDesc(questionerId, debtorId);
		return DebtorHistoryDtoMapper.map(questionerId, debtorId, debts);
	}

	public void addNewDebt(Long requesterId, Long debtorId, BigDecimal amount, Boolean isRequesterOwned) {
		debtorService.isDebtor(requesterId, debtorId);
		Date date = new Date();
		DebtEntity debtOne = DebtEntity.builder()
				.firstUserId(requesterId)
				.secondUserId(debtorId)
				.amount(amount)
				.isFirstOwed(isRequesterOwned)
				.creationTimestamp(date)
				.build();
		DebtEntity debtTwo = DebtEntity.builder()
				.firstUserId(debtorId)
				.secondUserId(requesterId)
				.amount(amount)
				.isFirstOwed(!isRequesterOwned)
				.creationTimestamp(date)
				.build();
		debtRepository.saveAll(Arrays.asList(debtOne, debtTwo));
	}
}
