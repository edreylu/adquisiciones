/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.usuario.domain;

import com.modules.sirsr.datosPersonales.domain.DatosPersonalesDTO;
import com.modules.sirsr.estatus.domain.EstatusDTO;
import com.modules.sirsr.unidadResponsable.domain.UnidadResponsableDTO;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Edward Reyes
 */

public class UsuarioDTO implements Serializable{
	private int noUsuario;
	private String userName;
	private String password;
	private String encrytedPassword;
	private Date fechaAuditoria;
	private EstatusDTO estatus;
	private Integer enabled;
	private DatosPersonalesDTO personal;
	private UnidadResponsableDTO unidadResponsable;
	
	public UsuarioDTO() {
		// TODO Auto-generated constructor stub
	}
	

	public UsuarioDTO(int noUsuario, String userName, Date fechaAuditoria, EstatusDTO estatus, Integer enabled,
			DatosPersonalesDTO personal, UnidadResponsableDTO unidadResponsable) {
		this.noUsuario = noUsuario;
		this.userName = userName;
		this.fechaAuditoria = fechaAuditoria;
		this.estatus = estatus;
		this.enabled = enabled;
		this.personal = personal;
		this.unidadResponsable = unidadResponsable;
	}



	public int getNoUsuario() {
		return noUsuario;
	}

	public void setNoUsuario(int noUsuario) {
		this.noUsuario = noUsuario;
	}

	public String getUserName() {
		return Objects.nonNull(userName) ? userName.toUpperCase() : userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEncrytedPassword() {
		return encrytedPassword;
	}

	public String getPassword() {
		return Objects.nonNull(password) ? password.toUpperCase() : password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEncrytedPassword(String encrytedPassword) {
		this.encrytedPassword = encrytedPassword;
	}

	public Date getFechaAuditoria() {
		return fechaAuditoria;
	}

	public void setFechaAuditoria(Date fechaAuditoria) {
		this.fechaAuditoria = fechaAuditoria;
	}

	public UnidadResponsableDTO getUnidadResponsable() {
		return unidadResponsable;
	}

	public void setUnidadResponsable(UnidadResponsableDTO unidadResponsable) {
		this.unidadResponsable = unidadResponsable;
	}

	public EstatusDTO getEstatus() {
		return estatus;
	}

	public void setEstatus(EstatusDTO estatus) {
		this.estatus = estatus;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public DatosPersonalesDTO getPersonal() {
		return personal;
	}

	public void setPersonal(DatosPersonalesDTO personal) {
		this.personal = personal;
	}

}
