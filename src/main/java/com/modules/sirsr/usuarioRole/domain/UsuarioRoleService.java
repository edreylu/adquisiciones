package com.modules.sirsr.usuarioRole.domain;

import com.modules.sirsr.role.persistence.RoleMapper;
import com.modules.sirsr.usuarioRole.persistence.UsuarioRole;
import com.modules.sirsr.usuario.persistence.Usuario;
import com.modules.sirsr.role.persistence.RoleRepository;
import com.modules.sirsr.usuarioRole.persistence.UsuarioRoleRepository;
import com.modules.sirsr.usuario.persistence.UsuarioRepository;
import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.role.domain.RoleDTO;
import com.modules.sirsr.role.domain.RoleService;
import com.modules.sirsr.usuario.domain.UsuarioDTO;
import com.modules.sirsr.usuario.domain.UsuarioService;
import com.modules.sirsr.usuario.persistence.UsuarioMapper;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioRoleService {

	private final UsuarioRoleRepository usuarioRoleRepository;
	private final RoleService roleService;
	private final UsuarioService usuarioService;
	private Mensaje msg;

	public UsuarioRoleService(UsuarioRoleRepository usuarioRoleRepository, RoleService roleService,
			UsuarioService usuarioService) {
		this.usuarioRoleRepository = usuarioRoleRepository;
		this.roleService = roleService;
		this.usuarioService = usuarioService;
	}

	public UsuarioRoleDTO findByNoUsuario(int id) {
		Usuario usuario = UsuarioMapper.toUsuario(usuarioService.findById(id));
		UsuarioDTO usuarioDTO = UsuarioMapper.toUsuarioDTO(usuario);
		List<RoleDTO> rolesDtos = roleService.findAll();

		rolesDtos.forEach(role -> {
			boolean selected = usuario.getUsuariosRoles().stream()
					.anyMatch(userRole -> userRole.getRole().getNoRole() == role.getNoRole());
			role.setSelected(selected);
		});
		UsuarioRoleDTO usuarioRoleDTO = new UsuarioRoleDTO();
		usuarioRoleDTO.setRoles(rolesDtos);
		usuarioRoleDTO.setUsuario(usuarioDTO);
		return usuarioRoleDTO;
	}

	public Mensaje assignRoleToUser(UsuarioRoleDTO usuarioRoleDTO, int id) {

		try {
			Usuario usuario = UsuarioMapper.toUsuario(usuarioService.findById(id));
			usuarioRoleDTO.getRoles().forEach(roleDTO -> {
				System.out.println(roleDTO.getNoRole());
				UsuarioRole usuarioRole = new UsuarioRole();
				usuarioRole.setUsuario(usuario);
				usuarioRole.setRole(RoleMapper.toRole(roleDTO));
				ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnorePaths("id");
				Example<UsuarioRole> example = Example.of(usuarioRole, exampleMatcher);
				boolean exists = usuarioRoleRepository.exists(example);
				if (roleDTO.isSelected()) {
					if (!exists) {
						System.out.println(
								usuarioRole.getRole().getNoRole() + " - " + usuarioRole.getUsuario().getNoUsuario());
						usuarioRoleRepository.save(usuarioRole);
					}
				} else {
					if (exists) {
						usuarioRole = usuarioRoleRepository.findByNoUsuarioAndNoRole(id, roleDTO.getNoRole());
						usuarioRoleRepository.delete(usuarioRole);
					}
				}
			});
			msg = Mensaje.success("Pantallas asignadas correctamente");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			msg = Mensaje.danger("Pantallas no se pudieron asignar");
		}
		return msg;
	}
}
