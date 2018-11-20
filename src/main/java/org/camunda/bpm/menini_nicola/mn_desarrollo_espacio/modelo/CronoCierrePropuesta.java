package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.modelo;

import java.util.Date;

public class CronoCierrePropuesta {

	protected Date proyCerrFechInicio;
	protected Date proyCerrFechFin;
	protected int proyCerrHoras;
	
	protected int totalHorasInvesIdes;
	
	
	public CronoCierrePropuesta() {
		super();	
	}

	public CronoCierrePropuesta(Date proyCerrFechInicio, Date proyCerrFechFin, int proyCerrFechHoras) {
		super();
		this.proyCerrFechInicio = proyCerrFechInicio;
		this.proyCerrFechFin = proyCerrFechFin;
		this.proyCerrHoras = proyCerrFechHoras;
	}
	
	

	

	public Date getProyCerrFechInicio() {
		return proyCerrFechInicio;
	}

	public void setProyCerrFechInicio(Date proyCerrFechInicio) {
		this.proyCerrFechInicio = proyCerrFechInicio;
	}

	public Date getProyCerrFechFin() {
		return proyCerrFechFin;
	}

	public void setProyCerrFechFin(Date proyCerrFechFin) {
		this.proyCerrFechFin = proyCerrFechFin;
	}

	public int getProyCerrHoras() {
		return proyCerrHoras;
	}

	public void setProyCerrHoras(int proyCerrHoras) {
		this.proyCerrHoras = proyCerrHoras;
	}

	public int getTotalHorasInvesIdes() {
		return totalHorasInvesIdes;
	}

	public void setTotalHorasInvesIdes(int totalHorasInvesIdes) {
		this.totalHorasInvesIdes = totalHorasInvesIdes;
	}

	

	
	
}
