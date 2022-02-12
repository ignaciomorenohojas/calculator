package com.sanitas.calculator.domain.operations;

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
	public Double calculate(List<Double> arguments) throws OperationException {
		if (arguments != null && arguments.size() >= MIN_ARGUMENTS && arguments.size() <= MAX_ARGUMENTS) {
			Double totalNegativePart = arguments.subList(1, arguments.size()).stream().reduce((double) 0, Double::sum);
			return arguments.get(0) - totalNegativePart;
		} else {
			throw new OperationException("Number of arguments not valid.");
		}

	}

}
