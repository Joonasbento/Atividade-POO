package com.example.ProjetoSpring.controller;

import com.example.ProjetoSpring.model.Usuario;
import com.example.ProjetoSpring.service.UsuarioService;
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
    public List<Usuario> listartodos(){
           return usuarioService.listarUsuarios();
    }

   /* @PostMapping
   public ResponseEntity<String> salvar(@Valid @RequestBody Usuario usuario){
   String mensagem = "Usuario "+ usuario.getNome()+ " cadastrado com sucesso";
        usuarioService.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(mensagem);
   */
        @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody Usuario usuario){
        usuarioService.salvar(usuario);
        //String mensagem = "Usuario "+ usuario.getNome()+ " cadastrado com sucesso";
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem","Usuário cadastrado com sucesso." ));
    }

    @PutMapping
    public ResponseEntity<Map<String, Object>>atualizar(@Valid @RequestBody Usuario usuario){
        usuarioService.atualizar(usuario);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem","Usuário ataualizado com sucesso."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar(@PathVariable Long id){
        usuarioService.excluir(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Usuário excluido com sucesso."));

    }
}
