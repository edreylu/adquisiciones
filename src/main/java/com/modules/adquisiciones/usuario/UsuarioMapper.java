package com.modules.adquisiciones.usuario;

import com.modules.adquisiciones.persistence.entity.Usuario;
import com.modules.adquisiciones.personal.PersonalMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class UsuarioMapper {
    
    

    public UsuarioDTO toUsuarioDTO(Usuario usuario) {
        if (Objects.isNull(usuario)) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        PersonalMapper personalMapper = new PersonalMapper();

        usuarioDTO.setNoUsuario(usuario.getNoUsuario());
        usuarioDTO.setUserName(usuario.getUserName());
        usuarioDTO.setEncrytedPassword(usuario.getEncrytedPassword());
        usuarioDTO.setFechaAuditoria(usuario.getFechaAuditoria());
        usuarioDTO.setIdEstatus(usuario.getIdEstatus());
        usuarioDTO.setEnabled(usuario.getEnabled());
        usuarioDTO.setPersonal(personalMapper.toPersonalDTO(usuario.getPersonal()));
        usuarioDTO.setClaveUnidad(usuario.getClaveUnidad());

        return usuarioDTO;
    }

    public List<UsuarioDTO> toUsuariosDTOs(List<Usuario> usuarios) {
        if (Objects.isNull(usuarios)) {
            return null;
        }

        List<UsuarioDTO> list = new ArrayList<>(usuarios.size());
        for (Usuario usuario : usuarios) {
            list.add(toUsuarioDTO(usuario));
        }

        return list;
    }

    public Usuario toUsuario(UsuarioDTO usuarioDTO) {
        if (Objects.isNull(usuarioDTO)) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setNoUsuario(usuarioDTO.getNoUsuario());
        usuario.setUserName(usuarioDTO.getUserName());
        usuario.setEncrytedPassword(usuarioDTO.getEncrytedPassword());
        usuario.setFechaAuditoria(usuarioDTO.getFechaAuditoria());
        usuario.setIdEstatus(usuarioDTO.getIdEstatus());
        usuario.setEnabled(usuarioDTO.getEnabled());
        usuario.setClaveUnidad(usuarioDTO.getClaveUnidad());
        return usuario;
    }

    public Usuario setToUpdate(Usuario usuarioFound, UsuarioDTO usuarioDTO) {
        usuarioFound.setUserName(usuarioDTO.getUserName());
        usuarioFound.setClaveUnidad(usuarioDTO.getClaveUnidad());
        return usuarioFound;
    }

    public Usuario setToUpdatePerfil(Usuario usuarioFound, UsuarioDTO usuarioDTO) {
        
        return usuarioFound;
    }
}
