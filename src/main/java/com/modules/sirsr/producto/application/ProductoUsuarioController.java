/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.producto.application;

import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.producto.domain.ProductoDTO;
import com.modules.sirsr.producto.domain.ProductoService;
import com.modules.sirsr.tipoProducto.domain.TipoProductoDTO;
import com.modules.sirsr.tipoProducto.domain.TipoProductoService;
import com.modules.sirsr.unidadMedida.domain.UnidadMedidaDTO;
import com.modules.sirsr.unidadMedida.domain.UnidadMedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 *
 * @author Edward Reyes
 */
@Controller
@RequestMapping("/usuario")
public class ProductoUsuarioController {

    private final ProductoService productoService;
    private final TipoProductoService tipoProductoService;
    private final UnidadMedidaService unidadMedidaService;
    private List<TipoProductoDTO> tiposProductoDTOs;
    private List<UnidadMedidaDTO> unidadesMedidaDTOs;
    private final Mensaje msg = new Mensaje();

    @Autowired
    public ProductoUsuarioController(ProductoService productoService, TipoProductoService tipoProductoService, UnidadMedidaService unidadMedidaService) {
        this.productoService = productoService;
        this.tipoProductoService = tipoProductoService;
        this.unidadMedidaService = unidadMedidaService;
    }


    @GetMapping("/solicitudes/requisiciones/detalles/sugerir/{id}")
    public String sugerir(Model model, @PathVariable("id") int id) {
        tiposProductoDTOs = tipoProductoService.findAll();
        unidadesMedidaDTOs = unidadMedidaService.findAll();
        model.addAttribute("producto", new ProductoDTO());
        model.addAttribute("tiposProducto", tiposProductoDTOs);
        model.addAttribute("unidadesMedida", unidadesMedidaDTOs);
        model.addAttribute("idRequisicion", id);
        return "usuario/solicitudes/requisiciones/detalles/agregarProducto";
    }

    @PostMapping("/solicitudes/requisiciones/detalles/addSugerencia/{id}")
    public String sugerir(ProductoDTO productoDTO, @PathVariable("id") int id, RedirectAttributes redirectAttrs) {
        msg.crearMensaje(productoService.saveToUsuario(productoDTO), redirectAttrs);
        return "redirect:/usuario/solicitudes/requisiciones/detalles/"+id;
    }

}
