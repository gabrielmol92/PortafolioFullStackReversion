/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.BackEndPorfolio.serviceImp;

import com.porfolio.BackEndPorfolio.dto.EducacionDto;
import com.porfolio.BackEndPorfolio.entity.Educacion;
import com.porfolio.BackEndPorfolio.entity.Persona;
import com.porfolio.BackEndPorfolio.repository.EducacionRepository;
import com.porfolio.BackEndPorfolio.repository.PersonaRepository;
import com.porfolio.BackEndPorfolio.service.IEducacionService;
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
public class EducacionServiceImp implements IEducacionService {

    @Autowired
    private PersonaRepository personaRepository;
    
    @Autowired
    private EducacionRepository educacionRepository;
    
    @Autowired
    private Mapeo mapper;
    

    
    
    
    
    @Override
    public EducacionDto create(EducacionDto educacionDto) {
    Educacion educacionEntity = new Educacion();
    educacionEntity = (Educacion) mapper.convertToEntity(educacionDto, educacionEntity);
    Persona persona = personaRepository.findById(1L)
        .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
    educacionEntity.setPersona(persona);
    educacionEntity = educacionRepository.save(educacionEntity);
    return (EducacionDto) mapper.convertToDto(educacionEntity, new EducacionDto());
}

    @Override
    public void deleteEdu(Long id) {
        educacionRepository.deleteById(id);
    }

    @Override
    public EducacionDto updateEd(EducacionDto educacionDto, Long id) {
        Educacion educacion = educacionRepository.findById(id).orElse(null);      
         educacion.setInstitucion(educacionDto.getInstitucion());
         educacion.setPeriodo_inicio(educacionDto.getPeriodo_inicio());
         educacion.setPeriodo_final(educacionDto.getPeriodo_final());
         educacion.setTitulo(educacionDto.getTitulo());
         educacion.setLink(educacionDto.getLink());     
         Educacion updateEducacion = this.educacionRepository.save(educacion);
         EducacionDto educacionDtoU = new EducacionDto();
         educacionDtoU = (EducacionDto)mapper.convertToDto(updateEducacion, educacionDtoU);
    
         return educacionDtoU;
    }

    @Override
    public List<EducacionDto> obtenerEd() {
             ModelMapper modelMapper = new ModelMapper();
              List<Educacion> educacionList = this.educacionRepository.findAll();
	      List<EducacionDto> educacionDtos = modelMapper.map(educacionList, new TypeToken<List<EducacionDto>>() {}.getType());       
              return educacionDtos;
		 
    }
    
    
}
