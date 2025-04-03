package com.example.demo.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Enumerated(EnumType.STRING)
public enum Sexo {
    MASCULINO, FEMININO
}
