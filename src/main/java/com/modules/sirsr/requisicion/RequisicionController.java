/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.requisicion;

import com.modules.sirsr.PartidaGasto.PartidaGastoEspecificaDTO;
import com.modules.sirsr.PartidaGasto.PartidaGastoEspecificaService;
import com.modules.sirsr.persistence.repository.PartidaGastoEspecificaRepository;
import com.modules.sirsr.persistence.repository.UnidadMedidaRepository;
import com.modules.sirsr.unidadMedida.UnidadMedidaDTO;
import com.modules.sirsr.unidadMedida.UnidadMedidaService;
import com.modules.sirsr.utils.Mensaje;
import java.util.List;
import java.util.Objects;
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
public class RequisicionController {

    private final RequisicionService requisicionService;
    private final UnidadMedidaService unidadService;
    private final PartidaGastoEspecificaService partidaGastoEspecificaService;
    private List<RequisicionDTO> requisiciones;
    private List<PartidaGastoEspecificaDTO> partidasEspecificas;
    private List<UnidadMedidaDTO> unidadMedidas;
    private final Mensaje msg = new Mensaje();

    @Autowired
    public RequisicionController(RequisicionService requisicionService,UnidadMedidaService unidadService, PartidaGastoEspecificaService partidaGastoEspecificaService) {
        this.requisicionService = requisicionService;
        this.unidadService = unidadService;
        this.partidaGastoEspecificaService = partidaGastoEspecificaService;
    }

    @GetMapping("usuario/requisiciones")
    public String listar(Model model) {
        requisiciones = requisicionService.findByClaveUnidad();
        model.addAttribute("lista", requisiciones);
        return "usuario/requisiciones/principal";
    }

    @GetMapping("usuario/requisiciones/agregar")
    public String agregar(Model model) {
        partidasEspecificas = partidaGastoEspecificaService.findAll();
        unidadMedidas = unidadService.findAll();
        model.addAttribute("partidasEspecificas", partidasEspecificas);
        model.addAttribute("unidadMedidas", unidadMedidas);
        model.addAttribute("requisicion", new RequisicionDTO());
        return "usuario/requisiciones/agregar";
    }

    @PostMapping("usuario/requisiciones/add")
    public String agregar(RequisicionDTO requisicionDTO, RedirectAttributes redirectAttrs){
        msg.crearMensaje(requisicionService.save(requisicionDTO), redirectAttrs);
        return "redirect:/usuario/requisiciones";
    }

    @GetMapping("usuario/requisiciones/editar/{id}")
    public String editar(@PathVariable("id") int id, Model model) {
        RequisicionDTO requisicionDTO = requisicionService.findById(id);
        String validUrl = "redirect:/usuario/requisiciones";
        if(Objects.nonNull(requisicionDTO)){
            model.addAttribute("requisicion", requisicionDTO);
            validUrl = "usuario/requisiciones/editar";
        }
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
