package com.demo.sunat.entity;

import com.demo.sunat.enums.ResultadoConsulta;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "sunat_consulta")
public class SunatConsulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String rucConsultado;

    @Enumerated(EnumType.STRING)
    private ResultadoConsulta resultado;

    @Column(nullable = true)
    private String mensajeError;

    @Column(nullable = true)
    private String providerStatusCode;

    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = true)
    private SunatCompany company;

    public SunatCompany getCompany() {
        return company;
    }

    public void setCompany(SunatCompany company) {
        this.company = company;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getProviderStatusCode() {
        return providerStatusCode;
    }

    public void setProviderStatusCode(String providerStatusCode) {
        this.providerStatusCode = providerStatusCode;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public ResultadoConsulta getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoConsulta resultado) {
        this.resultado = resultado;
    }

    public String getRucConsultado() {
        return rucConsultado;
    }

    public void setRucConsultado(String rucConsultado) {
        this.rucConsultado = rucConsultado;
    }
}
