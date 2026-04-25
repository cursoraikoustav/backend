package com.ks.spring.micro.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class utilConfigs {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
