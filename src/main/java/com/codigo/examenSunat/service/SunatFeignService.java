package com.codigo.examenSunat.service;

import com.codigo.examenSunat.client.SunatFeignClient;
import com.codigo.examenSunat.dto.ConsultaResponse;
import com.codigo.examenSunat.dto.SunatRucResponse;
import com.codigo.examenSunat.entity.SunatCompany;
import com.codigo.examenSunat.mapper.SunatMapper;
import com.codigo.examenSunat.repository.SunatCompanyRepository;
import com.codigo.examenSunat.repository.SunatInMemoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SunatFeignService {
    private final SunatFeignClient sunatFeignClient;
    private final SunatInMemoryRepository sunatInMemoryRepository;
    private final SunatCompanyRepository sunatCompanyRepository;

    @Value("${decoleta.token}")
    private String token;

    public SunatFeignService(SunatFeignClient sunatFeignClient, SunatInMemoryRepository sunatInMemoryRepository, SunatCompanyRepository sunatCompanyRepository) {
        this.sunatFeignClient = sunatFeignClient;
        this.sunatInMemoryRepository = sunatInMemoryRepository;
        this.sunatCompanyRepository = sunatCompanyRepository;
    }

    @Transactional
    public SunatCompany consultarYGuardar(String ruc){
        return sunatInMemoryRepository.findByRuc(ruc)
                .orElseGet(() -> {
                    String auth = "Bearer " + token;
                    SunatRucResponse dto = sunatFeignClient.consultarRuc(ruc,auth);
                    SunatCompany entity = SunatMapper.toEntityCompany(dto);
                    entity.setRuc(ruc);
                    sunatCompanyRepository.save(entity);

                    return sunatInMemoryRepository.save(entity);
                });
    }
}
