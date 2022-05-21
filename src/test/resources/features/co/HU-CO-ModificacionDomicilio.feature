@REQ_TACS-2284
Feature: ROBOT-HU-ENGAGE-CO - Modificaciones

	@TEST_TACS-2068 @TESTSET_TACS-735 @TESTSET_TACS-742 @ENGAGE.CO.CITAONLINEMUDANZA @ENGAGE.CO.MODIFICACIONES @ENGAGE.CO.REGRESION
	Scenario: ROBOT-TC-ENGAGE-CO-WEB - Modificacion de Domicilio - REG - Cita Online - Mudanza - Flujo Basico
		Given ingresar a Engage web
		When seleccionar perfil modificacion
		And seleccionar el cliente a procesar modificacion "Normal"
		And selecciona el proceso "Informacion del Cliente"
		And diligencia modificacion domicilio
		And modificacion de domicilio
		And verificar direccion cliente
		And finalizo la sesion del usuario
	@TEST_TACS-2071 @TESTSET_TACS-735 @TESTSET_TACS-742 @ENGAGE.CO.MODIFICACIONES @ENGAGE.CO.MODIFICACIONTELEFONOCLIENTERESIDENCIAL @ENGAGE.CO.REGRESION
	Scenario: ROBOT-TC-ENGAGE-CO-WEB - Modificacion de telefono para cliente residencial
		Given ingresar a Engage web
		When seleccionar perfil modificacion
		And seleccionar el cliente a procesar modificacion "Normal"
		And selecciona el proceso "Informacion del Cliente"
		And diligencia modificacion telefono
		And seleccionar el cliente a procesar modificacion "Normal"
		And selecciona el proceso "Informacion del Cliente"
		And verificar modificacion telefono
		And finalizo la sesion del usuario
	@TEST_TACS-2075 @TESTSET_TACS-735 @TESTSET_TACS-742 @ENGAGE.CO.MODIFICACIONEMAILCLIENTERESIDENCIAL @ENGAGE.CO.MODIFICACIONES @ENGAGE.CO.REGRESION
	Scenario: ROBOT-TC-ENGAGE-CO-WEB - Modificacion de email para cliente residencial
		Given ingresar a Engage web
		When selecciona el perfil "SAC Colombia"
		And seleccionar el cliente a procesar modificacion "Normal"
		And selecciona el proceso "Informacion del Cliente"
		And diligencia modificacion email
		And seleccionar el cliente a procesar modificacion "Normal"
		And selecciona el proceso "Informacion del Cliente"
		And verificar email cliente
		And finalizo la sesion del usuario
