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

	public DebtorHistoryDto getDebtorHistory(String questionerUsername, String debtorUsername) {
		List<DebtEntity> debts = debtRepository.findAllByFirstUsernameAndSecondUsernameOrderByCreationTimestampDesc(questionerUsername, debtorUsername);
		return DebtorHistoryDtoMapper.map(questionerUsername, debtorUsername, debts);
	}

	public void addNewDebt(String requesterUsername, String debtorUsername, BigDecimal amount, Boolean isRequesterOwed) {
		debtorService.isDebtor(requesterUsername, debtorUsername);
		Date date = new Date();
		DebtEntity debtOne = DebtEntity.builder()
				.firstUsername(requesterUsername)
				.secondUsername(debtorUsername)
				.amount(amount)
				.isFirstOwed(isRequesterOwed)
				.creationTimestamp(date)
				.build();
		DebtEntity debtTwo = DebtEntity.builder()
				.firstUsername(debtorUsername)
				.secondUsername(requesterUsername)
				.amount(amount)
				.isFirstOwed(!isRequesterOwed)
				.creationTimestamp(date)
				.build();
		debtRepository.saveAll(Arrays.asList(debtOne, debtTwo));
	}
}
