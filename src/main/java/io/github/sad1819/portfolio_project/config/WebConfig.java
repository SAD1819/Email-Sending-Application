package io.github.sad1819.portfolio_project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @SuppressWarnings("null")
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/send-email")
                .allowedOrigins("https://saurabh-dhara-portfolio.netlify.app")
                .allowedMethods("POST")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
