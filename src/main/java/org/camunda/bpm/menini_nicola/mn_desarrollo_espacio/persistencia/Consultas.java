package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia;

public class Consultas {
	
	// CONSULTAS TABLA: mn_cliente, mn_cliente_presupuesto, mn_presupuesto
	public String obtenerClientesPresupuestoAprobado() {
		//String consulta = "SELECT CONCAT(pre.cotizacion,' : ' ,cli.nombre) AS nombre FROM mn_cliente cli INNER JOIN mn_cliente_presupuesto cp ON cli.idCliente = cp.idCliente AND cp.estado=1 INNER JOIN mn_presupuesto pre ON pre.idPresupuesto = cp.idPresupuesto;";
		String consulta ="SELECT CONCAT(pre.cotizacion,' : ' ,cli.nombre) AS nombre FROM mn_cliente cli INNER JOIN mn_cliente_presupuesto cp ON cli.idCliente = cp.idCliente AND cp.estado=1 INNER JOIN mn_presupuesto pre ON pre.idPresupuesto = cp.idPresupuesto INNER JOIN mn_espacio esp ON esp.idPresupuesto = cp.idPresupuesto;";
		return consulta;	
	}
	
	// CONSULTAS TABLA: mn_presupuesto
	public String obtenerCostoPresupuesto() {		
		//String consulta ="SELECT * FROM mn_presupuesto WHERE cotizacion =?;";
		String consulta ="SELECT costo FROM mn_presupuesto WHERE cotizacion =?;";
		return consulta;				
	}
	
	public String obtenerIdPresupuesto() {
		String consulta = "select idPresupuesto from mn_presupuesto where cotizacion =?;";
		return consulta;
	}
	

	// CONSULTAS TABLA: mn_crono_invesydes	
	public String insertarCronogramaInvestigacionYDesarrollo() {
		String consulta ="INSERT INTO mn_crono_invesydes (anMarcaFechInicio,anMarcaFechFin, anMarcaHoras, desConcepFechInicio, desConcepFechFin, desConcepHoras, desPropFechInicio, desPropFechFin, desPropHoras, ajInterFechInicio, ajInterFechFin, ajInterHoras) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
		return consulta;
	}
	
	public String obtenerUltimoIndiceInsertadoCronoInvestides() {
		String consulta ="SELECT MAX(idCronoInvestides) AS id FROM mn_crono_invesydes;";
		return consulta;
	}	
	
	
	// CONSULTAS TABLA: mn_crono_presupuestacion
	public String insertarCronogramaPresupuestacion() {
		String consulta ="INSERT INTO mn_crono_presupuestacion (scoutProdFechInicio,scoutProdFechFin,scoutProdHoras, selecProvFechInicio, selecProvFechFin, selecProvHoras) VALUES(?,?,?,?,?,?);";
		return consulta;
	}
	
	public String obtenerUltimoIndiceInsertadoCronoPresupuestacion() {
		String consulta ="SELECT MAX(idCronoPresupuestacion) AS id FROM mn_crono_presupuestacion;";
		return consulta;
	}
	
	
	// CONSULTAS TABLA: mn_crono_cierre_Prop
		public String insertarCronogramaCierrePropuesta() {
			String consulta ="INSERT INTO mn_crono_cierre_Prop (proyCerrFechInicio, proyCerrFechFin, proyCerrHoras) VALUES(?,?,?);";
			return consulta;
		}
		
		public String obtenerUltimoIndiceInsertadoCronoCierrePropuesta() {
			String consulta ="SELECT MAX(idCronoCierreProp) AS id FROM mn_crono_cierre_Prop;";
			return consulta;
		}
	
		// CONSULTAS TABLA: mn_cliente
		public String obtenerIdCliente() {
			String consulta ="SELECT idCliente FROM mn_cliente WHERE nombre=?;";
			return consulta;
		}
	
	//CONSULTAS TABLA: mn_desarrollo_espacio
	public String insertarDesarrolloEspacio() {
		String consulta ="INSERT INTO mn_desarrollo_espacio (cotizacion, idCliente, valorHora, idCronoInvestides, idCronoPresupuestacion, idCronoCierreProp) VALUES (?,?,?,?,?,?);";
	 	return consulta;
	}
	
	
	public String updateEstadoPresupuesto()
	{
		String update="update mn_cliente_presupuesto set estado=? where idPresupuesto=?;";
		return update;
	}
	
	
	
	
	
	
}
