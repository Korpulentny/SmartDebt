package pl.uw.mim.jnp.smartdebt.debts.repositories.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name="DEBTS")
public class DebtEntity {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "FIRST_USER_ID")
	private String firstUsername;

	@Column(name = "SECOND_USER_ID")
	private String secondUsername;

	@Column(name = "IS_FIRST_OWED")
	private Boolean isFirstOwed;

	@Column(name = "AMOUNT")
	private BigDecimal amount;

	@Temporal(TemporalType.TIMESTAMP)
	Date creationTimestamp;
}
