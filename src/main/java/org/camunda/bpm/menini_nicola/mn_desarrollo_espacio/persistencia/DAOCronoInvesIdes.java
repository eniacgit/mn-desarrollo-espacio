package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.modelo.CronoInvesIdes;
import org.jfree.util.Log;


public class DAOCronoInvesIdes {
	
	// convierte una fecha de tipo Date de java.sql a String con formato "yyyy-MM-dd" para insertar en la BD de MySQL
	private String fechaToMysql(Date fecha) {
		String fechaMysql=null;
		String format = "yyyy-MM-dd";
		DateFormat df = new SimpleDateFormat(format);		
		fechaMysql =df.format(fecha);
		return fechaMysql;
	}
	
	
	
	public int insertarCronogramaInvestigacionYDesarrollo(CronoInvesIdes cronograma){		
		AccesoBD accesoBD = new AccesoBD();		
		Connection con = accesoBD.conectarBD();
		Consultas consultas = new Consultas();
		
		String insert=consultas.insertarCronogramaInvestigacionYDesarrollo(); 
		PreparedStatement pstmt = null;
		int rowCount=0;
		
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
			rowCount = pstmt.executeUpdate();			
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
		
	public int obtenerUltimoIndiceInsertadoCronoInvestides() {
		AccesoBD accesoBD = new AccesoBD();		
		Connection con = accesoBD.conectarBD();
		Consultas consultas = new Consultas();
		
		String srtIndice = consultas.obtenerUltimoIndiceInsertadoCronoInvestides();
		Statement stmt = null;
		int indice = 0;
		
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(srtIndice);	
			while (rs.next()) {
				indice = rs.getInt("id");
			}
		} catch (SQLException e) {
			Log.error(e + "EEROR 1");
			System.out.println(">> Tipo de datos incorrectos");
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
				accesoBD.desconectarBD(con);
			} catch (SQLException e) {
				Log.error(e + "ERROR 2");
				System.out.println(">> ERROR 2");
				e.printStackTrace();
			}			
		}
		return indice;
	}
	

}
