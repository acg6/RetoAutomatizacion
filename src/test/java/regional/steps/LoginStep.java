package regional.steps;

import net.thucydides.core.annotations.Step;
import regional.ui.LoginUI;
import regional.utilities.AccionesWeb;
import regional.utilities.UtilConsulta;
import regional.utilities.UtilDatos;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;

public class LoginStep {
	
	private static final String WEBDRIVERNAME = "webdriver.name";
	
	private EnvironmentVariables environmentVariables;
	private AccionesWeb accionesWeb;
	private UtilConsulta utilConsulta;

	@Step
	public void ingresoAplicativoEngage() {
		UtilDatos.setAmbiente(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(WEBDRIVERNAME));
		Serenity.recordReportData().withTitle("Ambiente").andContents("Ambiente:" + UtilDatos.getAmbiente());
		Serenity.recordReportData().withTitle("Pais").andContents("Pais:" +  UtilDatos.getPais());
		accionesWeb.abrirURL("page:home.page");
		accionesWeb.esperaCargarPagina();
		accionesWeb.tomarEvidencia();
		Serenity.recordReportData().withTitle("Url").andContents("URL:" + accionesWeb.obtenerUrlAplicativo());
	}

	@Step
	public void iniciarSesionEngage() {
		String[] strCredenciales = UtilDatos.obtenerConfig("src/test/resources/archivos/Credenciales.properties", UtilDatos.getAmbiente(), 1);
		accionesWeb.esperaCargarPagina();
		accionesWeb.escribirTexto(LoginUI.getInputUsuario(), strCredenciales[0]);
		accionesWeb.clickBoton(LoginUI.getButtonLogin());
		accionesWeb.esperaDesaparezcaElemento(LoginUI.getOverLayLogin(), 1);
		accionesWeb.esperaCargarPagina();
	}
		
	@Step
	public void abrirEIniciarSesionEngage() {
		UtilDatos.setAmbiente(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(WEBDRIVERNAME));
		String strUrl = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("webdriver.base.url").replace("https://","");
		String[] strCredenciales = UtilDatos.obtenerConfig("src/test/resources/archivos/Loguin.properties", UtilDatos.getAmbiente(), 2);
		strUrl = "https://" + strCredenciales[0]+ ":" + strCredenciales[1] + "@" + strUrl;
		accionesWeb.abrirPagina(strUrl);
		accionesWeb.esperaCargarPagina();
		accionesWeb.actualizarPagina();
		accionesWeb.esperaCargarPagina();
		accionesWeb.clickPosibleElemento(LoginUI.getButtonRelogin(), 5);
	}
	
	@Step
	public void reingresoAplicativoEngage() {
		accionesWeb.clickBoton(LoginUI.getButtonRelogin());
	}
	
	
	@Step
	public void verificarIngresarAmbienteEngageWeb() {
		accionesWeb.esperoElementoVisible(LoginUI.getLblInicioSesion());
		accionesWeb.bordearElemento(LoginUI.getLblInicioSesion());
		accionesWeb.tomarEvidencia();
	}
	
	
	@Step	
	public void verificarConexionASesamo() {
		UtilDatos.setAmbiente( EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(WEBDRIVERNAME));
		if(UtilDatos.getAmbiente().contains("UY-")){
			utilConsulta.verificarConexionSesamo("ClientePospagoNormal");
		}	
	}
	
	@Step	
	public void verificarLecturaDeArchivosDeApoyo() {
		UtilDatos.setAmbiente( EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(WEBDRIVERNAME));
		UtilDatos.obtenerConfig("src/test/resources/archivos/Credenciales.properties",UtilDatos.getAmbiente(),2);
	}
	
	@Step
	public void ingresaLoginDespuesDeFinalizar() {
		accionesWeb.esperoElementoVisible(LoginUI.getButtonRelogin());
		accionesWeb.clickBoton(LoginUI.getButtonRelogin());
	}

}
