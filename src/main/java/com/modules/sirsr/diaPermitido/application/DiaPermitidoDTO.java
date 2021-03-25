package com.modules.sirsr.diaPermitido.application;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;

import com.modules.sirsr.estatus.domain.Estatus;

public class DiaPermitidoDTO {
	

    private Date diaPermitido;
    private Estatus estatus;
    private Integer anio;
    private String mes;
    private Integer dia;

	public Date getDiaPermitido() {
		return diaPermitido;
	}

	public void setDiaPermitido(Date diaPermitido) {
		this.diaPermitido = diaPermitido;
	}

	public Estatus getEstatus() {
		return estatus;
	}

	public void setEstatus(Estatus estatus) {
		this.estatus = estatus;
	}

	

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getMes() {
	
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}
	
	
	
	
	@Override
	public String toString() {
		return "DiaPermitidoDTO [diaPermitido=" + diaPermitido + ", estatus=" + estatus + ", anio=" + anio + ", mes="
				+ mes + ", dia=" + dia + ", getDiaPermitido()=" + getDiaPermitido() + ", getEstatus()=" + getEstatus()
				+ ", getAnio()=" + getAnio() + ", getMes()=" + getMes() + ", getDia()=" + getDia() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	// lo ocupamos para obtener el mes de una fecha en texto
	public String obtenerTextoMes(Date date) {
		Month month =  convertToLocalDateViaMilisecond(date).getMonth();
		return month.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
	}
	
	public int obtenerDia(Date date) {
		int  dia =  convertToLocalDateViaMilisecond(date).getDayOfMonth();
		return dia;
	}
	
	public LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) {
	    return Instant.ofEpochMilli(dateToConvert.getTime())
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}
    
    

}
