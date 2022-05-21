package regional.steps;

import org.openqa.selenium.By;

import exceptions.ExceptionsProyecto;
import net.thucydides.core.annotations.Step;
import regional.ui.AsistenciaTecnicaUI;
import regional.ui.ClientesUI;
import regional.ui.ConstantesUI;
import regional.ui.DatosContactoIBSUI;
import regional.ui.GestionRetencionUI;
import regional.ui.RetencionesPrepagoUI;
import regional.utilities.AccionesWeb;
import regional.utilities.UtilDatos;
import regional.utilities.UtilDatosAleatorios;
import regional.utilities.UtilDatosEstaticos;

public class GestionRetencionStep {

	
	private String idFrame = "Actividad";
	private int tamanio = 0;
	private int contAux = 0;
	
	AccionesWeb accionesWeb = new AccionesWeb();
		
	@Step
	public void clickIntencionBajaContinuar() {
		accionesWeb.esperaCargarPagina();
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.cambioDeFrame(7);
		accionesWeb.esperaCargarPagina();
		accionesWeb.posicionarElementoScroll(ClientesUI.getBtnContinuarResultado());
		accionesWeb.esperoElementoVisible(ClientesUI.getBtnContinuarResultado());
		accionesWeb.clickBoton(ClientesUI.getBtnContinuarResultado());
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
		accionesWeb.tomarEvidencia();
	}
	
	@Step
	public void clickPestanaProductos() {
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
		accionesWeb.esperaCargarPagina();
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.cambioDeFrame(7);
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperoElementoVisible(GestionRetencionUI.getBtnProducto());
		accionesWeb.clickBoton(GestionRetencionUI.getBtnProducto());
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
		accionesWeb.tomarEvidencia();
	}
	
	@Step
	public void clickVolverPestanaProductos() {
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
		accionesWeb.esperaCargarPagina();
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.cambioDeFrame(7);	
		accionesWeb.clickPosibleElemento(GestionRetencionUI.getBtnVolver(), 2);
		accionesWeb.esperaDesaparezcaElementoIntentos(GestionRetencionUI.getBtnVolver(), 100);
		accionesWeb.tomarEvidencia();
	}

