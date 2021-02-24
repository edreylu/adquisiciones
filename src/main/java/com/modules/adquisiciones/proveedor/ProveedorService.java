/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.adquisiciones.proveedor;

import com.modules.adquisiciones.persistence.entity.Proveedor;
import com.modules.adquisiciones.persistence.repository.ProveedorRepository;

import java.util.List;
import java.util.Optional;

import com.modules.adquisiciones.utils.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Edward Reyes
 */
@Service
public class ProveedorService {
    
    private final ProveedorRepository proveedorRepository;
    private final ProveedorMapper proveedorMapper;
    private Mensaje msg;

    @Autowired
    public ProveedorService(ProveedorRepository proveedorRepository, ProveedorMapper proveedorMapper) {
        this.proveedorRepository = proveedorRepository;
        this.proveedorMapper = proveedorMapper;
    }

    public List<ProveedorDTO> findAll() {
        return proveedorMapper.toProveedorDTOs(proveedorRepository.findAll());
    }

    public ProveedorDTO findById(int id) {
        Optional<Proveedor> proveedorOptional = proveedorRepository.findById(id);
        ProveedorDTO proveedorDTO = proveedorMapper.toProveedorDTO(proveedorOptional.get());
        return proveedorDTO;
    }

    public Mensaje save(ProveedorDTO proveedorDTO) {
        try {
            
            proveedorRepository.save(proveedorMapper.toProveedor(proveedorDTO));
            msg = Mensaje.CREATE("Agregado correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo agregar por: "+e.getMessage(), 2);
        }
        return msg;
    }

    public Mensaje update(ProveedorDTO proveedorDTO, int id) {
        try {
            Optional<Proveedor> proveedorFound = proveedorRepository.findById(id);
            Proveedor proveedor = proveedorMapper.setToUpdate(proveedorFound.get(), proveedorDTO);
            proveedorRepository.save(proveedor);
            msg = Mensaje.CREATE("Agregado correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo agregar por: "+e.getMessage(), 2);
        }
        return msg;
    }

    public Mensaje deleteById(int id) {
        try {
            proveedorRepository.deleteById(id);
            msg = Mensaje.CREATE("Eliminado correctamente", 1);
        }catch (Exception e){
            msg = Mensaje.CREATE("No se pudo Eliminar por que hay usuarios asociados a rol.", 2);
        }
        return msg;

    }

}
