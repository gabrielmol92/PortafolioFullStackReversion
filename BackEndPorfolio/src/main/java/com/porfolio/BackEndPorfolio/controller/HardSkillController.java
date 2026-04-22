/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.BackEndPorfolio.controller;

import com.porfolio.BackEndPorfolio.dto.HardSkillDto;
import com.porfolio.BackEndPorfolio.service.IHardSkillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
public class HardSkillController {
    
    @Autowired
    private IHardSkillService hardSkillService;
    
     @PostMapping("/hardSkill/new")
     public String createHardSkill(@RequestBody HardSkillDto hardSkillDto){
       hardSkillService.create(hardSkillDto);
     return "Se ha creado la hardskill";
     }
    
     
     @DeleteMapping("/hardSkill/delete/{id}")
     public String deleteSkill(@PathVariable Long id){
       hardSkillService.deleteSkill(id);
     return "Se ha borrado el skill";
     }
     
     @PutMapping("/hardSkill/edit/{id}")
     public String editSkill(@RequestBody HardSkillDto hardSkillDto,@PathVariable Long id){
       hardSkillService.editSkill(hardSkillDto, id);
     return "Se ha editado la skill";    
     }

     
     @GetMapping("/hardSkill/listar")
    public List<HardSkillDto> listarHardSkill (){
     
    return  hardSkillService.obtenerSkills();
    
        
    }

}
     

