package regional.steps;

import net.thucydides.core.annotations.Step;
import regional.ui.ConfirmarPorletUI;
import regional.ui.ConstantesUI;
import regional.ui.PortletUI;
import regional.utilities.AccionesWeb;
import regional.utilities.UtilDatos;

public class PortletStep {

	private AccionesWeb accionesWeb;
	
	private void sinNumero() {
		if(UtilDatos.getPais().equals("EC")) {
			accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 1);
    		accionesWeb.darClickCheckBox(PortletUI.getChkSinNumero());
    		accionesWeb.escribirTexto(PortletUI.getInputInfoAdicional(), "casa");
		}				
		accionesWeb.tomarEvidencia();
	}
	
	private void llenarCalle() {
		if(UtilDatos.getPais().equals("UY")) {
			accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 1);
    		accionesWeb.escribirTexto(PortletUI.getInputCalleAdicional(), "casa");
		}				
		accionesWeb.tomarEvidencia();
	}
	
	
	@Step
	public void normalizarDireccion(String direccion) {
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperoElementoVisible(PortletUI.getLblPorlet());
		accionesWeb.cambioDeFrame(0);
		accionesWeb.escribirTexto(PortletUI.getInputDireccionPorlet(), direccion);
		accionesWeb.clickPosibleElemento(PortletUI.getBtnBuscarDireccionPorlet(), 2);
		accionesWeb.clickBoton(PortletUI.getSpanDireccionElegidaPrimera());
		accionesWeb.esperaCargarPagina();
		sinNumero();
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 1);
		accionesWeb.posicionarElementoScroll(PortletUI.getBtnContinuarPorlet());
		accionesWeb.esperoElementoVisible(PortletUI.getBtnContinuarPorlet());
		accionesWeb.esperoElementoHabilitado(PortletUI.getBtnContinuarPorlet());
		accionesWeb.esperaDesaparezcaElemento(ConstantesUI.getDivCargando(), 1);
		accionesWeb.tomarEvidencia();
		accionesWeb.clickBoton(PortletUI.getBtnContinuarPorlet());
		llenarCalle();
		accionesWeb.esperoElementoVisible(ConfirmarPorletUI.getBtnSiConfirmacion());
		accionesWeb.tomarEvidencia();
		accionesWeb.clickBoton(ConfirmarPorletUI.getBtnSiConfirmacion());
	}
	
}
