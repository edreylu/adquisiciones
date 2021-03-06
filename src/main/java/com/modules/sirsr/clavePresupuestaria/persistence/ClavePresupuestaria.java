/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.clavePresupuestaria.persistence;

import com.modules.sirsr.estatus.persistence.Estatus;
import com.modules.sirsr.objetoGasto.persistence.ObjetoDeGasto;
import com.modules.sirsr.unidadResponsable.persistence.UnidadResponsable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "CLAVE_PRESUPUESTARIA")
public class ClavePresupuestaria {

	@Id
	@Basic(optional = false)
	@Column(name = "ID_CLAVE_PRESUP")
	private Integer idClavePresup;
	@Column(name = "ANIO")
	private String anio;
	@Column(name = "RAMO")
	private String ramo;
	@Column(name = "INSTITUCION")
	private String institucion;
	@Column(name = "UNIDAD_RESPONSABLE")
	private String unidadResp;
	@Column(name = "FINALIDAD")
	private String finalidad;
	@Column(name = "FUNCION")
	private String funcion;
	@Column(name = "SUBFUNCION")
	private String subfuncion;
	@Column(name = "PROGRAMA_PRESUPUESTARIO")
	private String programaPresupuestario;
	@Column(name = "SUBPROGRAMA_PRESUPUESTARIO")
	private String subprogramaPresupuestario;
	@Column(name = "ACTIVIDAD_INSTITUCIONAL")
	private String actividadInstitucional;
	@Column(name = "IDENTIFICADOR_GASTO")
	private String identificadorGasto;
	@Column(name = "FUENTE_FINANCIAMIENTO")
	private String fuenteFinanciamiento;
	@Column(name = "ORIGEN")
	private String origen;
	@Column(name = "PROCEDENCIA")
	private String procedencia;
	@Column(name = "ACTIVIDAD_ESPECIFICA")
	private String actividadEspecifica;
	@Column(name = "TIPO_GASTO")
	private String tipoGasto;
	@Column(name = "REGION")
	private String region;
	@Column(name = "MUNICIPIO")
	private String municipio;
	@Column(name = "PPI")
	private String ppi;
	@Column(name = "CLAVE_UR", updatable = false, insertable = false)
	private String claveUr;
	@Column(name = "ID_ESTATUS", updatable = false, insertable = false)
	private Integer idEstatus;
	@JoinColumn(name = "OBJETO_GASTO", referencedColumnName = "OBJETO_GASTO")
	@ManyToOne(optional = false)
	private ObjetoDeGasto objetoDeGasto;
	@JoinColumn(name = "CLAVE_UR", referencedColumnName = "CLAVE_UR")
	@ManyToOne(optional = false)
	private UnidadResponsable unidadResponsable;
	@JoinColumn(name = "ID_ESTATUS", referencedColumnName = "ID_ESTATUS")
	@ManyToOne(optional = false)
	private Estatus estatus;
	
	public ClavePresupuestaria() {
		// TODO Auto-generated constructor stub
	}

	public ClavePresupuestaria(Integer idClavePresup, String anio, String ramo, String institucion, String unidadResp,
			String finalidad, String funcion, String subfuncion, String programaPresupuestario,
			String subprogramaPresupuestario, String actividadInstitucional, String identificadorGasto,
			String fuenteFinanciamiento, String origen, String procedencia, String actividadEspecifica,
			String tipoGasto, String region, String municipio, String ppi, String claveUr, 
			ObjetoDeGasto objetoDeGasto, UnidadResponsable unidadResponsable, Estatus estatus) {
		this.idClavePresup = idClavePresup;
		this.anio = anio;
		this.ramo = ramo;
		this.institucion = institucion;
		this.unidadResp = unidadResp;
		this.finalidad = finalidad;
		this.funcion = funcion;
		this.subfuncion = subfuncion;
		this.programaPresupuestario = programaPresupuestario;
		this.subprogramaPresupuestario = subprogramaPresupuestario;
		this.actividadInstitucional = actividadInstitucional;
		this.identificadorGasto = identificadorGasto;
		this.fuenteFinanciamiento = fuenteFinanciamiento;
		this.origen = origen;
		this.procedencia = procedencia;
		this.actividadEspecifica = actividadEspecifica;
		this.tipoGasto = tipoGasto;
		this.region = region;
		this.municipio = municipio;
		this.ppi = ppi;
		this.claveUr = claveUr;
		this.objetoDeGasto = objetoDeGasto;
		this.unidadResponsable = unidadResponsable;
		this.estatus = estatus;
	}


