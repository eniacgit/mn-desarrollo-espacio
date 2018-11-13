package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.modelo.CronoInvesIdes;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia.DAOCronoInvesIdes;

public class Test_DAOCronInvesides {

	public static void main(String[] args) throws ParseException {

		Date anMarcaFechInicio= new SimpleDateFormat("yyyy-MM-dd").parse("2018-11-13");
		Date anMarcaFechFin= (Date) new SimpleDateFormat("yyyy-MM-dd").parse("2018-11-13");
		int anMarcaHoras=88;
		Date desConcepFechInicio= (Date) new SimpleDateFormat("yyyy-MM-dd").parse("2018-11-13");;
		Date desConcepFechFin= (Date) new SimpleDateFormat("yyyy-MM-dd").parse("2018-11-13");;
		int desConcepHoras=88; 
		Date desPropFechInicio= (Date) new SimpleDateFormat("yyyy-MM-dd").parse("2018-11-13");;
		Date desPropFechFin= (Date) new SimpleDateFormat("yyyy-MM-dd").parse("2018-11-13");;
		int desPropHoras=88;
		Date ajInterFechInicio= (Date) new SimpleDateFormat("yyyy-MM-dd").parse("2018-11-13");;
		Date ajInterFechFin = (Date) new SimpleDateFormat("yyyy-MM-dd").parse("2018-11-13");;
		int ajInterHoras=88;	
		
		System.out.println("Test DAOCronoInvesIdes.");
		
		CronoInvesIdes crono = new CronoInvesIdes(anMarcaFechInicio, anMarcaFechFin, anMarcaHoras, desConcepFechInicio, desConcepFechFin,desConcepHoras, desPropFechInicio, desPropFechFin, desPropHoras, ajInterFechInicio, ajInterFechFin, ajInterHoras);
		DAOCronoInvesIdes dao=new DAOCronoInvesIdes();
		dao.insertarCronogramaInvestigacionYDesarrollo(crono);
		System.out.println("cronograma insertado con exito");
		
	}

}
