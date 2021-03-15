/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.estructuraProgramatica.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "ESTRUCTURA_PROGRAMATICA")
public class EstructuraProgramatica{

    @Id
    @Basic(optional = false)
    @Column(name = "ID_ESTRUCTURA")
    private Short idEstructura;
    @Column(name = "ANIO")
    private String anio;
    @Column(name = "RAMO")
    private String ramo;
    @Column(name = "INSTITUCION")
    private String institucion;
    @Column(name = "UNIDAD_RESPONSABLE")
    private String unidadResponsable;
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
    @Column(name = "OBJETO_GASTO")
    private String objetoGasto;
    @Column(name = "TIPO_GASTO")
    private String tipoGasto;
    @Column(name = "REGION")
    private String region;
    @Column(name = "MUNICIPIO")
    private String municipio;
    @Column(name = "PPI")
    private String ppi;
    @Basic(optional = false)
    @Column(name = "CLAVE_UNIDAD")
    private String claveUnidad;

    
    public Short getIdEstructura() {
        return idEstructura;
    }

    public void setIdEstructura(Short idEstructura) {
        this.idEstructura = idEstructura;
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

    public String getUnidadResponsable() {
        return unidadResponsable;
    }

    public void setUnidadResponsable(String unidadResponsable) {
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

    public String getObjetoGasto() {
        return objetoGasto;
    }

    public void setObjetoGasto(String objetoGasto) {
        this.objetoGasto = objetoGasto;
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

    public String getClaveUnidad() {
        return claveUnidad;
    }

    public void setClaveUnidad(String claveUnidad) {
        this.claveUnidad = claveUnidad;
    }

    
}
