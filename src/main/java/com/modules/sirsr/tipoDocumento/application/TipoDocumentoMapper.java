package com.modules.sirsr.tipoDocumento.application;

import com.modules.sirsr.estatus.application.EstatusMapper;
import com.modules.sirsr.tipoDocumento.domain.TipoDocumento;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class TipoDocumentoMapper {

    private final EstatusMapper estatusMapper = new EstatusMapper();

    public TipoDocumentoDTO toTipoDocumentoDTO(TipoDocumento tipoDocumento){
        TipoDocumentoDTO tipoDocumentoDTO = new TipoDocumentoDTO();
        tipoDocumentoDTO.setIdTipoDocumento(tipoDocumento.getIdTipoDocumento());
        tipoDocumentoDTO.setDescripcion(tipoDocumento.getDescripcion());
        tipoDocumentoDTO.setEstatus(estatusMapper.toEstatusDTO(tipoDocumento.getEstatus()));
        return tipoDocumentoDTO;
    }

    public TipoDocumento toTipoDocumento(TipoDocumentoDTO tipoDocumentoDTO){
        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setIdTipoDocumento(tipoDocumentoDTO.getIdTipoDocumento());
        tipoDocumento.setDescripcion(tipoDocumentoDTO.getDescripcion());
        tipoDocumento.setEstatus(estatusMapper.toEstatus(tipoDocumentoDTO.getEstatus()));
        return tipoDocumento;
    }

    public List<TipoDocumentoDTO> toTipoDocumentoDTOs(List<TipoDocumento> tipoDocumentos){
        if (Objects.isNull(tipoDocumentos)) {
            return null;
        }
        List<TipoDocumentoDTO> list = new ArrayList<>(tipoDocumentos.size());
        for (TipoDocumento tipoDocumento : tipoDocumentos) {
            list.add(toTipoDocumentoDTO(tipoDocumento));
        }
        return list;
    }

   
}
