/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.proveedor.domain;

import com.modules.sirsr.estatus.domain.EstatusDTO;
import com.modules.sirsr.tipoPersonaFiscal.domain.TipoPersonaFiscalDTO;

/**
 *
 * @author Edward Reyes
 */

public class ProveedorDTO {
    
	
	
    public ProveedorDTO() {
		tipoPersonaFiscalDTO = new TipoPersonaFiscalDTO();
		estatusDTO = new  EstatusDTO();
	}

	private int idProveedor;
    private String rfc;
    private String razonSocial;
    private String nombreComercial;
    private String propietario;
    private String representante;
    private Integer telefono1;
    private Integer telefono2;
    private String correoElectronico;
    private String domicilio;
    private Integer codigoPostal;
    private TipoPersonaFiscalDTO tipoPersonaFiscalDTO;
    private EstatusDTO estatusDTO;
   

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    
    public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public Integer getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(Integer telefono1) {
		this.telefono1 = telefono1;
	}

	public Integer getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(Integer telefono2) {
		this.telefono2 = telefono2;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public Integer getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public TipoPersonaFiscalDTO getTipoPersonaFiscalDTO() {
		return tipoPersonaFiscalDTO;
	}

	public void setTipoPersonaFiscalDTO(TipoPersonaFiscalDTO tipoPersonaFiscalDTO) {
		this.tipoPersonaFiscalDTO = tipoPersonaFiscalDTO;
	}

	public EstatusDTO getEstatusDTO() {
		return estatusDTO;
	}

	public void setEstatusDTO(EstatusDTO estatusDTO) {
		this.estatusDTO = estatusDTO;
	}

    
    

}
