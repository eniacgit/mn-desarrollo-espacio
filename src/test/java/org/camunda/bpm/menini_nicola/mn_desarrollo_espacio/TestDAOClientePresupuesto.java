package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio;

import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia.DAOClientePresupuesto;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia.DAOPresupuesto;

public class TestDAOClientePresupuesto {

	public static void main(String[] args) {

		DAOClientePresupuesto dao = new DAOClientePresupuesto();
		dao.updateEstadoPresupuesto(39, 2);
		
		DAOPresupuesto dapPresup = new DAOPresupuesto();
		int estadoPresupuesto = 2; // 0 = anulado, 1 = aprobado, 2 = en desarrollo
		String cotizacion = "181213-02";
		int idPresupuesto = dapPresup.obtenerIdPresupuesto(cotizacion);
		System.out.println("idPresupuesto:" + idPresupuesto);
		
		dao.updateEstadoPresupuesto(idPresupuesto, estadoPresupuesto);
		System.out.println("Estado cambiado a 2");
		

	}

}
