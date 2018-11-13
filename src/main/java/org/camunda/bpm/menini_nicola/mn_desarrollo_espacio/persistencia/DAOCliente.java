package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.jfree.util.Log;

public class DAOCliente {
	
	public ArrayList obtenerClientesPresupuestoAprobado() {
		AccesoBD accesoBD = new AccesoBD();		
		Connection con = accesoBD.conectarBD();
		ArrayList lista = new ArrayList<String>();
		Consultas consultas = new Consultas();
		
		Statement stmt=null;
		PreparedStatement pstmt=null;
		try {
			stmt = con.createStatement();
			String strClientesPresupuestosAprobados = consultas.obtenerClientesPresupuestoAprobado();
			pstmt = con.prepareStatement(strClientesPresupuestosAprobados);
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
		return lista;		
	}
}
