/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.BackEndPorfolio.serviceImp;
import com.porfolio.BackEndPorfolio.entity.Usuario;
import com.porfolio.BackEndPorfolio.dto.UsuarioDto;
import com.porfolio.BackEndPorfolio.repository.UsuarioRepository;
import com.porfolio.BackEndPorfolio.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author GabrielPc
 */
    
@Service
public class UsuarioServiceImp implements IUsuarioService {

    @Autowired
    private UsuarioRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
public UsuarioDto registrar(UsuarioDto usuarioDto) {
    Usuario usuarioEntity = new Usuario();
    usuarioEntity.setUsername(usuarioDto.getUsername());
    usuarioEntity.setPassword(passwordEncoder.encode(usuarioDto.getPassword()));
    usuarioEntity.setRol("ROLE_USER");
    Usuario savedEntity = repo.save(usuarioEntity);
    UsuarioDto dto = new UsuarioDto();
    dto.setUsername(savedEntity.getUsername());  
    return dto;
}

    @Override
public UsuarioDto buscarPorUsername(String username) {
    Usuario user = repo.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("No existe"));
    UsuarioDto dto = new UsuarioDto();
    dto.setUsername(user.getUsername());
    return dto;
}

@Override
public Usuario buscarEntidadPorUsername(String username) {
        return repo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

}

