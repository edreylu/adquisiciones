/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.solicitud;

import com.modules.sirsr.prioridad.PrioridadService;
import com.modules.sirsr.PartidaGasto.ObjetoDeGastoDTO;
import com.modules.sirsr.PartidaGasto.ObjetoDeGastoService;
import com.modules.sirsr.clavePresupuestaria.ClavePresupuestariaDTO;
import com.modules.sirsr.clavePresupuestaria.ClavePresupuestariaService;
import com.modules.sirsr.documento.DocumentoDTO;
import com.modules.sirsr.documento.DocumentoService;
import com.modules.sirsr.subTipoProducto.SubTipoProductoDTO;
import com.modules.sirsr.subTipoProducto.SubTipoProductoService;
import com.modules.sirsr.tipoDocumento.TipoDocumentoDTO;
import com.modules.sirsr.tipoDocumento.TipoDocumentoService;
import com.modules.sirsr.unidadMedida.UnidadMedidaDTO;
import com.modules.sirsr.unidadMedida.UnidadMedidaService;
import com.modules.sirsr.utils.Mensaje;
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
public class SolicitudController {

    private final SolicitudService solicitudService;
    private final UnidadMedidaService unidadService;
    private final ObjetoDeGastoService objetoDeGastoService;
    private final DocumentoService documentoService;
    private final TipoDocumentoService tipoDocumentoService;
    private final ClavePresupuestariaService clavePresupuestariaService;
    private final SubTipoProductoService subTipoProductoService;
    private final PrioridadService prioridadService;
    private List<SolicitudDTO> solicitudes;
    private List<ObjetoDeGastoDTO> partidasEspecificas;
    private List<UnidadMedidaDTO> unidadMedidas;
    private List<DocumentoDTO> documentos;
    private List<TipoDocumentoDTO> tiposDocumento;
    private List<ClavePresupuestariaDTO> clavesPresupuestarias;
    private List<SubTipoProductoDTO> subTipoProductos;
    private final Mensaje msg = new Mensaje();

    @Autowired
    public SolicitudController(SolicitudService solicitudService, UnidadMedidaService unidadService, ObjetoDeGastoService objetoDeGastoService, DocumentoService documentoService, TipoDocumentoService tipoDocumentoService, ClavePresupuestariaService clavePresupuestariaService, SubTipoProductoService subTipoProductoService, PrioridadService prioridadService) {
        this.solicitudService = solicitudService;
        this.unidadService = unidadService;
        this.objetoDeGastoService = objetoDeGastoService;
        this.documentoService = documentoService;
        this.tipoDocumentoService = tipoDocumentoService;
        this.clavePresupuestariaService = clavePresupuestariaService;
        this.subTipoProductoService = subTipoProductoService;
        this.prioridadService = prioridadService;
    }

    @GetMapping("usuario/solicitudes")
    public String listar(Model model) {
        solicitudes= solicitudService.findByClaveUnidad();
        model.addAttribute("lista", solicitudes);
        return "usuario/solicitudes/principal";
    }

    @GetMapping("usuario/solicitudes/agregar")
    public String agregar(Model model) {
        partidasEspecificas = objetoDeGastoService.findAll();
        model.addAttribute("partidasEspecificas", partidasEspecificas);
        model.addAttribute("solicitud", new SolicitudDTO());
        return "usuario/solicitudes/agregar";
    }

    @PostMapping("usuario/solicitudes/add")
    public String agregar(SolicitudDTO solicitudDTO, RedirectAttributes redirectAttrs){
        msg.crearMensaje(solicitudService.save(solicitudDTO), redirectAttrs);
        return "redirect:/usuario/solicitudes";
    }

    @GetMapping("usuario/solicitudes/editar/{id}")
    public String editar(@PathVariable("id") int id, Model model) {
        SolicitudDTO solicitudDTO = solicitudService.findById(id);
        System.out.println(solicitudDTO.toString());
        String validUrl = "redirect:/usuario/solicitudes";
        if(Objects.nonNull(solicitudDTO)){
            model.addAttribute("solicitud", solicitudDTO);
            validUrl = "usuario/solicitudes/editar";
        }
        return validUrl;
    }

    @PostMapping("usuario/solicitudes/update/{id}")
    public String editar(@PathVariable("id") int id, RedirectAttributes redirectAttrs) {
        return "redirect:/usuario/solicitudes";
    }

    @GetMapping("admin/solicitudes/eliminar/{id}")
    public String eliminar(@PathVariable("id") int id,
                           RedirectAttributes redirectAttrs) {
        return "redirect:/usuario/solicitudes";
    }

    //DOCUMENTOS

    @GetMapping("usuario/solicitudes/editarDocumentos/{id}")
    public String editarDocumentos(@PathVariable("id") int id, Model model) {
        SolicitudDTO solicitudDTO = solicitudService.findById(id);
        documentos = documentoService.findByIdRequisicion(id);
        tiposDocumento = tipoDocumentoService.findAll();
        String validUrl = "redirect:/usuario/requisiciones";
        if(Objects.nonNull(solicitudDTO)){
            model.addAttribute("solicitud", solicitudDTO);
            model.addAttribute("documentos", documentos);
            model.addAttribute("tiposDocumento", tiposDocumento);
            validUrl = "usuario/solicitudes/editarDocumentos";
        }
        return validUrl;
    }

    @PostMapping("usuario/solicitudes/updateDocumentos/{id}")
    public String editarDocumentos(@PathVariable("id") int id, DocumentoDTO documentoDTO, RedirectAttributes redirectAttrs){
        msg.crearMensaje(solicitudService.saveDocumentos(documentoDTO, id), redirectAttrs);
        return "redirect:/usuario/solicitudes/editarDocumentos/"+id;
    }

    @GetMapping("usuario/solicitudes/eliminarDocumento/{id}/{idReq}")
    public String eliminarDocumento(@PathVariable("id") int id,@PathVariable("idReq") int idReq, RedirectAttributes redirectAttrs) {
        msg.crearMensaje(documentoService.deleteById(id), redirectAttrs);
        return "redirect:/usuario/solicitudes/editarDocumentos/"+idReq;
    }

}
