package com.modules.sirsr.documento;

import com.modules.sirsr.persistence.entity.Documento;
import com.modules.sirsr.persistence.entity.Requisicion;
import com.modules.sirsr.persistence.entity.TipoDocumento;
import java.io.IOException;
import java.time.Instant;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.web.multipart.MultipartFile;

@Component
public class DocumentoMapper {

    ModelMapper modelMapper = new ModelMapper();

    public DocumentoDTO toDocumentoDTO(Documento documento){
        DocumentoDTO documentoDTO = modelMapper.map(documento, DocumentoDTO.class);
        return documentoDTO;
    }

    public Documento toDocumento(MultipartFile multipartFile, Requisicion requisicion, TipoDocumento tipoDocumento) throws IOException {
        
            if (Objects.isNull(multipartFile)) {
                return null;
            }
            
            Documento documento = new Documento();
            documento.setDocumento(multipartFile.getBytes());
            documento.setFechaActualizacion(Date.from(Instant.now()));
            documento.setRequisicion(requisicion);
            documento.setTipoDocumento(tipoDocumento);
            
            return documento;
        
    }

    public List<DocumentoDTO> toDocumentoDTOs(List<Documento> documentos){
        if (Objects.isNull(documentos)) {
            return null;
        }
        List<DocumentoDTO> list = new ArrayList<>(documentos.size());
        for (Documento documento : documentos) {
            list.add(toDocumentoDTO(documento));
        }
        return list;
    }

   
}
