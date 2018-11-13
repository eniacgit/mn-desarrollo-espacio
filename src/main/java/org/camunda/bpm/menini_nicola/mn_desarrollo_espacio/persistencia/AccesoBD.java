package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.valueObjects.VOPresupuesto;
import org.jfree.util.Log;

public class AccesoBD {
	
	private String driver;
	private String username;
	private String pass;
	private String url;
	private String base;
	
	public Connection conectarBD() {
		// Carga los datos desde el archivo de configuracion
		// y se conecta a la base del servidor
		Connection con = null;		
		
		try {
			Properties p = new Properties();
			p.load(new FileInputStream("config/parametros.txt"));
			driver = p.getProperty("driver");
			Class.forName(driver);
			//System.out.println("driver: " + driver);
			
			username = p.getProperty("usuario");
			pass = p.getProperty("password");
			url = p.getProperty("url");
			base = p.getProperty("bdatos");
			
			con = DriverManager.getConnection(url + base, username, pass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return con;
	}
	
	public void desconectarBD(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Log.error(e);
			System.out.println(">> ERROR 3");
			e.printStackTrace();
		}
	}
		
	// Retorna un array con los nombres de los clientes cuyos presupuesto fueron aprobados
	public ArrayList obtenerClientesPresupuestoAprobado() {
		ArrayList lista = new ArrayList<String>();
		Connection con = null;
		con = this.conectarBD();
		
		Statement stmt;
		try {
			stmt = con.createStatement();
			Consultas consultas = new Consultas();
			String strClientesPresupuestosAprobados = consultas.obtenerClientesPresupuestoAprobado();
			PreparedStatement pstmt = con.prepareStatement(strClientesPresupuestosAprobados);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				lista.add(rs.getString("nombre"));
			}
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return lista;
	}
	
	// retorna a partir de la cotización la moneda y el costo del presupuesto
	public VOPresupuesto obtenerCostoPresupuesto(String cotizacion) {
		Connection con = null;
		con = this.conectarBD();
		Consultas consultas = new Consultas();
		String strPresupuesto = consultas.obtenerCostoPresupuesto();
		
		VOPresupuesto presupuesto = new VOPresupuesto();
		try {
			PreparedStatement pstmt = con.prepareStatement(strPresupuesto);
			pstmt.setString(1, cotizacion); 	
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			presupuesto.setMoneda(rs.getString("moneda"));
			presupuesto.setCosto(rs.getFloat("costo"));			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return presupuesto;
	}
	
}
