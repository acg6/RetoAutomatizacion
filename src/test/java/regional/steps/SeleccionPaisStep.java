package regional.steps;



import regional.ui.AsistenciaTecnicaUI;
import regional.ui.RetencionesPrepagoUI;
import regional.utilities.AccionesWeb;
import regional.utilities.UtilDatos;
import regional.utilities.UtilDatosEstaticos;

public class SeleccionPaisStep {
	
	AsistenciaTecnicaUI asistenciaTecnicaUI;
	RetencionesPrepagoUI retencionesPrepagoUI;
	GestionRetencionStep gestionRetencionStep = new GestionRetencionStep();
	ClienteStep clienteStep = new ClienteStep();
	AccionesWeb accionesWeb;
	
	public void submotivoDeIntencionBaja() {
		
		switch (UtilDatos.getPais()) {
	    	case UtilDatosEstaticos.PAIS_UY:  
	    		gestionRetencionStep.seleccionarSubmotivoIntencionBaja();
	    		break;
	    
	    	case UtilDatosEstaticos.PAIS_PE:  
	    		gestionRetencionStep.seleccionarSubmotivo();
	    		gestionRetencionStep.seleccionarSubsubmotivo();
	    		break;
	    		
	    	case UtilDatosEstaticos.PAIS_CO:  
	    		gestionRetencionStep.seleccionarMotivoPrincipalBajaTV();
	    		gestionRetencionStep.seleccinarCategoriaYBeneficio();
	    		break;
	    		
	    	default:
	    		break;
        }
	}
	
	public void agregarUnSubmotivoDeIntencionBaja() {
		gestionRetencionStep.seleccionaMotivoPrincipalBajaTV();
	}
	
	public void motivoPrincipalBaja() {
		gestionRetencionStep.seleccionarMotivoPrincipalBajaNet();
	}

	public void motivoPrincipalBajaRetenidoTV() {
		gestionRetencionStep.seleccionarMotivoPrincipalBajaRetenidoTV();
	}
	
	public void seleccionarProductoIndex() {
		
		String xpathGenerico = "";
		
		if (UtilDatos.getPais().equals(UtilDatosEstaticos.PAIS_UY) || UtilDatos.getPais().equals(UtilDatosEstaticos.PAIS_PE) ) {
			xpathGenerico = AsistenciaTecnicaUI.getXpathFrameGenericoEngage();
		} else  {
			xpathGenerico = RetencionesPrepagoUI.getXpathFrameGenerico();
		}

		gestionRetencionStep.seleccionarProducto(xpathGenerico);
		
	}
	
	public void seleccionarLaAccion(String strAccion) {
		
		String xpathGenerico = gestionRetencionStep.seleccionarFrameGenerico();
		
		gestionRetencionStep.seleccionarAccion(strAccion, xpathGenerico);
 	 }
	
	public void seleccionaProcesoPosWinBack(String strProceso) {
		
		clienteStep.seleccionarProceso(strProceso);
	}
	
	public void seleccionaProcesoPosWinBack() {
		String strProceso = "";
		if(UtilDatos.getPais().equals(UtilDatosEstaticos.PAIS_PE)) {
			strProceso = "Retenciones Peru";
		}else {
			strProceso = "Retenciones Poswinback UY";
		}
		clienteStep.seleccionarProceso(strProceso);
		
	}
	
	public void agregaElTipoDeResultado() {
		String tipoResultado = "";
		switch (UtilDatos.getPais()) {
        case UtilDatosEstaticos.PAIS_UY:  
        	tipoResultado = "Poswinback";
        	break;
        case UtilDatosEstaticos.PAIS_PE:  
        	tipoResultado = "PosWinBack";
        	break;
                	
        default:
        	break;
		}
		gestionRetencionStep.seleccionarResultadoDeRetencion(tipoResultado);
		gestionRetencionStep.clickIntencionBajaContinuar();
	}


}
