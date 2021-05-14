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
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Edward Reyes
 */
@Controller
@RequestMapping("/admonadq")
public class ProductoController {

	private final ProductoService productoService;
	private final TipoProductoService tipoProductoService;
	private final UnidadMedidaService unidadMedidaService;
	private List<ProductoDTO> productos;
	private List<TipoProductoDTO> tiposProductoDTOs;
	private List<UnidadMedidaDTO> unidadesMedidaDTOs;
	private ProductoDTO productoDTO;
	private final Mensaje msg = new Mensaje();

	@Autowired
	public ProductoController(ProductoService productoService, TipoProductoService tipoProductoService,
			UnidadMedidaService unidadMedidaService) {
		this.productoService = productoService;
		this.tipoProductoService = tipoProductoService;
		this.unidadMedidaService = unidadMedidaService;
	}

	@GetMapping("/productos")
	public String listar(Model model) {
		productos = productoService.findAll();
		model.addAttribute("lista", productos);
		return "admonadq/productos/principal";
	}

	@GetMapping("/productos/agregar")
	public String agregar(Model model) {
		tiposProductoDTOs = tipoProductoService.findAll();
		unidadesMedidaDTOs = unidadMedidaService.findAll();
		model.addAttribute("producto", new ProductoDTO());
		model.addAttribute("tiposProducto", tiposProductoDTOs);
		model.addAttribute("unidadesMedida", unidadesMedidaDTOs);
		return "admonadq/productos/agregar";
	}

	@PostMapping("/productos/add")
	public String agregar(ProductoDTO productoDTO, RedirectAttributes redirectAttrs) {
		Mensaje.addMensaje(productoService.save(productoDTO), redirectAttrs);
		return "redirect:/admonadq/productos";
	}

	@GetMapping("/productos/editar/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		productoDTO = productoService.findById(id);
		tiposProductoDTOs = tipoProductoService.findAll();
		unidadesMedidaDTOs = unidadMedidaService.findAll();
		String validUrl = "redirect:/admonadq/productos";
		if (Objects.nonNull(productoDTO)) {
			model.addAttribute("producto", productoDTO);
			model.addAttribute("tiposProducto", tiposProductoDTOs);
			model.addAttribute("unidadesMedida", unidadesMedidaDTOs);
			validUrl = "admonadq/productos/editar";
		}
		return validUrl;
	}

	@PostMapping("/productos/update")
	public String editar(ProductoDTO productoDTO, RedirectAttributes redirectAttrs) {
		Mensaje.addMensaje(productoService.update(productoDTO), redirectAttrs);
		return "redirect:/admonadq/productos";
	}

	@GetMapping("/productos/eliminar/{id}")
	public String eliminar(@PathVariable("id") int id, RedirectAttributes redirectAttrs) {
		// msg.crearMensaje(productoService.deleteById(id), redirectAttrs);
		return "redirect:/admonadq/productos";
	}

	@GetMapping("/productos/areThereProductsSuggestions")
	@ResponseBody
	public String areThereProductsSuggest() {
		String valor = productoService.areThereProductsSuggestions() ? "S" : "N";
		return valor;
	}

}
