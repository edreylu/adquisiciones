package com.modules.sirsr.requisicion.persistence;

import com.modules.sirsr.clavePresupuestaria.domain.ClavePresupuestariaDTO;
import com.modules.sirsr.clavePresupuestaria.persistence.ClavePresupuestariaMapper;
import com.modules.sirsr.estatus.domain.EstatusDTO;
import com.modules.sirsr.estatus.persistence.EstatusMapper;
import com.modules.sirsr.montoAdjudicacion.persistence.MontoAdjudicacionMapper;
import com.modules.sirsr.requisicion.domain.RequisicionDTO;

import com.modules.sirsr.solicitud.persistence.SolicitudMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class RequisicionMapper {

	public static RequisicionDTO toRequisicionDTO(Requisicion requisicion) {
		if (Objects.isNull(requisicion)) {
			return null;
		}
		RequisicionDTO requisicionDTO = new RequisicionDTO();
		requisicionDTO.setIdRequisicion(requisicion.getIdRequisicion());
		requisicionDTO.setIdSolicitud(requisicion.getIdSolicitud());
		requisicionDTO.setEstatus(EstatusMapper.toEstatusDTO(requisicion.getEstatus()));
		// requisicionDTO.setMontoAdjudicacion(montoAdjudicacionMapper.toMontoAdjudicacionDTO(requisicion.getMontoAdjudicacion()));
		requisicionDTO.setMontoSuficiencia(requisicion.getMontoSuficiencia());
		requisicionDTO.setClavePresupuestaria(
				ClavePresupuestariaMapper.toClavePresupuestariaDTO(requisicion.getClavePresupuestaria()));
		requisicionDTO.setDetallesRequisiciones(
				DetalleRequisicionMapper.toDetalleRequisicionDTOs(requisicion.getDetallesRequisicion()));
		return requisicionDTO;
	}

	public static List<RequisicionDTO> toRequisicionDTOs(List<Requisicion> requisiciones) {
		if (Objects.isNull(requisiciones)) {
			return null;
		}
		List<RequisicionDTO> list = new ArrayList<>(requisiciones.size());
		for (Requisicion requisicion : requisiciones) {
			list.add(toRequisicionDTO(requisicion));
		}
		return list;
	}

	public static Requisicion toRequisicion(RequisicionDTO requisicionDTO) {
		if (Objects.isNull(requisicionDTO)) {
			return null;
		}
		Requisicion requisicion = new Requisicion();
		requisicion.setIdRequisicion(requisicionDTO.getIdRequisicion());
		requisicion.setIdSolicitud(requisicionDTO.getIdSolicitud());
		requisicion.setEstatus(EstatusMapper.toEstatus(requisicionDTO.getEstatus()));
		// requisicion.setMontoAdjudicacion(montoAdjudicacionMapper.toMontoAdjudicacion(requisicionDTO.getMontoAdjudicacion()));
		requisicion.setMontoSuficiencia(requisicionDTO.getMontoSuficiencia());
		requisicion.setSolicitud(SolicitudMapper.toSolicitud(requisicionDTO.getSolicitud()));
		requisicion.setClavePresupuestaria(
				ClavePresupuestariaMapper.toClavePresupuestaria(requisicionDTO.getClavePresupuestaria()));
		return requisicion;
	}

	public static Requisicion setToUpdate(Requisicion requisicionFound, RequisicionDTO requisicionDTO) {
		requisicionFound.setClavePresupuestaria(
				ClavePresupuestariaMapper.toClavePresupuestaria(requisicionDTO.getClavePresupuestaria()));
		requisicionFound.setMontoSuficiencia(requisicionDTO.getMontoSuficiencia());
		return requisicionFound;
	}

	private String replaceCaracter(String caracter, int opcion) {
		Objects.nonNull(caracter);
		return opcion == 1 ? caracter.replaceAll(",", "\\|") : caracter.replaceAll("\\|", ",");
	}
}
