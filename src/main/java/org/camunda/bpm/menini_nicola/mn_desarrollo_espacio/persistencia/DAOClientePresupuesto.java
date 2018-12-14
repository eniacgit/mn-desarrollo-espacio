package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import org.jfree.util.Log;

public class DAOClientePresupuesto {

	public int updateEstadoPresupuesto(int idPresupuesto, int estado)
	{
		AccesoBD accesoBD= new AccesoBD();
		Connection con= accesoBD.conectarBD();
		Consultas consultas= new Consultas();
		String select= consultas.updateEstadoPresupuesto();
		PreparedStatement pstmt= null;
		
		int registrosAfectados=0;
		
		try {
			pstmt= con.prepareStatement(select);
			pstmt.setInt(1, estado);
			pstmt.setInt(2, idPresupuesto);
			registrosAfectados=pstmt.executeUpdate();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Log.error(e);
				e.printStackTrace();
			}
		}
		
		return registrosAfectados;
	}
}
