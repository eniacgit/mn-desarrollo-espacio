package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.modelo.CronoCierrePropuesta;
import org.jfree.util.Log;

public class DAOCronoCierrePropuesta {

	// convierte una fecha de tipo Date de java.sql a String con formato "yyyy-MM-dd" para insertar en la BD de MySQL
		private String fechaToMysql(Date fecha) {
			String fechaMysql=null;
			String format = "yyyy-MM-dd";
			DateFormat df = new SimpleDateFormat(format);		
			fechaMysql = df.format(fecha);
			return fechaMysql;
		}
		
		
		public int insertarCronogramaCierrePropuesta(CronoCierrePropuesta cronograma){
			AccesoBD accesoBD = new AccesoBD();		
			Connection con = accesoBD.conectarBD();
			Consultas consultas = new Consultas();
			
			String insert=consultas.insertarCronogramaCierrePropuesta();
			PreparedStatement pstmt = null;
			int rowCount=0;
			
			try {
				pstmt =con.prepareStatement(insert);
				pstmt.setString(1, fechaToMysql(cronograma.getProyCerrFechInicio()));
				pstmt.setString(2, fechaToMysql(cronograma.getProyCerrFechFin()));
				pstmt.setInt(3, cronograma.getProyCerrHoras());
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
		
		public int obtenerUltimoIndiceInsertadoCronoCierrePropuesta() {
			AccesoBD accesoBD = new AccesoBD();		
			Connection con = accesoBD.conectarBD();
			Consultas consultas = new Consultas();
			
			String srtIndice = consultas.obtenerUltimoIndiceInsertadoCronoCierrePropuesta();
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
		
		public int obtenerIdCliente(String nombre) {
			AccesoBD accesoBD = new AccesoBD();		
			Connection con = accesoBD.conectarBD();
			Consultas consultas = new Consultas();
			
			String srtIdCliente = consultas.obtenerIdCliente();
			PreparedStatement pstmt = null;
			int idCliente = 0;
			
			try {
				pstmt = con.prepareStatement(srtIdCliente);
				pstmt.setString(1,nombre);
				ResultSet rs = pstmt.executeQuery();
				rs.next();
				idCliente = rs.getInt(1);
				rs.close();				
			} catch (SQLException e) {
				Log.error(e + "EEROR 1");
				System.out.println(">> Tipo de datos incorrectos");
				e.printStackTrace();
			}
			try {
				pstmt.close();
				accesoBD.desconectarBD(con);
			} catch (SQLException e) {
				Log.error(e + "ERROR 2");
				System.out.println(">> ERROR 2");
				e.printStackTrace();
			}						
			return idCliente;
			
		}
		
}
