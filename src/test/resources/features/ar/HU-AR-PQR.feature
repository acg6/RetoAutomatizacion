@REQ_TACS-2287
Feature: ROBOT-HU-ENGAGE-AR - PQR

	@TEST_TACS-2185 @TESTSET_TACS-742 @TESTSET_TACS-1299 @ENGAGE.AR.GENERACIONPQRCONDERIVACIONCLIENTECORPORATIVO @ENGAGE.AR.PQR @ENGAGE.AR.REGRESION
	Scenario: ROBOT-TC-ENGAGE-AR-WEB - Generacion de un PQR con Derivacion  para cliente corporativo
		Given ingresar a Engage web
		When selecciona el perfil PQR
		And ingresar el cliente corporativo a procesar
		And verificar que exista el correo cliente "PQR AR"
		And indica una super categoria del tramite disponible
		And diligencia el motivo del tramite "03-SIN SEÑAL"
		And diligencia el submotivo del tramite "022-Instaló y no activó"
		And agrega la descripcion del diagnostico Derivacion
		And registra la categoria para derivar "07-Requerimientos Técnicos"
		And registra el motivo a derivar "02-Servicios Técnicos"
		And registra el submotivo a derivar "007-Atención técnico/instalador"
		And continuar derivacion corporativo
		And Validar derivacion  
		And finalizo la sesion del usuario
	@TEST_TACS-2184 @TESTSET_TACS-742 @TESTSET_TACS-1299 @ENGAGE.AR.GENERACIONPQRSINDERIVACIONCLIENTECOROPORATIVO @ENGAGE.AR.PQR @ENGAGE.AR.REGRESION
	Scenario: ROBOT-TC-ENGAGE-AR-WEB - Generacion de un PQR sin Derivacion para cliente corporativo
		Given ingresar a Engage web
		When selecciona el perfil PQR
		And ingresar el cliente corporativo a procesar
		And verificar que exista el correo cliente "PQR AR"
		And indica una super categoria del tramite disponible
		And diligencia el motivo del tramite "03-SIN SEÑAL"
		And diligencia el submotivo del tramite "022-Instaló y no activó"
		And agrega la descripcion del diagnostico Derivacion
		And registra la categoria para derivar "07-Requerimientos Técnicos"
		And registra el motivo a derivar "02-Servicios Técnicos"
		And registra el submotivo sin derivar "007-Atención técnico/instalador"
		And continuar derivacion corporativo
		And Validar derivacion  
		And finalizo la sesion del usuario
