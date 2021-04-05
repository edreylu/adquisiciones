/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.clavePresupuestaria.domain;

import com.modules.sirsr.clavePresupuestaria.persistence.ClavePresupuestaria;
import com.modules.sirsr.clavePresupuestaria.persistence.ClavePresupuestariaRepository;
import com.modules.sirsr.clavePresupuestaria.persistence.ClavePresupuestariaMapper;
import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.config.WebUtils;
import com.modules.sirsr.usuario.domain.UsuarioDTO;
import com.modules.sirsr.usuario.domain.UsuarioService;
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
    private final UsuarioService usuarioService;
    private Mensaje msg;

    @Autowired
    public ClavePresupuestariaService(ClavePresupuestariaRepository clavePresupuestariaRepository, ClavePresupuestariaMapper clavePresupuestariaMapper, UsuarioService usuarioService) {
        this.clavePresupuestariaRepository = clavePresupuestariaRepository;
        this.clavePresupuestariaMapper = clavePresupuestariaMapper;
        this.usuarioService = usuarioService;
    }

    public List<ClavePresupuestariaDTO> findAll() {
        return clavePresupuestariaMapper.toClavePresupuestariaDTOs(clavePresupuestariaRepository.findAll());
    }

    public List<ClavePresupuestariaDTO> findByClaveUr() {
        UsuarioDTO usuarioDTO = usuarioService.findByUserName(WebUtils.getUserName());
        return clavePresupuestariaMapper.toClavePresupuestariaDTOs(clavePresupuestariaRepository.findByUnidadResp(usuarioDTO.getUnidadResponsable().getClaveUr()));
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
