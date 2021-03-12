/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.requisicion;

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
public class RequisicionController {

    private final RequisicionService requisicionService;
    private final UnidadMedidaService unidadService;
    private final ObjetoDeGastoService objetoDeGastoService;
    private final DocumentoService documentoService;
    private final TipoDocumentoService tipoDocumentoService;
    private final ClavePresupuestariaService clavePresupuestariaService;
    private final SubTipoProductoService subTipoProductoService;
    private List<RequisicionDTO> requisiciones;
    private List<ObjetoDeGastoDTO> partidasEspecificas;
    private List<UnidadMedidaDTO> unidadMedidas;
    private List<DocumentoDTO> documentos;
    private List<TipoDocumentoDTO> tiposDocumento;
    private List<ClavePresupuestariaDTO> clavesPresupuestarias;
    private List<SubTipoProductoDTO> subTipoProductos;
    private final Mensaje msg = new Mensaje();

    @Autowired
    public RequisicionController(RequisicionService requisicionService, UnidadMedidaService unidadService, ObjetoDeGastoService objetoDeGastoService, DocumentoService documentoService, TipoDocumentoService tipoDocumentoService, ClavePresupuestariaService clavePresupuestariaService, SubTipoProductoService subTipoProductoService) {
        this.requisicionService = requisicionService;
        this.unidadService = unidadService;
        this.objetoDeGastoService = objetoDeGastoService;
        this.documentoService = documentoService;
        this.tipoDocumentoService = tipoDocumentoService;
        this.clavePresupuestariaService = clavePresupuestariaService;
        this.subTipoProductoService = subTipoProductoService;
    }

    @GetMapping("usuario/requisiciones")
    public String listar(Model model) {
        //requisiciones = requisicionService.findByClaveUnidad();
        model.addAttribute("lista", requisiciones);
        return "usuario/requisiciones/principal";
    }

    @GetMapping("usuario/requisiciones/agregar")
    public String agregar(Model model) {
        partidasEspecificas = objetoDeGastoService.findAll();
        model.addAttribute("partidasEspecificas", partidasEspecificas);
        model.addAttribute("requisicion", new RequisicionDTO());
        return "usuario/requisiciones/agregar";
    }

    @PostMapping("usuario/requisiciones/add")
    public String agregar(RequisicionDTO requisicionDTO, RedirectAttributes redirectAttrs){
        msg.crearMensaje(requisicionService.save(requisicionDTO), redirectAttrs);
        return "redirect:/usuario/requisiciones";
    }

    @GetMapping("usuario/requisiciones/editar/{id}")
    public String editar(@PathVariable("id") int id, Model model) {
        RequisicionDTO requisicionDTO = requisicionService.findById(id);
        String validUrl = "redirect:/usuario/requisiciones";
        if(Objects.nonNull(requisicionDTO)){
            model.addAttribute("requisicion", requisicionDTO);
            validUrl = "usuario/requisiciones/editar";
        }
        return validUrl;
    }

    @PostMapping("usuario/requisiciones/update/{id}")
    public String editar(@PathVariable("id") int id, RedirectAttributes redirectAttrs) {
        return "redirect:/usuario/requisiciones";
    }

    @GetMapping("admin/requisiciones/eliminar/{id}")
    public String eliminar(@PathVariable("id") int id,
                           RedirectAttributes redirectAttrs) {
        return "redirect:/usuario/requisiciones";
    }

    //DETALLES

    @GetMapping("usuario/requisiciones/editarDetalles/{id}")
    public String editarDetalles(@PathVariable("id") int id, Model model) {
        RequisicionDTO requisicionDTO = requisicionService.findById(id);
        String validUrl = "redirect:/usuario/requisiciones";
        if(Objects.nonNull(requisicionDTO)){
            unidadMedidas = unidadService.findAll();
            clavesPresupuestarias = clavePresupuestariaService.findAll();
            subTipoProductos = subTipoProductoService.findAll();
            model.addAttribute("requisicion", requisicionDTO);
            model.addAttribute("unidadMedidas", unidadMedidas);
            model.addAttribute("clavesPresupuestarias", clavesPresupuestarias);
            model.addAttribute("subTipoProductos", subTipoProductos);
            validUrl = "usuario/requisiciones/editarDetalles";
        }
        return validUrl;
    }

    @PostMapping("usuario/requisiciones/updateDetalles/{id}")
    public String editarDetalles(@PathVariable("id") int id, RequisicionDTO requisicionDTO, RedirectAttributes redirectAttrs){
        msg.crearMensaje(requisicionService.saveDetalles(requisicionDTO, id), redirectAttrs);
        return "redirect:/usuario/requisiciones";
    }

}
