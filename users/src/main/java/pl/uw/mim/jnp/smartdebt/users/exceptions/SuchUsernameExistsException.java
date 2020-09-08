package pl.uw.mim.jnp.smartdebt.users.exceptions;

public class SuchUsernameExistsException extends RuntimeException {
	private final static String MESSAGE = "Nazwa użytkownika jest już zajęta";

	public SuchUsernameExistsException() {
		super(MESSAGE);
	}
}
