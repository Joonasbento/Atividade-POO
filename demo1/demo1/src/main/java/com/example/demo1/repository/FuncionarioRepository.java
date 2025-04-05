package com.example.demo1.repository;

import com.example.demo1.model.Funcionario;
import com.example.demo1.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Usuario,Long> {

Optional<Funcionario> findByEmail(String email);

}
