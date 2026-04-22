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
    
    
    private Long h_id;  
    private String nombre;
    private int nivel; 
    private String img;

    public HardSkillDto() {
    }

    public HardSkillDto(Long h_id, String nombre, int nivel, String img) {
        this.h_id = h_id;
        this.nombre = nombre;
        this.nivel = nivel;
        this.img = img;
    }

    public Long getH_id() {
        return h_id;
    }

    public void setH_id(Long h_id) {
        this.h_id = h_id;
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
   


