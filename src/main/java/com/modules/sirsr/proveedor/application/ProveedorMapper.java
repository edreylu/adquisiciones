package com.modules.sirsr.proveedor.application;

import com.modules.sirsr.proveedor.domain.Proveedor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ProveedorMapper {

    public ProveedorDTO toProveedorDTO(Proveedor proveedor) {
        if (Objects.isNull(proveedor)) {
            return null;
        }

        ProveedorDTO proveedorDTO = new ProveedorDTO();
        proveedorDTO.setIdProveedor(proveedor.getIdProveedor());
        proveedorDTO.setRfc(proveedor.getRfc());
        proveedorDTO.setRazonSocial(proveedor.getRazonSocial());
        //proveedorDTO.setEstatus(proveedor.getEstatus());

        return proveedorDTO;
    }

    public List<ProveedorDTO> toProveedorDTOs(List<Proveedor> proveedors) {
        if (Objects.isNull(proveedors)) {
            return null;
        }
        List<ProveedorDTO> list = new ArrayList<>(proveedors.size());
        for (Proveedor proveedor : proveedors) {
            list.add(toProveedorDTO(proveedor));
        }
        return list;
    }

    public Proveedor toProveedor(ProveedorDTO proveedorDTO) {
        if (Objects.isNull(proveedorDTO)) {
            return null;
        }

        Proveedor proveedor = new Proveedor();
        proveedor.setIdProveedor(proveedorDTO.getIdProveedor());
        proveedor.setRfc(proveedorDTO.getRfc());
        proveedor.setRazonSocial(proveedorDTO.getRazonSocial());
        //proveedor.setEstatus(1);

        return proveedor;
    }

    public Proveedor setToUpdate(Proveedor proveedorFound, ProveedorDTO proveedorDTO) {
        proveedorFound.setRfc(proveedorDTO.getRfc());
        proveedorFound.setRazonSocial(proveedorDTO.getRazonSocial());
        return proveedorFound;
    }
}
