package com.sanitas.calculator.infraestructure.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.sanitas.calculator.domain.operations.Operation;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class CalculatorControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	void getCalculatorController_addOK() throws Exception {
		String response = mockMvc.perform(get("/calculator/ADD")
						.param("arguments", "1,2"))
				.andExpect(status().is(HttpStatus.OK.value()))
				.andReturn().getResponse().getContentAsString();
		assertEquals(BigDecimal.valueOf(3.0), BigDecimal.valueOf(Double.parseDouble(response)));
	}

	@Test
	void getCalculatorController_addKO_tooFewArguments() throws Exception {
		String response = mockMvc.perform(get("/calculator/ADD")
						.param("arguments", "1"))
				.andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
				.andReturn().getResponse().getContentAsString();
		assertEquals(Operation.ARGUMENT_QUANTITY_ERROR_TEXT, response);
	}

	@Test
	void getCalculatorController_addKO_tooMuchArguments() throws Exception {
		String response = mockMvc.perform(get("/calculator/ADD")
						.param("arguments", "1,2,3"))
				.andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
				.andReturn().getResponse().getContentAsString();
		assertEquals(Operation.ARGUMENT_QUANTITY_ERROR_TEXT, response);
	}

	@Test
	void getCalculatorController_subtractOK() throws Exception {
		String response = mockMvc.perform(get("/calculator/SUBTRACT")
						.param("arguments", "1,2"))
				.andExpect(status().is(HttpStatus.OK.value()))
				.andReturn().getResponse().getContentAsString();
		assertEquals(BigDecimal.valueOf(-1.0), BigDecimal.valueOf(Double.parseDouble(response)));
	}

	@Test
	void getCalculatorController_subtractKO_tooFewArguments() throws Exception {
		String response = mockMvc.perform(get("/calculator/SUBTRACT")
						.param("arguments", "1"))
				.andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
				.andReturn().getResponse().getContentAsString();
		assertEquals(Operation.ARGUMENT_QUANTITY_ERROR_TEXT, response);
	}

	@Test
	void getCalculatorController_subtractKO_tooMuchArguments() throws Exception {
		String response = mockMvc.perform(get("/calculator/SUBTRACT")
						.param("arguments", "1,2,3"))
				.andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
				.andReturn().getResponse().getContentAsString();
		assertEquals(Operation.ARGUMENT_QUANTITY_ERROR_TEXT, response);
	}
}