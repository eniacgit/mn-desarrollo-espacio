package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.valueObjects;

import java.util.Date;

public class VOCronoCierrePropuesta {

	private Date proyCerrFechInicio;
	private Date proyCerrFechFin;
	private int proyCerrHoras;
	
	public VOCronoCierrePropuesta() {
		super();	
	}

	public VOCronoCierrePropuesta(Date proyCerrFechInicio, Date proyCerrFechFin, int proyCerrFechHoras) {
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

	
}
