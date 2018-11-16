package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.modelo;

import java.util.Date;

public class CronoPresupuestacion {
	
	protected Date scoutProdFechInicio;
	protected Date scoutProdFechFin;
	protected int scoutProdHoras;
	protected Date selecProvFechInicio;
	protected Date selecProvFechFin;
	protected int selecProvHoras;
	
	public CronoPresupuestacion() {
		super();	
	}

	public CronoPresupuestacion(Date scoutProdFechInicio, Date scoutProdFechFin, int scoutProdHoras,
			Date selecProvFechInicio, Date selecProvFechFin, int selecProvHoras) {
		super();
		this.scoutProdFechInicio = scoutProdFechInicio;
		this.scoutProdFechFin = scoutProdFechFin;
		this.scoutProdHoras = scoutProdHoras;
		this.selecProvFechInicio = selecProvFechInicio;
		this.selecProvFechFin = selecProvFechFin;
		this.selecProvHoras = selecProvHoras;
	}

	public Date getScoutProdFechInicio() {
		return scoutProdFechInicio;
	}

	public void setScoutProdFechInicio(Date scoutProdFechInicio) {
		this.scoutProdFechInicio = scoutProdFechInicio;
	}

	public Date getScoutProdFechFin() {
		return scoutProdFechFin;
	}

	public void setScoutProdFechFin(Date scoutProdFechFin) {
		this.scoutProdFechFin = scoutProdFechFin;
	}

	public int getScoutProdHoras() {
		return scoutProdHoras;
	}

	public void setScoutProdHoras(int scoutProdHoras) {
		this.scoutProdHoras = scoutProdHoras;
	}

	public Date getSelecProvFechInicio() {
		return selecProvFechInicio;
	}

	public void setSelecProvFechInicio(Date selecProvFechInicio) {
		this.selecProvFechInicio = selecProvFechInicio;
	}

	public Date getSelecProvFechFin() {
		return selecProvFechFin;
	}

	public void setSelecProvFechFin(Date selecProvFechFin) {
		this.selecProvFechFin = selecProvFechFin;
	}

	public int getSelecProvHoras() {
		return selecProvHoras;
	}

	public void setSeletProvHoras(int selecProvHoras) {
		this.selecProvHoras = selecProvHoras;
	}	
	
}
