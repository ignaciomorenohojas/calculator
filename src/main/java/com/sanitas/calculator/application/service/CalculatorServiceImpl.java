package com.sanitas.calculator.application.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sanitas.calculator.application.service.usecase.CalculatorUseCase;
import com.sanitas.calculator.domain.exception.OperationException;
import com.sanitas.calculator.domain.operations.OperationFactory;

/**
 * @author imoreno
 * @since 2022-02-11
 */
@Service
public class CalculatorServiceImpl implements CalculatorUseCase {

	@Override
	public BigDecimal calculate(OperationFactory operation, List<BigDecimal> arguments) throws OperationException {
		return operation.calculate(arguments);
	}
}
