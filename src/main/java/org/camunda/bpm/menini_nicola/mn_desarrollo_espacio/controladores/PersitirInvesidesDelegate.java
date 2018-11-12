package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.controladores;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.impl.bpmn.delegate.ExecutionListenerInvocation;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.modelo.CronoInvesIdes;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia.DAOCronoInvesIdes;

public class PersitirInvesidesDelegate implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		CronoInvesIdes dataCronoInvesIdes = new CronoInvesIdes();
		dataCronoInvesIdes=(CronoInvesIdes)execution.getVariable("dataCronInvesIdes");
		
		DAOCronoInvesIdes dao = new DAOCronoInvesIdes();
		dao.insertarCronogramaInvestigacionYDesarrollo(dataCronoInvesIdes);
		
		
	}

}
