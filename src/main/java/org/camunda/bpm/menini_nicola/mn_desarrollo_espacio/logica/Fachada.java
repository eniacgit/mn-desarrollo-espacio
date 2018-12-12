package org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.logica;

import java.util.ArrayList;
import java.util.Date;

import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.modelo.CronoCierrePropuesta;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.modelo.CronoInvesIdes;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.modelo.CronoPresupuestacion;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.modelo.DesarrolloEspacio;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia.AccesoBD;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia.DAOCliente;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia.DAOCronoCierrePropuesta;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia.DAOCronoInvesIdes;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia.DAOCronoPresupuestacion;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia.DAODesarrolloEspacio;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.persistencia.DAOPresupuesto;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.valueObjects.VOCronoCierrePropuesta;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.valueObjects.VOCronoInvesIdes;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.valueObjects.VOCronoPresupuestacion;
import org.camunda.bpm.menini_nicola.mn_desarrollo_espacio.valueObjects.VODesarrolloEspacio;
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
	public int insertarCronogramaInvestigacionYDesarrollo(VOCronoInvesIdes voCronograma){
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
    	
    	return dao.insertarCronogramaInvestigacionYDesarrollo(crono);    	
    }
    
    
    @Override
    public ArrayList obtenerClientesPresupuestoAprobado() {
    	DAOCliente dao = new DAOCliente();
    	return dao.obtenerClientesPresupuestoAprobado();
    }
    
    @Override
    public float obtenerCostoPresupuesto(String cotizacion) {
    	DAOPresupuesto dao = new DAOPresupuesto();
    	return dao.obtenerCostoPresupuesto(cotizacion);
    }

    @Override
    public int insertarCronogramaPresupuestacion(VOCronoPresupuestacion voCronograma){
    	DAOCronoPresupuestacion dao=new DAOCronoPresupuestacion();
    	CronoPresupuestacion crono = new CronoPresupuestacion();
    	
    	crono.setScoutProdFechInicio(voCronograma.getScoutProdFechInicio());
    	crono.setScoutProdFechFin(voCronograma.getScoutProdFechFin());
    	crono.setScoutProdHoras(voCronograma.getScoutProdHoras());
    	crono.setSelecProvFechInicio(voCronograma.getSelecProvFechInicio());
    	crono.setSelecProvFechFin(voCronograma.getSelecProvFechFin());
    	crono.setScoutProdHoras(voCronograma.getScoutProdHoras());
    	
    	return dao.insertarCronogramaPresupuestacion(crono);    	
    }
    
    @Override
    public int insertarCronogramaCierrePropuesta(VOCronoCierrePropuesta voCronograma){
    	DAOCronoCierrePropuesta dao = new DAOCronoCierrePropuesta();
    	CronoCierrePropuesta crono = new CronoCierrePropuesta();
    	
    	crono.setProyCerrFechInicio(voCronograma.getProyCerrFechInicio());
    	crono.setProyCerrFechFin(voCronograma.getProyCerrFechFin());
    	crono.setProyCerrHoras(voCronograma.getProyCerrHoras());
    	
    	return dao.insertarCronogramaCierrePropuesta(crono);    	
    }
    
    @Override
    public int obtenerUltimoIndiceInsertadoCronoInvestides() {
    	DAOCronoInvesIdes dao=new DAOCronoInvesIdes();
    	return dao.obtenerUltimoIndiceInsertadoCronoInvestides();
    }
    
    @Override
    public int obtenerUltimoIndiceInsertadoCronoPresupuestacion() {
    	DAOCronoPresupuestacion dao=new DAOCronoPresupuestacion();
    	return dao.obtenerUltimoIndiceInsertadoCronoPresupuestacion();
    }
    
    @Override
    public int obtenerUltimoIndiceInsertadoCronoCierrePropuesta() {
    	DAOCronoCierrePropuesta dao = new DAOCronoCierrePropuesta();
    	return dao.obtenerUltimoIndiceInsertadoCronoCierrePropuesta();
    }
    
    @Override
    public int obtenerIdCliente(String nombre) {
    	DAOCronoCierrePropuesta dao = new DAOCronoCierrePropuesta();
    	return dao.obtenerIdCliente(nombre);
    }
    
    @Override
    public int insertarDesarrolloEspacio(VODesarrolloEspacio voEspacio) {
    	
    	DesarrolloEspacio espacio = new DesarrolloEspacio();
    	
    	espacio.setCotizacion(voEspacio.getCotizacion());
    	espacio.setIdCliente(voEspacio.getIdCliente());
    	espacio.setValorHora(voEspacio.getValorHora());
    	espacio.setIdCronoInvestides(voEspacio.getIdCronoInvestides());
    	espacio.setIdCronoPresupuestacion(voEspacio.getIdCronoPresupuestacion());
    	espacio.setIdCronoCierreProp(voEspacio.getIdCronoCierreProp());   	
    	
    	DAODesarrolloEspacio dao = new DAODesarrolloEspacio();
    	return dao.insertarDesarrolloEspacio(espacio);    	
    }
    
}



