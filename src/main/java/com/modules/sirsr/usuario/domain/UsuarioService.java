/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.usuario.domain;

import com.modules.sirsr.datosPersonales.persistence.DatosPersonales;
import com.modules.sirsr.estatus.domain.EstatusDTO;
import com.modules.sirsr.estatus.domain.EstatusService;
import com.modules.sirsr.usuario.persistence.Usuario;
import com.modules.sirsr.datosPersonales.persistence.DatosPersonalesRepository;
import com.modules.sirsr.unidadResponsable.persistence.UnidadResponsableRepository;
import com.modules.sirsr.usuario.persistence.UsuarioMapper;
import com.modules.sirsr.usuario.persistence.UsuarioRepository;

import java.io.UnsupportedEncodingException;
import java.util.*;

import com.modules.sirsr.config.EmailUtils;
import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.datosPersonales.domain.DatosPersonalesDTO;
import com.modules.sirsr.datosPersonales.domain.DatosPersonalesService;
import com.modules.sirsr.unidadResponsable.domain.UnidadResponsableDTO;
import com.modules.sirsr.unidadResponsable.domain.UnidadResponsableService;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import org.eclipse.persistence.jpa.rs.exceptions.JPARSException;

/**
 *
 * @author Edward Reyes
 */
@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	private final DatosPersonalesService datosPersonalesService;
	private final UnidadResponsableService unidadResponsableService;
	private final DatosPersonalesRepository datosPersonalesRepository;
	private final UnidadResponsableRepository unidadResponsableRepository;
	private final EstatusService estatusService;
	private final EmailUtils emailUtils;
	private UsuarioDTO usuarioDTO;
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	private Mensaje msg;

	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository, DatosPersonalesService datosPersonalesService,
			UnidadResponsableService unidadResponsableService, DatosPersonalesRepository datosPersonalesRepository,
			UnidadResponsableRepository unidadResponsableRepository, EstatusService estatusService, EmailUtils emailUtils) {
		this.usuarioRepository = usuarioRepository;
		this.datosPersonalesRepository = datosPersonalesRepository;
		this.unidadResponsableRepository = unidadResponsableRepository;
		this.estatusService = estatusService;
		this.emailUtils = emailUtils;
		this.datosPersonalesService = datosPersonalesService;
		this.unidadResponsableService = unidadResponsableService;
	}

	public List<UsuarioDTO> findAll() {
		return UsuarioMapper.toUsuariosDTOs(usuarioRepository.findAll(Sort.by("noUsuario")));
	}

	public UsuarioDTO findById(int id) {
		Usuario usuario = usuarioRepository.findByNoUsuario(id);
		return UsuarioMapper.toUsuarioDTO(usuario);
	}

	public Mensaje save(UsuarioDTO usuarioDTO) {
		try {
			EstatusDTO estatusDTO = estatusService.findById(1);
			DatosPersonalesDTO datosPersonalesDTO = datosPersonalesService
					.findById(usuarioDTO.getPersonal().getNoPersonal());
			UnidadResponsableDTO unidadResponsableDTO = unidadResponsableService
					.findById(usuarioDTO.getUnidadResponsable().getClaveUr());
			usuarioDTO.setEncrytedPassword(encoder.encode(usuarioDTO.getPassword()));
			usuarioDTO.setFechaAuditoria(Date.from(Instant.now()));
			usuarioDTO.setEstatus(estatusDTO);
			usuarioDTO.setEnabled(1);
			usuarioDTO.setPersonal(datosPersonalesDTO);
			usuarioDTO.setUnidadResponsable(unidadResponsableDTO);
			usuarioRepository.save(UsuarioMapper.toUsuario(usuarioDTO));
			msg = Mensaje.success("Agregado correctamente");
		} catch (JPARSException e) {
			msg = Mensaje.danger("No se pudo agregar por: " + e.getMessage());
		}
		return msg;
	}

	public Mensaje update(UsuarioDTO usuarioDTO, int id) {
		try {
			EstatusDTO estatusDTO = estatusService.findById(1);
			DatosPersonalesDTO datosPersonalesDTO = datosPersonalesService
					.findById(usuarioDTO.getPersonal().getNoPersonal());
			UnidadResponsableDTO unidadResponsableDTO = unidadResponsableService
					.findById(usuarioDTO.getUnidadResponsable().getClaveUr());
			UsuarioDTO usuarioUp = this.findById(id);
			usuarioUp.setUnidadResponsable(unidadResponsableDTO);
			usuarioUp.setPersonal(datosPersonalesDTO);
			usuarioUp.setEstatus(estatusDTO);
			usuarioUp.setUserName(usuarioDTO.getUserName());
			usuarioUp.setEnabled(1);
			usuarioRepository.save(UsuarioMapper.toUsuario(usuarioUp));
			msg = Mensaje.success("Actualizado correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo Actualizar por: " + e.getMessage());
		}
		return msg;
	}

	public Mensaje deleteById(int id, int idEstatus) {

		String action = idEstatus == 1 ? "Activado" : "Inactivado";
		try {
			Usuario usuario = usuarioRepository.findByNoUsuario(id);
			usuario.setEnabled(idEstatus);
			usuarioRepository.save(usuario);
			msg = Mensaje.success(action + " correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo " + action + " por: " + e.getMessage());
		}
		return msg;

	}

	public Mensaje updateResetPasswordToken(String token, String email, String resetPasswordLink) {
		DatosPersonales personal = datosPersonalesRepository.findByCorreo(email);

		if (Objects.nonNull(personal)) {
			Usuario usuario = usuarioRepository.findByNoPersonal(personal.getNoPersonal());
			usuario.setResetPasswordToken(token);
			usuarioRepository.save(usuario);
			try {
				emailUtils.sendEmailReinicioPassword(email, resetPasswordLink);
				msg = Mensaje.success("Enviamos un link a su email para reiniciar su password.");
			} catch (UnsupportedEncodingException | MessagingException e) {
				msg = Mensaje.danger("Error mientras se enviaba email");
			}
		} else {
			msg = Mensaje.danger("No se pudo encontrar ningun usuario con el Email: " + email);
		}
		return msg;
	}

	public Mensaje getByResetPasswordToken(String token) {
		Usuario usuario = usuarioRepository.findByResetPasswordToken(token);
		if (Objects.nonNull(usuario)) {
			msg = Mensaje.success("Token Valido");
		} else {
			msg = Mensaje.danger("Token invalido");
		}
		return msg;
	}

	public Mensaje updatePassword(String token, String newPassword) {
		try {
			Usuario usuario = usuarioRepository.findByResetPasswordToken(token);
			String encodedPassword = encoder.encode(newPassword);
			usuario.setEncrytedPassword(encodedPassword);
			usuario.setResetPasswordToken(null);
			usuarioRepository.save(usuario);
			msg = Mensaje.success("Tu password ha sido cambiado");
		} catch (Exception e) {
			msg = Mensaje.danger("Ha ocurrido un error al cambiar tu password");
		}
		return msg;
	}

	public UsuarioDTO findByUserName(String userName) {
		Usuario usuario = usuarioRepository.findByUserName(userName);
		return UsuarioMapper.toUsuarioDTO(usuario);
	}

	public Mensaje updatePerfil(UsuarioDTO usuarioDTO, String userName) {
		try {
			Usuario usuario = UsuarioMapper.setToUpdatePerfil(usuarioRepository.findByUserName(userName), usuarioDTO);
			usuarioRepository.save(usuario);
			msg = Mensaje.success("Actualizado correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo Actualizar por: " + e.getMessage());
		}
		return msg;
	}

	public Mensaje updateNoPersonal(int noPersonal, int noUsuario) {
		boolean existsPersonal = usuarioRepository.existsUsuarioByNoPersonalAndNoUsuarioNot(noPersonal, noUsuario);
		System.out.println("existe: " + existsPersonal);
		if (existsPersonal) {
			msg = Mensaje.danger("No se pudo asignar personal por que alguien mas lo tiene asignado");
		} else {
			try {
				Usuario usuario = usuarioRepository.findByNoUsuario(noUsuario);
				DatosPersonales personal = datosPersonalesRepository.findById(noPersonal).get();
				usuario.setDatosPersonales(personal);
				usuarioRepository.save(usuario);
				msg = Mensaje.success(
						"Personal " + noPersonal + " asignado correctamente a usuario: " + usuario.getUserName());
			} catch (Exception e) {
				msg = Mensaje.danger("No se pudo asignar por: " + e.getMessage());
			}
		}
		return msg;
	}
}
