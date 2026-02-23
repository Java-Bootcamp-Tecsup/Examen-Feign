package com.demo.sunat.dto;

import java.time.LocalDateTime;
import java.util.List;

public record CompanyResponse(
        Long id,
        String ruc,
        String razonSocial,
        String estado,
        String condicion,
        String direccion,
        String ubigeo,
        String departamento,
        String provincia,
        String distrito,
        Boolean esAgenteRetencion,
        Boolean esBuenContribyente,
        LocalDateTime createdAt,
        List<com.demo.sunat.entity.SunatConsulta> consultas
) {
}
