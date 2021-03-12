package com.modules.sirsr.estatus;

import com.modules.sirsr.documento.DocumentoDTO;
import com.modules.sirsr.persistence.entity.Documento;
import com.modules.sirsr.persistence.entity.Estatus;
import com.modules.sirsr.persistence.entity.Solicitud;
import com.modules.sirsr.persistence.entity.TipoDocumento;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Component
public class EstatusMapper {

    ModelMapper modelMapper = new ModelMapper();

    public Estatus toEstatus(EstatusDTO estatusDTO) throws IOException {
        
            if (Objects.isNull(estatusDTO)) {
                return null;
            }
            
            Estatus estatus = modelMapper.map(estatusDTO, Estatus.class);
            
            return estatus;
        
    }

    public EstatusDTO toEstatusDTO(Estatus estatus) throws IOException {

        if (Objects.isNull(estatus)) {
            return null;
        }

        EstatusDTO estatusDTO = modelMapper.map(estatus, EstatusDTO.class);

        return estatusDTO;

    }

    public List<EstatusDTO> toEstatusDTOs(List<Estatus> estatus) throws IOException {
        if (Objects.isNull(estatus)) {
            return null;
        }
        List<EstatusDTO> list = new ArrayList<>(estatus.size());
        for (Estatus estatusr : estatus) {
            list.add(toEstatusDTO(estatusr));
        }
        return list;
    }

   
}
