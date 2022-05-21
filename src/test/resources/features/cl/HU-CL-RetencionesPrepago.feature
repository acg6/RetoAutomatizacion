@REQ_TACS-2285
Feature: ROBOT-HU-ENGAGE-CL - Retenciones Prepago

	#Prueba de caso Retencion prepago - Acepta con propuesta
	#En este caso SDS hace uso del servicios sesamo.
	@TEST_TACS-2082 @TESTSET_TACS-742 @TESTSET_TACS-1951 @ENGAGE.CL.REGRESION @ENGAGE.CL.RETENCIONESPREPAGO @ENGAGE.CL.RETENCIONPREPAGOACEPTAPROPUESTA
	Scenario: ROBOT-TC-ENGAGE-CL-WEB - Retencion prepago - Acepta con propuesta
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
	#Prueba de caso Retencion prepago - No acepta con keyword contenido
	#En este caso SDS hace uso del servicios sesamo.
	@TEST_TACS-2089 @TESTSET_TACS-742 @TESTSET_TACS-1951 @ENGAGE.CL.REGRESION @ENGAGE.CL.RETENCIONESPREPAGO @ENGAGE.CL.RETENCIONPREPAGONOACEPTAKEYWORDCONTENIDO
	Scenario: ROBOT-TC-ENGAGE-CL-WEB - Retencion prepago - No acepta con keyword contenido
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
	#Prueba de caso Retencion prepago - No acepta
	#En este caso SDS hace uso del servicios sesamo.
	@TEST_TACS-2094 @TESTSET_TACS-742 @TESTSET_TACS-1951 @ENGAGE.CL.REGRESION @ENGAGE.CL.RETENCIONESPREPAGO @ENGAGE.CL.RETENCIONPREPAGONOACEPTA
	Scenario: ROBOT-TC-ENGAGE-CL-WEB - Retencion prepago - No acepta
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
	#Prueba de caso Retencion prepago - Rellamar
	#En este caso SDS hace uso del servicios sesamo.
	@TEST_TACS-2101 @TESTSET_TACS-742 @TESTSET_TACS-1951 @ENGAGE.CL.REGRESION @ENGAGE.CL.RETENCIONESPREPAGO @ENGAGE.CL.RETENCIONPREPAGORELLAMAR
	Scenario: ROBOT-TC-ENGAGE-CL-WEB - Retencion prepago - Rellamar
		Given ingresar a Engage web
		When seleccionar perfil retenciones Prepago
		And seleccionar el cliente a procesar Prepago "Normal"
		Then seleccionar resultado de gestion rellamar
		And seleccionar finalizar
		And verificar pantalla inicial
		And Cerrar sesion aplicativo
	#Prueba de caso Retención prepago - Retirar Gestión
	#En este caso SDS hace uso del servicios sesamo.
	@TEST_TACS-2497 @TESTSET_TACS-742 @TESTSET_TACS-1951 @ENGAGE.CL.REGRESION @ENGAGE.CL.RETENCIONESPREPAGO @ENGAGE.CL.RETENCIONPREPAGORETIRARGESTION
	Scenario: ROBOT-TC-ENGAGE-CL-WEB - Retencion prepago - Retirar de Gestion
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
