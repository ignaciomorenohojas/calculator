package com.sanitas.calculator.domain.operations;

import java.util.List;

/**
 * @author imoreno
 * @since 2022-02-11
 */
public class AddOperation implements OperationFactory {
	public AddOperation() {
		super();
	}

	@Override
	public Double calculate(List<Double> arguments) {
		return arguments.stream().reduce((double) 0, Double::sum);
	}
}
