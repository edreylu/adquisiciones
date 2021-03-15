/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.detalleRequisicion.application;

import com.modules.sirsr.detalleRequisicion.domain.DetalleRequisicionRepository;
import com.modules.sirsr.documento.domain.DocumentoRepository;
import com.modules.sirsr.estatus.application.EstatusDTO;
import com.modules.sirsr.estatus.application.EstatusMapper;
import com.modules.sirsr.detalleRequisicion.domain.DetalleRequisicion;
import com.modules.sirsr.estatus.domain.EstatusRepository;
import com.modules.sirsr.requisicion.application.RequisicionMapper;
import com.modules.sirsr.requisicion.domain.RequisicionRepository;
import com.modules.sirsr.solicitud.application.SolicitudDTO;
import com.modules.sirsr.solicitud.application.SolicitudMapper;
import com.modules.sirsr.solicitud.domain.SolicitudRepository;
import com.modules.sirsr.usuario.application.UsuarioDTO;
import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.usuario.domain.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Edward Reyes
 */
@Service
public class DetalleRequisicionService {

    private final RequisicionRepository requisicionRepository;
    private final DetalleRequisicionRepository detalleRequisicionRepository;
    private final DocumentoRepository documentoRepository;
    private final UsuarioRepository usuarioRepository;
    private final DetalleRequisicionMapper detalleRequisicionMapper;
    private final SolicitudRepository solicitudRepository;
    private final EstatusRepository estatusRepository;
    private final RequisicionMapper requisicionMapper;
    private final SolicitudMapper solicitudMapper;
    private final EstatusMapper estatusMapper;
    private DetalleRequisicionDTO detalleRequisicionDTO;
    private UsuarioDTO usuarioDTO;
    private SolicitudDTO solicitudDTO;
    private EstatusDTO estatusDTO;
    private Mensaje msg;

    @Autowired
    public DetalleRequisicionService(RequisicionRepository requisicionRepository, DetalleRequisicionRepository detalleRequisicionRepository, DocumentoRepository documentoRepository, UsuarioRepository usuarioRepository, DetalleRequisicionMapper detalleRequisicionMapper, SolicitudRepository solicitudRepository, EstatusRepository estatusRepository, RequisicionMapper requisicionMapper, SolicitudMapper solicitudMapper, EstatusMapper estatusMapper) {
        this.requisicionRepository = requisicionRepository;
        this.detalleRequisicionRepository = detalleRequisicionRepository;
        this.documentoRepository = documentoRepository;
        this.usuarioRepository = usuarioRepository;
        this.detalleRequisicionMapper = detalleRequisicionMapper;
        this.solicitudRepository = solicitudRepository;
        this.estatusRepository = estatusRepository;
        this.requisicionMapper = requisicionMapper;
        this.solicitudMapper = solicitudMapper;
        this.estatusMapper = estatusMapper;
    }


    public List<DetalleRequisicionDTO> findAll() {
        return detalleRequisicionMapper.toDetalleRequisicionDTOs(detalleRequisicionRepository.findAll());
    }

    public DetalleRequisicionDTO findById(int id) {
        Optional<DetalleRequisicion> detalleRequisicionOptional = detalleRequisicionRepository.findById(id);
        DetalleRequisicionDTO detalleRequisicionDTO = detalleRequisicionMapper.toDetalleRequisicionDTO(detalleRequisicionOptional.get());
        return detalleRequisicionDTO;
    }

    public Mensaje save(DetalleRequisicionDTO detalleRequisicionDTO) {
        try {

            msg = Mensaje.CREATE("Agregado correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo agregar por: "+e.getMessage(), 2);
        }
        return msg;
    }

    public Mensaje update(DetalleRequisicionDTO detalleRequisicionDTO, int id) {
        try {

            msg = Mensaje.CREATE("Actualizado correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo Actualizar por: "+e.getMessage(), 2);
        }
        return msg;
    }

    public Mensaje deleteById(int id) {
        try {
            detalleRequisicionRepository.deleteById(id);
            msg = Mensaje.CREATE("Eliminado correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo Eliminar por que hay usuarios asociados a rol.", 2);
        }
        return msg;

    }

}
