@REQ_TACS-2275
Feature: ROBOT-HU-ENGAGE-PE - Retenciones Prepago

	@TEST_TACS-2080 @TESTSET_TACS-742 @TESTSET_TACS-1951 @ENGAGE.PE.REGRESION @ENGAGE.PE.RETENCIONESPREPAGO @ENGAGE.PE.RETENCIONPREPAGOACEPTAPROPUESTA
	Scenario: ROBOT-TC-ENGAGE-PE-WEB - Retencion prepago - Acepta con propuesta
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
	@TEST_TACS-2087 @TESTSET_TACS-742 @TESTSET_TACS-1951 @ENGAGE.PE.REGRESION @ENGAGE.PE.RETENCIONESPREPAGO @ENGAGE.PE.RETENCIONPREPAGONOACEPTAKEYWORDCONTENIDO
	Scenario: ROBOT-TC-ENGAGE-PE-WEB - Retencion prepago - No acepta con keyword contenido
		Given ingresar a Engage web
		When seleccionar perfil retenciones Prepago
		And seleccionar el cliente a procesar Prepago "Normal"
		And seleccionar motivo de no recarga
		And seleccionar submotivo de no recarga
		And seleccionar propuestas comerciales
		And seleccionar "2" opciones de contenido
		Then seleccionar resultado de gestion no acepta
		And seleccionar finalizar
		And Cerrar sesion aplicativo
	@TEST_TACS-2092 @TESTSET_TACS-742 @TESTSET_TACS-1951 @ENGAGE.PE.REGRESION @ENGAGE.PE.RETENCIONESPREPAGO @ENGAGE.PE.RETENCIONPREPAGONOACEPTA
	Scenario: ROBOT-TC-ENGAGE-PE-WEB - Retencion prepago - No acepta
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
	@TEST_TACS-2099 @TESTSET_TACS-742 @TESTSET_TACS-1951 @ENGAGE.PE.REGRESION @ENGAGE.PE.RETENCIONESPREPAGO @ENGAGE.PE.RETENCIONPREPAGORELLAMAR
	Scenario: ROBOT-TC-ENGAGE-PE-WEB - Retencion prepago - Rellamar
		Given ingresar a Engage web
		When seleccionar perfil retenciones Prepago
		And seleccionar el cliente a procesar Prepago "Normal"
		Then seleccionar resultado de gestion rellamar
		And seleccionar finalizar
		And verificar pantalla inicial
		And Cerrar sesion aplicativo
	@TEST_TACS-2231 @TESTSET_TACS-742 @TESTSET_TACS-1951
	Scenario: ROBOT-TC-ENGAGE-PE-WEB - Retencion prepago - Retirar de Gestion
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
