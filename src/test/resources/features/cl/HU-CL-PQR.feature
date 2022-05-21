@REQ_TACS-2289
Feature: ROBOT-HU-ENGAGE-CL - PQR

	@TEST_TACS-3097 @TESTSET_TACS-1951 @ENGAGE.CL.REGRESION @ENGAGE.CL.RETENCIONESPREPAGO @ENGAGE.CL.RETENCIONPREPAGOACEPTAPROPUESTA
	Scenario: ROBOT-TC-ENGAGE-CL-WEB - Generacion de un PQR con Derivacion  para cliente corporativo
		Given ingresar a Engage web
		When selecciona el perfil PQR
		And ingresar el cliente corporativo a procesar
		And indica una super categoria del tramite disponible
		And diligencia el motivo del tramite "03-SIN SEÑAL"
		And diligencia el submotivo del tramite "021-Fallas origen de transmisión/sistemas-apoyo"
		And agrega la descripcion del diagnostico Derivacion
		And registra la categoria para derivar "07-Requerimientos Técnicos"
		And registra el motivo a derivar "02-Servicio Tecnico"
		And registra el submotivo a derivar "019-Dónde está mi técnico"
		And continuar derivacion corporativo
		And Validar derivacion  
		And finalizo la sesion del usuario
		
	@TEST_TACS-3098 @TESTSET_TACS-1951 @ENGAGE.CL.REGRESION @ENGAGE.CL.RETENCIONESPREPAGO @ENGAGE.CL.RETENCIONPREPAGOACEPTAPROPUESTA
	Scenario: ROBOT-TC-ENGAGE-CL-WEB - Generacion de un PQR sin Derivacion para cliente corporativo
		Given ingresar a Engage web
		When selecciona el perfil PQR
		And ingresar el cliente corporativo a procesar
		And indica una super categoria del tramite disponible
		And diligencia el motivo del tramite "01-NO ENTIENDE/ERROR FACTURA"
		And diligencia el submotivo del tramite "001-Otra expectativa Promo/Oferta"
		And agrega la descripcion del diagnostico sin Derivacion
		And agregar comentario 
		Then Validar derivacion  
		And finalizo la sesion del usuario
		
 