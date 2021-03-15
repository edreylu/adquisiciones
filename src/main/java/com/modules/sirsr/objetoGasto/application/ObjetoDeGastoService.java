/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.objetoGasto.application;

import com.modules.sirsr.objetoGasto.domain.ObjetoDeGasto;
import com.modules.sirsr.objetoGasto.domain.ObjetoDeGastoRepository;
import com.modules.sirsr.config.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 *
 * @author Edward Reyes
 */
@Service
public class ObjetoDeGastoService {

    private final ObjetoDeGastoRepository objetoDeGastoRepository;
    private final ObjetoDeGastoMapper objetoDeGastoMapper;
    private Mensaje msg;
    
    @Autowired
    public ObjetoDeGastoService(ObjetoDeGastoRepository objetoDeGastoRepository, ObjetoDeGastoMapper objetoDeGastoMapper) {
        this.objetoDeGastoRepository = objetoDeGastoRepository;
        this.objetoDeGastoMapper = objetoDeGastoMapper;
    }

    public List<ObjetoDeGastoDTO> findAll() {
        return objetoDeGastoMapper.toObjetoDeGastoDTOs(objetoDeGastoRepository.findAll());
    }

    public ObjetoDeGastoDTO findById(String id) {
        Optional<ObjetoDeGasto> objetoDeGastoOptional = objetoDeGastoRepository.findById(id);
        ObjetoDeGastoDTO objetoDeGastoDTO = objetoDeGastoMapper.toObjetoDeGastoDTO(objetoDeGastoOptional.get());
        return objetoDeGastoDTO;
    }

    public Mensaje save(ObjetoDeGastoDTO objetoDeGastoDTO) {
        return msg;
    }

    public Mensaje update(ObjetoDeGastoDTO objetoDeGastoDTO, int id) {
        return msg;
    }

    public Mensaje deleteById(int id) {
        return msg;
    }

}
