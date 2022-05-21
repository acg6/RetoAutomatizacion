package regional.ui;

import org.openqa.selenium.By;

public class AsistenciaTecnicaUI {

	private AsistenciaTecnicaUI() {}
	
	private static final By SELECT_SUPER_CATEGORIA = By.xpath("//select[contains(@name,'CALL.SUPER_CATEGORIA:ctl')]");  
	private static final By SELECT_CATEGORIA = By.xpath("//select[contains(@name,'CALL.CATEGORIA:ctl')]");
	private static final By SELECT_MOTIVO = By.xpath("//select[contains(@name,'CALL.MOTIVO:ctl')]");
	private static final By SELECT_SUB_MOTIVO = By.xpath("//select[contains(@name,'CALL.SUBMOTIVO:ctl')]");  
	private static final By OVER_LAY_TRAMITE = By.xpath("//div[@class='LoadingImage']");
	private static final By BUTTON_NUEVO = By.xpath("//img[contains(@id,'dtv_initmt')]");
	private static By rdbtnDeco = By.xpath("(//input[contains(@name,'Deco')])");
	private static By txtNombreDeco;
	private static final By BUTTON_CONTINUAR = By.xpath("//img[contains(@id,'btn_nvo_continuar')]");
	private static final By OVER_LAY_TR_VTN_2 = By.xpath("(//div[@class='LoadingImage'])[1]");
	private static final By RDBTN_FALLO_CONTROL =By.xpath("//input[contains(@onclick,'Fallas con el control remoto')]");
	private static final By RBTN_WORKORDER_CLIENTE = By.xpath("//input[contains(@onclick,'No Solucionado - Work Order a pedido del cliente')]");
	private static final By BUTTON_GENERAR_WORKORDER = By.xpath("//img[contains(@id,'dtv_genwo')]");
	private static final By TXT_NOMRALIZADO = By.xpath("(//table[contains(@id,'TABLE.68A1_MUESTRA_DOMI:ctl_')]//tbody//td[4]//font");
	private static final By BUTTON_MODIFICAR_DOMICILIO = By.xpath("(//table[contains(@id,'TABLE.68A1_MUESTRA_DOMI:ctl')]//td)[8]");
	private static final By BUTTON_NORMALIZAR = By.xpath("//a[contains(@id,'PorletIns')]");
	private static final By BUTTON_CONTINUAR_NORM = By.xpath("//span[contains(text(),'Continuar')]");
	private static final By SELECT_TIPO_SERVICIO = By.xpath("//select[contains(@name,'CALL.TIPO_SERVICIO:ctl')]");
	private static final By SELECT_NOMBRE_SERVICIO = By.xpath("//select[contains(@name,'CALL.NOMBRE_SERVICIO:ctl')]");
	private static By rbtnDecoWO;
	private static final By BUTTON_CONTINUAR_WO = By.xpath("//img[@id='dtv_continuar']");
	private static final By RBTN_TIPO_PRODUCTO = By.xpath("//*[@id='TABLE.50A1_GRILLA_PROD_INI:ctl_292']/tbody/tr[3]/td[1]/input");
	private static final By RBTN_IRD_NO_ENCIENDE = By.xpath("//*[contains(@id,'TABLE.50A1_GRILLA_PRUEBAS:ctl')]//input[contains(@onclick,'No enciende IRD')]");
	private static final By RBTN_WORK_ORDER_NO_SOLUCIONADO = By.xpath("//*[contains(@id,'TABLE.50A1_GRILLA_RESOL:ctl_')]//input[contains(@onclick,'No es posible realizar procedimientos')]");    
	private static final By IMG_MODIFICAR_DOMICILIO = By.xpath("//img[contains(@title,'Editar')]");
    private static final String XPATH_FRAME_GENERICO_ENGAGE = "//iframe[contains(@id,'link:ctl_')]";
    private static final By BUTTON_CONTINUAR_MODIFICACION_CORPORATIVO =By.xpath("//a[contains(@class,'button')]/span[contains(text(),'Continuar')]");
    private static final By BUTTON_GRABAR_MODIFICACION_CORPORATIVO = By.xpath("//a[contains(@class,'button')]/span[contains(text(),'Grabar')]") ;
    
    
	
