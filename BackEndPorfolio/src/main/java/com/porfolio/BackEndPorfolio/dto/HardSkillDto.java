/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.BackEndPorfolio.dto;

import com.porfolio.BackEndPorfolio.entity.Persona;
import java.io.Serializable;


/**
 *
 * @author GabrielPc
 */

public class HardSkillDto implements _DTOEntity {
    
    
    private Long id;  
    private String nombre;
    private int nivel; 
    private String img;

    public HardSkillDto() {
    }

    public HardSkillDto(Long id, String nombre, int nivel, String img) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
  
}
   


