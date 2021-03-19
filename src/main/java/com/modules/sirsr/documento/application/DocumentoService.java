/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.documento.application;

import com.modules.sirsr.documento.domain.DocumentoRepository;
import com.modules.sirsr.documento.domain.Documento;
import com.modules.sirsr.solicitud.domain.Solicitud;
import com.modules.sirsr.tipoDocumento.domain.TipoDocumento;
import com.modules.sirsr.requisicion.domain.RequisicionRepository;
import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.solicitud.domain.SolicitudRepository;
import com.modules.sirsr.tipoDocumento.domain.TipoDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 *
 * @author Edward Reyes
 */
@Service
public class DocumentoService {

    private final DocumentoRepository documentoRepository;
    private final SolicitudRepository solicitudRepository;
    private final TipoDocumentoRepository tipoDocumentoRepository;
    private final RequisicionRepository requisicionRepository;
    private final DocumentoMapper documentoMapper;
    private Mensaje msg;

    @Autowired
    public DocumentoService(DocumentoRepository documentoRepository, SolicitudRepository solicitudRepository, TipoDocumentoRepository tipoDocumentoRepository, RequisicionRepository requisicionRepository, DocumentoMapper documentoMapper) {
        this.documentoRepository = documentoRepository;
        this.solicitudRepository = solicitudRepository;
        this.tipoDocumentoRepository = tipoDocumentoRepository;
        this.requisicionRepository = requisicionRepository;
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

    public boolean areDocumentsComplete(int idSolicitud){
        List<DocumentoDTO> documentoDTOs = documentoMapper.toDocumentoDTOs(documentoRepository.findByIdSolicitud(idSolicitud));
        boolean isValid = documentoDTOs.stream()
                .anyMatch(documentoDTO ->
                        documentoDTO.getTipoDocumento().getIdTipoDocumento() == 1);
        boolean isValid2 = documentoDTOs.stream()
                .anyMatch(documentoDTO ->
                        documentoDTO.getTipoDocumento().getIdTipoDocumento() == 2);
        return isValid && isValid2;
    }

    public Mensaje save(DocumentoDTO documentoDTO, int id) {
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


    public Mensaje deleteById(int id) {
        try {
            documentoRepository.deleteById(id);
            msg = Mensaje.CREATE("Eliminado correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo Eliminar.", 2);
        }
        return msg;

    }

}
