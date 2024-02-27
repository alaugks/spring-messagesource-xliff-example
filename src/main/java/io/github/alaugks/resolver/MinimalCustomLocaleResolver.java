package io.github.alaugks.resolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.i18n.SimpleLocaleContext;
import org.springframework.web.servlet.i18n.AbstractLocaleResolver;

import java.util.Locale;

public class MinimalCustomLocaleResolver extends AbstractLocaleResolver {
    static final String LOCALE_ATTRIBUTE = MinimalCustomLocaleResolver.class.getName() + ".LOCALE";
    HttpServletRequest request;

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        Object localAttribute = this.request.getAttribute(LOCALE_ATTRIBUTE);
        if (localAttribute != null) {
            return (Locale) this.request.getAttribute(LOCALE_ATTRIBUTE);
        }

        if (request.getLocale() != null) {
            return request.getLocale();
        }

        return this.getDefaultLocale();
    }

    @Override
    public void setLocale(HttpServletRequest request,
                          HttpServletResponse response,
                          Locale locale
    ) {
        request.setAttribute(LOCALE_ATTRIBUTE, new SimpleLocaleContext(locale).getLocale());
        this.request = request;
    }
}
