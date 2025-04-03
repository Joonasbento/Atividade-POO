package com.example.demo.model;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Enumerated(EnumType.STRING)
public enum Setor {
    ENGENHARIA, SAUDE, JURIDICO

}
