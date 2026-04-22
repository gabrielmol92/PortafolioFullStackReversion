/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.BackEndPorfolio.serviceImp;

import com.porfolio.BackEndPorfolio.dto.HardSkillDto;
import com.porfolio.BackEndPorfolio.entity.HardSkill;
import com.porfolio.BackEndPorfolio.repository.HardSkillRepository;
import com.porfolio.BackEndPorfolio.service.IHardSkillService;
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
public class HardSkillServiceImp implements IHardSkillService {

    @Autowired
    private HardSkillRepository hardSkillRepository;
    
    @Autowired
    private Mapeo mapper;
    
    @Override
    public HardSkillDto create(HardSkillDto hardSkillDto) {
        HardSkill hardSkillEntity = new HardSkill();
        hardSkillEntity = (HardSkill)mapper.convertToEntity(hardSkillDto, hardSkillEntity);
        hardSkillEntity = hardSkillRepository.save(hardSkillEntity);
        return (HardSkillDto)mapper.convertToDto(hardSkillEntity, hardSkillDto);
    }

    @Override
    public void deleteSkill(Long id) {
        hardSkillRepository.deleteById(id);
    
    }
    
    @Override
    public HardSkillDto editSkill(HardSkillDto hardSkillDto, Long id) {
          HardSkill hardSkill = hardSkillRepository.findById(id).orElse(null);
         
         hardSkill.setNombre(hardSkillDto.getNombre());
         hardSkill.setNivel(hardSkillDto.getNivel());
         hardSkill.setImg(hardSkillDto.getImg());
        
         
         HardSkill updateHardSkill = this.hardSkillRepository.save(hardSkill);
         HardSkillDto hardSkillDtoU = new HardSkillDto();
         hardSkillDtoU = (HardSkillDto)mapper.convertToDto(updateHardSkill, hardSkillDtoU);
    
         return hardSkillDtoU;
    }
    
    @Override
    public List<HardSkillDto> obtenerSkills() {
         ModelMapper modelMapper = new ModelMapper();
              List<HardSkill> hardSkillList = this.hardSkillRepository.findAll();
	      List<HardSkillDto> hardSkillDtos = modelMapper.map(hardSkillList, new TypeToken<List<HardSkillDto>>() {}.getType());       
              return hardSkillDtos;

    }
    
}
