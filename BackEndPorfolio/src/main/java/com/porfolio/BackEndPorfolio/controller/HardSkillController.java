/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.BackEndPorfolio.controller;

import com.porfolio.BackEndPorfolio.dto.HardSkillDto;
import com.porfolio.BackEndPorfolio.service.IHardSkillService;
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
public class HardSkillController {
    
    @Autowired
    private IHardSkillService hardSkillService;
    
     @PostMapping("/hardSkill/new")
     public ResponseEntity<HardSkillDto> createHardSkill(@RequestBody HardSkillDto hardSkillDto){
      HardSkillDto created = hardSkillService.create(hardSkillDto);
     return ResponseEntity
             .status(HttpStatus.CREATED)
             .body(created);
     }
    
     
     @DeleteMapping("/hardSkill/delete/{id}")
     public ResponseEntity<Void> deleteSkill(@PathVariable Long id){
       hardSkillService.deleteSkill(id);
      return ResponseEntity.noContent().build(); 
     }
     
     @PutMapping("/hardSkill/update/{id}")
     public ResponseEntity<HardSkillDto> editSkill(@RequestBody HardSkillDto hardSkillDto,@PathVariable Long id){
      HardSkillDto updated = hardSkillService.editSkill(hardSkillDto, id);
     return ResponseEntity.ok().body(updated) ;        
     }

     
     @GetMapping("/hardSkill/listar")
    public List<HardSkillDto> listarHardSkill (){
     
    return  hardSkillService.obtenerSkills();
    
        
    }

}
     

