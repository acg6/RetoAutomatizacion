@REQ_TACS-2278
Feature: ROBOT-HU-ENGAGE-PE - Retenciones PosWinBack

	@TEST_TACS-2043 @TESTSET_TACS-742 @TESTSET_TACS-998 @ENGAGE.PE.POSWINBACKRETENIDOAGREGAPREMIUM @ENGAGE.PE.REGRESION @ENGAGE.PE.RETENCIONESPOSWINBACK
	Scenario: ROBOT-TC-ENGAGE-PE-WEB - Retenciones Poswinback - REG - Intencion de Baja - Retenido agrega producto premium
		Given ingresar a Engage web
		When selecciona el perfil PosWinBack
		And ingresar el cliente a procesar Poswinback "Pending Cancellation"
		And seleccionar el proceso PosWinBack
		And verificar que exista el correo cliente "PosWinback"
		And agrega el tipo de resultado "PosWinBack"
		And seleccionar la accion poswinback "A Agregar"
		And seleccionar un producto
		And registrar el nuevo producto
		And agrega el tipo de resultado "Retenido"
		And agregar observacion "Robot Directv"
		And aceptar fecha de terminacion
		Then verificar estado cliente "Normal"
		And finalizo la sesion del usuario
	@TEST_TACS-2044 @TESTSET_TACS-742 @TESTSET_TACS-998 @ENGAGE.PE.POSWINBACKRETENIDODOWNGRADEEQUIPOACTIVO @ENGAGE.PE.REGRESION @ENGAGE.PE.RETENCIONESPOSWINBACK
	Scenario: ROBOT-TC-ENGAGE-PE-WEB - Retenciones Poswinback - REG - Intencion de Baja - Retenido - Downgrade
		Given ingresar a Engage web
		When selecciona el perfil PosWinBack
		And ingresar el cliente a procesar Poswinback "Pending Cancellation"
		And seleccionar el proceso PosWinBack
		And verificar que exista el correo cliente "PosWinback"
		And agrega el tipo de resultado "PosWinBack"
		And registrar producto downgrade poswinback
		And agrega el tipo de resultado "Retenido"
		And agregar observacion "Robot Directv"
		Then verificar estado cliente "Normal"
		And finalizo la sesion del usuario
	@TEST_TACS-2045 @TESTSET_TACS-742 @TESTSET_TACS-998 @ENGAGE.PE.POSWINBACKRETENIDO @ENGAGE.PE.REGRESION @ENGAGE.PE.RETENCIONESPOSWINBACK
	Scenario: ROBOT-TC-ENGAGE-PE-WEB - Retenciones Poswinback - REG - Intencion de Baja - Retenido
		Given ingresar a Engage web      
		When selecciona el perfil PosWinBack
		And ingresar el cliente a procesar Poswinback "Pending Cancellation"
		And seleccionar el proceso PosWinBack
		And verificar que exista el correo cliente "PosWinback"
		And agrega el tipo de resultado "PosWinBack"
		And agrega el tipo de resultado "Retenido"
		And agregar observacion "Robot Directv"
		Then verificar estado cliente "Normal"
		And finalizo la sesion del usuario
	@TEST_TACS-2046 @TESTSET_TACS-742 @TESTSET_TACS-998 @ENGAGE.PE.POSWINBACKNORETENIDO @ENGAGE.PE.REGRESION @ENGAGE.PE.RETENCIONESPOSWINBACK
	Scenario: ROBOT-TC-ENGAGE-PE-WEB - Retenciones Poswinback - REG - Intencion de Baja - No Retenido
		Given ingresar a Engage web
		When selecciona el perfil PosWinBack
		And ingresar el cliente a procesar Poswinback "Pending Cancellation"
		And seleccionar el proceso PosWinBack
		And verificar que exista el correo cliente "PosWinback"
		And agrega el tipo de resultado "PosWinBack"
		And agrega el tipo de resultado "No Retenido"
		And agregar observacion "Robot Directv"
		Then verificar estado cliente "Pending Cancellation"
		And finalizo la sesion del usuario
	@TEST_TACS-2047 @TESTSET_TACS-742 @TESTSET_TACS-998 @ENGAGE.PE.POSWINBACKRETENIDOBENEFICIO @ENGAGE.PE.REGRESION @ENGAGE.PE.RETENCIONESPOSWINBACK
	Scenario: ROBOT-TC-ENGAGE-PE-WEB - Retenciones Poswinback - REG - Intencion de Baja - Retenido con beneficio
		Given ingresar a Engage web
		When selecciona el perfil PosWinBack
		And ingresar el cliente a procesar Poswinback "Pending Cancellation"
		And seleccionar el proceso PosWinBack
		And verificar que exista el correo cliente "PosWinback"
		And agrega el tipo de resultado "PosWinBack"
		And indica una categoria de beneficio principal Engage
		And selecciona un beneficio principal Engage
		And agrega el tipo de resultado "Retenido"
		And agregar observacion "Robot Directv"
		Then valida que se haya registrado el retenido de manera exitosa
		Then verificar estado cliente "Normal"
		And valida el beneficio seleccionado
		And finalizo la sesion del usuario
