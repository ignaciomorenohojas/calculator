package com.sanitas.calculator.application.service.usecase;

import java.math.BigDecimal;
import java.util.List;

import com.sanitas.calculator.domain.exception.OperationException;

/**
 * @author imoreno
 * @since 2022-02-11
 */
public interface CalculatorUseCase {
	/**
	 * @param operation Operation type to be executed.
	 * @param arguments Arguments to use with the operation.
	 * @return result of the operation.
	 */
	BigDecimal calculate(String operation, List<BigDecimal> arguments) throws OperationException;
}
