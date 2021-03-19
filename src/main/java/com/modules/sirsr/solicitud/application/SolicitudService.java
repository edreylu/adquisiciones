/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.solicitud.application;

import com.modules.sirsr.documento.application.DocumentoService;
import com.modules.sirsr.estatus.application.EstatusDTO;
import com.modules.sirsr.estatus.application.EstatusService;
import com.modules.sirsr.folioRequisicion.domain.FolioRequisicion;
import com.modules.sirsr.folioRequisicion.domain.FolioRequisicionRepository;
import com.modules.sirsr.prioridad.application.PrioridadDTO;
import com.modules.sirsr.prioridad.application.PrioridadMapper;

import java.util.*;

import com.modules.sirsr.config.Mensaje;
import java.time.Instant;

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
    private final DocumentoService documentoService;
    private final FolioRequisicionRepository folioRequisicionRepository;
    private UsuarioDTO usuarioDTO;
    private EstatusDTO estatusDTO;
    private PrioridadDTO prioridadDTO;
    private Mensaje msg;

    @Autowired
    public SolicitudService(SolicitudRepository solicitudRepository, UsuarioService usuarioService, EstatusService estatusService, PrioridadRepository prioridadRepository, RevisionRepository revisionRepository, SolicitudMapper solicitudMapper, PrioridadMapper prioridadMapper, DocumentoService documentoService, FolioRequisicionRepository folioRequisicionRepository) {
        this.solicitudRepository = solicitudRepository;
        this.usuarioService = usuarioService;
        this.estatusService = estatusService;
        this.prioridadRepository = prioridadRepository;
        this.revisionRepository = revisionRepository;
        this.solicitudMapper = solicitudMapper;
        this.prioridadMapper = prioridadMapper;
        this.documentoService = documentoService;
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

    public Mensaje updateEstatus(SolicitudDTO solicitudDTO, int idEstatus) {
        try {
            EstatusDTO estatusDTO = estatusService.findById(idEstatus);
            solicitudDTO.setEstatus(estatusDTO);
            solicitudRepository.save(solicitudMapper.toSolicitud(solicitudDTO));
        }catch (Exception e){
        }
        return msg;
    }

    public Mensaje validateById(int id) {
        if(documentoService.areDocumentsComplete(id)) {
            try {
                String folio = null;
                SolicitudDTO solicitudDTO = this.findById(id);
                estatusDTO = estatusService.findById(11);
                FolioRequisicion folioRequisicion = folioRequisicionRepository.getOne(2021);
                solicitudDTO.setEstatus(estatusDTO);
                solicitudRepository.save(solicitudMapper.toSolicitud(solicitudDTO));
                folioRequisicion.setConsecutivo(folioRequisicion.getConsecutivo()+1);
                folioRequisicionRepository.save(folioRequisicion);

                    //al finalizar el cambio de estatus de solicitud se llaman los datos para la firma director
                    UsuarioDTO usuarioDTO = usuarioService.findByUserName(WebUtils.getUserName());
                    String ur = usuarioDTO.getUnidadResponsable().getDescripcion();
                    Integer expediente = usuarioDTO.getNoUsuario();
                    Solicitud solicitud = solicitudRepository.findById(id).get();
                    folio = "UR" + ur + "EX" + new Formatter().format("%07d", expediente).toString() + "FC" + solicitudDTO.getFechaCreacion();
                    System.out.println(folio);
                    byte[] bytes = folio.getBytes();
                    String cadena = utilerias.Base64.encodeBytes(bytes, utilerias.Base64.GZIP);
                    System.out.println("cadena = " + cadena);
                    //finalmente se guarda la cadena de firma director
                    solicitud.setFirmaDirector(cadena);
                    solicitudRepository.save(solicitud);
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
        SolicitudDTO solicitudDTO = findById(id);
        EstatusDTO estatusDTO = estatusService.findById(15);
        solicitudDTO.setEstatus(estatusDTO);
        solicitudRepository.save(solicitudMapper.toSolicitud(solicitudDTO));
        msg = Mensaje.CREATE("Se Acepto la solicitud correctamente", 1);
    }catch (Exception e){
        msg = Mensaje.CREATE("No se pudo aceptar la solicitud.", 2);
    }
        return msg;
    }
}
