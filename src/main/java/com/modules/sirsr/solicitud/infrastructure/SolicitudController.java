/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.solicitud.infrastructure;

import com.modules.sirsr.documento.application.DocumentoDTO;
import com.modules.sirsr.documento.application.DocumentoService;
import com.modules.sirsr.estatus.domain.Estatus;
import com.modules.sirsr.objetoGasto.application.ObjetoDeGastoDTO;
import com.modules.sirsr.objetoGasto.application.ObjetoDeGastoService;
import com.modules.sirsr.config.Mensaje;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

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
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Edward Reyes
 */
@Controller
@RequestMapping(value = "/usuario")
public class SolicitudController {

    private final SolicitudService solicitudService;
    private final ObjetoDeGastoService objetoDeGastoService;
    private final RequisicionService requisicionService;
    private final DetalleRequisicionService detalleRequisicionService;
    private final DocumentoService documentoService;
    private final RevisionRepository revisionRepository;
    private final RevisionMapper revisionMapper;
    private List<SolicitudDTO> solicitudes;
    private List<ObjetoDeGastoDTO> partidasEspecificas;
    private List<RequisicionDTO> requisiciones;
    private List<DetalleRequisicionDTO> detallesRequisicion;
    private List<DocumentoDTO> documentos;
    private List<RevisionDTO> revisiones;
    private final Mensaje msg = new Mensaje();

    @Autowired
    public SolicitudController(SolicitudService solicitudService, ObjetoDeGastoService objetoDeGastoService, RequisicionService requisicionService, DetalleRequisicionService detalleRequisicionService, DocumentoService documentoService, RevisionRepository revisionRepository, RevisionMapper revisionMapper) {
        this.solicitudService = solicitudService;
        this.objetoDeGastoService = objetoDeGastoService;
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
        return "usuario/solicitudes/principal";
    }

    @GetMapping("/solicitudes/agregar")
    public String agregar(Model model) {
        partidasEspecificas = objetoDeGastoService.findAll();
        model.addAttribute("partidasEspecificas", partidasEspecificas);
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
        Estatus estatus = new Estatus();
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
    public String editar(@PathVariable("id") int id, RedirectAttributes redirectAttrs) {
        return "redirect:/usuario/solicitudes";
    }

    @GetMapping("/solicitudes/eliminar/{id}")
    public String eliminar(@PathVariable("id") int id,
                           RedirectAttributes redirectAttrs) {
        return "redirect:/usuario/solicitudes";
    }


    @PostMapping("/solicitudes/validate/{id}")
    public String validar(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttrs) {
        msg.crearMensaje(solicitudService.validateById(id), redirectAttrs);
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

    @GetMapping("/solicitudes/downloadPDF/{id}")
    public void downloadPDFResource(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) throws IOException {
        DocumentoDTO documentoDTO = documentoService.findById(id);
        // Content-Type
        // application/pdf
        response.setContentType("application/pdf");
        // Content-Disposition
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + "doc.pdf");
        // Content-Length
        response.setContentLength((int) documentoDTO.getDocumento().length);

        InputStream is = new ByteArrayInputStream(documentoDTO.getDocumento());
        BufferedOutputStream outStream = new BufferedOutputStream(response.getOutputStream());

        byte[] buffer = new byte[1024];
        int bytesRead = 0;
        while ((bytesRead = is.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
        outStream.flush();
        is.close();
    }
}
