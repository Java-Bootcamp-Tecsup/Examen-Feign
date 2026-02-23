package com.codigo.examenSunat.config;

import com.codigo.examenSunat.repository.SunatInMemoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public SunatInMemoryRepository sunatInMemoryRepository(){
        return new SunatInMemoryRepository();
    }
}
