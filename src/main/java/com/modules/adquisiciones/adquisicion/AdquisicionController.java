/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.adquisiciones.adquisicion;

import com.modules.adquisiciones.requisicion.Requisicion;
import com.modules.adquisiciones.utils.Mensaje;
import java.util.ArrayList;
import java.util.List;
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
public class AdquisicionController {
    
    private List<Requisicion> requisiciones;
    private final Mensaje msg = new Mensaje();

    public AdquisicionController() {
    }

    @GetMapping("admin/adquisiciones")
    public String listar(Model model) {
        System.out.println("estoy en el listar");
        requisiciones = new ArrayList<>();
        Requisicion requisicion = new Requisicion();
        requisicion.setFolio(1);
        requisicion.setAreaSolicitante(3);
        requisicion.setClavePresupuestal("666666");
        requisicion.setCantidad(12);
        requisicion.setDescripcionProducto("Lapices");
        requisicion.setObjetoGasto(001);
        requisicion.setUnidad(4);
        requisiciones.add(requisicion);
        model.addAttribute("lista", requisiciones);
        return "admin/adquisiciones/principal";
    }

    @GetMapping("admin/adquisiciones/agregar")
    public String agregar(Model model) {
        return "admin/adquisiciones/agregar";
    }

    @PostMapping("admin/adquisiciones/add")
    public String agregar(RedirectAttributes redirectAttrs) {
        return "redirect:/admin/adquisiciones";
    }

    @GetMapping("admin/adquisiciones/editar/{id}")
    public String editar(@PathVariable("id") int id, Model model) {
        String validUrl = "redirect:/admin/adquisiciones";
        return validUrl;
    }

    @PostMapping("admin/adquisiciones/update/{id}")
    public String editar(@PathVariable("id") int id, RedirectAttributes redirectAttrs) {
        return "redirect:/admin/adquisiciones";
    }

    @GetMapping("admin/adquisiciones/eliminar/{id}")
    public String eliminar(@PathVariable("id") int id,
                           RedirectAttributes redirectAttrs) {
        return "redirect:/admin/adquisiciones";
    }   
    
}
