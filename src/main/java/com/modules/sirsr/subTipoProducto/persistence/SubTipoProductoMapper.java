package com.modules.sirsr.subTipoProducto.persistence;

import com.modules.sirsr.subTipoProducto.domain.SubTipoProductoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class SubTipoProductoMapper {

    ModelMapper modelMapper = new ModelMapper();

    public SubTipoProductoDTO toSubTipoProductoDTO(SubTipoProducto subTipoProducto){
        SubTipoProductoDTO subTipoProductoDTO = modelMapper.map(subTipoProducto, SubTipoProductoDTO.class);
        return subTipoProductoDTO;
    }

    public List<SubTipoProductoDTO> toSubTipoProductoDTOs(List<SubTipoProducto> subTipoProductos){
        if (Objects.isNull(subTipoProductos)) {
            return null;
        }
        List<SubTipoProductoDTO> list = new ArrayList<>(subTipoProductos.size());
        for (SubTipoProducto subTipoProducto : subTipoProductos) {
            list.add(toSubTipoProductoDTO(subTipoProducto));
        }
        return list;
    }

   
}
