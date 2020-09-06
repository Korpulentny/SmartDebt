package pl.uw.mim.jnp.smartdebt.debts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.uw.mim.jnp.smartdebt.debts.repositories.entities.DebtorEntity;

import java.util.Optional;

public interface DebtorRepository extends JpaRepository<DebtorEntity, Long> {
	Optional<DebtorEntity> findByUserIdAndDebtorId(Long requesterId, Long debtorId);
}
