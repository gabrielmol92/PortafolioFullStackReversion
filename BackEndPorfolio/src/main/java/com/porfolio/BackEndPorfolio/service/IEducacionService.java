/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfolio.BackEndPorfolio.service;

import com.porfolio.BackEndPorfolio.dto.EducacionDto;

import java.util.List;

/**
 *
 * @author GabrielPc
 */
public interface IEducacionService {
    
    public EducacionDto create(EducacionDto educacionDto);
      
    public void deleteEdu (Long id);
    
    public EducacionDto updateEd (EducacionDto personaDto, Long id);

    public List<EducacionDto> obtenerEd ();
    
    
    
    
}
