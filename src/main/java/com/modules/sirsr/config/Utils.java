package com.modules.sirsr.config;

import com.modules.sirsr.solicitud.persistence.Solicitud;
import com.modules.sirsr.solicitud.persistence.SolicitudRepository;
import com.modules.sirsr.usuario.domain.UsuarioDTO;
import com.modules.sirsr.usuario.domain.UsuarioService;

import java.io.IOException;
import java.util.Formatter;

public class Utils {

    public static void firmaDirector(UsuarioService usuarioService, SolicitudRepository solicitudRepository, Solicitud solicitud){
        UsuarioDTO usuarioDTO = usuarioService.findByUserName(WebUtils.getUserName());
        String ur = usuarioDTO.getUnidadResponsable().getDescripcion();
        Integer expediente = usuarioDTO.getNoUsuario();
        String folio = folio = "UR" + ur + "EX" + new Formatter().format("%07d", expediente).toString() + "FC" + solicitud.getFechaCreacion();
        System.out.println(folio);
        byte[] bytes = folio.getBytes();
        String cadena = null;
        try {
            cadena = Base64.encodeBytes(bytes, Base64.GZIP);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("cadena = " + cadena);
        solicitud.setFirmaDirector(cadena);
        solicitudRepository.save(solicitud);
    }

}
