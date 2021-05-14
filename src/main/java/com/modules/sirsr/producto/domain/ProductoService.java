/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.producto.domain;

import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.estatus.domain.EstatusDTO;
import com.modules.sirsr.estatus.domain.EstatusService;
import com.modules.sirsr.producto.persistence.Producto;
import com.modules.sirsr.producto.persistence.ProductoMapper;
import com.modules.sirsr.producto.persistence.ProductoRepository;
import com.modules.sirsr.tipoProducto.domain.TipoProductoDTO;
import com.modules.sirsr.tipoProducto.domain.TipoProductoService;
import com.modules.sirsr.unidadMedida.domain.UnidadMedidaDTO;
import com.modules.sirsr.unidadMedida.domain.UnidadMedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.eclipse.persistence.jpa.rs.exceptions.JPARSException;

/**
 *
 * @author Edward Reyes
 */
@Service
public class ProductoService {

	private final ProductoRepository productoRepository;
	private final TipoProductoService tipoProductoService;
	private final UnidadMedidaService unidadMedidaService;
	private final EstatusService estatusService;
	private TipoProductoDTO tipoProductoDTO;
	private UnidadMedidaDTO unidadMedidaDTO;
	private EstatusDTO estatusDTO;
	private Mensaje msg;

	@Autowired
	public ProductoService(ProductoRepository productoRepository, TipoProductoService tipoProductoService,
			UnidadMedidaService unidadMedidaService, EstatusService estatusService) {
		this.productoRepository = productoRepository;
		this.tipoProductoService = tipoProductoService;
		this.unidadMedidaService = unidadMedidaService;
		this.estatusService = estatusService;
	}

	public List<ProductoDTO> findAll() {
		return ProductoMapper.toProductoDTOs(productoRepository.findAllByIdEstatus(1));
	}

	public List<ProductoDTO> findAllSuggestions() {
		return ProductoMapper.toProductoDTOs(productoRepository.findAllByIdEstatus(2));
	}

	public boolean areThereProductsSuggestions() {
		boolean result = productoRepository.findAllByIdEstatus(2).size() > 0;
		return result;
	}

	public List<ProductoDTO> findByIdTipoProducto(String objetoGasto) {
		List<TipoProductoDTO> tiposProductoDTOs = tipoProductoService.findByObjetoGastoStr(objetoGasto);
		List<Integer> tiposProductoFound = tiposProductoDTOs.stream()
				.map(tipoProducto -> tipoProducto.getIdTipoProducto()).collect(Collectors.toList());
		return ProductoMapper.toProductoDTOs(productoRepository.findByIdTipoProductoIn(tiposProductoFound));
	}

	public ProductoDTO findById(int id) {
		Optional<Producto> productoOptional = productoRepository.findById(id);
		ProductoDTO productoDTO = ProductoMapper.toProductoDTO(productoOptional.get());
		return productoDTO;
	}

	public Mensaje save(ProductoDTO productoDTO) {
		try {
			unidadMedidaDTO = unidadMedidaService.findById(productoDTO.getUnidadMedida().getIdUnidadMedida());
			tipoProductoDTO = tipoProductoService.findById(productoDTO.getTipoProducto().getIdTipoProducto());
			estatusDTO = estatusService.findById(1);
			productoDTO.setUnidadMedida(unidadMedidaDTO);
			productoDTO.setTipoProducto(tipoProductoDTO);
			productoDTO.setEstatus(estatusDTO);
			System.out.println(productoDTO.getUnidadMedida().getIdUnidadMedida());
			System.out.println(productoDTO.getTipoProducto().getIdTipoProducto());
			productoRepository.save(ProductoMapper.toProducto(productoDTO));
			msg = Mensaje.success("Agregado correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo agregar por: " + e.getMessage());
		}
		return msg;
	}

	public Mensaje saveToUsuario(ProductoDTO productoDTO) {
		try {
			unidadMedidaDTO = unidadMedidaService.findById(productoDTO.getUnidadMedida().getIdUnidadMedida());
			tipoProductoDTO = tipoProductoService.findById(productoDTO.getTipoProducto().getIdTipoProducto());
			estatusDTO = estatusService.findById(2);
			productoDTO.setUnidadMedida(unidadMedidaDTO);
			productoDTO.setTipoProducto(tipoProductoDTO);
			productoDTO.setEstatus(estatusDTO);
			System.out.println(productoDTO.getUnidadMedida().getIdUnidadMedida());
			System.out.println(productoDTO.getTipoProducto().getIdTipoProducto());
			productoRepository.save(ProductoMapper.toProducto(productoDTO));
			msg = Mensaje.success("Agregado correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo agregar por: " + e.getMessage());
		}
		return msg;
	}

	public Mensaje update(ProductoDTO productoDTO) {
		try {
			unidadMedidaDTO = unidadMedidaService.findById(productoDTO.getUnidadMedida().getIdUnidadMedida());
			tipoProductoDTO = tipoProductoService.findById(productoDTO.getTipoProducto().getIdTipoProducto());
			estatusDTO = estatusService.findById(1);
			productoDTO.setUnidadMedida(unidadMedidaDTO);
			productoDTO.setTipoProducto(tipoProductoDTO);
			productoDTO.setEstatus(estatusDTO);
			productoRepository.save(ProductoMapper.toProducto(productoDTO));
			msg = Mensaje.success("Actualizado correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo Actualizar por: " + e.getMessage());
		}
		return msg;
	}

	public Mensaje updateToSuggestions(ProductoDTO productoDTO) {
		try {

			unidadMedidaDTO = unidadMedidaService.findById(productoDTO.getUnidadMedida().getIdUnidadMedida());
			tipoProductoDTO = tipoProductoService.findById(productoDTO.getTipoProducto().getIdTipoProducto());
			estatusDTO = estatusService.findById(2);
			productoDTO.setUnidadMedida(unidadMedidaDTO);
			productoDTO.setTipoProducto(tipoProductoDTO);
			productoDTO.setEstatus(estatusDTO);
			productoRepository.save(ProductoMapper.toProducto(productoDTO));
			msg = Mensaje.success("Actualizado correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo Actualizar por: " + e.getMessage());
		}
		return msg;
	}

	public Mensaje deleteById(int id) {
		try {
			productoRepository.deleteById(id);
			msg = Mensaje.success("Eliminado correctamente");
		} catch (Exception e) {
			msg = Mensaje.danger("No se pudo Eliminar.");
		}
		return msg;

	}

	public Mensaje actionToSuggestion(int id, int idEstatus) {
		try {
			ProductoDTO productoDTO = this.findById(id);
			estatusDTO = estatusService.findById(idEstatus);
			productoDTO.setEstatus(estatusDTO);
			productoRepository.save(ProductoMapper.toProducto(productoDTO));
			if (idEstatus == 1) {
				msg = Mensaje.success("Registro se acepto correctamente");
			} else {
				msg = Mensaje.warning("Registro se rechazo correctamente");
			}

		} catch (JPARSException e) {
			msg = Mensaje.danger("No se pudo completar.");
		}
		return msg;

	}

}
