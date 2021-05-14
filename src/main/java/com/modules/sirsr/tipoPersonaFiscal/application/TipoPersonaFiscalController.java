package com.modules.sirsr.tipoPersonaFiscal.application;

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

import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.tipoPersonaFiscal.domain.TipoPersonaFiscalDTO;
import com.modules.sirsr.tipoPersonaFiscal.domain.TipoPersonaFiscalService;

@Controller
@RequestMapping("/admonadq")
public class TipoPersonaFiscalController {

	@Autowired
	private TipoPersonaFiscalService tipoPersonaFiscalService;
	private List<TipoPersonaFiscalDTO> listaTipoPersonaFiscal;

	public List<TipoPersonaFiscalDTO> getListaTipoPersonaFiscal() {
		return listaTipoPersonaFiscal;
	}

	public void setListaTipoPersonaFiscal(List<TipoPersonaFiscalDTO> listaTipoPersonaFiscal) {
		this.listaTipoPersonaFiscal = listaTipoPersonaFiscal;
	}

	@GetMapping("/tipospersonafiscal")
	public String listar(Model model) {
		listaTipoPersonaFiscal = tipoPersonaFiscalService.findAll();
		model.addAttribute("lista", listaTipoPersonaFiscal);
		return "admin/tipospersonafiscal/principal";
	}

	@GetMapping("/tipospersonafiscal/editar/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		TipoPersonaFiscalDTO tipoPersonaFisDTO = tipoPersonaFiscalService.buscaPorId(id);
		String validUrl = "redirect:/admin/tipospersonafiscal";
		if (Objects.nonNull(tipoPersonaFisDTO)) {
			model.addAttribute("tipopersonafiscal", tipoPersonaFisDTO);
			validUrl = "admin/tipospersonafiscal/editar";
		}
		return validUrl;
	}

	@PostMapping("/tipospersonafiscal/update/{id}")
	public String editar(@PathVariable("id") int id, TipoPersonaFiscalDTO tipopersonafiscal,
			RedirectAttributes redirectAttrs) {
		Mensaje.addMensaje(tipoPersonaFiscalService.actualizaTipoPersonaFiscal(tipopersonafiscal, id), redirectAttrs);
		return "redirect:/admin/tipospersonafiscal";
	}

	@GetMapping("/tipospersonafiscal/agregar")
	public String agregar(Model model) {
		model.addAttribute("tipoPersonaFiscal", new TipoPersonaFiscalDTO());
		return "admin/tipospersonafiscal/agregar";
	}

	@PostMapping("/tipospersonafiscal/add")
	public String agregar(TipoPersonaFiscalDTO tp, RedirectAttributes redirectAttrs) {
		Mensaje.addMensaje(tipoPersonaFiscalService.save(tp), redirectAttrs);
		return "redirect:/admin/tipospersonafiscal";
	}

	@GetMapping("/tipospersonafiscal/eliminar/{id}/{idestatus}")
	public String eliminar(@PathVariable("id") int id, @PathVariable("idestatus") int idestatus,
			RedirectAttributes redirectAttrs) {
		Mensaje.addMensaje(tipoPersonaFiscalService.borraPorId(id, idestatus), redirectAttrs);
		return "redirect:/admin/tipospersonafiscal";
	}

}
