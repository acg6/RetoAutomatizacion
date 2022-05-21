package regional.ui;

import org.openqa.selenium.By;

public class ResultadoDeGestionUI {
	
	private ResultadoDeGestionUI() {}

	private static final By BUTTON_ACEPTA = By.xpath("(//div//input[contains(@onclick,'ACEPTA')]//following-sibling::label)[1]");
	private static final By BUTTON_NO_ACEPTA = By.xpath("(//div//input[contains(@onclick,'ACEPTA')]//following-sibling::label)[2]");
	private static final By BUTTON_RELLAMAR = By.xpath("(//div//input[contains(@onclick,'ACEPTA')]//following-sibling::label)[3]");
	private static final By BUTTON_RETIRAR_GESTION = By.xpath("(//div//input[contains(@onclick,'ACEPTA')]//following-sibling::label)[4]");
	private static final By FINALIZAR = By.xpath("//img[contains(@onclick,'validarKW()')] "); 
	
	
	public static By getButtonAcepta() {
		return BUTTON_ACEPTA;
	}
	
	public static By getButtonNoAcepta() {
		return BUTTON_NO_ACEPTA;
	}
	
	public static By getButtonRellamar() {
		return BUTTON_RELLAMAR;
	}
	
	public static By getButtonRetirarGestion() {
		return BUTTON_RETIRAR_GESTION;
	}
	
	public static By getButtonFinalizar() {
		return FINALIZAR;
	}


}
