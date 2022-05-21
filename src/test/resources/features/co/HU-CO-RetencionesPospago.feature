@REQ_TACS-3101
Feature: ROBOT-HU-ENGAGE-CO - Retenciones Inbound

	@TEST_TACS-3103 @TESTSET_TACS-3102 @TESTSET_TACS-3105 @ENGAGE.CO.REGRESION @ENGAGE.CO.RETENCIONCOLOMBIA @ENGAGE.CO.RETENCIONCOLOMBIATVCONBENEFICIO
	Scenario: ROBOT-TC-ENGAGE-CO-WEB- Cliente  TV -  TV se encuentra Activo  - Retenido TV  con beneficio
		Given ingresar a Engage web
		When seleccionar perfil retenciones Pospago
		And seleccionar el cliente Pospago "Normal" proceso "Retenciones"
		And valida que el resultado sea intencion baja
		And agrega un submotivo de intencion baja
		And seleccionar la accion agregar beneficio
		And indica la categoria en IBS "001-Disculpa/Situación Corregida"
		And agregar observacion "Robot Directv"
		Then verificar estado cliente "Normal"
		And finalizo la sesion del usuario
		
	@TEST_TACS-3532 @TESTSET_TACS-3102 @TESTSET_TACS-3105 @ENGAGE.CO.REGRESION @ENGAGE.CO.RETENCIONCOLOMBIA
	Scenario: ROBOT-TC-ENGAGE-CO-WEB- Cliente  NET - NET Cancelado - Retenido NET
		Given ingresar a Engage web
		When seleccionar perfil retenciones Pospago
		And seleccionar el cliente Pospago Net Cancelado "Normal" proceso "Retenciones"
		And valida que el producto este en estado "C - Cancelado"
		And valida que el resultado sea intencion baja
		And agrega un submotivo de intencion baja Net
		And indica la categoria en IBS "002-Cambio de Opinión"
		And agregar observacion "Dcto: $- / F.S/D: $ / F.C/D: $ / In Off: /Fin Off: / Fac.Pend: $ / Lim Pag:Retenido Net"
		Then verificar estado cliente "Normal"
		And finalizo la sesion del usuario
	@TEST_TACS-3530 @TESTSET_TACS-3102 @TESTSET_TACS-3105 @ENGAGE.CO.REGRESION @ENGAGE.CO.RETENCIONCOLOMBIA
	Scenario: ROBOT-TC-ENGAGE-CO-WEB- Cliente BUNDLE NET y TV-  NET y TV  Activo  - No Retenido
		Given ingresar a Engage web
		When seleccionar perfil retenciones Pospago
		And seleccionar el cliente Pospago Bundle "Normal" proceso "Retenciones"
		And valida que el resultado sea intencion baja
		And agrega un submotivo de intencion baja Bundle
		And agrega el tipo de resultado "No Retenido"
		And indica la cuarta categoria en IBS
		And agregar observacion con "Robot No Retinido Nro 1"
		And indica la cuarta categoria en IBS
		And agregar observacion con "Robot No Retinido Nro 2"
		And seleccionar fecha de baja
		Then verificar estado cliente "Normal"
		And finalizo la sesion del usuario
	@TEST_TACS-3531 @TESTSET_TACS-3102 @TESTSET_TACS-3105 @ENGAGE.CO.REGRESION @ENGAGE.CO.RETENCIONCOLOMBIA
	Scenario: ROBOT-TC-ENGAGE-CO-WEB- Cliente  NET -  NET se encuentra Activo  - No Retenido
		Given ingresar a Engage web
		When seleccionar perfil retenciones Pospago
		And seleccionar el cliente Pospago Net "Normal" proceso "Retenciones"
		And valida que el resultado sea intencion baja
		And agrega un motivo de intencion baja Net
		And agrega el tipo de resultado "No Retenido"
		And indica la cuarta categoria en IBS
		And agregar observacion con "Robot Directv"
		And seleccionar fecha de baja
		Then verificar estado cliente "Normal"
		And finalizo la sesion del usuario
	@TEST_TACS-3762 @TESTSET_TACS-3102 @TESTSET_TACS-3105 @ENGAGE.CO.CLIENTETVACTIVONORETENIDO @ENGAGE.CO.REGRESION @ENGAGE.CO.RETENCIONCOLOMBIA
	Scenario: ROBOT-TC-ENGAGE-CO-Cliente Tv-TV Se Encuentra activo-No retenido
		Given ingresar a Engage web
		When seleccionar perfil retenciones Pospago
		And seleccionar el cliente Pospago "Normal" proceso "Retenciones"
		And valida que el resultado sea intencion baja
		And agregar un submotivo de intencion baja
		And agrega el tipo de resultado "No Retenido"
		And indica la categoria en IBS "001-ECON-Problemas económicos"
		And agregar observacion con "Robot Directv"
		And seleccionar fecha de baja
		Then verificar estado cliente "Normal"
		And finalizo la sesion del usuario


 @TEST_TACS-3961 @TESTSET_TACS-3102 @TESTSET_TACS-3105 @ENGAGE.CO.CLIENTETVACTIVONORETENIDO @ENGAGE.CO.REGRESION
	Scenario: ROBOT-TC-ENGAGE-CO-Cliente solo con servicio NET - Con Baja Programada- Retenido NET
		Given ingresar a Engage web
		When seleccionar perfil retenciones Pospago
		And seleccionar el cliente Pospago Net "Normal" proceso "Retenciones"
		And valida que el resultado sea intencion baja
		And agregar un submotivo de intencion baja
		And agrega el tipo de resultado "Retenido NET"
		And indica la categoria en IBS "002-Cambio de Opinión"
		And agregar observacion "Dcto: $- / F.S/D: $ / F.C/D: $ / In Off: /Fin Off: / Fac.Pend: $ / Lim Pag: Automatización NET Baja programada Retenido NET"
		Then verificar estado cliente "Normal"
		And finalizo la sesion del usuario


 @TEST_TACS-3962 @TESTSET_TACS-3102 @TESTSET_TACS-3105 @ENGAGE.CO.CLIENTETVACTIVONORETENIDO @ENGAGE.CO.REGRESION @ENGAGE.CO.RETENCIONCOLOMBIA
	Scenario: ROBOT-TC-ENGAGE-CO-Cliente BUNDLE NET y TV- NET y TV Activo - Retenido NET
		Given ingresar a Engage web
		When seleccionar perfil retenciones Pospago
		And seleccionar el cliente Pospago Bundle "Normal" proceso "Retenciones"
		And valida que el resultado sea intencion baja
		And agrega un motivo de intencion baja Net
		And agrega categoria y beneficio
		And agrega el tipo de resultado "Retenido NET"
		And indica la categoria en IBS "002-Cambio de Opinión"
		And indica la categoria en IBS "002-ECON-Motivos Personales"
		And seleccionar fecha de baja
		Then verificar estado cliente "Normal"
		And finalizo la sesion del usuario

 @TEST_TACS-3963 @TESTSET_TACS-3102 @TESTSET_TACS-3105 @ENGAGE.CO.CLIENTETVACTIVONORETENIDO @ENGAGE.CO.REGRESION
	Scenario: ROBOT-TC-ENGAGE-CO-Cliente BUNDLE NET y TV- NET y TV Activo - Retenido TV
		Given ingresar a Engage web
		When seleccionar perfil retenciones Pospago
		And seleccionar el cliente Pospago Bundle "Normal" proceso "Retenciones"
		And valida que el resultado sea intencion baja
		And agrega motivo de intencion baja para Retenido TV 
		And agrega categoria y beneficio
		And agrega el tipo de resultado "Retenido TV"
		And indica la categoria en IBS "003-Argumentos de Compañía/Producto"
		And indica la cuarta subcategoria en IBS
		And seleccionar fecha de baja
		Then verificar estado cliente "Normal"
		And finalizo la sesion del usuario