package com.codigo.examenSunat.entity;

import com.codigo.examenSunat.enums.CondicionDomicilio;
import com.codigo.examenSunat.enums.EstadoContribuyente;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sunat_company")
public class SunatCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 11, max = 11)
    @Column(nullable = false, unique = true)
    @Pattern(regexp = "\\d{11}", message = "El RUC debe tener exactamente 11 dígitos")
    private String ruc;

    @Column(nullable = false)
    private String razonSocial;

    @Enumerated(EnumType.STRING)
    private EstadoContribuyente estado;

    @Enumerated(EnumType.STRING)
    private CondicionDomicilio condicion;

    private String direccion;
    private String ubigeo;
    private String departamento;
    private String provincia;
    private String distrito;
    private Boolean esAgenteRetencion;
    private Boolean esBuenContribyente;
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<SunatConsulta> consultas = new HashSet<>();

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public EstadoContribuyente getEstado() {
        return estado;
    }

    public void setEstado(EstadoContribuyente estado) {
        this.estado = estado;
    }

    public CondicionDomicilio getCondicion() {
        return condicion;
    }

    public void setCondicion(CondicionDomicilio condicion) {
        this.condicion = condicion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public Boolean getEsBuenContribyente() {
        return esBuenContribyente;
    }

    public void setEsBuenContribyente(Boolean esBuenContribyente) {
        this.esBuenContribyente = esBuenContribyente;
    }

    public Boolean getEsAgenteRetencion() {
        return esAgenteRetencion;
    }

    public void setEsAgenteRetencion(Boolean esAgenteRetencion) {
        this.esAgenteRetencion = esAgenteRetencion;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Set<SunatConsulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(Set<SunatConsulta> consultas) {
        this.consultas = consultas;
    }
}
