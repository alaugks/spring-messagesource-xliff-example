package io.github.alaugks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"io.github.alaugks.*"})
public class XliffMessageSourceExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(XliffMessageSourceExampleApplication.class, args);
	}
}
