package com.sanitas.calculator.domain.operations;

import java.math.BigDecimal;
import java.util.List;

import com.sanitas.calculator.domain.exception.OperationException;

/**
 * @author imoreno
 * @since 2022-02-11
 */
public class AddOperation implements OperationFactory {
	private static final int MIN_ARGUMENTS = 2;
	private static final int MAX_ARGUMENTS = 2;

	public AddOperation() {
		super();
	}

	@Override
	public BigDecimal calculate(List<BigDecimal> arguments) throws OperationException {
		if (arguments != null && arguments.size() >= MIN_ARGUMENTS && arguments.size() <= MAX_ARGUMENTS) {
			return arguments.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
		} else {
			throw new OperationException(ARGUMENT_QUANTITY_ERROR_TEXT);
		}
	}
}
