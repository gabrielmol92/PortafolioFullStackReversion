/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.BackEndPorfolio.dto;

/**
 *
 * @author GabrielPc
 */
public class UsuarioDto implements _DTOEntity{
  //  private Long id;
    private String username;
    private String password;
  //  private String rol;

    public UsuarioDto() {
    }

    public UsuarioDto(Long id,String username, String password, String rol) {
     //   this.id = id;
        this.username = username;
        this.password = password;
      //  this.rol = rol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

  /*  public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }*/
    
    
}