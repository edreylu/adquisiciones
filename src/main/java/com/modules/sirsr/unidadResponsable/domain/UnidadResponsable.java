/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.unidadResponsable.domain;

import com.modules.sirsr.clavePresupuestaria.domain.ClavePresupuestaria;
import com.modules.sirsr.estatus.domain.Estatus;
import com.modules.sirsr.usuario.domain.Usuario;
import com.modules.sirsr.producto.domain.Producto;
import com.modules.sirsr.solicitud.domain.Solicitud;

import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "UNIDAD_RESPONSABLE")
public class UnidadResponsable {

    @Id
    @Basic(optional = false)
    @Column(name = "CLAVE_UR")
    private String claveUr;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "FECHA_FINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinal;
    @JoinColumn(name = "ID_ESTATUS", referencedColumnName = "ID_ESTATUS")
    @ManyToOne(optional = false)
    private Estatus estatus;
    /*
    @JoinTable(name = "PRODUCTO_UNIDADRESP",
            joinColumns = @JoinColumn(name = "PRODUNIDRESP_UNIDADRESP_FK", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "PRODUNIRESP_PRODUCTO_FK", nullable = false))
    @ManyToMany
    private List<Producto> productos;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadResponsable")
    private List<ClavePresupuestaria> clavesPresupuestarias;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadResponsable")
    private List<Usuario> usuarios;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadResponsable")
    private List<Solicitud> solicitudes;
*/
    public String getClaveUr() {
        return claveUr;
    }

    public void setClaveUr(String claveUr) {
        this.claveUr = claveUr;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Estatus getEstatus() {
        return estatus;
    }

    public void setEstatus(Estatus estatus) {
        this.estatus = estatus;
    }

}
