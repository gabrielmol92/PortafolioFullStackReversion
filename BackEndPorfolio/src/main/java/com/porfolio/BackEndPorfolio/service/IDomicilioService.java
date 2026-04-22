/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfolio.BackEndPorfolio.service;

import com.porfolio.BackEndPorfolio.dto.DomicilioDto;

/**
 *
 * @author GabrielPc
 */
public interface IDomicilioService {
    
    
     public DomicilioDto create(DomicilioDto domicilioDto);
      
    //public void deleteDomicilio (Long id);
    
    public DomicilioDto updateDomicilio (DomicilioDto domicilioDto, Long id);
    
  //  public DomicilioDto getDomicilio(Long id);
    
}
