/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.BackEndPorfolio.dto;



/**
 *
 * @author GabrielPc
 */

public class DomicilioDto implements _DTOEntity {

    private Long id;
    private String Calle;
    private String Provincia;
    private String Ciudad;

    public DomicilioDto() {
    }

    public DomicilioDto(Long id, String Calle, String Provincia, String Ciudad) {
        this.id = id;
        this.Calle = Calle;
        this.Provincia = Provincia;
        this.Ciudad = Ciudad;
    }

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

    @Override
    public String toString() {
        return "DomicilioDto{" +
                "id=" + id +
                ", Calle='" + Calle + '\'' +
                ", Provincia='" + Provincia + '\'' +
                ", Ciudad='" + Ciudad + '\'' +
                '}';
    }
}
    
    
