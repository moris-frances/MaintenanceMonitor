package com.fhtw.maintenancemonitor;


import com.fhtw.maintenancemonitor.service.MessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class MaintenanceMonitorApplicationTests {

	@Autowired
	private MockMvc mockMvc;


	@Autowired
	MessageService messageService;

	@BeforeEach
	void clear(){
		messageService.resetMessage();
	}
	@Test
	public void getMessageTest() throws Exception {
		RequestBuilder getRequest = MockMvcRequestBuilders.get("/api/message");
		mockMvc.perform(getRequest)
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.valueOf("text/plain;charset=UTF-8")))
				.andExpect(content().string("Everything works as expected"));
	}

	@Test
	public void resetMessageTest() throws Exception {
		RequestBuilder putRequest = MockMvcRequestBuilders.put("/api/message/reset");
		mockMvc.perform(putRequest).andExpect(status().isOk());
		String expected = "Everything works as expected";
		String actual = messageService.getMessage();
		assertEquals(expected, actual);
	}

}