	public static By getSelectSuperCategoria() {
		return SELECT_SUPER_CATEGORIA;
	}
	public static By getSelectCategoria() {
		return SELECT_CATEGORIA;
	}
	public static By getSelectMotivo() {
		return SELECT_MOTIVO;
	}
	public static By getSelectSubMotivo() {
		return SELECT_SUB_MOTIVO;
	}
	public static By getOverLayTramite() {
		return OVER_LAY_TRAMITE;
	}
	public static By getButtonNuevo() {
		return BUTTON_NUEVO;
	}
	public static By getRdbtnDeco() {
		return rdbtnDeco;
	}
	public static void setRdbtnDeco(int numDeco) {
		AsistenciaTecnicaUI.rdbtnDeco = By.xpath("(//input[contains(@name,'Decos')])"+"["+numDeco+"]");
	}
	public static By getTxtNombreDeco() {
		return txtNombreDeco;
	}
	public static void setTxtNombreDeco(String strNumDeco) {
		AsistenciaTecnicaUI.txtNombreDeco =  By.xpath("(//table[contains(@id,'TABLE.50A1_GRILLA_PROD_INI:ctl')]//tr)[*]//td[3]".replace("*", strNumDeco));
	}
	public static By getButtonContinuar() {
		return BUTTON_CONTINUAR;
	}
	public static By getOverLayTrVtn2() {
		return OVER_LAY_TR_VTN_2;
	}
	public static By getRdbtnFalloControl() {
		return RDBTN_FALLO_CONTROL;
	}
	public static By getRbtnWorkorderCliente() {
		return RBTN_WORKORDER_CLIENTE;
	}
	public static By getButtonGenerarWorkorder() {
		return BUTTON_GENERAR_WORKORDER;
	}
	public static By getTxtNomralizado() {
		return TXT_NOMRALIZADO;
	}
	public static By getButtonModificarDomicilio() {
		return BUTTON_MODIFICAR_DOMICILIO;
	}
	public static By getButtonNormalizar() {
		return BUTTON_NORMALIZAR;
	}
	public static By getButtonContinuarNorm() {
		return BUTTON_CONTINUAR_NORM;
	}
	public static By getSelectTipoServicio() {
		return SELECT_TIPO_SERVICIO;
	}
	public static By getSelectNombreServicio() {
		return SELECT_NOMBRE_SERVICIO;
	}
	public static By getRbtnDecoWO() {
		return rbtnDecoWO;
	}
	public static void setRbtnDecoWO(String strNombreDeco) {
		AsistenciaTecnicaUI.rbtnDecoWO = By.xpath("//td[text()='*']//preceding::input[1]".replace("*", strNombreDeco));
	}
	public static By getButtonContinuarWo() {
		return BUTTON_CONTINUAR_WO;
	}
	public static By getRbtnTipoDeProducto() {
		return RBTN_TIPO_PRODUCTO;
	}
	public static By getRbtnIrdNoEnciende() {
		return RBTN_IRD_NO_ENCIENDE;
	}
	public static By getRbtnWorkOrderNoSolucionado() {
		return RBTN_WORK_ORDER_NO_SOLUCIONADO;
	}

	public static By getImgModificacionDomicilio() {
		return IMG_MODIFICAR_DOMICILIO;
	}
	public static String getXpathFrameGenericoEngage() {
		return XPATH_FRAME_GENERICO_ENGAGE;
	}
	public static By getBtnContinuarModificacionCorporativo() {
		return BUTTON_CONTINUAR_MODIFICACION_CORPORATIVO;
	}
	public static By getBtnGrabarModificacionCorporativo() {
		return BUTTON_GRABAR_MODIFICACION_CORPORATIVO;
	}
	
}
