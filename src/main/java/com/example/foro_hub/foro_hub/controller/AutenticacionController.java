package com.example.foro_hub.foro_hub.controller;

import com.example.foro_hub.foro_hub.infra.security.DatosJWT;
import com.example.foro_hub.foro_hub.infra.security.TokenService;
import com.example.foro_hub.foro_hub.usuarios.DatosAutenticacionUsuario;
import com.example.foro_hub.foro_hub.usuarios.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario){
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.login(),
                datosAutenticacionUsuario.clave());
                var usuarioAuth = authenticationManager.authenticate(authToken);
                var JWTtoken = tokenService.generarToken((Usuario) usuarioAuth.getPrincipal());
                return ResponseEntity.ok(new DatosJWT(JWTtoken));
    }

}
