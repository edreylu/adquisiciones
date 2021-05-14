package com.modules.sirsr.folioRequisicion.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.folioRequisicion.domain.FolioRequisicionDTO;
import com.modules.sirsr.folioRequisicion.domain.FolioRequisicionService;

@Controller
@RequestMapping("/admonadq")
public class FolioRequisicionController {

	private final FolioRequisicionService folioRequisicionService;
	private List<FolioRequisicionDTO> listaFolioRequisicionDTO;

	@Autowired
	public FolioRequisicionController(FolioRequisicionService folioRequisicionService) {
		this.folioRequisicionService = folioRequisicionService;
	}

	@GetMapping("/foliosrequisiciones")
	public String listar(Model model) {

		listaFolioRequisicionDTO = folioRequisicionService.findAll();

		for (FolioRequisicionDTO folioRequisicionDTO : listaFolioRequisicionDTO) {
			System.out.println("Desde el controller: " + folioRequisicionDTO.getAnio());
		}

		model.addAttribute("anioActual", folioRequisicionService.verificaAnioActual());
		model.addAttribute("lista", listaFolioRequisicionDTO);
		return "admonadq/foliosrequisiciones/principal";
	}

	@GetMapping("/foliosrequisiciones/eliminar/{id}/{idestatus}")
	public String eliminar(@PathVariable("id") int id, @PathVariable("idestatus") int idEstatus,
			RedirectAttributes redirectAttrs) {
		Mensaje.addMensaje(folioRequisicionService.activarInactivar(id, idEstatus), redirectAttrs);
		return "redirect:/admonadq/foliosrequisiciones";
	}

	@GetMapping("/foliosrequisiciones/add/{id}")
	public String agregarAnio(@PathVariable("id") String anio, RedirectAttributes redirectAttrs) {
		Mensaje.addMensaje(folioRequisicionService.save(Integer.parseInt(anio)), redirectAttrs);
		return "redirect:/admonadq/foliosrequisiciones";
	}
}