	@Step
	public void obtenerCategoriaRetenido() {
		int listaCategoria = accionesWeb.obtenerListaCategoria(GestionRetencionUI.getDivCategoria());
		if (contAux == 0) {
			tamanio = listaCategoria;
			contAux++;
		} else {
			if (listaCategoria > tamanio) {
				accionesWeb.cambioDeFrameDefault();
				accionesWeb.cambioDeFrame(7);
				accionesWeb.tomarEvidencia();
			}
		}
	}
	
	
	@Step
	public void seleccionarSubmotivo() {
		accionesWeb.esperaCargarPagina();
		accionesWeb.confirmarElementoHabilitado(GestionRetencionUI.getSelectSubmovtivo());
		accionesWeb.esperoElementoVisible(GestionRetencionUI.getSelectSubmovtivo());
		accionesWeb.seleccionarOpcionIndex(GestionRetencionUI.getSelectSubmovtivo(), 1);
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 40);
		accionesWeb.tomarEvidencia();
	}
	
	@Step
	public void seleccionarSubsubmotivo() {
		accionesWeb.esperoElementoVisible(GestionRetencionUI.getSelectSubsubmovtivo());
		accionesWeb.esperoElementoClickable(GestionRetencionUI.getSelectSubsubmovtivo());
		accionesWeb.seleccionarOpcionIndex(GestionRetencionUI.getSelectSubsubmovtivo(), 1);
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 20);
		accionesWeb.tomarEvidencia();
	}

	@Step
	public void seleccionarSubmotivoIntencionBaja() {
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 80);
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperoElementoVisible(GestionRetencionUI.getInputSubmotivoBajaUy());
		accionesWeb.esperoElementoHabilitado(GestionRetencionUI.getInputSubmotivoBajaUy());
		accionesWeb.clickBoton(GestionRetencionUI.getInputSubmotivoBajaUy());
		accionesWeb.esperoElementoVisible(GestionRetencionUI.getInputSubSubmotivoBajaUy());
		accionesWeb.esperaCargarPagina();
		accionesWeb.tomarEvidencia();
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperoElementoClickable(GestionRetencionUI.getInputSubSubmotivoBajaUy());
		accionesWeb.clickBoton(GestionRetencionUI.getInputSubSubmotivoBajaUy());
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 20);
		accionesWeb.esperaCargarPagina();
		
		
	}

	@Step
	public void seleccionarProductoComercial(String nroCTL) {
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.cambioDeFramePorId(idFrame);
		accionesWeb.cambioDeFramePorId(UtilDatos.getFrameID() + nroCTL);
		accionesWeb.cambioDeFramePorId(idFrame);
		switch (UtilDatos.getPais()) {
	        case "UY":  
	        	if (accionesWeb.chequearExistenciaElemento(GestionRetencionUI.getRdbOroHd())) {
					accionesWeb.clickBoton(GestionRetencionUI.getRdbOroHd());
				} else if (accionesWeb.chequearExistenciaElemento(GestionRetencionUI.getRdbOroMix())) {
					accionesWeb.clickBoton(GestionRetencionUI.getRdbOroMix());
				} else if (accionesWeb.chequearExistenciaElemento(GestionRetencionUI.getRdbOroPlus())) {
					accionesWeb.clickBoton(GestionRetencionUI.getRdbOroPlus());
				} else if (accionesWeb.chequearExistenciaElemento(GestionRetencionUI.getRdbPlataHd())) {
					accionesWeb.clickBoton(GestionRetencionUI.getRdbPlataHd());
				} else if (accionesWeb.chequearExistenciaElemento(GestionRetencionUI.getRdbPlatino())) {
					accionesWeb.clickBoton(GestionRetencionUI.getRdbPlatino());
				} else if (accionesWeb.chequearExistenciaElemento(GestionRetencionUI.getRdbOroHdK())) {
					accionesWeb.clickBoton(GestionRetencionUI.getRdbOroHdK());
				} else if (accionesWeb.chequearExistenciaElemento(GestionRetencionUI.getRdbRdbPlata())) {
					accionesWeb.clickBoton(GestionRetencionUI.getRdbRdbPlata());
				}
	        	break;
	        case "PE":  
	        	String[] productosPremium = UtilDatosEstaticos.getProductosPremiumPE();
	    	 	Integer contador = 1;
	    	 	boolean blnProductoEncontrado = false;
	    	 	while((contador<productosPremium.length) && (!blnProductoEncontrado)) {
	    	 		String strXpathCompleto = GestionRetencionUI.getComienzoXpathProductoPremium() + productosPremium[contador] + GestionRetencionUI.getFinXpathProductoPremium();
	    	 		blnProductoEncontrado = accionesWeb.chequearExistenciaElemento(By.xpath(strXpathCompleto));
	    	 		if (blnProductoEncontrado) {
	    	 			accionesWeb.clickBoton(By.xpath(strXpathCompleto));
	    	 		}
	    	 		contador++;
	    	 	}
	    	 	break;
	        default:
	        	break;
        }
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 12);
		accionesWeb.esperaCargarPagina();
		accionesWeb.tomarEvidencia();
	}

	@Step
	public void seleccionarAccion(String strAccion, String xPathGenerico) {
		accionesWeb.esperaCargarPagina();	
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.cambioDeFramePorId(idFrame);	
		seleccionarFrameSegunPais();
		accionesWeb.cambioDeFramePorId(idFrame);	
		accionesWeb.esperaCargarPagina();
		accionesWeb.tomarEvidencia();
		accionesWeb.esperoElementoVisible(GestionRetencionUI.getBtnContinuar());
		accionesWeb.esperoElementoVisible(GestionRetencionUI.getSelectAccion());
		accionesWeb.esperoElementoHabilitado(GestionRetencionUI.getSelectAccion());
		accionesWeb.esperoElementoClickable(GestionRetencionUI.getSelectAccion());

		accionesWeb.clickBoton(GestionRetencionUI.getSelectAccion());
		
		accionesWeb.seleccionarOpcion(GestionRetencionUI.getSelectAccion(), strAccion);
	
	}
		
		
	@Step
	public void seleccionarAccionPosWinBack(String strAccion) {
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.cambioDeFramePorId(idFrame);
		accionesWeb.cambiarFramePorelemento(GestionRetencionUI.getXpathSelectAccion());
		accionesWeb.cambioDeFramePorId(idFrame);
		accionesWeb.seleccionaOpcionContengaTexto(GestionRetencionUI.getSelectAccion(), strAccion);		
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperoElementoVisible(GestionRetencionUI.getSelectAccion());
		accionesWeb.tomarEvidencia();
	}
	
	@Step
	public void clickRegistrar() {
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 20);
		accionesWeb.esperoElementoHabilitado(GestionRetencionUI.getBtnRegistrar());
		accionesWeb.tomarEvidencia();
		accionesWeb.clickBoton(GestionRetencionUI.getBtnRegistrar());
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 10);
	}
	
	
	@Step
	public void registrarProductoDowngradePoswinback() {
		accionesWeb.esperaCargarPagina();		
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.cambioDeFramePorId(idFrame);	
		accionesWeb.cambiarFramePorelemento(AsistenciaTecnicaUI.getXpathFrameGenericoEngage());
		accionesWeb.cambioDeFramePorId(idFrame);
		accionesWeb.esperoElementoVisible(GestionRetencionUI.getSelectAccion());
		accionesWeb.clickBoton(GestionRetencionUI.getSelectAccion());
		accionesWeb.seleccionarOpcionIndex(GestionRetencionUI.getSelectAccion(), 1);
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargandoproceso(), 30);
		accionesWeb.esperoElementoVisible(GestionRetencionUI.getSelectListaProductos());
		accionesWeb.posicionarElementoScroll(GestionRetencionUI.getSelectListaProductos());
		accionesWeb.esperoElementoHabilitado(GestionRetencionUI.getSelectListaProductos());
		accionesWeb.clickBoton(GestionRetencionUI.getSelectListaProductos());
		accionesWeb.seleccionarOpcionIndex(GestionRetencionUI.getSelectListaProductos(), 2);
		
		accionesWeb.tomarEvidencia();
		accionesWeb.clickBoton(GestionRetencionUI.getBtnRegistrar());
		accionesWeb.esperaCargarPagina();
		
	}
	
	public String  seleccionarFrameGenerico() {

		return accionesWeb.seleccionarFrameGenerico();
		
	}
	
	@Step
	public void seleccionarProductoInbound() {
	
		Boolean blnResult = false;
		int intentos = 0;
		int maximos = 7;
		
		accionesWeb.esperaCargarPagina();
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.cambioDeFramePorId(idFrame);
		seleccionarFrameSegunPais();
		accionesWeb.cambioDeFramePorId(idFrame);
		
		accionesWeb.esperoElementoVisible(GestionRetencionUI.getRbtnProductoInbound());
		accionesWeb.esperoElementoHabilitado(GestionRetencionUI.getRbtnProductoInbound());
		
		while ( Boolean.FALSE.equals(blnResult) && intentos < maximos) {
			intentos++;
			accionesWeb.esperaCargarPagina();
			accionesWeb.elegirElementoListaUbicaClick(GestionRetencionUI.getRbtnProductoInbound());
			accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 50);
			blnResult = accionesWeb.existeOpcion(GestionRetencionUI.getSelectAccion(), "A Cancelar");
			
		}	
		
		if ( intentos >= maximos) {
			ExceptionsProyecto.lanzarExcepcion("Documento " + UtilDatos.getClientePospago() + ", Ambiente " + UtilDatos.getAmbiente() + ", no posee productos A Cancelar");
		}
	}
	
	@Step
	public void seleccionarListaProducto2365(String nuevoProducto) {
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.cambioDeFramePorId(idFrame);
		accionesWeb.cambiarFramePorelemento(GestionRetencionUI.getXpathFrameListaProductos());
		accionesWeb.cambioDeFramePorId(idFrame);
		accionesWeb.esperoElementoVisible(GestionRetencionUI.getSelectListaProductos());
		accionesWeb.seleccionaOpcionContengaTexto(GestionRetencionUI.getSelectListaProductos(), nuevoProducto);
		accionesWeb.tomarEvidencia();
	}

	@Step
	public void seleccionarProducto( String xpathGenerico) {
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargandoproceso(), 50);
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.cambioDeFramePorId(idFrame);	
		seleccionarFrameSegunPais();
		accionesWeb.cambioDeFramePorId(idFrame);
		accionesWeb.esperoElementoVisible(GestionRetencionUI.getSelectListaProductos());
		accionesWeb.esperoElementoHabilitado(GestionRetencionUI.getSelectListaProductos());
		accionesWeb.seleccionarOpcionIndex(GestionRetencionUI.getSelectListaProductos(), 1);
		accionesWeb.esperaCargarPagina();
		accionesWeb.tomarEvidencia();
	}

	
	
	@Step
	public void seleccionarCategoriaBeneficioPrincipalEngage() {

		
		switch (UtilDatos.getPais()) {
        case "UY": 
        	accionesWeb.esperaCargarPagina();
    		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
    		accionesWeb.esperoElementoVisible(GestionRetencionUI.getSelectCategoriaBeneficioPrincipal());
    		accionesWeb.clickBoton(GestionRetencionUI.getSelectCategoriaBeneficioPrincipal());
    		accionesWeb.seleccionarOpcionIndex(GestionRetencionUI.getSelectCategoriaBeneficioPrincipal(), 1);
    		accionesWeb.esperaCargarPagina();
    		accionesWeb.tomarEvidencia();
			break;
        case "PE":  
        	accionesWeb.esperaCargarPagina();
        	accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
    		accionesWeb.esperoElementoVisible(GestionRetencionUI.getSelectCategoriaBeneficioPrincipalPeru());
    		accionesWeb.clickBoton(GestionRetencionUI.getSelectCategoriaBeneficioPrincipalPeru());
    		accionesWeb.seleccionarOpcionIndex(GestionRetencionUI.getSelectCategoriaBeneficioPrincipalPeru(), 1);
    		accionesWeb.esperaCargarPagina();
    		accionesWeb.tomarEvidencia();
        	break;
        default:
        	break;
    }
	}
	
	@Step
	public void seleccionarBeneficioPrincipal() {
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
		accionesWeb.esperoElementoVisible(GestionRetencionUI.getSelectBeneficioPrincipal());
		accionesWeb.clickPosibleElemento(GestionRetencionUI.getSelectBeneficioPrincipal(), 5);
		accionesWeb.seleccionarOpcionIndex(GestionRetencionUI.getSelectBeneficioPrincipal(), 5);
		accionesWeb.tomarEvidencia();
	}
	@Step
	public void seleccionarBeneficioPrincipalEngage() {
	
		int numeroElementos = 0;
		switch (UtilDatos.getPais()) {
        case "UY": 
        	accionesWeb.esperaCargarPagina();
    		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
    		accionesWeb.esperoElementoVisible(GestionRetencionUI.getSelectBeneficioPrincipal());
    		accionesWeb.clickBoton(GestionRetencionUI.getSelectBeneficioPrincipal());
    		
    		numeroElementos = accionesWeb.obtenerCantidadDeElementosPorXpath(GestionRetencionUI.getSelectBeneficioPrincipal());
    		accionesWeb.contarClickElementoLista(GestionRetencionUI.getSelectBeneficioPrincipal());
    		int opcion = UtilDatosAleatorios.obtenerIntAleatorioRango(1, numeroElementos); 
    		accionesWeb.esperoElementoVisible(GestionRetencionUI.getSelectBeneficioPrincipal());
    		accionesWeb.esperoElementoHabilitado(GestionRetencionUI.getSelectBeneficioPrincipal());
    		accionesWeb.seleccionarOpcionIndex(GestionRetencionUI.getSelectBeneficioPrincipal(),opcion);
    		accionesWeb.tomarEvidencia();			
    		break;

        case "PE":  
        	accionesWeb.esperaCargarPagina();
    		accionesWeb.esperaDesaparezcaElemento(ConstantesUI.getDivCargando(), 5);
    		accionesWeb.esperoElementoVisible(GestionRetencionUI.getSelectBeneficioPrincipal());
    		accionesWeb.clickPosibleElemento(GestionRetencionUI.getSelectBeneficioPrincipal(), 5);
    		accionesWeb.seleccionarOpcionIndex(GestionRetencionUI.getSelectBeneficioPrincipal(), 3);
    		accionesWeb.esperaCargarPagina();
    		accionesWeb.clickPosibleElemento(GestionRetencionUI.getBtnAgregarBeneficio(), 5);
    		accionesWeb.esperaCargarPagina();
    		accionesWeb.tomarEvidencia();
    		
        	break;
        default:
        	break;
    }
	}
	
	private void cambioFramePorID() {
		switch (UtilDatos.getPais()) {
	        case "UY": 
	        	accionesWeb.cambiarFramePorelemento(AsistenciaTecnicaUI.getXpathFrameGenericoEngage ());
				break;
	        case "PE":  
	        	accionesWeb.cambiarFramePorelemento(RetencionesPrepagoUI.getXpathFrameGenerico ());
	        	break;
	        default:
	        	break;
	    }
	}
	
	@Step
	public void agregarProductoActivo() {
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
		accionesWeb.esperaCargarPagina();
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.cambioDeFramePorId(idFrame);
		cambioFramePorID();
        accionesWeb.cambioDeFramePorId(idFrame);
		accionesWeb.posicionarElementoScroll(ClientesUI.getGrdProductoActivo());
		accionesWeb.esperoElementoVisible(ClientesUI.getGrdProductoComercial());
		accionesWeb.esperoElementoHabilitado(ClientesUI.getGrdProductoComercial());
		accionesWeb.darClickCheckBox(ClientesUI.getGrdProductoComercial());
		accionesWeb.tomarEvidencia();
	}

	@Step
	public void seleccionarResultadoDeRetencion(String tipoRetencion) {
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 150);
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.cambioDeFramePorId(idFrame);
		accionesWeb.posicionarElementoScroll(GestionRetencionUI.getSelectTipoRetenido());
		accionesWeb.tomarEvidencia();
		accionesWeb.esperoElementoVisible(GestionRetencionUI.getSelectTipoRetenido());
    	accionesWeb.esperoElementoHabilitado(GestionRetencionUI.getSelectTipoRetenido());
		accionesWeb.seleccionarOpcion(GestionRetencionUI.getSelectTipoRetenido(), tipoRetencion);
		accionesWeb.clickPosibleElemento(GestionRetencionUI.getSelectTipoRetenido(), 2);
		accionesWeb.tomarEvidencia();
		
	}

	@Step
	public void seleccionarSubCategoriaIBS() {
		accionesWeb.esperaCargarPagina();
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
		accionesWeb.cambioDeFramePorId(idFrame);
		accionesWeb.esperoElementoVisible(DatosContactoIBSUI.getSelectSegundaCategoria());
		accionesWeb.clickPosibleElemento(DatosContactoIBSUI.getSelectSegundaCategoria(), 2);
		accionesWeb.seleccionarOpcionIndex(DatosContactoIBSUI.getSelectSegundaCategoria(), 5);
		accionesWeb.tomarEvidencia();
	}

	@Step
	public void agregarObservacion() {
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
		accionesWeb.esperaCargarPagina();
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
		accionesWeb.cambioDeFramePorId(idFrame);
		accionesWeb.esperoElementoVisible(GestionRetencionUI.getTxtObservaciones());
		accionesWeb.escribirTexto(GestionRetencionUI.getTxtObservaciones(), UtilDatos.getObservacion());
		accionesWeb.tomarEvidencia();
	}
	
	@Step
	public void agregarObservacion( String observacion) {
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.cambioDeFramePorId(idFrame);
		accionesWeb.esperoElementoVisible(GestionRetencionUI.getTxtObservaciones());
		accionesWeb.esperoElementoHabilitado(GestionRetencionUI.getTxtObservaciones());
		accionesWeb.escribirTexto(GestionRetencionUI.getTxtObservaciones(), observacion);
	}
	
	@Step
	public void agregarInformacion() {
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
		accionesWeb.esperaCargarPagina();
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
		accionesWeb.cambioDeFramePorId(idFrame);
		accionesWeb.esperoElementoVisible(GestionRetencionUI.getTxtObservaciones());
		accionesWeb.escribirTexto(GestionRetencionUI.getTxtObservaciones(), UtilDatos.getInformacion());
		accionesWeb.tomarEvidencia();
	}
	
	@Step
	public void agregarNota(String strNota) {
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
		accionesWeb.esperaCargarPagina();
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
		accionesWeb.cambioDeFramePorId(idFrame);
		accionesWeb.esperoElementoVisible(GestionRetencionUI.getTxtObservaciones());
		accionesWeb.escribirTexto(GestionRetencionUI.getTxtObservaciones(), strNota);
		accionesWeb.tomarEvidencia();
	}
	
	  

	public void seleccionarContinuar() {
	   	accionesWeb.clickPosibleElemento(GestionRetencionUI.getBtnContinuar(), 5);
	   	accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(),110);
	}    

	@Step
	public void clickContinuar() {
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.cambioDeFramePorId(idFrame);
		seleccionarContinuar();
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(),200);
	}

	@Step
	public void segundaCategoria() {
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperoElementoVisible(GestionRetencionUI.getCmbSegundaCategoria());
		accionesWeb.seleccionarOpcionIndex(GestionRetencionUI.getCmbSegundaCategoria(), 1);
		accionesWeb.tomarEvidencia();

	}
	
	@Step
	public void septimaCategoria() {
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 40);
		accionesWeb.esperoElementoVisible(GestionRetencionUI.getCmbSegundaCategoria());
		accionesWeb.seleccionaOpcionContengaTexto(GestionRetencionUI.getCmbSegundaCategoria(), "Premium");
	}
	
	@Step
	public void indicaLaCuartaCategoriaEnIBS() {
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
		accionesWeb.esperoElementoVisible(GestionRetencionUI.getCmbSegundaCategoria());
		accionesWeb.esperoElementoHabilitado(GestionRetencionUI.getCmbSegundaCategoria());
		accionesWeb.seleccionaOpcionContengaTexto(GestionRetencionUI.getCmbSegundaCategoria(), "004-PREC-Incremento de Precios");
		accionesWeb.tomarEvidencia();

	}
	
	@Step
	public void indicaCategoriaEnIBS(String categoria) {
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperoElementoVisible(GestionRetencionUI.getCmbSegundaCategoria());
		accionesWeb.seleccionaOpcionContengaTexto(GestionRetencionUI.getCmbSegundaCategoria(), categoria);
		accionesWeb.tomarEvidencia();
	}
	
	@Step
	public void seleccionaCategoriaBeneficioPrincipal() {
	
		int x= 1;
		
		accionesWeb.esperaCargarPagina();
		accionesWeb.cambioDeFrameDefault();
		accionesWeb.cambioDeFramePorId(idFrame);
		accionesWeb.esperoElementoVisible(GestionRetencionUI.getOpcionCategoriaBeneficioPrincipal());
		accionesWeb.esperoElementoHabilitado(GestionRetencionUI.getOpcionCategoriaBeneficioPrincipal());
		int opciones= accionesWeb.obtenerCantidadDeElementosPorXpath(GestionRetencionUI.getOpcionesCategoriaBeneficioPrincipal());
		
		do {
			accionesWeb.seleccionarOpcionIndex(GestionRetencionUI.getOpcionCategoriaBeneficioPrincipal(), x);
			accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 10);
			x++;
		}
		while((accionesWeb.obtenerCantidadDeElementosPorXpath(GestionRetencionUI.getSelectBeneficioPrincipal())<=1)&&
				(x<=opciones));
		accionesWeb.tomarEvidencia();
	}
		
	@Step
	public void seleccionaBeneficioPrincipal(){
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperoElementoVisible(GestionRetencionUI.getOpcionBeneficioPrincipal());
		accionesWeb.esperoElementoHabilitado(GestionRetencionUI.getOpcionBeneficioPrincipal());
		accionesWeb.seleccionarOpcionIndex(GestionRetencionUI.getOpcionBeneficioPrincipal(),1);
		accionesWeb.tomarEvidencia();
	}
	
	public void seleccionarFrameSegunPais() {
		if(UtilDatos.getPais().contains("UY")) {
			accionesWeb.cambiarFramePorelemento(AsistenciaTecnicaUI.getXpathFrameGenericoEngage());
		}else {
			accionesWeb.cambiarFramePorelemento(RetencionesPrepagoUI.getXpathFrameGenerico());
		}
	}
	@Step
	public void seleccionarMotivoPrincipalBaja() {
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
		accionesWeb.esperoElementoVisible(GestionRetencionUI.getSelectMotivoPrincipal());
		String strMotivo ="Costos / No Puede Pagar";
		accionesWeb.seleccionarOpcion(GestionRetencionUI.getSelectMotivoPrincipal(),strMotivo );
		accionesWeb.tomarEvidencia();
	}
	
	@Step
	public void seleccionarMotivoPrincipalBajaTV() {
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
		accionesWeb.esperoElementoVisible(GestionRetencionUI.getSelectMotivoPrincipal());
		String strMotivo ="Competencia / Plataformas Digitales";
		accionesWeb.seleccionarOpcion(GestionRetencionUI.getSelectMotivoPrincipal(),strMotivo );
		accionesWeb.tomarEvidencia();
	}
	
	@Step
	public void seleccionaMotivoPrincipalBajaTV() {
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
		accionesWeb.esperoElementoVisible(GestionRetencionUI.getSelectMotivoPrincipal());
		String strMotivo ="Costos / Aumento de precios";
		accionesWeb.seleccionarOpcion(GestionRetencionUI.getSelectMotivoPrincipal(),strMotivo );
		accionesWeb.tomarEvidencia();
	}
	
	@Step
	public void seleccionarMotivoPrincipalBajaNet() {
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
		accionesWeb.esperoElementoVisible(GestionRetencionUI.getSelectMotivoPrincipal());
		String strMotivo ="Competencia / Precio: combo Internet";
		accionesWeb.seleccionarOpcion(GestionRetencionUI.getSelectMotivoPrincipalNet(),strMotivo );
		accionesWeb.tomarEvidencia();
	}
	
	public void seleccinarCategoriaYBeneficio() {
		
		String strCategoria ="Servicios";
		String strBeneficio="1884-Work Order Free Retencion (costo: 1)";
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperoElementoVisible(GestionRetencionUI.getSelectCategoriaBeneficioPrincipal());
		accionesWeb.seleccionarOpcion(GestionRetencionUI.getSelectCategoriaBeneficioPrincipal(),strCategoria);
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
		accionesWeb.esperoElementoHabilitado(GestionRetencionUI.getSelectBeneficioPrincipal());
		accionesWeb.seleccionarOpcion(GestionRetencionUI.getSelectBeneficioPrincipal(),strBeneficio);
		accionesWeb.tomarEvidencia();
	}
	
	@Step
	public void seleccionarMotivoPrincipalBajaRetenidoTV() {
		accionesWeb.esperaCargarPagina();
		accionesWeb.esperaDesaparezcaElementoIntentos(ConstantesUI.getDivCargando(), 100);
		accionesWeb.esperoElementoVisible(GestionRetencionUI.getSelectMotivoPrincipal());
		String strMotivo ="Competencia / Programación";
		accionesWeb.seleccionarOpcion(GestionRetencionUI.getSelectMotivoPrincipalNet(),strMotivo );
		accionesWeb.tomarEvidencia();
	}
	
}
