package pl.uw.mim.jnp.smartdebt.debts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.uw.mim.jnp.smartdebt.debts.repositories.entities.DebtEntity;

import java.util.List;

public interface DebtRepository extends JpaRepository<DebtEntity, Long> {

	List<DebtEntity> findAllBySecondUserIdOrderByCreationTimestampDesc(Long secondUserId);


}
