package com.modules.sirsr.producto.application;

import com.modules.sirsr.estatus.application.EstatusMapper;
import com.modules.sirsr.producto.domain.Producto;
import com.modules.sirsr.tipoProducto.application.TipoProductoMapper;
import com.modules.sirsr.unidadMedida.application.UnidadMedidaMapper;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Component
public class ProductoMapper {

    private final EstatusMapper estatusMapper = new EstatusMapper();
    private final TipoProductoMapper tipoProductoMapper = new TipoProductoMapper();
    private final UnidadMedidaMapper unidadMedidaMapper = new UnidadMedidaMapper();

    public Producto toProducto(ProductoDTO productoDTO){
        Producto producto = new Producto();
        producto.setIdProducto(productoDTO.getIdProducto());
        producto.setUnidadMedida(unidadMedidaMapper.toUnidadMedida(productoDTO.getUnidadMedida()));
        producto.setTipoProducto(tipoProductoMapper.toTipoProducto(productoDTO.getTipoProducto()));
        producto.setCaracteristicas(productoDTO.getCaracteristicas());
        producto.setPrecioDeReferencia(productoDTO.getPrecioDeReferencia());
        producto.setFechaActualizacion(Date.from(Instant.now()));
        producto.setPermisoUr(1);
        producto.setEstatus(estatusMapper.toEstatus(productoDTO.getEstatus()));
        return producto;
    }
    public ProductoDTO toProductoDTO(Producto producto){
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setIdProducto(producto.getIdProducto());
        productoDTO.setUnidadMedida(unidadMedidaMapper.toUnidadMedidaDTO(producto.getUnidadMedida()));
        productoDTO.setTipoProducto(tipoProductoMapper.toTipoProductoDTO(producto.getTipoProducto()));
        productoDTO.setCaracteristicas(producto.getCaracteristicas());
        productoDTO.setPrecioDeReferencia(producto.getPrecioDeReferencia());
        productoDTO.setFechaActualizacion(producto.getFechaActualizacion());
        productoDTO.setPermisoUr(producto.getPermisoUr());
        productoDTO.setEstatus(estatusMapper.toEstatusDTO(producto.getEstatus()));

        return productoDTO;
    }
    public List<ProductoDTO> toProductoDTOs(List<Producto> productos){
        if (Objects.isNull(productos)) {
            return null;
        }
        List<ProductoDTO> list = new ArrayList<>(productos.size());
        for (Producto producto : productos) {
            list.add(toProductoDTO(producto));
        }
        return list;
    }
}
