/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.BackEndPorfolio.serviceImp;

import com.porfolio.BackEndPorfolio.dto.SoftSkillDto;
import com.porfolio.BackEndPorfolio.entity.Persona;
import com.porfolio.BackEndPorfolio.entity.SoftSkill;
import com.porfolio.BackEndPorfolio.repository.PersonaRepository;
import com.porfolio.BackEndPorfolio.repository.SoftSkillRepository;
import com.porfolio.BackEndPorfolio.service.ISoftSkillService;
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
public class SoftSkillServiceImp implements ISoftSkillService  {

    @Autowired
    private PersonaRepository personaRepository;
       
    @Autowired
    private SoftSkillRepository softSkillRepository;
    
    @Autowired
    private Mapeo mapper;
    
    @Override
public SoftSkillDto create(SoftSkillDto softSkillDto) {
    // 1. Crear entidad
    SoftSkill softSkillEntity = new SoftSkill();
    // 2. Mapear campos simples manualmente
    softSkillEntity.setNombre(softSkillDto.getNombre());
    softSkillEntity.setDescripcion(softSkillDto.getDescripcion());
    // 3. Asignar persona fija (id = 1)
    Persona persona = personaRepository.findById(1L)
        .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
    softSkillEntity.setPersona(persona);
    // 4. Guardar en base de datos
    SoftSkill savedEntity = softSkillRepository.save(softSkillEntity);
    // 5. Convertir a DTO de salida
    SoftSkillDto dto = new SoftSkillDto();
    dto.setNombre(savedEntity.getNombre());
    dto.setDescripcion(savedEntity.getDescripcion());
    // si tenés id en el DTO
    
    dto.setId(savedEntity.getId());
    return dto;
}
         
    @Override
    public void deleteSkill(Long id) {
        
    }
    
    
    @Override
    public SoftSkillDto editSkill(SoftSkillDto softSkillDto, Long id) {
        SoftSkill softSkill = softSkillRepository.findById(id).orElse(null);
         
         softSkill.setNombre(softSkillDto.getNombre());
         softSkill.setDescripcion(softSkillDto.getDescripcion());
         
         SoftSkill updateSoftSkill = this.softSkillRepository.save(softSkill);
         SoftSkillDto softSkillDtoU = new SoftSkillDto();
         softSkillDtoU = (SoftSkillDto)mapper.convertToDto(updateSoftSkill, softSkillDtoU);
    
         return softSkillDtoU;
        
    }

    
    
    @Override
    public List<SoftSkillDto> obtenerSkills() {
               
              ModelMapper modelMapper = new ModelMapper();
              List<SoftSkill> educacionList = this.softSkillRepository.findAll();
	      List<SoftSkillDto> educacionDtos = modelMapper.map(educacionList, new TypeToken<List<SoftSkillDto>>() {}.getType());       
              return educacionDtos;        
        
    }
    
}
