package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio;

import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia.AccesoBD;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia.DAOPresupuesto;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.valueObjects.VOPresupuesto;

public class Test {

	public static void main(String[] args) {
		DAOPresupuesto dao = new DAOPresupuesto();
		//System.out.println(a.obtenerClientesPresupuestoAprobado());
		
		VOPresupuesto presupuesto = dao.obtenerCostoPresupuesto("181012-02");
		System.out.println("monedda: " + presupuesto.getMoneda());
		System.out.println("costo: " + presupuesto.getCosto());
		

	}

}
