package com.modules.sirsr.usuario.persistence;

import com.modules.sirsr.estatus.persistence.EstatusMapper;
import com.modules.sirsr.usuario.domain.UsuarioDTO;
import com.modules.sirsr.datosPersonales.persistence.DatosPersonalesMapper;
import com.modules.sirsr.unidadResponsable.persistence.UnidadResponsableMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UsuarioMapper {

	public static UsuarioDTO toUsuarioDTO(Usuario usuario) {
		if (Objects.isNull(usuario)) {
			return null;
		}

		UsuarioDTO usuarioDTO = new UsuarioDTO();

		usuarioDTO.setNoUsuario(usuario.getNoUsuario());
		usuarioDTO.setUserName(usuario.getUserName());
		usuarioDTO.setEncrytedPassword(usuario.getEncrytedPassword());
		usuarioDTO.setFechaAuditoria(usuario.getFechaAuditoria());
		usuarioDTO.setEstatus(EstatusMapper.toEstatusDTO(usuario.getEstatus()));
		usuarioDTO.setEnabled(usuario.getEnabled());
		usuarioDTO.setPersonal(DatosPersonalesMapper.toPersonalDTO(usuario.getDatosPersonales()));
		usuarioDTO.setUnidadResponsable(UnidadResponsableMapper.toUnidadResponsableDTO(usuario.getUnidadResponsable()));

		return usuarioDTO;
	}

	public static List<UsuarioDTO> toUsuariosDTOs(List<Usuario> usuarios) {
		if (Objects.isNull(usuarios)) {
			return null;
		}

		List<UsuarioDTO> list = new ArrayList<>(usuarios.size());
		for (Usuario usuario : usuarios) {
			list.add(toUsuarioDTO(usuario));
		}

		return list;
	}

	public static Usuario toUsuario(UsuarioDTO usuarioDTO) {
		if (Objects.isNull(usuarioDTO)) {
			return null;
		}
		Usuario usuario = new Usuario();

		usuario.setNoUsuario(usuarioDTO.getNoUsuario());
		usuario.setUserName(usuarioDTO.getUserName());
		usuario.setEncrytedPassword(usuarioDTO.getEncrytedPassword());
		usuario.setFechaAuditoria(usuarioDTO.getFechaAuditoria());
		usuario.setEstatus(EstatusMapper.toEstatus(usuarioDTO.getEstatus()));
		usuario.setDatosPersonales(DatosPersonalesMapper.toPersonal(usuarioDTO.getPersonal()));
		usuario.setUnidadResponsable(UnidadResponsableMapper.toUnidadResponsable(usuarioDTO.getUnidadResponsable()));
		usuario.setEnabled(usuarioDTO.getEnabled());
		return usuario;
	}

	public static Usuario setToUpdate(Usuario usuarioFound, UsuarioDTO usuarioDTO) {
		usuarioFound.setUserName(usuarioDTO.getUserName());
		return usuarioFound;
	}

	public static Usuario setToUpdatePerfil(Usuario usuarioFound, UsuarioDTO usuarioDTO) {
		return usuarioFound;
	}
}
