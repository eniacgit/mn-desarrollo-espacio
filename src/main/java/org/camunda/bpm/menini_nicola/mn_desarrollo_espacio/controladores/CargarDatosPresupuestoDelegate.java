package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.controladores;

import java.util.ArrayList;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.logica.Fachada;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.logica.IFachada;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.valueObjects.VOPresupuesto;

public class CargarDatosPresupuestoDelegate implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		String valor_hora =(String)execution.getVariable("valorHora");
		execution.setVariable("valorHora", valor_hora);
		
		
		int indiceLista = Integer.parseInt((String)execution.getVariable("cliente"));
		//String indice =(String)execution.getVariable("cliente");
		IFachada iFachada = Fachada.getSingletonInstance();
		ArrayList lista = iFachada.obtenerClientesPresupuestoAprobado();
				
		String nroCotizacion = ((String) lista.get(indiceLista)).replace(" : ", ":"); // quito espacios a los costados del :
		
		// creo un array de strings para almacenar los elementos cotizacion y cliente 
		String[] partes = nroCotizacion.split(":");
		String cotizacion = partes[0];
		String cliente = partes[1];
		
		execution.setVariable("cotizacion", cotizacion);
		execution.setVariable("cliente", cliente);
		
		String strCosto = ""+iFachada.obtenerCostoPresupuesto(cotizacion);
		execution.setVariable("valorPresupuesto", strCosto);
		
		// seteo estado del presupuesto en 2 porque está en desarrollo
		int estadoPresupuesto = 2; // 0 = anulado, 1 = aprobado, 2 = en desarrollo
		int idPresupuesto = iFachada.obtenerIdPresupuesto(cotizacion);
		iFachada.updateEstadoPresupuesto(idPresupuesto, estadoPresupuesto);
	}

}
