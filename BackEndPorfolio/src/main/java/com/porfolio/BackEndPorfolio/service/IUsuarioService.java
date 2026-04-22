/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfolio.BackEndPorfolio.service;

import com.porfolio.BackEndPorfolio.dto.UsuarioDto;
import com.porfolio.BackEndPorfolio.entity.Usuario;


/**
 *
 * @author GabrielPc
 */
public interface IUsuarioService {
 
    public UsuarioDto registrar(UsuarioDto dto);
    public UsuarioDto buscarPorUsername(String username);
    public Usuario buscarEntidadPorUsername(String username);
    
}
