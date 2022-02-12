package com.sanitas.calculator.domain.exception;

/**
 * @author imoreno
 * @since 2022-02-12
 */
public class OperationException extends Exception {

	public OperationException(String message) {
		super(message);
	}

	public OperationException(String message, Throwable cause) {
		super(message, cause);
	}
}
