package regional.definitions;

import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import regional.steps.ClienteStep;
import regional.steps.ResultadoDeGestionStep;


public class ResultadoDeGestionDefinitions {
	
	@Steps
	ResultadoDeGestionStep  resultadoDeGestionStep;
	@Steps
	ClienteStep clienteStep;

	@When("seleccionar resultado de gestion aceptar")
    public void seleccionaResultadoDeGestionAcepta() {
		resultadoDeGestionStep.seleccionaResultadoDeGestionAcepta();    
    }
	
	@When("seleccionar resultado de gestion no acepta")
    public void seleccionaResultadoDeGestionNoAcepta() {
		resultadoDeGestionStep.seleccionaResultadoDeGestionNoAcepta();    
    }
	
	@When("seleccionar resultado de gestion rellamar")
    public void seleccionaResultadoDeGestionRellamar() {
		resultadoDeGestionStep.seleccionaResultadoDeGestionRellamar();    
    }
	
	@When("seleccionar resultado de retirar gestion")
    public void seleccionaResultadoDeRetirarGestion() {
		resultadoDeGestionStep.seleccionaResultadoDeRetirarGestion();    
    }
	
	@When("seleccionar finalizar")
    public void seleccionaFinalizar() {
		resultadoDeGestionStep.seleccionaFinalizar();    
    }
	
	@When("verificar pantalla inicial")
    public void verificarPantallaInicial() {
		clienteStep.validarBusquedaCliente();    
    }
	
	
	
}
