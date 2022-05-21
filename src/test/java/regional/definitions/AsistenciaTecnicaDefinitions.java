package regional.definitions;

import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import regional.steps.AsistenciaTecnicaStep;
import regional.steps.ClienteStep;

public class AsistenciaTecnicaDefinitions {
	
	@Steps
	AsistenciaTecnicaStep asistenciaTecnicaStep;
	@Steps
	ClienteStep clienteStep;

	@When("diligencia la razon de envio de control remoto")
	public void diligenciaLaRazonDeEnvioDeControlRemoto() {
		asistenciaTecnicaStep.diligenciaLaRazonDeEnvioDeControlRemoto();
	}
	
	@When("tramita envio de control remoto")
	public void tramitaEnvioDeControlRemoto() {
		asistenciaTecnicaStep.tramitaEnvioDeControlRemoto();
	}
	
	@When("diligencia envios ird")
	public void diligenciaEnviosIrd() {
		asistenciaTecnicaStep.diligenciaProblemasIrd();
	}
	
	@When("tramita envios ird")
	public void tramitaEnviosIrd() {
		asistenciaTecnicaStep.tramitaEnviosIrd();
	}
	
	@When("diligencia modificacion telefono")
	public void diligenciaModificacionTelefono() {
		asistenciaTecnicaStep.diligenciarModificacionTelefono();

	}
		
	@When("diligencia modificacion email")
	public void diligenciaModificacionEmail() {
		asistenciaTecnicaStep.diligenciarModificacionEmail();
	}
	
	@When("diligencia modificacion domicilio")
    public void diligenciaModificacionDomicilio() {
        asistenciaTecnicaStep.diligenciarModificacionDomicilio();
    }
	
	@When("modificacion de domicilio")
    public void modificacionDomicilio() {
        asistenciaTecnicaStep.normalizarClienteModficacionDomicilio();
    }
}
