package com.example.demo.model;


import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;
    private String cpf;
    private String rg;
    private String matricula;
    private String dataNascimento;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Enumerated(EnumType.STRING)
        private Setor setor;


    private double salario;
    private String telefone;
    private  String email;

    @Embedded
    private Endereco endereco;
}
