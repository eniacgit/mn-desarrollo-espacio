package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.controladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.logica.Fachada;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.logica.IFachada;

public class CargarPresupuestosAprobadosDelegate implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		// Se obtiene listado de clientes con presupuesto aprobado
		IFachada iFachada = Fachada.getSingletonInstance();
		ArrayList listaClientes= iFachada.obtenerClientesPresupuestoAprobado();
		
		
		if (listaClientes.size() > 0) {
		
			// Se convierte lista de clientes a HashMap
			// el formulario de SDK trabaja con HashMap
			Integer i=0;
			Map<Integer,String> presupuestosMap = new HashMap<Integer,String>();
			
			while(i< listaClientes.size()){
				presupuestosMap.put(i, (String)listaClientes.get(i));
				i++;
			}
			
			// Serializar datos de HashMap a json
			ObjectValue presupuestosDataValue = Variables.objectValue(presupuestosMap)
					.serializationDataFormat(Variables.SerializationDataFormats.JSON)
					.create();
			
			// bindear datos de HashMap (a JSON) sobre el control select del formulario
			execution.setVariable("PRESUPUESTOS_APROBADOS", presupuestosDataValue);
		}else {
			
			Map<Integer, String> presupuestoNulo = new HashMap<Integer,String>();
			String textoSelect="--No hay presupuestos aprobados--";
			Integer indiceSelect = 0;
			
			presupuestoNulo.put(indiceSelect, textoSelect);
			
			// Serializar datos de HashMap a json
			ObjectValue presupuestosDatosDataValue = Variables.objectValue(presupuestoNulo)
					.serializationDataFormat(Variables.SerializationDataFormats.JSON)
					.create();
			
			// bindear HashMap serializado (a json) sobre el control 'select' del formulario seleccinarPresupuesto-form
			execution.setVariable("PRESUPUESTOS_APROBADOS", presupuestosDatosDataValue);
			execution.setVariable("cancelarProduccion", (boolean)true);
		}
		
	}

}
