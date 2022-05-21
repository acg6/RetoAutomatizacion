package regional.ui;

import org.openqa.selenium.By;

public class PortletUI {

	private static final  By LBL_PORLET = By.xpath("//h4[contains(text(),'Portlet')]");
	private static final  By INPUT_DIRECCION_PORLET = By.xpath("(//input[contains(text(),'')])[1]");
	private static final  By BTN_BUSCAR_DIRECCION_PORLET = By.xpath("//div/*[contains(@class,'search-button')]");
	private static final  By SPAN_DIRECCION_ELEGIDA_PRIMERA = By.xpath("//div[contains(@class,'mat-autocomplete-panel')]//mat-option[contains(@id,'mat-option')]");
	private static final  By SPAN_DIRECCION_ELEGIDA_ULTIMA = By.xpath("//div[contains(@class,'mat-autocomplete-panel')]//mat-option[last()]");
	private static final  By INPUT_INFO_ADICIONAL = By.xpath("//textarea[contains(@name,'additionalData')]");
	private static final  By INPUT_CALLE_ADICIONAL = By.xpath("//input[contains(@name,'betweenStreet2')]");
	private static final  By BTN_CONTINUAR_PORLET = By.xpath("//button[contains(@mattooltip,'Continuar')]");
	private static final  By BTN_CANCELAR_PORLET = By.xpath("//button[contains(@mattooltip,'Cancelar')]");
	private static final  By CHK_SIN_NUMERO = By.xpath("(//mat-checkbox[contains(@id,'mat-checkbox-1')]//label//div)[1]");
	private static final  By BTN_CONFIRMAR = By.xpath("//*[@id='mat-select-0']/div/div[2]");

	
	private PortletUI() {
	    
	}

	public static By getLblPorlet() {
		return LBL_PORLET;
	}
	public static By getInputDireccionPorlet() {
		return INPUT_DIRECCION_PORLET;
	}
	public static By getBtnBuscarDireccionPorlet() {
		return BTN_BUSCAR_DIRECCION_PORLET;
	}
	public static By getSpanDireccionElegidaPrimera() {
		return SPAN_DIRECCION_ELEGIDA_PRIMERA;
	}
	public static By getSpanDireccionElegidaUltima() {
		return SPAN_DIRECCION_ELEGIDA_ULTIMA;
	}
	
	public static By getInputInfoAdicional() {
		return INPUT_INFO_ADICIONAL;
	}
	
	public static By getInputCalleAdicional() {
		return INPUT_CALLE_ADICIONAL;
	}
	
	public static By getBtnContinuarPorlet() {
		return BTN_CONTINUAR_PORLET;
	}
	public static By getBtnCancelarPorlet() {
		return BTN_CANCELAR_PORLET;
	}
	
	public static By getConfirmar() {
		return BTN_CONFIRMAR;
	}
	
	public static By getChkSinNumero() {
		return CHK_SIN_NUMERO;
	}
	
}
