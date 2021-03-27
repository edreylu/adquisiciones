package com.modules.sirsr.diaPermitido.application;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.springframework.stereotype.Component;

import com.modules.sirsr.diaPermitido.domain.DiaPermitido;

@Component
public class DiaPermitidoMapper {

	public DiaPermitidoDTO toDiaPermitidoDTO(DiaPermitido diaPermitido) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(diaPermitido.getDiaPermitido());
		
		DiaPermitidoDTO diaPermitidoDTO = new DiaPermitidoDTO();
		diaPermitidoDTO.setDiaPermitido(diaPermitido.getDiaPermitido());
		diaPermitidoDTO.setEstatus(diaPermitido.getEstatus());
		diaPermitidoDTO.setAnio(calendar.get(Calendar.YEAR));
		diaPermitidoDTO.setMes(diaPermitidoDTO.obtenerTextoMes(diaPermitido.getDiaPermitido()));
		diaPermitidoDTO.setDia(diaPermitidoDTO.obtenerDia(diaPermitido.getDiaPermitido()));
		
		return diaPermitidoDTO;
	}
	
	public DiaPermitido toDiaPermitido(DiaPermitidoDTO diaPermitidoDTO) {
		
		DiaPermitido diaPermitido = new DiaPermitido();
		diaPermitido.setDiaPermitido(diaPermitidoDTO.getDiaPermitido());
		diaPermitido.setEstatus(diaPermitidoDTO.getEstatus());
		
		return diaPermitido;
	}
	
	public List<DiaPermitidoDTO> toDiasPermitodosDTO(List<DiaPermitido> diasPermitidos){
		
		List<DiaPermitidoDTO> listaDiasPermitidosDTO = new ArrayList<DiaPermitidoDTO>();
		
		for (DiaPermitido diaPermitido : diasPermitidos) {
			listaDiasPermitidosDTO.add(toDiaPermitidoDTO(diaPermitido));
		}        
		
		return listaDiasPermitidosDTO;
	}
	
	
	
}
