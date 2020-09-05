package pl.uw.mim.jnp.smartdebt.debts.mappers;

import lombok.experimental.UtilityClass;
import pl.uw.mim.jnp.smartdebt.debts.models.debt.DebtDto;
import pl.uw.mim.jnp.smartdebt.debts.repositories.entities.DebtEntity;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class DebtDtoListMapper {
	public List<DebtDto> map(List<DebtEntity> debtEntities){
		return debtEntities.stream().map(DebtDtoMapper::map).collect(Collectors.toList());
	}
}
