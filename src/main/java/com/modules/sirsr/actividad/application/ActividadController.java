package com.modules.sirsr.actividad.application;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.modules.sirsr.actividad.domain.ActividadDTO;
import com.modules.sirsr.actividad.domain.ActividadService;
import com.modules.sirsr.config.Mensaje;

@Controller
@RequestMapping("/admonadq")
public class ActividadController {
	
	private final ActividadService actividadService;
	private List<ActividadDTO> actividades;
	private final Mensaje msg = new Mensaje();
	
	@Autowired
	public ActividadController(ActividadService actividadService) {
		this.actividadService = actividadService;
		
	}
	
	@GetMapping("/actividades")
	public String listar(Model model) {
		actividades = actividadService.findAll();
		model.addAttribute("lista", actividades);
		return "admonadq/actividades/principal";
	}
	
	@GetMapping("actividades/agregar")
	public String agregar(Model model) {
		model.addAttribute("actividad", new ActividadDTO());
	    return "admonadq/actividades/agregar";
	}
	
	@PostMapping("actividades/add")
	public String add(ActividadDTO actividadDTO, RedirectAttributes redirectAttributes) {
		Mensaje.addMensaje(actividadService.save(actividadDTO), redirectAttributes);
		return "redirect:/admonadq/actividades";
		
	}
	
	 @GetMapping("/actividades/eliminar/{id}/{idestatus}")
	    public String eliminar(@PathVariable("id") int id, @PathVariable("idestatus") int idestatus,
	            RedirectAttributes redirectAttrs) {
		 Mensaje.addMensaje(actividadService.borraPorId(id, idestatus), redirectAttrs);
	        return "redirect:/admonadq/actividades";
	    }
	 
	
	 @GetMapping("/actividades/editar/{id}")
		public String editar(@PathVariable("id") int id, Model model) {
			ActividadDTO actividadDTO = actividadService.findById(id);
			String validUrl = "redirect:/admonadq/proveedores";
			if (Objects.nonNull(actividadDTO)) {
				model.addAttribute("actividad", actividadDTO);
				validUrl = "admonadq/actividades/editar";
			}
			return validUrl;
		}
	 
	 @PostMapping("/actividades/update")
		public String editar(ActividadDTO actividadDTO, RedirectAttributes redirectAttrs) {
		 Mensaje.addMensaje(actividadService.update(actividadDTO, actividadDTO.getIdActividad()), redirectAttrs);
			return "redirect:/admonadq/actividades";
		}
	
}
