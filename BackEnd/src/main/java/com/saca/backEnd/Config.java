package com.saca.backEnd;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.filter.CorsFilter;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class Config {
    
    @Autowired
    private Environment env;

    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(getListProperty("allowed.origins"));
        config.setAllowedMethods(getListProperty("allowed.methods"));
        config.setAllowedHeaders(getListProperty("allowed.headers"));
        config.setAllowCredentials(getBooleanProperty("allow.credentials"));
        config.setMaxAge(getLongProperty("maxage"));
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    private List<String> getListProperty(String key){
        return Arrays.asList(env.getProperty(key).split(","));
    }

    private Boolean getBooleanProperty(String key){
        return Boolean.valueOf(env.getProperty(key));
    }

    private Long getLongProperty(String key){
        return Long.valueOf(env.getProperty(key));
    }
}
