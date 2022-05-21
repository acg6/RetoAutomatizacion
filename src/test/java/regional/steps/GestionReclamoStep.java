package regional.steps;

import java.util.List;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import regional.ui.AsistenciaTecnicaUI;
import regional.ui.ConstantesUI;
import regional.ui.GestionReclamoUI;
import regional.ui.RecepcionReclamoUI;
import regional.utilities.AccionesWeb;
import regional.utilities.UtilDatos;
import regional.utilities.UtilDatosAleatorios;

public class GestionReclamoStep {
	
	private AccionesWeb accionesWeb;
	
	@Steps
	 AsistenciaTecnicaStep asistenciaTecnicaStep = new AsistenciaTecnicaStep();
	
	
	@Step
	public void agregarDescripcion() {
		
		String motivoDerivacion;
		
		accionesWeb.cambiarVentana(2);
		accionesWeb.esperaDesaparezcaElemento(ConstantesUI.getDivCargando(), 2);
		accionesWeb.esperaCargarPagina();
		accionesWeb.editaTiempoImplicito(5);
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.cambioDeFrame(7);
		accionesWeb.esperoElementoVisible(GestionReclamoUI.getTxtDescripcion());
		motivoDerivacion = accionesWeb.extraerValuedeSelected(GestionReclamoUI.getSelectSubMotivo());
		motivoDerivacion = motivoDerivacion.substring(motivoDerivacion.indexOf("-") + 1, motivoDerivacion.length()) ;
		accionesWeb.escribirTexto(GestionReclamoUI.getTxtDescripcion(),motivoDerivacion);
		accionesWeb.restauraTiempoImplicitoPorDefecto();
		accionesWeb.tomarEvidencia();
	}

	public void clickBotonSolucionar() {
		accionesWeb.posicionarElementoScroll(GestionReclamoUI.getButtonSolucionar());
		accionesWeb.clickBoton(GestionReclamoUI.getButtonSolucionar());
		accionesWeb.restauraTiempoImplicitoPorDefecto();
	}
	
	@Step
	public void seleccionaMotivoDeDerivacion() {
		List<String> categoriaDerivacion = UtilDatosAleatorios.obtenerCategoriaDerivacionAleatoria();
		accionesWeb.esperaDesaparezcaElemento(AsistenciaTecnicaUI.getOverLayTramite(), 2);
		accionesWeb.seleccionaOpcionContengaTexto(GestionReclamoUI.getSelectCategoriaDerivacion(),
				categoriaDerivacion.get(0));
		accionesWeb.esperaDesaparezcaElemento(AsistenciaTecnicaUI.getOverLayTramite(), 2);
		accionesWeb.seleccionarOpcionIndex(GestionReclamoUI.getSelectMotivoDerivacion(), 1);
		accionesWeb.esperaDesaparezcaElemento(AsistenciaTecnicaUI.getOverLayTramite(), 2);
		accionesWeb.seleccionarOpcionIndex(GestionReclamoUI.getSelectSubmotivoDerivacion(), 1);
		accionesWeb.tomarEvidencia();
	}

	@Step
	public void agregarObservacionContacto() {
		String subCategoriaDerivacion;
		accionesWeb.esperaDesaparezcaElemento(ConstantesUI.getDivCargando(), 2);
		accionesWeb.esperaCargarPagina();
		accionesWeb.editaTiempoImplicito(5);
		accionesWeb.esperoElementoVisible(GestionReclamoUI.getTxtObservacionContacto());
		subCategoriaDerivacion = accionesWeb.extraerValuedeSelected(GestionReclamoUI.getSelectSecondSubCategoriaContacto());
		subCategoriaDerivacion = subCategoriaDerivacion.substring(subCategoriaDerivacion.indexOf("-") + 1, subCategoriaDerivacion.length());
		accionesWeb.escribirTexto(GestionReclamoUI.getTxtObservacionContacto(), subCategoriaDerivacion);
		accionesWeb.restauraTiempoImplicitoPorDefecto();
		accionesWeb.tomarEvidencia();
	}
	
	
	@Step
	public void clickSolucionar() {
		accionesWeb.esperaCargarPagina();
		accionesWeb.editaTiempoImplicito(2);
		accionesWeb.esperaDesaparezcaElemento(AsistenciaTecnicaUI.getOverLayTrVtn2(), 2);
		accionesWeb.posicionarElementoScroll(RecepcionReclamoUI.getButtonSolucionar());
		accionesWeb.tomarEvidencia();
		accionesWeb.clickBoton(RecepcionReclamoUI.getButtonSolucionar());
		accionesWeb.restauraTiempoImplicitoPorDefecto();
		accionesWeb.tomarEvidencia();
	}
	
	@Step
	public void clickContinuarIBS() {
		accionesWeb.esperaCargarPagina();
		accionesWeb.editaTiempoImplicito(2);
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.cambioDeFrame(7);
		accionesWeb.esperaDesaparezcaElemento(ConstantesUI.getDivCargando(), 4);
		accionesWeb.posicionarElementoScroll(AsistenciaTecnicaUI.getButtonContinuar());
		accionesWeb.clickBoton(AsistenciaTecnicaUI.getButtonContinuar());
		accionesWeb.restauraTiempoImplicitoPorDefecto();
		accionesWeb.tomarEvidencia();
	}
	
	
	
	@Step
	public void agregarRazonContacto() {

		accionesWeb.esperaDesaparezcaElemento(ConstantesUI.getDivCargando(), 2);
		accionesWeb.esperaCargarPagina();
		
		if ( UtilDatos.getPais().equals("EC")) {
			
			accionesWeb.esperoElementoVisible(GestionReclamoUI.getSelectRazon());
			accionesWeb.seleccionarOpcionIndex(GestionReclamoUI.getSelectRazon(), 1);
			accionesWeb.tomarEvidencia();
		}
	}
	
	
		
	@Step
	public void clickDerivar() {
		accionesWeb.esperaDesaparezcaElemento(AsistenciaTecnicaUI.getOverLayTrVtn2(), 2);
		accionesWeb.posicionarElementoScroll(RecepcionReclamoUI.getButtonDerivar());
		accionesWeb.tomarEvidencia();
		accionesWeb.clickBoton(RecepcionReclamoUI.getButtonDerivar());
	}
	
	@Step
	public void seleccionaReasonDerivacion() {
		
		accionesWeb.esperoElementoHabilitado(GestionReclamoUI.getSelectReasonDerivacion());
		accionesWeb.seleccionarOpcionIndex(GestionReclamoUI.getSelectReasonDerivacion(), 1);
		accionesWeb.tomarEvidencia();
	}
	
	@Step
	public void agregaLaDescripcionDelDiagnosticoADerivar() {
	    agregarDescripcion();
	    seleccionaMotivoDeDerivacion();
	    clickDerivar();
	}
	
	@Step
	public void registraRazonGestion() {	
	    agregarRazonContacto();
		agregarObservacionContacto();		
		accionesWeb.clickBoton(GestionReclamoUI.getBtnFinalizar());
	}
	
	@Step
	public void clickFinalizarCorporativo() {	
			accionesWeb.cambiarVentana(1);
			accionesWeb.esperaCargarPagina();
			accionesWeb.cambioDeFrame(7);
			accionesWeb.esperaDesaparezcaElementoIntentos(AsistenciaTecnicaUI.getOverLayTramite(), 2);
			accionesWeb.posicionarElementoScroll(GestionReclamoUI.getBtnFinalizarCorporativo());
			accionesWeb.tomarEvidencia();
			accionesWeb.clickBoton(GestionReclamoUI.getBtnFinalizarCorporativo());
					
	}
	
		
}
