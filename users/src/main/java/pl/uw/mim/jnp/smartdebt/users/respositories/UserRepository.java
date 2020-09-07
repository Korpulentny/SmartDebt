package pl.uw.mim.jnp.smartdebt.users.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.uw.mim.jnp.smartdebt.users.respositories.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findUserEntityByUsernameAndPassword(String username, String password);

	Boolean existsByUsername(String username);

	UserEntity findByUsername(String username);
}
