package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.modelo.CronoInvesIdes;
import org.jfree.util.Log;

public class DAOCronoInvesIdes {

	
	private String fechaToMysql(Date fecha) {
		String fechaMysql=null;
		String format = "yyyy-MM-dd";
		DateFormat df = new SimpleDateFormat(format);		
		fechaMysql =df.format(fecha);
		return fechaMysql;
	}
	
	
	
	public void insertarCronogramaInvestigacionYDesarrollo(CronoInvesIdes cronograma){		
		AccesoBD accesoBD = new AccesoBD();		
		Connection con = accesoBD.conectarBD();
		Consultas consultas = new Consultas();
		
		String insert=consultas.insertarCronogramaInvestigacionYDesarrollo(); 
		PreparedStatement pstmt = null;
		try {
			
			pstmt =con.prepareStatement(insert);
			pstmt.setString(1, fechaToMysql(cronograma.getAnMarcaFechInicio()));
			pstmt.setString(2, fechaToMysql(cronograma.getAnMarcaFechFin()));
			pstmt.setInt(3, cronograma.getAnMarcaHoras());
			pstmt.setString(4, fechaToMysql(cronograma.getDesConcepFechInicio()));
			pstmt.setString(5, fechaToMysql(cronograma.getAnMarcaFechFin()));
			pstmt.setInt(6, cronograma.getDesConcepHoras());
			pstmt.setString(7, fechaToMysql(cronograma.getDesPropFechInicio()));
			pstmt.setString(8, fechaToMysql(cronograma.getDesPropFechFin()));
			pstmt.setInt(9, cronograma.getDesPropHoras());
			pstmt.setString(10, fechaToMysql(cronograma.getAjInterFechInicio()));
			pstmt.setString(11, fechaToMysql(cronograma.getAjInterFechFin()));
			pstmt.setInt(12, cronograma.getAjInterHoras());
			pstmt.executeUpdate();			
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
		
				
	}

}
