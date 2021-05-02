package com.modules.sirsr.actividad.persistence;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.modules.sirsr.proveedor.persistence.Proveedor;

import com.modules.sirsr.estatus.persistence.Estatus;

@Entity
@Table
public class Actividad {

	@Id
	@GeneratedValue
	@Column(name = "ID_ACTIVIDAD", nullable = false)
	private Integer idActividad;
	@Column(nullable = false)
	private String descripcion;
	@JoinColumn(name = "ID_ESTATUS", referencedColumnName = "ID_ESTATUS")
	@ManyToOne(optional = false)
	private Estatus estatus;
	@ManyToMany(mappedBy = "actividades")
	private List<Proveedor> proveedores;

	public Integer getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(Integer idActividad) {
		this.idActividad = idActividad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Estatus getEstatus() {
		return estatus;
	}

	public void setEstatus(Estatus estatus) {
		this.estatus = estatus;
	}

	public List<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	@Override
	public String toString() {
		return "Actividad [idActividad=" + idActividad + ", descripcion=" + descripcion + ", estatus=" + estatus
				+ ", proveedores=" + proveedores + "]";
	}
	
	

	
	
}
