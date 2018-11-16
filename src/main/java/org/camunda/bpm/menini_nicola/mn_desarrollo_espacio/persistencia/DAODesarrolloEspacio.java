package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.modelo.DesarrolloEspacio;
import org.jfree.util.Log;

public class DAODesarrolloEspacio {

	public int insertarDesarrolloEspacio(DesarrolloEspacio espacio) {
		AccesoBD accesoBD = new AccesoBD();		
		Connection con = accesoBD.conectarBD();
		Consultas consultas = new Consultas();
		
		String insert=consultas.insertarDesarrolloEspacio(); 
		PreparedStatement pstmt = null;
		int rowCount=0;
		
		try {
			pstmt =con.prepareStatement(insert);			
			pstmt.setString(1, espacio.getCotizacion());
			pstmt.setInt(2, espacio.getIdCliente());
			pstmt.setInt(3, espacio.getValorHora());
			pstmt.setInt(4, espacio.getIdCronoInvestides());
			pstmt.setInt(5, espacio.getIdCronoPresupuestacion());
			pstmt.setInt(6, espacio.getIdCronoCierreProp());
			rowCount=pstmt.executeUpdate();			
		} catch (SQLException e) {
			Log.error(e + "EEROR 1");
			System.out.println(">> Tipo de datos incorrectos");
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
		return rowCount;		
	}
}
