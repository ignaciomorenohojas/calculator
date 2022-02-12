package com.sanitas.calculator.infrastructure.controller.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sanitas.calculator.domain.exception.OperationException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	/**
	 * Handle OperationException. Triggered when an operation have invalid arguments or options.
	 *
	 * @param ex OperationException
	 * @return the ApiError object
	 */
	@ExceptionHandler(OperationException.class)
	public static ResponseEntity<String> handleOperationException(final OperationException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
