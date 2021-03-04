/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.subTipoProducto;

import com.modules.sirsr.persistence.entity.SubTipoProducto;
import com.modules.sirsr.persistence.repository.SubTipoProductoRepository;
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
public class SubTipoProductoService {

    private final SubTipoProductoRepository subTipoProductoRepository;
    private final SubTipoProductoMapper subTipoProductoMapper;
    private Mensaje msg;

    @Autowired
    public SubTipoProductoService(SubTipoProductoRepository subTipoProductoRepository, SubTipoProductoMapper subTipoProductoMapper) {
        this.subTipoProductoRepository = subTipoProductoRepository;
        this.subTipoProductoMapper = subTipoProductoMapper;
    }
    

    public List<SubTipoProductoDTO> findAll() {
        return subTipoProductoMapper.toSubTipoProductoDTOs(subTipoProductoRepository.findAll());
    }

    public SubTipoProductoDTO findById(int id) {
        Optional<SubTipoProducto> subTipoProductoOptional = subTipoProductoRepository.findById(id);
        SubTipoProductoDTO tipoDocumentoDTO = subTipoProductoMapper.toSubTipoProductoDTO(subTipoProductoOptional.get());
        return tipoDocumentoDTO;
    }

}
