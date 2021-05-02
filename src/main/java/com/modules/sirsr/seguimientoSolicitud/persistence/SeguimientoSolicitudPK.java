/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.seguimientoSolicitud.persistence;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Edward Reyes
 */
@Embeddable
public class SeguimientoSolicitudPK implements Serializable {

	@Basic(optional = false)
	@Column(name = "ID_SOLICITUD")
	private int idSolicitud;
	@Basic(optional = false)
	@Column(name = "ID_ESTATUS")
	private short idEstatus;
	@Basic(optional = false)
	@Column(name = "FECHA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	public SeguimientoSolicitudPK() {
	}

	public SeguimientoSolicitudPK(int idSolicitud, short idEstatus, Date fecha) {
		this.idSolicitud = idSolicitud;
		this.idEstatus = idEstatus;
		this.fecha = fecha;
	}

	public int getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public short getIdEstatus() {
		return idEstatus;
	}

	public void setIdEstatus(short idEstatus) {
		this.idEstatus = idEstatus;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (int) idSolicitud;
		hash += (int) idEstatus;
		hash += (fecha != null ? fecha.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof SeguimientoSolicitudPK)) {
			return false;
		}
		SeguimientoSolicitudPK other = (SeguimientoSolicitudPK) object;
		if (this.idSolicitud != other.idSolicitud) {
			return false;
		}
		if (this.idEstatus != other.idEstatus) {
			return false;
		}
		if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.modules.sirsr.seguimientoSolicitud.persistence.SeguimientoSolicitudPK[ idSolicitud=" + idSolicitud
				+ ", idEstatus=" + idEstatus + ", fecha=" + fecha + " ]";
	}

}
