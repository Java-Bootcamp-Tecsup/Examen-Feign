package com.codigo.examenSunat.mapper;

import com.codigo.examenSunat.dto.CompanyResponse;
import com.codigo.examenSunat.dto.SunatRucResponse;
import com.codigo.examenSunat.entity.SunatCompany;
import com.codigo.examenSunat.entity.SunatConsulta;
import com.codigo.examenSunat.enums.CondicionDomicilio;
import com.codigo.examenSunat.enums.EstadoContribuyente;

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
}
