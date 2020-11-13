package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void repro932() throws Exception {
		var generatedOpenAPIFile = mockMvc.perform(get("/v3/api-docs")).andReturn().getResponse().getContentAsString();

		assertThat(generatedOpenAPIFile)
				.contains(MyConfiguration.CUSTOM_DESCRIPTION);
	}
}
