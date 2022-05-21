package regional.ui;

import org.openqa.selenium.By;

public class LogoutUI {
	
	private LogoutUI() {}

	private static final By BUTTON_LOGOUT = By.xpath("//span[contains(text(),'Salir')]");
	private static final By BUTTON_TERMINAR_PROCESO = By.xpath("//span[contains(text(), 'OK') and contains(@class, 'rwInnerSpan')][1]");

	public static By getButtonLogout() {
		return BUTTON_LOGOUT;
	}

	public static By getButtonTerminarProceso() {
		return BUTTON_TERMINAR_PROCESO;
	}
}
