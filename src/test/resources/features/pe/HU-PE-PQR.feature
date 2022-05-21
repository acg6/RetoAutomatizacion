@REQ_TACS-1298
Feature: ROBOT-HU-ENGAGE-PE - PQR

	@TEST_TACS-1297 @TESTSET_TACS-742 @TESTSET_TACS-1299 @ENGAGE.PE.GENERACIONPQRCONDERIVACIONCLIENTERESIDENCIAL @ENGAGE.PE.PQR @ENGAGE.PE.REGRESION
	Scenario: ROBOT-TC-ENGAGE-PE-WEB - Generacion de un PQR con Derivacion  para cliente residencial
		Given ingresar a Engage web
		When selecciona el perfil PQR
		And seleccionar el cliente a procesar "Normal"
		And verificar que exista el correo cliente "PQR"
		And indica una super categoria del tramite disponible
		And diligencia el motivo del tramite "02-SALDO Y PAGO"
		And diligencia el submotivo del tramite "011-Solicita reembolso de dinero"
		And agrega la descripcion del diagnostico a derivar
		And valida los datos de IBS de la derivacion
		And finaliza la validacion de datos
		And registra el motivo de gestion "02-SALDO Y PAGO"
		And registra el submotivo de gestion "011-Solicita reembolso de dinero"
		And registra la razon de gestion
		Then verificar estado cliente "Normal"
		And finalizo la sesion del usuario
	@TEST_TACS-1296 @TESTSET_TACS-742 @TESTSET_TACS-1299 @ENGAGE.PE.PQR @ENGAGE.PE.REGRESION @ENGAGE.REG.GENERACIONPQRSINDERIVACIONCLIENTERESIDENCIAL
	Scenario: ROBOT-TC-ENGAGE-PE-WEB - Generacion de un PQR sin Derivacion para cliente residencial
		Given ingresar a Engage web
		When selecciona el perfil PQR
		And seleccionar el cliente a procesar "Normal"
		And verificar que exista el correo cliente "PQR"
		And indica una super categoria del tramite disponible
		And diligencia el motivo del tramite "01-NO ENTIENDE/ERROR FACTURA"
		And diligencia el submotivo del tramite "001-Otra expectativa Promo/Oferta"
		And agrega la descripcion del diagnostico
		And valida los datos de IBS
		And finaliza la validacion de datos
		And registra el motivo de gestion "01-NO ENTIENDE/ERROR FACTURA"
		And registra el submotivo de gestion "001-Otra expectativa Promo/Oferta"
		And registra la razon de gestion
		Then verificar estado cliente "Normal"
		And finalizo la sesion del usuario