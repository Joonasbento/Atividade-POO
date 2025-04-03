package com.example.demo.model;


import jakarta.persistence.*;
import jdk.jfr.DataAmount;
@Entity
@Embeddable

public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String logradouro;
    private String numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String uf;


}
