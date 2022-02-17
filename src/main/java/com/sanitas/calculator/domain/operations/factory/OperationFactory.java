package com.sanitas.calculator.domain.operations.factory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sanitas.calculator.domain.operations.Operation;

/**
 * @author imoreno
 * @since 2022-02-17
 */
@Component
public class OperationFactory extends OperationsContentFactory<Operation> {

	public OperationFactory(@Autowired List<Operation> supportableInstances) {
		super(supportableInstances);
	}
}
