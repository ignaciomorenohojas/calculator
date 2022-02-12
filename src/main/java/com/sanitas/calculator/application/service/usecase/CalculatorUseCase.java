package com.sanitas.calculator.application.service.usecase;

import java.util.List;

import com.sanitas.calculator.domain.exception.OperationException;
import com.sanitas.calculator.domain.operations.OperationFactory;

/**
 * @author imoreno
 * @since 2022-02-11
 */
public interface CalculatorUseCase {
	/**
	 *
	 * @param operation Operation type to be executed.
	 * @param arguments Arguments to use with the operation.
	 * @return result of the operation.
	 */
	Double calculate(OperationFactory operation, List<Double> arguments) throws OperationException;
}
