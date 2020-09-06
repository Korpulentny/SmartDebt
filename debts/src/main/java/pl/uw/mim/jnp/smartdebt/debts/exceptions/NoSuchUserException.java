package pl.uw.mim.jnp.smartdebt.debts.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoSuchUserException extends RuntimeException {
	private final static String MESSAGE = "Osoby o danym id nie ma w bazie dancyh";

	public NoSuchUserException() {
		super(MESSAGE);
	}
}
