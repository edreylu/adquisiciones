/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.requisicion.domain;

import com.modules.sirsr.producto.domain.ProductoDTO;
import com.modules.sirsr.producto.domain.ProductoService;
import com.modules.sirsr.requisicion.persistence.DetalleRequisicionRepository;
import com.modules.sirsr.requisicion.persistence.DetalleRequisicion;
import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.requisicion.persistence.DetalleRequisicionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 *
 * @author Edward Reyes
 */
@Service
public class DetalleRequisicionService {

	private final DetalleRequisicionRepository detalleRequisicionRepository;
	private final RequisicionService requisicionService;
	private final ProductoService productoService;
	private DetalleRequisicionDTO detalleRequisicionDTO;
	private RequisicionDTO requisicionDTO;
	private ProductoDTO productoDTO;
	private Mensaje msg;

	@Autowired
	public DetalleRequisicionService(DetalleRequisicionRepository detalleRequisicionRepository,
			RequisicionService requisicionService, ProductoService productoService) {
		this.detalleRequisicionRepository = detalleRequisicionRepository;
		this.requisicionService = requisicionService;
		this.productoService = productoService;
	}

	public List<DetalleRequisicionDTO> findAll() {
		return DetalleRequisicionMapper.toDetalleRequisicionDTOs(detalleRequisicionRepository.findAll());
	}

	public List<DetalleRequisicionDTO> findByIdRequisicion(int id) {
		List<DetalleRequisicion> detalleRequisicion = detalleRequisicionRepository.findByIdRequisicion(id);
		List<DetalleRequisicionDTO> detalleRequisicionDTOS = DetalleRequisicionMapper
				.toDetalleRequisicionDTOs(detalleRequisicion);
		return detalleRequisicionDTOS;
	}

	public DetalleRequisicionDTO findById(int id) {
		Optional<DetalleRequisicion> detalleRequisicionOptional = detalleRequisicionRepository.findById(id);
		detalleRequisicionDTO = DetalleRequisicionMapper.toDetalleRequisicionDTO(detalleRequisicionOptional.get());
		return detalleRequisicionDTO;
	}

	public Mensaje save(DetalleRequisicionDTO detalleRequisicionDTO, int id) {
		try {
			List<DetalleRequisicionDTO> detallesRequisicionDTOs = this.findByIdRequisicion(id);
			requisicionDTO = requisicionService.findById(id);
			detallesRequisicionDTOs.add(detalleRequisicionDTO);
			Double montoTotal = getMontoTotal.apply(detallesRequisicionDTOs);
			if (montoTotal <= requisicionDTO.getMontoSuficiencia()) {
				System.out.println("monto total: " + montoTotal);
				System.out.println("monto getMontoSuficiencia: " + requisicionDTO.getMontoSuficiencia());
				productoDTO = productoService.findById(detalleRequisicionDTO.getProducto().getIdProducto());
				detalleRequisicionDTO.setRequisicion(requisicionDTO);
				detalleRequisicionDTO.setProducto(productoDTO);
				detalleRequisicionRepository.save(DetalleRequisicionMapper.toDetalleRequisicion(detalleRequisicionDTO));
				msg = Mensaje.CREATE("Agregado correctamente", 1);
			} else {
				Double totalTransaccion = detalleRequisicionDTO.getProducto().getPrecioDeReferencia()
						* detalleRequisicionDTO.getCantidadSolicitada();
				msg = Mensaje.CREATE("Monto excede la suficiencia con la que cuentas, Intentaste agregar: $"
						+ totalTransaccion + " y tu Monto Restante es: $"
						+ (requisicionDTO.getMontoSuficiencia() - (montoTotal - totalTransaccion)), 3);
			}
		} catch (Exception e) {
			msg = Mensaje.CREATE("No se pudo agregar por: " + e.getMessage(), 2);
		}
		return msg;
	}

	public Mensaje update(DetalleRequisicionDTO detalleRequisicionDTO, int id, int idRequisicion) {
		try {
			detalleRequisicionDTO.setIdDetalleRequisicion(id);
			List<DetalleRequisicionDTO> detallesRequisicionDTOs = this.findByIdRequisicion(idRequisicion);
			requisicionDTO = requisicionService.findById(idRequisicion);
			List<DetalleRequisicionDTO> detallesList = new ArrayList<>();
			detallesRequisicionDTOs.forEach(detalle -> {
				if (detalle.getIdDetalleRequisicion() == detalleRequisicionDTO.getIdDetalleRequisicion()) {
					detallesList.add(detalleRequisicionDTO);
				} else {
					detallesList.add(detalle);
				}
			});
			Double montoTotal = getMontoTotal.apply(detallesList);
			if (montoTotal <= requisicionDTO.getMontoSuficiencia()) {
				System.out.println("monto total: " + montoTotal);
				System.out.println("monto getMontoSuficiencia: " + requisicionDTO.getMontoSuficiencia());
				productoDTO = productoService.findById(detalleRequisicionDTO.getProducto().getIdProducto());
				detalleRequisicionDTO.setRequisicion(requisicionDTO);
				detalleRequisicionDTO.setProducto(productoDTO);
				detalleRequisicionRepository.save(DetalleRequisicionMapper.toDetalleRequisicion(detalleRequisicionDTO));
				msg = Mensaje.CREATE("Actualizado correctamente", 1);
			} else {
				msg = Mensaje.CREATE("Monto excede la suficiencia con la que cuentas, El total asciende a: $"
						+ montoTotal + " y tu suficiencia total es: $" + requisicionDTO.getMontoSuficiencia(), 3);
			}
		} catch (Exception e) {
			msg = Mensaje.CREATE("No se pudo Actualizar por: " + e.getMessage(), 2);
		}
		return msg;
	}

	public Mensaje deleteById(int id) {
		try {
			detalleRequisicionRepository.deleteById(id);
			msg = Mensaje.CREATE("Eliminado correctamente", 1);
		} catch (Exception e) {
			msg = Mensaje.CREATE("No se pudo Eliminar por que hay usuarios asociados a rol.", 2);
		}
		return msg;

	}

	public Function<List<DetalleRequisicionDTO>, Double> getMontoTotal = detallesRequisicion -> {
		return detallesRequisicion.stream()
				.mapToDouble(value -> value.getProducto().getPrecioDeReferencia() * value.getCantidadSolicitada())
				.sum();
	};

}
