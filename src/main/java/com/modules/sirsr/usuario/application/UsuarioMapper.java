package com.modules.sirsr.usuario.application;

import com.modules.sirsr.usuario.domain.Usuario;
import com.modules.sirsr.datosPersonales.application.DatosPersonalesMapper;
import com.modules.sirsr.unidadResponsable.application.UnidadResponsableMapper;
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
        DatosPersonalesMapper datosPersonalesMapper = new DatosPersonalesMapper();
        UnidadResponsableMapper unidadResponsableMapper = new UnidadResponsableMapper();

        usuarioDTO.setNoUsuario(usuario.getNoUsuario());
        usuarioDTO.setUserName(usuario.getUserName());
        usuarioDTO.setEncrytedPassword(usuario.getEncrytedPassword());
        usuarioDTO.setFechaAuditoria(usuario.getFechaAuditoria());
        usuarioDTO.setIdEstatus(usuario.getIdEstatus());
        usuarioDTO.setEnabled(usuario.getEnabled());
        usuarioDTO.setPersonal(datosPersonalesMapper.toPersonalDTO(usuario.getDatosPersonales()));
        usuarioDTO.setUnidadResponsable(unidadResponsableMapper.toUnidadResponsableDTO(usuario.getUnidadResponsable()));

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
        return usuario;
    }

    public Usuario setToUpdate(Usuario usuarioFound, UsuarioDTO usuarioDTO) {
        UnidadResponsableMapper unidadResponsableMapper = new UnidadResponsableMapper();
        usuarioFound.setUserName(usuarioDTO.getUserName());
        return usuarioFound;
    }

    public Usuario setToUpdatePerfil(Usuario usuarioFound, UsuarioDTO usuarioDTO) {
        
        return usuarioFound;
    }
}
