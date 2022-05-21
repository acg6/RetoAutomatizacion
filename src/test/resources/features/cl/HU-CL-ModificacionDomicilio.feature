@REQ_TACS-2230
Feature: ROBOT-HU-ENGAGE-CL - Modificaciones

	@TEST_TACS-3099 @TESTSET_TACS-1951 @ENGAGE.CL.REGRESION @ENGAGE.CL.RETENCIONESPREPAGO @ENGAGE.CL.RETENCIONPREPAGOACEPTAPROPUESTA
	Scenario: ROBOT-TC-ENGAGE-CL-WEB - Modificacion de domicilio de cliente corporativo
		Given ingresar a Engage web
		When seleccionar perfil modificacion
		And ingresar el cliente corporativo a procesar
		And diligencia modificacion domicilio
		And modificacion de domicilio
		And verificar direccion cliente
		And finalizo la sesion del usuario

@TEST_TACS-3100 @TESTSET_TACS-1951 @ENGAGE.CL.REGRESION @ENGAGE.CL.RETENCIONESPREPAGO @ENGAGE.CL.RETENCIONPREPAGOACEPTAPROPUESTA
 Scenario: ROBOT-TC-ENGAGE-CL-WEB - Modificacion de telefono corporativo
   Given ingresar a Engage web
   When seleccionar perfil modificacion
   And ingresar el cliente corporativo a procesar
   And diligencia modificacion telefono
   And registra el motivo de gestion "08-OTROS"
	 And registra el submotivo de gestion "044-Cambio datos de la cuenta/forma de pago"
   And seleccionar el cliente a procesar modificacion "Normal"
   And selecciona el proceso "Informacion del Cliente"
   And verificar modificacion telefono
   And finalizo la sesion del usuario			
		
		