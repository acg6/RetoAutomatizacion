@REQ_TACS-2274
Feature: ROBOT-HU-ENGAGE-PE - Modificaciones

	@TEST_TACS-2067 @TESTSET_TACS-735 @TESTSET_TACS-742 @ENGAGE.PE.CITAONLINEMUDANZA @ENGAGE.PE.MODIFICACIONES @ENGAGE.PE.REGRESION
	Scenario: ROBOT-TC-ENGAGE-PE-WEB - Modificacion de Domicilio - REG - Cita Online - Mudanza - Flujo Basico
		Given ingresar a Engage web
		When seleccionar perfil modificacion
		And seleccionar el cliente a procesar modificacion "Normal"
		And selecciona el proceso "Informacion del Cliente"
		And diligencia modificacion domicilio
		And modificacion de domicilio
		And verificar direccion cliente
		And finalizo la sesion del usuario
	@TEST_TACS-2070 @TESTSET_TACS-735 @TESTSET_TACS-742 @ENGAGE.PE.MODIFICACIONES @ENGAGE.PE.MODIFICACIONTELEFONOCLIENTERESIDENCIAL @ENGAGE.PE.REGRESION
	Scenario: ROBOT-TC-ENGAGE-PE-WEB - Modificacion de telefono para cliente residencial
		Given ingresar a Engage web
		When seleccionar perfil modificacion
		And seleccionar el cliente a procesar modificacion "Normal"
		And selecciona el proceso "Informacion del Cliente"
		And diligencia modificacion telefono
		And seleccionar el cliente a procesar modificacion "Normal"
		And selecciona el proceso "Informacion del Cliente"
		And verificar modificacion telefono
		And finalizo la sesion del usuario
	@TEST_TACS-2074 @TESTSET_TACS-735 @TESTSET_TACS-742 @ENGAGE.PE.MODIFICACIONEMAILCLIENTERESIDENCIAL @ENGAGE.PE.MODIFICACIONES @ENGAGE.PE.REGRESION
	Scenario: ROBOT-TC-ENGAGE-PE-WEB - Modificacion de email para cliente residencial
		Given ingresar a Engage web
		When seleccionar perfil modificacion
		And seleccionar el cliente a procesar modificacion "Normal"
		And selecciona el proceso "Informacion del Cliente"
		And diligencia modificacion email
		And seleccionar el cliente a procesar modificacion "Normal"
		And selecciona el proceso "Informacion del Cliente"
		And verificar email cliente
		And finalizo la sesion del usuario
