package com.sanitas.calculator.application.service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.sanitas.calculator.domain.enums.OperationType;
import com.sanitas.calculator.domain.exception.OperationException;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorServiceImplTest {
	@InjectMocks
	private CalculatorServiceImpl calculatorService;

	@Test
	public void CalculatorService_addOK_test() throws OperationException {
		List<Double> arguments = Arrays.asList(1.0, 2.0);
		assertEquals(Double.valueOf(3.0), calculatorService.calculate(OperationType.ADD.doOperation(), arguments));
	}

	@Test(expected = OperationException.class)
	public void CalculatorService_addKO_withoutArguments_test() throws OperationException {
		List<Double> arguments = null;
		calculatorService.calculate(OperationType.ADD.doOperation(), arguments);
	}

	@Test(expected = OperationException.class)
	public void CalculadoraService_addKO_tooFewArguments_test() throws OperationException {
		List<Double> arguments = Arrays.asList(1.0);
		calculatorService.calculate(OperationType.ADD.doOperation(), arguments);
	}

	@Test(expected = OperationException.class)
	public void CalculadoraService_addKO_tooMuchArguments_test() throws OperationException {
		List<Double> arguments = Arrays.asList(1.0, 2.0, 3.0);
		calculatorService.calculate(OperationType.ADD.doOperation(), arguments);
	}

	@Test
	public void CalculadoraService_subtractOK_test() throws OperationException {
		List<Double> arguments = Arrays.asList(1.0, 2.0);
		assertEquals(Double.valueOf(-1.0), calculatorService.calculate(OperationType.SUBTRACT.doOperation(), arguments));
	}

	@Test(expected = OperationException.class)
	public void CalculadoraService_subtractKO_withoutArguments_test() throws OperationException {
		List<Double> arguments = null;
		calculatorService.calculate(OperationType.SUBTRACT.doOperation(), arguments);
	}

	@Test(expected = OperationException.class)
	public void CalculadoraService_subtractKO_tooFewArguments_test() throws OperationException {
		List<Double> arguments = Arrays.asList(1.0);
		calculatorService.calculate(OperationType.SUBTRACT.doOperation(), arguments);
	}

	@Test(expected = OperationException.class)
	public void CalculadoraService_subtractKO_tooMuchArguments_test() throws OperationException {
		List<Double> arguments = Arrays.asList(1.0, 2.0, 3.0);
		calculatorService.calculate(OperationType.SUBTRACT.doOperation(), arguments);
	}

}