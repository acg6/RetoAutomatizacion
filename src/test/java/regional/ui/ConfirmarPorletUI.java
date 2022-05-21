package regional.ui;

import org.openqa.selenium.By;

public class ConfirmarPorletUI {
	
	
	
    private static final By BTN_SI_CONFIRMACION = By.xpath("//div[contains(@class,'mat-dialog-action')]//button[contains(@class,'ok')]");	

	
	private ConfirmarPorletUI() {
	    
	  }
	

	public static By getBtnSiConfirmacion() {
		return BTN_SI_CONFIRMACION;
	}
}
