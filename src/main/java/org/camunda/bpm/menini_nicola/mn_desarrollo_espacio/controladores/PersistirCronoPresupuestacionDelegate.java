package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.controladores;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.logica.Fachada;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.logica.IFachada;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.modelo.CronoPresupuestacion;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.valueObjects.VOCronoPresupuestacion;

public class PersistirCronoPresupuestacionDelegate implements JavaDelegate{
	
	private final static Logger LOG = Logger.getLogger(PersistirCronoPresupuestacionDelegate.class.getName());

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		IFachada iFachada = Fachada.getSingletonInstance();
		CronoPresupuestacion dataCronoPresupuestacion = (CronoPresupuestacion) execution.getVariable("dataCronoPresupuestacion");
		
		VOCronoPresupuestacion voCrongrama = new VOCronoPresupuestacion();
		
		voCrongrama.setScoutProdFechInicio(dataCronoPresupuestacion.getScoutProdFechInicio());
    	voCrongrama.setScoutProdFechFin(dataCronoPresupuestacion.getScoutProdFechFin());
    	voCrongrama.setScoutProdHoras(dataCronoPresupuestacion.getScoutProdHoras());
    	voCrongrama.setSelecProvFechInicio(dataCronoPresupuestacion.getSelecProvFechInicio());
    	voCrongrama.setSelecProvFechFin(dataCronoPresupuestacion.getSelecProvFechFin());
    	voCrongrama.setScoutProdHoras(dataCronoPresupuestacion.getScoutProdHoras());
		
		int rowCount = iFachada.insertarCronogramaPresupuestacion(voCrongrama);
		
		if (rowCount > 0)
			LOG.info("\n## Se insertó cronograma de presupuestación en la BD.\nCantidad de registros afectados: " + rowCount);
		else
			LOG.info("\n## Cantidad de registros afectados: " + rowCount + "\nNo se insertó cronograma de presupuestacion en la BD");
		
		// almaceno en una variable de proceso el último indice de la tabla mn_crono_presupuestacion	
		//int idCronoPresupuestacion = iFachada.obtenerUltimoIndiceInsertadoCronoPresupuestacion();
		//execution.setVariable("idCronoPresupuestacion", idCronoPresupuestacion);
		
		// almaceno la cantidad total de horas de la etapa de presupuestacion que usare en el resumen final
		//int totalHorasPresupuestacion = voCrongrama.getScoutProdHoras() + voCrongrama.getSelecProvHoras();
		//execution.setVariable("totalHorasPresupuestacion", totalHorasPresupuestacion);
	}

}
