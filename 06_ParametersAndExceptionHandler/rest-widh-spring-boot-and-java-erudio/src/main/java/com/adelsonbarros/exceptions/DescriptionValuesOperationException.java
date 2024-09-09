package com.adelsonbarros.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONTINUE)
public class DescriptionValuesOperationException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public DescriptionValuesOperationException(String ex) {
		super(ex);
	}

}