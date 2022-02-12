package com.sanitas.calculator.infraestructure.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.sanitas.calculator.domain.enums.OperationType;
import com.sanitas.calculator.domain.operations.OperationFactory;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getOperationTypes_OK() throws Exception {
		String response = mockMvc.perform(get("/calculator/operation-types"))
				.andExpect(status().is(HttpStatus.OK.value()))
				.andReturn().getResponse().getContentAsString();
		assertEquals(OperationType.values().length, response.split(",").length);
	}

	@Test
	public void getCalculatorController_addOK() throws Exception {
		String response = mockMvc.perform(get("/calculator/ADD")
						.param("arguments", "1,2"))
				.andExpect(status().is(HttpStatus.OK.value()))
				.andReturn().getResponse().getContentAsString();
		assertEquals(Double.valueOf(3), Double.valueOf(response));
	}

	@Test
	public void getCalculatorController_addKO_tooFewArguments() throws Exception {
		String response = mockMvc.perform(get("/calculator/ADD")
						.param("arguments", "1"))
				.andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
				.andReturn().getResponse().getContentAsString();
		assertEquals(OperationFactory.ARGUMENT_QUANTITY_ERROR_TEXT, response);
	}

	@Test
	public void getCalculatorController_addKO_tooMuchArguments() throws Exception {
		String response = mockMvc.perform(get("/calculator/ADD")
						.param("arguments", "1,2,3"))
				.andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
				.andReturn().getResponse().getContentAsString();
		assertEquals(OperationFactory.ARGUMENT_QUANTITY_ERROR_TEXT, response);
	}

	@Test
	public void getCalculatorController_subtractOK() throws Exception {
		String response = mockMvc.perform(get("/calculator/SUBTRACT")
						.param("arguments", "1,2"))
				.andExpect(status().is(HttpStatus.OK.value()))
				.andReturn().getResponse().getContentAsString();
		assertEquals(Double.valueOf(-1), Double.valueOf(response));
	}

	@Test
	public void getCalculatorController_subtractKO_tooFewArguments() throws Exception {
		String response = mockMvc.perform(get("/calculator/SUBTRACT")
						.param("arguments", "1"))
				.andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
				.andReturn().getResponse().getContentAsString();
		assertEquals(OperationFactory.ARGUMENT_QUANTITY_ERROR_TEXT, response);
	}

	@Test
	public void getCalculatorController_subtractKO_tooMuchArguments() throws Exception {
		String response = mockMvc.perform(get("/calculator/SUBTRACT")
						.param("arguments", "1,2,3"))
				.andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
				.andReturn().getResponse().getContentAsString();
		assertEquals(OperationFactory.ARGUMENT_QUANTITY_ERROR_TEXT, response);
	}
}