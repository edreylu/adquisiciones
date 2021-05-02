/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.proveedor.application;

import com.modules.sirsr.actividad.domain.ActividadDTO;
import com.modules.sirsr.actividad.domain.ActividadService;
import com.modules.sirsr.actividad.persistence.Actividad;
import com.modules.sirsr.actividad.persistence.ActividadRepository;
import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.documento.domain.DocumentoDTO;
import com.modules.sirsr.proveedor.domain.ProveedorDTO;
import com.modules.sirsr.proveedor.domain.ProveedorService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.boot.web.server.PortInUseException;

/**
 *
 * @author Edward Reyes
 */
@Controller
public class ProveedorController {

	private final ProveedorService proveedorService;
	private List<ProveedorDTO> proveedores;
	private final ActividadService actividadService;

	@Autowired
	public ProveedorController(ProveedorService proveedorService, ActividadService actividadService) {
		this.proveedorService = proveedorService;
		this.actividadService = actividadService;
	}

	@GetMapping("admonadq/proveedores")
	public String listar(Model model) {
		proveedores = proveedorService.findAll();
		for (ProveedorDTO proveedorDTO : proveedores) {
			System.out.println(proveedorDTO);
		}
		model.addAttribute("lista", proveedores);
		return "admonadq/proveedores/principal";
	}

	@GetMapping("admonadq/proveedores/agregar")
	public String agregar(Model model) {
		
		model.addAttribute("proveedor", new ProveedorDTO());
		return "admonadq/proveedores/agregar";
	}

	@PostMapping("admonadq/proveedores/add")
	public String agregar(ProveedorDTO proveedorDTO, RedirectAttributes redirectAttrs) {
		System.out.println(proveedorDTO.toString());
		Mensaje.addMensaje(proveedorService.save(proveedorDTO), redirectAttrs);
		return "redirect:/admonadq/proveedores";
	}

	@GetMapping("admonadq/proveedores/editar/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		ProveedorDTO proveedorDTO = proveedorService.findById(id);
		String validUrl = "redirect:/admonadq/proveedores";
		if (Objects.nonNull(proveedorDTO)) {
			model.addAttribute("proveedor", proveedorDTO);
			validUrl = "admonadq/proveedores/editar";
		}
		return validUrl;
	}

	@PostMapping("admonadq/proveedores/update")
	public String editar(ProveedorDTO proveedorDTO, RedirectAttributes redirectAttrs) {
		Mensaje.addMensaje(proveedorService.update(proveedorDTO, proveedorDTO.getIdProveedor()), redirectAttrs);
		return "redirect:/admonadq/proveedores";
	}

	@GetMapping("admonadq/proveedores/eliminar/{id}/{idEstatus}")
	public String eliminar(@PathVariable("id") int id, @PathVariable("idEstatus") int idEstatus,
			RedirectAttributes redirectAttrs) {
		Mensaje.addMensaje(proveedorService.borraPorId(id, idEstatus), redirectAttrs);
		return "redirect:/admonadq/proveedores";
	}

	
	@GetMapping("admonadq/proveedores/actividad/{idProveedor}")
	public String addActividad(@PathVariable("idProveedor") int idProveedor, Model model) {
		List<ActividadDTO> actividades = actividadService.findAll();
    	ProveedorDTO proveedor = proveedorService.findById(idProveedor);
		System.out.println("Proveedor " +  proveedor.toString());
		model.addAttribute("proveedor", proveedor);
		model.addAttribute("actividades", actividades);
		return "admonadq/proveedores/actividad";
	}
	
	@PostMapping("admonadq/proveedores/actividad/add")
	public String agregarActividad(ProveedorDTO proveedor, RedirectAttributes redirectAttrs) {
		Mensaje.addMensaje(proveedorService.agregarActividad(proveedor), redirectAttrs);
		return "redirect:/admonadq/proveedores/actividad/"+proveedor.getIdProveedor();
	}
	
	@GetMapping("admonadq/proveedores/actividad/eliminar/{idProveedor}/{idActividad}")
	public String eliminarActividad(@PathVariable("idProveedor") int idProveedor, @PathVariable("idActividad") int idActividad,	RedirectAttributes redirectAttrs) {
		Mensaje.addMensaje(proveedorService.borraActividad(idProveedor, idActividad), redirectAttrs);
		return "redirect:/admonadq/proveedores/actividad/"+idProveedor;
	}
	
	

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, false));
	}
}