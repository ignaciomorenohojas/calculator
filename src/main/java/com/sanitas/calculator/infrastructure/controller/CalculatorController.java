package com.sanitas.calculator.infrastructure.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sanitas.calculator.application.service.usecase.CalculatorUseCase;
import com.sanitas.calculator.domain.enums.OperationType;
import com.sanitas.calculator.domain.exception.OperationException;
import com.sanitas.calculator.infrastructure.controller.tracer.TracerAPIService;

@RestController
@RequestMapping("/calculator")
public final class CalculatorController {

	@Autowired
	TracerAPIService tracerAPIService;

	private final CalculatorUseCase calculator;

	CalculatorController(CalculatorUseCase calculator) {
		this.calculator = calculator;
	}

	@GetMapping("/operation-types")
	public ResponseEntity<List<String>> listOperationTypes() {
		return ResponseEntity.ok(Stream.of(OperationType.values()).map(OperationType::name).collect(Collectors.toList()));
	}

	@GetMapping("/{operationType}")
	public ResponseEntity<Object> calculator(
			@PathVariable final OperationType operationType,
			@RequestParam final List<Double> arguments) throws OperationException {

		Double result = calculator.calculate(operationType.doOperation(), arguments);

		tracerAPIService.trace(result);
		return ResponseEntity.ok(result);
	}
}
