/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.adquisiciones.role;

import com.modules.adquisiciones.persistence.entity.Role;
import com.modules.adquisiciones.persistence.repository.RoleRepository;

import java.util.List;
import java.util.Optional;

import com.modules.adquisiciones.utils.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Edward Reyes
 */
@Service
public class RoleService {
    
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;
    private Mensaje msg;

    @Autowired
    public RoleService(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    public List<RoleDTO> findAll() {
        return roleMapper.toRoleDTOs(roleRepository.findAll());
    }

    public RoleDTO findById(int id) {
        Optional<Role> roleOptional = roleRepository.findById(id);
        RoleDTO roleDTO = roleMapper.toRoleDTO(roleOptional.get());
        return roleDTO;
    }

    public Mensaje save(RoleDTO roleDTO) {
        try {
            roleDTO.setRoleName("ROLE_"+roleDTO.getRoleName());
            roleRepository.save(roleMapper.toRole(roleDTO));
            msg = Mensaje.CREATE("Agregado correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo agregar por: "+e.getMessage(), 2);
        }
        return msg;
    }

    public Mensaje update(RoleDTO roleDTO, int id) {
        try {
            Optional<Role> roleFound = roleRepository.findById(id);
            Role role = roleMapper.setToUpdate(roleFound.get(), roleDTO);
            roleRepository.save(role);
            msg = Mensaje.CREATE("Agregado correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo agregar por: "+e.getMessage(), 2);
        }
        return msg;
    }

    public Mensaje deleteById(int id) {
        try {
            roleRepository.deleteById(id);
            msg = Mensaje.CREATE("Eliminado correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo Eliminar por que hay usuarios asociados a rol.", 2);
        }
        return msg;

    }

}
