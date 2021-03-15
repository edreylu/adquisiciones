package com.modules.sirsr.requisicion.application;

import com.modules.sirsr.documento.application.DocumentoMapper;
import com.modules.sirsr.estatus.application.EstatusDTO;
import com.modules.sirsr.requisicion.domain.Requisicion;

import java.io.IOException;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class RequisicionMapper {

    ModelMapper modelMapper = new ModelMapper();

    public RequisicionDTO toRequisicionDTO(Requisicion requisicion) {
        if (Objects.isNull(requisicion)) {
            return null;
        }
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        RequisicionDTO requisicionDTO = modelMapper.map(requisicion, RequisicionDTO.class);
        EstatusDTO estatus = requisicionDTO.getEstatus();
        System.out.println(estatus.toString());
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
