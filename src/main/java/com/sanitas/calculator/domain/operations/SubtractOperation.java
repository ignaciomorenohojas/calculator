package com.sanitas.calculator.domain.operations;

import java.util.List;

/**
 * @author imoreno
 * @since 2022-02-11
 */
public class SubtractOperation implements OperationFactory {

	public SubtractOperation() {
		super();
	}

	@Override
	public Double calculate(List<Double> arguments) {
			Double totalNegativePart = arguments.subList(1, arguments.size()).stream().reduce((double) 0, Double::sum);
			return arguments.get(0) - totalNegativePart;
	}

}
