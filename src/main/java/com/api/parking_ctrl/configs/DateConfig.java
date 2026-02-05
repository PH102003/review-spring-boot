package com.api.parking_ctrl.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import com.fasterxml.jackson.databind.ObjectMapper;


//utilizar essa annotation para definir configurações específicas da aplicação
@Configuration

//classe de configuração para padronizar o formato de data e hora utilizado na aplicação
public class DateConfig {
    //o 'Z' indica que a data e hora estão no formato UTC
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    // converte datas java em um formato json padronizado para que a API sempre retorne datas consistentemente formatadas
    public static LocalDateTimeSerializer LOCAL_DATE_TIME_SERIALIZER = new LocalDateTimeSerializer(java.time.format.DateTimeFormatter.ofPattern(DATE_TIME_FORMAT));
    @Bean
    @Primary
    ObjectMapper objectMapper() {
        JavaTimeModule module = new JavaTimeModule();
        module.addSerializer(LOCAL_DATE_TIME_SERIALIZER);
        return new ObjectMapper().registerModule(module);
    }


}            
