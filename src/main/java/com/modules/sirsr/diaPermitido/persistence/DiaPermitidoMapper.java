package com.modules.sirsr.diaPermitido.persistence;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.modules.sirsr.diaPermitido.domain.DiaPermitidoDTO;
import com.modules.sirsr.estatus.persistence.EstatusMapper;
import com.modules.sirsr.config.util.Fecha;

import org.springframework.stereotype.Component;

public class DiaPermitidoMapper {

	public static DiaPermitidoDTO toDiaPermitidoDTO(DiaPermitido diaPermitido) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(diaPermitido.getDiaPermitido());

		DiaPermitidoDTO diaPermitidoDTO = new DiaPermitidoDTO();
		diaPermitidoDTO.setDiaPermitido(diaPermitido.getDiaPermitido());
		diaPermitidoDTO.setEstatus(EstatusMapper.toEstatusDTO(diaPermitido.getEstatus()));
		diaPermitidoDTO.setAnio(calendar.get(Calendar.YEAR));
		diaPermitidoDTO.setMes(Fecha.obtenerTextoMes(diaPermitido.getDiaPermitido()));
		diaPermitidoDTO.setIdDia(Fecha.obtenerDiaMes(diaPermitido.getDiaPermitido()));
		diaPermitidoDTO.setIdMes(Fecha.obtenerMes(diaPermitido.getDiaPermitido()));

		return diaPermitidoDTO;
	}

	public static DiaPermitido toDiaPermitido(DiaPermitidoDTO diaPermitidoDTO) {

		DiaPermitido diaPermitido = new DiaPermitido();
		diaPermitido.setDiaPermitido(diaPermitidoDTO.getDiaPermitido());
		diaPermitido.setEstatus(EstatusMapper.toEstatus(diaPermitidoDTO.getEstatus()));

		return diaPermitido;
	}

	public static List<DiaPermitidoDTO> toDiasPermitodosDTO(List<DiaPermitido> diasPermitidos) {

		List<DiaPermitidoDTO> listaDiasPermitidosDTO = new ArrayList<DiaPermitidoDTO>();

		for (DiaPermitido diaPermitido : diasPermitidos) {
			listaDiasPermitidosDTO.add(toDiaPermitidoDTO(diaPermitido));
		}

		return listaDiasPermitidosDTO;
	}

}
