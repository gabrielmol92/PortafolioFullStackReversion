/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.BackEndPorfolio.dto;

import java.io.Serializable;


/**
 *
 * @author GabrielPc
 */

public class SoftSkillDto implements _DTOEntity {

    private Long s_id;
    private String nombre;
    private String descripcion;

    public SoftSkillDto() {
    }

    public SoftSkillDto(Long s_id, String nombre, String descripcion) {
        this.s_id = s_id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Long getS_id() {
        return s_id;
    }

    public void setS_id(Long s_id) {
        this.s_id = s_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "SoftSkillDto{" +
                "s_id=" + s_id +
                ", nombre=" + nombre +
                ", descripcion=" + descripcion +
                '}';
    }
}
    

