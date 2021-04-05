/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.documento.domain;

import com.modules.sirsr.documento.persistence.DocumentoRepository;
import com.modules.sirsr.documento.persistence.Documento;
import com.modules.sirsr.documento.persistence.DocumentoMapper;
import com.modules.sirsr.solicitud.domain.SolicitudDTO;
import com.modules.sirsr.solicitud.domain.SolicitudService;
import com.modules.sirsr.tipoDocumento.domain.TipoDocumentoDTO;
import com.modules.sirsr.tipoDocumento.domain.TipoDocumentoService;
import com.modules.sirsr.config.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author Edward Reyes
 */
@Service
public class DocumentoService {

    private final DocumentoRepository documentoRepository;
    private final SolicitudService solicitudService;
    private final TipoDocumentoService tipoDocumentoService;
    private final DocumentoMapper documentoMapper;
    private List<Integer> idTiposDocumentosUnicos;
    private Mensaje msg;

    @Autowired
    public DocumentoService(DocumentoRepository documentoRepository, SolicitudService solicitudService, TipoDocumentoService tipoDocumentoService, DocumentoMapper documentoMapper) {
        this.documentoRepository = documentoRepository;
        this.solicitudService = solicitudService;
        this.tipoDocumentoService = tipoDocumentoService;
        this.documentoMapper = documentoMapper;
    }
    

    public List<DocumentoDTO> findAll() {
        return documentoMapper.toDocumentoDTOs(documentoRepository.findAll());
    }

    public DocumentoDTO findById(int id) {
        Optional<Documento> documentoOptional = documentoRepository.findById(id);
        DocumentoDTO documentoDTO = documentoMapper.toDocumentoDTO(documentoOptional.get());
        return documentoDTO;
    }

    public List<DocumentoDTO> findByIdSolicitud(int idSolicitud) {
        List<DocumentoDTO> documentoDTOs = documentoMapper.toDocumentoDTOs(documentoRepository.findByIdSolicitud(idSolicitud));
        return documentoDTOs;
    }

    public Mensaje save(DocumentoDTO documentoDTO, int id) {
        try {
            SolicitudDTO solicitud = solicitudService.findById(id);
            TipoDocumentoDTO tipoDocumento = tipoDocumentoService.findById(documentoDTO.getTipoDocumento().getIdTipoDocumento());
            documentoDTO.setSolicitud(solicitud);
            documentoDTO.setTipoDocumento(tipoDocumento);
            documentoRepository.save(documentoMapper.toDocumento(documentoDTO));

            msg = Mensaje.CREATE("Documentos agregados correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo agregar documento por: "+e.getMessage(), 2);
        }
        return msg;
    }


    public Mensaje deleteById(int id) {
        try {
            documentoRepository.deleteById(id);
            msg = Mensaje.CREATE("Eliminado correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo Eliminar.", 2);
        }
        return msg;

    }

    public List<Integer> getTiposDocumentoNot(int idSolicitud) {
        idTiposDocumentosUnicos = tipoDocumentoService.findAllIdDocumentosObligatorios();
        List<Integer> documentoDTOs = this.findByIdSolicitud(idSolicitud)
                .stream()
                .filter(documentoDTO -> idTiposDocumentosUnicos.contains(documentoDTO.getTipoDocumento().getIdTipoDocumento()))
                .map(documentoDTO ->
                           documentoDTO.getTipoDocumento().getIdTipoDocumento())
                .collect(Collectors.toList());
        if(documentoDTOs.isEmpty())documentoDTOs.add(0);
        return documentoDTOs;
    }

}
