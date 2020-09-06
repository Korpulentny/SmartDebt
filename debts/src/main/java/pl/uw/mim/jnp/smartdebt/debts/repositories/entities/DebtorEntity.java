package pl.uw.mim.jnp.smartdebt.debts.repositories.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "DEBTOR")
public class DebtorEntity {
	@Id
	@GeneratedValue
	private Long id;

	private Long userId;

	private Long debtorId;
}
