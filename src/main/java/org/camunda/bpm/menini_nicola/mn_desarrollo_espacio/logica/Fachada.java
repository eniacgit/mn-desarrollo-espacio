package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.logica;

import java.util.ArrayList;
import java.util.Date;

import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.modelo.CronoInvesIdes;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia.AccesoBD;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia.DAOCliente;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia.DAOCronoInvesIdes;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia.DAOPresupuesto;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.valueObjects.VOCronoInvesIdes;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.valueObjects.VOPresupuesto;



public class Fachada implements IFachada {

     private static IFachada fachada;

    // El constructor es privado, no permite que se genere un constructor por defecto.
    private Fachada() {
 
     }

    public static IFachada getSingletonInstance() {
        if (fachada == null){
        	fachada = new Fachada();
        }        
        return fachada;
    }
    
    // metodos getter y setter
    /* (non-Javadoc)
	 * @see org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.logica.IFachada#insertarCronogramaInvestigacionYDesarrollo(org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.valueObjects.VOCronoInvesIdes)
	 */
    @Override
	public void insertarCronogramaInvestigacionYDesarrollo(VOCronoInvesIdes voCronograma){
    	DAOCronoInvesIdes dao = new DAOCronoInvesIdes();
    	CronoInvesIdes crono = new CronoInvesIdes();
    	    	
    	crono.setAnMarcaFechInicio(voCronograma.getAjInterFechInicio());
    	crono.setAnMarcaFechFin(voCronograma.getAjInterFechFin());
    	crono.setAnMarcaHoras(voCronograma.getAnMarcaHoras());
    	crono.setAjInterFechFin(voCronograma.getAjInterFechFin());
    	crono.setDesConcepFechInicio(voCronograma.getDesConcepFechInicio());    	
    	crono.setDesConcepFechFin(voCronograma.getDesConcepFechFin());
    	crono.setDesConcepHoras(voCronograma.getDesConcepHoras());
    	crono.setDesPropFechInicio(voCronograma.getDesPropFechInicio());
    	crono.setDesPropFechFin(voCronograma.getDesPropFechFin());
    	crono.setDesPropHoras(voCronograma.getDesPropHoras());
    	crono.setAjInterFechInicio(voCronograma.getAjInterFechInicio());
    	crono.setAjInterFechFin(voCronograma.getAjInterFechFin());
    	crono.setAjInterHoras(voCronograma.getAjInterHoras());    	  	
    	
    	dao.insertarCronogramaInvestigacionYDesarrollo(crono);    	
    }
    
    
    @Override
    public ArrayList obtenerClientesPresupuestoAprobado() {
    	DAOCliente dao = new DAOCliente();
    	return dao.obtenerClientesPresupuestoAprobado();
    }
    
    @Override
    public VOPresupuesto obtenerCostoPresupuesto(String cotizacion) {
    	DAOPresupuesto dao = new DAOPresupuesto();
    	return dao.obtenerCostoPresupuesto(cotizacion);
    }

}







///////////
/*
public class Fachada {
	
	public ArrayList obtenerClientesPresupuestoAprobado() {
		AccesoBD accesoBD = new AccesoBD();
		return accesoBD.obtenerClientesPresupuestoAprobado();
	}
	
	public VOPresupuesto obtenerCostoPresupuesto(String cotizacion) {
		AccesoBD accesoBD = new AccesoBD();
		return accesoBD.obtenerCostoPresupuesto(cotizacion);
	}
}
*/