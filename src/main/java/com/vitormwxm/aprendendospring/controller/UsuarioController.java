package com.vitormwxm.aprendendospring.controller;

import com.vitormwxm.aprendendospring.business.UsuarioService;
import com.vitormwxm.aprendendospring.infraestructure.entities.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //diz ao spring que essa é a nossa controler e que ela vai observar o uso das uri e verbos https
@RequestMapping("/usuario") // aponta qual a uri da nossa controller
@RequiredArgsConstructor
public class UsuarioController {

    private  final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> salvaUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.salvaUsuario(usuario));
    }
}
