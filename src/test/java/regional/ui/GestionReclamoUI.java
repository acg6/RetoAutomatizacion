package regional.ui;

import org.openqa.selenium.By;

public class GestionReclamoUI {
	
	private GestionReclamoUI() {}

	private static final By TXT_DESCRIPCION = By.xpath("//textarea[contains(@name, 'SYS_DESC_RESOL:ctl')]");
	private static final By BTN_FINALIZAR = By.xpath("//img[contains(@id, 'dtv_nvo_fin') and contains(@name, 'dtv_nvo_fin')]");
	private static final By BTN_FINALIZR_CORPORATIVO = By.xpath("//p[contains(text(),'Finalizar')]");
	private static final By BTN_CONTACTOS = By.xpath("//a[contains(text(),'Contactos')]");
	private static final By BTN_VOLVER = By.xpath("//span[contains(text(),'Volver')]");
	private static final By SELECT_SUB_CATEGORIA_CONTACTO = By.xpath("//select[contains(@name, 'SUBCATEG_CONTACT')]");
	private static final By SELECT_SECOND_SUB_CATEGORIA_CONTACTO = By.xpath("//select[contains(@name, 'SEGSUBCATEG_CONTAC')]");
	private static final By TXT_OBSERVACION_CONTACTO = By.xpath("//textarea[contains(@name, 'OBSERVACION:')]");
	private static final By SELECT_REASON_DERIVACION = By.xpath("//*[contains(@name,'RAZON')]");
	private static final By SELECT_SUB_MOTIVO = By.xpath("//select[contains(@name, 'SUBMOTIVO')]");
	private static final By SELECT_CATEGORIA_DERIVACION = By.xpath("//select[contains(@name, 'CAT_DERIVACION')]");
    private static final By SELECT_MOTIVO_DERIVACION = By.xpath("//select[contains(@name, 'ctl_244')]");
    private static final By SELECT_SUBMOTIVO_DERIVACION = By.xpath("//select[contains(@name, 'ctl_245')]");
			
	private static final By SELECT_RAZON = By.xpath("//*[contains(@name,'REASON_CONTACTO')]");
	private static final By BUTTON_SOLUCIONAR = By.xpath("//div[@id='divActivity']/div[76]");
	private static final By TXT_OBSERVACION = By.xpath("//div[@id='divActivity']/div[19]/textarea");
	private static final By BUTTON_CONTINUAR = By.xpath("//*[@id='btn_nvo_continuar']");
	
	private static By lblCategoriaDerivacion;
	
	
	public static By getSelectReasonDerivacion() {
		return SELECT_REASON_DERIVACION;
	}

	public static By getSelectMotivoDerivacion() {
		return SELECT_MOTIVO_DERIVACION;
	}

	public static By getSelectSubmotivoDerivacion() {
		return SELECT_SUBMOTIVO_DERIVACION;
	}

	public static By getLblCategoriaDerivacion() {
		return lblCategoriaDerivacion;
	}

	public static By getBtnFinalizar() {
		return BTN_FINALIZAR;
	}
	public static By getBtnFinalizarCorporativo() {
		return BTN_FINALIZR_CORPORATIVO;
	}
	public static By getBtnContactos() {
		return BTN_CONTACTOS;
	}
	public static By getBtnVolver() {
		return BTN_VOLVER;
	}

	public static By getSelectCategoriaDerivacion() {
		return SELECT_CATEGORIA_DERIVACION;
	}

	public static By getSelectSubMotivo() {
		return SELECT_SUB_MOTIVO;
	}

	public static By getSelectSubCategoriaContacto() {
		return SELECT_SUB_CATEGORIA_CONTACTO;
	}

	public static By getTxtObservacionContacto() {
		return TXT_OBSERVACION_CONTACTO;
	}

	public static By getSelectSecondSubCategoriaContacto() {
		return SELECT_SECOND_SUB_CATEGORIA_CONTACTO;
	}

	public static By getTxtDescripcion() {
		return TXT_DESCRIPCION;
	}
	
	public static void setLblCategoriaDerivacion(String categoria) {
		GestionReclamoUI.lblCategoriaDerivacion = By.xpath("//div[contains(@name, 'textDiv') and contains(text(), '*')]".replace("*", categoria));
	}

	public static By getSelectRazon() {
		return SELECT_RAZON;
	}
	
	public static By getButtonSolucionar() {
		return BUTTON_SOLUCIONAR;
	}
	
	public static By getButtonContinuar() {
		return BUTTON_CONTINUAR;
	}
	
	public static By getTxtObservacion() {
		return TXT_OBSERVACION;
	}
	
	
	
}
