/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.requisicion.application;

import com.modules.sirsr.clavePresupuestaria.domain.ClavePresupuestariaDTO;
import com.modules.sirsr.clavePresupuestaria.domain.ClavePresupuestariaService;
import com.modules.sirsr.config.WebUtils;
import com.modules.sirsr.requisicion.domain.RequisicionDTO;
import com.modules.sirsr.requisicion.domain.RequisicionService;
import com.modules.sirsr.config.Mensaje;
import java.util.List;
import java.util.Objects;

import com.modules.sirsr.solicitud.domain.SolicitudDTO;
import com.modules.sirsr.solicitud.domain.SolicitudService;
import com.modules.sirsr.usuario.domain.UsuarioDTO;
import com.modules.sirsr.usuario.domain.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Edward Reyes
 */
@Controller
@RequestMapping(value = "/usuario")
public class RequisicionController {

	private final RequisicionService requisicionService;
	private final SolicitudService solicitudService;
	private final ClavePresupuestariaService clavePresupuestariaService;
	private final UsuarioService usuarioService;
	private List<RequisicionDTO> requisiciones;
	private List<ClavePresupuestariaDTO> clavesPresupuestarias;
	private RequisicionDTO requisicionDTO;
	private UsuarioDTO usuarioDTO;
	private final Mensaje msg = new Mensaje();

	@Autowired
	public RequisicionController(RequisicionService requisicionService, SolicitudService solicitudService,
			ClavePresupuestariaService clavePresupuestariaService, UsuarioService usuarioService) {
		this.requisicionService = requisicionService;
		this.solicitudService = solicitudService;
		this.clavePresupuestariaService = clavePresupuestariaService;
		this.usuarioService = usuarioService;
	}

	@GetMapping("/solicitudes/requisiciones/{id}")
	public String listar(Model model, @PathVariable("id") int id) {
		requisiciones = requisicionService.findByIdSolicitud(id);
		usuarioDTO = usuarioService.findByUserName(WebUtils.getUserName());
		model.addAttribute("lista", requisiciones);
		model.addAttribute("solicitud", id);
		model.addAttribute("unidadResponsable", usuarioDTO.getUnidadResponsable().getDescripcion());
		return "usuario/solicitudes/requisiciones/principal";
	}

	@GetMapping("/solicitudes/requisiciones/agregar/{id}")
	public String agregar(Model model, @PathVariable("id") int id) {
		RequisicionDTO requisicionDTO = new RequisicionDTO();
		SolicitudDTO solicitudDTO = solicitudService.findById(id);
		requisicionDTO.setSolicitud(solicitudDTO);
		clavesPresupuestarias = clavePresupuestariaService.findByClaveUr();
		model.addAttribute("requisicion", requisicionDTO);
		model.addAttribute("clavesPresupuestarias", clavesPresupuestarias);
		return "usuario/solicitudes/requisiciones/agregar";
	}

	@PostMapping("/solicitudes/requisiciones/add/{id}")
	public String agregar(RequisicionDTO requisicionDTO, @PathVariable("id") int id, RedirectAttributes redirectAttrs) {
		msg.crearMensaje(requisicionService.save(requisicionDTO, id), redirectAttrs);
		return "redirect:/usuario/solicitudes/requisiciones/" + id;
	}

	@GetMapping("/solicitudes/requisiciones/editar/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		requisicionDTO = requisicionService.findById(id);
		clavesPresupuestarias = clavePresupuestariaService.findByClaveUr();
		String validUrl = "redirect:/usuario/solicitudes/requisiciones";
		if (Objects.nonNull(requisicionDTO)) {
			model.addAttribute("requisicion", requisicionDTO);
			model.addAttribute("clavesPresupuestarias", clavesPresupuestarias);
			model.addAttribute("objetoGasto",
					requisicionDTO.getClavePresupuestaria().getObjetoDeGasto().getDescripcion());
			validUrl = "usuario/solicitudes/requisiciones/editar";
		}
		return validUrl;
	}

	@PostMapping("/solicitudes/requisiciones/update")
	public String editar(RequisicionDTO requisicionDTO, RedirectAttributes redirectAttrs) {
		msg.crearMensaje(requisicionService.update(requisicionDTO), redirectAttrs);
		return "redirect:/usuario/solicitudes/requisiciones/" + requisicionDTO.getIdSolicitud();
	}

	@GetMapping("/solicitudes/requisiciones/eliminar/{id}/{idSolicitud}")
	public String eliminar(@PathVariable("id") int id, @PathVariable("idSolicitud") int idSolicitud,
			RedirectAttributes redirectAttrs) {
		msg.crearMensaje(requisicionService.deleteById(id), redirectAttrs);
		return "redirect:/usuario/solicitudes/requisiciones/" + idSolicitud;
	}

	@GetMapping("/solicitudes/requisiciones/updateObjetoGasto/{id}")
	public String updateObjetoGasto(@PathVariable("id") int id, Model model) {
		ClavePresupuestariaDTO clavePresupuestariaDTO = clavePresupuestariaService.findById(id);
		model.addAttribute("objetoGasto", clavePresupuestariaDTO.getObjetoDeGasto().getDescripcion());
		return "usuario/solicitudes/requisiciones/agregar :: #idObjetoGasto";
	}

}
