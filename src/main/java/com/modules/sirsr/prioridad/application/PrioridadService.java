/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.prioridad.application;

import com.modules.sirsr.prioridad.domain.Prioridad;
import com.modules.sirsr.prioridad.domain.PrioridadRepository;
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
public class PrioridadService {

    private final PrioridadRepository prioridadRepository;
    private final PrioridadMapper prioridadMapper;
    private Mensaje msg;

    @Autowired
    public PrioridadService(PrioridadRepository prioridadRepository, PrioridadMapper prioridadMapper) {
        this.prioridadRepository = prioridadRepository;
        this.prioridadMapper = prioridadMapper;
    }

    public List<PrioridadDTO> findAll() {
        return prioridadMapper.toPrioridadDTOs(prioridadRepository.findAll());
    }

    public PrioridadDTO findById(int id) {
        Optional<Prioridad> prioridadOptional = prioridadRepository.findById(id);
        PrioridadDTO prioridadDTO = prioridadMapper.toPrioridadDTO(prioridadOptional.get());
        return prioridadDTO;
    }

    public Mensaje save(PrioridadDTO prioridadDTO) {
        try {

            prioridadRepository.save(prioridadMapper.toPrioridad(prioridadDTO));
            msg = Mensaje.CREATE("Agregado correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo agregar por: "+e.getMessage(), 2);
        }
        return msg;
    }

    public Mensaje update(PrioridadDTO prioridadDTO, int id) {
        try {
            Optional<Prioridad> prioridadFound = prioridadRepository.findById(id);
            Prioridad prioridad = prioridadMapper.setToUpdate(prioridadFound.get(), prioridadDTO);
            prioridadRepository.save(prioridad);
            msg = Mensaje.CREATE("Actualizado correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo Actualizar por: "+e.getMessage(), 2);
        }
        return msg;
    }

    public Mensaje deleteById(int id) {
        try {
            prioridadRepository.deleteById(id);
            msg = Mensaje.CREATE("Eliminado correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo Eliminar por que hay usuarios asociados a rol.", 2);
        }
        return msg;

    }

}
