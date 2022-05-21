package regional.ui;

import org.openqa.selenium.By;

public class PerfilUI {
	
	private PerfilUI() {}

	private static final By INPUT_PERFIL = By.xpath("//input[contains(@id,'cmbUnits_Input')]");
	private static final By BUTTON_ACEPTAR = By.xpath("//input[contains(@id,'imgEntrar')]");

	public static By getInputPerfil() {
		return INPUT_PERFIL;
	}

	public static By getButtonAceptar() {
		return BUTTON_ACEPTAR;
	}
	
}
