/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.clavePresupuestaria;

import com.modules.sirsr.PartidaGasto.ObjetoDeGastoDTO;
import com.modules.sirsr.persistence.entity.ClavePresupuestaria;
import com.modules.sirsr.persistence.repository.ClavePresupuestariaRepository;
import com.modules.sirsr.utils.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Edward Reyes
 */
@Service
public class ClavePresupuestariaService {

    private final ClavePresupuestariaRepository clavePresupuestariaRepository;
    private final ClavePresupuestariaMapper clavePresupuestariaMapper;
    private Mensaje msg;

    @Autowired
    public ClavePresupuestariaService(ClavePresupuestariaRepository clavePresupuestariaRepository, ClavePresupuestariaMapper clavePresupuestariaMapper) {
        this.clavePresupuestariaRepository = clavePresupuestariaRepository;
        this.clavePresupuestariaMapper = clavePresupuestariaMapper;
    }

    public List<ClavePresupuestariaDTO> findAll() {
        return clavePresupuestariaMapper.toClavePresupuestariaDTOs(clavePresupuestariaRepository.findAll());
    }

    public ClavePresupuestariaDTO findById(int id) {
        Optional<ClavePresupuestaria> clavePresupuestariaOptional = clavePresupuestariaRepository.findById(id);
        ClavePresupuestariaDTO clavePresupuestariaDTO = clavePresupuestariaMapper.toClavePresupuestariaDTO(clavePresupuestariaOptional.get());
        return clavePresupuestariaDTO;
    }

    public Mensaje save(ClavePresupuestariaDTO clavePresupuestariaDTO) {
        return msg;
    }

    public Mensaje update(ClavePresupuestariaDTO clavePresupuestariaDTO, int id) {
        return msg;
    }

    public Mensaje deleteById(int id) {
        return msg;
    }

}
