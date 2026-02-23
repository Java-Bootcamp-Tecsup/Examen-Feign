package com.demo.sunat.controller;

import com.demo.sunat.entity.SunatCompany;
import com.demo.sunat.entity.SunatConsulta;
//import com.demo.sunat.repository.SunatInMemoryRepository;
import com.demo.sunat.repository.SunatConsultaRepository;
import com.demo.sunat.service.SunatFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sunat")
public class SunatController {
    private final SunatFeignService sunatFeignService;
    private final SunatConsultaRepository sunatConsultaRepository;

    public SunatController(SunatFeignService sunatFeignService, SunatConsultaRepository sunatConsultaRepository) {
        this.sunatFeignService = sunatFeignService;
        this.sunatConsultaRepository = sunatConsultaRepository;
    }

    @GetMapping("/ruc/{ruc}")
    public SunatCompany feign(@PathVariable String ruc){
        if(!ruc.matches("\\d{11}")){
            throw new IllegalArgumentException("RUC debe tener exactamente 11 dígitos");
        }
        return sunatFeignService.consultarYGuardar(ruc);
    }

    @GetMapping("/ruc/{ruc}/consultas")
    public List<SunatConsulta> historial(@PathVariable String ruc) {
        return sunatConsultaRepository
                .findByRucConsultadoOrderByCreatedAtDesc(ruc)
                .stream()
                .toList();
    }

}
