package com.modules.sirsr.proveedor.application;

import com.modules.sirsr.estatus.domain.Estatus;
import com.modules.sirsr.proveedor.domain.Proveedor;
import com.modules.sirsr.tipoPersonaFiscal.domain.TipoPersonaFiscal;

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
        proveedorDTO.setNombreComercial(proveedor.getNombreComercial());
        proveedorDTO.setPropietario(proveedor.getPropietario());
        proveedorDTO.setRepresentante(proveedor.getRepresentante());
        proveedorDTO.setCorreoElectronico(proveedor.getCorreoElectronico());
        proveedorDTO.getTipoPersonaFiscalDTO().setIdTipoPersonaFiscal(proveedor.getTipoPersonaFiscal().getIdTipoPersonaFiscal());
        proveedorDTO.getEstatusDTO().setIdEstatus(proveedor.getEstatus().getIdEstatus());
        proveedorDTO.getEstatusDTO().setDescripcion(proveedor.getEstatus().getDescripcion());

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
        proveedor.setEstatus(new Estatus());
        proveedor.setTipoPersonaFiscal(new TipoPersonaFiscal());
        
        proveedor.setIdProveedor(proveedorDTO.getIdProveedor());
        proveedor.setRfc(proveedorDTO.getRfc());
        proveedor.setRazonSocial(proveedorDTO.getRazonSocial());
        proveedor.setNombreComercial(proveedorDTO.getNombreComercial());
        proveedor.setPropietario(proveedorDTO.getPropietario());
        proveedor.setRepresentante(proveedorDTO.getRepresentante());
        proveedor.setTelefono1(proveedorDTO.getTelefono1());
        proveedor.setTelefono2(proveedorDTO.getTelefono2());
        proveedor.setCorreoElectronico(proveedorDTO.getCorreoElectronico());
        proveedor.setDomicilio(proveedorDTO.getDomicilio());
        proveedor.setCodigoPostal(proveedorDTO.getCodigoPostal());   
        proveedor.getTipoPersonaFiscal().setIdTipoPersonaFiscal(proveedorDTO.getTipoPersonaFiscalDTO().getIdTipoPersonaFiscal());
        proveedor.getEstatus().setIdEstatus(proveedorDTO.getEstatusDTO().getIdEstatus());
        
        return proveedor;
    }

    public Proveedor setToUpdate(Proveedor proveedorFound, ProveedorDTO proveedorDTO) {
        proveedorFound.setRfc(proveedorDTO.getRfc());
        proveedorFound.setRazonSocial(proveedorDTO.getRazonSocial());
        proveedorFound.setNombreComercial(proveedorDTO.getNombreComercial());
        proveedorFound.setPropietario(proveedorDTO.getPropietario());
        proveedorFound.setRepresentante(proveedorDTO.getRepresentante());
        proveedorFound.setTelefono1(proveedorDTO.getTelefono1());
        proveedorFound.setTelefono2(proveedorDTO.getTelefono2());
        proveedorFound.setCorreoElectronico(proveedorDTO.getCorreoElectronico());
        proveedorFound.setDomicilio(proveedorDTO.getDomicilio());
        proveedorFound.setCodigoPostal(proveedorDTO.getCodigoPostal());   
       
        return proveedorFound;
    }
}
