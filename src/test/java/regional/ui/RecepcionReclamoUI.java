package regional.ui;

import org.openqa.selenium.By;

public class RecepcionReclamoUI {
	
	private RecepcionReclamoUI() {}
	
	private static final By BUTTON_SOLUCIONAR = By.xpath("//img[contains(@id, 'dtv_solu')]");
	private static final By BUTTON_DERIVAR = By.xpath("//img[contains(@id, 'dtv_deri')]");

	public static By getButtonDerivar() {
		return BUTTON_DERIVAR;
	}

	public static By getButtonSolucionar() {
		return BUTTON_SOLUCIONAR;
	}

}
