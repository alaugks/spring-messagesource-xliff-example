package io.github.alaugks.controller;

import io.github.alaugks.config.MessageSourceConfig;
import io.github.alaugks.config.ThymeleafConfig;
import io.github.alaugks.config.WebMvcConfigurerConfig;
import io.github.alaugks.thymeleaf.LanguageMenuPath;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;


@WebMvcTest()
@Import(HomeController.class)
@ContextConfiguration(classes = {
		ThymeleafConfig.class,
		WebMvcConfigurerConfig.class,
		MessageSourceConfig.class,
		LanguageMenuPath.class,
})
class HomeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void test_home_localeEn() throws Exception {
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get("/en/home"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		assertThat(result.getResponse().getContentAsString().indexOf("Postcode")).isPositive();
	}

	@Test
	void test_home_localeEnUs() throws Exception {
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get("/en-us/home"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		assertThat(result.getResponse().getContentAsString().indexOf("Zip code")).isPositive();
	}

	@Test
	void test_home_localeDe() throws Exception {
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get("/de/home"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		assertThat(result.getResponse().getContentAsString().indexOf("Postleitzahl")).isPositive();
	}

	@Test
	void test_translations_localeEn() throws Exception {
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get("/en/translations"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		assertThat(result.getResponse().getContentAsString().indexOf("Postcode")).isPositive();
	}

	@Test
	void test_translations_localeEnUs() throws Exception {
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get("/en-us/translations"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		assertThat(result.getResponse().getContentAsString().indexOf("Zip code")).isPositive();
	}

	@Test
	void test_translations_localeDe() throws Exception {
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get("/de/translations"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		assertThat(result.getResponse().getContentAsString().indexOf("Postleitzahl")).isPositive();
	}
}

