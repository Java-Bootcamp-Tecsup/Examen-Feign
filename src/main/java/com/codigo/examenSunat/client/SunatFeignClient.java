package com.codigo.examenSunat.client;

import com.codigo.examenSunat.dto.SunatRucResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "sunatClient", url = "https://api.decolecta.com")
public interface SunatFeignClient {

    @GetMapping("/v1/sunat/ruc")
    SunatRucResponse consultarRuc(@RequestParam("numero") String numero,
                                  @RequestHeader("Authorization") String authorization);
}
