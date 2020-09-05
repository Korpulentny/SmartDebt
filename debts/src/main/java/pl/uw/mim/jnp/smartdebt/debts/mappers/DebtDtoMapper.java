package pl.uw.mim.jnp.smartdebt.debts.mappers;

import lombok.experimental.UtilityClass;
import pl.uw.mim.jnp.smartdebt.debts.models.debt.DebtDto;
import pl.uw.mim.jnp.smartdebt.debts.repositories.entities.DebtEntity;

@UtilityClass
public class DebtDtoMapper {
	public DebtDto map(DebtEntity debtEntity){
		return DebtDto.builder()
				.amount(DebtAmountMapper.map(debtEntity))
				.date(debtEntity.getCreationTimestamp())
				.build();
	}
}
