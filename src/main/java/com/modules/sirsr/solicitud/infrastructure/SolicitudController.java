/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.solicitud.infrastructure;

import com.modules.sirsr.objetoGasto.application.ObjetoDeGastoDTO;
import com.modules.sirsr.objetoGasto.application.ObjetoDeGastoService;
import com.modules.sirsr.config.Mensaje;
import java.util.List;
import java.util.Objects;

import com.modules.sirsr.solicitud.application.SolicitudDTO;
import com.modules.sirsr.solicitud.application.SolicitudService;
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
public class SolicitudController {

    private final SolicitudService solicitudService;
    private final ObjetoDeGastoService objetoDeGastoService;
    private List<SolicitudDTO> solicitudes;
    private List<ObjetoDeGastoDTO> partidasEspecificas;
    private final Mensaje msg = new Mensaje();

    @Autowired
    public SolicitudController(SolicitudService solicitudService, ObjetoDeGastoService objetoDeGastoService) {
        this.solicitudService = solicitudService;
        this.objetoDeGastoService = objetoDeGastoService;
    }

    @GetMapping("usuario/solicitudes")
    public String listar(Model model) {
        solicitudes= solicitudService.findByClaveUnidad();
        model.addAttribute("lista", solicitudes);
        return "usuario/solicitudes/principal";
    }

    @GetMapping("usuario/solicitudes/agregar")
    public String agregar(Model model) {
        partidasEspecificas = objetoDeGastoService.findAll();
        model.addAttribute("partidasEspecificas", partidasEspecificas);
        model.addAttribute("solicitud", new SolicitudDTO());
        return "usuario/solicitudes/agregar";
    }

    @PostMapping("usuario/solicitudes/add")
    public String agregar(SolicitudDTO solicitudDTO, RedirectAttributes redirectAttrs){
        msg.crearMensaje(solicitudService.save(solicitudDTO), redirectAttrs);
        return "redirect:/usuario/solicitudes";
    }

    @GetMapping("usuario/solicitudes/editar/{id}")
    public String editar(@PathVariable("id") int id, Model model) {
        SolicitudDTO solicitudDTO = solicitudService.findById(id);
        System.out.println(solicitudDTO.toString());
        String validUrl = "redirect:/usuario/solicitudes";
        if(Objects.nonNull(solicitudDTO)){
            model.addAttribute("solicitud", solicitudDTO);
            validUrl = "usuario/solicitudes/editar";
        }
        return validUrl;
    }

    @PostMapping("usuario/solicitudes/update/{id}")
    public String editar(@PathVariable("id") int id, RedirectAttributes redirectAttrs) {
        return "redirect:/usuario/solicitudes";
    }

    @GetMapping("admin/solicitudes/eliminar/{id}")
    public String eliminar(@PathVariable("id") int id,
                           RedirectAttributes redirectAttrs) {
        return "redirect:/usuario/solicitudes";
    }

}
