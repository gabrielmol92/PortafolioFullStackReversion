/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.BackEndPorfolio.controller;

import com.porfolio.BackEndPorfolio.dto.PersonaDto;
import com.porfolio.BackEndPorfolio.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<PersonaDto> createPersona (@RequestBody PersonaDto persona){
           PersonaDto created = personaService.create(persona);
             return ResponseEntity
             .status(HttpStatus.CREATED)
             .body(created);
    
    }
    
    @DeleteMapping("/persona/delete/{id}")
    public ResponseEntity<Void> deletePersona (@PathVariable Long id){
       personaService.deletePersona(id);
       return ResponseEntity.noContent().build(); 
       
   
   }
   
   
   @PutMapping("/persona/editar/{id}")
  public ResponseEntity<PersonaDto> editPersona(@RequestBody PersonaDto personaDto,@PathVariable Long id)                              
          { 
       PersonaDto updated =  personaService.updatePersona(personaDto, id);
       return ResponseEntity.ok().body(updated);
   }
  
  
  @GetMapping("/persona/obtener")
  public PersonaDto getPersona() {
    return   personaService.getPersona((long)1);     
  }

   
    

  
}
