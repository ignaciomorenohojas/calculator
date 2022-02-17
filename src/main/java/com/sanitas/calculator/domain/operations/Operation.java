package com.sanitas.calculator.domain.operations;

import java.math.BigDecimal;
import java.util.List;

import com.sanitas.calculator.domain.exception.OperationException;
import com.sanitas.calculator.domain.operations.factory.OperationValidFactory;

/**
 * @author imoreno
 * @since 2022-02-17
 */
public interface Operation extends OperationValidFactory<String> {
	String ARGUMENT_QUANTITY_ERROR_TEXT = "Number of arguments not valid.";

	BigDecimal calculate(List<BigDecimal> arguments) throws OperationException;
}
