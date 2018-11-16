package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio;

import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.modelo.DesarrolloEspacio;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia.DAODesarrolloEspacio;

public class Test_DAODesarrolloEspacio {

	public static void main(String[] args) {
		
		String cotizacion = "88888-88";
		int idCliente = 2;
		int valorHora = 10;
		int idCronoInvestides = 5;
		int idCronoPresupuestacion =9;
		int idCronoCierreProp = 2;
		
		
		DesarrolloEspacio espacio = new DesarrolloEspacio(cotizacion,idCliente, valorHora, idCronoInvestides, idCronoPresupuestacion, idCronoCierreProp);
		DAODesarrolloEspacio dao = new DAODesarrolloEspacio();
		
		int rowCount = dao.insertarDesarrolloEspacio(espacio);
		

		if (rowCount > 0)
			System.out.println("Se insertó desarrollo espacio en la BD.\nCantidad de registros afectados: " + rowCount);
		else
			System.out.println("Cantidad de registros afectados: " + rowCount + "\nNo se insertó desarrollo espacio en la BD");
		

	}

}
