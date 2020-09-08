package pl.uw.mim.jnp.smartdebt.debts.mappers;

import lombok.experimental.UtilityClass;
import pl.uw.mim.jnp.smartdebt.debts.repositories.entities.DebtEntity;

import java.math.BigDecimal;
import java.util.List;

@UtilityClass
public class TotalDebtAmountMapper {
	public BigDecimal map(List<DebtEntity> debtEntities) {
		return debtEntities.stream().map(DebtAmountMapper::map).reduce(new BigDecimal(0),BigDecimal::add);
	}
}
