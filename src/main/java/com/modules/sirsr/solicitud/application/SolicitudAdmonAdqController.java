/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.solicitud.application;

import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.documento.domain.DocumentoDTO;
import com.modules.sirsr.documento.domain.DocumentoService;
import com.modules.sirsr.producto.domain.ProductoService;
import com.modules.sirsr.requisicion.domain.DetalleRequisicionDTO;
import com.modules.sirsr.requisicion.domain.DetalleRequisicionService;
import com.modules.sirsr.requisicion.domain.RequisicionDTO;
import com.modules.sirsr.requisicion.domain.RequisicionService;
import com.modules.sirsr.revision.domain.RevisionDTO;
import com.modules.sirsr.solicitud.domain.SolicitudDTO;
import com.modules.sirsr.solicitud.domain.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Edward Reyes
 */
@Controller
@RequestMapping("/admonadq")
public class SolicitudAdmonAdqController {

	private final SolicitudService solicitudService;
	private final RequisicionService requisicionService;
	private final DetalleRequisicionService detalleRequisicionService;
	private final DocumentoService documentoService;
	private final ProductoService productoService;
	private List<SolicitudDTO> solicitudes;
	private List<RequisicionDTO> requisiciones;
	private List<DetalleRequisicionDTO> detallesRequisicion;
	private List<DocumentoDTO> documentos;

	@Autowired
	public SolicitudAdmonAdqController(SolicitudService solicitudService, RequisicionService requisicionService,
			DetalleRequisicionService detalleRequisicionService, DocumentoService documentoService,
			ProductoService productoService) {
		this.solicitudService = solicitudService;
		this.requisicionService = requisicionService;
		this.detalleRequisicionService = detalleRequisicionService;
		this.documentoService = documentoService;
		this.productoService = productoService;
	}

	@GetMapping("/solicitudes")
	public String listar(Model model) {
		solicitudes = solicitudService.findAllEmitidas();
		boolean areThereProductsSuggestions = productoService.areThereProductsSuggestions();
		model.addAttribute("lista", solicitudes);
		model.addAttribute("areThereProductsSuggestions", areThereProductsSuggestions);
		return "admonadq/solicitudes/principal";
	}

	@GetMapping("/solicitudes/revisar/{id}")
	public String revisar(@PathVariable("id") int id, Model model) {
		SolicitudDTO solicitudDTO = solicitudService.findById(id);
		requisiciones = requisicionService.findByIdSolicitud(id);
		documentos = documentoService.findByIdSolicitud(id);
		String validUrl = "redirect:/admonadq/solicitudes";
		if (Objects.nonNull(solicitudDTO)) {
			model.addAttribute("solicitud", solicitudDTO);
			model.addAttribute("requisiciones", requisiciones);
			model.addAttribute("documentos", documentos);
			if (solicitudDTO.getEstatus().getIdEstatus() == 11)
				solicitudService.updateEstatusFecha(solicitudDTO, 12);
			validUrl = "admonadq/solicitudes/revisar";
		}
		return validUrl;
	}

	@PostMapping("/solicitudes/aceptar/{id}")
	public String aceptar(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttrs) {
		Mensaje.addMensaje(solicitudService.acceptById(id), redirectAttrs);
		return "redirect:/admonadq/solicitudes";
	}

	@GetMapping("/solicitudes/correccion/{id}")
	public String correccion(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttrs) {
		SolicitudDTO solicitud = solicitudService.findById(id);
		RevisionDTO revision = new RevisionDTO();
		model.addAttribute("revision", revision);
		model.addAttribute("solicitud", solicitud);
		return "admonadq/solicitudes/correccion";
	}

	@PostMapping("/solicitudes/correccion/add/{id}")
	public String correccion(@PathVariable("id") int id, RevisionDTO revisionDTO, Model model,
			RedirectAttributes redirectAttrs) {
		Mensaje.addMensaje(solicitudService.correction(revisionDTO, id), redirectAttrs);
		return "redirect:/admonadq/solicitudes";
	}

	@GetMapping("/solicitudes/searchDetallesRequisicion/{id}")
	public String serchDetallesRequisicion(@PathVariable("id") int id, Model model) {
		detallesRequisicion = detalleRequisicionService.findByIdRequisicion(id);
		model.addAttribute("detallesRequisicion", detallesRequisicion);
		return "admonadq/solicitudes/revisar :: modalDetalles";
	}

}
