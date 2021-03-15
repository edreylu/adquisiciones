/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.role.domain;

import com.modules.sirsr.usuarioRole.domain.UsuarioRole;

import javax.persistence.*;
import java.util.List;

/**
 *
 * @author Edward Reyes
 */

@Entity
@Table(name = "ROLES", uniqueConstraints = {@UniqueConstraint(name = "ROLES_UK", columnNames = "ROLE_NAME") })
public class Role {
     
    @Id
    @GeneratedValue
    @Column(name = "NO_ROL", nullable = false)
    private Integer noRole;
 
    @Column(name = "ROLE_NAME", length = 30, nullable = false)
    private String roleName;

    @OneToMany(mappedBy = "role")
    private List<UsuarioRole> usuariosRoles;

    public Integer getNoRole() {
        return noRole;
    }

    public void setNoRole(Integer noRole) {
        this.noRole = noRole;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<UsuarioRole> getUsuariosRoles() {
        return usuariosRoles;
    }

    public void setUsuariosRoles(List<UsuarioRole> usuariosRoles) {
        this.usuariosRoles = usuariosRoles;
    }

    public Role() {
    }
}