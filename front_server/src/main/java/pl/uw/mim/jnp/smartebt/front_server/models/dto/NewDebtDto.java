package pl.uw.mim.jnp.smartebt.front_server.models.dto;

import lombok.Data;


import java.io.Serializable;
import java.math.BigDecimal;


@Data
public class NewDebtDto implements Serializable {
	private static final long serialVersionUID = 5926468583005150707L;
	private String requesterUsername;
	private String debtorUsername;
	private BigDecimal amount;
	private Boolean isRequesterOwned;
}
