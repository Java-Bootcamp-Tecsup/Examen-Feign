package com.demo.sunat.dto;

import java.time.LocalDateTime;

public record ConsultaResponse(
        Long id,
        String rucConsultado,
        String resultado,
        String mensajeError,
        String providerStatusCode,
        LocalDateTime createdAt
) {
}
