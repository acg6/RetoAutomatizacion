@REQ_TACS-737
Feature: ROBOT-HU-ENGAGE-UY - Retenciones Inbound

	@TEST_TACS-622 @TESTSET_TACS-732 @TESTSET_TACS-742 @ENGAGE.UY.INTENCIONBAJARETENIDOBENEFICIO @ENGAGE.UY.REGRESION @ENGAGE.UY.RETENCIONESINBOUND
	Scenario: ROBOT-TC-ENGAGE-UY-WEB - Retenciones Inbound - REG -  Intencion de Baja -  Retenido con beneficio 
		Given ingresar a Engage web
		When seleccionar perfil retenciones Inbound
		And seleccionar el cliente a procesar "Normal"
		And verificar que exista el correo cliente "Inbound"
		And valida que el resultado sea intencion baja
		When agrega un submotivo de intencion baja
		And indica una categoria de beneficio principal Engage
		And selecciona un beneficio principal Engage
		And agrega el tipo de resultado "Retenido"
		When indica una categoria en IBS
		And agregar observacion "Robot Directv"
		Then valida que se haya registrado el retenido de manera exitosa
		And verificar estado cliente "Normal"
		And valida el beneficio seleccionado
		And finalizo la sesion del usuario
	@TEST_TACS-623 @TESTSET_TACS-732 @TESTSET_TACS-742 @ENGAGE.UY.INTENCIONBAJANORETENIDO @ENGAGE.UY.REGRESION @ENGAGE.UY.RETENCIONESINBOUND
	Scenario: ROBOT-TC-ENGAGE-UY-WEB - Retenciones Inbound - REG - Intencion de Baja - No Retenido
		Given ingresar a Engage web
		When seleccionar perfil retenciones Inbound
		And seleccionar el cliente a procesar "Normal"
		And verificar que exista el correo cliente "Inbound"
		And seleccionar clase de retencion Inbound
		And agrega un submotivo de intencion baja
		And agrega el tipo de resultado "No Retenido"
		And agregar observacion "Intencion de Baja - No Retenido"
		And aceptar fecha de terminacion
		Then verificar estado cliente "Pending"
		And finalizo la sesion del usuario
	@TEST_TACS-624 @TESTSET_TACS-732 @TESTSET_TACS-742 @ENGAGE.UY.INTENCIONBAJARETENIDO @ENGAGE.UY.REGRESION @ENGAGE.UY.RETENCIONESINBOUND
	Scenario: ROBOT-TC-ENGAGE-UY-WEB - Retenciones Inbound - REG - Intencion de Baja - Retenido
		Given ingresar a Engage web
		When seleccionar perfil retenciones Inbound
		And seleccionar el cliente a procesar "Normal"
		And seleccionar clase de retencion Inbound
		And agrega un submotivo de intencion baja
		And agrega el tipo de resultado "Retenido"
		And adicionar segunda categoria
		And agregar observacion "Intencion de Baja - Retenido"
		Then valida que se haya registrado el retenido de manera exitosa
		And verificar estado cliente "Normal"
		And finalizo la sesion del usuario
	@TEST_TACS-625 @TESTSET_TACS-732 @TESTSET_TACS-742 @ENGAGE.UY.INTENCIONBAJARETENIDODOWNGRADEEQUIPOACTIVO @ENGAGE.UY.REGRESION @ENGAGE.UY.RETENCIONESINBOUND
	Scenario: ROBOT-TC-ENGAGE-UY-WEB - Retenciones Inbound - REG - Intencion de Baja - Retenido - Downgrade - Equipo Activo
		Given ingresar a Engage web
		When seleccionar perfil retenciones Inbound
		And seleccionar el cliente a procesar "Normal"
		And valida que el resultado sea intencion baja
		When agrega un submotivo de intencion baja
		And agrega producto activo
		And seleccionar la accion "Downgrade"
		And seleccionar un producto
		And registrar el nuevo producto
		And agrega el tipo de resultado "Retenido"
		And indica una categoria en IBS
		And agregar observacion "Retenido - Downgrade"
		Then valida que se haya registrado el retenido de manera exitosa
		And verificar estado cliente "Normal"
		And finalizo la sesion del usuario
	@TEST_TACS-986 @TESTSET_TACS-732 @TESTSET_TACS-742 @ENGAGE.UY.INTENCIONBAJARETENIDOAGREGAPREMIUM @ENGAGE.UY.REGRESION @ENGAGE.UY.RETENCIONESINBOUND
	Scenario: ROBOT-TC-ENGAGE-UY-WEB - Retenciones Inbound - REG -  Intencion de Baja -  Retenido agrega producto premium 
		Given ingresar a Engage web
		When seleccionar perfil retenciones Inbound
		And seleccionar el cliente a procesar "Normal"
		And valida que el resultado sea intencion baja
		And agrega un submotivo de intencion baja
		And seleccionar la accion "A Agregar"
		And seleccionar un producto
		And registrar el nuevo producto
		And agrega el tipo de resultado "Retenido"
		And indica la septima categoria en IBS
		And agregar observacion "Retenido agregando producto."
		Then valida que se haya registrado el retenido de manera exitosa
		And verificar estado cliente "Normal"
		And finalizo la sesion del usuario
	@TEST_TACS-1943 @TESTSET_TACS-732 @TESTSET_TACS-742 @ENGAGE.UY.INTENCIONBAJARETENIDOCANCELARPRODUCTO @ENGAGE.UY.REGRESION @ENGAGE.UY.RETENCIONESINBOUND
	Scenario: ROBOT-TC-ENGAGE-UY-WEB - Retenciones Inbound - Intencion de Baja - Retenido - Cancelar Producto
		Given ingresar a Engage web
		When seleccionar perfil retenciones Inbound
		And seleccionar el cliente a procesar "Normal"
		And valida que el resultado sea intencion baja
		And agrega un submotivo de intencion baja
		And seleccionar producto a cancelar inbound
		And seleccionar la accion "A Cancelar"
		And registrar el nuevo producto
		And agrega el tipo de resultado "Retenido"
		And indica la septima categoria en IBS
		And agregar observacion "Retenido producto cancelado."
		Then verificar producto cancelado
		And finalizo la sesion del usuario
