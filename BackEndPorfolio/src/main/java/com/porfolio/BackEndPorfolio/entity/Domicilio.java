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
//@Getter @Setter
//@Entity
//@Table(name="domicilio")
//public class Domicilio implements Serializable {
//    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    @Column(name="dom_id")
//    private Long id;
// 
//    @Column(name="calle")
//    private String Calle;
//
//    @Column(name="provincia")
//    private String Provincia;
//
//    @Column(name="ciudad") 
//    private String Ciudad;
// 
//    public Domicilio() {
//    }
//
//    public Domicilio(Long id, String Calle, String Provincia, String Ciudad) {
//        this.id = id;
//        this.Calle = Calle;
//        this.Provincia = Provincia;
//        this.Ciudad = Ciudad;
//    }
//    
    
@Entity
@Table(name="domicilio")
public class Domicilio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dom_id")
    private Long id;

    @Column(name = "calle")
    private String Calle;

    @Column(name = "provincia")
    private String Provincia;

    @Column(name = "ciudad")
    private String Ciudad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="persona_id")
    private Persona persona;
    
    // Constructor vacío
    public Domicilio() {
    }

    // Constructor con parámetros
    public Domicilio(Long id, String Calle, String Provincia, String Ciudad) {
        this.id = id;
        this.Calle = Calle;
        this.Provincia = Provincia;
        this.Ciudad = Ciudad;
    }

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return Calle;
    }

    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    public String getProvincia() {
        return Provincia;
    }

    public void setProvincia(String Provincia) {
        this.Provincia = Provincia;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }
    
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
}