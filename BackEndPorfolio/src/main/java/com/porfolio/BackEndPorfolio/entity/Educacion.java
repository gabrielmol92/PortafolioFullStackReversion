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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author GabrielPc
 */

@Entity
@Table (name="educacion")
public class Educacion implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ed_id")
    private Long id;
    
    @NotEmpty(message="Tiene que poner un nombre")
    @Length(max=20)
    @Column(name = "titulo")
    private String titulo;
    
    @NotEmpty(message="Tiene que poner un Apellido")
    @Length(max=20)
    @Column(name = "institucion")
    private String institucion;
    
    @Column(name="per_inicio")
    @NotBlank(message = "Debes ingresar un mail valido")
    private String periodo_inicio;
    
    @Column(name="per_fin")
    @NotBlank(message = "Debes ingresar un mail valido")
    private String periodo_final;
   
    @Column(name="img")
    private String img; 
    
    @Column(name="tipo")
    private String tipo;
    
    @Column(name="link")
    private String link;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="persona_id")
    private Persona persona;
    
    public Educacion() {
    }

    public Educacion(Long id, String titulo, String institucion, String periodo_inicio, String periodo_final, String img, String tipo, String link) {
        this.id = id;
        this.titulo = titulo;
        this.institucion = institucion;
        this.periodo_inicio = periodo_inicio;
        this.periodo_final = periodo_final;
        this.img = img;
        this.tipo = tipo;
        this.link = link;
    }

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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}

