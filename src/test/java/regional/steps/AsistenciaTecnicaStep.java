package regional.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import regional.ui.AgendaCitaUI;
import regional.ui.AsistenciaTecnicaUI;
import regional.ui.ClientesUI;
import regional.ui.ConstantesUI;
import regional.ui.GestionReclamoUI;
import regional.utilities.AccionesWeb;
import regional.utilities.UtilDatos;
import regional.utilities.UtilDatosAleatorios;

public class AsistenciaTecnicaStep {

	private AccionesWeb accionesWeb = new AccionesWeb();
	private String strNombreDeco;
	
	
	
	@Steps
	PortletStep portletStep;
	@Steps
	ClienteStep clienteStep;

	@Step
	public void diligenciaLaRazonDeEnvioDeControlRemoto() {
		diligencioMenuAsistenciaTecnica();
		diligenciaMotivoySubMotivo(UtilDatos.getMotivoControlRemoto(),UtilDatos.getSubmotivoContronRemoto());
	}

	@Step
	public void diligenciaProblemasIrd() {
		diligencioMenuAsistenciaTecnica();
		diligenciaMotivoySubMotivo(UtilDatos.getMotivoProblemasIRD(),UtilDatos.getSubmotivoProblemasIRD());
	}
	
	private void diligencioMenuAsistenciaTecnica() {
		cambioFrameComun();
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperaDesaparezcaElementoIntentos(AsistenciaTecnicaUI.getOverLayTramite(), 10);
		accionesWeb.esperoElementoVisible(AsistenciaTecnicaUI.getSelectSuperCategoria());
		accionesWeb.seleccionarOpcion(AsistenciaTecnicaUI.getSelectSuperCategoria(), UtilDatos.getOpcionAsistenciaTecnica());
		accionesWeb.esperaDesaparezcaElementoIntentos(AsistenciaTecnicaUI.getOverLayTramite(), 100);
		accionesWeb.esperoElementoVisible(AsistenciaTecnicaUI.getSelectSuperCategoria());
		accionesWeb.seleccionarOpcion(AsistenciaTecnicaUI.getSelectCategoria(), UtilDatos.getOpcionFallasEquipos());
		accionesWeb.esperaDesaparezcaElementoIntentos(AsistenciaTecnicaUI.getOverLayTramite(), 100);
		accionesWeb.tomarEvidencia();
	}
	
	private void diligenciaMotivoySubMotivo(String motivo, String subMotivo) {
		accionesWeb.esperoElementoVisible(AsistenciaTecnicaUI.getSelectMotivo());
		accionesWeb.seleccionarOpcion(AsistenciaTecnicaUI.getSelectMotivo(), motivo);
		accionesWeb.esperaDesaparezcaElementoIntentos(AsistenciaTecnicaUI.getOverLayTramite(), 20);
		accionesWeb.seleccionarOpcion(AsistenciaTecnicaUI.getSelectSubMotivo(), subMotivo);
		accionesWeb.tomarEvidencia();
		accionesWeb.clickBoton(AsistenciaTecnicaUI.getButtonNuevo());
	}

	@Step
	public void seleccionaDecodificador() {
		accionesWeb.esperaCargarPagina();
		accionesWeb.cambiarVentana(2);
		cambiarFrameTipoActividad();
		accionesWeb.esperoElementoVisible(AsistenciaTecnicaUI.getRdbtnDeco());
		
		int intDecos = accionesWeb.obtenerCantidadDeElementosPorXpath(AsistenciaTecnicaUI.getRdbtnDeco());
		int intDecoAle = UtilDatosAleatorios.obtenerIntAleatorioRango(intDecos);
		AsistenciaTecnicaUI.setRdbtnDeco(intDecoAle);
		AsistenciaTecnicaUI.setTxtNombreDeco(Integer.toString(intDecoAle + 1));
		accionesWeb.esperoElementoVisible(AsistenciaTecnicaUI.getRdbtnDeco());
		accionesWeb.clickBoton(AsistenciaTecnicaUI.getRdbtnDeco());
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperoElementoVisible(AsistenciaTecnicaUI.getButtonContinuar());		
		strNombreDeco = accionesWeb.extraerTextodeLabel(AsistenciaTecnicaUI.getTxtNombreDeco());
		accionesWeb.tomarEvidencia();
		accionesWeb.clickBoton(AsistenciaTecnicaUI.getButtonContinuar());
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperaDesaparezcaElementoIntentos(AsistenciaTecnicaUI.getOverLayTrVtn2(), 20);
	}

