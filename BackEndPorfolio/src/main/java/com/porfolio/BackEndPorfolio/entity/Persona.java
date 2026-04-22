package com.porfolio.BackEndPorfolio.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table (name="PERSONA")
public class Persona implements Serializable {
 

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @NotEmpty(message="Tiene que poner un nombre")
    @Length(max=20)
    @Column(name = "nombre")
    private String nombre;
    
    @NotEmpty(message="Tiene que poner un Apellido")
    @Length(max=20)
    @Column(name = "apellido")
    private String apellido;
    
    @Column(name="email")
    @NotBlank(message = "Debes ingresar un mail valido")
    private String email;
    
    @Column(name="titulo")        
    private String titulo;
    
    @Column(name="img")
    private String img;
    
    @OneToMany(mappedBy = "persona")    
    private List<Educacion> educacionList;    
    
  
 
    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, String email, String titulo, String img) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.titulo = titulo;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<Educacion> getEducacionList() {
        return educacionList;
    }

    public void setEducacionList(List<Educacion> educacionList) {
        this.educacionList = educacionList;
    }


    
}

