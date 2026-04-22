/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfolio.BackEndPorfolio.repository;
import com.porfolio.BackEndPorfolio.entity.Usuario;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author GabrielPc
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}