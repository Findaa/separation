package com.bntech.googleintegrator.googleintegrator.persistance;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SearchRecord {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String url;
}
