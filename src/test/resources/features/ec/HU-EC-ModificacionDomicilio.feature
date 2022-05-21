@REQ_TACS-2280
Feature: ROBOT-HU-ENGAGE-EC - Modificaciones

	@TEST_TACS-2069 @TESTSET_TACS-735 @TESTSET_TACS-742 @ENGAGE.EC.CITAONLINEMUDANZA @ENGAGE.EC.MODIFICACIONES @ENGAGE.EC.REGRESION
	Scenario: ROBOT-TC-ENGAGE-EC-WEB - Modificacion de Domicilio - REG - Cita Online - Mudanza - Flujo Basico
		Given ingresar a Engage web
		When seleccionar perfil modificacion
		And seleccionar el cliente a procesar modificacion "Normal"
		And selecciona el proceso "Informacion del Cliente"
		And diligencia modificacion domicilio
		And modificacion de domicilio
		And verificar direccion cliente
		And finalizo la sesion del usuario
	@TEST_TACS-2072 @TESTSET_TACS-735 @TESTSET_TACS-742 @ENGAGE.EC.MODIFICACIONES @ENGAGE.EC.MODIFICACIONTELEFONOCLIENTERESIDENCIAL @ENGAGE.EC.REGRESION
	Scenario: ROBOT-TC-ENGAGE-EC-WEB - Modificacion de telefono para cliente residencial
		Given ingresar a Engage web
		When seleccionar perfil modificacion
		And seleccionar el cliente a procesar modificacion "Normal"
		And selecciona el proceso "Informacion del Cliente"
		And diligencia modificacion telefono
		And seleccionar el cliente a procesar modificacion "Normal"
	  And selecciona el proceso "Informacion del Cliente"
		And verificar modificacion telefono
		And finalizo la sesion del usuario
	@TEST_TACS-2076 @TESTSET_TACS-735 @TESTSET_TACS-742 @ENGAGE.EC.MODIFICACIONEMAILCLIENTERESIDENCIAL @ENGAGE.EC.MODIFICACIONES @ENGAGE.EC.REGRESION
	Scenario: ROBOT-TC-ENGAGE-EC-WEB - Modificacion de email para cliente residencial
		Given ingresar a Engage web
		When seleccionar perfil modificacion
		And seleccionar el cliente a procesar modificacion "Normal"
		And selecciona el proceso "Informacion del Cliente"
		And diligencia modificacion email
		And seleccionar el cliente a procesar modificacion "Normal"
		And selecciona el proceso "Informacion del Cliente"
		And verificar email cliente
		And finalizo la sesion del usuario
