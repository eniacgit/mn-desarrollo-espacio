package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.modelo.CronoPresupuestacion;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia.DAOCronoPresupuestacion;

public class Test_DAOPresupuestacion {

	public static void main(String[] args) throws ParseException {
		
		// Creacion de objeto cronoPresupuestacion
		Date scoutProdFechInicio= new SimpleDateFormat("yyyy-MM-dd").parse("2018-11-13");
		Date scoutProdFechFin= (Date) new SimpleDateFormat("yyyy-MM-dd").parse("2018-11-13");
		int scoutProdHoras=88;
		Date selecProvFechInicio= (Date) new SimpleDateFormat("yyyy-MM-dd").parse("2018-11-13");;
		Date selecProvFechFin= (Date) new SimpleDateFormat("yyyy-MM-dd").parse("2018-11-13");;
		int selectProvHoras=88;
		
		// Persistencia del objeto en la BD
		int rowCount=0;
		DAOCronoPresupuestacion daoPresupuestacion =new DAOCronoPresupuestacion();		
		CronoPresupuestacion  cronoPresupuestacion = new CronoPresupuestacion(scoutProdFechInicio,scoutProdFechFin,scoutProdHoras,selecProvFechInicio,selecProvFechFin,selectProvHoras); 
		rowCount = daoPresupuestacion.insertarCronogramaPresupuestacion(cronoPresupuestacion);
		
		if (rowCount > 0)
			System.out.println("Se insertó cronograma de presupuestación en la BD.\nCantidad de registros afectados: " + rowCount);
		else
			System.out.println("Cantidad de registros afectados: " + rowCount + "\nNo se insertó cronograma de presupuestacion en la BD");
			
	}
}
