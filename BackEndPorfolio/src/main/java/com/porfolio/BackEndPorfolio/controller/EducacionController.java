/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.BackEndPorfolio.controller;

import com.porfolio.BackEndPorfolio.dto.EducacionDto;
import com.porfolio.BackEndPorfolio.service.IEducacionService;
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
public class EducacionController {
    
    @Autowired
    private IEducacionService educacionService;
    
    @PostMapping("/educacion/new")
    public String createEd (@RequestBody EducacionDto educacionDto){
       educacionService.create(educacionDto); 
     return "Se ha creado la educacion";
    }
    
    
    @DeleteMapping("/educacion/delete/{id}")
    public String deleteEducacion (@PathVariable Long id){
     educacionService.deleteEdu(id);
    return "Se ha borrado la educacion";   
     }
    
    
    @PutMapping("/educacion/update/{id}")
    public String editEducacion (@RequestBody EducacionDto educacionDto, @PathVariable Long id){
       educacionService.updateEd(educacionDto, id);
    
     return "Se ha editado el curso";
    
    }


    @GetMapping("/educacion/listar")
    public List<EducacionDto> listarEducacion (){
     
    return  educacionService.obtenerEd(); 
    
        
    }
    
    
   
    
}
