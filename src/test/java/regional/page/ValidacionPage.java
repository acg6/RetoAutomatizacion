package regional.page;

import org.openqa.selenium.By;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://serenity.is/demo/Account/Login/?ReturnUrl=%2Fdemo%2F")

public class ValidacionPage extends PageObject {

	
	private static By strOPCIONMENUNELEGIDA = By.xpath("//li[@id=\"menu-item-282\"]");
	private static By strINPUTNOMBRE = By.xpath("//input[@id=\"form-field-nombre\"]");
	private static By strWHATSAPP = By.xpath("//input[@id=\"form-field-field_fb71456\"]");
	private static By strCORREO = By.xpath("//input[@id=\"form-field-email\"]");
	private static By strCIUDAD = By.xpath("//input[@id=\"form-field-field_c3f91b8\"]");
	private static By strEMPRESA = By.xpath("//input[@id=\"form-field-empresa\"]");
	private static By strINTERES = By.xpath("//select[@id=\"form-field-Tipodeservicio\"]");
	private static By strMENSAJE = By.xpath("//textarea[@id=\"form-field-message\"]");
	private static By btnEnviar = By.xpath("//*[@id=\"content\"]/div/div/div/div/div/section[3]/div/div/div/div/div/div/div/form/div/div[8]/button");
	private static By lblMensaje = By.xpath("//*[@id=\"content\"]/div/div/div/div/div/section[3]/div/div/div/div/div/div/div/form/div[2]/text()");
	private static By MenuServicios = By.xpath("//li[@id=\"menu-item-6142\"]");
	private static By MenuIndustrias = By.xpath("//li[@id=\"menu-item-870\"]");
	private static By MenuFormacion = By.xpath("//li[@id=\"menu-item-1876\"]");
	private static By MenuComunidad = By.xpath("//li[@id=\"menu-item-7979\"]");
	private static By MenuEmpleos = By.xpath("//li[@id=\"menu-item-7979\"]");



	public static By getStrOpcionElegida() {
		return strOPCIONMENUNELEGIDA;
	}
	
	public static By getMenuServicios() {
		return MenuServicios;
	}
	
	public static By getMenuIndustrias() {
		return MenuIndustrias;
	}
	
	public static By getMenuComunidad() {
		return MenuComunidad;
	}
	
	public static By getMeneFormacion() {
		return MenuFormacion;
	}
	
	public static By getMenuEmpleo() {
		return MenuEmpleos;
	}
	
	
	public static By getStrInputNombre() {
		return strINPUTNOMBRE;
	}
	
	public static By getStrWhatsapp() {
		return strWHATSAPP;
	}
	
	public static By getStrCorreo() {
		return strCORREO;
	}
	
	public static By getStrCiudad() {
		return strCIUDAD;
	}
	
	public static By getStrEmpresa() {
		return strEMPRESA;
	}
	
	public static By getStrInteres() {
		return strINTERES;
	}
	
	public static By getStrMensaje() {
		return strMENSAJE;
	}
	
	public static By getBtnEnviar() {
		return btnEnviar;
	}
	
	public static By getLblMensaje() {
		return lblMensaje;
	}
	
}
