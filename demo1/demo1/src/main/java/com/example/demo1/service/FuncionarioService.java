package com.example.demo1.service;


import com.example.demo1.model.Funcionario;
import com.example.demo1.model.Usuario;
import com.example.demo1.repository.FuncionarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class FuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    public List<Usuario> listarFuncionarios(){
        return funcionarioRepository.findAll();

    }


    public Funcionario salvar(@Valid Funcionario funcionario){
        if ( funcionarioRepository.findByEmail(funcionario)){
            throw new RuntimeException("Funcionario já cadastrado");
        }
        return funcionarioRepository.save(funcionario);

    }

    public void excluir(Long id){
        Funcionario funcionario = funcionarioRepository.findBy(id)
                .orElseThrow(()-> new RuntimeException("Funcionario já excluido ou inexostente"));

        funcionarioRepository.deleteById(funcionario.getId);
    }
}
