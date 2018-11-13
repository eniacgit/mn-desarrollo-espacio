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

public class PersitirInvesidesDelegate implements JavaDelegate{
	
	private final static Logger LOG = Logger.getLogger(PersitirInvesidesDelegate.class.getName());

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
						
		iFachada.insertarCronogramaInvestigacionYDesarrollo(voCrongrama);
		
			
		/*
		LOG.info("\n\n\n   ====> PersitirInvesidesDelegate " + dataCronoInvesIdes+ "\n\n\n");	
		
		Date fecha =dataCronoInvesIdes.getAjInterFechFin();
		int horas = dataCronoInvesIdes.getAjInterHoras();
		
		LOG.info("==> FECHA: " + fecha);
		LOG.info("==> HORAS: " + horas);
		
		
		DAOCronoInvesIdes dao = new DAOCronoInvesIdes();
		dao.insertarCronogramaInvestigacionYDesarrollo(dataCronoInvesIdes);
		*/
		
	}

}
