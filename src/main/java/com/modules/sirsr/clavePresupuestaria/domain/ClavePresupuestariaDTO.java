package com.modules.sirsr.clavePresupuestaria.domain;

import com.modules.sirsr.objetoGasto.domain.ObjetoDeGastoDTO;
import com.modules.sirsr.unidadResponsable.domain.UnidadResponsableDTO;

public class ClavePresupuestariaDTO {
	private Integer idClavePresup;
	private String anio;
	private String ramo;
	private String institucion;
	private String finalidad;
	private String funcion;
	private String subfuncion;
	private String programaPresupuestario;
	private String subprogramaPresupuestario;
	private String actividadInstitucional;
	private String identificadorGasto;
	private String fuenteFinanciamiento;
	private String origen;
	private String procedencia;
	private String actividadEspecifica;
	private String tipoGasto;
	private String region;
	private String municipio;
	private String ppi;
	private String claveCompleta;
	private ObjetoDeGastoDTO objetoDeGasto;
	private UnidadResponsableDTO unidadResponsable;
	
	public ClavePresupuestariaDTO() {
		// TODO Auto-generated constructor stub
	}

	public ClavePresupuestariaDTO(Integer idClavePresup, String anio, String ramo, String institucion, String finalidad,
			String funcion, String subfuncion, String programaPresupuestario, String subprogramaPresupuestario,
			String actividadInstitucional, String identificadorGasto, String fuenteFinanciamiento, String origen,
			String procedencia, String actividadEspecifica, String tipoGasto, String region, String municipio,
			String ppi, ObjetoDeGastoDTO objetoDeGasto, UnidadResponsableDTO unidadResponsable) {
		this.idClavePresup = idClavePresup;
		this.anio = anio;
		this.ramo = ramo;
		this.institucion = institucion;
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
		this.objetoDeGasto = objetoDeGasto;
		this.unidadResponsable = unidadResponsable;
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

	public void setUnidadResponsable(UnidadResponsableDTO unidadResponsable) {
		this.unidadResponsable = unidadResponsable;
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

	public ObjetoDeGastoDTO getObjetoDeGasto() {
		return objetoDeGasto;
	}

	public void setObjetoDeGasto(ObjetoDeGastoDTO objetoDeGasto) {
		this.objetoDeGasto = objetoDeGasto;
	}

	public String getClaveCompleta() {
		return claveCompleta;
	}

	public void setClaveCompleta(String claveCompleta) {
		this.claveCompleta = claveCompleta;
	}

	public UnidadResponsableDTO getUnidadResponsable() {
		return unidadResponsable;
	}
}
