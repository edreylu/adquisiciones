/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.usuarioRole.domain;

import com.modules.sirsr.role.domain.Role;
import com.modules.sirsr.usuario.domain.Usuario;

import javax.persistence.*;

/**
 *
 * @author Edward Reyes
 */

@Entity
@Table(name = "USUARIOS_ROLES", uniqueConstraints = { @UniqueConstraint(name = "USUARIOS_ROLES_UK", columnNames = { "NO_USUARIO", "NO_ROL" }) })
public class UsuarioRole {
 
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="usuariorole_generator")
    @SequenceGenerator(name = "usuariorole_generator", sequenceName = "ADQUISICIONES.SEQ_USUARIOROLE", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Integer id;
 
    @ManyToOne
    @JoinColumn(name = "NO_USUARIO", nullable = false)
    private Usuario usuario;
 
    @ManyToOne
    @JoinColumn(name = "NO_ROL", nullable = false)
    private Role role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}