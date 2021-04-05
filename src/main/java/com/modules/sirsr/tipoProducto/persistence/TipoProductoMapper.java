package com.modules.sirsr.tipoProducto.persistence;

import com.modules.sirsr.estatus.persistence.EstatusMapper;
import com.modules.sirsr.objetoGasto.persistence.ObjetoDeGastoMapper;
import com.modules.sirsr.tipoProducto.domain.TipoProductoDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class TipoProductoMapper {

    private final ObjetoDeGastoMapper objetoDeGastoMapper = new ObjetoDeGastoMapper();
    private final EstatusMapper estatusMapper = new EstatusMapper();

    public TipoProductoDTO toTipoProductoDTO(TipoProducto tipoProducto) {
        if (Objects.isNull(tipoProducto)) {
            return null;
        }
        TipoProductoDTO tipoProductoDTO = new TipoProductoDTO();
        tipoProductoDTO.setIdTipoProducto(tipoProducto.getIdTipoProducto());
        tipoProductoDTO.setDescripcion(tipoProducto.getDescripcion());
        tipoProductoDTO.setEstatus(estatusMapper.toEstatusDTO(tipoProducto.getEstatus()));
        tipoProductoDTO.setObjetoDeGasto(objetoDeGastoMapper.toObjetoDeGastoDTO(tipoProducto.getObjetoGasto()));
        return tipoProductoDTO;
    }

    public List<TipoProductoDTO> toTipoProductoDTOs(List<TipoProducto> tipoProductoes) {
        if (Objects.isNull(tipoProductoes)) {
            return null;
        }
        List<TipoProductoDTO> list = new ArrayList<>(tipoProductoes.size());
        for (TipoProducto tipoProducto : tipoProductoes) {
            list.add(toTipoProductoDTO(tipoProducto));
        }
        return list;
    }

    public TipoProducto toTipoProducto(TipoProductoDTO tipoProductoDTO){
        if (Objects.isNull(tipoProductoDTO)) {
            return null;
        }
        TipoProducto tipoProducto = new TipoProducto();
        tipoProducto.setIdTipoProducto(tipoProductoDTO.getIdTipoProducto());
        tipoProducto.setDescripcion(tipoProductoDTO.getDescripcion());
        tipoProducto.setEstatus(estatusMapper.toEstatus(tipoProductoDTO.getEstatus()));
        tipoProducto.setObjetoGasto(objetoDeGastoMapper.toObjetoDeGasto(tipoProductoDTO.getObjetoDeGasto()));
        return tipoProducto;
    }

    public TipoProducto setToUpdate(TipoProducto tipoProductoFound, TipoProductoDTO tipoProductoDTO) {
        return tipoProductoFound;
    }

    private String replaceCaracter(String caracter, int opcion) {
        Objects.nonNull(caracter);
        return opcion == 1 ? caracter.replaceAll(",", "\\|") : caracter.replaceAll("\\|", ",");
    }
}
