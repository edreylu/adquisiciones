/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.adquisiciones.usuario;

import com.modules.adquisiciones.personal.PersonalDTO;
import com.modules.adquisiciones.personal.PersonalService;
import com.modules.adquisiciones.unidadResponsable.UnidadResponsableDTO;
import com.modules.adquisiciones.unidadResponsable.UnidadResponsableService;
import com.modules.adquisiciones.usuarioRole.UsuarioRoleDTO;
import com.modules.adquisiciones.usuarioRole.UsuarioRoleService;
import com.modules.adquisiciones.utils.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Objects;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Edward Reyes
 */
@Controller
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioRoleService usuarioRoleService;
    private final UnidadResponsableService unidadResponsableService;
    private final PersonalService personalService;
    private List<UsuarioDTO> usuarios;
    private List<PersonalDTO> personal;
    private UsuarioRoleDTO usuarioRole;
    private final Mensaje msg = new Mensaje();

    @Autowired
    public UsuarioController(UsuarioService usuarioService, UsuarioRoleService usuarioRoleService, UnidadResponsableService unidadResponsableService, PersonalService personalService) {
        this.usuarioService = usuarioService;
        this.usuarioRoleService = usuarioRoleService;
        this.unidadResponsableService = unidadResponsableService;
        this.personalService = personalService;
    }

    @GetMapping("admin/usuarios")
    public String listar(Model model) {
        usuarios = usuarioService.findAll();
        model.addAttribute("lista", usuarios);
        return "admin/usuarios/principal";
    }

    @GetMapping("admin/usuarios/agregar")
    public String agregar(Model model) {
        List<UnidadResponsableDTO> unidadResponsableDTOs = unidadResponsableService.findAll();
        model.addAttribute("unidadesResponsables", unidadResponsableDTOs);
        model.addAttribute("usuario", new UsuarioDTO());
        return "admin/usuarios/agregar";
    }

    @PostMapping("admin/usuarios/add")
    public String agregar(UsuarioDTO us, RedirectAttributes redirectAttrs) {
        msg.crearMensaje(usuarioService.save(us), redirectAttrs);
        return "redirect:/admin/usuarios";
    }

    @GetMapping("admin/usuarios/editar/{id}")
    public String editar(@PathVariable("id") int id, Model model) {
        UsuarioDTO usuario = usuarioService.findById(id);
        List<UnidadResponsableDTO> unidadResponsableDTOs = unidadResponsableService.findAll();
        model.addAttribute("unidadesResponsables", unidadResponsableDTOs);
        String validUrl = "redirect:/admin/usuarios";
        if (Objects.nonNull(usuario)) {
            model.addAttribute("usuario", usuario);
            validUrl = "admin/usuarios/editar";
        }
        return validUrl;
    }

    @PostMapping("admin/usuarios/update/{id}")
    public String editar(@PathVariable("id") int id, UsuarioDTO us, RedirectAttributes redirectAttrs) {
        msg.crearMensaje(usuarioService.update(us, id), redirectAttrs);
        return "redirect:/admin/usuarios";
    }

    @GetMapping("admin/usuarios/eliminar/{id}/{idestatus}")
    public String eliminar(@PathVariable("id") int id, @PathVariable("idestatus") int idestatus,
            RedirectAttributes redirectAttrs) {
        msg.crearMensaje(usuarioService.deleteById(id, idestatus), redirectAttrs);
        return "redirect:/admin/usuarios";
    }

    @GetMapping("admin/usuarios/asignarRoles/{id}")
    public String asignarRoles(@PathVariable("id") int id, Model model) {
        usuarioRole = usuarioRoleService.findByNoUsuario(id);
        model.addAttribute("noUsuario", id);
        model.addAttribute("usuarioRole", usuarioRole);
        return "admin/usuarios/asignarRoles";
    }

    @PostMapping("admin/usuarios/asignarRoles/{id}")
    public String asignarRoles(@PathVariable("id") int id, @ModelAttribute("userRoles") UsuarioRoleDTO userRole,
            RedirectAttributes redirectAttrs) {
        msg.crearMensaje(usuarioRoleService.assignRoleToUser(userRole, id), redirectAttrs);
        return "redirect:/admin/usuarios";
    }

    @GetMapping("admin/usuarios/asignarPersonal/{id}")
    public String asignarPersonal(@PathVariable("id") int id, Model model) {
        UsuarioDTO usuario = usuarioService.findById(id);
        model.addAttribute("username", usuario.getUserName());
        model.addAttribute("noUsuario", usuario.getNoUsuario());
        model.addAttribute("personalAsignado", usuario.getPersonal().getNoPersonal());
        model.addAttribute("claveArea", "");
        return "admin/usuarios/asignarPersonal";
    }

    @PostMapping("admin/usuarios/asignarPersonal")
    public String asignarPersonal(@RequestParam(name = "noPersonal") int noPersonal, @RequestParam(name = "noUsuario") int noUsuario, RedirectAttributes redirectAttrs) {
        msg.crearMensaje(usuarioService.updateNoPersonal(noPersonal, noUsuario), redirectAttrs);
        return "redirect:/admin/usuarios";
    }

    @GetMapping("admin/usuarios/searchPersonal/{noPersonal}/{noUsuario}")
    public String searchPersonal(@PathVariable("noPersonal") int noPersonal, @PathVariable("noUsuario") int noUsuario, Model model) {
        personal = personalService.findByNoPersonal(noPersonal);
        model.addAttribute("noPersonal", noPersonal);
        model.addAttribute("noUsuario", noUsuario);
        model.addAttribute("personal", personal);
        return "admin/usuarios/asignarPersonal :: #datosPersonal";
    }

    @GetMapping("admin/usuarios/listUsuarioPersonal/{personalAsignado}")
    public String listUsuarioPersonal(@PathVariable("personalAsignado") int personalAsignado, Model model) {
        personal = personalService.findByNoPersonal(personalAsignado);
        model.addAttribute("personalAsignado", personalAsignado);
        model.addAttribute("personal", personal);
        return "admin/usuarios/asignarPersonal :: modalUsuarioPersonal";
    }

    @GetMapping("usuario/editarPerfil/{userName}")
    public String editarPerfil(@PathVariable("userName") String userName, Model model) {
        UsuarioDTO usuario = usuarioService.findByUserName(userName);
        model.addAttribute("usuario", usuario);
        return "layout :: modalPerfil";
    }

    @PostMapping("usuario/updatePerfil/{userName}")
    public String editarPerfil(@PathVariable("userName") String userName, UsuarioDTO us, RedirectAttributes redirectAttrs) {
        msg.crearMensaje(usuarioService.updatePerfil(us, userName), redirectAttrs);
        return "redirect:/menu";
    }
}
