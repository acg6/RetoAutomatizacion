@REQ_TACS-1000
Feature: ROBOT-HU-ENGAGE-UY - Retenciones PosWinBack

	@TEST_TACS-993 @TESTSET_TACS-742 @TESTSET_TACS-998 @ENGAGE.UY.POSWINBACKRETENIDOBENEFICIO @ENGAGE.UY.REGRESION @ENGAGE.UY.RETENCIONESPOSWINBACK
	Scenario: ROBOT-TC-ENGAGE-UY-WEB - Retenciones Poswinback - REG -  Intencion de Baja -  Retenido con beneficio 
		Given ingresar a Engage web
		When selecciona el perfil PosWinBack
		And ingresar el cliente a procesar Poswinback "Pending Cancellation"
		And seleccionar el proceso PosWinBack
		And verificar que exista el correo cliente "PosWinback"
		And agrega el tipo de resultado "Poswinback"
		And indica una categoria de beneficio principal Engage
		And selecciona un beneficio principal Engage
		And agrega el tipo de resultado "Retenido"
		And agregar observacion "Robot Directv"
		Then valida que se haya registrado el retenido de manera exitosa
		Then verificar estado cliente "Normal"
		And valida el beneficio seleccionado
		And finalizo la sesion del usuario
	@TEST_TACS-994 @TESTSET_TACS-742 @TESTSET_TACS-998 @ENGAGE.UY.POSWINBACKNORETENIDO @ENGAGE.UY.REGRESION @ENGAGE.UY.RETENCIONESPOSWINBACK
	Scenario: ROBOT-TC-ENGAGE-UY-WEB - Retenciones Poswinback - REG - Intencion de Baja - No Retenido
		Given ingresar a Engage web
		When selecciona el perfil PosWinBack
		And ingresar el cliente a procesar Poswinback "Pending Cancellation"
		And seleccionar el proceso PosWinBack
		And verificar que exista el correo cliente "PosWinback"
		And agrega el tipo de resultado "Poswinback"
		And agrega el tipo de resultado "No Retenido"
		And agregar observacion "Robot Directv"
		Then verificar estado cliente "Pending Cancellation"
		And finalizo la sesion del usuario
	@TEST_TACS-995 @TESTSET_TACS-742 @TESTSET_TACS-998 @ENGAGE.UY.POSWINBACKRETENIDO @ENGAGE.UY.REGRESION @ENGAGE.UY.RETENCIONESPOSWINBACK
	Scenario: ROBOT-TC-ENGAGE-UY-WEB - Retenciones Poswinback - REG - Intencion de Baja - Retenido
		Given ingresar a Engage web      
		When selecciona el perfil PosWinBack
		And ingresar el cliente a procesar Poswinback "Pending Cancellation"
		And seleccionar el proceso PosWinBack
		And verificar que exista el correo cliente "PosWinback"
		And agrega el tipo de resultado "Poswinback"
		And agrega el tipo de resultado "Retenido"
		And agregar observacion "Robot Directv"
		Then verificar estado cliente "Normal"
		And finalizo la sesion del usuario
	@TEST_TACS-996 @TESTSET_TACS-742 @TESTSET_TACS-998 @ENGAGE.UY.POSWINBACKRETENIDODOWNGRADEEQUIPOACTIVO @ENGAGE.UY.REGRESION @ENGAGE.UY.RETENCIONESPOSWINBACK
	Scenario: ROBOT-TC-ENGAGE-UY-WEB - Retenciones Poswinback - REG - Intencion de Baja - Retenido - Downgrade
		Given ingresar a Engage web
		When selecciona el perfil PosWinBack
		And ingresar el cliente a procesar Poswinback "Pending Cancellation"
		And seleccionar el proceso PosWinBack "Retenciones Poswinback UY"
		And verificar que exista el correo cliente "PosWinback"
		And agrega el tipo de resultado "Poswinback"
		And registrar producto downgrade poswinback
		And agrega el tipo de resultado "Retenido"
		And agregar observacion "Robot Directv"
		Then verificar estado cliente "Normal"
		And finalizo la sesion del usuario
	@TEST_TACS-997 @TESTSET_TACS-742 @TESTSET_TACS-998 @ENGAGE.UY.POSWINBACKRETENIDOAGREGAPREMIUM @ENGAGE.UY.REGRESION @ENGAGE.UY.RETENCIONESPOSWINBACK
	Scenario: ROBOT-TC-ENGAGE-UY-WEB - Retenciones Poswinback - REG -  Intencion de Baja -  Retenido agrega producto premium 
		Given ingresar a Engage web
		When selecciona el perfil PosWinBack
		And ingresar el cliente a procesar Poswinback "Pending Cancellation"
		And seleccionar el proceso PosWinBack
		And verificar que exista el correo cliente "PosWinback"
		And agrega el tipo de resultado "Poswinback"
		And seleccionar la accion poswinback "A Agregar"
		And seleccionar un producto
		And registrar el nuevo producto
		And agrega el tipo de resultado "Retenido"
		And agregar observacion "Robot Directv"
		And aceptar fecha de terminacion
		Then verificar estado cliente "Normal"
		And finalizo la sesion del usuario
