package com.modules.sirsr.usuarioRole.domain;

import com.modules.sirsr.role.domain.RoleDTO;
import com.modules.sirsr.usuario.domain.UsuarioDTO;

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
