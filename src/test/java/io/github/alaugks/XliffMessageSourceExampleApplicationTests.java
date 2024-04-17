package io.github.alaugks;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "spring.main.allow-bean-definition-overriding=true")
public class XliffMessageSourceExampleApplicationTests {

    @Test
    void contextLoads() {
        assertTrue(true);
    }

}
