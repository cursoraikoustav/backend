package com.ks.spring.micro.Utill;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class Converter {
    private final ObjectMapper objectMapper;
    private final ModelMapper modelMapper;
    public Converter(ObjectMapper objectMapper, ModelMapper modelMapper) {
        this.objectMapper = objectMapper;
        this.modelMapper = modelMapper;
    }

    public <T> String convertToJson(T dto) {
        try {
            return objectMapper.writeValueAsString(dto);
        } catch (Exception e) {
            throw new RuntimeException("Error converting DTO to JSON", e);
        }
    }

    public <S, T> T convert(S source, Class<T> targetClass) {
        return (source == null) ? null : modelMapper.map(source, targetClass);
    }

}

