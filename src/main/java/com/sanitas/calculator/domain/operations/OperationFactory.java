package com.sanitas.calculator.domain.operations;

import java.util.List;

import com.sanitas.calculator.domain.exception.OperationException;

/**
 * @author imoreno
 * @since 2022-02-11
 */
public interface OperationFactory {

	Double calculate(List<Double> arguments) throws OperationException;
}
