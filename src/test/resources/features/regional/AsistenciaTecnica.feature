@REQ_TACS-739
Feature: ROBOT-HU-ENGAGE - Asistencia Tecnica

	#@TEST_TACS-627 @TESTSET_TACS-734 @TESTSET_TACS-742 @ENGAGE.REG.ASISTENCIATECNICA @ENGAGE.REG.REAGENDARASISTENCIATECNICACITAONLINE @ENGAGE.REG.REGRESION
	Scenario: ROBOT-TC-ENGAGE-WEB - Asistencia Tecnica - REG - Reagendar una Asistencia Tecnica con Cita Online - Flujo Basico
    Given ingresar a Engage web
    When selecciona el perfil "TST Uruguay"
    And ingresar el cliente a procesar

  #@TEST_TACS-628 @TESTSET_TACS-734 @TESTSET_TACS-742 @ENGAGE.REG.ASISTENCIATECNICA @ENGAGE.REG.REGRESION @ENGAGE.REG.TSTENVIOCR
	Scenario: ROBOT-TC-ENGAGE-WEB - Asistencia Tecnica - REG - TST Envio de C
    Given ingresar a Engage web
    When selecciona el perfil "TST Uruguay"
    And ingresar el cliente a procesar
    And selecciona el proceso "Informacion del Cliente"
    And diligencia la razon de envio de control remoto
    And tramita envio de control remoto

  #@TEST_TACS-629 @TESTSET_TACS-734 @TESTSET_TACS-742 @ENGAGE.REG.ASISTENCIATECNICA @ENGAGE.REG.REGRESION @ENGAGE.REG.TSTGENERACIONWOCURRIER
	Scenario: ROBOT-TC-ENGAGE-WEB - Asistencia Tecnica - REG - TST - Realizar una asistencia tecnica con generacion de WO (currier)
    Given ingresar a Engage web
    When selecciona el perfil "TST Uruguay"
    And ingresar el cliente a procesar
    And selecciona el proceso "Informacion del Cliente"
    And diligencia envios ird
    And tramita envios ird
