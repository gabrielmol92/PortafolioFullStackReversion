/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfolio.BackEndPorfolio.service;

import com.porfolio.BackEndPorfolio.dto.SoftSkillDto;
import java.util.List;

/**
 *
 * @author GabrielPc
 */
public interface ISoftSkillService {
 
    public SoftSkillDto create (SoftSkillDto softSkillDto);
    
    public void deleteSkill (Long id);
    
    public SoftSkillDto editSkill (SoftSkillDto softSkillDto, Long id);
    
    public List<SoftSkillDto> obtenerSkills ();
    
}
