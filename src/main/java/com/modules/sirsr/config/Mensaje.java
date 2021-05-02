package com.modules.sirsr.config;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Admin
 */

public class Mensaje implements Serializable {
	private String mensaje;
	private int result;

	public Mensaje(String mensaje, int result) {
		this.mensaje = mensaje;
		this.result = result;
	}

	public Mensaje() {
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
	
	public static RedirectAttributes addMensaje(Mensaje msg, RedirectAttributes redirectAttrs) {
		String[] tipoMensajes = { "info", "success", "danger", "warning", "primary", "secundary", "light", "dark" };
		String clase = tipoMensajes[msg.getResult()];
		return redirectAttrs.addFlashAttribute("mensaje", msg.getMensaje())
				.addFlashAttribute("clase", clase);
	}
	
	public static Mensaje info(String mensaje) {
		return new Mensaje(mensaje, 0);
	}
	
	public static Mensaje success(String mensaje) {
		return new Mensaje(mensaje, 1);
	}
	
	public static Mensaje danger(String mensaje) {
		return new Mensaje(mensaje, 2);
	}
	
	public static Mensaje warning(String mensaje) {
		return new Mensaje(mensaje, 3);
	}
	
	public static Mensaje primary(String mensaje) {
		return new Mensaje(mensaje, 4);
	}
	
	public static Mensaje secundary(String mensaje) {
		return new Mensaje(mensaje, 5);
	}
	
	public static Mensaje light(String mensaje) {
		return new Mensaje(mensaje, 6);
	}
	
	public static Mensaje dark(String mensaje) {
		return new Mensaje(mensaje, 7);
	}

	@Deprecated
	public RedirectAttributes crearMensaje(Mensaje msg, RedirectAttributes redirectAttrs) {
		String[] tipoMensajes = { "info", "success", "danger", "warning", "primary", "secundary", "light", "dark" };
		String clase = tipoMensajes[msg.getResult()];
		return redirectAttrs.addFlashAttribute("mensaje", msg.getMensaje())
				.addFlashAttribute("clase", clase);
	}
	
	@Deprecated
	public static Mensaje CREATE(String mensaje, int result) {
		return new Mensaje(mensaje, result);
	}

}
