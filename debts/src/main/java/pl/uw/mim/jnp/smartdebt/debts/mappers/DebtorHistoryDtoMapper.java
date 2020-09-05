package pl.uw.mim.jnp.smartdebt.debts.mappers;

import lombok.experimental.UtilityClass;
import pl.uw.mim.jnp.smartdebt.debts.models.debtHistory.DebtorHistoryDto;
import pl.uw.mim.jnp.smartdebt.debts.repositories.entities.DebtEntity;

import java.util.List;

@UtilityClass
public class DebtorHistoryDtoMapper {
	public DebtorHistoryDto map (Long questionerId, Long debtorId, List<DebtEntity> debtEntities){
		return DebtorHistoryDto.builder()
				.questionerId(questionerId)
				.debtorId(debtorId)
				.totalAmount(TotalDebtAmountMapper.map(debtEntities))
				.debts(DebtDtoListMapper.map(debtEntities))
				.build();
	}
}
