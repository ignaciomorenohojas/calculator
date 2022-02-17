package com.sanitas.calculator.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sanitas.calculator.domain.enums.OperationType;
import com.sanitas.calculator.domain.exception.OperationException;

@ExtendWith(SpringExtension.class)
class CalculatorServiceImplTest {
	@InjectMocks
	private CalculatorServiceImpl calculatorService;

	@Test
	void CalculatorService_addOK_test() throws OperationException {
		List<BigDecimal> arguments = Arrays.asList(new BigDecimal(1), new BigDecimal(2));
		assertEquals(BigDecimal.valueOf(3), calculatorService.calculate(OperationType.ADD.doOperation(), arguments));
	}

	@Test
	void CalculatorService_addKO_withoutArguments_test() {
		List<BigDecimal> arguments = null;
		Assertions.assertThrows(OperationException.class, () -> calculatorService.calculate(OperationType.ADD.doOperation(), arguments));
	}

	@Test
	void CalculadoraService_addKO_tooFewArguments_test() {
		List<BigDecimal> arguments = List.of(new BigDecimal(1));
		Assertions.assertThrows(OperationException.class, () -> calculatorService.calculate(OperationType.ADD.doOperation(), arguments));
	}

	@Test
	void CalculadoraService_addKO_tooMuchArguments_test() {
		List<BigDecimal> arguments = Arrays.asList(new BigDecimal(1), new BigDecimal(2), new BigDecimal(3));
		Assertions.assertThrows(OperationException.class, () -> calculatorService.calculate(OperationType.ADD.doOperation(), arguments));
	}

	@Test
	void CalculadoraService_subtractOK_test() throws OperationException {
		List<BigDecimal> arguments = Arrays.asList(new BigDecimal(1), new BigDecimal(2));
		assertEquals(BigDecimal.valueOf(-1), calculatorService.calculate(OperationType.SUBTRACT.doOperation(), arguments));
	}

	@Test
	void CalculadoraService_subtractKO_withoutArguments_test() {
		List<BigDecimal> arguments = null;
		Assertions.assertThrows(OperationException.class, () -> calculatorService.calculate(OperationType.SUBTRACT.doOperation(), arguments));
	}

	@Test
	void CalculadoraService_subtractKO_tooFewArguments_test() {
		List<BigDecimal> arguments = List.of(new BigDecimal(1));
		Assertions.assertThrows(OperationException.class, () -> calculatorService.calculate(OperationType.SUBTRACT.doOperation(), arguments));
	}

	@Test
	void CalculadoraService_subtractKO_tooMuchArguments_test() {
		List<BigDecimal> arguments = Arrays.asList(new BigDecimal(1), new BigDecimal(2), new BigDecimal(3));
		Assertions.assertThrows(OperationException.class, () -> calculatorService.calculate(OperationType.SUBTRACT.doOperation(), arguments));
	}

}