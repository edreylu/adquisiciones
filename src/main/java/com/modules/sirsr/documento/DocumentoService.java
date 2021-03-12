/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.documento;

import com.modules.sirsr.persistence.entity.Documento;
import com.modules.sirsr.persistence.entity.Requisicion;
import com.modules.sirsr.persistence.entity.TipoDocumento;
import com.modules.sirsr.persistence.repository.*;
import com.modules.sirsr.utils.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

/**
 *
 * @author Edward Reyes
 */
@Service
public class DocumentoService {

    private final DocumentoRepository documentoRepository;
    private final TipoDocumentoRepository tipoDocumentoRepository;
    private final RequisicionRepository requisicionRepository;
    private final DocumentoMapper documentoMapper;
    private Mensaje msg;

    @Autowired
    public DocumentoService(DocumentoRepository documentoRepository, TipoDocumentoRepository tipoDocumentoRepository, RequisicionRepository requisicionRepository, DocumentoMapper documentoMapper) {
        this.documentoRepository = documentoRepository;
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

    public List<DocumentoDTO> findByIdRequisicion(int idSolicitud) {
        List<DocumentoDTO> documentoDTOs = documentoMapper.toDocumentoDTOs(documentoRepository.findByIdSolicitud(idSolicitud));
        return documentoDTOs;
    }

    public Mensaje save(DocumentoDTO documentoDTO, MultipartFile multipartFile) {
        try {
            Documento documento = new Documento();
            TipoDocumento tipoDocumento = tipoDocumentoRepository.findById(documentoDTO.getTipoDocumento().getIdTipoDocumento()).get();
            Requisicion requisicion = requisicionRepository.findById(documentoDTO.getRequisicion().getIdRequisicion()).get();
            documento.setDocumento(multipartFile.getBytes());
            documento.setTipoDocumento(tipoDocumento);
            //documento.setSolicitud(requisicion);
            documentoRepository.save(documento);

            msg = Mensaje.CREATE("Agregado correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo agregar por: "+e.getMessage(), 2);
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
