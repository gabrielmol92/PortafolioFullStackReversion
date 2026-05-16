/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.BackEndPorfolio.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 *
 * @author GabrielPc
 */

@Entity
@Table(name="hardskills")
public class HardSkill implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="nivel")
    private int nivel;
    
    @Column(name="icono")
    private String img;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="persona_id")
    private Persona persona;
    
    public HardSkill() {
    }

    public HardSkill(Long id, String nombre, int nivel, String img) {
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
    
      public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
            
}

