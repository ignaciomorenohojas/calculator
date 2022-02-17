package com.sanitas.calculator.infrastructure.controller;

import java.math.BigDecimal;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

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
	@Operation(summary = "List all operations supported by this microservice.")
	@ApiResponse(responseCode = "200", description = "List retrieved correctly.")
	public ResponseEntity<List<String>> listOperationTypes() {
		return ResponseEntity.ok(Stream.of(OperationType.values()).map(OperationType::name).collect(Collectors.toList()));
	}

	@GetMapping("/{operationType}")
	@Operation(summary = "Execute an operation type with some arguments.")
	@ApiResponse(responseCode = "200", description = "Operation executed correctly.")
	@ApiResponse(responseCode = "400", description = "Operation has knows errors and response with an error text.")
	@ApiResponse(responseCode = "500", description = "Operation has unknown errors.")
	public ResponseEntity<Object> calculator(
			@Parameter(required = true, description = "Operation to be executed.") @PathVariable final OperationType operationType,
			@Parameter(required = true, description = "Argument list separated by commas.") @RequestParam final List<BigDecimal> arguments) throws OperationException {

		BigDecimal result = calculator.calculate(operationType.doOperation(), arguments);

		tracerAPIService.trace(result);
		return ResponseEntity.ok(result);
	}
}
