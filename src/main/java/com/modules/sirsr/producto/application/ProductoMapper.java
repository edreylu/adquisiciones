package com.modules.sirsr.producto.application;

import com.modules.sirsr.producto.domain.Producto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ProductoMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public Producto toProducto(ProductoDTO productoDTO){
        Producto producto = modelMapper.map(productoDTO, Producto.class);
        return producto;
    }
    public ProductoDTO toProductoDTO(Producto producto){
        ProductoDTO productoDTO = modelMapper.map(producto, ProductoDTO.class);
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
