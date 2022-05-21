@REQ_TACS-2277
Feature: ROBOT-HU-ENGAGE-PE - Retenciones WinBack

	@TEST_TACS-2054 @TESTSET_TACS-733 @TESTSET_TACS-742 @ENGAGE.PE.REGRESION @ENGAGE.PE.RETENCIONESWINBACK @ENGAGE.PE.WINBACKRETENIDODOWNGRADEEQUIPOACTIVO
	Scenario: ROBOT-TC-ENGAGE-PE-WEB - Retenciones Winback - REG - Intencion de Baja - Retenido - Downgrade - Equipo Activo
		Given ingresar a Engage web
		When seleccionar perfil retenciones Inbound
		And seleccionar el cliente a procesar "Normal"
		And verificar que exista el correo cliente "Winback"
		And seleccionar clase de retencion Inbound
		And agrega un submotivo de intencion baja
		And agrega el tipo de resultado "No Retenido"
		And agregar observacion "Cliente No Retenido Winback"
		And aceptar fecha de terminacion
		Then finalizo la sesion del usuario
		  
		Given ingresar a Engage web
		When seleccionar perfil retenciones Winback
		And seleccionar el cliente a procesar "Pending"
		And seleccionar clase de retencion Outbound
		And agrega producto activo
		And seleccionar la accion "Downgrade"
		And seleccionar un producto
		And registrar el nuevo producto
		And agrega el tipo de resultado "Retenido"
		And agregar observacion "RETENIDO Downgrade Winback"
		Then verificar estado cliente "Normal"
		And finalizo la sesion del usuario
	@TEST_TACS-2053 @TESTSET_TACS-733 @TESTSET_TACS-742 @ENGAGE.PE.REGRESION @ENGAGE.PE.RETENCIONESWINBACK @ENGAGE.PE.WINBACKRETENIDO
	Scenario: ROBOT-TC-ENGAGE-PE-WEB - Retenciones Winback - REG - Intencion de Baja - Retenido
		Given ingresar a Engage web
		When seleccionar perfil retenciones Inbound
		And seleccionar el cliente a procesar "Normal"
		And verificar que exista el correo cliente "Winback"
		And seleccionar clase de retencion Inbound
		And agrega un submotivo de intencion baja
		And agrega el tipo de resultado "No Retenido"
		And agregar observacion "Cliente No Retenido Inbound"
		And aceptar fecha de terminacion
		Then finalizo la sesion del usuario
		    
		Given  ingresar a Engage web
		When seleccionar perfil retenciones Winback
		And seleccionar el cliente a procesar "Pending"
		And seleccionar clase de retencion Outbound
		And agrega producto activo
		And seleccionar la accion "Downgrade"
		And seleccionar un producto
		And agrega el tipo de resultado "Retenido"
		And agregar observacion "RETENIDO Winback"
		Then valida que se haya registrado el retenido de manera exitosa
		And  verificar estado cliente "Normal"
	@TEST_TACS-2052 @TESTSET_TACS-733 @TESTSET_TACS-742 @ENGAGE.PE.REGRESION @ENGAGE.PE.RETENCIONESWINBACK @ENGAGE.PE.WINBACKNORETENIDO
	Scenario: ROBOT-TC-ENGAGE-PE-WEB - Retenciones Winback - REG - Intencion de Baja - No Retenido
		Given ingresar a Engage web
		When seleccionar perfil retenciones Inbound
		And seleccionar el cliente a procesar "Normal"
		And verificar que exista el correo cliente "Winback"
		And seleccionar clase de retencion Inbound
		And agrega un submotivo de intencion baja
		And agrega el tipo de resultado "No Retenido"
		And agregar observacion "Cliente No Retenido Inbound"
		And aceptar fecha de terminacion
		Then finalizo la sesion del usuario
		    
		Given ingresar a Engage web
		When seleccionar perfil retenciones Winback
		And seleccionar el cliente a procesar "Pending"
		And seleccionar clase de retencion Outbound
		And agrega el tipo de resultado "No Retenido"
		And agregar observacion "Cliente no retenido Winback"
		Then valida que se haya registrado el retenido de manera exitosa
		And  verificar estado cliente "Pending"
	@TEST_TACS-2051 @TESTSET_TACS-733 @TESTSET_TACS-742 @ENGAGE.PE.REGRESION @ENGAGE.PE.RETENCIONESWINBACK @ENGAGE.PE.WINBACKRETENIDOBENEFICIO
	Scenario: ROBOT-TC-ENGAGE-PE-WEB - Retenciones Winback - REG - Intencion de Baja - Retenido con beneficio
		Given ingresar a Engage web
		When seleccionar perfil retenciones Inbound
		And seleccionar el cliente a procesar "Normal"
		And verificar que exista el correo cliente "Winback"
		And seleccionar clase de retencion Inbound
		And agrega un submotivo de intencion baja
		And agrega el tipo de resultado "No Retenido"
		And agregar observacion "Cliente No Retenido Inbound"
		And aceptar fecha de terminacion
		Then finalizo la sesion del usuario
		       
		Given ingresar a Engage web
		When seleccionar perfil retenciones Winback
		And seleccionar el cliente a procesar "Pending"
		And seleccionar clase de retencion Outbound
		And indica categoria de beneficio principal
		And seleccionar un beneficio principal
		And agrega el tipo de resultado "Retenido"
		And agregar observacion "Retenido con beneficio"
		Then valida que se haya registrado el retenido de manera exitosa
		And  verificar estado cliente "Normal"
	@TEST_TACS-2050 @TESTSET_TACS-733 @TESTSET_TACS-742 @ENGAGE.PE.REGRESION @ENGAGE.PE.RETENCIONESPOSWINBACK @ENGAGE.PE.WINBACKAGREGARPRODUCTORETENIDO
	Scenario: ROBOT-TC-ENGAGE-PE-WEB - Retenciones WinBack - REG - Retenido - Agregar Producto
		Given ingresar a Engage web
		When seleccionar perfil retenciones Inbound
		And seleccionar el cliente a procesar "Normal"
		And verificar que exista el correo cliente "Winback"
		And seleccionar clase de retencion Inbound
		And agrega un submotivo de intencion baja
		And agrega el tipo de resultado "No Retenido"
		And agregar observacion ""
		And aceptar fecha de terminacion
		And aceptar fecha de terminacion
		Then verificar estado cliente "Pending"
		And finalizo la sesion del usuario
		And iniciar la sesion del usuario
		When seleccionar perfil retenciones Winback
		And seleccionar el cliente a procesar "Pending"
		And seleccionar clase de retencion Outbound
		And seleccionar la accion "A Agregar"
		And seleccionar un producto
		And registrar el nuevo producto
		And agrega el tipo de resultado "Retenido"
		And agregar observacion "Robot Directv"
		Then valida que se haya registrado el retenido de manera exitosa
