/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.solicitud;

import com.modules.sirsr.documento.DocumentoDTO;
import com.modules.sirsr.estatus.EstatusDTO;
import com.modules.sirsr.estatus.EstatusMapper;
import com.modules.sirsr.prioridad.PrioridadDTO;
import com.modules.sirsr.prioridad.PrioridadMapper;
import com.modules.sirsr.requisicion.*;
import com.modules.sirsr.documento.DocumentoMapper;
import com.modules.sirsr.persistence.entity.*;
import com.modules.sirsr.persistence.repository.*;

import java.util.List;
import java.util.Optional;

import com.modules.sirsr.unidadResponsable.UnidadResponsableDTO;
import com.modules.sirsr.unidadResponsable.UnidadResponsableService;
import com.modules.sirsr.utils.Mensaje;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.modules.sirsr.usuario.UsuarioDTO;
import com.modules.sirsr.usuario.UsuarioService;
import com.modules.sirsr.utils.WebUtils;

/**
 *
 * @author Edward Reyes
 */
@Service
public class SolicitudService {

    private final SolicitudRepository solicitudRepository;
    private final DetalleRequisicionRepository detalleRequisicionRepository;
    private final DocumentoRepository documentoRepository;
    private final UsuarioService usuarioService;
    private final DetalleRequisicionMapper detalleRequisicionMapper;
    private final TipoDocumentoRepository tipoDocumentoRepository;
    private final UnidadMedidaRepository unidadMedidaRepository;
    private final UnidadResponsableService unidadResponsableService;
    private final EstatusRepository estatusRepository;
    private final PrioridadRepository prioridadRepository;
    private final DocumentoMapper documentoMapper;
    private final SolicitudMapper solicitudMapper;
    private final EstatusMapper estatusMapper;
    private final PrioridadMapper prioridadMapper;
    private UsuarioDTO usuarioDTO;
    private UnidadResponsableDTO unidadResponsableDTO;
    private EstatusDTO estatusDTO;
    private PrioridadDTO prioridadDTO;
    private Mensaje msg;

    @Autowired
    public SolicitudService(SolicitudRepository solicitudRepository, DetalleRequisicionRepository detalleRequisicionRepository,
                            DocumentoRepository documentoRepository,
                            TipoDocumentoRepository tIpoDocumentoRepository,
                            UnidadMedidaRepository unidadMedidaRepository,
                            DetalleRequisicionMapper detalleRequisicionMapper,
                            PrioridadRepository prioridadRepository, DocumentoMapper documentoMapper,
                            UsuarioService usuarioService, UnidadResponsableService unidadResponsableService, EstatusRepository estatusRepository, SolicitudMapper solicitudMapper, EstatusMapper estatusMapper, PrioridadMapper prioridadMapper) {
        this.solicitudRepository = solicitudRepository;
        this.detalleRequisicionRepository = detalleRequisicionRepository;
        this.documentoRepository = documentoRepository;
        this.detalleRequisicionMapper = detalleRequisicionMapper;
        this.prioridadRepository = prioridadRepository;
        this.documentoMapper = documentoMapper;
        this.estatusRepository = estatusRepository;
        this.solicitudMapper = solicitudMapper;
        this.tipoDocumentoRepository = tIpoDocumentoRepository;
        this.unidadMedidaRepository = unidadMedidaRepository;
        this.usuarioService = usuarioService;
        this.unidadResponsableService = unidadResponsableService;
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

    public Mensaje saveDocumentos(DocumentoDTO documentoDTO, int id) {
        try {
            Solicitud solicitud = solicitudRepository.findById(id).get();
            TipoDocumento tipoDocumento = tipoDocumentoRepository.findById(documentoDTO.getTipoDocumento().getIdTipoDocumento()).get();

            Documento file = new Documento();
            file.setDocumento(documentoDTO.getFile().getBytes());
            file.setSolicitud(solicitud);
            file.setTipoDocumento(tipoDocumento);

            documentoRepository.save(file);

            msg = Mensaje.CREATE("Documentos agregados correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo agregar documentos por: "+e.getMessage(), 2);
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
