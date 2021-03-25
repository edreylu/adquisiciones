/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.producto.application;

import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.estatus.application.EstatusDTO;
import com.modules.sirsr.estatus.application.EstatusService;
import com.modules.sirsr.producto.domain.Producto;
import com.modules.sirsr.producto.domain.ProductoRepository;
import com.modules.sirsr.tipoProducto.application.TipoProductoDTO;
import com.modules.sirsr.tipoProducto.application.TipoProductoService;
import com.modules.sirsr.unidadMedida.application.UnidadMedidaDTO;
import com.modules.sirsr.unidadMedida.application.UnidadMedidaService;
import org.eclipse.persistence.jpa.rs.exceptions.JPARSException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author Edward Reyes
 */
@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;
    private final TipoProductoService tipoProductoService;
    private final UnidadMedidaService unidadMedidaService;
    private final EstatusService estatusService;
    private TipoProductoDTO tipoProductoDTO;
    private UnidadMedidaDTO unidadMedidaDTO;
    private EstatusDTO estatusDTO;
    private Mensaje msg;

    @Autowired
    public ProductoService(ProductoRepository productoRepository, TipoProductoService tipoProductoService, ProductoMapper productoMapper, UnidadMedidaService unidadMedidaService, EstatusService estatusService) {
        this.productoRepository = productoRepository;
        this.tipoProductoService = tipoProductoService;
        this.productoMapper = productoMapper;
        this.unidadMedidaService = unidadMedidaService;
        this.estatusService = estatusService;
    }

    public List<ProductoDTO> findAll() {
        return productoMapper.toProductoDTOs(productoRepository.findAllByIdEstatus(1));
    }

    public List<ProductoDTO> findByIdTipoProducto(String objetoGasto) {
        List<TipoProductoDTO> tiposProductoDTOs = tipoProductoService.findByObjetoGastoStr(objetoGasto);
        List<Integer> tiposProductoFound = tiposProductoDTOs
                .stream()
                .map(tipoProducto -> tipoProducto.getIdTipoProducto())
                .collect(Collectors.toList());
        return productoMapper.toProductoDTOs(productoRepository.findByIdTipoProductoIn(tiposProductoFound));
    }

    public ProductoDTO findById(int id) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        ProductoDTO productoDTO = productoMapper.toProductoDTO(productoOptional.get());
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
            productoRepository.save(productoMapper.toProducto(productoDTO));
            msg = Mensaje.CREATE("Agregado correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo agregar por: "+e.getMessage(), 2);
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
            productoRepository.save(productoMapper.toProducto(productoDTO));
            msg = Mensaje.CREATE("Agregado correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo agregar por: "+e.getMessage(), 2);
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
            productoRepository.save(productoMapper.toProducto(productoDTO));
            msg = Mensaje.CREATE("Actualizado correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo Actualizar por: "+e.getMessage(), 2);
        }
        return msg;
    }

    public Mensaje deleteById(int id) {
        try {
            productoRepository.deleteById(id);
            msg = Mensaje.CREATE("Eliminado correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo Eliminar.", 2);
        }
        return msg;

    }

}
