package com.modules.sirsr.diaPermitido.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.diaPermitido.domain.DiaPermitidoDTO;
import com.modules.sirsr.diaPermitido.domain.DiaPermitidoService;

@Controller
@RequestMapping("/admonadq")
public class DiaPermitidoController {

	private final DiaPermitidoService diaPermitidoService;

	@Autowired
	public DiaPermitidoController(DiaPermitidoService diaPermitidoService) {
		this.diaPermitidoService = diaPermitidoService;

	}

	@GetMapping("/diaspermitidos")
	public String listar(Model model) {
		List<DiaPermitidoDTO> diasPermitidos = diaPermitidoService.findAll();
		model.addAttribute("lista", diasPermitidos);
		return "admonadq/diaspermitidos/principal";
	}

	@GetMapping("/diaspermitidos/agregar")
	public String agregar(Model model) {
		model.addAttribute("diaPermitido", new DiaPermitidoDTO());
		return "admonadq/diaspermitidos/agregar";
	}

	@PostMapping("/diaspermitidos/add_day")
	public String agregarDia(DiaPermitidoDTO diaPermitido, RedirectAttributes redirectAttrs) {
		Mensaje.addMensaje(diaPermitidoService.saveDay(diaPermitido), redirectAttrs);
		return "redirect:/admonadq/diaspermitidos";
	}

	@PostMapping("/diaspermitidos/add_days")
	public String agregarDias(DiaPermitidoDTO diaPermitido, RedirectAttributes redirectAttrs) {
		Mensaje.addMensaje(diaPermitidoService.saveDays(diaPermitido), redirectAttrs);
		return "redirect:/admonadq/diaspermitidos";
	}

	@GetMapping("/diaspermitidos/eliminar/{fechaString}/{idEstatus}")
	public String eliminar(@PathVariable("fechaString") String fechaString, @PathVariable("idEstatus") int idEstatus,
			RedirectAttributes redirectAttrs) {
		try {
			System.out.println("La fecha final es: " + fechaString);
			Date fecha = new SimpleDateFormat("dd-MM-yyyy").parse(fechaString);
			Mensaje.addMensaje(diaPermitidoService.inactivarPorId(fecha, idEstatus), redirectAttrs);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/admonadq/diaspermitidos";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, false));
	}
}
