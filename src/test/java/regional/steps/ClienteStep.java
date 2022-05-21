package regional.steps;

import java.io.IOException;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import exceptions.ExceptionsProyecto;
import net.thucydides.core.annotations.Step;
import regional.ui.AsistenciaTecnicaUI;
import regional.ui.ClientesUI;
import regional.ui.ConstantesUI;
import regional.ui.GestionRetencionUI;
import regional.utilities.AccionesWeb;
import regional.utilities.UtilDatos;
import regional.utilities.UtilDatosEstaticos;
import regional.utilities.UtilConsulta;

public class ClienteStep {

	
	private AccionesWeb accionesWeb = new AccionesWeb();
	private static final String ID_FRAME_ACTIVIDAD = "Actividad";
	private Logger logger = LoggerFactory.getLogger(ClienteStep.class);
	
	UtilConsulta utilConsulta;
	AsistenciaTecnicaStep asistenciaTecnicaStep;
	UtilDatos utilDatos;
	
	
		
	@Step
	public void procesoSeleccionCliente(String estado) throws IOException {
		
		String strClientePospago = "";
		
		ingresarAPestanaCliente();
		seleccionarTipoCliente();
		ingresarCodigoPais();
		
		if ( UtilDatos.getClientePospago().length() < 1) {
		  strClientePospago = utilConsulta.extraeIdClientePospagoNormal(UtilDatos.getAmbienteSesamo(), UtilDatos.getAmbiente().split("-")[0].toLowerCase());
	
		  UtilDatos.setClientePospago(strClientePospago);
		}
		
		ingresarNumeroCliente(UtilDatos.getClientePospago());
		clickBuscar();
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargandoSeleccionarCliente(), 50);
		verificarEstadoCliente(estado);
		seleccionarCliente(UtilDatos.getClientePospago());
		
	}

	public void ingresarCliente() {
		
		ingresarAPestanaCliente();
		seleccionarTipoCliente();
		ingresarCodigoPais();
	}
	
	public void seleccionarUnCliente( String strEstado) {
		ingresarAPestanaCliente();
		seleccionarTipoCliente();
		ingresarCodigoPais();
		ingresarNumeroCliente(UtilDatos.getClientePospago());
		clickBuscar();
		verificarEstadoCliente(strEstado);
		seleccionarCliente(UtilDatos.getClientePospago());
	}
	
	@Step
	public void ingresarAPestanaCliente() {
		accionesWeb.esperaCargarPagina();
		accionesWeb.cambiarVentana(1);
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperoElementoVisible(ClientesUI.getTabsEngage());
		accionesWeb.clickBoton(ClientesUI.getTabsEngage());
	}
	
	@Step
	public void obtenerEmailValido(String perfil) {
		
		String email = "";
		
		accionesWeb.esperaCargarPagina();
		accionesWeb.cambioDeFrameDefault();
	    accionesWeb.cambioDeFramePorId(ID_FRAME_ACTIVIDAD);
	    
	    email = extraerEmailActual(perfil);
	    
	    if (!email.contains("@")) {
	    	diligenciarEmailValido(perfil);
			continuarModificacionEmail();
	    }
	    
	    UtilDatos.setUsuarioCorreo(extraerEmailActual(perfil));
	    UtilDatos.getUsuarioCorreo();
		
	}
	
	private String extraerEmailPais() {
		String email = "";
		
		switch (UtilDatos.getPais()) {
		case UtilDatosEstaticos.PAIS_PE:
			accionesWeb.esperoElementoVisible(ClientesUI.getTxtEmailCliente());
        	email = accionesWeb.extraerTextodeLabel(ClientesUI.getTxtEmailCliente());
        	break;
		case UtilDatosEstaticos.PAIS_UY:
			accionesWeb.esperoElementoVisible(ClientesUI.getTxtEmailClienteUy());
        	email = accionesWeb.extraerTextodeLabel(ClientesUI.getTxtEmailClienteUy());	
			break;

		default:
			
			break;
		}
		
		return email;
	}
	
	public String extraerEmailActual(String perfil) {
		String email = "";
		switch (perfil) 
	        {
		        case "PQR": 
		        	accionesWeb.esperoElementoVisible(ClientesUI.getTxtEmailClientePqr());
		        	email = accionesWeb.extraerTextodeLabel(ClientesUI.getTxtEmailClientePqr());
		        break;
		        case "PQR AR":
		        	accionesWeb.esperoElementoVisible(ClientesUI.getTxtEmailClientePqrAr());
		        	email = accionesWeb.extraerTextodeLabel(ClientesUI.getTxtEmailClientePqrAr());
		        	break;
		      
		        default: 
		        	email = extraerEmailPais();
		        break;	        
	        }

		return email;
	}
	
	private void clickModificarEmailPais() {
		
		accionesWeb.esperaCargarPagina();
		accionesWeb.cambioDeFrameDefault();
	    accionesWeb.cambioDeFramePorId(ID_FRAME_ACTIVIDAD);
		
		switch (UtilDatos.getPais()) {
		case UtilDatosEstaticos.PAIS_UY:
			accionesWeb.clickBoton(ClientesUI.getImgModificarEmialUy());
			break;
		case UtilDatosEstaticos.PAIS_PE:
			accionesWeb.clickBoton(ClientesUI.getImgModificarEmailCliente());
			break;

		default:
			break;
		}
	}
	
	public void diligenciarEmailValido(String perfil){
		
		if(perfil.equals("PQR AR")) {
			accionesWeb.clickBoton(ClientesUI.getImgModificarEmailClientePqrAr());
        	accionesWeb.cambiarVentana(2);			
			diligenciarEmailValidoPqrAr();
		}else {
			clickModificarEmailPais();
        	accionesWeb.cambiarVentana(2);			
			diligenciarEmailValido();
			seleccionarDominioDeEmailValido();	
		}
			
	}
	
	public void continuarModificacionEmail() {
		accionesWeb.esperaCargarPagina();
		accionesWeb.clickBoton(ClientesUI.getBtnContinuarModificacion());
	    accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
	    accionesWeb.tomarEvidencia();
		accionesWeb.cambiarVentana(1);
		accionesWeb.cambioDeFrameDefault();
	    accionesWeb.cambioDeFramePorId(ID_FRAME_ACTIVIDAD);
	    
	}
	
	@Step
	public void seleccionarTipoCliente() {
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.cambioDeFrame(2);		
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperoElementoVisible(ClientesUI.getSeleccionarTipoCliente());
		accionesWeb.esperoElementoHabilitado(ClientesUI.getSeleccionarTipoCliente());
    	accionesWeb.escribirTextoSendKeys(ClientesUI.getSeleccionarTipoCliente(), UtilDatos.getCliente());
	}
	
	@Step
	public void obtenerClientePospagoNormal() throws IOException  {
		
		String cliente = utilConsulta.extraeIdClientePospagoNormal(UtilDatos.getAmbienteSesamo(), UtilDatos.getAmbiente().split("-")[0].toLowerCase());
		UtilDatos.setClientePospago(cliente);
	}
	
	@Step
	public void obtenerClienteCancelado() throws IOException  {
		
		 utilConsulta.clienteCanceladoPendiente(UtilDatos.getAmbienteSesamo(), UtilDatos.getAmbiente().split("-")[0].toLowerCase(),"ClienteCancelacionPendiente");
		 ingresarNumeroCliente(UtilDatos.getClientePospago());
		 clickBuscar();
		
	}
	
	@Step
	public void ingresarCodigoPais() {
		accionesWeb.esperoElementoVisible(ClientesUI.getTxtPais());
		accionesWeb.esperoElementoHabilitado(ClientesUI.getTxtPais());
		accionesWeb.escribirTexto(ClientesUI.getTxtPais(), UtilDatos.getAmbiente().split("-")[0].toLowerCase());  
	}
	
	@Step
	public void ingresarNumeroCliente() {     
		accionesWeb.esperoElementoVisible(ClientesUI.getTxtNumeroCliente());
		accionesWeb.escribirTexto(ClientesUI.getTxtNumeroCliente(), UtilDatos.getClientePospago());
	}
	
	@Step
	public void ingresarNumeroCliente(String noCliente) {
		accionesWeb.esperoElementoVisible(ClientesUI.getTxtNumeroCliente());
		accionesWeb.escribirTexto(ClientesUI.getTxtNumeroCliente(), noCliente);
	}
	
	@Step
	public void clickBuscar() {
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperoElementoVisible(ClientesUI.getBtnBuscar());
		accionesWeb.clickBoton(ClientesUI.getBtnBuscar());
	}

	@Step
	public void seleccionarCliente() {
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
		accionesWeb.esperoElementoVisible(ClientesUI.getTxtNumeroCliente());
		accionesWeb.esperoElementoHabilitado(ClientesUI.getTxtNumeroCliente());
		ClientesUI.setConsultaCliente(UtilDatos.getClientePospago());
		accionesWeb.esperoElementoVisible(ClientesUI.getSelectCliente());
		accionesWeb.esperoElementoHabilitado(ClientesUI.getSelectCliente());
		accionesWeb.esperaCargarPagina();
		accionesWeb.darClickEnBotonEspecial(ClientesUI.getSelectCliente());
		accionesWeb.tomarEvidencia();
	}

	@Step
	public void seleccionarCliente(String noCliente) {
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperoElementoVisible(ClientesUI.getSelectCliente());
		ClientesUI.setConsultaCliente(noCliente);	
		accionesWeb.esperoElementoVisible(ClientesUI.getEstadocliente());
		accionesWeb.clickBoton(ClientesUI.getSelectCliente());
		accionesWeb.tomarEvidencia();
	}
	

	@Step
	public void seleccionarProceso() {
		
		procesoDisponible();
		
	}
	
	@Step
	public void seleccionarProceso(String strProceso) {

		accionesWeb.esperaCargarPagina();
		accionesWeb.esperoElementoVisible(ClientesUI.getCmbProceso());
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargandoproceso(), 80);
		accionesWeb.esperoElementoVisible(ClientesUI.getCmbProceso());
		accionesWeb.clickBoton(ClientesUI.getSelectListaProceso());
		accionesWeb.clickElementoLista(ClientesUI.getSelectProceso(), strProceso);
		clickNuevoProceso();
		accionesWeb.tomarEvidencia();
	}
	
	
	private void procesoDisponible() {
		
		String procesoDispo = "";
		
		switch (UtilDatos.getPais()) 
        {
	        case "EC": 
	        	procesoDispo = "Acceso Rapido de Tramites";
	        break;
	        case "PE":  
	        	procesoDispo = "Retenciones Peru";
	        break;
	        case "UY":  
	        	procesoDispo = "Informacion del Cliente";
	        break;
	        default: 
	        	procesoDispo = "Informacion del Cliente";
	        break;
	        
        }
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperoElementoVisible(ClientesUI.getCmbProceso());
		accionesWeb.esperoElementoVisible(ClientesUI.getSelectListaProceso());
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargandoproceso(), 120);
		accionesWeb.clickBoton(ClientesUI.getSelectListaProceso());
		if(accionesWeb.validarListaContineDato(ClientesUI.getSelectProceso(), procesoDispo))
			accionesWeb.clickElementoLista(ClientesUI.getSelectProceso(), procesoDispo);
		else
	        accionesWeb.escribirTextoSendKeys(ClientesUI.getCmbProceso(), procesoDispo);
		accionesWeb.tomarEvidencia();
		clickNuevoProceso();
		accionesWeb.cambioDeFrameDefault();
    	accionesWeb.cambioDeFramePorId(ID_FRAME_ACTIVIDAD);
	}
	
	@Step
	public void clickNuevoProceso() {
		accionesWeb.esperoElementoVisible(ClientesUI.getBtnNuevoProceso());
		accionesWeb.esperoElementoHabilitado(ClientesUI.getBtnNuevoProceso());		
		accionesWeb.clickBoton(ClientesUI.getBtnNuevoProceso());
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 200);
	}
	
	@Step
	public void seleccionarResultado() {
		preparacionSeleccion();
		switch (UtilDatos.getPais()) {
	        case "UY":  
	        case "PE":  
	        	accionesWeb.seleccionaOpcionContengaTexto(ClientesUI.getCmbResultado(), "Baja");
	        	break; 
	        default:
	        	break;
        }
		accionesWeb.tomarEvidencia();
	}
	
	@Step
	public void clickContinuarProceso() {
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
		accionesWeb.esperoElementoVisible(ClientesUI.getBtnContinuarResultado());
		accionesWeb.esperoElementoHabilitado(ClientesUI.getBtnContinuarResultado());
		accionesWeb.tomarEvidencia();
		accionesWeb.clickBoton(ClientesUI.getBtnContinuarResultado());
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
	}
	
	@Step
	public void clickBotonAgregar() {
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
		accionesWeb.esperoElementoVisible(ClientesUI.getBtnAgregar());
		accionesWeb.tomarEvidencia();
		accionesWeb.clickBoton(ClientesUI.getBtnAgregar());
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
		accionesWeb.cambioDeFrameDefault();
	}
	
	@Step
	public void verificarEstadoRetencion(String direccionCliente) {
		accionesWeb.bordearElemento(ClientesUI.getEstadocliente());
		accionesWeb.validarTextoDeUnElemetoContieneTexto(ClientesUI.getEstadocliente(), direccionCliente);
		accionesWeb.tomarEvidencia();
	}
	
	@Step
	public void guardarCaptura() {
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
		accionesWeb.cambioDeFrameDefault();
    	accionesWeb.cambioDeFramePorId(ID_FRAME_ACTIVIDAD);	
    	accionesWeb.tomarEvidencia();
		accionesWeb.clickPosibleElemento(GestionRetencionUI.getBtnReIntentarContinuar(), 2);
		
	}
	
	private void buscaIngresaClienteSesamo() {
		try {
			UtilDatos.setClientePospago(utilConsulta.extraeIdClientePospagoNormal(UtilDatos.getAmbienteSesamo(), UtilDatos.getAmbiente().split("-")[0].toLowerCase()));
		} catch (Exception e) {
			logger.error("Fallo en la consulta de sesamo para obtener cliente "+e);
			excepcionUtilConsulta(e);
		}
		ingresarNumeroCliente(UtilDatos.getClientePospago());
		clickBuscar();
		accionesWeb.esperaCargarPagina();
	}
	
	@Step
	public void  verificarClienteNormal(String strClientePospago) {
		boolean clienteIncorrecto = true ;
		Integer intContador = 0;
		while (clienteIncorrecto && intContador <= 5) {
			intContador = intContador + 1;
			if(intContador > 5)	{
				ExceptionsProyecto.excepcionComprometidoServicios("No se encontró cliente en estado pending cancellation");
			}
			String strTipoCliente = accionesWeb.extraerTextodeLabel(ClientesUI.getTipocliente());
			String strEstadoCliente = accionesWeb.extraerTextodeLabel(ClientesUI.getEstadocliente());
			if (strTipoCliente.contains("Normal") && strEstadoCliente.contains("Normal")) {
				clienteIncorrecto = false;
			} else {
				clienteIncorrecto = true;
				buscaIngresaClienteSesamo();
			}
			accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
		}
		accionesWeb.tomarEvidencia();
	}

	@Step
	public void verificarEstadoCliente(String strEstado) {
		boolean clienteIncorrecto = true ;
		Integer intContador = 0;
		while ((clienteIncorrecto) && (intContador<=5)) {
			intContador = intContador + 1;
			if(intContador > 5)	{
				ExceptionsProyecto.excepcionComprometidoServicios("No se encontró cliente en estado normal");
			}
			accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 50);
			accionesWeb.esperoElementoVisible(ClientesUI.getEstadocliente());
			String strEstadoCliente = accionesWeb.extraerTextodeLabel(ClientesUI.getEstadocliente());
			if (strEstadoCliente.contains(strEstado)) {
				clienteIncorrecto = false;
			} else {
				clienteIncorrecto = true;
				buscaIngresaClienteSesamo();
			}
		}
	}
	
	@Step
	public void seleccionarWinback() {
		preparacionSeleccion();
		accionesWeb.seleccionarOpcion(ClientesUI.getCmbResultado(), UtilDatos.getWinback());
		accionesWeb.tomarEvidencia();
	}

	private void preparacionSeleccion() {
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargandoproceso(), 150);
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.esperaCargarPagina();
		accionesWeb.cambioDeFramePorId(ID_FRAME_ACTIVIDAD);
		accionesWeb.esperoElementoVisible(ClientesUI.getCmbResultado());
		accionesWeb.posicionarElementoScroll(ClientesUI.getCmbResultado());
		accionesWeb.tomarEvidencia();
	}
	@Step
    public void verificarDireccion(String direccionCliente) {
		accionesWeb.esperaCargarPagina();
        accionesWeb.bordearElemento(ClientesUI.getDireccioncliente());
        accionesWeb.validarTextoDeUnElemetoModificacion(ClientesUI.getDireccioncliente(), direccionCliente );
        accionesWeb.tomarEvidencia();
     }
	
	@Step
    public void verificarEmail() {
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperaCargarPagina();
        accionesWeb.cambioDeFrameDefault();
	    accionesWeb.clickPosibleElemento(ClientesUI.getBtnProcesoActivo(), 2);
	    accionesWeb.cambioDeFramePorId(ID_FRAME_ACTIVIDAD);
	    accionesWeb.esperaCargarPagina();
	  
	    
	   
	}
	
	@Step
    public void verificarTelefono() {
		accionesWeb.esperaCargarPagina();
	    accionesWeb.cambioDeFrameDefault();
	    accionesWeb.clickPosibleElemento(ClientesUI.getBtnProcesoActivo(), 2);
	    accionesWeb.cambioDeFramePorId(ID_FRAME_ACTIVIDAD);
	    accionesWeb.esperoElementoVisible(ClientesUI.getLblDomicilioTelFijo());
	    accionesWeb.esperoElementoHabilitado(ClientesUI.getLblDomicilioTelFijo());
        accionesWeb.bordearElemento(ClientesUI.getLblDomicilioTelFijo());
        accionesWeb.bordearElemento(ClientesUI.getLblDomicilioTelLab());
        accionesWeb.validarTextoDeUnElemetoContieneTexto(ClientesUI.getLblDomicilioTelFijo(), UtilDatos.getCelular(), "No se realizo el correcto cambio del numero del campo telefono. inst.fijo ");
        accionesWeb.validarTextoDeUnElemetoContieneTexto(ClientesUI.getLblDomicilioTelLab(), UtilDatos.getTelefono(), "No se realizo el correcto cambio del numero del campo telefono inst.Lab");	
        accionesWeb.esperaCargarPagina();
        accionesWeb.tomarEvidencia();
    }
	@Step
    public void verificarProductoCancelado() {
	    accionesWeb.cambioDeFrameDefault();
	    accionesWeb.cambioDeFramePorId(ID_FRAME_ACTIVIDAD);
	    accionesWeb.tomarEvidencia();
        accionesWeb.bordearElemento(ClientesUI.getLblProductoCancelado());
        accionesWeb.validarTextoDeUnElemetoContieneTexto(ClientesUI.getLblFechaCancelado(), "Fecha de Cancelacion");
        accionesWeb.clickBoton(ClientesUI.getBtnProductoCancelado());
    }
	
	
	@Step
	public String obtenerDireccion() {
		
		String direccion = "";
	
		switch (UtilDatos.getPais()) 
        {
	        case "UY":
	        	direccion = "COLONIA 2063";
	        	break;
	        case "EC":  	        	
	        	direccion = "JACINTO RAMON VERA MANABI PICHINCHA";
	        	break;
	        case "CO":  
	        	direccion = "CL 41 # 17 - 26, San Jose, Sur Oriente, Barranquilla";
	        	break;
	        case "PE":  
	        	direccion = "Jorge Basadre 498, Lima 27 ASUNCION";
	        	break;
	        	
	        default:
	        	break;   
        }
		
		return direccion;
	}
	
	@Step
    public void validarBusquedaCliente() {
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.cambioDeFramePorId("Clientes");
		accionesWeb.editaTiempoImplicito(5);
	    accionesWeb.esperoElementoHabilitado(ClientesUI.getLblBusquedaCliente());
        accionesWeb.bordearElemento(ClientesUI.getLblBusquedaCliente());
        accionesWeb.restauraTiempoImplicitoPorDefecto();
        accionesWeb.tomarEvidencia();
     }
	
	private void excepcionUtilConsulta(Exception e) {
		String[]strException = e.getClass().getCanonicalName().replace(".", "-").split("-");
		ExceptionsProyecto.validaExcepcionConsultas(strException[strException.length-1]);
	}
	
	@Step
	public void procesoSeleccionClientePrepago(String estado) throws IOException {
		
		String strClientePrepago = "";
		
		ingresarAPestanaCliente();
		seleccionarTipoCliente();
		ingresarCodigoPais();
		strClientePrepago =  utilConsulta.extraeIdClientePrepagoNormalConPropuestas(UtilDatos.getAmbienteSesamo(), UtilDatos.getAmbiente().split("-")[0].toLowerCase());
		UtilDatos.setClientePrepago(strClientePrepago);
		ingresarNumeroCliente(UtilDatos.getClientePrepago());
		clickBuscar();
		verificarEstadoCliente(estado);
		accionesWeb.tomarEvidencia();
		seleccionarCliente(UtilDatos.getClientePrepago());		
	}
	
	@Step
	public void procesoSeleccionClientePospago(String estado) throws IOException {
		
		String strClientePospago = "";
		
		ingresarAPestanaCliente();
		seleccionarTipoCliente();
		ingresarCodigoPais();
		strClientePospago =utilConsulta.extraeIdClientePospagoNormal(UtilDatos.getAmbienteSesamo(), UtilDatos.getAmbiente().split("-")[0].toLowerCase());
		UtilDatos.setClientePospago(strClientePospago);
		ingresarNumeroCliente(UtilDatos.getClientePospago());
		clickBuscar();
		verificarEstadoCliente(estado);
		accionesWeb.tomarEvidencia();
		seleccionarCliente(UtilDatos.getClientePospago());		
	}
	
	@Step
	public void procesoSeleccionClienteBundleTVPospago(String estado) throws IOException {
		
		String strClientePospago = "";
		
		ingresarAPestanaCliente();
		seleccionarTipoCliente();
		ingresarCodigoPais();
		
		strClientePospago =utilConsulta.extraeIdClientePospagoBundleTVNormal(UtilDatos.getAmbienteSesamo(), UtilDatos.getAmbiente().split("-")[0].toLowerCase());
		UtilDatos.setClientePospago(strClientePospago);
		ingresarNumeroCliente(UtilDatos.getClientePospago());
		clickBuscar();
		verificarEstadoCliente(estado);
		accionesWeb.tomarEvidencia();
		seleccionarCliente(UtilDatos.getClientePospago());		
	}
	
	@Step
	public void procesoSeleccionClienteOnlyNet(String estado) throws IOException {
		
		String strClientePospago = "";
		
		ingresarAPestanaCliente();
		seleccionarTipoCliente();
		ingresarCodigoPais();
		
		strClientePospago = utilConsulta.extraeIdClientePospagoOnlyNet(UtilDatos.getAmbienteSesamo(), UtilDatos.getAmbiente().split("-")[0].toLowerCase());
		UtilDatos.setClientePospago(strClientePospago);
		ingresarNumeroCliente(UtilDatos.getClientePospago());
		clickBuscar();
		verificarEstadoCliente(estado);
		accionesWeb.tomarEvidencia();
		seleccionarCliente(UtilDatos.getClientePospago());		
	}
	
	@Step
	public void procesoSeleccionClienteOnlyNetCancelado(String estado) throws IOException {
		
		String strClientePospago = "";
		
		ingresarAPestanaCliente();
		seleccionarTipoCliente();
		ingresarCodigoPais();
		
		strClientePospago = utilConsulta.extraeIdClientePospagoOnlyNetCancelado(UtilDatos.getAmbienteSesamo(), UtilDatos.getAmbiente().split("-")[0].toLowerCase());
		UtilDatos.setClientePospago(strClientePospago);
		ingresarNumeroCliente(UtilDatos.getClientePospago());
		clickBuscar();
		verificarEstadoCliente(estado);
		accionesWeb.tomarEvidencia();
		seleccionarCliente(UtilDatos.getClientePospago());		
	}
	
	public void diligenciarEmailValido() {
		UtilDatos.setUsuarioCorreo(UtilDatos.getUsuariCorreo());
		UtilDatos.setDominio(UtilDatos.getSetDominio());
		UtilDatos.setDns(UtilDatos.getSetDNS());
		accionesWeb.cambioDeFrameDefault();
	    accionesWeb.cambioDeFramePorId(ID_FRAME_ACTIVIDAD);
	    
		accionesWeb.esperoElementoVisible(ClientesUI.getTxtUsuarioModificacionEmail());
		accionesWeb.esperoElementoHabilitado(ClientesUI.getTxtUsuarioModificacionEmail());
		accionesWeb.escribirTextoSendKeys(ClientesUI.getTxtUsuarioModificacionEmail(), UtilDatos.getUsuarioCorreo());
		accionesWeb.esperoElementoVisible(ClientesUI.getTxtDominioModificacionEmail());
		accionesWeb.esperoElementoHabilitado(ClientesUI.getTxtDominioModificacionEmail());
		accionesWeb.escribirTextoSendKeys(ClientesUI.getTxtDominioModificacionEmail(), UtilDatos.getDominio());
		accionesWeb.seleccionaOpcionContengaTexto(ClientesUI.getSelTipoDominioModificacionEmail(), UtilDatos.getDns());
	}
	public void diligenciarEmailValidoPqrAr(){
	
	accionesWeb.cambioDeFrameDefault();
	accionesWeb.cambioDeFramePorId(ID_FRAME_ACTIVIDAD);
	accionesWeb.cambiarFramePorelemento(AsistenciaTecnicaUI.getXpathFrameGenericoEngage());	
	accionesWeb.cambioDeFramePorId(ID_FRAME_ACTIVIDAD);
	accionesWeb.esperoElementoVisible(ClientesUI.getTxtEmailClientePqrArA());
	accionesWeb.esperoElementoHabilitado(ClientesUI.getTxtEmailClientePqrArA());
	accionesWeb.darClickCheckBox(ClientesUI.getCmbEmailClientePqrAr());
	UtilDatos.setUsuarioCorreo(UtilDatos.getUsuariCorreo());
	UtilDatos.setDominio(UtilDatos.getSetDominio());
	UtilDatos.setDns(UtilDatos.getSetDNS());
	
	accionesWeb.escribirTextoSendKeys(ClientesUI.getTxtEmailClientePqrArA(),UtilDatos.getUsuarioCorreo());
	accionesWeb.escribirTextoSendKeys(ClientesUI.getTxtEmailClientePqrArB(),UtilDatos.getDominio());
	accionesWeb.seleccionaOpcionContengaTexto(ClientesUI.getSelectTipoDiominioPqrAr(), UtilDatos.getDns());
	accionesWeb.seleccionaOpcionContengaTexto(ClientesUI.getSelectTipoPaisPqrAr(), ".ar");
	accionesWeb.tomarEvidencia();
	accionesWeb.clickBoton(AsistenciaTecnicaUI.getBtnGrabarModificacionCorporativo());
	accionesWeb.cambioDeFrameDefault();
	accionesWeb.cambioDeFramePorId(ID_FRAME_ACTIVIDAD);
	
	}
	public void seleccionarDominioDeEmailValido() {
		String dominioPais = "";
		switch (UtilDatos.getPais()) 
		{
		case "EC": 
			dominioPais =  ".ec";
			break;
		case "PE": 
			dominioPais =  ".pe";
			break;
		case "AR": 
			dominioPais =  ".ar";
			break;

			
		default: 
			dominioPais =  ".uy";
			break; 
		}
		UtilDatos.setDominioPais(dominioPais);
		accionesWeb.seleccionaOpcionContengaTexto(ClientesUI.getSelTipoRegionModificacionEmail(), UtilDatos.getDominioPais());
	}
	@Step
	public void validarCorreoCliente() throws IOException {
		String strClienteCorporativo = "";
		ingresarAPestanaCliente();
		seleccionarTipoCliente();
		ingresarCodigoPais();
		strClienteCorporativo = utilConsulta.extraeIdClienteCorporativo(UtilDatos.getAmbienteSesamo(), UtilDatos.getAmbiente().split("-")[0].toLowerCase());
		ingresarNumeroCliente(strClienteCorporativo);		
		clickBuscar();
		seleccionarCliente(strClienteCorporativo);
		seleccionarProceso(UtilDatos.getInformacionCliente());
		clickNuevoProceso();
	}
	@Step
	public void ingresarElClienteCorporativoAProcesar() throws IOException {
		String strClienteCancelado = "";
		ingresarCliente();
		strClienteCancelado = utilConsulta.extraeIdClienteCorporativo(UtilDatos.getAmbienteSesamo(), UtilDatos.getAmbiente().split("-")[0].toLowerCase());
		ingresarNumeroCliente(strClienteCancelado);		
		clickBuscar();
		seleccionarCliente(strClienteCancelado);
		seleccionarProceso(UtilDatos.getInformacionCliente());
		
	}

	@Step
	public void ingresarElClienteAProcesar() throws IOException {
		ingresarCliente();
		obtenerClientePospagoNormal();
		ingresarNumeroCliente();		
		clickBuscar();
		seleccionarCliente(UtilDatos.getClientePospago());
	}
	
	@Step
	public void ingresarElClienteAProcesarPoswinback(String estado) throws IOException {
		ingresarCliente();
		String strClientePosWinBack = "";
		strClientePosWinBack = utilConsulta.clienteCanceladoPendiente(UtilDatos.getAmbienteSesamo(),UtilDatos.getAmbiente().split("-")[0].toLowerCase(), "ClienteCancelacionPendiente");
		UtilDatos.setClientePospago(strClientePosWinBack);
		ingresarNumeroCliente(UtilDatos.getClientePospago());
		clickBuscar();
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
		verificarEstadoClientePosWinBack(estado);
		accionesWeb.tomarEvidencia();
		seleccionarCliente(UtilDatos.getClientePospago());

	}
	
	@Step
	public void verificarEstadoProductoCancelado(String estadoProducto) {
		accionesWeb.bordearElemento(GestionRetencionUI.getLblEstadoProdcuto());
		accionesWeb.validarTextoDeUnElemetoContieneTexto(GestionRetencionUI.getLblEstadoProdcuto(), estadoProducto);
		accionesWeb.tomarEvidencia();
	}
	
	@Step
	public void verficarNoRetencion(String estado) {		
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
		accionesWeb.tomarEvidencia();
		accionesWeb.esperaCargarPagina();
		seleccionarTipoCliente();
		accionesWeb.esperaCargarPagina();
		ingresarCodigoPais();
		accionesWeb.esperaCargarPagina();
		ingresarNumeroCliente();
		clickBuscar();
		verificarEstadoRetencion(estado);	
	}
	@Step
	public void verificarEstadoClientePosWinBack(String strEstado) throws IOException {
		boolean clienteIncorrecto = true ;
		Integer intContador = 0;
		while ((clienteIncorrecto) && (intContador<=5)) {
			intContador = intContador + 1;
			if(intContador > 5)	{
				ExceptionsProyecto.excepcionComprometidoServicios("No se encontró cliente en estado pending cancellation");
			}
			accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
			accionesWeb.esperoElementoVisible(ClientesUI.getEstadocliente());
			String strEstadoCliente = accionesWeb.extraerTextodeLabel(ClientesUI.getEstadocliente());
			if(strEstadoCliente.contains("Pending Cancellation")) {
				clienteIncorrecto = false;
			}else {
				clienteIncorrecto = true;
				obtenerClienteCancelado();
			}
			accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
		}
		
		accionesWeb.tomarEvidencia();
	}
	
	@Step
	public void seleccionarFechaDeBaja() {
		accionesWeb.clickBoton(GestionRetencionUI.getFechaDeBaja());
		accionesWeb.tomarEvidencia();
	}
	
	public void seleccionarOpcionAgregarBeneficio() {
		accionesWeb.clickPosibleElemento(ClientesUI.getBtnAgregar(),2);
	}
	
	
}
