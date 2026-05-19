/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.BackEndPorfolio.dto;

/**
 *
 * @author GabrielPc
 */

public class SoftSkillDto implements _DTOEntity {

    private Long id;
    private String nombre;
    private String descripcion;

    public SoftSkillDto() {
    }

    public SoftSkillDto(Long id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "SoftSkillDto{" +
                "id=" + id +
                ", nombre=" + nombre +
                ", descripcion=" + descripcion +
                '}';
    }
}
    

