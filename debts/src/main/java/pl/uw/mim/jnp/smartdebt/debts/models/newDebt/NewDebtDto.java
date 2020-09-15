package pl.uw.mim.jnp.smartdebt.debts.models.newDebt;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class NewDebtDto {
	private String requesterUsername;
	private String debtorUsername;
	private BigDecimal amount;
	private Boolean isRequesterOwned;
}
