package com.modules.sirsr.estatus.persistence;

import com.modules.sirsr.estatus.domain.EstatusDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class EstatusMapper {

    public Estatus toEstatus(EstatusDTO estatusDTO){
        
            if (Objects.isNull(estatusDTO)) {
                return null;
            }
            
            Estatus estatus = new Estatus();
        estatus.setIdEstatus(estatusDTO.getIdEstatus());
        estatus.setClave(estatusDTO.getClave());
        estatus.setColorhex(estatusDTO.getColorhex());
        estatus.setDescripcion(estatusDTO.getDescripcion());
        estatus.setExplicacion(estatusDTO.getExplicacion());
            
            return estatus;
        
    }

    public EstatusDTO toEstatusDTO(Estatus estatus) {

        if (Objects.isNull(estatus)) {
            return null;
        }
        EstatusDTO estatusDTO = new EstatusDTO();
        estatusDTO.setIdEstatus(estatus.getIdEstatus());
        estatusDTO.setClave(estatus.getClave());
        estatusDTO.setColorhex(estatus.getColorhex());
        estatusDTO.setDescripcion(estatus.getDescripcion());
        estatusDTO.setExplicacion(estatus.getExplicacion());
        return estatusDTO;

    }

    public List<EstatusDTO> toEstatusDTOs(List<Estatus> estatus) {
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