	public Integer getIdClavePresup() {
		return idClavePresup;
	}

	public void setIdClavePresup(Integer idClavePresup) {
		this.idClavePresup = idClavePresup;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getRamo() {
		return ramo;
	}

	public void setRamo(String ramo) {
		this.ramo = ramo;
	}

	public String getInstitucion() {
		return institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public String getUnidadResp() {
		return unidadResp;
	}

	public void setUnidadResp(String unidadResp) {
		this.unidadResp = unidadResp;
	}

	public String getFinalidad() {
		return finalidad;
	}

	public void setFinalidad(String finalidad) {
		this.finalidad = finalidad;
	}

	public String getFuncion() {
		return funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	public String getSubfuncion() {
		return subfuncion;
	}

	public void setSubfuncion(String subfuncion) {
		this.subfuncion = subfuncion;
	}

	public String getProgramaPresupuestario() {
		return programaPresupuestario;
	}

	public void setProgramaPresupuestario(String programaPresupuestario) {
		this.programaPresupuestario = programaPresupuestario;
	}

	public String getSubprogramaPresupuestario() {
		return subprogramaPresupuestario;
	}

	public void setSubprogramaPresupuestario(String subprogramaPresupuestario) {
		this.subprogramaPresupuestario = subprogramaPresupuestario;
	}

	public String getActividadInstitucional() {
		return actividadInstitucional;
	}

	public void setActividadInstitucional(String actividadInstitucional) {
		this.actividadInstitucional = actividadInstitucional;
	}

	public String getIdentificadorGasto() {
		return identificadorGasto;
	}

	public void setIdentificadorGasto(String identificadorGasto) {
		this.identificadorGasto = identificadorGasto;
	}

	public String getFuenteFinanciamiento() {
		return fuenteFinanciamiento;
	}

	public void setFuenteFinanciamiento(String fuenteFinanciamiento) {
		this.fuenteFinanciamiento = fuenteFinanciamiento;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}

	public String getActividadEspecifica() {
		return actividadEspecifica;
	}

	public void setActividadEspecifica(String actividadEspecifica) {
		this.actividadEspecifica = actividadEspecifica;
	}

	public String getTipoGasto() {
		return tipoGasto;
	}

	public void setTipoGasto(String tipoGasto) {
		this.tipoGasto = tipoGasto;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getPpi() {
		return ppi;
	}

	public void setPpi(String ppi) {
		this.ppi = ppi;
	}

	public String getClaveUr() {
		return claveUr;
	}

	public void setClaveUr(String claveUr) {
		this.claveUr = claveUr;
	}

	public ObjetoDeGasto getObjetoDeGasto() {
		return objetoDeGasto;
	}

	public void setObjetoDeGasto(ObjetoDeGasto objetoDeGasto) {
		this.objetoDeGasto = objetoDeGasto;
	}

	public UnidadResponsable getUnidadResponsable() {
		return unidadResponsable;
	}

	public void setUnidadResponsable(UnidadResponsable unidadResponsable) {
		this.unidadResponsable = unidadResponsable;
	}

	public Estatus getEstatus() {
		return estatus;
	}

	public void setEstatus(Estatus estatus) {
		this.estatus = estatus;
	}

	public Integer getIdEstatus() {
		return idEstatus;
	}

	public void setIdEstatus(Integer idEstatus) {
		this.idEstatus = idEstatus;
	}
}
