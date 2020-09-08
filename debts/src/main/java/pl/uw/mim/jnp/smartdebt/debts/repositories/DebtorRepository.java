package pl.uw.mim.jnp.smartdebt.debts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.uw.mim.jnp.smartdebt.debts.repositories.entities.DebtorEntity;

import java.util.List;
import java.util.Optional;

public interface DebtorRepository extends JpaRepository<DebtorEntity, Long> {
	Optional<DebtorEntity> findByUsernameAndDebtorUsername(String requesterUsername, String debtorUsername);

	List<DebtorEntity> findAllByUsername(String requesterUsername);

}
