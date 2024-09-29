package io.github.alaugks.controller;

import io.github.alaugks.config.MessageSourceConfig;
import io.github.alaugks.config.ThymeleafConfig;
import io.github.alaugks.config.WebMvcConfigurerConfig;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
@Import(IndexController.class)
@ContextConfiguration(classes = {
		ThymeleafConfig.class,
		WebMvcConfigurerConfig.class,
		MessageSourceConfig.class
})
class IndexControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void test_index() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/"))
				.andExpect(MockMvcResultMatchers.redirectedUrl("/en/home"))
				.andExpect(MockMvcResultMatchers.status().is3xxRedirection())
				.andReturn();
	}

}

