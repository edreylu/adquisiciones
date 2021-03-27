/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.usuario.application;

import com.modules.sirsr.datosPersonales.domain.DatosPersonales;
import com.modules.sirsr.estatus.application.EstatusDTO;
import com.modules.sirsr.estatus.application.EstatusService;
import com.modules.sirsr.unidadResponsable.domain.UnidadResponsable;
import com.modules.sirsr.usuario.domain.Usuario;
import com.modules.sirsr.datosPersonales.domain.DatosPersonalesRepository;
import com.modules.sirsr.unidadResponsable.domain.UnidadResponsableRepository;
import com.modules.sirsr.usuario.domain.UsuarioRepository;

import java.io.UnsupportedEncodingException;
import java.util.*;

import com.modules.sirsr.config.EmailUtils;
import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.datosPersonales.application.DatosPersonalesDTO;
import com.modules.sirsr.datosPersonales.application.DatosPersonalesService;
import com.modules.sirsr.unidadResponsable.application.UnidadResponsableDTO;
import com.modules.sirsr.unidadResponsable.application.UnidadResponsableService;
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
    private final UsuarioMapper usuarioMapper;
    private final EmailUtils emailUtils;
    private UsuarioDTO usuarioDTO;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private Mensaje msg;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository,DatosPersonalesService datosPersonalesService,UnidadResponsableService unidadResponsableService, DatosPersonalesRepository datosPersonalesRepository, UnidadResponsableRepository unidadResponsableRepository, EstatusService estatusService, UsuarioMapper usuarioMapper, EmailUtils emailUtils) {
        this.usuarioRepository = usuarioRepository;
        this.datosPersonalesRepository = datosPersonalesRepository;
        this.unidadResponsableRepository = unidadResponsableRepository;
        this.estatusService = estatusService;
        this.usuarioMapper = usuarioMapper;
        this.emailUtils = emailUtils;
        this.datosPersonalesService = datosPersonalesService;
        this.unidadResponsableService = unidadResponsableService;
    }

    public List<UsuarioDTO> findAll() {
        return usuarioMapper.toUsuariosDTOs(usuarioRepository.findAll(Sort.by("noUsuario")));
    }
    public UsuarioDTO findById(int id) {
        Usuario usuario = usuarioRepository.findByNoUsuario(id);
        return usuarioMapper.toUsuarioDTO(usuario);
    }

    public Mensaje save(UsuarioDTO usuarioDTO) {
        try {
            EstatusDTO estatusDTO = estatusService.findById(1);
            DatosPersonalesDTO datosPersonalesDTO = datosPersonalesService.findById(usuarioDTO.getPersonal().getNoPersonal());
            UnidadResponsableDTO unidadResponsableDTO = unidadResponsableService.findById(usuarioDTO.getUnidadResponsable().getClaveUr());
            usuarioDTO.setEncrytedPassword(encoder.encode(usuarioDTO.getPassword()));
            usuarioDTO.setFechaAuditoria(Date.from(Instant.now()));
            usuarioDTO.setEstatus(estatusDTO);
            usuarioDTO.setEnabled(1);
            usuarioDTO.setPersonal(datosPersonalesDTO);
            usuarioDTO.setUnidadResponsable(unidadResponsableDTO);
            usuarioRepository.save(usuarioMapper.toUsuario(usuarioDTO));
            msg = Mensaje.CREATE("Agregado correctamente", 1);
        } catch (JPARSException e) {
            msg = Mensaje.CREATE("No se pudo agregar por: " + e.getMessage(), 2);
        }
        return msg;
    }

    public Mensaje update(UsuarioDTO usuarioDTO, int id) {
        try {
            EstatusDTO estatusDTO = estatusService.findById(1);
            DatosPersonalesDTO datosPersonalesDTO = datosPersonalesService.findById(usuarioDTO.getPersonal().getNoPersonal());
            UnidadResponsableDTO unidadResponsableDTO = unidadResponsableService.findById(usuarioDTO.getUnidadResponsable().getClaveUr());
            UsuarioDTO usuarioUp = this.findById(id);
            usuarioUp.setUnidadResponsable(unidadResponsableDTO);
            usuarioUp.setPersonal(datosPersonalesDTO);
            usuarioUp.setEstatus(estatusDTO);
            usuarioUp.setUserName(usuarioDTO.getUserName());
            usuarioUp.setEnabled(1);
            usuarioRepository.save(usuarioMapper.toUsuario(usuarioUp));
            msg = Mensaje.CREATE("Actualizado correctamente", 1);
        } catch (Exception e) {
            msg = Mensaje.CREATE("No se pudo Actualizar por: " + e.getMessage(), 2);
        }
        return msg;
    }

    public Mensaje deleteById(int id, int idEstatus) {

        String action = idEstatus == 1 ? "Activado" : "Inactivado";
        try {
            Usuario usuario = usuarioRepository.findByNoUsuario(id);
            usuario.setEnabled(idEstatus);
            usuarioRepository.save(usuario);
            msg = Mensaje.CREATE(action + " correctamente", 1);
        } catch (Exception e) {
            msg = Mensaje.CREATE("No se pudo " + action + " por: " + e.getMessage(), 2);
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
                msg = Mensaje.CREATE("Enviamos un link a su email para reiniciar su password.", 1);
            } catch (UnsupportedEncodingException | MessagingException e) {
                msg = Mensaje.CREATE("Error mientras se enviaba email", 2);
            }
        } else {
            msg = Mensaje.CREATE("No se pudo encontrar ningun usuario con el Email: " + email, 2);
        }
        return msg;
    }

    public Mensaje getByResetPasswordToken(String token) {
        Usuario usuario = usuarioRepository.findByResetPasswordToken(token);
        if (Objects.nonNull(usuario)) {
            msg = Mensaje.CREATE("Token Valido", 1);
        } else {
            msg = Mensaje.CREATE("Token invalido", 2);
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
            msg = Mensaje.CREATE("Tu password ha sido cambiado", 1);
        } catch (Exception e) {
            msg = Mensaje.CREATE("Ha ocurrido un error al cambiar tu password", 2);
        }
        return msg;
    }

    public UsuarioDTO findByUserName(String userName) {
        Usuario usuario = usuarioRepository.findByUserName(userName);
        return usuarioMapper.toUsuarioDTO(usuario);
    }

    public Mensaje updatePerfil(UsuarioDTO usuarioDTO, String userName) {
        try {
            Usuario usuario = usuarioMapper.setToUpdatePerfil(usuarioRepository.findByUserName(userName), usuarioDTO);
            usuarioRepository.save(usuario);
            msg = Mensaje.CREATE("Actualizado correctamente", 1);
        } catch (Exception e) {
            msg = Mensaje.CREATE("No se pudo Actualizar por: " + e.getMessage(), 2);
        }
        return msg;
    }
    
    public Mensaje updateNoPersonal(int noPersonal, int noUsuario) {
        boolean existsPersonal = usuarioRepository.existsUsuarioByNoPersonalAndNoUsuarioNot(noPersonal, noUsuario);
        System.out.println("existe: "+existsPersonal);
        if (existsPersonal) {
            msg = Mensaje.CREATE("No se pudo asignar personal por que alguien mas lo tiene asignado", 2);
        } else {
            try {
                Usuario usuario = usuarioRepository.findByNoUsuario(noUsuario);
                DatosPersonales personal = datosPersonalesRepository.findById(noPersonal).get();
                usuario.setDatosPersonales(personal);
                usuarioRepository.save(usuario);
                msg = Mensaje.CREATE("Personal "+noPersonal+" asignado correctamente a usuario: "+usuario.getUserName(), 1);
            } catch (Exception e) {
                msg = Mensaje.CREATE("No se pudo asignar por: " + e.getMessage(), 2);
            }
        }
        return msg;
    }
}
