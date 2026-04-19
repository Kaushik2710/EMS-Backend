package com.ems.Config;

import com.ems.StringToAddressConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${ems.cors.allowed-origin}")
    private String allowedOrigin;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToAddressConverter());
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(allowedOrigin)
                .allowedMethods("*")
                .allowCredentials(true);
    }
}
