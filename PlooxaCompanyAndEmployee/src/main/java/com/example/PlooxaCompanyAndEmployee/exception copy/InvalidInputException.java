package webresort.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@Getter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidInputException extends RuntimeException {

	private String fieldName;
	private Object fieldValue;

	public InvalidInputException(String fieldName, Object fieldValue) {
		super(String.format("%s cannot be '%s'", fieldName, fieldValue));
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public InvalidInputException(String message) {
		super(String.format(message));
	}
}