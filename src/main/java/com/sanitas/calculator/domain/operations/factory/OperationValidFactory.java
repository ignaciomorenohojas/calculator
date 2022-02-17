package com.sanitas.calculator.domain.operations.factory;

/**
 * @author imoreno
 * @since 2022-02-17
 */
public interface OperationValidFactory<T> {

	boolean isValid(T operation);

}
