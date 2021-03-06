/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.proveedor.domain;

import com.modules.sirsr.proveedor.persistence.Proveedor;
import com.modules.sirsr.proveedor.persistence.ProveedorMapper;
import com.modules.sirsr.proveedor.persistence.ProveedorRepository;
import com.modules.sirsr.tipoPersonaFiscal.persistence.TipoPersonaFiscal;
import com.modules.sirsr.tipoPersonaFiscal.persistence.TipoPersonaFiscalRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.modules.sirsr.actividad.domain.ActividadDTO;
import com.modules.sirsr.actividad.persistence.Actividad;
import com.modules.sirsr.actividad.persistence.ActividadRepository;
import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.estatus.persistence.Estatus;
import com.modules.sirsr.estatus.persistence.EstatusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Edward Reyes
 */
@Service
public class ProveedorService {

	private final ProveedorRepository proveedorRepository;
	private final TipoPersonaFiscalRepository tipoPersonaFiscalRepository;
	private final EstatusRepository estatusRepository;
	private final ActividadRepository actividadRepository;
	private Mensaje msg;

	@Autowired
	public ProveedorService(ProveedorRepository proveedorRepository,
			TipoPersonaFiscalRepository tipoPersonaFiscalRepository, EstatusRepository estatusRepository,
			ActividadRepository actividadRepository) {
		this.proveedorRepository = proveedorRepository;
		this.tipoPersonaFiscalRepository = tipoPersonaFiscalRepository;
		this.estatusRepository = estatusRepository;
		this.actividadRepository = actividadRepository;

	}

	public List<ProveedorDTO> findAll() {
		return ProveedorMapper.toProveedorDTOs(proveedorRepository.findAll());
	}

	public ProveedorDTO findById(int id) {
		Optional<Proveedor> proveedorOptional = proveedorRepository.findById(id);
		ProveedorDTO proveedorDTO = ProveedorMapper.toProveedorDTO(proveedorOptional.get());
		return proveedorDTO;
	}

	public Mensaje save(ProveedorDTO proveedorDTO) {
		try {

			Proveedor prov = ProveedorMapper.toProveedor(proveedorDTO);
			prov.setEstatus(estatusRepository.findById(1).get());
			proveedorRepository.save(prov);
			msg = Mensaje.success("Agregado correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo agregar por: " + e.getMessage());
		}
		return msg;
	}

	public Mensaje update(ProveedorDTO proveedorDTO, int id) {
		try {
			Optional<Proveedor> proveedorFound = proveedorRepository.findById(id);
			Optional<TipoPersonaFiscal> tpfound = null;
			Proveedor proveedor = null;
			if (proveedorFound.isPresent()) {
				proveedor = ProveedorMapper.setToUpdate(proveedorFound.get(), proveedorDTO);
			
			} else {
				msg = Mensaje.notFound("No se encontro el proveedor");
			}

			if (!Objects.isNull(proveedorDTO.getTipoPersonaFiscal().getIdTipoPersonaFiscal())) {
				tpfound = tipoPersonaFiscalRepository
						.findById(proveedorDTO.getTipoPersonaFiscal().getIdTipoPersonaFiscal());
				proveedor.setTipoPersonaFiscal(tpfound.get());
			}
			
			proveedorRepository.save(proveedor);
			
			msg = Mensaje.success("Actualizado correctamente");

		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo Actualizar por: " + e.getMessage());
		}
		return msg;
	}

	public Mensaje borraPorId(int id, int idEstatus) {

		String action = idEstatus == 1 ? "Activado" : "Inactivado";
		try {
			Optional<Proveedor> provedorfound = proveedorRepository.findById(id);
			Optional<Estatus> estatusFound = estatusRepository.findById(idEstatus);
			if (provedorfound.isPresent() && estatusFound.isPresent()) {
				provedorfound.get().setEstatus(estatusFound.get());
			}

			proveedorRepository.save(provedorfound.get());
			msg = Mensaje.success(action + " correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo " + action + " por: " + e.getMessage());
		}
		return msg;

	}

	public Mensaje agregarActividad(ProveedorDTO proveedor) {
		try {
			Optional<Proveedor> proveedorFound = proveedorRepository.findById(proveedor.getIdProveedor());
			Optional<Actividad> actividadSeleccionada = actividadRepository
					.findById(proveedor.getIdActividadSeleccionada());
			if (proveedorFound.isPresent() && actividadSeleccionada.isPresent()) {
				if (!proveedorFound.get().getActividades().contains(actividadSeleccionada.get())) {
					proveedorFound.get().getActividades().add(actividadSeleccionada.get());
					proveedorRepository.save(proveedorFound.get());
					msg = Mensaje.success("Agregado correctamente");
				} else {
					msg = Mensaje.warning("La actividad ya estaba asignada");
				}

			}

		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo agregar por: " + e.getMessage());
		}
		return msg;
	}

	public Mensaje borraActividad(int idProveedor, int idActividad) {

		try {
			Optional<Proveedor> provedorfound = proveedorRepository.findById(idProveedor);
			Optional<Actividad> actividadFound = actividadRepository.findById(idActividad);
			if (provedorfound.isPresent() && actividadFound.isPresent()) {
				provedorfound.get().getActividades().remove(actividadFound.get());
			}
			proveedorRepository.save(provedorfound.get());
			msg = Mensaje.success("Eliminado correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo elimnar por: " + e.getMessage());
		}
		return msg;

	}

}
