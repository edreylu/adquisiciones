/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.role;

import com.modules.sirsr.utils.Mensaje;
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
public class RoleController {

    private final RoleService roleService;
    private List<RoleDTO> roles;
    private final Mensaje msg = new Mensaje();

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("admin/roles")
    public String listar(Model model) {
        roles = roleService.findAll();
        model.addAttribute("lista", roles);
        return "admin/roles/principal";
    }

    @GetMapping("admin/roles/agregar")
    public String agregar(Model model) {
        model.addAttribute("role", new RoleDTO());
        return "admin/roles/agregar";
    }

    @PostMapping("admin/roles/add")
    public String agregar(RoleDTO roleDTO, RedirectAttributes redirectAttrs) {
        msg.crearMensaje(roleService.save(roleDTO), redirectAttrs);
        return "redirect:/admin/roles";
    }

    @GetMapping("admin/roles/editar/{id}")
    public String editar(@PathVariable("id") int id, Model model) {
        RoleDTO roleDTO = roleService.findById(id);
        String validUrl = "redirect:/admin/roles";
        if(Objects.nonNull(roleDTO)){
            model.addAttribute("role", roleDTO);
            validUrl = "admin/roles/editar";
        }
        return validUrl;
    }

    @PostMapping("admin/roles/update/{id}")
    public String editar(@PathVariable("id") int id, RoleDTO roleDTO, RedirectAttributes redirectAttrs) {
        msg.crearMensaje(roleService.update(roleDTO, id), redirectAttrs);
        return "redirect:/admin/roles";
    }

    @GetMapping("admin/roles/eliminar/{id}")
    public String eliminar(@PathVariable("id") int id,
                           RedirectAttributes redirectAttrs) {
        msg.crearMensaje(roleService.deleteById(id), redirectAttrs);
        return "redirect:/admin/roles";
    }
    
}
