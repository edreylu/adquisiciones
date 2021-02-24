/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.adquisiciones.persistence.repository;

import com.modules.adquisiciones.persistence.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 *
 * @author Edward Reyes
 */
public interface RoleRepository extends JpaRepository<Role, Integer>{

    @Query("Select ur.role.roleName from UsuarioRole ur where ur.usuario.noUsuario = :noUsuario ")
    List<String> findByUsuario(@Param("noUsuario")  Integer noUsuario);
    
}
