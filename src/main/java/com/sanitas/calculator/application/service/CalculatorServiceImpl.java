package com.sanitas.calculator.application.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanitas.calculator.application.service.usecase.CalculatorUseCase;
import com.sanitas.calculator.domain.exception.OperationException;
import com.sanitas.calculator.domain.operations.factory.OperationFactory;

/**
 * @author imoreno
 * @since 2022-02-11
 */
@Service
public class CalculatorServiceImpl implements CalculatorUseCase {

	@Autowired
	private OperationFactory operationServiceFactory;

	@Override
	public BigDecimal calculate(String operation, List<BigDecimal> arguments) throws OperationException {
		return operationServiceFactory.getInstance(operation).calculate(arguments);
	}
}
