package com.sanitas.calculator.domain.operations;

import java.util.List;

/**
 * @author imoreno
 * @since 2022-02-11
 */
public interface OperationFactory {

	Double calculate(List<Double> arguments);
}
