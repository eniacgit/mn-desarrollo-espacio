package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.logica;

import java.util.ArrayList;

import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia.AccesoBD;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.valueObjects.VOPresupuesto;

public class Fachada {
	
	public ArrayList obtenerClientesPresupuestoAprobado() {
		AccesoBD accesoBD = new AccesoBD();
		return accesoBD.obtenerClientesPresupuestoAprobado();
	}
	
	public VOPresupuesto obtenerCostoPresupuesto(String cotizacion) {
		AccesoBD accesoBD = new AccesoBD();
		return accesoBD.obtenerCostoPresupuesto(cotizacion);
	}
}
