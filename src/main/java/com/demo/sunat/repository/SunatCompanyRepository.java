package com.demo.sunat.repository;

import com.demo.sunat.entity.SunatCompany;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SunatCompanyRepository extends JpaRepository<SunatCompany, Long> {
    Optional<SunatCompany> findByRuc(String ruc);
}
