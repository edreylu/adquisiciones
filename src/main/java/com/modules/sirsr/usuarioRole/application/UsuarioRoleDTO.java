package com.modules.sirsr.usuarioRole.application;

import com.modules.sirsr.role.application.RoleDTO;
import com.modules.sirsr.usuario.application.UsuarioDTO;

import java.util.List;

public class UsuarioRoleDTO {

    private int id;
    private UsuarioDTO usuario;
    private List<RoleDTO> roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }
}
