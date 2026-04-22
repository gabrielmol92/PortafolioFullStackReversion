/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.BackEndPorfolio.controller;

import com.porfolio.BackEndPorfolio.dto.SoftSkillDto;
import com.porfolio.BackEndPorfolio.service.ISoftSkillService;
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
public class SoftSkillController {
    
     @Autowired
    private ISoftSkillService softSkillService;
    
     @PostMapping("/softSkill/new")
     public String createSoftSkill(@RequestBody SoftSkillDto softSkillDto){
       softSkillService.create(softSkillDto);
     return "Se ha creado la skill";
     }
    
     
     @DeleteMapping("/softSkill/delete/{id}")
     public String deleteSkill(@PathVariable Long id){
       softSkillService.deleteSkill(id);
     return "Se ha borrado el skill";
     }
     
     @PutMapping("/softSkill/edit/{id}")
     public String editSkill(@RequestBody SoftSkillDto softSkillDto,@PathVariable Long id){
       softSkillService.editSkill(softSkillDto, id);
     return "Se ha editado la skill";    
     }

     
     @GetMapping("/softSkill/listar")
    public List<SoftSkillDto> listarSoftSkill (){
     
    return  softSkillService.obtenerSkills();
    
        
    }

}
