/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.proveedor.infrastructure;

import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.proveedor.application.ProveedorDTO;
import com.modules.sirsr.proveedor.application.ProveedorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Edward Reyes
 */
@Controller
public class ProveedorController {

    private final ProveedorService proveedorService;
    private List<ProveedorDTO> proveedores;
    private final Mensaje msg = new Mensaje();

    @Autowired
    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }


    @GetMapping("admonadq/proveedores")
    public String listar(Model model) {
        proveedores = proveedorService.findAll();
        model.addAttribute("lista", proveedores);
        return "admonadq/proveedores/principal";
    }

    @GetMapping("admonadq/proveedores/agregar")
    public String agregar(Model model) {
        model.addAttribute("proveedor", new ProveedorDTO());
        return "admonadq/proveedores/agregar";
    }

    @PostMapping("admonadq/proveedores/add")
    public String agregar(ProveedorDTO proveedorDTO, RedirectAttributes redirectAttrs) {
    	msg.crearMensaje(proveedorService.save(proveedorDTO), redirectAttrs);
        return "redirect:/admonadq/proveedores";
    }

    @GetMapping("admonadq/proveedores/editar/{id}")
    public String editar(@PathVariable("id") int id, Model model) {
        ProveedorDTO proveedorDTO = proveedorService.findById(id);
        String validUrl = "redirect:/admonadq/proveedores";
        if(Objects.nonNull(proveedorDTO)){
            model.addAttribute("proveedor", proveedorDTO);
            validUrl = "admonadq/proveedores/editar";
        }
        return validUrl;
    }

    @PostMapping("admonadq/proveedores/update/{id}")
    public String editar(@PathVariable("id") int id, ProveedorDTO proveedorDTO, RedirectAttributes redirectAttrs) {
        msg.crearMensaje(proveedorService.update(proveedorDTO, id), redirectAttrs);
        return "redirect:/admonadq/proveedores";
    }

    @GetMapping("admonadq/proveedores/eliminar/{id}/{idEstatus}")
    public String eliminar(@PathVariable("id") int id, @PathVariable("idEstatus") int idEstatus,
                           RedirectAttributes redirectAttrs) {
        msg.crearMensaje(proveedorService.borraPorId(id, idEstatus), redirectAttrs);
        return "redirect:/admonadq/proveedores";
    }
    
}