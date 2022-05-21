package regional.ui;

import org.openqa.selenium.By;

public class AgendaCitaUI {
	
	private AgendaCitaUI() {}

	private static final By BUTTON_GENERAR_CITA = By.xpath("//img[contains(@id,'generar_cita')]");

	public static By getButtonGenerarCita() {
		return BUTTON_GENERAR_CITA;
	}
	
}
