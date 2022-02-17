package com.sanitas.calculator.domain.operations.factory;

import java.util.List;

import com.sanitas.calculator.domain.exception.OperationException;


/**
 * @author imoreno
 * @since 2022-02-11
 */
public abstract class OperationsContentFactory<T extends OperationValidFactory<String>> {
	static final String OPERATION_NOT_SUPPORTED_ERROR_TEXT = "Operation not supported.";

	private final List<T> operationInstances;

	protected OperationsContentFactory(List<T> operationInstances) {
		this.operationInstances = operationInstances;
	}

	public T getInstance(String factory) throws OperationException {
		return operationInstances.stream().filter(o -> o.isValid(factory)).findFirst().orElseThrow(
				() -> new OperationException(OPERATION_NOT_SUPPORTED_ERROR_TEXT));
	}
}
