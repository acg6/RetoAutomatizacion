package regional.definitions;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import regional.steps.ClienteStep;
import regional.steps.GestionRetencionStep;
import regional.steps.LogoutStep;
import regional.steps.PerfilStep;
import regional.steps.SeleccionPaisStep;
import regional.utilities.UtilConsulta;
import regional.utilities.UtilDatos;

public class ClienteDefinitions {
	
	@Steps
	PerfilStep perfilStep;
	
	@Steps
	ClienteStep clienteStep;
	@Steps
	GestionRetencionStep gestionRetencionStep;
	@Steps
	LogoutStep logoutStep;
	UtilConsulta utilConsulta;
	
	@Steps
	SeleccionPaisStep seleccionPais;
	
	@Given("seleccionar el cliente a procesar modificacion {string}")
	public void seleccionarClienteProcesarModificacion(String estado) throws IOException {
		clienteStep.procesoSeleccionCliente(estado);	
	}
	
	@Given("seleccionar el cliente a procesar {string}")
	public void seleccionarClienteProcesar(String estado) throws IOException{
		clienteStep.procesoSeleccionCliente(estado);
		clienteStep.seleccionarProceso();	
	}
	
	
	@When("seleccionar cliente {string}")
	public void seleccionarCliente(String strEstado) {
		clienteStep.seleccionarUnCliente(strEstado);
	}		

	@When("seleccionar el proceso {string}")
	public void seleccionaProceso(String strProceso) {
		clienteStep.seleccionarProceso(strProceso);
		clienteStep.clickNuevoProceso();
	}
		
	@When("selecciona el proceso \"([^\"]*)\"$")
	public void seleccionaElProceso(String strProceso) {
		clienteStep.seleccionarProceso();
	}
	
	@When("selecciona el proceso modificacion {string}")
	public void seleccionarProcesoModificacion(String procesoDisponible) {
		clienteStep.seleccionarProceso(procesoDisponible);
		
	}
	
	@Given("seleccionar clase de retencion Inbound")
	public void seleccionarClaseRetencion() {
		clienteStep.seleccionarResultado();
		clienteStep.clickContinuarProceso();
	}

	@When("valida que el resultado sea intencion baja")
	public void validaIntencionBajaDeResultado() {
		gestionRetencionStep.clickIntencionBajaContinuar();
	}
	
	@When("valida que el producto este en estado {string}")
	public void validaProductoCancelado(String estadoProducto) {
		gestionRetencionStep.clickPestanaProductos();
		clienteStep.verificarEstadoProductoCancelado(estadoProducto);
		gestionRetencionStep.clickVolverPestanaProductos();
	}

	@When("indica una categoria de beneficio principal Engage")
	public void indicaUnaCategoriaDeBeneficioPrincipalEngage() {
		gestionRetencionStep.seleccionarCategoriaBeneficioPrincipalEngage();
	}

	@When("selecciona un beneficio principal")
	public void seleccionaUnBeneficioPrincipal() {
		gestionRetencionStep.seleccionarBeneficioPrincipal();
	}
	@When("selecciona un beneficio principal Engage")
	public void seleccionaUnBeneficioPrincipalEngage() {
		gestionRetencionStep.seleccionarBeneficioPrincipalEngage();
	}
	
			
	@When("agrega el tipo de resultado {string}")
	public void agregaElTipoDeResultado(String tipoResultado) {
		gestionRetencionStep.seleccionarResultadoDeRetencion(tipoResultado);
		gestionRetencionStep.clickIntencionBajaContinuar();
	}
	
	@When("agrega producto activo")
	public void agregaProductoActivo() {
		gestionRetencionStep.agregarProductoActivo();
	}
	
	
	//REvisar
	@When("agregar observacion {string}")
	public void agregarObservacion(String observacion) {
		gestionRetencionStep.agregarObservacion(observacion);
		gestionRetencionStep.clickContinuar();	
		gestionRetencionStep.seleccionarContinuar();
	}
	
	///REvisar
	@When("agregar observacion con {string}")
	public void agregarPrimeraObservacion(String observacion) {
		gestionRetencionStep.agregarObservacion(observacion);
		gestionRetencionStep.clickContinuar();	
	}
	
	@When("agregar informacion")
	public void agregarInformacion() {
		gestionRetencionStep.agregarInformacion();
		gestionRetencionStep.clickContinuar();		
	}
	
	@When("^agregar nota \"([^\"]*)\"$")
	public void agregarNota(String strNota) {
		gestionRetencionStep.agregarNota(strNota);
		gestionRetencionStep.clickContinuar();		
	}
	
	@When("aceptar fecha de terminacion")
	public void aceptarFechaTerminacion() {
		gestionRetencionStep.clickContinuar();
	}
	
	@When("indica una categoria en IBS")	
	public void indicaUnaCategoriaEnIBS() {
	   gestionRetencionStep.seleccionarSubCategoriaIBS();
	}

