package com.demo.sunat.service;

import com.demo.sunat.client.SunatFeignClient;
import com.demo.sunat.dto.SunatRucResponse;
import com.demo.sunat.entity.SunatCompany;
import com.demo.sunat.entity.SunatConsulta;
import com.demo.sunat.enums.ResultadoConsulta;
import com.demo.sunat.mapper.SunatMapper;
import com.demo.sunat.repository.SunatCompanyRepository;
import com.demo.sunat.repository.SunatConsultaRepository;
import com.demo.sunat.repository.SunatInMemoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SunatFeignService {
    private final SunatFeignClient sunatFeignClient;
    // private final SunatInMemoryRepository sunatInMemoryRepository;
    private final SunatCompanyRepository sunatCompanyRepository;
    private final SunatConsultaRepository sunatConsultaRepository;

    @Value("${decoleta.token}")
    private String token;

    public SunatFeignService(SunatFeignClient sunatFeignClient, SunatCompanyRepository sunatCompanyRepository, SunatConsultaRepository sunatConsultaRepository) {
        this.sunatFeignClient = sunatFeignClient;
        // this.sunatInMemoryRepository = sunatInMemoryRepository;
        this.sunatCompanyRepository = sunatCompanyRepository;
        this.sunatConsultaRepository = sunatConsultaRepository;
    }

    @Transactional
    public SunatCompany consultarYGuardar(String ruc){
        SunatConsulta consulta = new SunatConsulta();
        consulta.setRucConsultado(ruc);
        consulta.setResultado(ResultadoConsulta.SUCCESS);
        sunatConsultaRepository.save(consulta);
        return sunatCompanyRepository.findByRuc(ruc)
                .orElseGet(() -> {
                    String auth = "Bearer " + token;
                    SunatRucResponse dto = sunatFeignClient.consultarRuc(ruc,auth);
                    SunatCompany entity = SunatMapper.toEntityCompany(dto);
                    entity.setRuc(ruc);
                    // sunatCompanyRepository.save(entity);

                    return sunatCompanyRepository.save(entity);
                });
    }
}
