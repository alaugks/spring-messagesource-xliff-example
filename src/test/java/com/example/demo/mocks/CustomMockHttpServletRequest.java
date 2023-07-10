package com.example.demo.mocks;

import org.springframework.mock.web.MockHttpServletRequest;

import java.util.Locale;

public class CustomMockHttpServletRequest extends MockHttpServletRequest {
    public Locale getLocale() {
        return Locale.forLanguageTag("");
    }
}
