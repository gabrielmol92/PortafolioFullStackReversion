/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.BackEndPorfolio.serviceImp;

import com.porfolio.BackEndPorfolio.dto.PersonaDto;
import com.porfolio.BackEndPorfolio.entity.Persona;
import com.porfolio.BackEndPorfolio.repository.PersonaRepository;
import com.porfolio.BackEndPorfolio.service.IPersonaService;
import com.porfolio.BackEndPorfolio.util.Mapeo;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author GabrielPc
 */
@Service
public class PersonaServiceImp implements IPersonaService{

    @Autowired
    private PersonaRepository personaRepository;
    
    @Autowired
    private Mapeo mapper;
    
    @Override
    public PersonaDto create(PersonaDto personaDto) {
       Persona personaEntity = new Persona();
        personaEntity = (Persona)mapper.convertToEntity(personaDto, personaEntity);
        personaEntity = personaRepository.save(personaEntity);
        return (PersonaDto)mapper.convertToDto(personaEntity, personaDto);
    }

    @Override
    public void deletePersona(Long id) {
         personaRepository.deleteById(id);
    }

    @Override
    public PersonaDto updatePersona(PersonaDto personaDto, Long id) {
        Persona persona = personaRepository.findById(id).orElse(null);
         
         persona.setNombre(personaDto.getNombre());
         persona.setApellido(personaDto.getApellido());
         persona.setEmail(personaDto.getEmail());
         persona.setImg(personaDto.getImg());
         persona.setTitulo(personaDto.getTitulo());
         
         Persona updatePersona = this.personaRepository.save(persona);
         PersonaDto personaDtoU = new PersonaDto();
         personaDtoU = (PersonaDto)mapper.convertToDto(updatePersona, personaDtoU);
    
         return personaDtoU;
    }

    @Override
    public PersonaDto getPersona(Long id) {
        
        Persona persona = personaRepository.findById(id).orElse(null);
        PersonaDto personaDto = new PersonaDto();  
        return (PersonaDto)mapper.convertToDto(persona, personaDto);   
                }   

     
}
