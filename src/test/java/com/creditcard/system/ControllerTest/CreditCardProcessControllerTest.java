package com.creditcard.system.ControllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.creditcard.system.entity.CreditCard;
import com.creditcard.system.repository.CreditCardProcessRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@SpringBootTest()
@AutoConfigureMockMvc
public class CreditCardProcessControllerTest {

	
	@Autowired
    private MockMvc mockMvc;

	@MockBean
	CreditCardProcessRepository creditCardProcessRepository;
	
	//generic check for get method
	@Test
	public void testGetAllCreditCardDetailsStatus200()
			  throws Exception {

		mockMvc.perform(get("/cards/api/credit/get")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
			}
	
	//write test case to check 
	@Test
	public void testAddCreditCardDetailsStatus200()
			  throws Exception {

		CreditCard cc=new CreditCard();
		cc.setName("Emma Watson");
		cc.setCardNumber(79927398713L);
		cc.setBalance(0.00);
		cc.setCreditLimit(100.00);
		
		Mockito.when(creditCardProcessRepository.save(Mockito.any(CreditCard.class))).thenReturn(cc);

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(cc);

		mockMvc.perform(post("/cards/api/credit/add")
				.content(json)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
			}
}
