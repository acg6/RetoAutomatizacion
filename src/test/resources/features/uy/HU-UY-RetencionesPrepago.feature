@REQ_TACS-1952
Feature: ROBOT-HU-ENGAGE-UY - Retenciones Prepago

	@TEST_TACS-1939 @TESTSET_TACS-742 @TESTSET_TACS-1951 @ENGAGE.UY.REGRESION @ENGAGE.UY.RETENCIONESPREPAGO @ENGAGE.UY.RETENCIONPREPAGOACEPTAPROPUESTA
	Scenario: ROBOT-TC-ENGAGE-UY-WEB - Retencion prepago - Acepta con propuesta
		Given ingresar a Engage web
		When seleccionar perfil retenciones Prepago
		And seleccionar el cliente a procesar Prepago "Normal"
		And seleccionar motivo de no recarga
		And seleccionar submotivo de no recarga
		And seleccionar propuestas comerciales
		Then seleccionar resultado de gestion aceptar
		And seleccionar finalizar
		And verificar pantalla inicial
		And Cerrar sesion aplicativo
	@TEST_TACS-1940 @TESTSET_TACS-742 @TESTSET_TACS-1951 @ENGAGE.UY.REGRESION @ENGAGE.UY.RETENCIONESPREPAGO @ENGAGE.UY.RETENCIONPREPAGONOACEPTAKEYWORDCONTENIDO
	Scenario: ROBOT-TC-ENGAGE-UY-WEB - Retencion prepago - No acepta con keyword contenido
		Given ingresar a Engage web
		When seleccionar perfil retenciones Prepago
		And seleccionar el cliente a procesar Prepago "Normal"
		And seleccionar motivo de no recarga
		And seleccionar submotivo de no recarga
		And seleccionar propuestas comerciales
		And seleccionar "2" opciones de contenido
		Then seleccionar resultado de gestion no acepta
		And seleccionar finalizar
		And verificar pantalla inicial
		And Cerrar sesion aplicativo
	@TEST_TACS-1941 @TESTSET_TACS-742 @TESTSET_TACS-1951 @ENGAGE.UY.REGRESION @ENGAGE.UY.RETENCIONESPREPAGO @ENGAGE.UY.RETENCIONPREPAGONOACEPTA
	Scenario: ROBOT-TC-ENGAGE-UY-WEB - Retencion prepago - No acepta
		Given ingresar a Engage web
		When seleccionar perfil retenciones Prepago
		And seleccionar el cliente a procesar Prepago "Normal"
		And seleccionar motivo de no recarga
		And seleccionar submotivo de no recarga
		And seleccionar propuestas comerciales
		Then seleccionar resultado de gestion no acepta
		And seleccionar finalizar
		And verificar pantalla inicial
		And Cerrar sesion aplicativo
	@TEST_TACS-1942 @TESTSET_TACS-742 @TESTSET_TACS-1951 @ENGAGE.UY.REGRESION @ENGAGE.UY.RETENCIONESPREPAGO @ENGAGE.UY.RETENCIONPREPAGORELLAMAR
	Scenario: ROBOT-TC-ENGAGE-UY-WEB - Retencion prepago - Rellamar
		Given ingresar a Engage web
		When seleccionar perfil retenciones Prepago
		And seleccionar el cliente a procesar Prepago "Normal"
		Then seleccionar resultado de gestion rellamar
		And seleccionar finalizar
		And verificar pantalla inicial
		And Cerrar sesion aplicativo
	@TEST_TACS-2230 @TESTSET_TACS-742 @TESTSET_TACS-1951 @ENGAGE.UY.REGRESION @ENGAGE.UY.RETENCIONESPREPAGO @ENGAGE.UY.RETENCIONPREPAGORETIRARGESTION
	Scenario: ROBOT-TC-ENGAGE-UY-WEB - Retencion prepago - Retirar de Gestion
		Given ingresar a Engage web
		When seleccionar perfil retenciones Prepago
		And seleccionar el cliente a procesar Prepago "Normal"
		And seleccionar motivo de no recarga
		And seleccionar submotivo de no recarga
		And seleccionar propuestas comerciales
		Then seleccionar resultado de retirar gestion
		And seleccionar finalizar
		And verificar pantalla inicial
		And Cerrar sesion aplicativo
