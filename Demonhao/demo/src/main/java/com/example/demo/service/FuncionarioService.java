package com.example.demo.service;


import com.example.demo.model.Funcionario;
import com.example.demo.repository.FuncionarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class FuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }


    public List<Funcionario> listarFuncionarios() {
        return funcionarioRepository.findAll();

    }

    public Funcionario salvar(@Valid Funcionario funcionario){
        if (funcionarioRepository.findByEmail(funcionario.getEmail()).isPresent()){
            throw new RuntimeException("Email já Cadastrado");

        }
        return funcionarioRepository.save(funcionario);

    }

    public Funcionario atualizar(@Valid Funcionario funcionario){
        Funcionario funcionarioatualizar = funcionarioRepository.findByEmail(funcionario.getEamil()).orElseThrow(() -> new RuntimeException("Usuario não Cadastrado"));

        funcionarioatualizar.setNome(funcionario.getNome());
        funcionarioatualizar.setCpf(funcionario.getCpf());
        funcionarioatualizar.setRg(funcionario.getRg());
        funcionarioatualizar.setMatricula(funcionario.getMatricula());
        funcionarioatualizar.setDataNascimento(funcionario.getDataNascimento());
        funcionarioatualizar.setSetor(funcionario.getSetor());
        funcionarioatualizar.setSalario(funcionario.getSalario());
        funcionarioatualizar.setTelefone(funcionario.getTelefone());
        funcionarioatualizar.setEmail(funcionario.getEmail());
         return funcionarioRepository.save(funcionarioatualizar);


    }
    public void excluir (String email){
        Funcionario funcionario = funcionarioRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("Usuario não cadastrado!"));
        funcionarioRepository.deleteById(funcionario.getId());

    }
}

