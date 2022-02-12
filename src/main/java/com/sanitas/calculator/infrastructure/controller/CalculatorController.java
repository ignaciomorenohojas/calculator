package com.sanitas.calculator.infrastructure.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sanitas.calculator.application.service.usecase.CalculatorUseCase;
import com.sanitas.calculator.domain.enums.OperationType;
import com.sanitas.calculator.domain.exception.OperationException;

@RestController
@RequestMapping("/calculator")
final class CalculatorController {

	private final CalculatorUseCase calculator;

	CalculatorController(CalculatorUseCase calculator) {
		this.calculator = calculator;
	}

	@GetMapping("/operation-types")
	public ResponseEntity<List<String>> listOperationTypes() {
		return ResponseEntity.ok(Stream.of(OperationType.values()).map(OperationType::name).collect(Collectors.toList()));
	}

	@GetMapping("/{operationType}")
	public ResponseEntity<Double> calculator(
			@PathVariable final OperationType operationType,
			@RequestParam final List<Double> arguments) throws OperationException  {
		return ResponseEntity.ok(calculator.calculate(operationType.doOperation(), arguments));
	}
}
