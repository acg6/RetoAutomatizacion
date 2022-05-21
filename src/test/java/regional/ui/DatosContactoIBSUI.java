package regional.ui;

import org.openqa.selenium.By;

public class DatosContactoIBSUI {
	
	private DatosContactoIBSUI() {}

	private static final By SELECT_SEGUNDA_CATEGORIA = By.xpath("//select[contains(@name,'CALL.SUBREASON_RES:ctl')]");

	public static By getSelectSegundaCategoria() {
		return SELECT_SEGUNDA_CATEGORIA;
	}


}
