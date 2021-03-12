package com.modules.sirsr.requisicion;

import com.modules.sirsr.documento.DocumentoMapper;
import com.modules.sirsr.persistence.entity.Requisicion;

import java.io.IOException;
import java.math.BigDecimal;

import com.modules.sirsr.unidadResponsable.UnidadResponsableMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class RequisicionMapper {

    ModelMapper modelMapper = new ModelMapper();
    private final UnidadResponsableMapper unidadResponsableMapper = new UnidadResponsableMapper();

    public RequisicionDTO toRequisicionDTO(Requisicion requisicion) {
        if (Objects.isNull(requisicion)) {
            return null;
        }
        RequisicionDTO requisicionDTO = modelMapper.map(requisicion, RequisicionDTO.class);

        return requisicionDTO;
    }

    public List<RequisicionDTO> toRequisicionDTOs(List<Requisicion> requisiciones) {
        if (Objects.isNull(requisiciones)) {
            return null;
        }
        List<RequisicionDTO> list = new ArrayList<>(requisiciones.size());
        for (Requisicion requisicion : requisiciones) {
            list.add(toRequisicionDTO(requisicion));
        }
        return list;
    }

    public Requisicion toRequisicion(RequisicionDTO requisicionDTO) throws IOException {
        if (Objects.isNull(requisicionDTO)) {
            return null;
        }
        
        DocumentoMapper documentoMapper = new DocumentoMapper();

        Requisicion requisicion = modelMapper.map(requisicionDTO, Requisicion.class);
        return requisicion;
    }

    public Requisicion setToUpdate(Requisicion requisicionFound, RequisicionDTO requisicionDTO) {
        //requisicionFound.setRequisicionName("ROLE_" + requisicionDTO.getRequisicionName());
        return requisicionFound;
    }
    
    private String replaceCaracter(String caracter, int opcion) {
        Objects.nonNull(caracter);
        return opcion == 1 ? caracter.replaceAll(",", "\\|") : caracter.replaceAll("\\|", ",");
    }
}
