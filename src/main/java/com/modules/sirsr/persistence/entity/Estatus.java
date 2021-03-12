/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.persistence.entity;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "ESTATUS")
public class Estatus {

    @Id
    @Basic(optional = false)
    @Column(name = "ID_ESTATUS")
    private Integer idEstatus;
    @Column(name = "CLAVE")
    private String clave;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "COLORHEX")
    private String colorhex;
    @Column(name = "EXPLICACION")
    private String explicacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatus")
    private List<Proveedor> proveedors;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatus")
    private List<Marca> marcas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatus")
    private List<Capitulo> capitulos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatus")
    private List<Requisicion> requisiciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatus")
    private List<Consolidacion> consolidaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatus")
    private List<SeguimientoSolicitud> seguimientoSolicitudes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatus")
    private List<UnidadMedida> unidadesMedida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatus")
    private List<ClavePresupuestaria> clavesPresupuestarias;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatus")
    private List<TipoDocumento> tiposDocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatus")
    private List<CotizaRequisicion> cotizaRequisiciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatus")
    private List<Concepto> conceptos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatus")
    private List<InvitacionACotizarRequis> invitacionesACotizar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatus")
    private List<Usuario> usuarios;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatus")
    private List<ObjetoDeGasto> objetosDeGasto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatus")
    private List<Solicitud> solicitudes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatus")
    private List<Producto> productos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatus")
    private List<MontoAdjudicacion> montosAdjudicacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatus")
    private List<PartidaGastoGenerica> partidasGastoGenerica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatus")
    private List<TipoProducto> tiposProducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatus")
    private List<Prioridad> prioridades;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatus")
    private List<CotizaConsolidacion> cotizaConsolidaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatus")
    private List<SubTipoProducto> subTiposProducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatus")
    private List<UnidadResponsable> unidadesResponsables;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatus")
    private List<InvitacionACotizarConsolida> invitacionesACotizarConsolida;

    public Integer getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(Integer idEstatus) {
        this.idEstatus = idEstatus;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getColorhex() {
        return colorhex;
    }

    public void setColorhex(String colorhex) {
        this.colorhex = colorhex;
    }

    public String getExplicacion() {
        return explicacion;
    }

    public void setExplicacion(String explicacion) {
        this.explicacion = explicacion;
    }

    public List<Proveedor> getProveedors() {
        return proveedors;
    }

    public void setProveedors(List<Proveedor> proveedors) {
        this.proveedors = proveedors;
    }

    public List<Marca> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }

    public List<Capitulo> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(List<Capitulo> capitulos) {
        this.capitulos = capitulos;
    }

    public List<Requisicion> getRequisiciones() {
        return requisiciones;
    }

    public void setRequisiciones(List<Requisicion> requisiciones) {
        this.requisiciones = requisiciones;
    }

    public List<Consolidacion> getConsolidaciones() {
        return consolidaciones;
    }

    public void setConsolidaciones(List<Consolidacion> consolidaciones) {
        this.consolidaciones = consolidaciones;
    }

    public List<SeguimientoSolicitud> getSeguimientoSolicitudes() {
        return seguimientoSolicitudes;
    }

    public void setSeguimientoSolicitudes(List<SeguimientoSolicitud> seguimientoSolicitudes) {
        this.seguimientoSolicitudes = seguimientoSolicitudes;
    }

    public List<UnidadMedida> getUnidadesMedida() {
        return unidadesMedida;
    }

    public void setUnidadesMedida(List<UnidadMedida> unidadesMedida) {
        this.unidadesMedida = unidadesMedida;
    }

    public List<ClavePresupuestaria> getClavesPresupuestarias() {
        return clavesPresupuestarias;
    }

    public void setClavesPresupuestarias(List<ClavePresupuestaria> clavesPresupuestarias) {
        this.clavesPresupuestarias = clavesPresupuestarias;
    }

    public List<TipoDocumento> getTiposDocumento() {
        return tiposDocumento;
    }

    public void setTiposDocumento(List<TipoDocumento> tiposDocumento) {
        this.tiposDocumento = tiposDocumento;
    }

    public List<CotizaRequisicion> getCotizaRequisiciones() {
        return cotizaRequisiciones;
    }

    public void setCotizaRequisiciones(List<CotizaRequisicion> cotizaRequisiciones) {
        this.cotizaRequisiciones = cotizaRequisiciones;
    }

    public List<Concepto> getConceptos() {
        return conceptos;
    }

    public void setConceptos(List<Concepto> conceptos) {
        this.conceptos = conceptos;
    }

    public List<InvitacionACotizarRequis> getInvitacionesACotizar() {
        return invitacionesACotizar;
    }

    public void setInvitacionesACotizar(List<InvitacionACotizarRequis> invitacionesACotizar) {
        this.invitacionesACotizar = invitacionesACotizar;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<ObjetoDeGasto> getObjetosDeGasto() {
        return objetosDeGasto;
    }

    public void setObjetosDeGasto(List<ObjetoDeGasto> objetosDeGasto) {
        this.objetosDeGasto = objetosDeGasto;
    }

    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<MontoAdjudicacion> getMontosAdjudicacion() {
        return montosAdjudicacion;
    }

    public void setMontosAdjudicacion(List<MontoAdjudicacion> montosAdjudicacion) {
        this.montosAdjudicacion = montosAdjudicacion;
    }

    public List<PartidaGastoGenerica> getPartidasGastoGenerica() {
        return partidasGastoGenerica;
    }

    public void setPartidasGastoGenerica(List<PartidaGastoGenerica> partidasGastoGenerica) {
        this.partidasGastoGenerica = partidasGastoGenerica;
    }

    public List<TipoProducto> getTiposProducto() {
        return tiposProducto;
    }

    public void setTiposProducto(List<TipoProducto> tiposProducto) {
        this.tiposProducto = tiposProducto;
    }

    public List<Prioridad> getPrioridades() {
        return prioridades;
    }

    public void setPrioridades(List<Prioridad> prioridades) {
        this.prioridades = prioridades;
    }

    public List<CotizaConsolidacion> getCotizaConsolidaciones() {
        return cotizaConsolidaciones;
    }

    public void setCotizaConsolidaciones(List<CotizaConsolidacion> cotizaConsolidaciones) {
        this.cotizaConsolidaciones = cotizaConsolidaciones;
    }

    public List<SubTipoProducto> getSubTiposProducto() {
        return subTiposProducto;
    }

    public void setSubTiposProducto(List<SubTipoProducto> subTiposProducto) {
        this.subTiposProducto = subTiposProducto;
    }

    public List<UnidadResponsable> getUnidadesResponsables() {
        return unidadesResponsables;
    }

    public void setUnidadesResponsables(List<UnidadResponsable> unidadesResponsables) {
        this.unidadesResponsables = unidadesResponsables;
    }

    public List<InvitacionACotizarConsolida> getInvitacionesACotizarConsolida() {
        return invitacionesACotizarConsolida;
    }

    public void setInvitacionesACotizarConsolida(List<InvitacionACotizarConsolida> invitacionesACotizarConsolida) {
        this.invitacionesACotizarConsolida = invitacionesACotizarConsolida;
    }

    public Estatus() {
    }

    

    
}
