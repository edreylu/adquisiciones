package com.modules.sirsr.diaPermitido.infrastucture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.diaPermitido.application.DiaPermitidoDTO;
import com.modules.sirsr.diaPermitido.application.DiaPermitidoService;

@Controller
@RequestMapping(value="/admonadq")
public class DiaPermitidoController {
	
	
	private final DiaPermitidoService diaPermitidoService;
	private final Mensaje msg = new Mensaje(); 
	
	@Autowired
	public DiaPermitidoController(DiaPermitidoService diaPermitidoService) {
		this.diaPermitidoService = diaPermitidoService;
		
	}
	
	@GetMapping("/diaspermitidos")
    public String listar(Model model) {
		List<DiaPermitidoDTO> diasPermitidos= diaPermitidoService.findAll();
		for (DiaPermitidoDTO diaPermitidoDTO : diasPermitidos) {
			System.out.println(diaPermitidoDTO.toString());
		}
    	model.addAttribute("lista", diasPermitidos);
        return "admonadq/diaspermitidos/principal";
    }
	
	
	 @GetMapping("/diaspermitidos/agregar")
	    public String agregar(Model model) {
	        model.addAttribute("diaPermitido", new DiaPermitidoDTO());
	        return "admonadq/diaspermitidos/agregar";
	  }
	 
	 @PostMapping("/diaspermitidos/add")
	    public String agregar(DiaPermitidoDTO  diaPermitido, RedirectAttributes redirectAttrs) {
	    	msg.crearMensaje(diaPermitidoService.save(diaPermitido), redirectAttrs);
	        return "redirect:/admonadq/diaspermitidos";
	    }
}
