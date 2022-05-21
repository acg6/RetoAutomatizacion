package regional.definitions;

import io.cucumber.java.en.When;
import regional.steps.AsistenciaTecnicaStep;
import regional.steps.ClienteStep;
import regional.steps.GestionReclamoStep;
import regional.utilities.UtilConsulta;
import net.thucydides.core.annotations.Steps;

public class PQRDefinitions {
	
	@Steps
	GestionReclamoStep gestionReclamoStep;
	@Steps
	ClienteStep clienteStep;
	@Steps
	AsistenciaTecnicaStep asistenciaTecnicaStep;
	UtilConsulta utilConsulta;
	
	@When("indica una super categoria del tramite disponible")
	public void indicaUnaSuperCategoriaDelTramiteDisponible() {
		asistenciaTecnicaStep.seleccionarSuperCategoria();
	}

	@When("agrega la descripcion del diagnostico")
	public void agregaLaDescripcionDelDiagnostico() {
		gestionReclamoStep.agregarDescripcion();	
		gestionReclamoStep.clickSolucionar();
	}
	
	@When("agrega la descripcion del diagnostico Derivacion")
	public void agregaLaDescripcionDelDiagnosticoDerivacion() {
		gestionReclamoStep.agregarDescripcion();		
	}
	
	@When("agrega la descripcion del diagnostico sin Derivacion")
	public void agregaLaDescripcionDelDiagnosticoSinDerivacion() {
		gestionReclamoStep.agregarDescripcion();
		gestionReclamoStep.clickBotonSolucionar();
	}
	
	@When("agregar comentario")
	public void agregarComentario() {
		asistenciaTecnicaStep.agregarComentario("Prueba");
	}
	
	
	@When("valida los datos de IBS")
	public void validaLosDatosDeIBS() {	
		gestionReclamoStep.clickContinuarIBS();
	}
	
	@When("finaliza la validacion de datos")
	public void finalizaLaValidacionDeDatos() {	
		asistenciaTecnicaStep.clickFinalizar();
	}
	
	@When("registra el motivo de gestion {string}")
	public void registraMotivoGestion( String motivo) {	
		asistenciaTecnicaStep.seleccionarSubCategoriaContacto(motivo);
	}
	@When("registra la categoria para derivar {string}")
	public void registraLaCategoriaParaDerivar( String motivo) {	
		asistenciaTecnicaStep.seleccionarCategoriaDerivar(motivo);

	}
	
	@When("registra el motivo a derivar {string}")
	public void registraMotivoADerivar(String motivo) {	
		asistenciaTecnicaStep.seleccionarMotivoDerivar(motivo);
	}
	@When("registra el submotivo de gestion {string}")
	public void registraSubMotivoGestion(String subMotivo) {	
		asistenciaTecnicaStep.seleccionarSegundaSubcategoriaContacto(subMotivo);
	}
	@When("registra el submotivo a derivar {string}")
	public void registraSubMotivoDerivar(String subMotivo) {	
		asistenciaTecnicaStep.seleccionarSubMotivoADerivar(subMotivo);
		gestionReclamoStep.clickDerivar();
	}
	@When("registra el submotivo sin derivar {string}")
	public void registraSubMotivoSinDerivar(String subMotivo) {	
		asistenciaTecnicaStep.seleccionarSubMotivoADerivar(subMotivo);
		gestionReclamoStep.clickSolucionar();
	}
	
	@When("registra la razon de gestion")
	public void registraRazonGestion() {	
		gestionReclamoStep.registraRazonGestion();
		
	}

	@When("Validar derivacion")
	public void finalizarDerivacion() {	
			asistenciaTecnicaStep.validarDerivacion();
						
	}
	
	@When("diligencia el motivo del tramite {string}")
	public void diligenciarMotivoTramite(String motivo) {
		asistenciaTecnicaStep.diligenciarMotivoPQR(motivo);
	}
	
	@When("diligencia el submotivo del tramite {string}")
	public void diligenciarSubMotivoTramite( String subMotivo) {
		asistenciaTecnicaStep.diligenciarSubMotivoPQR(subMotivo);
	}

	@When("valida los datos de IBS de la derivacion")
	public void validaLosDatosDeIBSDeLaDerivacion() {
		gestionReclamoStep.seleccionaReasonDerivacion();
		gestionReclamoStep.clickContinuarIBS();
	}
	@When("continuar derivacion corporativo")
	public void continuarDerivacionCorporativo() {
		gestionReclamoStep.clickContinuarIBS();
	}
	
	@When("agrega la descripcion del diagnostico a derivar")
	public void agregaLaDescripcionDelDiagnosticoADerivar() {
	    gestionReclamoStep.agregaLaDescripcionDelDiagnosticoADerivar();
	}
	
	@When("ingresar a pestana cliente")
	public void ingresarAPestanaCliente() {
		clienteStep.ingresarAPestanaCliente();
	}
	
}
