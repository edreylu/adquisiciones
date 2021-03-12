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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "PROVEEDOR")
public class Proveedor{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "proveedor_generator")
    @SequenceGenerator(name = "proveedor_generator", sequenceName = "ADQUISICIONES.SEQ_PROVEEDOR", allocationSize = 1)
    @Column(name = "ID_PROVEEDOR", nullable = false)
    private Integer idProveedor;
    @Basic(optional = false)
    @Column(name = "RFC")
    private String rfc;
    @Basic(optional = false)
    @Column(name = "RAZON_SOCIAL")
    private String razonSocial;
    @Column(name = "NOMBRE_COMERCIAL")
    private String nombreComercial;
    @Column(name = "PROPIETARIO")
    private String propietario;
    @Column(name = "REPRESENTANTE")
    private String representante;
    @Column(name = "TELEFONO1")
    private Integer telefono1;
    @Column(name = "TELEFONO2")
    private Integer telefono2;
    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;
    @Column(name = "DOMICILIO")
    private String domicilio;
    @Column(name = "CODIGO_POSTAL")
    private Integer codigoPostal;
    @JoinColumn(name = "ID_ESTATUS", referencedColumnName = "ID_ESTATUS")
    @ManyToOne(optional = false)
    private Estatus estatus;
    @JoinColumn(name = "ID_TIPO_PERSONA_FISCAL", referencedColumnName = "ID_TIPO_PERSONA_FISCAL")
    @ManyToOne(optional = false)
    private TipoPersonaFiscal tipoPersonaFiscal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proveedor")
    private List<CotizaRequisicion> cotizaRequisiciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proveedor")
    private List<InvitacionACotizarRequis> invitacionesACotizarRequis;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proveedor")
    private List<CotizaConsolidacion> cotizaConsolidaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proveedor")
    private List<InvitacionACotizarConsolida> invitacionesACotizarConsolida;

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
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

    public Estatus getEstatus() {
        return estatus;
    }

    public void setEstatus(Estatus estatus) {
        this.estatus = estatus;
    }

    public TipoPersonaFiscal getTipoPersonaFiscal() {
        return tipoPersonaFiscal;
    }

    public void setTipoPersonaFiscal(TipoPersonaFiscal tipoPersonaFiscal) {
        this.tipoPersonaFiscal = tipoPersonaFiscal;
    }

    public List<CotizaRequisicion> getCotizaRequisiciones() {
        return cotizaRequisiciones;
    }

    public void setCotizaRequisiciones(List<CotizaRequisicion> cotizaRequisiciones) {
        this.cotizaRequisiciones = cotizaRequisiciones;
    }

    public List<InvitacionACotizarRequis> getInvitacionesACotizarRequis() {
        return invitacionesACotizarRequis;
    }

    public void setInvitacionesACotizarRequis(List<InvitacionACotizarRequis> invitacionesACotizarRequis) {
        this.invitacionesACotizarRequis = invitacionesACotizarRequis;
    }

    public List<CotizaConsolidacion> getCotizaConsolidaciones() {
        return cotizaConsolidaciones;
    }

    public void setCotizaConsolidaciones(List<CotizaConsolidacion> cotizaConsolidaciones) {
        this.cotizaConsolidaciones = cotizaConsolidaciones;
    }

    public List<InvitacionACotizarConsolida> getInvitacionesACotizarConsolida() {
        return invitacionesACotizarConsolida;
    }

    public void setInvitacionesACotizarConsolida(List<InvitacionACotizarConsolida> invitacionesACotizarConsolida) {
        this.invitacionesACotizarConsolida = invitacionesACotizarConsolida;
    }

    
}
