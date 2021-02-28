/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.unidadMedida;

import com.modules.sirsr.persistence.entity.UnidadMedida;
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
public class UnidadMedidaService {

    private final UnidadMedidaRepository unidadMedidaRepository;
    private final UnidadMedidaMapper unidadMedidaMapper;
    private Mensaje msg;

    @Autowired
    public UnidadMedidaService(UnidadMedidaRepository unidadMedidaRepository, UnidadMedidaMapper unidadMedidaMapper) {
        this.unidadMedidaRepository = unidadMedidaRepository;
        this.unidadMedidaMapper = unidadMedidaMapper;
    }



    public List<UnidadMedidaDTO> findAll() {
        return unidadMedidaMapper.toUnidadMedidaDTOs(unidadMedidaRepository.findAll());
    }

    public UnidadMedidaDTO findById(int id) {
        Optional<UnidadMedida> unidadMedidaOptional = unidadMedidaRepository.findById(id);
        UnidadMedidaDTO unidadMedidaDTO = unidadMedidaMapper.toUnidadMedidaDTO(unidadMedidaOptional.get());
        return unidadMedidaDTO;
    }

    public Mensaje save(UnidadMedidaDTO unidadMedidaDTO) {
        return msg;
    }

    public Mensaje update(UnidadMedidaDTO unidadMedidaDTO, int id) {
        return msg;
    }

    public Mensaje deleteById(int id) {
        return msg;
    }

}
