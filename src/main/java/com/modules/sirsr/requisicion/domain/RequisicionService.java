/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.requisicion.domain;

import com.modules.sirsr.clavePresupuestaria.domain.ClavePresupuestariaDTO;
import com.modules.sirsr.clavePresupuestaria.persistence.ClavePresupuestariaMapper;
import com.modules.sirsr.clavePresupuestaria.persistence.ClavePresupuestariaRepository;
import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.estatus.domain.EstatusDTO;
import com.modules.sirsr.estatus.persistence.EstatusMapper;
import com.modules.sirsr.estatus.persistence.EstatusRepository;

import java.util.List;
import java.util.Optional;

import com.modules.sirsr.requisicion.persistence.Requisicion;
import com.modules.sirsr.requisicion.persistence.RequisicionRepository;
import com.modules.sirsr.requisicion.persistence.DetalleRequisicionMapper;
import com.modules.sirsr.requisicion.persistence.RequisicionMapper;
import com.modules.sirsr.solicitud.domain.SolicitudDTO;
import com.modules.sirsr.solicitud.persistence.SolicitudMapper;
import com.modules.sirsr.solicitud.persistence.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Edward Reyes
 */
@Service
public class RequisicionService {
    
    private final RequisicionRepository requisicionRepository;
    private final DetalleRequisicionMapper detalleRequisicionMapper;
    private final SolicitudRepository solicitudRepository;
    private final EstatusRepository estatusRepository;
    private final ClavePresupuestariaRepository clavePresupuestariaRepository;
    private final RequisicionMapper requisicionMapper;
    private final SolicitudMapper solicitudMapper;
    private final EstatusMapper estatusMapper;
    private final ClavePresupuestariaMapper clavePresupuestariaMapper;
    private SolicitudDTO solicitudDTO;
    private EstatusDTO estatusDTO;
    private ClavePresupuestariaDTO clavePresupuestariaDTO;
    private Mensaje msg;


    @Autowired
    public RequisicionService(RequisicionRepository requisicionRepository, DetalleRequisicionMapper detalleRequisicionMapper, SolicitudRepository solicitudRepository, EstatusRepository estatusRepository, ClavePresupuestariaRepository clavePresupuestariaRepository, RequisicionMapper requisicionMapper, SolicitudMapper solicitudMapper, EstatusMapper estatusMapper, ClavePresupuestariaMapper clavePresupuestariaMapper) {
        this.requisicionRepository = requisicionRepository;
        this.detalleRequisicionMapper = detalleRequisicionMapper;
        this.solicitudRepository = solicitudRepository;
        this.estatusRepository = estatusRepository;
        this.clavePresupuestariaRepository = clavePresupuestariaRepository;
        this.requisicionMapper = requisicionMapper;
        this.solicitudMapper = solicitudMapper;
        this.estatusMapper = estatusMapper;
        this.clavePresupuestariaMapper = clavePresupuestariaMapper;
    }

    public List<RequisicionDTO> findAll() {
        return requisicionMapper.toRequisicionDTOs(requisicionRepository.findAll());
    }


    public RequisicionDTO findById(int id) {
        Optional<Requisicion> requisicionOptional = requisicionRepository.findById(id);
        RequisicionDTO requisicionDTO = requisicionMapper.toRequisicionDTO(requisicionOptional.get());
        return requisicionDTO;
    }

    public List<RequisicionDTO> findByIdSolicitud(int id) {
        List<RequisicionDTO> requisicionesDTO = requisicionMapper.toRequisicionDTOs(requisicionRepository.findByIdSolicitud(id));
        return requisicionesDTO;
    }

    public Mensaje save(RequisicionDTO requisicionDTO, int idSolicitud) {
        try {
            System.out.println(requisicionDTO.toString());
            solicitudDTO = solicitudMapper.toSolicitudDTO(solicitudRepository.findById(idSolicitud).get());
            clavePresupuestariaDTO = clavePresupuestariaMapper.toClavePresupuestariaDTO(clavePresupuestariaRepository.findById(requisicionDTO.getClavePresupuestaria().getIdClavePresup()).get());
            estatusDTO = estatusMapper.toEstatusDTO(estatusRepository.findById(1).get());
            requisicionDTO.setSolicitud(solicitudDTO);
            requisicionDTO.setClavePresupuestaria(clavePresupuestariaDTO);
            requisicionDTO.setEstatus(estatusDTO);
            requisicionRepository.save(requisicionMapper.toRequisicion(requisicionDTO));

            msg = Mensaje.CREATE("Agregado correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo agregar por: "+e.getMessage(), 2);
        }
        return msg;
    }


    public Mensaje saveDetalles(RequisicionDTO requisicionDTO, int id) {
        try {


            msg = Mensaje.CREATE("Detalles agregados correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo agregar detalles por: "+e.getMessage(), 2);
        }
        return msg;
    }

    public Mensaje update(RequisicionDTO requisicionDTO) {
        try {
            Requisicion requisicion = requisicionRepository.findById(requisicionDTO.getIdRequisicion()).get();
            clavePresupuestariaDTO = clavePresupuestariaMapper.toClavePresupuestariaDTO(clavePresupuestariaRepository.findById(requisicionDTO.getClavePresupuestaria().getIdClavePresup()).get());
            requisicionDTO.setClavePresupuestaria(clavePresupuestariaDTO);
            requisicionRepository.save(requisicionMapper.setToUpdate(requisicion, requisicionDTO));
            msg = Mensaje.CREATE("Actualizado correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo Actualizar por: "+e.getMessage(), 2);
        }
        return msg;
    }

    public Mensaje deleteById(int id) {
        try {
            requisicionRepository.deleteById(id);
            msg = Mensaje.CREATE("Eliminado correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo Eliminar.", 2);
        }
        return msg;

    }

}