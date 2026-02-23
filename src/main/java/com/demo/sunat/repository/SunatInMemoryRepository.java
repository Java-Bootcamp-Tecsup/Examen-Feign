package com.demo.sunat.repository;

import com.demo.sunat.entity.SunatCompany;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SunatInMemoryRepository {
    private final Map<Long, SunatCompany> data = new HashMap<>();
    private Long sequence = 1L;

    public Optional<SunatCompany> findByRuc(String ruc) {
        return data.values()
                .stream()
                .filter(company -> company.getRuc().equals(ruc))
                .findFirst();
    }

    public Optional<SunatCompany> findById(Long id){
        return Optional.ofNullable(data.get(id));
    }

    public Collection<SunatCompany> findAll() {
        return data.values();
    }

    public SunatCompany save(SunatCompany company){
        if (company.getId() == null) {
            company.setId(sequence++);
        }
        data.put(company.getId(), company);
        return company;
    }
}
