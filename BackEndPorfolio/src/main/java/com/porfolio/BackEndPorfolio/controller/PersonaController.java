/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.BackEndPorfolio.controller;

import com.porfolio.BackEndPorfolio.dto.PersonaDto;
import com.porfolio.BackEndPorfolio.entity.Persona;
import com.porfolio.BackEndPorfolio.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author GabrielPc
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    
    
     @Autowired
    private IPersonaService personaService;
    
    
    
    @PostMapping("/persona/new")
    public String createPersona (@RequestBody PersonaDto persona){
            personaService.create(persona);
        return "La persona fue creada";
    
    }
    
     @DeleteMapping("/persona/delete/{id}")
   public String deletePersona (@PathVariable Long id){
       personaService.deletePersona(id);
        return "Persona borrada";
       
   
   }
   
   
   @PutMapping("/persona/editar/{id}")
  public String editPersona(@RequestBody PersonaDto personaDto,@PathVariable Long id)                              
          { 
       personaService.updatePersona(personaDto, id);
       return "Se ha modificado la persona";
   }
  
  
  @GetMapping("/persona/obtener")
  public PersonaDto getPersona() {
    return   personaService.getPersona((long)1);
      
  }

   
    

  
}