	@Then("valida que se haya registrado el retenido de manera exitosa")
	public void validaQueSeHayaRegistradoElRetenidoDeManeraExitosa() {
	   clienteStep.guardarCaptura();
	}

	@Then("finalizo la sesion del usuario")
	public void finalizoLaSesionDelUsuario() {
		clienteStep.guardarCaptura();
		logoutStep.cerrarSesionAplicativo();
	}
	
	@When("finalizo la sesion del usuario ingresado")
	public void finalizoLaSesionDelUsuarioIngresado() {
		logoutStep.cerrarSesionAplicativo();
	}
	
	@When("adicionar segunda categoria")
	public void adicionarSegundaCategoria() {
		gestionRetencionStep.segundaCategoria();
	}
	
	@When("seleccionar la accion poswinback {string}")
	public void seleccionarLaAccionPos(String strAccion) {
	    gestionRetencionStep.seleccionarAccionPosWinBack(strAccion);
	}
	@When("seleccionar producto a cancelar inbound")
	public void sleccionarProductoInbound() {
	    gestionRetencionStep.seleccionarProductoInbound();
	}
	
	@When("registrar producto downgrade poswinback")
	public void registrarProductoDowngradePoswinback() {
	    gestionRetencionStep.registrarProductoDowngradePoswinback();
	}
	
	@When("registrar el nuevo producto")
	public void refgistrarElUnNuevoProducto() {
		gestionRetencionStep.clickRegistrar(); 
	}
			
	@When("seleccionar un producto de la lista {string}")
	public void seleccionarProductoDeLista(String nuevoProducto) {
		gestionRetencionStep.seleccionarListaProducto2365(nuevoProducto);	    
	}
		
	
	@Then("valida el beneficio seleccionado")
	public void validaElBeneficioSeleccionadoTerminaElProceso() {
		clienteStep.seleccionarCliente(UtilDatos.getClientePospago());
		clienteStep.seleccionarProceso();	
		gestionRetencionStep.obtenerCategoriaRetenido();
	}
	
	@Then("finalizo la sesion del usuario generada")
	public void finalizoLaSesionDelUsuarioGenerada() {
		logoutStep.finalizarSesionAplicativo(); 
	}
	
	@When("seleccionar clase de retencion Outbound")
	public void seleccionarClaseDeRetencionOutbound() {
		clienteStep.seleccionarWinback();
		clienteStep.clickContinuarProceso();
	}
	
	@When("indica la septima categoria en IBS")
	public void indicalaSeptimaCategoriaEnIBS() {
		gestionRetencionStep.septimaCategoria();	
	}
	
	
	@When("indica la cuarta categoria en IBS")
	public void indicaLaCuartaCategoriaEnIBS() {
		gestionRetencionStep.indicaLaCuartaCategoriaEnIBS();
	}
	

	
	@When("indica la categoria en IBS {string}")
	public void indicaLaSegundaCategoriaEnIBS(String categoria) {
		gestionRetencionStep.indicaCategoriaEnIBS(categoria);
	}
	
		
	@When("indica categoria de beneficio principal")
	public void indicaCategoriaDeBeneficioPrincipal() {
		gestionRetencionStep.seleccionaCategoriaBeneficioPrincipal();
	}
			
	@When("seleccionar un beneficio principal")
	public void seleccionarBeneficioPrincipal( ) {
		gestionRetencionStep.seleccionaBeneficioPrincipal();
		clienteStep.clickBotonAgregar();
	}
	
	@Then("verificar email cliente")
	public void verficarEmail() {
		clienteStep.verificarEmail();
	}
	@Then("verificar producto cancelado")
	public void verificarProductoCancelado() {
		clienteStep.verificarProductoCancelado();
	}
	
	@When("verificar modificacion telefono")
	public void verficarModificacionTelefono() {
		clienteStep.verificarTelefono();    	
	}
	
	@Then("verificar direccion cliente")
    public void verficarDireccion() {
        clienteStep.verificarDireccion(UtilDatos.getDireccion());    
    }
	
	@Given("seleccionar el cliente a procesar Prepago {string}")
	public void seleccionarClienteProcesarPrepago(String estado) throws IOException{
		clienteStep.procesoSeleccionClientePrepago(estado);
		clienteStep.seleccionarProceso();	
	}
	
	@Given("seleccionar el cliente Pospago {string} proceso {string}")
	public void seleccionarClienteProcesarPospago(String estado, String proceso) throws IOException{
		clienteStep.procesoSeleccionClientePospago(estado);
		clienteStep.seleccionarProceso(proceso);
		
	}
	
	@Given("seleccionar el cliente Pospago Net {string} proceso {string}")
	public void seleccionarClienteProcesarPospagoNet(String estado, String proceso) throws IOException{
		clienteStep.procesoSeleccionClienteOnlyNet(estado);
		clienteStep.seleccionarProceso(proceso);
	}
	
