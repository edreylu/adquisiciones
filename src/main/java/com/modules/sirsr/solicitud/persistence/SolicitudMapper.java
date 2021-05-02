package com.modules.sirsr.solicitud.persistence;

import com.modules.sirsr.estatus.persistence.EstatusMapper;
import com.modules.sirsr.prioridad.persistence.PrioridadMapper;
import com.modules.sirsr.requisicion.persistence.RequisicionMapper;
import com.modules.sirsr.solicitud.domain.SolicitudDTO;
import com.modules.sirsr.unidadResponsable.persistence.UnidadResponsableMapper;
import org.springframework.stereotype.Component;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.*;

@Component
public class SolicitudMapper {

	public static SolicitudDTO toSolicitudDTO(Solicitud solicitud) {
		if (Objects.isNull(solicitud)) {
			return null;
		}
		Month month = Month.of(solicitud.getMesCalendarizacion());
		String monthName = month.getDisplayName(TextStyle.FULL, new Locale("es", "ES")).toUpperCase();

		SolicitudDTO solicitudDTO = new SolicitudDTO();
		solicitudDTO.setIdSolicitud(solicitud.getIdSolicitud());
		solicitudDTO.setFechaCreacion(solicitud.getFechaCreacion());
		solicitudDTO.setAnioCalendarizacion(solicitud.getAnioCalendarizacion());
		solicitudDTO.setMesCalendarizacion(solicitud.getMesCalendarizacion());
		solicitudDTO.setMesCalendarizacionStr(monthName);
		solicitudDTO.setActividadOUso(solicitud.getActividadOUso());
		solicitudDTO.setFechaEmision(solicitud.getFechaEmision());
		solicitudDTO.setFirmaDirector(solicitud.getFirmaDirector());
		solicitudDTO.setFolio(solicitud.getFolio());
		solicitudDTO.setClaveUr(solicitud.getClaveUr());
		solicitudDTO.setFechaAutorizacion(solicitud.getFechaAutorizacion());
		solicitudDTO.setFechaRecepcion(solicitud.getFechaRecepcion());
		solicitudDTO.setEstatus(EstatusMapper.toEstatusDTO(solicitud.getEstatus()));
		solicitudDTO.setPrioridad(PrioridadMapper.toPrioridadDTO(solicitud.getPrioridad()));
		solicitudDTO
				.setUnidadResponsable(UnidadResponsableMapper.toUnidadResponsableDTO(solicitud.getUnidadResponsable()));
		if (Objects.nonNull(solicitud.getRequisiciones()))
			solicitudDTO.setRequisiciones(RequisicionMapper.toRequisicionDTOs(solicitud.getRequisiciones()));
		return solicitudDTO;
	}

	public static List<SolicitudDTO> toSolicitudDTOs(List<Solicitud> solicitudes) {
		if (Objects.isNull(solicitudes)) {
			return null;
		}
		List<SolicitudDTO> list = new ArrayList<>(solicitudes.size());
		for (Solicitud solicitud : solicitudes) {
			list.add(toSolicitudDTO(solicitud));
		}
		return list;
	}

	public static Solicitud toSolicitud(SolicitudDTO solicitudDTO) {
		if (Objects.isNull(solicitudDTO)) {
			return null;
		}

		Solicitud solicitud = new Solicitud();
		solicitud.setIdSolicitud(solicitudDTO.getIdSolicitud());
		solicitud.setFechaCreacion(solicitudDTO.getFechaCreacion());
		solicitud.setAnioCalendarizacion(solicitudDTO.getAnioCalendarizacion());
		solicitud.setMesCalendarizacion(solicitudDTO.getMesCalendarizacion());
		solicitud.setActividadOUso(solicitudDTO.getActividadOUso());
		solicitud.setFechaEmision(solicitudDTO.getFechaEmision());
		solicitud.setFirmaDirector(solicitudDTO.getFirmaDirector());
		solicitud.setFolio(solicitudDTO.getFolio());
		solicitud.setClaveUr(solicitudDTO.getClaveUr());
		solicitud.setFechaAutorizacion(solicitudDTO.getFechaAutorizacion());
		solicitud.setFechaRecepcion(solicitudDTO.getFechaRecepcion());
		solicitud.setEstatus(EstatusMapper.toEstatus(solicitudDTO.getEstatus()));
		solicitud.setPrioridad(PrioridadMapper.toPrioridad(solicitudDTO.getPrioridad()));
		solicitud
				.setUnidadResponsable(UnidadResponsableMapper.toUnidadResponsable(solicitudDTO.getUnidadResponsable()));

		return solicitud;
	}

	public static Solicitud setToUpdate(SolicitudDTO solicitudFound, SolicitudDTO solicitudDTO) {
		solicitudFound.setActividadOUso(solicitudDTO.getActividadOUso());
		solicitudFound.setMesCalendarizacion(solicitudDTO.getMesCalendarizacion());
		solicitudFound.setPrioridad(solicitudDTO.getPrioridad());
		return SolicitudMapper.toSolicitud(solicitudFound);
	}

	private static String replaceCaracter(String caracter, int opcion) {
		Objects.nonNull(caracter);
		return opcion == 1 ? caracter.replaceAll(",", "\\|") : caracter.replaceAll("\\|", ",");
	}
}
