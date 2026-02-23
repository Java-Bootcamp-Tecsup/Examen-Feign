package com.demo.sunat.mapper;

import com.demo.sunat.dto.CompanyResponse;
import com.demo.sunat.dto.ConsultaResponse;
import com.demo.sunat.dto.SunatRucResponse;
import com.demo.sunat.entity.SunatCompany;
import com.demo.sunat.entity.SunatConsulta;
import com.demo.sunat.enums.CondicionDomicilio;
import com.demo.sunat.enums.EstadoContribuyente;

import java.util.List;

// Aqui se mapea el entity o model con el respsectivo dto
public class SunatMapper {
    public static SunatCompany toEntityCompany(SunatRucResponse dto){
        SunatCompany company = new SunatCompany();
        company.setRazonSocial(dto.razon_social());
        company.setRuc(dto.numero_documento());
        company.setDireccion(dto.direccion());
        company.setUbigeo(dto.ubigeo());
        company.setDistrito(dto.distrito());
        company.setProvincia(dto.provincia());
        company.setDepartamento(dto.departamento());
        company.setEsAgenteRetencion(dto.es_agente_retencion());
        company.setEsBuenContribyente(dto.es_buen_contribyente());
        company.setEstado(EstadoContribuyente.valueOf(dto.estado()));
        company.setCondicion(CondicionDomicilio.valueOf(dto.condicion()));
        return company;
    }

    public static CompanyResponse toCompanyResponse(SunatCompany entity) {

        List<SunatConsulta> consultas = entity.getConsultas()
                .stream()
                .toList();
        return new CompanyResponse(
                entity.getId(),
                entity.getRuc(),
                entity.getRazonSocial(),
                entity.getEstado().name(),
                entity.getCondicion().name(),
                entity.getDireccion(),
                entity.getUbigeo(),
                entity.getDepartamento(),
                entity.getProvincia(),
                entity.getDistrito(),
                entity.getEsAgenteRetencion(),
                entity.getEsBuenContribyente(),
                entity.getCreatedAt(),
                consultas
        );
    }

    public static ConsultaResponse toConsultaResponse(SunatConsulta entity) {
        return new ConsultaResponse(
                entity.getId(),
                entity.getRucConsultado(),
                entity.getResultado().name(),
                entity.getMensajeError(),
                entity.getProviderStatusCode(),
                entity.getCreatedAt()
        );
    }


}
