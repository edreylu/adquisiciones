package com.modules.sirsr.folioRequisicion.domain;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.modules.sirsr.folioRequisicion.persistence.FolioRequisicionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.estatus.persistence.EstatusRepository;
import com.modules.sirsr.folioRequisicion.persistence.FolioRequisicion;
import com.modules.sirsr.folioRequisicion.persistence.FolioRequisicionRepository;

@Service
public class FolioRequisicionService {

	private final FolioRequisicionMapper folioRequisicionMapper;
	private final FolioRequisicionRepository folioRequisicionRepository;
	private final EstatusRepository estatusRepository;

	@Autowired
	public FolioRequisicionService(FolioRequisicionMapper folioRequisicionMapper,
			FolioRequisicionRepository folioRequisicionRepository, EstatusRepository estatusRepository) {
		this.folioRequisicionMapper = folioRequisicionMapper;
		this.folioRequisicionRepository = folioRequisicionRepository;
		this.estatusRepository = estatusRepository;
	}

	private Mensaje msg;

	public List<FolioRequisicionDTO> findAll() {
		List<FolioRequisicion> listaFolioRequisicion = folioRequisicionRepository.findAll();
		for (FolioRequisicion folioRequisicion : listaFolioRequisicion) {
			System.out.println("Desde el service: " + folioRequisicion.getAnio());
		}
		return folioRequisicionMapper
				.toListaFolioRequisicioneDTO(listaFolioRequisicion);
	}

	public Mensaje activarInactivar(int id, int idEstatus) {
		String action = idEstatus == 1 ? "Activado" : "Inactivado";
		try {
			Optional<FolioRequisicion> folioRequisicion = folioRequisicionRepository.findById(id);
			if (folioRequisicion.isPresent()) {

				folioRequisicion.get().setEstatus(estatusRepository.findById(idEstatus).get());
			}

			folioRequisicionRepository.save(folioRequisicion.get());
			msg = Mensaje.CREATE(action + " correctamente", 1);
		} catch (Exception e) {
			msg = Mensaje.CREATE("No se pudo " + action + " por: " + e.getMessage(), 2);
		}
		return msg;

	}

	public Integer verificaAnioActual() {
		Integer anio;

		Date date = new Date();
		ZoneId timeZone = ZoneId.systemDefault();
		LocalDate getLocalDate = date.toInstant().atZone(timeZone).toLocalDate();
		anio = getLocalDate.getYear();
		Optional<FolioRequisicion> folioRequisicionConsulta = null;
		if (!Objects.isNull(anio)) {
			folioRequisicionConsulta = folioRequisicionRepository.findById(anio);
			if (folioRequisicionConsulta.isPresent()) {
				 anio =  null;
			} 
		}
		return anio;
	}

	public Mensaje save(Integer anio) {
		try {
            FolioRequisicionDTO folioRequisicionDTO = new FolioRequisicionDTO();
            folioRequisicionDTO.setAnio(anio);
            folioRequisicionDTO.setConsecutivo(1);
            folioRequisicionDTO.setEstatus(estatusRepository.findById(1).get());
			if(updateEstatusInactivo()==1) {
				folioRequisicionRepository.save(folioRequisicionMapper.toFolioRequisicion(folioRequisicionDTO));
				msg = Mensaje.CREATE("Agregado correctamente", 1);
			}
		
		} catch (Exception e) {
			msg = Mensaje.CREATE("No se pudo agregar por: " + e.getMessage(), 2);
		}
		return msg;
	}
	
	private int updateEstatusInactivo() {
		try {
            folioRequisicionRepository.inactiveAll(0,1);
            return 1;
			
		} catch (Exception e) {
			System.out.println("Error al actualizar: " + e.getMessage());
			return 0;
		}
		
	}

}
