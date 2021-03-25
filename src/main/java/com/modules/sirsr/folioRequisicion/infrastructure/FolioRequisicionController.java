package com.modules.sirsr.folioRequisicion.infrastructure;

import java.util.ArrayList;
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
import com.modules.sirsr.folioRequisicion.application.FolioRequisicionDTO;
import com.modules.sirsr.folioRequisicion.application.FolioRequisicionService;
import com.modules.sirsr.tipoPersonaFiscal.application.TipoPersonaFiscalDTO;

@Controller
@RequestMapping("/admonadq")
public class FolioRequisicionController {
	
	private final FolioRequisicionService folioRequisicionService;
	
	private List<FolioRequisicionDTO> listaFolioRequisicionDTO = new ArrayList();
	private final Mensaje msg = new Mensaje(); 

	
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
		Mensaje mensaje = folioRequisicionService.activarInactivar(id, idEstatus);
        msg.crearMensaje(mensaje, redirectAttrs);
        return "redirect:/admonadq/foliosrequisiciones";
    }
	
	@GetMapping("/foliosrequisiciones/add/{id}")
    public String agregarAnio(@PathVariable("id") String anio, RedirectAttributes redirectAttrs) {
        msg.crearMensaje(folioRequisicionService.save(Integer.parseInt(anio)) , redirectAttrs);
        return "redirect:/admonadq/foliosrequisiciones";
    }
}
