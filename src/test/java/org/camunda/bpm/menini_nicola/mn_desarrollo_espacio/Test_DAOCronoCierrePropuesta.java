package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.modelo.CronoCierrePropuesta;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia.DAOCronoCierrePropuesta;

public class Test_DAOCronoCierrePropuesta {

	public static void main(String[] args) throws ParseException {
		
		// Creacion de objeto cronoPresupuestacion
		Date proyCerrFechInicio= new SimpleDateFormat("yyyy-MM-dd").parse("2018-11-13");
		Date proyCerrFechFin= new SimpleDateFormat("yyyy-MM-dd").parse("2018-11-13");
		int proyCerrHoras=88;

		// Persistencia del objeto en la BD
		int rowCount=0;
		
		DAOCronoCierrePropuesta daoCronoCierrePropuesta = new DAOCronoCierrePropuesta();
		CronoCierrePropuesta cronoCierrePropuesta = new CronoCierrePropuesta(proyCerrFechInicio, proyCerrFechFin, proyCerrHoras);
		
		rowCount = daoCronoCierrePropuesta.insertarCronogramaCierrePropuesta(cronoCierrePropuesta);
		
		if (rowCount > 0)
			System.out.println("Se insertó cronograma de cierre en la BD.\nCantidad de registros afectados: " + rowCount);
		else
			System.out.println("Cantidad de registros afectados: " + rowCount + "\nNo se insertó cronograma de cierre en la BD");
		
	
		
		//System.out.println(daoCronoCierrePropuesta.obtenerIdCliente("Bolimar"));
	}

}
