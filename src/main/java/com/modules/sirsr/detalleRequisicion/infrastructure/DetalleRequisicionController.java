/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.detalleRequisicion.infrastructure;

import com.modules.sirsr.clavePresupuestaria.application.ClavePresupuestariaDTO;
import com.modules.sirsr.clavePresupuestaria.application.ClavePresupuestariaService;
import com.modules.sirsr.requisicion.application.RequisicionDTO;
import com.modules.sirsr.requisicion.application.RequisicionService;
import com.modules.sirsr.subTipoProducto.application.SubTipoProductoDTO;
import com.modules.sirsr.subTipoProducto.application.SubTipoProductoService;
import com.modules.sirsr.unidadMedida.application.UnidadMedidaDTO;
import com.modules.sirsr.unidadMedida.application.UnidadMedidaService;
import com.modules.sirsr.config.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Edward Reyes
 */
@Controller
public class DetalleRequisicionController {

    private final RequisicionService requisicionService;
    private final UnidadMedidaService unidadService;
    private final ClavePresupuestariaService clavePresupuestariaService;
    private final SubTipoProductoService subTipoProductoService;
    private List<UnidadMedidaDTO> unidadMedidas;
    private List<ClavePresupuestariaDTO> clavesPresupuestarias;
    private List<SubTipoProductoDTO> subTipoProductos;
    private final Mensaje msg = new Mensaje();

    @Autowired
    public DetalleRequisicionController(RequisicionService requisicionService, UnidadMedidaService unidadService, ClavePresupuestariaService clavePresupuestariaService, SubTipoProductoService subTipoProductoService) {
        this.requisicionService = requisicionService;
        this.unidadService = unidadService;
        this.clavePresupuestariaService = clavePresupuestariaService;
        this.subTipoProductoService = subTipoProductoService;
    }

    @GetMapping("usuario/requisiciones/editarDetalles/{id}")
    public String editar(@PathVariable("id") int id, Model model) {
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
    public String editar(@PathVariable("id") int id, RequisicionDTO requisicionDTO, RedirectAttributes redirectAttrs){
        msg.crearMensaje(requisicionService.saveDetalles(requisicionDTO, id), redirectAttrs);
        return "redirect:/usuario/requisiciones";
    }

}
