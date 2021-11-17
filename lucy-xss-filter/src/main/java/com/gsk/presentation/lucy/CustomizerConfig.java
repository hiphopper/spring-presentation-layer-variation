package com.gsk.presentation.lucy;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.navercorp.lucy.security.xss.servletfilter.XssEscapeFilter;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;

@Configuration
public class CustomizerConfig {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return builder -> builder
                .deserializers(new JsonXssEscapeDeserializer());
    }

    static class JsonXssEscapeDeserializer extends StringDeserializer {
        private XssEscapeFilter xssEscapeFilter = XssEscapeFilter.getInstance();

        @Override
        public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException{
            return cleanData(p.getCurrentName(), super.deserialize(p, ctxt));
        }

        private String cleanData(String name, Object value) {
            final String url = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                    .getRequest().getRequestURI();

            return xssEscapeFilter.doFilter(url, name, String.valueOf(value));
        }
    }
}
