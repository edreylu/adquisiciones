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
import java.util.Optional;

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
	private final ProveedorMapper proveedorMapper;
	private final TipoPersonaFiscalRepository tipoPersonaFiscalRepository;
	private final EstatusRepository estatusRepository;
	private Mensaje msg;

	@Autowired
	public ProveedorService(ProveedorRepository proveedorRepository, ProveedorMapper proveedorMapper,
			TipoPersonaFiscalRepository tipoPersonaFiscalRepository, EstatusRepository estatusRepository) {
		this.proveedorRepository = proveedorRepository;
		this.proveedorMapper = proveedorMapper;
		this.tipoPersonaFiscalRepository = tipoPersonaFiscalRepository;
		this.estatusRepository = estatusRepository;
	}

	public List<ProveedorDTO> findAll() {
		return proveedorMapper.toProveedorDTOs(proveedorRepository.findAll());
	}

	public ProveedorDTO findById(int id) {
		Optional<Proveedor> proveedorOptional = proveedorRepository.findById(id);
		ProveedorDTO proveedorDTO = proveedorMapper.toProveedorDTO(proveedorOptional.get());
		return proveedorDTO;
	}

	public Mensaje save(ProveedorDTO proveedorDTO) {
		try {
			proveedorDTO.getEstatusDTO().setIdEstatus(1);
			Proveedor prov = proveedorMapper.toProveedor(proveedorDTO);
			proveedorRepository.save(prov);
			msg = Mensaje.CREATE("Agregado correctamente", 1);
		} catch (Exception e) {
			msg = Mensaje.CREATE("No se pudo agregar por: " + e.getMessage(), 2);
		}
		return msg;
	}

	public Mensaje update(ProveedorDTO proveedorDTO, int id) {
		try {
			Optional<Proveedor> proveedorFound = proveedorRepository.findById(id);
			Optional<TipoPersonaFiscal> tpfound = tipoPersonaFiscalRepository
					.findById(proveedorDTO.getTipoPersonaFiscalDTO().getIdTipoPersonaFiscal());
			if (proveedorFound.isPresent() && tpfound.isPresent()) {
				Proveedor proveedor = proveedorMapper.setToUpdate(proveedorFound.get(), proveedorDTO);
				proveedor.setTipoPersonaFiscal(tpfound.get());
				proveedorRepository.save(proveedor);
				msg = Mensaje.CREATE("Actualizado correctamente", 1);
			} else {
				msg = Mensaje.CREATE("No se encontro el proveedor", -1);
			}

		} catch (Exception e) {
			msg = Mensaje.CREATE("No se pudo Actualizar por: " + e.getMessage(), 2);
		}
		return msg;
	}

	public Mensaje borraPorId(int id, int idEstatus) {

        String action = idEstatus == 1 ? "Activado" : "Inactivado";
        try {
            Optional<Proveedor> provedorfound = proveedorRepository.findById(id);
            Optional<Estatus> estatusFound = estatusRepository.findById(idEstatus);
            if(provedorfound.isPresent() && estatusFound.isPresent()) {
            	provedorfound.get().setEstatus(estatusFound.get());
            }
            
            proveedorRepository.save(provedorfound.get());
            msg = Mensaje.CREATE(action + " correctamente", 1);
        } catch (Exception e) {
            msg = Mensaje.CREATE("No se pudo " + action + " por: " + e.getMessage(), 2);
        }
        return msg;

    }

}
