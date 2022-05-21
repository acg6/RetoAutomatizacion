package regional.steps;

import net.thucydides.core.annotations.Step;
import regional.ui.ResultadoDeGestionUI;
import regional.utilities.AccionesWeb;


public class ResultadoDeGestionStep {
	
	private AccionesWeb accionesWeb;

	private static final String ID_FRAME_ACTIVIDAD = "Actividad";

	
	@Step
	public void seleccionaResultadoDeGestionAcepta() {
		
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.cambioDeFramePorId(ID_FRAME_ACTIVIDAD);
		accionesWeb.esperoElementoHabilitado(ResultadoDeGestionUI.getButtonAcepta());
		accionesWeb.posicionarElementoScroll(ResultadoDeGestionUI.getButtonAcepta());
		accionesWeb.clickBoton(ResultadoDeGestionUI.getButtonAcepta());
		accionesWeb.tomarEvidencia();
	}
	
	@Step
	public void seleccionaResultadoDeGestionNoAcepta() {
		
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.cambioDeFramePorId(ID_FRAME_ACTIVIDAD);
		accionesWeb.esperoElementoHabilitado(ResultadoDeGestionUI.getButtonNoAcepta());
		accionesWeb.posicionarElementoScroll(ResultadoDeGestionUI.getButtonNoAcepta());
		accionesWeb.clickBoton(ResultadoDeGestionUI.getButtonNoAcepta());
		accionesWeb.tomarEvidencia();
	}
	
	@Step
	public void seleccionaResultadoDeGestionRellamar() {
		
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.cambioDeFramePorId(ID_FRAME_ACTIVIDAD);
		accionesWeb.esperoElementoHabilitado(ResultadoDeGestionUI.getButtonRellamar());
		accionesWeb.posicionarElementoScroll(ResultadoDeGestionUI.getButtonRellamar());
		accionesWeb.clickBoton(ResultadoDeGestionUI.getButtonRellamar());
		accionesWeb.tomarEvidencia();
	}
	
	@Step
	public void seleccionaResultadoDeRetirarGestion() {
		
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.cambioDeFramePorId(ID_FRAME_ACTIVIDAD);
		accionesWeb.esperoElementoHabilitado(ResultadoDeGestionUI.getButtonRetirarGestion());
		accionesWeb.posicionarElementoScroll(ResultadoDeGestionUI.getButtonRetirarGestion());
		accionesWeb.clickBoton(ResultadoDeGestionUI.getButtonRetirarGestion());
		accionesWeb.tomarEvidencia();
	}
	
		
	@Step
	public void seleccionaFinalizar() {
		accionesWeb.esperoElementoHabilitado(ResultadoDeGestionUI.getButtonFinalizar());
		accionesWeb.clickBoton(ResultadoDeGestionUI.getButtonFinalizar());
		accionesWeb.tomarEvidencia();
	}
	
}
