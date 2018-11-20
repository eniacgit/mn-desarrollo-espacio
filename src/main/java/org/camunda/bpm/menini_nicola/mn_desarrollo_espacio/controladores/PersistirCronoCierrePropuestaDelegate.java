package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.controladores;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.logica.Fachada;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.logica.IFachada;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.modelo.CronoCierrePropuesta;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.valueObjects.VOCronoCierrePropuesta;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.valueObjects.VODesarrolloEspacio;

public class PersistirCronoCierrePropuestaDelegate implements JavaDelegate{
	
	private final static Logger LOG = Logger.getLogger(PersistirCronoCierrePropuestaDelegate.class.getName());

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		IFachada iFachada = Fachada.getSingletonInstance();
		CronoCierrePropuesta dataCronoCierrePropuesta = (CronoCierrePropuesta) execution.getVariable("dataCronoCierrePropuesta");
		
		VOCronoCierrePropuesta voCronograma = new VOCronoCierrePropuesta();
		
		voCronograma.setProyCerrFechInicio(dataCronoCierrePropuesta.getProyCerrFechInicio());
    	voCronograma.setProyCerrFechFin(dataCronoCierrePropuesta.getProyCerrFechFin());
    	voCronograma.setProyCerrHoras(dataCronoCierrePropuesta.getProyCerrHoras());
    	
    	int rowCount = iFachada.insertarCronogramaCierrePropuesta(voCronograma);
    	
    	if (rowCount > 0)
			LOG.info("\n## Se insertó cronograma de cierre en la BD.\nCantidad de registros afectados: " + rowCount);
		else
			LOG.info("\n## Cantidad de registros afectados: " + rowCount + "\nNo se insertó cronograma de cierre en la BD");
    	
    	
    	// almaceno en una variable de proceso el último indice de la tabla mn_crono_cierre_Prop	
    	int idCronoCierreProp = iFachada.obtenerUltimoIndiceInsertadoCronoCierrePropuesta();
    	    	
    	// obtengo ultimo indice de la tabla mn_crono_invesydes              
    	int idCronoInvestides = (int) execution.getVariable("idCronoInvestides");

    	// obtengo ultimo indice de la tabla mn_crono_presupuestacion
		int idCronoPresupuestacion = (int) execution.getVariable("idCronoPresupuestacion");
		
				
		// obtengo cotización
		String cotizacion = (String) execution.getVariable("cotizacion");
		
		// Obtengo cliente
		String cliente = (String) execution.getVariable("cliente");
		
		// obtengo el valor de la hora
		String strValorHora =  (String) execution.getVariable("valorHora");
		int valorHora = Integer.parseInt(strValorHora);
		
		//Obtengo id del cliente		
		int idCliente = iFachada.obtenerIdCliente(cliente);
		
		VODesarrolloEspacio voEspacio = new VODesarrolloEspacio();
		voEspacio.setCotizacion(cotizacion);
		voEspacio.setIdCliente(idCliente);
		voEspacio.setValorHora(valorHora);
		voEspacio.setIdCronoInvestides(idCronoInvestides);
		voEspacio.setIdCronoPresupuestacion(idCronoPresupuestacion);
		voEspacio.setIdCronoCierreProp(idCronoCierreProp);
		
		int rowCount2 = iFachada.insertarDesarrolloEspacio(voEspacio);
		
		if (rowCount2 > 0)
			LOG.info("\n## Se insertó desarrollo espacio en la BD.\nCantidad de registros afectados: " + rowCount2);
		else
			LOG.info("\n## Cantidad de registros afectados: " + rowCount2 + "\nNo se insertó desarrollo espacio en la BD");
		
		
		// almaceno la cantidad total de horas de la etapa de cierre de propuesta que usare en el resumen final
		/*int totalHorasCierrePropuesta = voCronograma.getProyCerrHoras();
		execution.setVariable("totalHorasCierrePropuesta", totalHorasCierrePropuesta);
		
		execution.setVariable("prueba", 1000);*/
		
	}

}
