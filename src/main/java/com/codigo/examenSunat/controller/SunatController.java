package com.codigo.examenSunat.controller;

import com.codigo.examenSunat.entity.SunatCompany;
import com.codigo.examenSunat.repository.SunatInMemoryRepository;
import com.codigo.examenSunat.service.SunatFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/sunat")
public class SunatController {
    private final SunatFeignService sunatFeignService;
    private final SunatInMemoryRepository sunatInMemoryRepository;

    public SunatController(SunatFeignService sunatFeignService, SunatInMemoryRepository sunatInMemoryRepository) {
        this.sunatFeignService = sunatFeignService;
        this.sunatInMemoryRepository = sunatInMemoryRepository;
    }

    @GetMapping("/ruc/{ruc}")
    public SunatCompany feign(@PathVariable String ruc){
        if(!ruc.matches("\\d{11}")){
            throw new IllegalArgumentException("RUC debe tener exactamente 11 dígitos");
        }
        return sunatFeignService.consultarYGuardar(ruc);
    }

    @GetMapping("/company")
    public Collection<SunatCompany> listar() {
        return sunatInMemoryRepository.findAll();
    }

}
