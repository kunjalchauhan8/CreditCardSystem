package com.creditcard.system.ControllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest()
@AutoConfigureMockMvc
public class CreditCardProcessControllerTest {

	
	@Autowired
    private MockMvc mockMvc;

	
	@Test
	public void testGetAllCreditCardDetailsStatus200()
			  throws Exception {

		mockMvc.perform(get("/cards/api/credit/get")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
			}
}
