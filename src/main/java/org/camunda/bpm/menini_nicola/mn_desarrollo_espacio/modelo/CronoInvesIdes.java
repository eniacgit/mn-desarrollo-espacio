package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.modelo;

import java.sql.Date;

public class CronoInvesIdes {
	
	Date fechIni;
	Date fechFin;
	int horas;
	
	
	
	public CronoInvesIdes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CronoInvesIdes(Date fechIni, Date fechFin, int horas) {
		super();
		this.fechIni = fechIni;
		this.fechFin = fechFin;
		this.horas = horas;
	}

	public Date getFechIni() {
		return fechIni;
	}

	public void setFechIni(Date fechIni) {
		this.fechIni = fechIni;
	}

	public Date getFechFin() {
		return fechFin;
	}

	public void setFechFin(Date fechFin) {
		this.fechFin = fechFin;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}
	
	
	
	
}
