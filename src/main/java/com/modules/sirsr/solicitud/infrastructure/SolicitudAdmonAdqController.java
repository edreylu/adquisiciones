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
import com.modules.sirsr.solicitud.application.SolicitudDTO;
import com.modules.sirsr.solicitud.application.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Edward Reyes
 */
@Controller
public class SolicitudAdmonAdqController {

    private final SolicitudService solicitudService;
    private final RequisicionService requisicionService;
    private final DetalleRequisicionService detalleRequisicionService;
    private final DocumentoService documentoService;
    private List<SolicitudDTO> solicitudes;
    private List<RequisicionDTO> requisiciones;
    private List<DetalleRequisicionDTO> detallesRequisicion;
    private List<DocumentoDTO> documentos;
    private final Mensaje msg = new Mensaje();

    @Autowired
    public SolicitudAdmonAdqController(SolicitudService solicitudService, RequisicionService requisicionService, DetalleRequisicionService detalleRequisicionService, DocumentoService documentoService) {
        this.solicitudService = solicitudService;
        this.requisicionService = requisicionService;
        this.detalleRequisicionService = detalleRequisicionService;
        this.documentoService = documentoService;
    }


    @GetMapping("admonadq/solicitudes")
    public String listar(Model model) {
        solicitudes= solicitudService.findAllEmitidas();
        model.addAttribute("lista", solicitudes);
        return "admonadq/solicitudes/principal";
    }

    @GetMapping("admonadq/solicitudes/revisar/{id}")
    public String revisar(@PathVariable("id") int id, Model model) {
        SolicitudDTO solicitudDTO = solicitudService.findById(id);
        requisiciones = requisicionService.findByIdSolicitud(id);
        documentos = documentoService.findByIdSolicitud(id);
        String validUrl = "redirect:/admonadq/solicitudes";
        if(Objects.nonNull(solicitudDTO)){
            model.addAttribute("solicitud", solicitudDTO);
            model.addAttribute("requisiciones", requisiciones);
            model.addAttribute("documentos", documentos);
            if(solicitudDTO.getEstatus().getIdEstatus()==11) solicitudService.updateEstatus(solicitudDTO,12);
            validUrl = "admonadq/solicitudes/revisar";
        }
        return validUrl;
    }

    @PostMapping("admonadq/solicitudes/aceptar/{id}")
    public String validar(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttrs) {
        msg.crearMensaje(solicitudService.aceptarById(id), redirectAttrs);
        return "redirect:/admonadq/solicitudes";
    }

    @GetMapping("admonadq/solicitudes/correccion/{id}")
    public String correccion(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttrs) {
        SolicitudDTO solicitud = solicitudService.findById(id);
        RevisionDTO revision = new RevisionDTO();
        model.addAttribute("revision", revision);
        model.addAttribute("solicitud", solicitud);
        return "admonadq/solicitudes/correccion";
    }

    @PostMapping("admonadq/solicitudes/correccion/add/{id}")
    public String correccion(@PathVariable("id") int id, RevisionDTO revisionDTO, Model model, RedirectAttributes redirectAttrs) {
        msg.crearMensaje(solicitudService.correction(revisionDTO, id), redirectAttrs);
        return "redirect:/admonadq/solicitudes";
    }

    @GetMapping("admonadq/solicitudes/searchDetallesRequisicion/{id}")
    public String serchDetallesRequisicion(@PathVariable("id") int id, Model model) {
        detallesRequisicion = detalleRequisicionService.findByIdRequisicion(id);
            model.addAttribute("detallesRequisicion", detallesRequisicion);
        return "admonadq/solicitudes/revisar :: modalDetalles";
    }

    @GetMapping("admonadq/solicitudes/downloadPDF/{id}")
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
