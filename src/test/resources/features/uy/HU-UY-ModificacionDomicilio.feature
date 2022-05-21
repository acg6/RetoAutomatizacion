@REQ_TACS-740
Feature: ROBOT-HU-ENGAGE-UY - Modificaciones

	@TEST_TACS-631 @TESTSET_TACS-735 @TESTSET_TACS-742 @ENGAGE.UY.CITAONLINEMUDANZA @ENGAGE.UY.MODIFICACIONES @ENGAGE.UY.REGRESION
	Scenario: ROBOT-TC-ENGAGE-UY-WEB - Modificacion de Domicilio - REG - Cita Online - Mudanza - Flujo Basico
		Given ingresar a Engage web
		When seleccionar perfil modificacion
		And seleccionar el cliente a procesar modificacion "Normal"
		And selecciona el proceso "Informacion del Cliente"
		And diligencia modificacion domicilio
		And modificacion de domicilio
		And verificar direccion cliente
		And finalizo la sesion del usuario
	@TEST_TACS-1300 @TESTSET_TACS-735 @ENGAGE.UY.MODIFICACIONES @ENGAGE.UY.MODIFICACIONTELEFONOCLIENTERESIDENCIAL @ENGAGE.UY.REGRESION
	Scenario: ROBOT-TC-ENGAGE-UY-WEB - Modificacion de telefono para cliente residencial
		Given ingresar a Engage web
		When seleccionar perfil modificacion
		And seleccionar el cliente a procesar modificacion "Normal"
		And selecciona el proceso "Acceso Rapido de Tramites"
		And diligencia modificacion telefono
		And seleccionar el cliente a procesar modificacion "Normal"
		And selecciona el proceso "Informacion del Cliente"
		And verificar modificacion telefono
		And finalizo la sesion del usuario
	@TEST_TACS-1301 @TESTSET_TACS-735 @ENGAGE.UY.MODIFICACIONEMAILCLIENTERESIDENCIAL @ENGAGE.UY.MODIFICACIONES @ENGAGE.UY.REGRESION
	Scenario: ROBOT-TC-ENGAGE-UY-WEB - Modificacion de email para cliente residencial
		Given ingresar a Engage web
		When seleccionar perfil modificacion
		And seleccionar el cliente a procesar modificacion "Normal"
		And selecciona el proceso "Informacion del Cliente"
		And diligencia modificacion email
		And seleccionar el cliente a procesar modificacion "Normal"
		And selecciona el proceso "Informacion del Cliente"
		And verificar email cliente
		And finalizo la sesion del usuario
