package com.modules.sirsr.diaPermitido.domain;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.modules.sirsr.diaPermitido.persistence.DiaPermitidoMapper;
import com.modules.sirsr.estatus.domain.EstatusDTO;
import com.modules.sirsr.estatus.domain.EstatusService;
import com.modules.sirsr.estatus.persistence.Estatus;
import com.modules.sirsr.estatus.persistence.EstatusMapper;
import com.modules.sirsr.estatus.persistence.EstatusRepository;
import com.modules.sirsr.config.util.Fecha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.diaPermitido.persistence.DiaPermitido;
import com.modules.sirsr.diaPermitido.persistence.DiaPermitidoRepository;

@Service
public class DiaPermitidoService {

	private final DiaPermitidoRepository diaPermitidoRepository;
	private final EstatusService estatusService;
	private Mensaje msg;

	@Autowired
	public DiaPermitidoService(DiaPermitidoRepository diaPermitidoRepository, EstatusService estatusService) {
		this.diaPermitidoRepository = diaPermitidoRepository;
		this.estatusService = estatusService;
	}

	public List<DiaPermitidoDTO> findAll() {
		List<DiaPermitido> diasPermitidos = diaPermitidoRepository.findAllByOrderByDiaPermitidoDesc();

		return DiaPermitidoMapper.toDiasPermitodosDTO(diasPermitidos);
	}

	public Mensaje saveDay(DiaPermitidoDTO diaPermitidoDTO) {
		try {
			String msgValidacion = validaFechaActual(diaPermitidoDTO.getDiaPermitido());
			if (Objects.isNull(msgValidacion)) {
				diaPermitidoDTO.setEstatus(estatusService.findById(1));
				DiaPermitido diaPermitido = DiaPermitidoMapper.toDiaPermitido(diaPermitidoDTO);
				diaPermitidoRepository.save(diaPermitido);
				msg = Mensaje.success("Agregado correctamente");
			} else {
				msg = Mensaje.warning(msgValidacion);
			}

		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo agregar por: " + e.getMessage());
		}
		return msg;
	}

	public Mensaje saveDays(DiaPermitidoDTO diaPermitidoDTO) {
		try {

			String msgValidacion = validaFechaActual(diaPermitidoDTO.getDiaPermitidoInicio());
			if (Objects.isNull(msgValidacion)) {
				List<Date> fechas = getDatesBetween(diaPermitidoDTO);
				if (Objects.isNull(fechas)) {
					return msg = Mensaje.danger("La fecha inicial no debe ser mayor a la fecha final");
				} else {
					EstatusDTO estatus = estatusService.findById(1);
					DiaPermitido diaPermitido;
					for (Date date : fechas) {

						diaPermitidoDTO.setDiaPermitido(date);
						diaPermitidoDTO.setEstatus(estatus);
						diaPermitido = DiaPermitidoMapper.toDiaPermitido(diaPermitidoDTO);

						diaPermitidoRepository.save(diaPermitido);

						msg = Mensaje.success("Días agregados correctamente");
					}
				}
			} else {
				msg = Mensaje.warning(msgValidacion);
			}

		} catch (Exception e) {
			msg = Mensaje.danger("No se pudieron agregar los días por: " + e.getMessage());
		}
		return msg;
	}

	public Mensaje inactivarPorId(Date date, int idEstatus) {

		String action = idEstatus == 1 ? "Activado" : "Inactivado";
		try {
			Optional<DiaPermitido> diaPermitidofound = diaPermitidoRepository.findById(date);
			EstatusDTO estatusFound = estatusService.findById(idEstatus);
			if (Objects.nonNull(estatusFound)) {
				diaPermitidofound.get().setEstatus(EstatusMapper.toEstatus(estatusFound));
			}

			diaPermitidoRepository.save(diaPermitidofound.get());
			msg = Mensaje.success(action + " correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo " + action + " por: " + e.getMessage());
		}
		return msg;

	}

	public List<Date> getDatesBetween(DiaPermitidoDTO diaPermitidoDTO) {
		LocalDate inicio = Fecha.convertToLocalDateViaMilisecond(diaPermitidoDTO.getDiaPermitidoInicio());
		LocalDate fin = Fecha.convertToLocalDateViaMilisecond(diaPermitidoDTO.getDiaPermitidoFin());

		long noDias = ChronoUnit.DAYS.between(inicio, fin);
		List<Date> listaFechas = new ArrayList<Date>();

		if (noDias >= 2) {
			Date date;
			listaFechas.add(diaPermitidoDTO.getDiaPermitidoInicio());
			for (int i = 1; i <= noDias; i++) {
				inicio.plusDays(i);
				date = Date.from(inicio.plusDays(i).atStartOfDay(ZoneId.systemDefault()).toInstant());
				listaFechas.add(date);
			}

			listaFechas.add(diaPermitidoDTO.getDiaPermitidoFin());
		} else if (noDias == 1) {
			listaFechas.add(diaPermitidoDTO.getDiaPermitidoInicio());
			listaFechas.add(diaPermitidoDTO.getDiaPermitidoFin());

		} else if (noDias == 0) {
			listaFechas.add(diaPermitidoDTO.getDiaPermitidoInicio());

		} else {

			listaFechas = null; // significa que la fecha inicial es mayor que la fecha fin
		}

		return listaFechas;
	}

	public String validaFechaActual(Date date) {
		String mensaje = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date fechaInicio;
		try {
			fechaInicio = simpleDateFormat.parse(simpleDateFormat.format(date));
			Date hoy = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
			if (fechaInicio.before(hoy)) {
				mensaje = "No se pueden agregar días anteriores";
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		return mensaje;
	}

}
