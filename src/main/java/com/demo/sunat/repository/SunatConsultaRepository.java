package com.demo.sunat.repository;

import com.demo.sunat.entity.SunatCompany;
import com.demo.sunat.entity.SunatConsulta;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface SunatConsultaRepository extends JpaRepository<SunatConsulta, Long>{
    List<SunatConsulta> findByRucConsultadoOrderByCreatedAtDesc(String ruc);
}

