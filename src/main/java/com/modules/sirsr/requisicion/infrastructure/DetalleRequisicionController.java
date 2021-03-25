/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.requisicion.infrastructure;

import com.modules.sirsr.config.WebUtils;
import com.modules.sirsr.producto.application.ProductoDTO;
import com.modules.sirsr.producto.application.ProductoService;
import com.modules.sirsr.requisicion.application.DetalleRequisicionDTO;
import com.modules.sirsr.requisicion.application.DetalleRequisicionService;
import com.modules.sirsr.requisicion.application.RequisicionDTO;
import com.modules.sirsr.requisicion.application.RequisicionService;
import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.usuario.application.UsuarioDTO;
import com.modules.sirsr.usuario.application.UsuarioService;
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
@RequestMapping(value = "/usuario")
public class DetalleRequisicionController {

    private final RequisicionService requisicionService;
    private final DetalleRequisicionService detalleRequisicionService;
    private final ProductoService productoService;
    private final UsuarioService usuarioService;
    private List<DetalleRequisicionDTO> detallesRequisiciones;
    private List<ProductoDTO> productos;
    private UsuarioDTO usuarioDTO;
    private final Mensaje msg = new Mensaje();

    @Autowired
    public DetalleRequisicionController(RequisicionService requisicionService, DetalleRequisicionService detalleRequisicionService, ProductoService productoService, UsuarioService usuarioService) {
        this.requisicionService = requisicionService;
        this.detalleRequisicionService = detalleRequisicionService;
        this.productoService = productoService;
        this.usuarioService = usuarioService;
    }

    @GetMapping("/solicitudes/requisiciones/detalles/{id}")
    public String listar(Model model, @PathVariable("id") int id) {
        detallesRequisiciones= detalleRequisicionService.findByIdRequisicion(id);
        RequisicionDTO requisicion = requisicionService.findById(id);
        usuarioDTO = usuarioService.findByUserName(WebUtils.getUserName());
        Double montoActual = detalleRequisicionService.getMontoTotal.apply(detallesRequisiciones);
        model.addAttribute("lista", detallesRequisiciones);
        model.addAttribute("requisicion", requisicion);
        model.addAttribute("montoActual", montoActual);
        model.addAttribute("unidadResponsable", usuarioDTO.getUnidadResponsable().getDescripcion());
        return "usuario/solicitudes/requisiciones/detalles/principal";
    }

    @GetMapping("/solicitudes/requisiciones/detalles/agregar/{id}")
    public String agregar(Model model, @PathVariable("id") int id) {
        DetalleRequisicionDTO detalleRequisicionDTO = new DetalleRequisicionDTO();
        detalleRequisicionDTO.setIdRequisicion(id);
        RequisicionDTO requisicionDTO = requisicionService.findById(id);
        String objetoGasto = requisicionDTO.getClavePresupuestaria().getObjetoDeGasto().getObjetoGasto();
        productos = productoService.findByIdTipoProducto(objetoGasto);
        model.addAttribute("detalle", detalleRequisicionDTO);
        model.addAttribute("productos", productos);
        return "usuario/solicitudes/requisiciones/detalles/agregar";
    }

    @PostMapping("/solicitudes/requisiciones/detalles/add/{id}")
    public String agregar(@PathVariable("id") int id, DetalleRequisicionDTO detalleRequisicionDTO, RedirectAttributes redirectAttrs){
        msg.crearMensaje(detalleRequisicionService.save(detalleRequisicionDTO, id), redirectAttrs);
        return "redirect:/usuario/solicitudes/requisiciones/detalles/"+id;
    }

    @GetMapping("/solicitudes/requisiciones/detalles/editar/{id}")
    public String editar(@PathVariable("id") int id, Model model) {
        DetalleRequisicionDTO detalleRequisicionDTO = detalleRequisicionService.findById(id);
        String objetoGasto = detalleRequisicionDTO.getRequisicion().getClavePresupuestaria().getObjetoDeGasto().getObjetoGasto();
        productos = productoService.findByIdTipoProducto(objetoGasto);
        String validUrl = "redirect:/usuario/solicitudes/requisiciones/detalles/"+id;
        if(Objects.nonNull(detalleRequisicionDTO)){
            model.addAttribute("detalle", detalleRequisicionDTO);
            model.addAttribute("productos", productos);
            model.addAttribute("producto", detalleRequisicionDTO.getProducto());
            validUrl = "usuario/solicitudes/requisiciones/detalles/editar";
        }
        return validUrl;
    }

    @PostMapping("/solicitudes/requisiciones/detalles/update/{id}/{idRequisicion}")
    public String editar(DetalleRequisicionDTO detalleRequisicionDTO, @PathVariable("id") int id,@PathVariable("idRequisicion") int idRequisicion, RedirectAttributes redirectAttrs) {
        msg.crearMensaje(detalleRequisicionService.update(detalleRequisicionDTO, id, idRequisicion), redirectAttrs);
        return "redirect:/usuario/solicitudes/requisiciones/detalles/"+idRequisicion;
    }

    @GetMapping("/solicitudes/requisiciones/detalles/eliminar/{id}/{idRequisicion}")
    public String eliminar(@PathVariable("id") int id, @PathVariable("idRequisicion") int idRequisicion, RedirectAttributes redirectAttrs) {
        msg.crearMensaje(detalleRequisicionService.deleteById(id), redirectAttrs);
        return "redirect:/usuario/solicitudes/requisiciones/detalles/"+idRequisicion;
    }

    @GetMapping("/solicitudes/requisiciones/detalles/updateProducto/{id}")
    public String updateProducto(@PathVariable("id") int id, Model model) {
        ProductoDTO productoDTO = productoService.findById(id);
        model.addAttribute("producto", productoDTO);
        return "usuario/solicitudes/requisiciones/detalles/agregar :: #idProducto";
    }

}
