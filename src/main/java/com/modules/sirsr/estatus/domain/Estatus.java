/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.estatus.domain;

import com.modules.sirsr.capitulo.domain.Capitulo;
import com.modules.sirsr.clavePresupuestaria.domain.ClavePresupuestaria;
import com.modules.sirsr.concepto.domain.Concepto;
import com.modules.sirsr.consolidacion.domain.Consolidacion;
import com.modules.sirsr.cotizaConsolidacion.domain.CotizaConsolidacion;
import com.modules.sirsr.cotizaRequisicion.domain.CotizaRequisicion;
import com.modules.sirsr.invitacionACotizarConsolida.domain.InvitacionACotizarConsolida;
import com.modules.sirsr.invitacionACotizarRequis.domain.InvitacionACotizarRequis;
import com.modules.sirsr.marca.domain.Marca;
import com.modules.sirsr.montoAdjudicacion.domain.MontoAdjudicacion;
import com.modules.sirsr.objetoGasto.domain.ObjetoDeGasto;
import com.modules.sirsr.partidaGastoGenerica.domain.PartidaGastoGenerica;
import com.modules.sirsr.prioridad.domain.Prioridad;
import com.modules.sirsr.producto.domain.Producto;
import com.modules.sirsr.proveedor.domain.Proveedor;
import com.modules.sirsr.requisicion.domain.Requisicion;
import com.modules.sirsr.seguimientoSolicitud.domain.SeguimientoSolicitud;
import com.modules.sirsr.solicitud.domain.Solicitud;
import com.modules.sirsr.subTipoProducto.domain.SubTipoProducto;
import com.modules.sirsr.tipoDocumento.domain.TipoDocumento;
import com.modules.sirsr.tipoProducto.domain.TipoProducto;
import com.modules.sirsr.unidadMedida.domain.UnidadMedida;
import com.modules.sirsr.unidadResponsable.domain.UnidadResponsable;
import com.modules.sirsr.usuario.domain.Usuario;

import java.util.List;
import javax.persistence.*;

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
}
