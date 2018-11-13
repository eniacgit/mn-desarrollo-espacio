package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.valueObjects.VOPresupuesto;
import org.jfree.util.Log;

public class DAOPresupuesto {

	public VOPresupuesto obtenerCostoPresupuesto(String cotizacion) {
		AccesoBD accesoBD = new AccesoBD();		
		Connection con = accesoBD.conectarBD();
		Consultas consultas = new Consultas();
		VOPresupuesto presupuesto = new VOPresupuesto();
		
		String strPresupuesto = consultas.obtenerCostoPresupuesto();
		
		PreparedStatement pstmt=null;
		try {
			pstmt = con.prepareStatement(strPresupuesto);
			pstmt.setString(1, cotizacion); 	
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			presupuesto.setMoneda(rs.getString("moneda"));
			presupuesto.setCosto(rs.getFloat("costo"));			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		finally {
			try {
				pstmt.close();
				accesoBD.desconectarBD(con);
			} catch (SQLException e) {
				Log.error(e + "ERROR 2");
				System.out.println(">> ERROR 2");
				e.printStackTrace();
			}			
		}		
		return presupuesto;		
	}
	
	
	
}
