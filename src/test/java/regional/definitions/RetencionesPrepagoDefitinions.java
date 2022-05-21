package regional.definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import regional.steps.LogoutStep;
import regional.steps.RetencionesPrepagoStep;

public class RetencionesPrepagoDefitinions {

	@Steps
	RetencionesPrepagoStep retencionesPrepagoStep;
	@Steps
	LogoutStep logOutStep;

	@When("seleccionar motivo de no recarga")
	public void seleccionarMotivoNoRecarga() {
		retencionesPrepagoStep.seleccionaMotivoNoRecarga();
	}

	@When("seleccionar submotivo de no recarga")
	public void seleccionarSubmotivoNoRecarga() {
		retencionesPrepagoStep.seleccionaSubmotivoNoRecarga();
	}

	@When("seleccionar propuestas comerciales")
	public void seleccionarPropuestasComerciales() {
		retencionesPrepagoStep.seleccionaPropuestaComercial();
	}

	@When("^seleccionar \"([^\"]*)\" opciones de contenido$")
	public void seleccionarOpcionesDeContenido(int num) {
		retencionesPrepagoStep.seleccionaContenido(num);
	}
	
	@Then("Cerrar sesion aplicativo")
	public void cerrarSesionAplicativo() {
	 logOutStep.cerrarSesionAplicativo();
	}
	

}
