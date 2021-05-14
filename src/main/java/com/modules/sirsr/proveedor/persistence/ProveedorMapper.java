package com.modules.sirsr.proveedor.persistence;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.modules.sirsr.actividad.persistence.ActividadMapper;
import com.modules.sirsr.estatus.persistence.EstatusMapper;
import com.modules.sirsr.proveedor.domain.ProveedorDTO;

public class ProveedorMapper {
	
	public static ProveedorDTO toProveedorDTO(Proveedor proveedor) {
        if (Objects.isNull(proveedor)) {
            return null;
        }

        ProveedorDTO proveedorDTO = new ProveedorDTO();
        proveedorDTO.setIdProveedor(proveedor.getIdProveedor());
        proveedorDTO.setRazonSocial(proveedor.getRazonSocial());
        proveedorDTO.setRfc(proveedor.getRfc());
        proveedorDTO.setTelefono1(proveedor.getTelefono1()); 
        proveedorDTO.setTelefono2(proveedor.getTelefono2());
        proveedorDTO.setCorreoElectronico(proveedor.getCorreoElectronico());
        proveedorDTO.setFechaInicioOperaciones(proveedor.getFechaInicioOperaciones());
        proveedorDTO.setNumeroProveedor(proveedor.getNumeroProveedor());
        proveedorDTO.setRepresentanteLegal(proveedor.getRepresentanteLegal());
        proveedorDTO.setCalle(proveedor.getCalle());
        proveedorDTO.setNumeroExterior(proveedor.getNumeroExterior());
        proveedorDTO.setNumeroInterior(proveedor.getNumeroInterior());
        proveedorDTO.setColonia(proveedor.getColonia());
        proveedorDTO.setCodigoPostal(proveedor.getCodigoPostal());
        proveedorDTO.setLocalidad(proveedor.getLocalidad());
        proveedorDTO.setCiudad(proveedor.getCiudad());
        proveedorDTO.setFechaInicio(proveedor.getFechaInicio());
        proveedorDTO.setFechaFin(proveedor.getFechaFin());
        proveedorDTO.setEstatus(EstatusMapper.toEstatusDTO(proveedor.getEstatus()));
        proveedorDTO.setActividades(ActividadMapper.toActividadDTOs(proveedor.getActividades()));
                
        return proveedorDTO;
    }

    public static List<ProveedorDTO> toProveedorDTOs(List<Proveedor> proveedors) {
        if (Objects.isNull(proveedors)) {
            return null;
        }
        List<ProveedorDTO> list = new ArrayList<>(proveedors.size());
        for (Proveedor proveedor : proveedors) {
            list.add(toProveedorDTO(proveedor));
        }
        return list;
    }

    public static Proveedor toProveedor(ProveedorDTO proveedorDTO) {
        if (Objects.isNull(proveedorDTO)) {
            return null;
        }

        Proveedor proveedor = new Proveedor();
       
        proveedor.setIdProveedor(proveedorDTO.getIdProveedor());
        proveedor.setRazonSocial(proveedorDTO.getRazonSocial());
        proveedor.setRfc(proveedorDTO.getRfc());
        proveedor.setTelefono1(proveedorDTO.getTelefono1()); 
        proveedor.setTelefono2(proveedorDTO.getTelefono2());
        proveedor.setCorreoElectronico(proveedorDTO.getCorreoElectronico());
        proveedor.setFechaInicioOperaciones(proveedorDTO.getFechaInicioOperaciones());
        proveedor.setNumeroProveedor(proveedorDTO.getNumeroProveedor());
        proveedor.setRepresentanteLegal(proveedorDTO.getRepresentanteLegal());
        proveedor.setCalle(proveedorDTO.getCalle());
        proveedor.setNumeroExterior(proveedorDTO.getNumeroExterior());
        proveedor.setNumeroInterior(proveedorDTO.getNumeroInterior());
        proveedor.setColonia(proveedorDTO.getColonia());
        proveedor.setCodigoPostal(proveedorDTO.getCodigoPostal());
        proveedor.setLocalidad(proveedorDTO.getLocalidad());
        proveedor.setCiudad(proveedorDTO.getCiudad());
        proveedor.setFechaInicio(proveedorDTO.getFechaInicio());
        proveedor.setFechaFin(proveedorDTO.getFechaFin());
        proveedor.setEstatus(EstatusMapper.toEstatus(proveedorDTO.getEstatus()));
        
        return proveedor;
    }

    public static Proveedor setToUpdate(Proveedor proveedorFound, ProveedorDTO proveedorDTO) {
    	
    	proveedorFound.setRazonSocial(proveedorDTO.getRazonSocial());
    	proveedorFound.setRfc(proveedorDTO.getRfc());
    	proveedorFound.setTelefono1(proveedorDTO.getTelefono1()); 
    	proveedorFound.setTelefono2(proveedorDTO.getTelefono2());
    	proveedorFound.setCorreoElectronico(proveedorDTO.getCorreoElectronico());
    	proveedorFound.setFechaInicioOperaciones(proveedorDTO.getFechaInicioOperaciones());
    	proveedorFound.setNumeroProveedor(proveedorDTO.getNumeroProveedor());
    	proveedorFound.setRepresentanteLegal(proveedorDTO.getRepresentanteLegal());
    	proveedorFound.setCalle(proveedorDTO.getCalle());
    	proveedorFound.setNumeroExterior(proveedorDTO.getNumeroExterior());
    	proveedorFound.setNumeroInterior(proveedorDTO.getNumeroInterior());
    	proveedorFound.setColonia(proveedorDTO.getColonia());
    	proveedorFound.setCodigoPostal(proveedorDTO.getCodigoPostal());
    	proveedorFound.setLocalidad(proveedorDTO.getLocalidad());
    	proveedorFound.setCiudad(proveedorDTO.getCiudad());
    	proveedorFound.setFechaInicio(proveedorDTO.getFechaInicio());
    	proveedorFound.setFechaFin(proveedorDTO.getFechaFin());   
       
        return proveedorFound;
    }
}
