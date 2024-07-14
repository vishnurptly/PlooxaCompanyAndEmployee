package webresort.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@Getter
@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateResourceException extends RuntimeException {

	private String resourceName;
	private String fieldName;
	private Object fieldValue;

	public DuplicateResourceException(String resourceName, String fieldName, Object fieldValue) {
		super(String.format("%s already exist with %s : '%s'", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
}