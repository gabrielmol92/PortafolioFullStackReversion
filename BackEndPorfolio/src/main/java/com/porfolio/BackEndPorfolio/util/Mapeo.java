/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.BackEndPorfolio.util;

import com.porfolio.BackEndPorfolio.dto._DTOEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 *
 * @author GabrielPc
 */
@Component
public class Mapeo {
    
//    @Autowired
//    private ModelMapper modelMapper;
     
public _DTOEntity convertToDto(Object obj, _DTOEntity dto) { 
    ModelMapper modelMapper = new ModelMapper (); 
    return modelMapper.map(obj, dto.getClass()); }
  
    public Object convertToEntity(_DTOEntity dto, Object obj) {
    ModelMapper modelMapper = new ModelMapper(); 
    modelMapper.map(dto, obj); 
    return obj;
}
}