	public void cambiarFrameTipoActividad() {
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargandoproceso(), 100);
		accionesWeb.cambioDeFrameDefault();		
		accionesWeb.cambioDeFramePorId(UtilDatos.getIdFrameActividad());
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperaDesaparezcaElementoIntentos(AsistenciaTecnicaUI.getOverLayTrVtn2(), 100);
	}

	@Step
	public void resolucion() {
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperoElementoVisible(AsistenciaTecnicaUI.getRdbtnFalloControl());
		accionesWeb.esperoElementoVisible(AsistenciaTecnicaUI.getButtonContinuar());
		accionesWeb.clickBoton(AsistenciaTecnicaUI.getRdbtnFalloControl());
		accionesWeb.clickBoton(AsistenciaTecnicaUI.getButtonContinuar());
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperaDesaparezcaElementoIntentos(AsistenciaTecnicaUI.getOverLayTrVtn2(), 40);
		accionesWeb.esperoElementoVisible(AsistenciaTecnicaUI.getRbtnWorkorderCliente());
		accionesWeb.esperoElementoVisible(AsistenciaTecnicaUI.getButtonContinuar());
		accionesWeb.clickBoton(AsistenciaTecnicaUI.getRbtnWorkorderCliente());
		accionesWeb.clickBoton(AsistenciaTecnicaUI.getButtonContinuar());
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperaDesaparezcaElementoIntentos(AsistenciaTecnicaUI.getOverLayTrVtn2(), 40);
		accionesWeb.esperoElementoVisible(AsistenciaTecnicaUI.getButtonGenerarWorkorder());
		accionesWeb.esperaCargarPagina();
		accionesWeb.tomarEvidencia();
		accionesWeb.clickBoton(AsistenciaTecnicaUI.getButtonGenerarWorkorder());
	}

	@Step
	public void resolucionAsistencia() {
		accionesWeb.clickBoton(AsistenciaTecnicaUI.getRbtnTipoDeProducto());
		accionesWeb.tomarEvidencia();
		accionesWeb.clickBoton(AsistenciaTecnicaUI.getButtonContinuar());		
		accionesWeb.esperaDesaparezcaElementoIntentos(AsistenciaTecnicaUI.getOverLayTrVtn2(), 20);
		accionesWeb.esperoElementoVisible(AsistenciaTecnicaUI.getRbtnIrdNoEnciende());
		accionesWeb.clickBoton(AsistenciaTecnicaUI.getRbtnIrdNoEnciende());
		accionesWeb.tomarEvidencia();
		accionesWeb.clickBoton(AsistenciaTecnicaUI.getButtonContinuar());
		accionesWeb.esperaDesaparezcaElementoIntentos(AsistenciaTecnicaUI.getOverLayTrVtn2(), 10);
		accionesWeb.esperoElementoVisible(AsistenciaTecnicaUI.getRbtnWorkOrderNoSolucionado());
		accionesWeb.clickBoton(AsistenciaTecnicaUI.getRbtnWorkOrderNoSolucionado());
		accionesWeb.tomarEvidencia();
		accionesWeb.esperoElementoVisible(AsistenciaTecnicaUI.getButtonContinuar());
		accionesWeb.clickBoton(AsistenciaTecnicaUI.getButtonContinuar());
		accionesWeb.tomarEvidencia();
		accionesWeb.esperoElementoVisible(AsistenciaTecnicaUI.getButtonGenerarWorkorder());
		accionesWeb.clickBoton(AsistenciaTecnicaUI.getButtonGenerarWorkorder());
		accionesWeb.tomarEvidencia();
	}

	@Step
	public void generacionWorkOrder(String strNombreServicio) {
		String strTextoNorm;
		accionesWeb.cambiarVentana(3);
		cambiarFrameTipoActividad();
		accionesWeb.esperoElementoVisible(AsistenciaTecnicaUI.getTxtNomralizado());		
		strTextoNorm = accionesWeb.extraerTextodeLabel(AsistenciaTecnicaUI.getTxtNomralizado());
		accionesWeb.tomarEvidencia();
		if (strTextoNorm.contains("No")) {
			normalizarCliente();
		}
		accionesWeb.seleccionarOpcion(AsistenciaTecnicaUI.getSelectTipoServicio(), UtilDatos.getOpcionService());		
		accionesWeb.esperaCargarPagina();			
		accionesWeb.esperaDesaparezcaElementoIntentos(AsistenciaTecnicaUI.getOverLayTrVtn2(), 10);
		accionesWeb.esperoElementoVisible(AsistenciaTecnicaUI.getSelectNombreServicio());	
		accionesWeb.seleccionarOpcion(AsistenciaTecnicaUI.getSelectNombreServicio(), strNombreServicio);
		accionesWeb.esperaDesaparezcaElementoIntentos(AsistenciaTecnicaUI.getOverLayTrVtn2(), 10);
		accionesWeb.esperaCargarPagina();
		AsistenciaTecnicaUI.setRbtnDecoWO(strNombreDeco);
		accionesWeb.clickBoton(AsistenciaTecnicaUI.getRbtnDecoWO());		
		accionesWeb.esperaDesaparezcaElementoIntentos(AsistenciaTecnicaUI.getOverLayTrVtn2(), 10);
		accionesWeb.esperoElementoVisible(AsistenciaTecnicaUI.getButtonContinuarWo());
		accionesWeb.tomarEvidencia();
		accionesWeb.clickBoton(AsistenciaTecnicaUI.getButtonContinuarWo());
	}

	@Step
	private void normalizarCliente() {
		accionesWeb.clickBoton(AsistenciaTecnicaUI.getButtonModificarDomicilio());
		accionesWeb.cambiarVentana(4);
		cambiarFrameTipoActividad();
		accionesWeb.posicionarElementoScroll(AsistenciaTecnicaUI.getButtonNormalizar());
		accionesWeb.tomarEvidencia();
		accionesWeb.clickBoton(AsistenciaTecnicaUI.getButtonNormalizar());
		accionesWeb.cambiarVentana(5);
		portletStep.normalizarDireccion(UtilDatos.getDireccion());
		accionesWeb.cambiarVentana(4);
		cambiarFrameTipoActividad();
		accionesWeb.tomarEvidencia();
		accionesWeb.posicionarElementoScroll(AsistenciaTecnicaUI.getButtonContinuarNorm());
		accionesWeb.clickBoton(AsistenciaTecnicaUI.getButtonContinuarNorm());
		accionesWeb.cambiarVentana(3);
		cambiarFrameTipoActividad();
	}
	
	private void aceptarDomicilioInstalacion() {
		
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperaDesaparezcaElementoIntentos(AsistenciaTecnicaUI.getOverLayTrVtn2(), 100);
		accionesWeb.posicionarElementoScroll(AsistenciaTecnicaUI.getButtonNormalizar());
		accionesWeb.tomarEvidencia();
		accionesWeb.clickBoton(AsistenciaTecnicaUI.getButtonNormalizar());
		
	}
		
	private void aceptarInstalacionDomicilio() {
        accionesWeb.esperaCargarPagina();
        accionesWeb.cambiarVentana(2);
        accionesWeb.esperaCargarPagina();
        accionesWeb.tomarEvidencia();
        accionesWeb.cambioDeFrameDefault();
        accionesWeb.esperaCargarPagina();
        accionesWeb.cambioDeFrame(7);
        accionesWeb.esperaCargarPagina();
        accionesWeb.esperoElementoVisible(AsistenciaTecnicaUI.getImgModificacionDomicilio());
        accionesWeb.posicionarElementoScroll(AsistenciaTecnicaUI.getImgModificacionDomicilio());
        accionesWeb.tomarEvidencia();
        accionesWeb.clickBoton(AsistenciaTecnicaUI.getImgModificacionDomicilio());
        aceptarDomicilioInstalacion();
	}
	
	@Step
	public void normalizarClienteModficacionDomicilio() {
		UtilDatos.setDireccion(clienteStep.obtenerDireccion());	       
        aceptarInstalacionDomicilio();
        accionesWeb.esperaCargarPagina();
        accionesWeb.cambiarVentana(3);
        portletStep.normalizarDireccion( UtilDatos.getDireccion());
        accionesWeb.cambiarVentana(2);
        accionesWeb.cambioDeFrameDefault();
        accionesWeb.cambioDeFrame(7);
        accionesWeb.tomarEvidencia();
        accionesWeb.posicionarElementoScroll(AsistenciaTecnicaUI.getButtonContinuarNorm());
        accionesWeb.clickBoton(AsistenciaTecnicaUI.getButtonContinuarNorm());
        accionesWeb.esperaDesaparezcaElementoIntentos(AsistenciaTecnicaUI.getOverLayTrVtn2(), 100);
        accionesWeb.cambiarVentana(1);
        clienteStep.ingresarAPestanaCliente();
        accionesWeb.cambioDeFrame(2);
        clienteStep.clickBuscar();
	}
	
	@Step
	public void agendarCita() {
		
		accionesWeb.esperaDesaparezcaElementoIntentos(AsistenciaTecnicaUI.getOverLayTrVtn2(), 10);
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperoElementoVisible(AgendaCitaUI.getButtonGenerarCita());
		accionesWeb.tomarEvidencia();
		accionesWeb.clickBoton(AgendaCitaUI.getButtonGenerarCita());
	}

	private void diligenciaLaRazonModificacion(String strCategoria, String strMotivo) {
		accionesWeb.esperaCargarPagina();
		cambioFrameComun();
		accionesWeb.tomarEvidencia();		
		seleccionarLasCategorias(strCategoria);		
		seleccionarMotivo(strMotivo);		
		seleccionaElSubMotivo();
		accionesWeb.tomarEvidencia();
		accionesWeb.tomarEvidencia();
		accionesWeb.esperoElementoVisible(AsistenciaTecnicaUI.getButtonNuevo());
		accionesWeb.clickBoton(AsistenciaTecnicaUI.getButtonNuevo());
		accionesWeb.esperaCargarPagina();
	}

	private void seleccionarLasCategorias(String strCategoria) {
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargandoproceso(), 100);
		accionesWeb.esperoElementoVisible(AsistenciaTecnicaUI.getSelectSuperCategoria());
		accionesWeb.esperoElementoSelect(AsistenciaTecnicaUI.getSelectSuperCategoria());
		accionesWeb.esperaCargarPagina();
		accionesWeb.seleccionarOpcion(AsistenciaTecnicaUI.getSelectSuperCategoria(), "Actualización de datos");		
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargandoproceso(), 100);
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperoElementoVisible(AsistenciaTecnicaUI.getSelectCategoria());
		accionesWeb.esperoElementoSelect(AsistenciaTecnicaUI.getSelectCategoria());
		accionesWeb.seleccionarOpcion(AsistenciaTecnicaUI.getSelectCategoria(), strCategoria);
		
		accionesWeb.tomarEvidencia();
	}

	private void seleccionarMotivo(String strMotivo) {
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargandoproceso(), 100);
		accionesWeb.esperaCargarPagina();
		accionesWeb.tomarEvidencia();
		accionesWeb.esperoElementoVisible(AsistenciaTecnicaUI.getSelectMotivo());
		accionesWeb.esperoElementoSelect(AsistenciaTecnicaUI.getSelectMotivo());
		accionesWeb.seleccionarOpcion(AsistenciaTecnicaUI.getSelectMotivo(), strMotivo);
	}

	private void seleccionaElSubMotivo() {
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargandoproceso(), 100);
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperoElementoVisible(AsistenciaTecnicaUI.getSelectSubMotivo());
		accionesWeb.esperoElementoSelect(AsistenciaTecnicaUI.getSelectSubMotivo());
	    accionesWeb.esperoElementoHabilitado(AsistenciaTecnicaUI.getSelectSubMotivo());
		accionesWeb.esperaCargarPagina();
		accionesWeb.clickBoton(AsistenciaTecnicaUI.getSelectSubMotivo());
		accionesWeb.seleccionarOpcion(AsistenciaTecnicaUI.getSelectSubMotivo(), UtilDatos.getSeleccionaSubmotivo());
		accionesWeb.tomarEvidencia();
		
		
		
	}
	
	@Step
	public void diligenciarModificacionTelefono() {
		diligenciaLaRazonModificacion(UtilDatos.getModificacionTelefonos(),UtilDatos.getModificacionDatos());
		accionesWeb.cambiarVentana(2);
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperaCargarPagina();
		accionesWeb.tomarEvidencia();
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.cambioDeFrame(7);
		accionesWeb.esperaCargarPagina();
		modificarTelefonoPais();	
		accionesWeb.tomarEvidencia();
		continuarModificacion();
		accionesWeb.esperaCargarPagina();
	}

	
	@Step
	public void diligenciarModificacionEmail() {
		diligenciaLaRazonModificacion(UtilDatos.getModificacionEmail(),UtilDatos.getModificacionDatos());	
		accionesWeb.cambiarVentana(2);
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargandoproceso(), 50);
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperaCargarPagina();
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.cambioDeFrame(7);
		accionesWeb.esperaCargarPagina();
		accionesWeb.tomarEvidencia();
		diligenciarCorreo();	
	}
	
	private void cambioFrameComun() {
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargandoproceso(), 50);
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargandoproceso(), 50);
		accionesWeb.cambioDeFramePorId(UtilDatos.getIdFrameActividad());
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperaDesaparezcaElementoIntentos(AsistenciaTecnicaUI.getOverLayTramite(), 10);
		accionesWeb.cambiarFramePorelemento(AsistenciaTecnicaUI.getXpathFrameGenericoEngage());
		accionesWeb.cambioDeFramePorId(UtilDatos.getIdFrameActividad());
	}
	
	
	@Step
	public void seleccionarSuperCategoria() {
		cambioFrameComun();
		accionesWeb.esperaCargarPagina();	
		accionesWeb.editaTiempoImplicito(2);
		accionesWeb.esperoElementoSelect(AsistenciaTecnicaUI.getSelectSuperCategoria());		
		accionesWeb.seleccionarOpcion(AsistenciaTecnicaUI.getSelectSuperCategoria(), UtilDatos.getSuperCategoria());
		accionesWeb.tomarEvidencia();	
		accionesWeb.resetImplicitTimeout();
	}
	
	@Step
	public void diligenciarMotivoPQR( String motivo) {
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargandoproceso(), 100);
		accionesWeb.esperaCargarPagina();
		accionesWeb.editaTiempoImplicito(2);
		accionesWeb.esperoElementoSelect(AsistenciaTecnicaUI.getSelectMotivo());
		accionesWeb.seleccionarOpcion(AsistenciaTecnicaUI.getSelectMotivo(), motivo);
		accionesWeb.tomarEvidencia();
	}
	
	@Step
	public void diligenciarSubMotivoPQR( String submotivo) {
		accionesWeb.esperaDesaparezcaElementoIntentos(AsistenciaTecnicaUI.getOverLayTramite(), 10);
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargandoproceso(), 100);
		accionesWeb.esperaCargarPagina();
		accionesWeb.editaTiempoImplicito(2);
		accionesWeb.esperoElementoVisible(AsistenciaTecnicaUI.getSelectSubMotivo());
		accionesWeb.seleccionarOpcion(AsistenciaTecnicaUI.getSelectSubMotivo(), submotivo);
		accionesWeb.tomarEvidencia();
		accionesWeb.clickBoton(AsistenciaTecnicaUI.getButtonNuevo());
	}
	
	@Step
	public void seleccionarSubCategoriaContacto( String motivo) {
		accionesWeb.esperaDesaparezcaElementoIntentos(AsistenciaTecnicaUI.getOverLayTramite(), 50);
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperoElementoVisible(GestionReclamoUI.getSelectSubCategoriaContacto());
		accionesWeb.seleccionarOpcion(GestionReclamoUI.getSelectSubCategoriaContacto(), motivo);
		accionesWeb.tomarEvidencia();	
	}
	@Step
	public void seleccionarCategoriaDerivar( String motivo) {
		
		accionesWeb.seleccionarOpcion(GestionReclamoUI.getSelectCategoriaDerivacion(), motivo);
		accionesWeb.esperaDesaparezcaElementoIntentos(AsistenciaTecnicaUI.getOverLayTramite(), 20);
	}
	

	@Step
	public void seleccionarSegundaSubcategoriaContacto( String submotivo) {
		accionesWeb.esperaDesaparezcaElementoIntentos(AsistenciaTecnicaUI.getOverLayTramite(), 10);
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargandoproceso(), 100);
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperoElementoVisible(GestionReclamoUI.getSelectSecondSubCategoriaContacto());
		accionesWeb.posicionarElementoScroll(GestionReclamoUI.getSelectSecondSubCategoriaContacto());
		accionesWeb.seleccionarOpcion(GestionReclamoUI.getSelectSecondSubCategoriaContacto(), submotivo);
		accionesWeb.tomarEvidencia();
	}
	@Step
	public void seleccionarSubMotivoADerivar( String submotivo) {
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargandoproceso(), 100);
		accionesWeb.seleccionarOpcion(GestionReclamoUI.getSelectSubmotivoDerivacion(), submotivo);
		
	}
	@Step
	public void seleccionarMotivoDerivar( String motivo) {
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargandoproceso(), 100);
		accionesWeb.esperoElementoVisible(GestionReclamoUI.getSelectMotivoDerivacion());
		accionesWeb.esperoElementoHabilitado(GestionReclamoUI.getSelectMotivoDerivacion());
		accionesWeb.seleccionarOpcion(GestionReclamoUI.getSelectMotivoDerivacion(), motivo);
		accionesWeb.tomarEvidencia();
		
	}
	

	@Step
	public void clickFinalizar() {	
			accionesWeb.cambiarVentana(1);
			accionesWeb.esperaCargarPagina();
			accionesWeb.editaTiempoImplicito(2);
			accionesWeb.cambioDeFrame(7);
			accionesWeb.esperaDesaparezcaElementoIntentos(AsistenciaTecnicaUI.getOverLayTramite(), 2);
			accionesWeb.posicionarElementoScroll(GestionReclamoUI.getBtnFinalizar());
			accionesWeb.tomarEvidencia();
			accionesWeb.clickBoton(GestionReclamoUI.getBtnFinalizar());
			accionesWeb.restauraTiempoImplicitoPorDefecto();
			
		
	}
	
	@Step
	public void validarDerivacion() {
		
		accionesWeb.cambiarVentana(1);
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.cambioDeFramePorId(UtilDatos.getIdFrameActividad());
		accionesWeb.posicionarElementoScroll(GestionReclamoUI.getBtnContactos());
		accionesWeb.clickBoton(GestionReclamoUI.getBtnContactos());
		accionesWeb.tomarEvidencia();	
		accionesWeb.clickBoton(GestionReclamoUI.getBtnVolver());
		accionesWeb.restauraTiempoImplicitoPorDefecto();
	}
	
	
	
	

	@Step
    public void diligenciarModificacionDomicilio() {
        diligenciaLaRazonModificacion(UtilDatos.getModificacionDomicilio(),UtilDatos.getModificacionConWO());
        accionesWeb.tomarEvidencia();
        
    }
	
	private void modificarTelefonoPais() {

		switch (UtilDatos.getPais()) 
		{
		case "EC":
			modificarTelefonoEC();
			break;
		case "CO":
			modificarTelefonoCO();
			break;
		case "UY":
			modificarTelefonoUY();
			break; 
		case "PE":
			modificarTelefonoPE();
			break;
		case "AR":
			modificarTelefonoAR();
			break;
		case "CL":
			modificarTelefonoCL();
			break;
		default:
			modificarTelefonoEC();
			break; 
		}
	}

	private void modificarTelefonoAR() {
		accionesWeb.cambiarVentana(2);
		cambioFrameComun();
		accionesWeb.esperoElementoVisible(ClientesUI.getCmbTelefonoFijoAr());
		accionesWeb.esperoElementoHabilitado(ClientesUI.getCmbTelefonoFijoAr());
		accionesWeb.darClickCheckBox(ClientesUI.getCmbTelefonoFijoAr());
		UtilDatos.setTelefono(UtilDatosAleatorios.fijoAleatorioT("01"));  
		accionesWeb.limpiarCampo(ClientesUI.getTxtPrefijoArgentina());
		accionesWeb.limpiarCampo(ClientesUI.getTxtNumeroFijoArgentina());				
		accionesWeb.escribirTextoSendKeys(ClientesUI.getTxtPrefijoArgentina(),"99");
		accionesWeb.escribirTextoSendKeys(ClientesUI.getTxtNumeroFijoArgentina(),UtilDatos.getTelefono());			
		accionesWeb.tomarEvidencia();
		accionesWeb.clickBoton(AsistenciaTecnicaUI.getBtnGrabarModificacionCorporativo());
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.cambioDeFramePorId(UtilDatos.getIdFrameActividad());
		accionesWeb.clickBoton(AsistenciaTecnicaUI.getBtnContinuarModificacionCorporativo());
	}

	public void modificarTelefonoPE() {
		UtilDatos.setCelular(UtilDatosAleatorios.obtenerNumeroTelefonoAleatorio(22, 5));
		UtilDatos.setTelefono(UtilDatosAleatorios.obtenerNumeroTelefonoAleatorio(12, 5));  
		accionesWeb.darClickCheckBox(ClientesUI.getCmbTelefonoModificacion());
		accionesWeb.esperoElementoVisible(ClientesUI.getTelefonoModificacion());
		accionesWeb.escribirTextoSendKeys(ClientesUI.getPrefijoTelefonoHogarModificacion(),"01");
		accionesWeb.escribirTextoSendKeys(ClientesUI.getTelefonoHogarModificacion(),UtilDatos.getTelefono());
		accionesWeb.tomarEvidencia();
	}

	private void modificarTelefonoUY() {
		UtilDatos.setCelular(UtilDatosAleatorios.fijoAleatorioT("22"));
		UtilDatos.setTelefono(UtilDatosAleatorios.fijoAleatorioT("22"));	
		accionesWeb.darClickCheckBox(ClientesUI.getCmbTelefonoModificacion());
		accionesWeb.esperoElementoVisible(ClientesUI.getTelefonoModificacion());
		accionesWeb.escribirTextoSendKeys(ClientesUI.getTelefonoModificacion(), UtilDatos.getCelular());
		accionesWeb.darClickCheckBox(ClientesUI.getCmbTelefonoTrabajoModificacion());
		accionesWeb.escribirTextoSendKeys(ClientesUI.getTelefonoTrabajoModificacion(),UtilDatos.getTelefono());
		accionesWeb.tomarEvidencia();
	}

	private void modificarTelefonoCO() {
		UtilDatos.setTelefonoHogar(UtilDatosAleatorios.fijoAleatorioT("44"));
		UtilDatos.setTelefonoTrabajo(UtilDatosAleatorios.fijoAleatorioT("44"));
		UtilDatos.setCelular(UtilDatosAleatorios.celAleatorioT("31"));
		UtilDatos.setFaxTelefono(UtilDatosAleatorios.fijoAleatorioT("44"));						
		accionesWeb.darClickCheckBox(ClientesUI.getCmbTelefonoModificacion());
		accionesWeb.escribirTextoSendKeys(ClientesUI.getPrefijoTelefonoHogarModificacion(),"05");
		accionesWeb.escribirTextoSendKeys(ClientesUI.getCodAreaTelefonoHogarModificacionCO(), "7"); 
		accionesWeb.esperoElementoVisible(ClientesUI.getTelefonoHogarModificacion());
		accionesWeb.escribirTextoSendKeys(ClientesUI.getTelefonoHogarModificacion(),UtilDatos.getTelefonoHogar());
		accionesWeb.tomarEvidencia();
	}

	private void modificarTelefonoEC() {
		accionesWeb.darClickCheckBox(ClientesUI.getCmbTelefonoModificacion());
		accionesWeb.clickBoton(ClientesUI.getCmbTelefonoModificacion());
		UtilDatos.setCelular(UtilDatosAleatorios.celAleatorioT("2"));
		UtilDatos.setTelefono(UtilDatosAleatorios.celAleatorioT("2"));
		accionesWeb.esperoElementoVisible(ClientesUI.getTelefonoHogarModificacion());
		accionesWeb.escribirTextoSendKeys(ClientesUI.getTelefonoModificacionPrefijo(), UtilDatosAleatorios.celAleatorioT("2"));
		accionesWeb.escribirTextoSendKeys(ClientesUI.getTelefonoHogarModificacion(), UtilDatos.getCelular());
		accionesWeb.darClickCheckBox(ClientesUI.getCmbTelefonoTrabajoModificacion());
		accionesWeb.escribirTextoSendKeys(ClientesUI.getTelefonoTrabajoModificacionPrefijo(),UtilDatosAleatorios.celAleatorioT("2"));
		accionesWeb.escribirTextoSendKeys(ClientesUI.getTelefonoTrabajoModificacionEc(),UtilDatos.getTelefono());
		accionesWeb.tomarEvidencia();
	}
	
	private void modificarTelefonoCL() {
		accionesWeb.darClickCheckBox(ClientesUI.getCmbTelefonoModificacion());
		accionesWeb.clickBoton(ClientesUI.getCmbTelefonoModificacion());
		UtilDatos.setCelular(UtilDatosAleatorios.celAleatorioT("2"));
		UtilDatos.setTelefono(UtilDatosAleatorios.celAleatorioT("2"));
		accionesWeb.esperoElementoVisible(ClientesUI.getTelefonoHogarModificacion());
		accionesWeb.escribirTextoSendKeys(ClientesUI.getTxtPrefijoArgentina(), UtilDatosAleatorios.celAleatorioT("2"));
		accionesWeb.escribirTextoSendKeys(ClientesUI.getTxtNumeroFijoArgentina(), UtilDatos.getCelular());
		accionesWeb.darClickCheckBox(ClientesUI.getCmbTelefonoTrabajoModificacion());
		accionesWeb.escribirTextoSendKeys(ClientesUI.getTelefonoTrabajoModificacionPrefijo(),UtilDatosAleatorios.celAleatorioT("2"));
		accionesWeb.escribirTextoSendKeys(ClientesUI.getTelefonoTrabajoModificacionEc(),UtilDatos.getTelefono());
		accionesWeb.tomarEvidencia();
	}
	
	private void continuarModificacion() {
			accionesWeb.clickBoton(ClientesUI.getBtnContinuarModificacion());
	}
	
	public void diligenciarCorreo() {
		UtilDatos.setUsuarioCorreo(UtilDatos.getUsuariCorreo());
		UtilDatos.setDominio(UtilDatos.getSetDominio());
		UtilDatos.setDns(UtilDatos.getSetDNS());
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperoElementoVisible(ClientesUI.getTxtUsuarioModificacionEmail());		
		accionesWeb.escribirTextoSendKeys(ClientesUI.getTxtUsuarioModificacionEmail(), UtilDatos.getUsuarioCorreo());
		accionesWeb.escribirTextoSendKeys(ClientesUI.getTxtDominioModificacionEmail(), UtilDatos.getDominio());
		accionesWeb.seleccionaOpcionContengaTexto(ClientesUI.getSelTipoDominioModificacionEmail(), UtilDatos.getDns());
		seleccionarDominioPais();
		accionesWeb.tomarEvidencia();
		accionesWeb.clickBoton(ClientesUI.getBtnContinuarModificacion());
	}
	
	public void seleccionarDominioPais() {

		String dominioPais = "";
		switch (UtilDatos.getPais()) 
		{
		case "EC": 
			dominioPais =  ".ec";
			break;
		case "PE": 
			dominioPais =  ".pe";
			break;

		default: 
			dominioPais =  ".uy";
			break; 
		}
		UtilDatos.setDominioPais(dominioPais);
		accionesWeb.seleccionaOpcionContengaTexto(ClientesUI.getSelTipoRegionModificacionEmail(), UtilDatos.getDominioPais());
	}
	
	@Step
	public void tramitaEnvioDeControlRemoto() {
		seleccionaDecodificador();
		resolucion();
		generacionWorkOrder(UtilDatos.getWorkOrderControlRemoto());
		agendarCita();
	}
	
	@Step
	public void tramitaEnviosIrd() {
		seleccionaDecodificador();
		resolucionAsistencia();
		generacionWorkOrder(UtilDatos.getUWorkOrderIRD());
	}
	
	@Step
	public void agregarComentario(String comentario) {
		String cadena= "";
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperoElementoVisible(GestionReclamoUI.getTxtObservacion());
		cadena=accionesWeb.extraerTextodeLabel(GestionReclamoUI.getTxtObservacion());
		cadena = cadena + " " + comentario;
		accionesWeb.escribirTexto(GestionReclamoUI.getTxtObservacion(), cadena); 
		accionesWeb.tomarEvidencia();
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.cambioDeFramePorId(UtilDatos.getIdFrameActividad());
		accionesWeb.clickBoton(GestionReclamoUI.getButtonContinuar());
		accionesWeb.esperaDesaparezcaElementoIntentos(AsistenciaTecnicaUI.getOverLayTramite(), 4);
		accionesWeb.tomarEvidencia();
			
		
	}
		
}
