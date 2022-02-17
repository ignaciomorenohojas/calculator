package com.sanitas.calculator.domain.operations;

import java.math.BigDecimal;
import java.util.List;

import com.sanitas.calculator.domain.exception.OperationException;

/**
 * @author imoreno
 * @since 2022-02-11
 */
public class SubtractOperation implements OperationFactory {
	private static final int MIN_ARGUMENTS = 2;
	private static final int MAX_ARGUMENTS = 2;

	public SubtractOperation() {
		super();
	}

	@Override
	public BigDecimal calculate(List<BigDecimal> arguments) throws OperationException {
		if (arguments != null && arguments.size() >= MIN_ARGUMENTS && arguments.size() <= MAX_ARGUMENTS) {
			BigDecimal totalNegativePart = arguments.subList(1, arguments.size()).stream().reduce(BigDecimal.ZERO, BigDecimal::add);
			return arguments.get(0).subtract(totalNegativePart);
		} else {
			throw new OperationException(ARGUMENT_QUANTITY_ERROR_TEXT);
		}

	}

}
