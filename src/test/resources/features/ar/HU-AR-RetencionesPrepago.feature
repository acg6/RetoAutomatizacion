@REQ_TACS-2286
Feature: ROBOT-HU-ENGAGE-AR - Retenciones Prepago

	#Prueba de caso Retencion prepago - Acepta con propuesta
	#En este caso SDS hace uso del servicios sesamo.
	@TEST_TACS-2084 @TESTSET_TACS-742 @TESTSET_TACS-1951 @ENGAGE.AR.REGRESION @ENGAGE.AR.RETENCIONESPREPAGO @ENGAGE.AR.RETENCIONPREPAGOACEPTAPROPUESTA
	Scenario: ROBOT-TC-ENGAGE-AR-WEB - Retencion prepago - Acepta con propuesta
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
	#En este caso ENGAGE hace uso del servicios sesamo.
	@TEST_TACS-2091 @TESTSET_TACS-742 @TESTSET_TACS-1951 @ENGAGE.AR.REGRESION @ENGAGE.AR.RETENCIONESPREPAGO @ENGAGE.AR.RETENCIONPREPAGONOACEPTAKEYWORDCONTENIDO
	Scenario: ROBOT-TC-ENGAGE-AR-WEB - Retencion prepago - No acepta con keyword contenido
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
	#Prueba de caso Retencion prepago -No acepta
	#En este caso ENGAGE hace uso del servicios sesamo.
	@TEST_TACS-2096 @TESTSET_TACS-742 @TESTSET_TACS-1951 @ENGAGE.AR.REGRESION @ENGAGE.AR.RETENCIONESPREPAGO @ENGAGE.AR.RETENCIONPREPAGONOACEPTA
	Scenario: ROBOT-TC-ENGAGE-AR-WEB - Retencion prepago - No acepta
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
	#En este caso ENGAGE hace uso del servicios sesamo.
	@TEST_TACS-2103 @TESTSET_TACS-742 @TESTSET_TACS-1951 @ENGAGE.AR.REGRESION @ENGAGE.AR.RETENCIONESPREPAGO @ENGAGE.AR.RETENCIONPREPAGORELLAMAR
	Scenario: ROBOT-TC-ENGAGE-AR-WEB - Retencion prepago - Rellamar
		Given ingresar a Engage web
		When seleccionar perfil retenciones Prepago
		And seleccionar el cliente a procesar Prepago "Normal"
		Then seleccionar resultado de gestion rellamar
		And seleccionar finalizar
		And verificar pantalla inicial
		And Cerrar sesion aplicativo
	#Prueba de caso Retencion prepago - Retirar de Gestion
	#En este caso ENGAGE hace uso del servicios sesamo.
	@TEST_TACS-2499 @TESTSET_TACS-742 @TESTSET_TACS-1951 @ENGAGE.AR.REGRESION @ENGAGE.AR.RETENCIONESPREPAGO @ENGAGE.AR.RETENCIONPREPAGORETIRARGESTION
	Scenario: ROBOT-TC-ENGAGE-AR-WEB - Retencion prepago - Retirar de Gestion
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
