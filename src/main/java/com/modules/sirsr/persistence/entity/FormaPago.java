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
@Table(name = "FORMA_PAGO")
public class FormaPago {

    @Id
    @Basic(optional = false)
    @Column(name = "ID_FORMA_PAGO")
    private Short idFormaPago;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formaPago")
    private List<InvitacionACotizarRequis> invitacionesACotizarRequis;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formaPago")
    private List<InvitacionACotizarConsolida> invitacionesACotizarConsolida;

    public Short getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(Short idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<InvitacionACotizarRequis> getInvitacionesACotizarRequis() {
        return invitacionesACotizarRequis;
    }

    public void setInvitacionesACotizarRequis(List<InvitacionACotizarRequis> invitacionesACotizarRequis) {
        this.invitacionesACotizarRequis = invitacionesACotizarRequis;
    }

    public List<InvitacionACotizarConsolida> getInvitacionesACotizarConsolida() {
        return invitacionesACotizarConsolida;
    }

    public void setInvitacionesACotizarConsolida(List<InvitacionACotizarConsolida> invitacionesACotizarConsolida) {
        this.invitacionesACotizarConsolida = invitacionesACotizarConsolida;
    }

    
}
