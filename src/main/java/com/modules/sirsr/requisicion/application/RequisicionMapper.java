package com.modules.sirsr.requisicion.application;

import com.modules.sirsr.clavePresupuestaria.application.ClavePresupuestariaMapper;
import com.modules.sirsr.documento.application.DocumentoMapper;
import com.modules.sirsr.estatus.application.EstatusMapper;
import com.modules.sirsr.montoAdjudicacion.application.MontoAdjudicacionMapper;
import com.modules.sirsr.requisicion.domain.Requisicion;

import java.io.IOException;

import com.modules.sirsr.solicitud.application.SolicitudMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class RequisicionMapper {

    ModelMapper modelMapper = new ModelMapper();
    private final ClavePresupuestariaMapper clavePresupuestariaMapper = new ClavePresupuestariaMapper();
    private final EstatusMapper estatusMapper = new EstatusMapper();
    private final SolicitudMapper solicitudMapper = new SolicitudMapper();
    private final MontoAdjudicacionMapper montoAdjudicacionMapper = new MontoAdjudicacionMapper();

    public RequisicionDTO toRequisicionDTO(Requisicion requisicion) {
        if (Objects.isNull(requisicion)) {
            return null;
        }
        RequisicionDTO requisicionDTO = new RequisicionDTO();
        requisicionDTO.setIdRequisicion(requisicion.getIdRequisicion());
        requisicionDTO.setEstatus(estatusMapper.toEstatusDTO(requisicion.getEstatus()));
        requisicionDTO.setMontoAdjudicacion(montoAdjudicacionMapper.toMontoAdjudicacionDTO(requisicion.getMontoAdjudicacion()));
        requisicionDTO.setMontoSuficiencia(requisicion.getMontoSuficiencia());
        requisicionDTO.setSolicitud(solicitudMapper.toSolicitudDTO(requisicion.getSolicitud()));
        requisicionDTO.setIdSolicitud(requisicion.getSolicitud().getIdSolicitud());
        requisicionDTO.setClavePresupuestaria(clavePresupuestariaMapper.toClavePresupuestariaDTO(requisicion.getClavePresupuestaria()));
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
