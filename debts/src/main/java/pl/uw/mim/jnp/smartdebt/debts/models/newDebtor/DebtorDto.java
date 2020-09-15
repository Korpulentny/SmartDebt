package pl.uw.mim.jnp.smartdebt.debts.models.newDebtor;
import lombok.Data;

import java.io.Serializable;


@Data
public class DebtorDto implements Serializable {
	private static final long serialVersionUID = 5926468583005150707L;
	private String requesterId;
	private String debtorId;
}
