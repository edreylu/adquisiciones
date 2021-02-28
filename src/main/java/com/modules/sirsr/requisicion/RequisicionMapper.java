package com.modules.sirsr.requisicion;

import com.modules.sirsr.documento.DocumentoMapper;
import com.modules.sirsr.persistence.entity.Requisicion;
import java.io.IOException;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class RequisicionMapper {

    public RequisicionDTO toRequisicionDTO(Requisicion requisicion) {
        if (Objects.isNull(requisicion)) {
            return null;
        }

        RequisicionDTO requisicionDTO = new RequisicionDTO();
        requisicionDTO.setIdRequisicion(requisicion.getIdRequisicion());
        requisicionDTO.setClaveUnidad(requisicion.getClaveUnidad());
        requisicionDTO.setFechaElaboracion(requisicion.getFechaElaboracion());
        requisicionDTO.setAnioCalendarizacion(requisicion.getAnioCalendarizacion());
        requisicionDTO.setMesCalendarizacion(requisicion.getMesCalendarizacion());
        requisicionDTO.setJustificacionDelUso(requisicion.getJustificacionDelUso());
        requisicionDTO.setFolio(requisicion.getFolio());
        requisicionDTO.setMontoSuficiencia(requisicion.getMontoSuficiencia());
        requisicionDTO.setFechaRecepcion(requisicion.getFechaRecepcion());
        requisicionDTO.setMontoAdjudicacion(BigDecimal.valueOf(1));
        requisicionDTO.setFechaAutorizacion(requisicion.getFechaAutorizacion());
        requisicionDTO.setEstatus(requisicion.getEstatus());
        requisicionDTO.setClaveEspecifica(requisicion.getClaveEspecifica());
        requisicionDTO.setDigito(requisicion.getDigito());

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
        DetalleRequisicionMapper detalleRequisicionMapper = new DetalleRequisicionMapper();
        
        Requisicion requisicion = new Requisicion();

        
        requisicion.setIdRequisicion(requisicionDTO.getIdRequisicion());
        requisicion.setClaveUnidad(requisicionDTO.getClaveUnidad());
        requisicion.setFechaElaboracion(requisicionDTO.getFechaElaboracion());
        requisicion.setAnioCalendarizacion(requisicionDTO.getAnioCalendarizacion());
        requisicion.setMesCalendarizacion(requisicionDTO.getMesCalendarizacion());
        requisicion.setJustificacionDelUso(requisicionDTO.getJustificacionDelUso());
        requisicion.setFolio(requisicionDTO.getFolio());
        requisicion.setMontoSuficiencia(requisicionDTO.getMontoSuficiencia());
        requisicion.setFechaRecepcion(requisicionDTO.getFechaRecepcion());
        requisicion.setMontoAdjudicacion(requisicionDTO.getMontoAdjudicacion());
        requisicion.setFechaAutorizacion(requisicionDTO.getFechaAutorización());
        requisicion.setEstatus(requisicionDTO.getEstatus());
        requisicion.setClaveEspecifica(requisicionDTO.getClaveEspecifica());
        requisicion.setDigito(requisicionDTO.getDigito());

        System.out.println(requisicion.toString());
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
