package com.example.demo1.controller;


import com.example.demo1.model.Usuario;
import com.example.demo1.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @GetMapping
    public List<Usuario> listarTodos(){
        return  usuarioService.listarUsarios();

    }
    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar (@Valid @RequestBody Usuario usuario) {
        usuarioService.salvar(usuario);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Usuário criado com sucesso."));
    }
        @DeleteMapping("/{id}")
                public ResponseEntity<Map<String, Object>> excluir(@PathVariable Long id){
            usuarioService.excluir(id);
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem", "Usuario deletado com sucesso."));
        }
    }



