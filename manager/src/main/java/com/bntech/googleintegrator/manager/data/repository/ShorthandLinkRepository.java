package com.bntech.googleintegrator.manager.data.repository;


import com.bntech.googleintegrator.manager.data.persistence.ShorthandLink;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShorthandLinkRepository extends JpaRepository<ShorthandLink, String> {
    List<ShorthandLink> findAll();
    Optional<ShorthandLink> findById(String id);

    @Modifying
    @Transactional
    @Query("DELETE FROM ShorthandLink s WHERE s.createdAt < :expiryDate")
    void deleteAllCreatedBefore(@Param("expiryDate") Instant expiryDate);
}
