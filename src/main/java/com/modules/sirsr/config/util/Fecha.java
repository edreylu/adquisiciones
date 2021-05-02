package com.modules.sirsr.config.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;

public class Fecha {

	public static String obtenerTextoMes(Date date) { // regresa el mes en texto
		Month month = convertToLocalDateViaMilisecond(date).getMonth();
		return month.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
	}

	public static int obtenerDiaMes(Date date) { // regresa el día del mes
		int dia = convertToLocalDateViaMilisecond(date).getDayOfMonth();
		return dia;
	}

	public static int obtenerMes(Date date) { // regresa el número de mes
		int idMes = convertToLocalDateViaMilisecond(date).getMonthValue();
		return idMes;
	}

	public static LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) { // convierte date a localDate
		return Instant.ofEpochMilli(dateToConvert.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}

}
