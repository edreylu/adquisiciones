/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.role.domain;

import com.modules.sirsr.role.persistence.Role;
import com.modules.sirsr.role.persistence.RoleMapper;
import com.modules.sirsr.role.persistence.RoleRepository;

import java.util.List;
import java.util.Optional;

import com.modules.sirsr.config.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Edward Reyes
 */
@Service
public class RoleService {

	private final RoleRepository roleRepository;
	private Mensaje msg;

	@Autowired
	public RoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	public List<RoleDTO> findAll() {
		return RoleMapper.toRoleDTOs(roleRepository.findAll());
	}

	public RoleDTO findById(int id) {
		Optional<Role> roleOptional = roleRepository.findById(id);
		RoleDTO roleDTO = RoleMapper.toRoleDTO(roleOptional.get());
		return roleDTO;
	}

	public Mensaje save(RoleDTO roleDTO) {
		try {
			roleDTO.setRoleName("ROLE_" + roleDTO.getRoleName());
			roleRepository.save(RoleMapper.toRole(roleDTO));
			msg = Mensaje.success("Agregado correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo agregar por: " + e.getMessage());
		}
		return msg;
	}

	public Mensaje update(RoleDTO roleDTO, int id) {
		try {
			Optional<Role> roleFound = roleRepository.findById(id);
			Role role = RoleMapper.setToUpdate(roleFound.get(), roleDTO);
			roleRepository.save(role);
			msg = Mensaje.success("Actualizado correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo Actualizar por: " + e.getMessage());
		}
		return msg;
	}

	public Mensaje deleteById(int id) {
		try {
			roleRepository.deleteById(id);
			msg = Mensaje.success("Eliminado correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo Eliminar por que hay usuarios asociados a rol.");
		}
		return msg;

	}

}
