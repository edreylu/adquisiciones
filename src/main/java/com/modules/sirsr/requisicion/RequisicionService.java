/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.requisicion;

import com.modules.sirsr.documento.DocumentoDTO;
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
public class RequisicionService {
    
    private final RequisicionRepository requisicionRepository;
    private final DetalleRequisicionRepository detalleRequisicionRepository;
    private final DocumentoRepository documentoRepository;
    private final UsuarioService usuarioService;
    private final DetalleRequisicionMapper detalleRequisicionMapper;
    private final TipoDocumentoRepository tipoDocumentoRepository;
    private final UnidadMedidaRepository unidadMedidaRepository;
    private final UnidadResponsableService unidadResponsableService;
    private final DocumentoMapper documentoMapper;
    private final RequisicionMapper requisicionMapper;
    private UsuarioDTO usuarioDTO;
    private UnidadResponsableDTO unidadResponsableDTO;
    private Mensaje msg;

    @Autowired
    public RequisicionService(RequisicionRepository requisicionRepository,
                              DetalleRequisicionRepository detalleRequisicionRepository,
                              DocumentoRepository documentoRepository,
                              TipoDocumentoRepository tIpoDocumentoRepository,
                              UnidadMedidaRepository unidadMedidaRepository,
                              DetalleRequisicionMapper detalleRequisicionMapper,
                              DocumentoMapper documentoMapper,
                              RequisicionMapper requisicionMapper,
                              UsuarioService usuarioService, UnidadResponsableService unidadResponsableService) {
        this.requisicionRepository = requisicionRepository;
        this.detalleRequisicionRepository = detalleRequisicionRepository;
        this.documentoRepository = documentoRepository;
        this.detalleRequisicionMapper = detalleRequisicionMapper;
        this.documentoMapper = documentoMapper;
        this.requisicionMapper = requisicionMapper;
        this.tipoDocumentoRepository = tIpoDocumentoRepository;
        this.unidadMedidaRepository = unidadMedidaRepository;
        this.usuarioService = usuarioService;
        this.unidadResponsableService = unidadResponsableService;
    }
    

    public List<RequisicionDTO> findAll() {
        return requisicionMapper.toRequisicionDTOs(requisicionRepository.findAll());
    }


    public RequisicionDTO findById(int id) {
        Optional<Requisicion> requisicionOptional = requisicionRepository.findById(id);
        RequisicionDTO requisicionDTO = requisicionMapper.toRequisicionDTO(requisicionOptional.get());
        return requisicionDTO;
    }

    public Mensaje save(RequisicionDTO requisicionDTO) {
        try {
            usuarioDTO = usuarioService.findByUserName(WebUtils.getUserName());
            unidadResponsableDTO = unidadResponsableService.findByClaveUr(usuarioDTO.getUnidadResponsable().getClaveUr());
            Calendar calendar = Calendar.getInstance();
            int annio = calendar.get(Calendar.YEAR);
            requisicionDTO.setUnidadResponsable(usuarioDTO.getUnidadResponsable());
            requisicionDTO.setFechaElaboracion(Date.from(Instant.now()));
            requisicionDTO.setAnioCalendarizacion(annio);
            requisicionDTO.setEstatus(1);
            Requisicion requisicion = requisicionRepository.save(requisicionMapper.toRequisicion(requisicionDTO));

            msg = Mensaje.CREATE("Agregado correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo agregar por: "+e.getMessage(), 2);
        }
        return msg;
    }


    public Mensaje saveDetalles(RequisicionDTO requisicionDTO, int id) {
        try {
            Requisicion requisicion = requisicionRepository.findById(id).get();
            String[] unidades = requisicionDTO.getIdUnidadMedida().split(",");
            String[] cantidades = requisicionDTO.getCantidad().split(",");
            String[] caracteristicas = requisicionDTO.getCaracteristicas().split(",");

            for(int i=0; i < caracteristicas.length; i++){
                int unidad = Integer.parseInt(unidades[i]);
                int cantidad = Integer.parseInt(cantidades[i]);
                UnidadMedida unidadMedida = unidadMedidaRepository.findById(unidad).get();
                detalleRequisicionRepository.save(detalleRequisicionMapper.toDetalleRequisicion(
                        cantidad,
                        caracteristicas[i],
                        unidadMedida,
                        requisicion));
            }

            msg = Mensaje.CREATE("Detalles agregados correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo agregar detalles por: "+e.getMessage(), 2);
        }
        return msg;
    }

    public Mensaje saveDocumentos(DocumentoDTO documentoDTO, int id) {
        try {
            Requisicion requisicion = requisicionRepository.findById(id).get();
            TipoDocumento tipoDocumento = tipoDocumentoRepository.findById(documentoDTO.getTipoDocumento().getIdTipoDocumento()).get();

            Documento file = new Documento();
            file.setDocumento(documentoDTO.getFile().getBytes());
            //file.setRequisicion(requisicion);
            file.setTipoDocumento(tipoDocumento);

            documentoRepository.save(file);

            msg = Mensaje.CREATE("Documentos agregados correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo agregar documentos por: "+e.getMessage(), 2);
        }
        return msg;
    }

    public Mensaje update(RequisicionDTO requisicionDTO, int id) {
        try {
            Optional<Requisicion> requisicionFound = requisicionRepository.findById(id);
            Requisicion requisicion = requisicionMapper.setToUpdate(requisicionFound.get(), requisicionDTO);
            requisicionRepository.save(requisicion);
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
            msg = Mensaje.CREATE("No se pudo Eliminar por que hay usuarios asociados a rol.", 2);
        }
        return msg;

    }

}
