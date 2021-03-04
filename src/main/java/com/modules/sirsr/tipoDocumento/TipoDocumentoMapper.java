package com.modules.sirsr.tipoDocumento;

import com.modules.sirsr.persistence.entity.TipoDocumento;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class TipoDocumentoMapper {

    ModelMapper modelMapper = new ModelMapper();

    public TipoDocumentoDTO toTipoDocumentoDTO(TipoDocumento tipoDocumento){
        TipoDocumentoDTO tipoDocumentoDTO = modelMapper.map(tipoDocumento, TipoDocumentoDTO.class);
        return tipoDocumentoDTO;
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
