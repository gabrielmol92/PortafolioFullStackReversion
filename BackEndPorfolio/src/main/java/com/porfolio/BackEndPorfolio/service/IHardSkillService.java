/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfolio.BackEndPorfolio.service;

import com.porfolio.BackEndPorfolio.dto.HardSkillDto;
import java.util.List;

/**
 *
 * @author GabrielPc
 */
public interface IHardSkillService {
    
    public HardSkillDto create (HardSkillDto hardSkillDto);
    
    public void deleteSkill (Long id);
    
    public HardSkillDto editSkill (HardSkillDto hardSkillDto, Long id);
    
    public List<HardSkillDto> obtenerSkills ();
    
}
