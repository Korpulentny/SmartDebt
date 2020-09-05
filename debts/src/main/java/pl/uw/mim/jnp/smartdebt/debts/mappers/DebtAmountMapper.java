package pl.uw.mim.jnp.smartdebt.debts.mappers;

import lombok.experimental.UtilityClass;
import pl.uw.mim.jnp.smartdebt.debts.repositories.entities.DebtEntity;

import java.math.BigDecimal;

@UtilityClass
public class DebtAmountMapper {
	public BigDecimal map(DebtEntity debtEntity){
		return debtEntity.getIsFirstOwed() ? debtEntity.getAmount() : debtEntity.getAmount().negate();
	}
}
