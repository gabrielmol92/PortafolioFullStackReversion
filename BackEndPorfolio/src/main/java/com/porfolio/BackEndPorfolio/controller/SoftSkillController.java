/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.BackEndPorfolio.controller;

import com.porfolio.BackEndPorfolio.dto.SoftSkillDto;
import com.porfolio.BackEndPorfolio.service.ISoftSkillService;
import java.util.List;
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
public class SoftSkillController {
    
     @Autowired
    private ISoftSkillService softSkillService;
    
     @PostMapping("/softSkill/new")
     public ResponseEntity<SoftSkillDto> createSoftSkill(@RequestBody SoftSkillDto softSkillDto){
       SoftSkillDto created = softSkillService.create(softSkillDto);
     return ResponseEntity
             .status(HttpStatus.CREATED)
             .body(created);
     }
    
     
     @DeleteMapping("/softSkill/delete/{id}")
     public ResponseEntity<Void> deleteSkill(@PathVariable Long id){
       softSkillService.deleteSkill(id);
      return ResponseEntity.noContent().build(); 
     }
     
     @PutMapping("/softSkill/update/{id}")
     public ResponseEntity<SoftSkillDto> editSkill(@RequestBody SoftSkillDto softSkillDto,@PathVariable Long id){
       SoftSkillDto updated = softSkillService.editSkill(softSkillDto, id);
         return ResponseEntity.ok().body(updated) ;    
     }

     
     @GetMapping("/softSkill/listar")
    public List<SoftSkillDto> listarSoftSkill (){
    return  softSkillService.obtenerSkills();        
    }

}
