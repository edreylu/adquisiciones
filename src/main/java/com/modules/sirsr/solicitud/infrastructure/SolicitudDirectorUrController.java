/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.solicitud.infrastructure;

import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.documento.application.DocumentoDTO;
import com.modules.sirsr.documento.application.DocumentoService;
import com.modules.sirsr.requisicion.application.DetalleRequisicionDTO;
import com.modules.sirsr.requisicion.application.DetalleRequisicionService;
import com.modules.sirsr.requisicion.application.RequisicionDTO;
import com.modules.sirsr.requisicion.application.RequisicionService;
import com.modules.sirsr.revision.application.RevisionDTO;
import com.modules.sirsr.revision.application.RevisionMapper;
import com.modules.sirsr.revision.domain.RevisionRepository;
import com.modules.sirsr.solicitud.application.SolicitudDTO;
import com.modules.sirsr.solicitud.application.SolicitudService;
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
@RequestMapping(value = "/directorur")
public class SolicitudDirectorUrController {

    private final SolicitudService solicitudService;
    private final RequisicionService requisicionService;
    private final DetalleRequisicionService detalleRequisicionService;
    private final DocumentoService documentoService;
    private final RevisionRepository revisionRepository;
    private final RevisionMapper revisionMapper;
    private List<SolicitudDTO> solicitudes;
    private List<RequisicionDTO> requisiciones;
    private List<DetalleRequisicionDTO> detallesRequisicion;
    private List<DocumentoDTO> documentos;
    private List<RevisionDTO> revisiones;
    private final Mensaje msg = new Mensaje();

    @Autowired
    public SolicitudDirectorUrController(SolicitudService solicitudService, RequisicionService requisicionService, DetalleRequisicionService detalleRequisicionService, DocumentoService documentoService, RevisionRepository revisionRepository, RevisionMapper revisionMapper) {
        this.solicitudService = solicitudService;
        this.requisicionService = requisicionService;
        this.detalleRequisicionService = detalleRequisicionService;
        this.documentoService = documentoService;
        this.revisionRepository = revisionRepository;
        this.revisionMapper = revisionMapper;
    }


    @GetMapping("/solicitudes")
    public String listar(Model model) {
        solicitudes= solicitudService.findByClaveUnidad();
        model.addAttribute("lista", solicitudes);
        return "directorur/solicitudes/principal";
    }

    @GetMapping("/solicitudes/revisar/{id}")
    public String revisar(@PathVariable("id") int id, Model model) {
        SolicitudDTO solicitudDTO = solicitudService.findById(id);
        requisiciones = requisicionService.findByIdSolicitud(id);
        documentos = documentoService.findByIdSolicitud(id);
        String validUrl = "redirect:/directorur/solicitudes";
        if(Objects.nonNull(solicitudDTO)){
            model.addAttribute("solicitud", solicitudDTO);
            model.addAttribute("requisiciones", requisiciones);
            model.addAttribute("documentos", documentos);
            validUrl = "directorur/solicitudes/revisar";
        }
        return validUrl;
    }

    @PostMapping("/solicitudes/emitir/{id}")
    public String validar(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttrs) {
        msg.crearMensaje(solicitudService.emitirById(id), redirectAttrs);
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
        revisiones = revisionMapper.toRevisionsDTOs(revisionRepository.findByIdSolicitud(id));
        model.addAttribute("observaciones", revisiones);
        return "directorur/solicitudes/revisar :: modalObservaciones";
    }
}
