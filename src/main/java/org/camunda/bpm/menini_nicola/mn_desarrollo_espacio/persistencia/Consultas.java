package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia;

public class Consultas {
	
	public String obtenerClientesPresupuestoAprobado() {
		//String consulta ="SELECT cli.nombre FROM mn_cliente cli INNER JOIN mn_cliente_presupuesto cp ON cli.idCliente = cp.idCliente AND cp.estado=1;";
		String consulta = "SELECT CONCAT(pre.cotizacion,' : ' ,cli.nombre) AS nombre FROM mn_cliente cli INNER JOIN mn_cliente_presupuesto cp ON cli.idCliente = cp.idCliente AND cp.estado=1 INNER JOIN mn_presupuesto pre ON pre.idPresupuesto = cp.idPresupuesto;";
		return consulta;	
	}
	
	public String obtenerCostoPresupuesto() {
		String consulta ="select moneda, costo from mn_presupuesto where cotizacion =?;";
		return consulta;				
	}
	
}
