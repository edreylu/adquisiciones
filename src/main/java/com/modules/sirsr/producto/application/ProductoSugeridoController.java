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
import java.util.Objects;

/**
 *
 * @author Edward Reyes
 */
@Controller
@RequestMapping("/admonadq")
public class ProductoSugeridoController {

	private final ProductoService productoService;
	private final TipoProductoService tipoProductoService;
	private final UnidadMedidaService unidadMedidaService;
	private List<ProductoDTO> productos;
	private List<TipoProductoDTO> tiposProductoDTOs;
	private List<UnidadMedidaDTO> unidadesMedidaDTOs;
	private ProductoDTO productoDTO;

	@Autowired
	public ProductoSugeridoController(ProductoService productoService, TipoProductoService tipoProductoService,
			UnidadMedidaService unidadMedidaService) {
		this.productoService = productoService;
		this.tipoProductoService = tipoProductoService;
		this.unidadMedidaService = unidadMedidaService;
	}

	@GetMapping("/productosSugeridos")
	public String listar(Model model) {
		productos = productoService.findAllSuggestions();
		model.addAttribute("lista", productos);
		return "admonadq/productosSugeridos/principal";
	}

	@GetMapping("/productosSugeridos/editar/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		productoDTO = productoService.findById(id);
		tiposProductoDTOs = tipoProductoService.findAll();
		unidadesMedidaDTOs = unidadMedidaService.findAll();
		String validUrl = "redirect:/admonadq/productosSugeridos";
		if (Objects.nonNull(productoDTO)) {
			model.addAttribute("producto", productoDTO);
			model.addAttribute("tiposProducto", tiposProductoDTOs);
			model.addAttribute("unidadesMedida", unidadesMedidaDTOs);
			validUrl = "admonadq/productosSugeridos/editar";
		}
		return validUrl;
	}

	@PostMapping("/productosSugeridos/update")
	public String editar(ProductoDTO productoDTO, RedirectAttributes redirectAttrs) {
		Mensaje.addMensaje(productoService.updateToSuggestions(productoDTO), redirectAttrs);
		return "redirect:/admonadq/productosSugeridos";
	}

	@GetMapping("/productosSugeridos/actionToSuggestion/{id}/{idEstatus}")
	public String actionToSuggestion(@PathVariable("id") int id, @PathVariable("idEstatus") int idEstatus,
			RedirectAttributes redirectAttrs) {
		Mensaje.addMensaje(productoService.actionToSuggestion(id, idEstatus), redirectAttrs);
		return "redirect:/admonadq/productosSugeridos";
	}

}
