package com.bntech.googleintegrator.googleintegrator.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SearchRecordRepository extends JpaRepository<SearchRecord, Integer> {
    List<SearchRecord> findAll();
    Optional<SearchRecord> findById(Integer id);
}
