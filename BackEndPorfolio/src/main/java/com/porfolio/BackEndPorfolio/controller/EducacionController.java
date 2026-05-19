/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.BackEndPorfolio.controller;

import com.porfolio.BackEndPorfolio.dto.EducacionDto;
import com.porfolio.BackEndPorfolio.service.IEducacionService;
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
public class EducacionController {
    
    @Autowired
    private IEducacionService educacionService;
    
    @PostMapping("/educacion/new")
    public ResponseEntity<EducacionDto> createEd (@RequestBody EducacionDto educacionDto){
      EducacionDto created =  educacionService.create(educacionDto); 
     return ResponseEntity
             .status(HttpStatus.CREATED)
             .body(created);
    }
    
    
    @DeleteMapping("/educacion/delete/{id}")
    public ResponseEntity<Void> deleteEducacion (@PathVariable Long id){
     educacionService.deleteEdu(id);
    return ResponseEntity.noContent().build();   
     }
    
    
    @PutMapping("/educacion/update/{id}")
    public ResponseEntity<EducacionDto> editEducacion (@RequestBody EducacionDto educacionDto, @PathVariable Long id){
       EducacionDto updated = educacionService.updateEd(educacionDto, id);
       return ResponseEntity.ok().body(updated);    
    }

    @GetMapping("/educacion/listar")
    public List<EducacionDto> listarEducacion (){
    return  educacionService.obtenerEd(); 
    }
    
    
   
    
}
