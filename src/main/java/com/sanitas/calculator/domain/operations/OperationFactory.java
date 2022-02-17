package com.sanitas.calculator.domain.operations;

import java.math.BigDecimal;
import java.util.List;

import com.sanitas.calculator.domain.exception.OperationException;

/**
 * @author imoreno
 * @since 2022-02-11
 */
public interface OperationFactory {
	String ARGUMENT_QUANTITY_ERROR_TEXT = "Number of arguments not valid.";

	BigDecimal calculate(List<BigDecimal> arguments) throws OperationException;
}
