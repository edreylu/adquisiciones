/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.documento.application;
import com.modules.sirsr.documento.domain.DocumentoDTO;
import com.modules.sirsr.documento.domain.DocumentoService;
import com.modules.sirsr.solicitud.domain.SolicitudDTO;
import com.modules.sirsr.solicitud.domain.SolicitudService;
import com.modules.sirsr.tipoDocumento.domain.TipoDocumentoDTO;
import com.modules.sirsr.tipoDocumento.domain.TipoDocumentoService;
import com.modules.sirsr.config.Mensaje;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Edward Reyes
 */
@Controller
public class DocumentoController {

    private final SolicitudService solicitudService;
    private final DocumentoService documentoService;
    private final TipoDocumentoService tipoDocumentoService;
    private SolicitudDTO solicitudDTO;
    private List<DocumentoDTO> documentos;
    private List<TipoDocumentoDTO> tiposDocumento;
    private final Mensaje msg = new Mensaje();

    @Autowired
    public DocumentoController(SolicitudService solicitudService, DocumentoService documentoService, TipoDocumentoService tipoDocumentoService) {
        this.solicitudService = solicitudService;
        this.documentoService = documentoService;
        this.tipoDocumentoService = tipoDocumentoService;
    }


    @GetMapping("usuario/solicitudes/documentos/{id}")
    public String editarDocumentos(@PathVariable("id") int id, Model model) {
        solicitudDTO = solicitudService.findById(id);
        documentos = documentoService.findByIdSolicitud(id);
        String validUrl = "redirect:/usuario/requisiciones";
        if(Objects.nonNull(solicitudDTO)){
            model.addAttribute("solicitud", solicitudDTO);
            model.addAttribute("documentos", documentos);
            validUrl = "usuario/solicitudes/documentos/principal";
        }
        return validUrl;
    }

    @PostMapping("usuario/solicitudes/documentos/update/{id}")
    public String editarDocumentos(@PathVariable("id") int id, DocumentoDTO documentoDTO, RedirectAttributes redirectAttrs){

        System.out.println(id);
        System.out.println(documentoDTO.getTipoDocumento().getIdTipoDocumento());
        msg.crearMensaje(documentoService.save(documentoDTO, id), redirectAttrs);
        return "redirect:/usuario/solicitudes/documentos/"+id;
    }

    @GetMapping("usuario/solicitudes/documentos/eliminar/{id}/{idReq}")
    public String eliminarDocumento(@PathVariable("id") int id,@PathVariable("idReq") int idReq, RedirectAttributes redirectAttrs) {
        msg.crearMensaje(documentoService.deleteById(id), redirectAttrs);
        return "redirect:/usuario/solicitudes/documentos/"+idReq;
    }

    @GetMapping("usuario/solicitudes/documentos/addDocumento/{id}")
    public String documento(@PathVariable("id") int id, Model model) {
        solicitudDTO = solicitudService.findById(id);
        List<Integer> tiposDocumentoNot = documentoService.getTiposDocumentoNot(id);
        tiposDocumento = tipoDocumentoService.findAllByTiposDocumentoNot(tiposDocumentoNot);
        model.addAttribute("tiposDocumento", tiposDocumento);
        model.addAttribute("solicitud", solicitudDTO);
        model.addAttribute("documento", new DocumentoDTO());
        return "usuario/solicitudes/documentos/principal :: modalSubirDocumento";
    }

}
