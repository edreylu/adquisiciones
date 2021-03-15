/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.solicitud.application;

import com.modules.sirsr.estatus.application.EstatusDTO;
import com.modules.sirsr.estatus.application.EstatusMapper;
import com.modules.sirsr.estatus.domain.EstatusRepository;
import com.modules.sirsr.prioridad.application.PrioridadDTO;
import com.modules.sirsr.prioridad.application.PrioridadMapper;

import java.util.List;
import java.util.Optional;
import com.modules.sirsr.config.Mensaje;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

import com.modules.sirsr.prioridad.domain.PrioridadRepository;
import com.modules.sirsr.solicitud.domain.Solicitud;
import com.modules.sirsr.solicitud.domain.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.modules.sirsr.usuario.application.UsuarioDTO;
import com.modules.sirsr.usuario.application.UsuarioService;
import com.modules.sirsr.config.WebUtils;

/**
 *
 * @author Edward Reyes
 */
@Service
public class SolicitudService {

    private final SolicitudRepository solicitudRepository;
    private final UsuarioService usuarioService;
    private final EstatusRepository estatusRepository;
    private final PrioridadRepository prioridadRepository;
    private final SolicitudMapper solicitudMapper;
    private final EstatusMapper estatusMapper;
    private final PrioridadMapper prioridadMapper;
    private UsuarioDTO usuarioDTO;
    private EstatusDTO estatusDTO;
    private PrioridadDTO prioridadDTO;
    private Mensaje msg;

    @Autowired
    public SolicitudService(SolicitudRepository solicitudRepository, UsuarioService usuarioService, EstatusRepository estatusRepository, PrioridadRepository prioridadRepository, SolicitudMapper solicitudMapper, EstatusMapper estatusMapper, PrioridadMapper prioridadMapper) {
        this.solicitudRepository = solicitudRepository;
        this.usuarioService = usuarioService;
        this.estatusRepository = estatusRepository;
        this.prioridadRepository = prioridadRepository;
        this.solicitudMapper = solicitudMapper;
        this.estatusMapper = estatusMapper;
        this.prioridadMapper = prioridadMapper;
    }

    public List<SolicitudDTO> findAll() {
        return solicitudMapper.toSolicitudDTOs(solicitudRepository.findAll());
    }

    public List<SolicitudDTO> findByClaveUnidad() {
        usuarioDTO = usuarioService.findByUserName(WebUtils.getUserName());
        return solicitudMapper.toSolicitudDTOs(solicitudRepository.findByClaveUr(usuarioDTO.getUnidadResponsable().getClaveUr()));
    }

    public SolicitudDTO findById(int id) {
        Optional<Solicitud> requisicionOptional = solicitudRepository.findById(id);
        SolicitudDTO solicitudDTO = solicitudMapper.toSolicitudDTO(requisicionOptional.get());
        return solicitudDTO;
    }

    public Mensaje save(SolicitudDTO solicitudDTO) {
        try {
            usuarioDTO = usuarioService.findByUserName(WebUtils.getUserName());
            estatusDTO = estatusMapper.toEstatusDTO(estatusRepository.findById(1).get());
            prioridadDTO = prioridadMapper.toPrioridadDTO(prioridadRepository.findById(solicitudDTO.getPrioridad().getIdPrioridad()).get());
            Calendar calendar = Calendar.getInstance();
            int annio = calendar.get(Calendar.YEAR);
            solicitudDTO.setUnidadResponsable(usuarioDTO.getUnidadResponsable());
            solicitudDTO.setFechaCreacion(Date.from(Instant.now()));
            solicitudDTO.setAnioCalendarizacion(annio);
            solicitudDTO.setPrioridad(prioridadDTO);
            solicitudDTO.setEstatus(estatusDTO);
            System.out.println(solicitudDTO.toString());
            solicitudRepository.save(solicitudMapper.toSolicitud(solicitudDTO));

            msg = Mensaje.CREATE("Agregado correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo agregar por: "+e.getMessage(), 2);
        }
        return msg;
    }

    public Mensaje update(SolicitudDTO solicitudDTO, int id) {
        try {
            Optional<Solicitud> solicitudFound = solicitudRepository.findById(id);
            Solicitud solicitud = new Solicitud();//solicitudMapper.setToUpdate(solicitudFound.get(), solicitudDTO);
            solicitudRepository.save(solicitud);
            msg = Mensaje.CREATE("Actualizado correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo Actualizar por: "+e.getMessage(), 2);
        }
        return msg;
    }

    public Mensaje deleteById(int id) {
        try {
            solicitudRepository.deleteById(id);
            msg = Mensaje.CREATE("Eliminado correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo Eliminar por que hay usuarios asociados a rol.", 2);
        }
        return msg;

    }

}
