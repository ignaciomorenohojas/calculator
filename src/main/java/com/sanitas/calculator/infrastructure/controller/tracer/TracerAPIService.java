package com.sanitas.calculator.infrastructure.controller.tracer;

import org.springframework.stereotype.Component;

import io.corp.calculator.TracerAPI;
import io.corp.calculator.TracerImpl;

@Component
public class TracerAPIService implements TracerAPI {

	private final TracerImpl tracerImpl;

	public TracerAPIService() {
		tracerImpl = new TracerImpl();
	}

	@Override
	public <T> void trace(T result) {
		this.tracerImpl.trace(result);
	}
}
