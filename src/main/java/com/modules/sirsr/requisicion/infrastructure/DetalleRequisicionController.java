/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.requisicion.infrastructure;

import com.modules.sirsr.marca.application.MarcaDTO;
import com.modules.sirsr.marca.application.MarcaService;
import com.modules.sirsr.producto.application.ProductoDTO;
import com.modules.sirsr.producto.application.ProductoService;
import com.modules.sirsr.requisicion.application.DetalleRequisicionDTO;
import com.modules.sirsr.requisicion.application.DetalleRequisicionService;
import com.modules.sirsr.requisicion.application.RequisicionDTO;
import com.modules.sirsr.requisicion.application.RequisicionService;
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
    private final DetalleRequisicionService detalleRequisicionService;
    private final ProductoService productoService;
    private final MarcaService marcaService;
    private List<DetalleRequisicionDTO> detallesRequisiciones;
    private List<MarcaDTO> marcas;
    private List<ProductoDTO> productos;
    private final Mensaje msg = new Mensaje();

    @Autowired
    public DetalleRequisicionController(RequisicionService requisicionService, DetalleRequisicionService detalleRequisicionService, ProductoService productoService, MarcaService marcaService) {
        this.requisicionService = requisicionService;
        this.detalleRequisicionService = detalleRequisicionService;
        this.productoService = productoService;
        this.marcaService = marcaService;
    }

    @GetMapping("usuario/solicitudes/requisiciones/detalles/{id}")
    public String listar(Model model, @PathVariable("id") int id) {
        detallesRequisiciones= detalleRequisicionService.findByIdRequisicion(id);
        productos = productoService.findByIdTipoProducto();
        RequisicionDTO requisicion = requisicionService.findById(id);
        model.addAttribute("lista", detallesRequisiciones);
        model.addAttribute("requisicion", requisicion);
        model.addAttribute("detalle", new DetalleRequisicionDTO());
        model.addAttribute("productos", productos);
        return "usuario/solicitudes/requisiciones/detalles/principal";
    }

    @PostMapping("usuario/solicitudes/requisiciones/detalles/add/{id}")
    public String agregar(@PathVariable("id") int id, DetalleRequisicionDTO detalleRequisicionDTO, RedirectAttributes redirectAttrs){
        msg.crearMensaje(detalleRequisicionService.save(detalleRequisicionDTO, id), redirectAttrs);
        return "redirect:/usuario/solicitudes/requisiciones/detalles/"+id;
    }

    @GetMapping("usuario/solicitudes/requisiciones/detalles/eliminar/{id}/{idRequisicion}")
    public String eliminar(@PathVariable("id") int id, @PathVariable("idRequisicion") int idRequisicion, RedirectAttributes redirectAttrs) {
        msg.crearMensaje(detalleRequisicionService.deleteById(id), redirectAttrs);
        return "redirect:/usuario/solicitudes/requisiciones/detalles/"+idRequisicion;
    }

}
