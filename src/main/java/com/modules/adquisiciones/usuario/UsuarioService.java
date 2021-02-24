/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.adquisiciones.usuario;

import com.modules.adquisiciones.persistence.entity.Personal;
import com.modules.adquisiciones.persistence.entity.Usuario;
import com.modules.adquisiciones.persistence.repository.PersonalRepository;
import com.modules.adquisiciones.persistence.repository.UsuarioRepository;

import java.io.UnsupportedEncodingException;
import java.util.*;

import com.modules.adquisiciones.utils.EmailUtils;
import com.modules.adquisiciones.utils.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

/**
 *
 * @author Edward Reyes
 */
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PersonalRepository personalRepository;
    private final UsuarioMapper usuarioMapper;
    private final EmailUtils emailUtils;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private Mensaje msg;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, PersonalRepository personalRepository, UsuarioMapper usuarioMapper, EmailUtils emailUtils) {
        this.usuarioRepository = usuarioRepository;
        this.personalRepository = personalRepository;
        this.usuarioMapper = usuarioMapper;
        this.emailUtils = emailUtils;
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
            usuarioDTO.setEncrytedPassword(encoder.encode(usuarioDTO.getPassword()));
            usuarioDTO.setFechaAuditoria(Calendar.getInstance());
            usuarioDTO.setIdEstatus(1);
            usuarioDTO.setEnabled(1);
            usuarioRepository.save(usuarioMapper.toUsuario(usuarioDTO));
            msg = Mensaje.CREATE("Agregado correctamente", 1);
        } catch (Exception e) {
            msg = Mensaje.CREATE("No se pudo agregar por: " + e.getMessage(), 2);
        }
        return msg;
    }

    public Mensaje update(UsuarioDTO usuarioDTO, int id) {
        try {
            Usuario usuario = usuarioMapper.setToUpdate(usuarioRepository.findByNoUsuario(id), usuarioDTO);
            usuarioRepository.save(usuario);
            msg = Mensaje.CREATE("Agregado correctamente", 1);
        } catch (Exception e) {
            msg = Mensaje.CREATE("No se pudo agregar por: " + e.getMessage(), 2);
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
        Personal personal = personalRepository.findByCorreo(email);
        
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
            msg = Mensaje.CREATE("Agregado correctamente", 1);
        } catch (Exception e) {
            msg = Mensaje.CREATE("No se pudo agregar por: " + e.getMessage(), 2);
        }
        return msg;
    }
    
    public Mensaje updateNoPersonal(int noPersonal, int noUsuario) {
        boolean existsPersonal = usuarioRepository.existsUsuarioByNoPersonalAndNoUsuarioNot(noPersonal, noUsuario);
        if (existsPersonal) {
            msg = Mensaje.CREATE("No se pudo asignar personal por que alguien mas lo tiene asignado", 2);
        } else {
            try {
                Usuario usuario = usuarioRepository.findByNoUsuario(noUsuario);
                usuario.setNoPersonal(noPersonal);
                usuarioRepository.save(usuario);
                msg = Mensaje.CREATE("Inmueble asignado correctamente", 1);
            } catch (Exception e) {
                msg = Mensaje.CREATE("No se pudo asignar por: " + e.getMessage(), 2);
            }
        }
        return msg;
    }
}
