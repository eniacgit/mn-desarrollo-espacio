package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.test;

import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia.AccesoBD;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.valueObjects.VOPresupuesto;

public class Test {

	public static void main(String[] args) {
		AccesoBD a = new AccesoBD();
		//System.out.println(a.obtenerClientesPresupuestoAprobado());
		
		VOPresupuesto presupuesto = a.obtenerCostoPresupuesto("181105-02");
		System.out.println("monedda: " + presupuesto.getMoneda());
		System.out.println("costo: " + presupuesto.getCosto());
		

	}

}
