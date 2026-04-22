/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.BackEndPorfolio.serviceImp;

import com.porfolio.BackEndPorfolio.dto.DomicilioDto;
import com.porfolio.BackEndPorfolio.entity.Domicilio;
import com.porfolio.BackEndPorfolio.repository.DomicilioRepository;
import com.porfolio.BackEndPorfolio.service.IDomicilioService;
import com.porfolio.BackEndPorfolio.util.Mapeo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author GabrielPc
 */
@Service
public class DomicilioServiceImp implements IDomicilioService{

    @Autowired
    private Mapeo mapper;
    
    @Autowired
    private DomicilioRepository domicilioRepository;
    
    @Override
    public DomicilioDto create(DomicilioDto domicilioDto) {
       Domicilio domicilioEntity = new Domicilio();
        domicilioEntity = (Domicilio)mapper.convertToEntity(domicilioDto, domicilioEntity);
        domicilioEntity = domicilioRepository.save(domicilioEntity);
        return (DomicilioDto)mapper.convertToDto(domicilioEntity, domicilioDto);
    }

    
    @Override
    public DomicilioDto updateDomicilio(DomicilioDto domicilioDto, Long id) {
       Domicilio domicilio = domicilioRepository.findById(id).orElse(null);
         
         domicilio.setCalle(domicilioDto.getCalle());
         domicilio.setCiudad(domicilioDto.getCiudad());
         domicilio.setProvincia(domicilioDto.getProvincia());
         
         
         Domicilio updateDomicilio = this.domicilioRepository.save(domicilio);
         DomicilioDto domicilioDtoU = new DomicilioDto();
         domicilioDtoU = (DomicilioDto)mapper.convertToDto(updateDomicilio, domicilioDtoU);
    
         return domicilioDtoU;
    }
    
    
 }
    

