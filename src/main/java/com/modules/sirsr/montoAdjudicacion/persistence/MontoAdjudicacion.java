/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.montoAdjudicacion.persistence;

import com.modules.sirsr.estatus.persistence.Estatus;
import com.modules.sirsr.consolidacion.persistence.Consolidacion;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Edward Reyes
 */
@Entity
@Table(name = "MONTO_ADJUDICACION")
public class MontoAdjudicacion {

	@Id
	@Basic(optional = false)
	@Column(name = "ID_MONTO_ADJUDICACION")
	private Integer montoAdjudicacion;
	@Basic(optional = false)
	@Column(name = "TIPO_CONTRATACION")
	private String tipoContratacion;
	@Column(name = "IMPORTE_SUPERIOR_A")
	private BigDecimal importeSuperiorA;
	@Column(name = "IMPORTE_LIMITE")
	private BigDecimal importeLimite;
	@OneToMany(mappedBy = "montoAdjudicacion")
	private List<Consolidacion> consolidaciones;
	@JoinColumn(name = "ID_ESTATUS", referencedColumnName = "ID_ESTATUS")
	@ManyToOne(optional = false)
	private Estatus estatus;

	public Integer getMontoAdjudicacion() {
		return montoAdjudicacion;
	}

	public void setMontoAdjudicacion(Integer montoAdjudicacion) {
		this.montoAdjudicacion = montoAdjudicacion;
	}

	public String getTipoContratacion() {
		return tipoContratacion;
	}

	public void setTipoContratacion(String tipoContratacion) {
		this.tipoContratacion = tipoContratacion;
	}

	public BigDecimal getImporteSuperiorA() {
		return importeSuperiorA;
	}

	public void setImporteSuperiorA(BigDecimal importeSuperiorA) {
		this.importeSuperiorA = importeSuperiorA;
	}

	public BigDecimal getImporteLimite() {
		return importeLimite;
	}

	public void setImporteLimite(BigDecimal importeLimite) {
		this.importeLimite = importeLimite;
	}

	public List<Consolidacion> getConsolidaciones() {
		return consolidaciones;
	}

	public void setConsolidaciones(List<Consolidacion> consolidaciones) {
		this.consolidaciones = consolidaciones;
	}

	public Estatus getEstatus() {
		return estatus;
	}

	public void setEstatus(Estatus estatus) {
		this.estatus = estatus;
	}

}
