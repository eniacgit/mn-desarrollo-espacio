package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.modelo.CronoInvesIdes;
import org.jfree.util.Log;

public class DAOCronoInvesIdes {

	public void insertarCronogramaInvestigacionYDesarrollo(CronoInvesIdes crongrama){		
		AccesoBD accesoBD = new AccesoBD();		
		Connection con = accesoBD.conectarBD();

		String insert=""; // completar
		PreparedStatement pstmt = null;
		try {
			pstmt =con.prepareStatement(insert);
			// pstmt.setDate
			
			//...
			
			
		} catch (SQLException e) {
			Log.error(e + "");
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				accesoBD.desconectarBD(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Log.error(e + "error al conectarse a la BD");
				e.printStackTrace();
			}			
		}
		
				
	}
	
}
