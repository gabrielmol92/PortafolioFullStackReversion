/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.BackEndPorfolio.controller;

import com.porfolio.BackEndPorfolio.dto.DomicilioDto;
import com.porfolio.BackEndPorfolio.service.IDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class DomicilioController {
    
    @Autowired
    private IDomicilioService domicilioService;
    
    
    @PostMapping("/domicilio/new")
    public ResponseEntity<DomicilioDto> createDomicilio (@RequestBody DomicilioDto domicilio){
            DomicilioDto created = domicilioService.create(domicilio);
          return ResponseEntity
             .status(HttpStatus.CREATED)
             .body(created);
    }
    
    @PutMapping("/domicilio/editar/{id}")
  public ResponseEntity<DomicilioDto> editDomicilio(@RequestBody DomicilioDto domicilioDto,@PathVariable Long id)                              
          { 
       DomicilioDto updated = domicilioService.updateDomicilio(domicilioDto, id);
        return ResponseEntity.ok().body(updated);
   }
    
    
}
