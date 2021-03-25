/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.solicitud.application;

import com.modules.sirsr.config.Utils;
import com.modules.sirsr.documento.application.DocumentoDTO;
import com.modules.sirsr.documento.application.DocumentoService;
import com.modules.sirsr.documento.domain.Documento;
import com.modules.sirsr.estatus.application.EstatusDTO;
import com.modules.sirsr.estatus.application.EstatusService;
import com.modules.sirsr.folioRequisicion.domain.FolioRequisicionRepository;
import com.modules.sirsr.prioridad.application.PrioridadDTO;
import com.modules.sirsr.prioridad.application.PrioridadMapper;

import java.util.*;

import com.modules.sirsr.config.Mensaje;
import java.time.Instant;
import java.util.function.Function;

import com.modules.sirsr.prioridad.domain.PrioridadRepository;
import com.modules.sirsr.revision.application.RevisionDTO;
import com.modules.sirsr.revision.domain.Revision;
import com.modules.sirsr.revision.domain.RevisionPK;
import com.modules.sirsr.revision.domain.RevisionRepository;
import com.modules.sirsr.solicitud.domain.Solicitud;
import com.modules.sirsr.solicitud.domain.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
    private final EstatusService estatusService;
    private final PrioridadRepository prioridadRepository;
    private final RevisionRepository revisionRepository;
    private final SolicitudMapper solicitudMapper;
    private final PrioridadMapper prioridadMapper;
    private final FolioRequisicionRepository folioRequisicionRepository;
    private SolicitudDTO solicitudDTO;
    private UsuarioDTO usuarioDTO;
    private EstatusDTO estatusDTO;
    private PrioridadDTO prioridadDTO;
    private Mensaje msg;

    @Autowired
    public SolicitudService(SolicitudRepository solicitudRepository, UsuarioService usuarioService, EstatusService estatusService, PrioridadRepository prioridadRepository, RevisionRepository revisionRepository, SolicitudMapper solicitudMapper, PrioridadMapper prioridadMapper, FolioRequisicionRepository folioRequisicionRepository) {
        this.solicitudRepository = solicitudRepository;
        this.usuarioService = usuarioService;
        this.estatusService = estatusService;
        this.prioridadRepository = prioridadRepository;
        this.revisionRepository = revisionRepository;
        this.solicitudMapper = solicitudMapper;
        this.prioridadMapper = prioridadMapper;
        this.folioRequisicionRepository = folioRequisicionRepository;
    }

    public List<SolicitudDTO> findAll() {
        return solicitudMapper.toSolicitudDTOs(solicitudRepository.findAll(Sort.by(Sort.Direction.DESC,"idSolicitud")));
    }

    public List<SolicitudDTO> findAllEmitidas() {
        return solicitudMapper.toSolicitudDTOs(solicitudRepository.findByIdEstatusGreaterThanEqual(11));
    }

    public List<SolicitudDTO> findByClaveUnidad() {
        usuarioDTO = usuarioService.findByUserName(WebUtils.getUserName());
        return solicitudMapper.toSolicitudDTOs(solicitudRepository.findByClaveUr(usuarioDTO.getUnidadResponsable().getClaveUr(),Sort.by(Sort.Direction.DESC,"idSolicitud")));
    }

    public SolicitudDTO findById(int id) {
        Optional<Solicitud> requisicionOptional = solicitudRepository.findById(id);
        SolicitudDTO solicitudDTO = solicitudMapper.toSolicitudDTO(requisicionOptional.get());
        return solicitudDTO;
    }

    public Mensaje save(SolicitudDTO solicitudDTO) {
        try {
            usuarioDTO = usuarioService.findByUserName(WebUtils.getUserName());
            estatusDTO = estatusService.findById(10);
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
            Solicitud solicitud = solicitudMapper.setToUpdate(solicitudFound.get(), solicitudDTO);
            solicitudRepository.save(solicitud);
            msg = Mensaje.CREATE("Actualizado correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo Actualizar por: "+e.getMessage(), 2);
        }
        return msg;
    }

    public Mensaje deleteById(int id) {
        try {
            estatusDTO = estatusService.findById(14);
            solicitudDTO = this.findById(id);
            solicitudDTO.setEstatus(estatusDTO);
            solicitudRepository.save(solicitudMapper.toSolicitud(solicitudDTO));
            msg = Mensaje.CREATE("Cancelado correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo Cancelar.", 2);
        }
        return msg;

    }

    public Mensaje emitirById(int id) {
        Solicitud solicitud = solicitudRepository.findById(id).get();
        if(areDocumentsComplete.apply(solicitud.getDocumentos())){
            try {
                solicitud.setEstatus(estatusService.estatusFindById(11));
                solicitud.setFechaEmision(Date.from(Instant.now()));
                solicitudRepository.save(solicitud);
                Utils.firmaDirector(usuarioService, solicitudRepository, solicitud);

                msg = Mensaje.CREATE("Emitido correctamente", 1);
            } catch (Exception e) {
                msg = Mensaje.CREATE("No se pudo Emitir.", 2);
            }
        }
        else msg = Mensaje.CREATE("No has subido los documentos necesarios.", 2);
        return msg;

    }


    public Mensaje correction(RevisionDTO revisionDTO, int id) {
        try {
            SolicitudDTO solicitudDTO = findById(id);
            EstatusDTO estatusDTO = estatusService.findById(13);
            Revision revision = new Revision();
            RevisionPK revisionPK = new RevisionPK();
            revisionPK.setFechaRevision(Date.from(Instant.now()));
            revisionPK.setIdRequisicion(id);
            revision.setRevisionPK(revisionPK);
            revision.setObservacion(revisionDTO.getObservacion());
            revision.setSolicitud(solicitudMapper.toSolicitud(solicitudDTO));
            revisionRepository.save(revision);
            solicitudDTO.setEstatus(estatusDTO);
            solicitudRepository.save(solicitudMapper.toSolicitud(solicitudDTO));
            msg = Mensaje.CREATE("Se enviaron correciones correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo enviar correcciones.", 2);
        }
        return msg;

    }

    public Mensaje aceptarById(int id) {
    try {
        solicitudDTO = findById(id);
        EstatusDTO estatusDTO = estatusService.findById(15);
        solicitudDTO.setEstatus(estatusDTO);
        solicitudDTO.setFechaAutorizacion(Date.from(Instant.now()));
        solicitudRepository.save(solicitudMapper.toSolicitud(solicitudDTO));
        msg = Mensaje.CREATE("Se Acepto la solicitud correctamente", 1);
    }catch (Exception e){
        msg = Mensaje.CREATE("No se pudo aceptar la solicitud.", 2);
    }
        return msg;
    }



    public void updateEstatusFecha(SolicitudDTO solicitudDTO, int idEstatus) {
        try {
            estatusDTO = estatusService.findById(idEstatus);
            Date now = Date.from(Instant.now());
            solicitudDTO.setFechaRecepcion(now);
            solicitudDTO.setEstatus(estatusDTO);
            solicitudRepository.save(solicitudMapper.toSolicitud(solicitudDTO));
        }catch (Exception e){
        }
    }

    public Function<List<Documento>, Boolean> areDocumentsComplete = documentos -> {
        boolean isValid = documentos.stream()
                .anyMatch(documentoDTO ->
                        documentoDTO.getTipoDocumento().getIdTipoDocumento() == 1);
        boolean isValid2 = documentos.stream()
                .anyMatch(documentoDTO ->
                        documentoDTO.getTipoDocumento().getIdTipoDocumento() == 2);
        return isValid && isValid2;
    };

}
