package pl.uw.mim.jnp.smartdebt.debts.models.newDebtor;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DebtorDto {
	private String requesterId;
	private String debtorId;
}
