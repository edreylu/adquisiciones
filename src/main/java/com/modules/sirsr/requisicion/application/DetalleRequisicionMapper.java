package com.modules.sirsr.requisicion.application;

import com.modules.sirsr.marca.application.MarcaMapper;
import com.modules.sirsr.producto.application.ProductoMapper;
import com.modules.sirsr.requisicion.domain.DetalleRequisicion;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class DetalleRequisicionMapper {

    ModelMapper modelMapper = new ModelMapper();
    private final RequisicionMapper requisicionMapper;
    private final MarcaMapper marcaMapper;
    private final ProductoMapper productoMapper;

    @Autowired
    public DetalleRequisicionMapper(RequisicionMapper requisicionMapper, MarcaMapper marcaMapper, ProductoMapper productoMapper) {
        this.requisicionMapper = requisicionMapper;
        this.marcaMapper = marcaMapper;
        this.productoMapper = productoMapper;
    }

    public DetalleRequisicion toDetalleRequisicion(DetalleRequisicionDTO detalleRequisicionDTO) {
        
        if(Objects.isNull(detalleRequisicionDTO)){
            return null;
        }
         DetalleRequisicion detalleRequisicion = modelMapper.map(detalleRequisicionDTO, DetalleRequisicion.class);

        return detalleRequisicion;
    }

    public DetalleRequisicionDTO toDetalleRequisicionDTO(DetalleRequisicion detalleRequisicion) {

        if(Objects.isNull(detalleRequisicion)){
            return null;
        }

        DetalleRequisicionDTO detalleRequisicionDTO = new DetalleRequisicionDTO();
        detalleRequisicionDTO.setIdDetalleRequisicion(detalleRequisicion.getIdDetalleRequisicion());
        detalleRequisicionDTO.setIdRequisicion(detalleRequisicion.getIdRequisicion());
        detalleRequisicionDTO.setProducto(productoMapper.toProductoDTO(detalleRequisicion.getProducto()));
        detalleRequisicionDTO.setRequisicion(requisicionMapper.toRequisicionDTO(detalleRequisicion.getRequisicion()));
        detalleRequisicionDTO.setCantidadAutorizada(detalleRequisicion.getCantidadAutorizada());
        detalleRequisicionDTO.setCantidadSolicitada(detalleRequisicion.getCantidadSolicitada());
        detalleRequisicionDTO.setPrecioUnitario(detalleRequisicion.getPrecioUnitario());

        return detalleRequisicionDTO;
    }

    public List<DetalleRequisicionDTO> toDetalleRequisicionDTOs(List<DetalleRequisicion> detalleRequisiciones) {
        if (Objects.isNull(detalleRequisiciones)) {
            return null;
        }
        List<DetalleRequisicionDTO> list = new ArrayList<>(detalleRequisiciones.size());
        for (DetalleRequisicion detalleRequisicion : detalleRequisiciones) {
            list.add(toDetalleRequisicionDTO(detalleRequisicion));
        }
        return list;
    }

}
