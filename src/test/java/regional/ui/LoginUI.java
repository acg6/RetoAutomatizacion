package regional.ui;

import org.openqa.selenium.By;

public class LoginUI {
	
	private LoginUI() {}

	private static final By INPUT_USUARIO = By.xpath("//input[contains(@id,'lgnLogin_UserName')]");
	private static final By INPUT_CONTRASENA = By.xpath("//input[contains(@id,'lgnLogin_Password')]");
	private static final By BUTTON_LOGIN = By.xpath("//input[contains(@id,'lgnLogin_LoginImageButton')]");
	private static final By OVER_LAY_LOGIN = By.xpath("(//div[@class='LoadingImage'])[1]");
	private static final By BUTTON_RELOGIN = By.xpath("//input[contains(@id,'imgEntrar')]");
	private static final By LBL_INICIO_SESION = By.xpath("//td[contains(@class, 'logintitle') and contains(text(), 'Iniciar Sesión:')]");

	public static By getInputUsuario() {
		return INPUT_USUARIO;
	}
	
	public static By getInputContrasena() {
		return INPUT_CONTRASENA;
	}

	public static By getButtonLogin() {
		return BUTTON_LOGIN;
	}

	public static By getOverLayLogin() {
		return OVER_LAY_LOGIN;
	}
	
	public static By getButtonRelogin() {
		return BUTTON_RELOGIN;
	}

	public static By getLblInicioSesion() {
		return LBL_INICIO_SESION;
	}
}
