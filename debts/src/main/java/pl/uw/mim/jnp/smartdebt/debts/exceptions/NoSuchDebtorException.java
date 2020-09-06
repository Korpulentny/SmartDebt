package pl.uw.mim.jnp.smartdebt.debts.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoSuchDebtorException extends RuntimeException {
	private final static String MESSAGE = "Danej osoby nie ma na liście dłużników";

	public NoSuchDebtorException() {
		super(MESSAGE);
	}
}
