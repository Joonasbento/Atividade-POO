package com.example.ProjetoSpring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tab_endereco")
public class Endereco {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @NotBlank(message = "O endereço é obrigatorio.")
     private String logradouro;

     @NotBlank(message = "O numero da residencia é obrigatorio")
     private String numero;

     @NotBlank(message = "A cidade de oigem é obrigatoria")
     private String cidade;

    public Endereco() {
    }

    public Endereco(String cidade, Long id, String logradouro, String numero) {
        this.cidade = cidade;
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
    }

    public @NotBlank(message = "A cidade de oigem é obrigatoria") String getCidade() {
        return cidade;
    }

    public void setCidade(@NotBlank(message = "A cidade de oigem é obrigatoria") String cidade) {
        this.cidade = cidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "O endereço é obrigatorio.") String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(@NotBlank(message = "O endereço é obrigatorio.") String logradouro) {
        this.logradouro = logradouro;
    }

    public @NotBlank(message = "O numero da residencia é obrigatorio") String getNumero() {
        return numero;
    }

    public void setNumero(@NotBlank(message = "O numero da residencia é obrigatorio") String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "cidade='" + cidade + '\'' +
                ", id=" + id +
                ", logradouro='" + logradouro + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
