package com.modules.sirsr.detalleRequisicion.application;

import com.modules.sirsr.detalleRequisicion.domain.DetalleRequisicion;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class DetalleRequisicionMapper {

    ModelMapper modelMapper = new ModelMapper();

    public DetalleRequisicion toDetalleRequisicion(DetalleRequisicionDTO detalleRequisicionDTO) {
        
        if(Objects.isNull(detalleRequisicionDTO)){
            return null;
        }
         DetalleRequisicion detalleRequisicion = modelMapper.map(detalleRequisicionDTO, DetalleRequisicion.class);

        return detalleRequisicion;
    }

    public DetalleRequisicionDTO toDetalleRequisicionDTO(DetalleRequisicion detalleRequisicion) {

        if(Objects.isNull(detalleRequisicion)){
            return null;
        }
        DetalleRequisicionDTO detalleRequisicionDTO = modelMapper.map(detalleRequisicion, DetalleRequisicionDTO.class);

        return detalleRequisicionDTO;
    }

    public List<DetalleRequisicionDTO> toDetalleRequisicionDTOs(List<DetalleRequisicion> detalleRequisiciones) {
        if (Objects.isNull(detalleRequisiciones)) {
            return null;
        }
        List<DetalleRequisicionDTO> list = new ArrayList<>(detalleRequisiciones.size());
        for (DetalleRequisicion detalleRequisicion : detalleRequisiciones) {
            list.add(toDetalleRequisicionDTO(detalleRequisicion));
        }
        return list;
    }

}
