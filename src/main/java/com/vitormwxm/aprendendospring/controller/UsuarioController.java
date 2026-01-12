package com.vitormwxm.aprendendospring.controller;

import com.vitormwxm.aprendendospring.business.UsuarioService;
import com.vitormwxm.aprendendospring.controller.dtos.UsuarioDTO;
import com.vitormwxm.aprendendospring.infraestructure.entities.Usuario;
import com.vitormwxm.aprendendospring.infraestructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Authenticator;

@RestController //diz ao spring que essa é a nossa controler e que ela vai observar o uso das uri e verbos https
@RequestMapping("/usuario") // aponta qual a uri da nossa controller
@RequiredArgsConstructor
public class UsuarioController {

    private  final UsuarioService usuarioService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<Usuario> salvaUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.salvaUsuario(usuario));
    }

    @PostMapping("/login")
    public String login(@RequestBody UsuarioDTO usuarioDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuarioDTO.getEmail(), usuarioDTO.getSenha())
        );

        return jwtUtil.generateToken(authentication.getName());
    }
}
