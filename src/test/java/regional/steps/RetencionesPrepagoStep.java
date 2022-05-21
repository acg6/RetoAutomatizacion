package regional.steps;

import net.thucydides.core.annotations.Step;
import regional.ui.RetencionesPrepagoUI;
import regional.utilities.AccionesWeb;
import regional.utilities.UtilDatosAleatorios;

public class RetencionesPrepagoStep {
	
	private AccionesWeb accionesWeb;

	private static final String ID_FRAME_ACTIVIDAD = "Actividad";

	
	@Step
	public void seleccionaMotivoNoRecarga() {
		int numeroElementos = 0;
		accionesWeb.esperoElementoVisible(RetencionesPrepagoUI.getMotivoNoRecarga());
		accionesWeb.esperoElementoHabilitado(RetencionesPrepagoUI.getMotivoNoRecarga());
		numeroElementos = accionesWeb.obtenerCantidadDeElementosPorXpath(RetencionesPrepagoUI.getMotivoNoRecarga());
		numeroElementos = UtilDatosAleatorios.obtenerIntAleatorioRango(numeroElementos);
		RetencionesPrepagoUI.setMotivoNoRecargaOpcion(numeroElementos);
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.cambioDeFramePorId(ID_FRAME_ACTIVIDAD);
		accionesWeb.cambiarFramePorelemento(RetencionesPrepagoUI.getXpathFrameGenerico());
		accionesWeb.cambioDeFramePorId(ID_FRAME_ACTIVIDAD);
		accionesWeb.esperoElementoHabilitado(RetencionesPrepagoUI.getMotivoNoRecargaOpcion());
		accionesWeb.posicionarElementoScroll(RetencionesPrepagoUI.getMotivoNoRecargaOpcion());
		accionesWeb.clickBoton(RetencionesPrepagoUI.getMotivoNoRecargaOpcion());
		accionesWeb.tomarEvidencia();
	}
	
	@Step
	public void seleccionaSubmotivoNoRecarga() {
			int numeroElementos = 0;
			accionesWeb.esperoElementoHabilitado(RetencionesPrepagoUI.getSubmotivoNoRecarga());
			numeroElementos = accionesWeb.obtenerCantidadDeElementosPorXpath(RetencionesPrepagoUI.getSubmotivoNoRecarga());
			numeroElementos = UtilDatosAleatorios.obtenerIntAleatorioRango(numeroElementos);
			RetencionesPrepagoUI.setSubmotivoNoRecargaOpcion(numeroElementos);
			accionesWeb.esperoElementoHabilitado(RetencionesPrepagoUI.getSubmotivoNoRecargaOpcion());
			accionesWeb.posicionarElementoScroll(RetencionesPrepagoUI.getSubmotivoNoRecargaOpcion());
			accionesWeb.clickBoton(RetencionesPrepagoUI.getSubmotivoNoRecargaOpcion());
			accionesWeb.tomarEvidencia();
	}
	
	@Step
	public void seleccionaPropuestaComercial() {
			int numeroElementos = 0;
			accionesWeb.esperoElementoHabilitado(RetencionesPrepagoUI.getPropuestasComerciales());
			numeroElementos = accionesWeb.obtenerCantidadDeElementosPorXpath(RetencionesPrepagoUI.getPropuestasComerciales());
			numeroElementos = UtilDatosAleatorios.obtenerIntAleatorioRango(numeroElementos);
			RetencionesPrepagoUI.setPropuestasComercialesOpcion(numeroElementos);
			accionesWeb.esperoElementoHabilitado(RetencionesPrepagoUI.getPropuestasComercialesOpcion());
			accionesWeb.clickBoton(RetencionesPrepagoUI.getPropuestasComercialesOpcion());
			accionesWeb.posicionarElementoScroll(RetencionesPrepagoUI.getPropuestasComercialesOpcion());
			accionesWeb.tomarEvidencia();
	}
	
	@Step
	public void seleccionaContenido(int num) {
		for (int i = 1; i <= num; i++) {
			accionesWeb.esperaCargarPagina();
			accionesWeb.cambioDeFrameDefault();
			accionesWeb.cambioDeFramePorId(ID_FRAME_ACTIVIDAD);
			int numeroElementos = 0;
			accionesWeb.esperaCargarPagina();
			accionesWeb.esperoElementoVisible(RetencionesPrepagoUI.getContenido());
			accionesWeb.posicionarElementoScroll(RetencionesPrepagoUI.getContenido());
			accionesWeb.esperoElementoHabilitado(RetencionesPrepagoUI.getContenido());			
			numeroElementos = accionesWeb.obtenerCantidadDeElementosPorXpath(RetencionesPrepagoUI.getContenido());
			numeroElementos = UtilDatosAleatorios.obtenerIntAleatorioRango(numeroElementos);			
			RetencionesPrepagoUI.setContenidoOpcion(numeroElementos);
			accionesWeb.esperoElementoHabilitado(RetencionesPrepagoUI.getContenidoOpcion());
			accionesWeb.posicionarElementoScroll(RetencionesPrepagoUI.getContenidoOpcion());
			accionesWeb.clickBoton(RetencionesPrepagoUI.getContenidoOpcion());
		}
		accionesWeb.tomarEvidencia();
	}
	
}
