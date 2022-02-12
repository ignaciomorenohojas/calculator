package com.sanitas.calculator.domain.enums;

import java.util.function.Supplier;

import com.sanitas.calculator.domain.operations.AddOperation;
import com.sanitas.calculator.domain.operations.OperationFactory;
import com.sanitas.calculator.domain.operations.SubtractOperation;

/**
 * @author imoreno
 * @since 2022-02-12
 */
public enum OperationType {
	ADD(AddOperation::new),
	SUBTRACT(SubtractOperation::new);

	final Supplier<? extends OperationFactory> operation;

	OperationType(final Supplier<? extends OperationFactory> operation) {
		this.operation = operation;
	}

	public OperationFactory doOperation() {
		return operation.get();
	}
}
