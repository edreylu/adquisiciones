package com.modules.sirsr.requisicion;

import com.modules.sirsr.persistence.entity.DetalleRequisicion;
import com.modules.sirsr.persistence.entity.Requisicion;
import com.modules.sirsr.persistence.entity.UnidadMedida;
import org.springframework.stereotype.Component;

@Component
public class DetalleRequisicionMapper {

    public DetalleRequisicion toDetalleRequisicion(int cantidad, String caracteristicas, UnidadMedida unidadMedida, Requisicion requisicion) {
        
        DetalleRequisicion detalleRequisicion = new DetalleRequisicion();
        detalleRequisicion.setCantidadSolicitada(cantidad);
        //detalleRequisicion.setCaracteristicas(caracteristicas);
        //detalleRequisicion.setUnidadMedida(unidadMedida);

        return detalleRequisicion;
    }

}
