/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.PartidaGasto;

import com.modules.sirsr.persistence.entity.PartidaGastoEspecifica;
import com.modules.sirsr.persistence.repository.*;
import com.modules.sirsr.utils.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 *
 * @author Edward Reyes
 */
@Service
public class PartidaGastoEspecificaService {

    private final PartidaGastoEspecificaRepository partidaGastoEspecificaRepository;
    private final PartidaGastoEspecificaMapper partidaGastoEspecificaMapper;
    private Mensaje msg;
    
    @Autowired
    public PartidaGastoEspecificaService(PartidaGastoEspecificaRepository partidaGastoEspecificaRepository, PartidaGastoEspecificaMapper partidaGastoEspecificaMapper) {
        this.partidaGastoEspecificaRepository = partidaGastoEspecificaRepository;
        this.partidaGastoEspecificaMapper = partidaGastoEspecificaMapper;
    }

    public List<PartidaGastoEspecificaDTO> findAll() {
        return partidaGastoEspecificaMapper.toPartidaGastoEspecificaDTOs(partidaGastoEspecificaRepository.findAll());
    }

    public PartidaGastoEspecificaDTO findById(int id) {
        Optional<PartidaGastoEspecifica> partidaGastoEspecificaOptional = partidaGastoEspecificaRepository.findById(id);
        PartidaGastoEspecificaDTO partidaGastoEspecificaDTO = partidaGastoEspecificaMapper.toPartidaGastoEspecificaDTO(partidaGastoEspecificaOptional.get());
        return partidaGastoEspecificaDTO;
    }

    public Mensaje save(PartidaGastoEspecificaDTO partidaGastoEspecificaDTO) {
        return msg;
    }

    public Mensaje update(PartidaGastoEspecificaDTO partidaGastoEspecificaDTO, int id) {
        return msg;
    }

    public Mensaje deleteById(int id) {
        return msg;
    }

}
