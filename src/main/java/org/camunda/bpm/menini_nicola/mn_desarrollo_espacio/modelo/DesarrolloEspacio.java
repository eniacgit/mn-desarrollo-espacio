package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.modelo;

public class DesarrolloEspacio {
	
	protected String cotizacion;
	protected int idCliente;
	protected int valorHora;
	protected int idCronoInvestides;
	protected int idCronoPresupuestacion;
	protected int idCronoCierreProp;
	
	public DesarrolloEspacio() {
		super();
	}

	public DesarrolloEspacio(String cotizacion, int idCliente, int valorHora, int idCronoInvestides,
			int idCronoPresupuestacion, int idCronoCierreProp) {
		super();
		this.cotizacion = cotizacion;
		this.idCliente = idCliente;
		this.valorHora = valorHora;
		this.idCronoInvestides = idCronoInvestides;
		this.idCronoPresupuestacion = idCronoPresupuestacion;
		this.idCronoCierreProp = idCronoCierreProp;
	}

	public String getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(String cotizacion) {
		this.cotizacion = cotizacion;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getValorHora() {
		return valorHora;
	}

	public void setValorHora(int valorHora) {
		this.valorHora = valorHora;
	}

	public int getIdCronoInvestides() {
		return idCronoInvestides;
	}

	public void setIdCronoInvestides(int idCronoInvestides) {
		this.idCronoInvestides = idCronoInvestides;
	}

	public int getIdCronoPresupuestacion() {
		return idCronoPresupuestacion;
	}

	public void setIdCronoPresupuestacion(int idCronoPresupuestacion) {
		this.idCronoPresupuestacion = idCronoPresupuestacion;
	}

	public int getIdCronoCierreProp() {
		return idCronoCierreProp;
	}

	public void setIdCronoCierreProp(int idCronoCierreProp) {
		this.idCronoCierreProp = idCronoCierreProp;
	}	
}