	@Given("seleccionar el cliente Pospago Net Cancelado {string} proceso {string}")
	public void seleccionarClienteProcesarPospagoNetCancelado(String estado, String proceso) throws IOException{
		clienteStep.procesoSeleccionClienteOnlyNetCancelado(estado);
		clienteStep.seleccionarProceso(proceso);
	
	}
	
	@Given("seleccionar el cliente Pospago Bundle {string} proceso {string}")
	public void seleccionarClienteProcesarPospagoBundle(String estado, String proceso) throws IOException{
		clienteStep.procesoSeleccionClienteBundleTVPospago(estado);
		clienteStep.seleccionarProceso(proceso);
	
	}
	@When("agrega un submotivo de intencion baja")
	public void agregaUnSubmotivoDeIntencionBaja() {
		seleccionPais.submotivoDeIntencionBaja();
	}

	
	@When("agrega un submotivo de intencion baja Net")
	public void agregaUnSubmotivoDeIntencionBajaNet() {
		seleccionPais.motivoPrincipalBaja();
		gestionRetencionStep.clickIntencionBajaContinuar();
	}
	
	@When("agrega motivo de intencion baja para Retenido TV")
	public void agregaMotivoIntencionBajaRetenidoTV() {
		seleccionPais.motivoPrincipalBajaRetenidoTV();
		
	}
	
	@When("agrega un motivo de intencion baja Net")
	public void agregaUnMotivoDeIntencionBajaNet() {
		seleccionPais.motivoPrincipalBaja();
	}
	
	@When("agrega un submotivo de intencion baja Bundle")
	public void agregaUnSubmotivoDeIntencionBajaBundle() {
		gestionRetencionStep.seleccionarMotivoPrincipalBaja();
	}
	
	@When("seleccionar la accion {string}")
	public void seleccionarLaAccion(String strAccion) {
 	    seleccionPais.seleccionarLaAccion(strAccion);
	}
	
	@When("seleccionar un producto")
	public void seleccionarProductoIndex() {
		seleccionPais.seleccionarProductoIndex();
	}
	
	@When("seleccionar el proceso PosWinBack {string}")
	public void seleccionaProcesoPosWinBack(String procesoDisponible) {
		seleccionPais.seleccionaProcesoPosWinBack(procesoDisponible);
	}
	
	@When("seleccionar el proceso PosWinBack")
	public void seleccionaProcesoPosWinBack() {
		seleccionPais.seleccionaProcesoPosWinBack();
	}
	
	@Then("verificar estado cliente {string}")
	public void verficarNoRetencion(String estado) {
		clienteStep.verficarNoRetencion(estado);
	}
	
	@When("ingresar el cliente a procesar Poswinback {string}")
	public void ingresarElClienteAProcesarPoswinback(String strEstado) throws IOException {
		clienteStep.ingresarElClienteAProcesarPoswinback(strEstado);
	}
	
	@When("ingresar el cliente a procesar")
	public void ingresarElClienteAProcesar() throws IOException {
		clienteStep.ingresarElClienteAProcesar();
	}
	
	@When("ingresar el cliente corporativo a procesar")
	public void ingresarElClienteCorporativoAProcesar() throws IOException {
		clienteStep.ingresarElClienteCorporativoAProcesar();
		
	}
	
	@When("validar correo cliente")
	public void validarCorreocliente() throws IOException {
		clienteStep.validarCorreoCliente();
	}
	@When("verificar que exista el correo cliente {string}")
	public void verificarQueExistaElCorreoCliente(String strPerfil) {
		clienteStep.obtenerEmailValido(strPerfil);
	}
	
	@When("seleccionar fecha de baja")
	public void  seleccionarFechaDeBaja() {
		clienteStep.seleccionarFechaDeBaja();
		gestionRetencionStep.seleccionarContinuar();
	}
	
	
	@When("agregar un submotivo de intencion baja")
	public void agregarUnSubmotivoDeIntencionBaja() {
		seleccionPais.agregarUnSubmotivoDeIntencionBaja();
	}

	@When("seleccionar la accion agregar beneficio")
	public void seleccionarAccionAgregarBeneficio() {
		clienteStep.clickBotonAgregar();
		gestionRetencionStep.clickIntencionBajaContinuar();
	}
	
	@When("agrega categoria y beneficio")
	public void agregaCategoriaYBeneficio() {
		gestionRetencionStep.seleccinarCategoriaYBeneficio();
	}
	
	@When("indica la cuarta subcategoria en IBS")
	public void indicaLaCuartaSubCategoriaEnIBS() {
		gestionRetencionStep.indicaLaCuartaCategoriaEnIBS();
		gestionRetencionStep.clickContinuar();	
	}
	
}
