package regional.steps;

import net.thucydides.core.annotations.Step;
import regional.ui.LogoutUI;
import regional.ui.PerfilUI;
import regional.utilities.AccionesWeb;

public class LogoutStep {
	
	private AccionesWeb accionesWeb;

	@Step
	public void cerrarSesionAplicativo() {
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.esperoElementoVisible(LogoutUI.getButtonLogout());
		accionesWeb.clickBoton(LogoutUI.getButtonLogout());
	}
	
	@Step
	public void terminarProcesoRetenido() {
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.esperoElementoVisible(LogoutUI.getButtonLogout());
		accionesWeb.clickBoton(LogoutUI.getButtonLogout());
		accionesWeb.tomarEvidencia();
		accionesWeb.esperoElementoVisible(LogoutUI.getButtonTerminarProceso());
		accionesWeb.clickBoton(LogoutUI.getButtonTerminarProceso());
		accionesWeb.tomarEvidencia();
	}
	
	@Step
	public void finalizarSesionAplicativo() {
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.esperoElementoVisible(PerfilUI.getButtonAceptar());
		accionesWeb.clickBoton(PerfilUI.getButtonAceptar());
		accionesWeb.tomarEvidencia();
	}
}
