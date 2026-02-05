package com.api.parking_ctrl.configs;

import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


//utilizar essa annotation para definir configurações específicas da aplicação

//classe de configuração para padronizar o formato de data e hora utilizado na aplicação
@Configuration
public class DateConfig {
    //o 'Z' indica que a data e hora estão no formato UTC
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    @Bean
    @Primary    
    ObjectMapper objectMapper() {
        JavaTimeModule module = new JavaTimeModule();
        // Usa o LocalDateTimeSerializer explicitamente com o padrão que inclui o Z
        module.addSerializer(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)));        return new ObjectMapper()
        .registerModule(module)
        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }


}            
