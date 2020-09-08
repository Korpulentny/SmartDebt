package pl.uw.mim.jnp.smartdebt.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.uw.mim.jnp.smartdebt.users.repositories.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	Boolean existsByUsername(String username);

	UserEntity findByUsername(String username);
}
