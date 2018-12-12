package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio;

import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.logica.Fachada;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.logica.IFachada;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia.DAOPresupuesto;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.valueObjects.VOPresupuesto;

public class TestDAOPresupuesto {

	public static void main(String[] args) {
		/*IFachada iFachada = Fachada.getSingletonInstance();
		VOPresupuesto presupuesto = iFachada.obtenerCostoPresupuesto("181211-04");
		System.out.println("presupuesto: " + presupuesto.getCosto());*/
		
		DAOPresupuesto presupuesto = new DAOPresupuesto();
		System.out.println("presupuesto: " + presupuesto.obtenerCostoPresupuesto("181211-04"));

	}

}
