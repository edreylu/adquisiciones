package com.modules.sirsr.config;

import com.modules.sirsr.solicitud.persistence.Solicitud;
import com.modules.sirsr.solicitud.persistence.SolicitudRepository;
import com.modules.sirsr.usuario.domain.UsuarioDTO;
import com.modules.sirsr.usuario.domain.UsuarioService;

import java.io.IOException;
import java.util.Formatter;

public class Utils {

	public static void firmaDirector(UsuarioDTO usuarioDTO, SolicitudRepository solicitudRepository,
			Solicitud solicitud) {
		String ur = usuarioDTO.getUnidadResponsable().getDescripcion();
		Integer expediente = usuarioDTO.getNoUsuario();
		Formatter format = new Formatter().format("%07d", expediente);
		String folio = "UR" + ur + "EX" + format.toString() + "FC"
				+ solicitud.getFechaCreacion();
		System.out.println(folio);
		byte[] bytes = folio.getBytes();
		String cadena = null;
		try {
			cadena = Base64.encodeBytes(bytes, Base64.GZIP);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			format.close();
		}
		System.out.println("cadena = " + cadena);
		solicitud.setFirmaDirector(cadena);
		solicitudRepository.save(solicitud);
	}

}
