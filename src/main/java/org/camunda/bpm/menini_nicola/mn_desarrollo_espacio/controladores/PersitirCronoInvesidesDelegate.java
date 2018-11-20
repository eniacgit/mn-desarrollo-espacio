package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.controladores;

import java.util.Date;
import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.impl.bpmn.delegate.ExecutionListenerInvocation;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.logica.Fachada;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.logica.IFachada;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.modelo.CronoInvesIdes;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia.DAOCronoInvesIdes;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.valueObjects.VOCronoInvesIdes;

public class PersitirCronoInvesidesDelegate implements JavaDelegate{
	
	private final static Logger LOG = Logger.getLogger(PersitirCronoInvesidesDelegate.class.getName());

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		IFachada iFachada = Fachada.getSingletonInstance();
		CronoInvesIdes dataCronoInvesIdes=(CronoInvesIdes)execution.getVariable("dataCronInvesIdes");
		
		VOCronoInvesIdes voCrongrama = new VOCronoInvesIdes();
		
		voCrongrama.setAnMarcaFechInicio(dataCronoInvesIdes.getAjInterFechInicio());
    	voCrongrama.setAnMarcaFechFin(dataCronoInvesIdes.getAjInterFechFin());
    	voCrongrama.setAnMarcaHoras(dataCronoInvesIdes.getAnMarcaHoras());
    	voCrongrama.setAjInterFechFin(dataCronoInvesIdes.getAjInterFechFin());
    	voCrongrama.setDesConcepFechInicio(dataCronoInvesIdes.getDesConcepFechInicio());    	
    	voCrongrama.setDesConcepFechFin(dataCronoInvesIdes.getDesConcepFechFin());
    	voCrongrama.setDesConcepHoras(dataCronoInvesIdes.getDesConcepHoras());
    	voCrongrama.setDesPropFechInicio(dataCronoInvesIdes.getDesPropFechInicio());
    	voCrongrama.setDesPropFechFin(dataCronoInvesIdes.getDesPropFechFin());
    	voCrongrama.setDesPropHoras(dataCronoInvesIdes.getDesPropHoras());
    	voCrongrama.setAjInterFechInicio(dataCronoInvesIdes.getAjInterFechInicio());
    	voCrongrama.setAjInterFechFin(dataCronoInvesIdes.getAjInterFechFin());
    	voCrongrama.setAjInterHoras(dataCronoInvesIdes.getAjInterHoras());    	
						
    	int rowCount = iFachada.insertarCronogramaInvestigacionYDesarrollo(voCrongrama);
		
    	if (rowCount > 0)
			LOG.info("\n## Se insertó cronograma de investigación y desarrollo en la BD.\nCantidad de registros afectados: " + rowCount);
		else
			LOG.info("\n## Cantidad de registros afectados: " + rowCount + "\nNo se insertó cronograma de investigación y desarrollo en la BD");
    	
    	// almaceno en una variable de proceso el último indice de la tabla mn_crono_invesydes	
		//int idCronoInvestides = iFachada.obtenerUltimoIndiceInsertadoCronoInvestides();
		//execution.setVariable("idCronoInvestides", idCronoInvestides);
		
		// almaceno la cantidad total de horas de la etapa de investigación y desarrollo que usaré en el resumen final
		//int totalHorasInvesIdes = voCrongrama.getAnMarcaHoras() + voCrongrama.getDesConcepHoras() + voCrongrama.getDesPropHoras() +voCrongrama.getAjInterHoras();
		//execution.setVariable("totalHorasInvesIdes", totalHorasInvesIdes);
	}

}
