/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.tipoDocumento.application;

import com.modules.sirsr.tipoDocumento.domain.TipoDocumento;
import com.modules.sirsr.tipoDocumento.domain.TipoDocumentoRepository;
import com.modules.sirsr.config.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Edward Reyes
 */
@Service
public class TipoDocumentoService {

    private final TipoDocumentoRepository tipoDocumentoRepository;
    private final TipoDocumentoMapper tipoDocumentoMapper;
    private Mensaje msg;

    @Autowired
    public TipoDocumentoService(TipoDocumentoRepository tipoDocumentoRepository, TipoDocumentoMapper tipoDocumentoMapper) {
        this.tipoDocumentoRepository = tipoDocumentoRepository;
        this.tipoDocumentoMapper = tipoDocumentoMapper;
    }
    

    public List<TipoDocumentoDTO> findAll() {
        return tipoDocumentoMapper.toTipoDocumentoDTOs(tipoDocumentoRepository.findAll());
    }

    public TipoDocumentoDTO findById(int id) {
        Optional<TipoDocumento> tipoDocumentoOptional = tipoDocumentoRepository.findById(id);
        TipoDocumentoDTO tipoDocumentoDTO = tipoDocumentoMapper.toTipoDocumentoDTO(tipoDocumentoOptional.get());
        return tipoDocumentoDTO;
    }

}