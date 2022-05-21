package regional.definitions;

import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import regional.steps.PerfilStep;

public class PerfilDefinitions {
	
	@Steps
	PerfilStep perfilStep;

	@When("^selecciona el perfil \"([^\"]*)\"$")
	public void seleccionaElPerfil(String strPerfil) {

		perfilStep.seleccionarPerfil(strPerfil);
	}
	@When("^selecciona el perfil PosWinBack")
	public void seleccionaElPerfilPosWinBack() {
		
		perfilStep.seleccionarPerfilPosWinBack();
		
	}
	
	@When("selecciona el perfil PQR")
	public void perfilPQR() {
		perfilStep.seleccionarPerfilPQR();
	}
	
	@When("seleccionar perfil retenciones Inbound")
	public void retencionesInbound() {
		perfilStep.seleccionarPerfilRetencionesInbound();
	}
	@When("seleccionar perfil modificacion")
	public void perfilModificacion() {
		perfilStep.seleccionarPerfiModificacion();
	}
	
	@When("seleccionar perfil retenciones Winback")
	public void retencionesWinback() {
		perfilStep.seleccionarPerfilRetencionesWinback();
	}
	
	@When("seleccionar perfil retenciones Poswinback")
	public void retencionesPoswinback() {
		perfilStep.seleccionarPerfilRetencionesWinback();
	}
	
	@When("selecciona el perfil deseado")
	public void seleccionaElPerfilDeseado() {
		perfilStep.seleccionarPerfilRetencionesInbound();
	}
	
	@When("seleccionar perfil retenciones Prepago")
	public void retencionesPrepago() {
		perfilStep.seleccionarPerfilRetencionesPrepago();
	}
	
	@When("seleccionar perfil retenciones Pospago")
	public void retencionesPospago() {
		perfilStep.seleccionarPerfilRetencionesPospago();
	}
}
