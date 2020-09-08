package pl.uw.mim.jnp.smartdebt.debts.models.debtHistory;

import lombok.Builder;
import lombok.Data;
import pl.uw.mim.jnp.smartdebt.debts.models.debt.DebtDto;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class DebtorHistoryDto {
	private String questionerUsername;
	private String debtorUsername;
	private BigDecimal totalAmount;
	private List<DebtDto> debts;
}
