/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.marca.application;

import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.marca.domain.Marca;
import com.modules.sirsr.marca.domain.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Edward Reyes
 */
@Service
public class MarcaService {

    private final MarcaRepository marcaRepository;
    private final MarcaMapper marcaMapper;
    private Mensaje msg;

    @Autowired
    public MarcaService(MarcaRepository marcaRepository, MarcaMapper marcaMapper) {
        this.marcaRepository = marcaRepository;
        this.marcaMapper = marcaMapper;
    }

    public List<MarcaDTO> findAll() {
        return marcaMapper.toMarcaDTOs(marcaRepository.findAll());
    }

    public MarcaDTO findById(int id) {
        Optional<Marca> marcaOptional = marcaRepository.findById(id);
        MarcaDTO marcaDTO = marcaMapper.toMarcaDTO(marcaOptional.get());
        return marcaDTO;
    }

    public Mensaje save(MarcaDTO marcaDTO) {
        return msg;
    }

    public Mensaje update(MarcaDTO marcaDTO, int id) {
        return msg;
    }

    public Mensaje deleteById(int id) {
        return msg;
    }

}
