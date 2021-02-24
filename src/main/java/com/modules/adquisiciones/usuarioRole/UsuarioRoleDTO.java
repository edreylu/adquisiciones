package com.modules.adquisiciones.usuarioRole;

import com.modules.adquisiciones.role.RoleDTO;
import com.modules.adquisiciones.usuario.UsuarioDTO;

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
