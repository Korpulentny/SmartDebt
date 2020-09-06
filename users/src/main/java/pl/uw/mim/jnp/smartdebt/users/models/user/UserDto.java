package pl.uw.mim.jnp.smartdebt.users.models.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
	private String username;
	private String password;

}
