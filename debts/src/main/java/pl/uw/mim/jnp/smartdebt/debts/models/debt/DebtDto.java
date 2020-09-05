package pl.uw.mim.jnp.smartdebt.debts.models.debt;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class DebtDto {
	private BigDecimal amount;
	private Date date;
}
