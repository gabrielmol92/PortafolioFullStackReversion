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

public class EducacionDto implements _DTOEntity {
    
    private Long id;
    private String titulo;
    private String institucion;
    private String periodo_inicio;
    private String periodo_final;
    private String img;
    private String tipo;
    private String link;

    public EducacionDto() {
    }

    public EducacionDto(Long id, String titulo, String institucion, String periodo_inicio, String periodo_final, String img, String tipo, String link) {
        this.id = id;
        this.titulo = titulo;
        this.institucion = institucion;
        this.periodo_inicio = periodo_inicio;
        this.periodo_final = periodo_final;
        this.img = img;
        this.tipo = tipo;
        this.link = link;
    }

    @Override
    public String toString() {
        return "EducacionDto{" + "id=" + id + ", titulo=" + titulo + ", institucion=" + institucion + ", periodo_inicio=" + periodo_inicio + ", periodo_final=" + periodo_final + ", img=" + img +  ", tipo=" + tipo +   ", link=" + link +  '}';
    }

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getPeriodo_inicio() {
        return periodo_inicio;
    }

    public void setPeriodo_inicio(String periodo_inicio) {
        this.periodo_inicio = periodo_inicio;
    }

    public String getPeriodo_final() {
        return periodo_final;
    }

    public void setPeriodo_final(String periodo_final) {
        this.periodo_final = periodo_final;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
     public String getLink() {
        return link;
    }
    
    public void setLink(String link) {
        this.link = link;
    }
}

    
    


     

