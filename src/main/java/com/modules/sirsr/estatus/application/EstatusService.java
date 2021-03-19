/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.estatus.application;

import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.estatus.domain.Estatus;
import com.modules.sirsr.estatus.domain.EstatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Edward Reyes
 */
@Service
public class EstatusService {

    private final EstatusRepository estatusRepository;
    private final EstatusMapper estatusMapper;
    private Mensaje msg;

    @Autowired
    public EstatusService(EstatusRepository estatusRepository, EstatusMapper estatusMapper) {
        this.estatusRepository = estatusRepository;
        this.estatusMapper = estatusMapper;
    }
    

    public List<EstatusDTO> findAll() throws IOException {
        return estatusMapper.toEstatusDTOs(estatusRepository.findAll());
    }

    public EstatusDTO findById(int id) throws IOException {
        Optional<Estatus> estatusOptional = estatusRepository.findById(id);
        EstatusDTO estatusDTO = estatusMapper.toEstatusDTO(estatusOptional.get());
        return estatusDTO;
    }

    public Mensaje save(EstatusDTO estatusDTO, int id) {
        try {
            msg = Mensaje.CREATE("Estatuss agregados correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo agregar estatuss por: "+e.getMessage(), 2);
        }
        return msg;
    }


    public Mensaje deleteById(int id) {
        try {
            msg = Mensaje.CREATE("Eliminado correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo Eliminar.", 2);
        }
        return msg;

    }

}
