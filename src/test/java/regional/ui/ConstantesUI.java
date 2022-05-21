package regional.ui;

import org.openqa.selenium.By;

public class ConstantesUI {
	
	private ConstantesUI() {}
	
	private static final By DIV_CARGANDOTRAMITE_ = By.xpath("//div[@id='ralpActivitydivActivity']/div[1]/div");
	private static final By DIV_CARGANDOPROCESO = By.xpath("//div[@id='ralpActivitydivActivity']//div[@class='LoadingImage']");
	private static final By DIV_CARGANDO = By.xpath("(//div[contains(@id,'ralp')][not(contains(@style, 'none'))])[1]");
	private static final By DIV_CARGANDO_SELECCIONAR_CLIENTE =  By.xpath("//div[contains(@id,'ralpCustomersgrdCustomers')]/div[1]/div");
	
	public static By getDivCargando() {
		return DIV_CARGANDO;
	}
	
	public static By getDivCargandoSeleccionarCliente() {
		return DIV_CARGANDO_SELECCIONAR_CLIENTE;
	}

	public static By getDivCargandoproceso() {
		return DIV_CARGANDOPROCESO;
	}

	public static By getDivCargandotramite() {
		return DIV_CARGANDOTRAMITE_;
	}
	
}
