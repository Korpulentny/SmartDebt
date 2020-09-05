package pl.uw.mim.jnp.smartdebt.debts.models.debtHistory;

import lombok.Builder;
import lombok.Data;
import pl.uw.mim.jnp.smartdebt.debts.models.debt.DebtDto;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class DebtorHistoryDto {
	private Long questionerId;
	private Long debtorId;
	private BigDecimal totalAmount;
	private List<DebtDto> debts;
}
