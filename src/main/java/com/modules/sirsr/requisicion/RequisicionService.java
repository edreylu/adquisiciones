/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.requisicion;

import com.modules.sirsr.documento.DocumentoMapper;
import com.modules.sirsr.persistence.entity.Documento;
import com.modules.sirsr.persistence.entity.Requisicion;
import com.modules.sirsr.persistence.entity.TipoDocumento;
import com.modules.sirsr.persistence.entity.UnidadMedida;
import com.modules.sirsr.persistence.repository.DetalleRequisicionRepository;
import com.modules.sirsr.persistence.repository.DocumentoRepository;
import com.modules.sirsr.persistence.repository.RequisicionRepository;

import java.util.List;
import java.util.Optional;

import com.modules.sirsr.utils.Mensaje;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.modules.sirsr.persistence.repository.TipoDocumentoRepository;
import com.modules.sirsr.persistence.repository.UnidadMedidaRepository;
import com.modules.sirsr.usuario.UsuarioDTO;
import com.modules.sirsr.usuario.UsuarioService;
import com.modules.sirsr.utils.WebUtils;
import java.util.Objects;

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
    private final DocumentoMapper documentoMapper;
    private final RequisicionMapper requisicionMapper;
    private UsuarioDTO usuarioDTO;
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
            UsuarioService usuarioService) {
        this.requisicionRepository = requisicionRepository;
        this.detalleRequisicionRepository = detalleRequisicionRepository;
        this.documentoRepository = documentoRepository;
        this.detalleRequisicionMapper = detalleRequisicionMapper;
        this.documentoMapper = documentoMapper;
        this.requisicionMapper = requisicionMapper;
        this.tipoDocumentoRepository = tIpoDocumentoRepository;
        this.unidadMedidaRepository = unidadMedidaRepository;
        this.usuarioService = usuarioService;
    }
    

    public List<RequisicionDTO> findAll() {
        return requisicionMapper.toRequisicionDTOs(requisicionRepository.findAll());
    }

    public List<RequisicionDTO> findByClaveUnidad() {
        usuarioDTO = usuarioService.findByUserName(WebUtils.getUserName());
        return requisicionMapper.toRequisicionDTOs(requisicionRepository.findByClaveUnidad(usuarioDTO.getClaveUnidad()));
    }

    public RequisicionDTO findById(int id) {
        Optional<Requisicion> requisicionOptional = requisicionRepository.findById(id);
        RequisicionDTO requisicionDTO = requisicionMapper.toRequisicionDTO(requisicionOptional.get());
        return requisicionDTO;
    }

    public Mensaje save(RequisicionDTO requisicionDTO) {
        try {
            usuarioDTO = usuarioService.findByUserName(WebUtils.getUserName());
            TipoDocumento suficiencia = tipoDocumentoRepository.findById(1).get();
            TipoDocumento ofi = tipoDocumentoRepository.findById(2).get();
            TipoDocumento otr = tipoDocumentoRepository.findById(3).get();
            
            Calendar calendar = Calendar.getInstance();
            int annio = calendar.get(Calendar.YEAR);
            requisicionDTO.setClaveUnidad(usuarioDTO.getClaveUnidad());
            requisicionDTO.setFechaElaboracion(Date.from(Instant.now()));
            requisicionDTO.setAnioCalendarizacion(annio);
            requisicionDTO.setEstatus(1);
            Requisicion requisicion = requisicionRepository.save(requisicionMapper.toRequisicion(requisicionDTO));
            
        Documento volanteSuficiencia = new Documento();
        volanteSuficiencia.setDocumento(requisicionDTO.getVolanteSuficiencia().getBytes());
        volanteSuficiencia.setRequisicion(requisicion);
        volanteSuficiencia.setTipoDocumento(suficiencia);
        
        Documento oficio = new Documento();
        oficio.setDocumento(requisicionDTO.getOficio().getBytes());
        oficio.setRequisicion(requisicion);
        oficio.setTipoDocumento(ofi);
        
        if(Objects.nonNull(requisicionDTO.getOtro())){
        Documento otro = new Documento();
        otro.setDocumento(requisicionDTO.getOtro().getBytes());
        otro.setRequisicion(requisicion);
        otro.setTipoDocumento(otr);
        documentoRepository.save(otro);
        }
        documentoRepository.save(volanteSuficiencia);
        documentoRepository.save(oficio);
        
        
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
        
            msg = Mensaje.CREATE("Agregado correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo agregar por: "+e.getMessage(), 2);
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
