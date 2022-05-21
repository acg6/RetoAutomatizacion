@REQ_TACS-2288
Feature: ROBOT-HU-ENGAGE-AR - Modificaciones

	@TEST_TACS-2187 @TESTSET_TACS-735 @TESTSET_TACS-742 @ENGAGE.AR.CITAONLINEMUDANZACORPORATIVO @ENGAGE.AR.MODIFICACIONES @ENGAGE.AR.REGRESION
	Scenario: ROBOT-TC-ENGAGE-AR-WEB - Modificacion de domicilio de cliente corporativo
		Given ingresar a Engage web
		When seleccionar perfil modificacion
		And ingresar el cliente corporativo a procesar
		And diligencia modificacion domicilio
		And modificacion de domicilio 
		And verificar direccion cliente
		And finalizo la sesion del usuario

 	@TEST_TACS-2186 @TESTSET_TACS-742 @TESTSET_TACS-735 @ENGAGE.AR.MODIFICACIONES @ENGAGE.AR.MODIFICACIONTELEFONOCLIENTECORPORATIVO @ENGAGE.AR.REGRESION
	Scenario: ROBOT-TC-ENGAGE-AR-WEB - Modificacion de telefono Corporativo
		Given ingresar a Engage web
		When seleccionar perfil modificacion
		And ingresar el cliente corporativo a procesar
		And diligencia modificacion telefono 
		And registra el motivo de gestion "08-Otros"
	 	And registra el submotivo de gestion "044-Cambio datos de la cuenta/forma de pago"
		And seleccionar el cliente a procesar modificacion "Normal"
		And selecciona el proceso "Informacion del Cliente"
		And verificar modificacion telefono
		And finalizo la sesion del usuario
