package com.example.demo.event;

import io.github.alaugks.spring.messagesource.xliff.XliffTranslationMessageSource;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class AppStartupRunner implements ApplicationRunner {

    private final MessageSource messageSource;

    public AppStartupRunner(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public void run(ApplicationArguments args) {
        if (this.messageSource instanceof XliffTranslationMessageSource) {
            ((XliffTranslationMessageSource) this.messageSource).initCache();
        }
    }
}
