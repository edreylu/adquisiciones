/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.adquisiciones.requisicion;

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
public class RequisicionController {

    private List<Requisicion> requisiciones;
    private final Mensaje msg = new Mensaje();

    public RequisicionController() {
    }

    @GetMapping("usuario/requisiciones")
    public String listar(Model model) {
        requisiciones = new ArrayList<>();
        model.addAttribute("lista", requisiciones);
        return "usuario/requisiciones/principal";
    }

    @GetMapping("usuario/requisiciones/agregar")
    public String agregar(Model model) {
        model.addAttribute("requisicion", new Requisicion());
        return "usuario/requisiciones/agregar";
    }

    @PostMapping("usuario/requisiciones/add")
    public String agregar(RedirectAttributes redirectAttrs) {
        return "redirect:/usuario/requisiciones";
    }

    @GetMapping("usuario/requisiciones/editar/{id}")
    public String editar(@PathVariable("id") int id, Model model) {
        String validUrl = "redirect:/usuario/requisiciones";
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
}
