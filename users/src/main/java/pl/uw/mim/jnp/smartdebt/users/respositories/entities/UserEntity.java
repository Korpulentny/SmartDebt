package pl.uw.mim.jnp.smartdebt.users.respositories.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "APPLICATION_USER")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "USERNAME", unique = true)
	private String username;

	@Column(name = "PASSWORD_HASH", nullable = false)
	@JsonIgnore
	private String passwordHash;
}

