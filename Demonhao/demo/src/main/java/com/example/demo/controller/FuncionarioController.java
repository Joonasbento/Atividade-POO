package com.example.demo.controller;


import com.example.demo.model.Funcionario;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repository.FuncionarioRepository;

import java.util.Optional;

@RestController
@RequestMapping ("/ funcionarios")

public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;


    @PostMapping
    public Funcionario criarFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @GetMapping
    public List<Funcionario> listarFuncionarios() {
        return funcionarioRepository.listarFuncionarios();

    }

    @GetMapping ("/{id}")
    public Optional<Funcionario> buscarFuncionario(@PathVariable Long id) {
        return funcionarioRepository.findById(id);
    }
}
