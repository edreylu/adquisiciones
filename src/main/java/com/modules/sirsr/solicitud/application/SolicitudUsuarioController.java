/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.solicitud.application;

import com.modules.sirsr.config.WebUtils;
import com.modules.sirsr.documento.domain.DocumentoDTO;
import com.modules.sirsr.documento.domain.DocumentoService;
import com.modules.sirsr.objetoGasto.domain.ObjetoDeGastoDTO;
import com.modules.sirsr.objetoGasto.domain.ObjetoDeGastoService;
import com.modules.sirsr.config.Mensaje;

import java.util.List;
import java.util.Objects;

import com.modules.sirsr.requisicion.domain.DetalleRequisicionDTO;
import com.modules.sirsr.requisicion.domain.DetalleRequisicionService;
import com.modules.sirsr.requisicion.domain.RequisicionDTO;
import com.modules.sirsr.requisicion.domain.RequisicionService;
import com.modules.sirsr.revision.domain.RevisionDTO;
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

/**
 *
 * @author Edward Reyes
 */
@Controller
@RequestMapping(value = "/usuario")
public class SolicitudUsuarioController {

    private final SolicitudService solicitudService;
    private final ObjetoDeGastoService objetoDeGastoService;
    private final RequisicionService requisicionService;
    private final DetalleRequisicionService detalleRequisicionService;
    private final DocumentoService documentoService;
    private final UsuarioService usuarioService;
    private final RevisionRepository revisionRepository;
    private final RevisionMapper revisionMapper;
    private List<SolicitudDTO> solicitudes;
    private List<ObjetoDeGastoDTO> partidasEspecificas;
    private List<RequisicionDTO> requisiciones;
    private List<DetalleRequisicionDTO> detallesRequisicion;
    private List<DocumentoDTO> documentos;
    private List<RevisionDTO> revisiones;
    private UsuarioDTO usuarioDTO;
    private final Mensaje msg = new Mensaje();

    @Autowired
    public SolicitudUsuarioController(SolicitudService solicitudService, ObjetoDeGastoService objetoDeGastoService, RequisicionService requisicionService, DetalleRequisicionService detalleRequisicionService, DocumentoService documentoService, UsuarioService usuarioService, RevisionRepository revisionRepository, RevisionMapper revisionMapper) {
        this.solicitudService = solicitudService;
        this.objetoDeGastoService = objetoDeGastoService;
        this.requisicionService = requisicionService;
        this.detalleRequisicionService = detalleRequisicionService;
        this.documentoService = documentoService;
        this.usuarioService = usuarioService;
        this.revisionRepository = revisionRepository;
        this.revisionMapper = revisionMapper;
    }

    @GetMapping("/solicitudes")
    public String listar(Model model) {
        solicitudes= solicitudService.findByClaveUnidad();
        usuarioDTO = usuarioService.findByUserName(WebUtils.getUserName());
        model.addAttribute("lista", solicitudes);
        model.addAttribute("unidadResponsable", usuarioDTO.getUnidadResponsable().getDescripcion());
        return "usuario/solicitudes/principal";
    }

    @GetMapping("/solicitudes/agregar")
    public String agregar(Model model) {
        model.addAttribute("solicitud", new SolicitudDTO());
        return "usuario/solicitudes/agregar";
    }

    @PostMapping("/solicitudes/add")
    public String agregar(SolicitudDTO solicitudDTO, RedirectAttributes redirectAttrs){
        msg.crearMensaje(solicitudService.save(solicitudDTO), redirectAttrs);
        return "redirect:/usuario/solicitudes";
    }

    @GetMapping("/solicitudes/editar/{id}")
    public String editar(@PathVariable("id") int id, Model model) {
        SolicitudDTO solicitudDTO = solicitudService.findById(id);
        String validUrl = "redirect:/usuario/solicitudes";
        if(Objects.nonNull(solicitudDTO)){
            model.addAttribute("solicitud", solicitudDTO);
            validUrl = "usuario/solicitudes/editar";
        }
        return validUrl;
    }

    @GetMapping("/solicitudes/detallesSolicitud/{id}")
    public String detalles(@PathVariable("id") int id, Model model) {
        SolicitudDTO solicitudDTO = solicitudService.findById(id);
        requisiciones = requisicionService.findByIdSolicitud(id);
        documentos = documentoService.findByIdSolicitud(id);
        String validUrl = "redirect:/usuario/solicitudes";
        if(Objects.nonNull(solicitudDTO)){
            model.addAttribute("solicitud", solicitudDTO);
            model.addAttribute("requisiciones", requisiciones);
            model.addAttribute("documentos", documentos);
            validUrl = "usuario/solicitudes/detallesSolicitud";
        }
        return validUrl;
    }

    @PostMapping("/solicitudes/update/{id}")
    public String editar(SolicitudDTO solicitudDTO, @PathVariable("id") int id, RedirectAttributes redirectAttrs) {
        msg.crearMensaje(solicitudService.update(solicitudDTO, id), redirectAttrs);
        return "redirect:/usuario/solicitudes";
    }

    @GetMapping("/solicitudes/eliminar/{id}")
    public String eliminar(@PathVariable("id") int id,
                           RedirectAttributes redirectAttrs) {
        msg.crearMensaje(solicitudService.deleteById(id), redirectAttrs);
        return "redirect:/usuario/solicitudes";
    }


    @PostMapping("/solicitudes/emitir/{id}")
    public String validar(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttrs) {
        msg.crearMensaje(solicitudService.emitirById(id), redirectAttrs);
        return "redirect:/usuario/solicitudes";
    }


    @GetMapping("/solicitudes/searchDetallesRequisicion/{id}")
    public String serchDetallesRequisicion(@PathVariable("id") int id, Model model) {
        detallesRequisicion = detalleRequisicionService.findByIdRequisicion(id);
        model.addAttribute("detallesRequisicion", detallesRequisicion);
        return "usuario/solicitudes/detallesSolicitud :: modalDetalles";
    }

    @GetMapping("/solicitudes/searchObservaciones/{id}")
    public String searchObservaciones(@PathVariable("id") int id, Model model) {
        revisiones = revisionMapper.toRevisionsDTOs(revisionRepository.findByIdSolicitud(id));
        model.addAttribute("observaciones", revisiones);
        return "usuario/solicitudes/detallesSolicitud :: modalObservaciones";
    }


}
