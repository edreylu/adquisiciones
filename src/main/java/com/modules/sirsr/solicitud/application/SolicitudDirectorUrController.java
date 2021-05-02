/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.solicitud.application;

import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.config.WebUtils;
import com.modules.sirsr.documento.domain.DocumentoDTO;
import com.modules.sirsr.documento.domain.DocumentoService;
import com.modules.sirsr.requisicion.domain.DetalleRequisicionDTO;
import com.modules.sirsr.requisicion.domain.DetalleRequisicionService;
import com.modules.sirsr.requisicion.domain.RequisicionDTO;
import com.modules.sirsr.requisicion.domain.RequisicionService;
import com.modules.sirsr.revision.domain.RevisionDTO;
import com.modules.sirsr.revision.domain.RevisionService;
import com.modules.sirsr.revision.persistence.RevisionMapper;
import com.modules.sirsr.revision.persistence.RevisionRepository;
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
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Edward Reyes
 */
@Controller
@RequestMapping("/directorur")
public class SolicitudDirectorUrController {

	private final SolicitudService solicitudService;
	private final RequisicionService requisicionService;
	private final DetalleRequisicionService detalleRequisicionService;
	private final DocumentoService documentoService;
	private final UsuarioService usuarioService;
	private final RevisionService revisionService;
	private List<SolicitudDTO> solicitudes;
	private List<RequisicionDTO> requisiciones;
	private List<DetalleRequisicionDTO> detallesRequisicion;
	private List<DocumentoDTO> documentos;
	private List<RevisionDTO> revisiones;
	private UsuarioDTO usuarioDTO;

	@Autowired
	public SolicitudDirectorUrController(SolicitudService solicitudService, RequisicionService requisicionService,
			DetalleRequisicionService detalleRequisicionService, UsuarioService usuarioService,
			DocumentoService documentoService, RevisionService revisionService) {
		this.solicitudService = solicitudService;
		this.requisicionService = requisicionService;
		this.detalleRequisicionService = detalleRequisicionService;
		this.documentoService = documentoService;
		this.revisionService = revisionService;
		this.usuarioService = usuarioService;
	}

	@GetMapping("/solicitudes")
	public String listar(Model model) {
		solicitudes = solicitudService.findByClaveUnidad();
		usuarioDTO = usuarioService.findByUserName(WebUtils.getUserName());
		model.addAttribute("lista", solicitudes);
		model.addAttribute("unidadResponsable", usuarioDTO.getUnidadResponsable().getDescripcion());
		return "directorur/solicitudes/principal";
	}

	@GetMapping("/solicitudes/revisar/{id}")
	public String revisar(@PathVariable("id") int id, Model model) {
		SolicitudDTO solicitudDTO = solicitudService.findById(id);
		requisiciones = requisicionService.findByIdSolicitud(id);
		documentos = documentoService.findByIdSolicitud(id);
		String validUrl = "redirect:/directorur/solicitudes";
		if (Objects.nonNull(solicitudDTO)) {
			model.addAttribute("solicitud", solicitudDTO);
			model.addAttribute("requisiciones", requisiciones);
			model.addAttribute("documentos", documentos);
			validUrl = "directorur/solicitudes/revisar";
		}
		return validUrl;
	}

	@PostMapping("/solicitudes/emitir/{id}")
	public String emitir(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttrs) {
		Mensaje.addMensaje(solicitudService.emitirById(id), redirectAttrs);
		return "redirect:/directorur/solicitudes";
	}

	@GetMapping("/solicitudes/searchDetallesRequisicion/{id}")
	public String serchDetallesRequisicion(@PathVariable("id") int id, Model model) {
		detallesRequisicion = detalleRequisicionService.findByIdRequisicion(id);
		model.addAttribute("detallesRequisicion", detallesRequisicion);
		return "directorur/solicitudes/revisar :: modalDetalles";
	}

	@GetMapping("/solicitudes/searchObservaciones/{id}")
	public String searchObservaciones(@PathVariable("id") int id, Model model) {
		revisiones = revisionService.findByIdSolicitud(id);
		model.addAttribute("observaciones", revisiones);
		return "directorur/solicitudes/revisar :: modalObservaciones";
	}
}
