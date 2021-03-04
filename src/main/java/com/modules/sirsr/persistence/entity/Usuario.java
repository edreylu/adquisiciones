/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.persistence.entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Edward Reyes
 */

@Entity
@Table(name = "USUARIOS", uniqueConstraints = { @UniqueConstraint(name = "USUARIOS_UK", columnNames = "USERNAME") })
public class Usuario {
 
    @Id
    @GeneratedValue
    @Column(name = "NO_USUARIO", nullable = false)
    private Integer noUsuario;
 
    @Column(name = "USERNAME", length = 30, nullable = false)
    private String userName;
 
    @Column(name = "ENCRYPTED_PASSWORD", length = 300, nullable = false)
    private String encrytedPassword;

    @Column(name = "FECHA_AUDITORIA", updatable = false, nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaAuditoria;

    @Column(name = "NO_PERSONAL", insertable = false, updatable = false)
    private Integer noPersonal;

    @Column(name = "CLAVE_UR", insertable = false, updatable = false)
    private String clavaUr;

    @Column(name = "IDESTATUS", length = 2, nullable = true)
    private Integer idEstatus;

    @Column(name = "ENABLED", length = 1, nullable = false)
    private Integer enabled;

    @Column(name = "RESET_PASSWORD_TOKEN", length = 30, nullable = true)
    private String resetPasswordToken;

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioRole> usuariosRoles;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "NO_PERSONAL", nullable = false)
    private Personal personal;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CLAVE_UR", nullable = false)
    private UnidadResponsable unidadResponsable;

    public Integer getNoUsuario() {
        return noUsuario;
    }

    public void setNoUsuario(Integer noUsuario) {
        this.noUsuario = noUsuario;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncrytedPassword() {
        return encrytedPassword;
    }

    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }

    public Calendar getFechaAuditoria() {
        return fechaAuditoria;
    }

    public void setFechaAuditoria(Calendar fechaAuditoria) {
        this.fechaAuditoria = fechaAuditoria;
    }

    public Integer getNoPersonal() {
        return noPersonal;
    }

    public void setNoPersonal(Integer noPersonal) {
        this.noPersonal = noPersonal;
    }

    public Integer getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(Integer idEstatus) {
        this.idEstatus = idEstatus;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }

    public List<UsuarioRole> getUsuariosRoles() {
        return usuariosRoles;
    }

    public void setUsuariosRoles(List<UsuarioRole> usuariosRoles) {
        this.usuariosRoles = usuariosRoles;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public UnidadResponsable getUnidadResponsable() {
        return unidadResponsable;
    }

    public void setUnidadResponsable(UnidadResponsable unidadResponsable) {
        this.unidadResponsable = unidadResponsable;
    }

    public String getClavaUr() {
        return clavaUr;
    }

    public void setClavaUr(String clavaUr) {
        this.clavaUr = clavaUr;
    }
}
