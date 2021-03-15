/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.requisicion.infrastructure;

import com.modules.sirsr.objetoGasto.application.ObjetoDeGastoDTO;
import com.modules.sirsr.objetoGasto.application.ObjetoDeGastoService;
import com.modules.sirsr.clavePresupuestaria.application.ClavePresupuestariaDTO;
import com.modules.sirsr.clavePresupuestaria.application.ClavePresupuestariaService;
import com.modules.sirsr.documento.application.DocumentoService;
import com.modules.sirsr.requisicion.application.RequisicionDTO;
import com.modules.sirsr.requisicion.application.RequisicionService;
import com.modules.sirsr.solicitud.application.SolicitudDTO;
import com.modules.sirsr.solicitud.application.SolicitudService;
import com.modules.sirsr.subTipoProducto.application.SubTipoProductoDTO;
import com.modules.sirsr.subTipoProducto.application.SubTipoProductoService;
import com.modules.sirsr.tipoDocumento.application.TipoDocumentoService;
import com.modules.sirsr.unidadMedida.application.UnidadMedidaDTO;
import com.modules.sirsr.unidadMedida.application.UnidadMedidaService;
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
public class RequisicionController {

    private final RequisicionService requisicionService;
    private final SolicitudService solicitudService;
    private final UnidadMedidaService unidadService;
    private final ObjetoDeGastoService objetoDeGastoService;
    private final DocumentoService documentoService;
    private final TipoDocumentoService tipoDocumentoService;
    private final ClavePresupuestariaService clavePresupuestariaService;
    private final SubTipoProductoService subTipoProductoService;
    private List<RequisicionDTO> requisiciones;
    private List<ObjetoDeGastoDTO> partidasEspecificas;
    private List<UnidadMedidaDTO> unidadMedidas;
    private List<ClavePresupuestariaDTO> clavesPresupuestarias;
    private List<SubTipoProductoDTO> subTipoProductos;
    private RequisicionDTO requisicionDTO;
    private final Mensaje msg = new Mensaje();

    @Autowired
    public RequisicionController(RequisicionService requisicionService, SolicitudService solicitudService, UnidadMedidaService unidadService, ObjetoDeGastoService objetoDeGastoService, DocumentoService documentoService, TipoDocumentoService tipoDocumentoService, ClavePresupuestariaService clavePresupuestariaService, SubTipoProductoService subTipoProductoService) {
        this.requisicionService = requisicionService;
        this.solicitudService = solicitudService;
        this.unidadService = unidadService;
        this.objetoDeGastoService = objetoDeGastoService;
        this.documentoService = documentoService;
        this.tipoDocumentoService = tipoDocumentoService;
        this.clavePresupuestariaService = clavePresupuestariaService;
        this.subTipoProductoService = subTipoProductoService;
    }

    @GetMapping("usuario/solicitudes/requisiciones/{id}")
    public String listar(Model model, @PathVariable("id") int id) {
        requisiciones= requisicionService.findByIdSolicitud(id);
        model.addAttribute("lista", requisiciones);
        model.addAttribute("solicitud", id);
        return "usuario/solicitudes/requisiciones/principal";
    }

    @GetMapping("usuario/solicitudes/requisiciones/agregar/{id}")
    public String agregar(Model model, @PathVariable("id") int id) {
        RequisicionDTO requisicionDTO = new RequisicionDTO();
        SolicitudDTO solicitudDTO = solicitudService.findById(id);
        requisicionDTO.setSolicitud(solicitudDTO);
        partidasEspecificas = objetoDeGastoService.findAll();
        clavesPresupuestarias = clavePresupuestariaService.findAll();
        model.addAttribute("partidasEspecificas", partidasEspecificas);
        model.addAttribute("requisicion", requisicionDTO);
        model.addAttribute("clavesPresupuestarias", clavesPresupuestarias);
        return "usuario/solicitudes/requisiciones/agregar";
    }

    @PostMapping("usuario/solicitudes/requisiciones/add/{id}")
    public String agregar(RequisicionDTO requisicionDTO,@PathVariable("id") int id, RedirectAttributes redirectAttrs){
        msg.crearMensaje(requisicionService.save(requisicionDTO, id), redirectAttrs);
        return "redirect:/usuario/solicitudes/requisiciones";
    }

    @GetMapping("usuario/solicitudes/requisiciones/editar/{id}")
    public String editar(@PathVariable("id") int id, Model model) {
        requisicionDTO = requisicionService.findById(id);
        clavesPresupuestarias = clavePresupuestariaService.findAll();
        String validUrl = "redirect:/usuario/solicitudes/requisiciones";
        if(Objects.nonNull(requisicionDTO)){
            model.addAttribute("requisicion", requisicionDTO);
            model.addAttribute("clavesPresupuestarias", clavesPresupuestarias);
            validUrl = "usuario/solicitudes/requisiciones/editar";
        }
        return validUrl;
    }

    @PostMapping("usuario/solicitudes/requisiciones/update/{id}/{idRequisicion}")
    public String editar(RequisicionDTO requisicionDTO, @PathVariable("id") int id,@PathVariable("idRequisicion") int idRequisicion, RedirectAttributes redirectAttrs) {
        return "redirect:/usuario/solicitudes/requisiciones";
    }

    @GetMapping("admin/requisiciones/eliminar/{id}")
    public String eliminar(@PathVariable("id") int id,
                           RedirectAttributes redirectAttrs) {
        return "redirect:/usuario/requisiciones";
    }


}
