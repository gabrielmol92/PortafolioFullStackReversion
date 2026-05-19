    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.BackEndPorfolio.controller;

import com.porfolio.BackEndPorfolio.dto.AuthResponseDto;
import com.porfolio.BackEndPorfolio.dto.LoginDto;
import com.porfolio.BackEndPorfolio.service.IUsuarioService;
import com.porfolio.BackEndPorfolio.entity.Usuario;
import org.springframework.http.HttpStatus;
import com.porfolio.BackEndPorfolio.dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.porfolio.BackEndPorfolio.security.JwtUtil;

/**
 *
 * @author GabrielPc
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // REGISTRO
    @PostMapping("/register")
    public UsuarioDto register(@RequestBody UsuarioDto dto) {
        return usuarioService.registrar(dto);
    }

    // LOGIN
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto req) {
        Usuario user = usuarioService.buscarEntidadPorUsername(req.getUsername());
        if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        String token = jwtUtil.generateToken(user.getUsername());
        return ResponseEntity.ok(new AuthResponseDto(token));
    }
}