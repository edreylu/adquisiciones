package com.modules.sirsr.requisicion.persistence;

import com.modules.sirsr.marca.persistence.MarcaMapper;
import com.modules.sirsr.producto.persistence.ProductoMapper;
import com.modules.sirsr.producto.persistence.Producto;
import com.modules.sirsr.producto.persistence.ProductoRepository;
import com.modules.sirsr.requisicion.domain.DetalleRequisicionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DetalleRequisicionMapper {

    private final RequisicionMapper requisicionMapper;
    private final MarcaMapper marcaMapper;
    private final ProductoMapper productoMapper;
    private final ProductoRepository productoRepository;
    private final RequisicionRepository requisicionRepository;

    @Autowired
    public DetalleRequisicionMapper(RequisicionMapper requisicionMapper, MarcaMapper marcaMapper, ProductoMapper productoMapper, ProductoRepository productoRepository, RequisicionRepository requisicionRepository) {
        this.requisicionMapper = requisicionMapper;
        this.marcaMapper = marcaMapper;
        this.productoMapper = productoMapper;
        this.productoRepository = productoRepository;
        this.requisicionRepository = requisicionRepository;
    }

    public DetalleRequisicion toDetalleRequisicion(DetalleRequisicionDTO detalleRequisicionDTO) {
        
        if(Objects.isNull(detalleRequisicionDTO)){
            return null;
        }
         DetalleRequisicion detalleRequisicion = new DetalleRequisicion();
        detalleRequisicion.setIdDetalleRequisicion(detalleRequisicionDTO.getIdDetalleRequisicion());
        detalleRequisicion.setIdRequisicion(detalleRequisicionDTO.getIdRequisicion());
        detalleRequisicion.setProducto(productoMapper.toProducto(detalleRequisicionDTO.getProducto()));
        detalleRequisicion.setRequisicion(requisicionMapper.toRequisicion(detalleRequisicionDTO.getRequisicion()));
        detalleRequisicion.setCantidadAutorizada(detalleRequisicionDTO.getCantidadAutorizada());
        detalleRequisicion.setCantidadSolicitada(detalleRequisicionDTO.getCantidadSolicitada());
        detalleRequisicion.setPrecioUnitario(detalleRequisicionDTO.getPrecioUnitario());

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
        detalleRequisicionDTO.setCantidadAutorizada(0);
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

    public Set<DetalleRequisicionDTO> toDetalleRequisicionDTOsSet(Set<DetalleRequisicion> detalleRequisiciones) {
        if (Objects.isNull(detalleRequisiciones)) {
            return null;
        }
        Set<DetalleRequisicionDTO> list = new HashSet<>(detalleRequisiciones.size());
        for (DetalleRequisicion detalleRequisicion : detalleRequisiciones) {
            list.add(toDetalleRequisicionDTO(detalleRequisicion));
        }
        return list;
    }

    public DetalleRequisicion setToUpdate(DetalleRequisicionDTO detalleRequisicionDTO) {
        DetalleRequisicion detalleRequisicionFound = new DetalleRequisicion();
        Producto producto = productoRepository.findById(detalleRequisicionDTO.getProducto().getIdProducto()).get();
        Requisicion requisicion = requisicionRepository.findById(detalleRequisicionDTO.getIdRequisicion()).get();
        detalleRequisicionFound.setIdDetalleRequisicion(detalleRequisicionDTO.getIdDetalleRequisicion());
        detalleRequisicionFound.setRequisicion(requisicion);
        detalleRequisicionFound.setProducto(producto);
        detalleRequisicionFound.setCantidadSolicitada(detalleRequisicionDTO.getCantidadSolicitada());
        return detalleRequisicionFound;
    }

}
