package regional.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import regional.steps.LoginStep;

public class LoginDefinitions {

	@Steps
	LoginStep loginStep;
	
	@Given("ingresar a Engage web")
	public void ingresarAEngageWeb() {
		loginStep.ingresoAplicativoEngage();
		loginStep.iniciarSesionEngage();
	}
	
	@When("iniciar la sesion del usuario")
	public void iniciarLaSesionDelUsuario() {
	   loginStep.reingresoAplicativoEngage();
	   loginStep.iniciarSesionEngage();
	}
	
	@Given("ingresar a ambiente Engage web")
	public void ingresarAAmbienteEngageWeb() {
		loginStep.ingresoAplicativoEngage();
		loginStep.verificarIngresarAmbienteEngageWeb();
	}
	
	@Given("verifica conexion a sesamo")
	public void verificaConexionASesamo() {
	    loginStep.verificarConexionASesamo();
	}
	
	@Given("verificar lectura de archivos de apoyo")
	public void verificarLecturaDeArchivosDeApoyo() {
	    loginStep.verificarLecturaDeArchivosDeApoyo();
	}
	
	@Then("ingresar login despues de finalizar")
	public void ingresarLoginDespuesDeFinalizar() {
	    loginStep.ingresaLoginDespuesDeFinalizar();
	}
}
