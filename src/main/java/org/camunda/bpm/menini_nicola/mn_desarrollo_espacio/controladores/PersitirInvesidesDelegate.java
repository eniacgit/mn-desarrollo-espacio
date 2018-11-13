package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.controladores;

import java.util.Date;
import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.impl.bpmn.delegate.ExecutionListenerInvocation;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.modelo.CronoInvesIdes;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia.DAOCronoInvesIdes;

public class PersitirInvesidesDelegate implements JavaDelegate{
	
	private final static Logger LOG = Logger.getLogger(PersitirInvesidesDelegate.class.getName());

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		//CronoInvesIdes dataCronoInvesIdes = new CronoInvesIdes(); no es necesario
		CronoInvesIdes dataCronoInvesIdes=(CronoInvesIdes)execution.getVariable("dataCronInvesIdes");
		
		/*
		LOG.info("\n\n\n   ====> PersitirInvesidesDelegate " + dataCronoInvesIdes+ "\n\n\n");	
		
		Date fecha =dataCronoInvesIdes.getAjInterFechFin();
		int horas = dataCronoInvesIdes.getAjInterHoras();
		
		LOG.info("==> FECHA: " + fecha);
		LOG.info("==> HORAS: " + horas);
		*/
		
		DAOCronoInvesIdes dao = new DAOCronoInvesIdes();
		dao.insertarCronogramaInvestigacionYDesarrollo(dataCronoInvesIdes);
		
		
	}

}
