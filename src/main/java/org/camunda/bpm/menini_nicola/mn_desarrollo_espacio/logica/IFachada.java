package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.logica;

import java.util.ArrayList;

import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.valueObjects.VOCronoCierrePropuesta;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.valueObjects.VOCronoInvesIdes;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.valueObjects.VOCronoPresupuestacion;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.valueObjects.VODesarrolloEspacio;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.valueObjects.VOPresupuesto;

public interface IFachada {

	// metodos getter y setter
	int insertarCronogramaInvestigacionYDesarrollo(VOCronoInvesIdes voCronograma);

	ArrayList obtenerClientesPresupuestoAprobado();

	int insertarCronogramaPresupuestacion(VOCronoPresupuestacion voCronograma);

	int insertarCronogramaCierrePropuesta(VOCronoCierrePropuesta voCronograma);

	int obtenerUltimoIndiceInsertadoCronoInvestides();

	int obtenerUltimoIndiceInsertadoCronoPresupuestacion();

	int obtenerUltimoIndiceInsertadoCronoCierrePropuesta();

	int obtenerIdCliente(String nombre);

	int insertarDesarrolloEspacio(VODesarrolloEspacio voEspacio);

	float obtenerCostoPresupuesto(String cotizacion);
	
	



}