package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.logica;

import java.util.ArrayList;

import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.valueObjects.VOCronoInvesIdes;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.valueObjects.VOPresupuesto;

public interface IFachada {

	// metodos getter y setter
	void insertarCronogramaInvestigacionYDesarrollo(VOCronoInvesIdes voCronograma);

	ArrayList obtenerClientesPresupuestoAprobado();

	VOPresupuesto obtenerCostoPresupuesto(String cotizacion);

}