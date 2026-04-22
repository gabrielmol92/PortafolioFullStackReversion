/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfolio.BackEndPorfolio.service;

import com.porfolio.BackEndPorfolio.dto.PersonaDto;
import com.porfolio.BackEndPorfolio.entity.Persona;
import java.util.List;

/**
 *
 * @author GabrielPc
 */
public interface IPersonaService {
      
    public PersonaDto create(PersonaDto personaDto);
      
    public void deletePersona (Long id);
    
    public PersonaDto updatePersona (PersonaDto personaDto, Long id);
    
    public PersonaDto getPersona (Long id);


     
  
}