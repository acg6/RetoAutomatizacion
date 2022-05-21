package regional.steps;

import net.thucydides.core.annotations.Step;
import regional.ui.ConstantesUI;
import regional.ui.PerfilUI;
import regional.utilities.AccionesWeb;
import regional.utilities.UtilDatos;

public class PerfilStep {

	private AccionesWeb accionesWeb;
	private static final String PERFIL_CSR_INTEGRAL = "CSR Integral";

	@Step
	public void seleccionarPerfil(String strPerfil) {
		accionesWeb.esperaCargarPagina();
		accionesWeb.escribirTexto(PerfilUI.getInputPerfil(), strPerfil);
		accionesWeb.tomarEvidencia();
		accionesWeb.clickBoton(PerfilUI.getButtonAceptar());
		accionesWeb.esperaDesaparezcaElemento(ConstantesUI.getDivCargando(), 2);
		accionesWeb.esperaCargarPagina();
	}
	
	@Step
	public void seleccionarPerfilPosWinBack() {
		
		String strPerfil = "";
		switch (UtilDatos.getPais()) 
        {
	        case "UY":  
	        	strPerfil = "CSR PosWinback UY";
	        break;
	        case "PE":  
	        	strPerfil = "CSR Retenciones PSW PE";
	        break;
	        default: 
	        	break;
	        
        }	

		accionesWeb.escribirTexto(PerfilUI.getInputPerfil(), strPerfil);	
		aceptarPerfilRetenciones();
	}
	
	
	@Step
	public void seleccionarPerfilPQR() {
		
		String perfil = "";
		
		switch (UtilDatos.getPais()) {
	        case "PE":  
	        	perfil =  "CSR BGI Peru";
	        break;
	        case "CO":
	        	perfil =  "SAC Colombia";
	        break;
	        case "EC":
	        	perfil =  "CSR Especialista Generalista Ecuador";
	        break;
	        case "AR":
	        	perfil =  PERFIL_CSR_INTEGRAL;
	        break;
	        case "CL":
	        	perfil = PERFIL_CSR_INTEGRAL;
	        	break;
	        default : 
	        	break;
        	
        }
		
		accionesWeb.escribirTexto(PerfilUI.getInputPerfil(), perfil);
		accionesWeb.tomarEvidencia();
		aceptarPerfilRetenciones();
	}
	
	

	@Step
	public void seleccionarPerfilRetencionesInbound() {
		
		String perfil = "";
		switch (UtilDatos.getPais()) {
	        case "PE":  
	        	perfil =  "CSR Retenciones IN PE";
	        break;
	        case "CO":
	        	perfil =  "CSR Retenciones IN CO";
	        break;
	        default : 
	        	perfil =  "CSR Retenciones UY";
	        	UtilDatos.setPais("UY");
	        break;
	        	
        }
		accionesWeb.escribirTexto(PerfilUI.getInputPerfil(), perfil);
		aceptarPerfilRetenciones();
	}
	
	@Step
	public void seleccionarPerfiModificacion() {

		String perfil = "";
		switch (UtilDatos.getPais()) 
        {
	        case "PE":  
	        	perfil = "TST Peru";
	        break;
	        case "AR":
	        	perfil =  PERFIL_CSR_INTEGRAL;
	        break;	        
	        case "CO":
	        	perfil =  "TST Colombia";
	        break;
	        case "EC":
	        	perfil =  "TST Ecuador";
	        break;
	        case "CL":
	        	perfil =  PERFIL_CSR_INTEGRAL;
	        break;
	        default : 
	        	perfil =  "TST Uruguay";
	        	UtilDatos.setPais("UY");
	        break;
	        	
        }
		accionesWeb.escribirTexto(PerfilUI.getInputPerfil(), perfil);
		accionesWeb.tomarEvidencia();
		aceptarPerfilRetenciones();
	}
	
	@Step
	public void seleccionarPerfilRetencionesWinback() {

		String perfil = "";
		if(UtilDatos.getPais().equals("PE")) {
			perfil =  "CSR Retenciones WB PE";
		}else {
			perfil =  "CSR Winback UY";
		}
		accionesWeb.escribirTexto(PerfilUI.getInputPerfil(), perfil);
		accionesWeb.tomarEvidencia();
		aceptarPerfilRetenciones();
	}
	
	public void seleccionarPerfilRetencionesPoswinback() {

		String perfil = "";
		if(UtilDatos.getPais().equals("PE")) {
			perfil =  "CSR Retenciones PSW PE";
		}else {
			perfil =  "CSR PosWinback UY";
        	UtilDatos.setPais("UY");
		}		
		accionesWeb.escribirTexto(PerfilUI.getInputPerfil(), perfil);
		accionesWeb.tomarEvidencia();
		aceptarPerfilRetenciones();
	}
	
	@Step
	public void aceptarPerfilRetenciones() {

		accionesWeb.tomarEvidencia();
		accionesWeb.clickBoton(PerfilUI.getButtonAceptar());

	}
		
	@Step
	public void seleccionarPerfilRetencionesPrepago() {
       	accionesWeb.escribirTexto(PerfilUI.getInputPerfil(), "CSR Retenciones Prepago");
       	accionesWeb.tomarEvidencia();
       	aceptarPerfilRetenciones();
	}
	
	@Step
	public void seleccionarPerfilRetencionesPospago() {
       	accionesWeb.escribirTexto(PerfilUI.getInputPerfil(), "CSR Retenciones IN CO");
       	accionesWeb.tomarEvidencia();
       	aceptarPerfilRetenciones();
	}
	
	
}
