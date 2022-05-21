package regional.ui;

import org.openqa.selenium.By;

public class GestionRetencionUI {

	private GestionRetencionUI() {
	}

	private static final By RDB_SUBMOTIVO_INTENCION = By.xpath("//input[contains(@name,'MotivosBaja')]");
	private static final By INPUT_SUBMOTIVO_INTENCION_BAJA_UY = By
			.xpath("//*[@id='TABLENOHEADER.17A1_MUESTRO_MOT_BAJ:ctl_2310']/tbody/tr/td/table/tbody/tr[1]/td/div");
	private static final By INPUT_SUBSUBMOTIVO_INTENCION_BAJA_UY = By
			.xpath("//*[@id='TABLENOHEADER.RET_IN_GR_SUBSUB_BAJ:ctl_2406']/tbody/tr/td/table/tbody/tr[1]/td/div");
	private static final By OPCION_CATEGORIA_BENEFICIO_PRINCIPAL = By.xpath("//*[contains(@name,'CATEG_BENEF')]");
	private static final By SELECT_CATEGORIA_BENEFICIO_PRINCIPAL_PERU = By
			.xpath("//select[contains(@name,'CALL.CATEG_BENEF:ctl')]");
	private static final By OPCIONES_CATEGORIA_BENEFICIO_PRINCIPAL = By
			.xpath("//*[contains(@name,'CATEG_BENEF')]//option");
	private static final By RDB_FECHADEBAJA = By.xpath("(//input[contains(@name,'fechaBaja')])[2]");
	private static final By SELECT_BENEFICIO_PRINCIPAL = By.xpath("//select[contains(@name,'CALL.ID_BENEF:ctl')]");
	private static final By SELECT_CATEGORIA_BENEFICIO_PRINCIPAL = By
			.xpath("//select[contains(@name,'CALL.CATEG_BENEF:ctl_')]");
	private static final By OPCION_BENEFICIO_PRINCIPAL = By.xpath("//*[contains(@name,'ID_BENEF')]");
	private static final By SELECT_TIPO_RETENIDO = By.xpath("//select[contains(@name,'CALL.RESULTADOS:ctl_')]");
	private static final By TXT_OBSERVACIONES = By
			.xpath("//*[@id='divActivity']//textarea[contains(@name,'OBSERVACIONES')]");
	private static final By BTN_CONTINUAR = By.xpath("//img[contains(@id,'continuar')]");
	private static final By BTN_REINTENTAR_CONTINUAR = By.xpath("//*[contains(@id,'btn_nvo_continuar')]");
	private static final By CMB_SEGUNDA_CATEGORIA = By.xpath("//*[contains(@name,'SUBREASON_RES')]");
	private static final By TBL_PRODUCTO_COMERCIAL = By.xpath("//table[contains(@id,'TABLE.78A1_MUESTRA_PROD')]");
	private static final By RDB_PRODUCTO_COMERCIAL = By.xpath("//input[contains(@onclick,'('ESTADO_PRODUCTO','1')')]");
	private static final By RDB_PRODUCTO_INBOUND = By.xpath(
			"//td[contains(normalize-space(),'Mirror') or contains(normalize-space(),'Subscription Fee')]//preceding-sibling::td[contains(text(),'Activo')]//preceding::input[1]");
	private static final By SELECT_ACCION = By.xpath("//select[contains(@name,'CALL.ACCION:ctl')]");
	private static final By SELECT_LISTA_PRODUCTO = By.xpath("//select[contains(@name, 'CALL.PROD_SEL')]");
	private static final By BTN_REGISTRAR = By.xpath("//img[contains(@id,'dtv_RegistrarA')]");
	private static final By DIV_CATEGORIA = By.xpath("//div[contains(@onscroll, 'ctl_442')]");
	private static final By TXT_NOMBRE_CATEGORIA = By.xpath("//td[contains(text(), 'Retención del servicio')]");
	private static final By RBD_ORO_HD = By.xpath(
			"//input[contains(@onclick,\"('ESTADO_PRODUCTO','1')\") and contains(@onclick,\"('NRO_PRODUCTO','139')\")]");
	private static final By RBD_ORO_MIX = By.xpath(
			"//input[contains(@onclick,\"('ESTADO_PRODUCTO','1')\") and contains(@onclick,\"('NRO_PRODUCTO','132')\")]");
	private static final By RBD_ORO_PLUS = By.xpath(
			"//input[contains(@onclick,\"('ESTADO_PRODUCTO','1')\") and contains(@onclick,\"('NRO_PRODUCTO','133')\")]");
	private static final By RBD_PLATA_HD = By.xpath(
			"//input[contains(@onclick,\"('ESTADO_PRODUCTO','1')\") and contains(@onclick,\"('NRO_PRODUCTO','169')\")]");
	private static final By RBD_PLATINNO = By.xpath(
			"//input[contains(@onclick,\"('ESTADO_PRODUCTO','1')\") and contains(@onclick,\"('NRO_PRODUCTO','154')\")]");
	private static final By RBD_ORO_HD_K = By.xpath(
			"//input[contains(@onclick,\"('ESTADO_PRODUCTO','1')\") and contains(@onclick,\"('NRO_PRODUCTO','191')\")]");
	private static final By RBD_PLATA = By.xpath(
			"//input[contains(@onclick,\"('ESTADO_PRODUCTO','1')\") and contains(@onclick,\"('NRO_PRODUCTO','147')\")]");

	private static final By SELECT_SUBMOVTIVO = By.xpath("//*[contains(@name, 'COD_MOT_BAJA')]");
	private static final By SELECT_SUBSUBMOVTIVO = By.xpath("//*[contains(@name, 'COD_SUBMOT_BAJA')]");
	private static final By SELECT_MOTIVOPRINCIPAL = By.xpath("//*[contains(@name,'CALL.MOT_BAJA')]");
	private static final By SELECT_MOTIVOPRINCIPALNET = By.xpath("//*[contains(@name,'CALL.MOT_BAJA')]");
	private static final By BTN_AGREGAR_BENEFICIO = By.xpath("//*[contains(@id,'dtv_agre')]");
	private static final String XPATH_FRAME_LISTA_PRODUCTOS = "//iframe[contains(@id,'link:ctl_')]";
	private static final String COMIENZOXPATHPRODUCTOPREMIUM = "//input[contains(@onclick,\"('ESTADO_PRODUCTO','1')\") and contains(@onclick,\"('NRO_PRODUCTO','";
	private static final String FINXPATHPRODUCTOPREMIUM = "')\")]";
	private static final String XPATH_FRAME_LISTA_ACCIONES = "//iframe[contains(@id,'link:ctl_23')]";
	private static final By BTN_PRODUCTO = By.xpath("//*[contains(@id,'Productos')]");
	private static final By BTN_VOLVER = By.xpath("//*[contains(@id,'volver')]");
	private static final By LBL_ESTADO_PRODUCTO = By.xpath("//*[@id=\"TABLE.77A1_MUE_PROD_COME:ctl_2\"]/tbody/tr/td[3]");

	public static By getLblEstadoProdcuto() {
		return LBL_ESTADO_PRODUCTO;
	}

	public static String getComienzoXpathProductoPremium() {
		return COMIENZOXPATHPRODUCTOPREMIUM;
	}

	public static By getFechaDeBaja() {
		return RDB_FECHADEBAJA;
	}

	public static String getFinXpathProductoPremium() {
		return FINXPATHPRODUCTOPREMIUM;
	}

	public static By getRdbSubmotivoIntencion() {
		return RDB_SUBMOTIVO_INTENCION;
	}

	public static By getDivCategoria() {
		return DIV_CATEGORIA;
	}

	public static By getTxtNombreCategoria() {
		return TXT_NOMBRE_CATEGORIA;
	}

	public static By getSelectCategoriaBeneficioPrincipal() {
		return SELECT_CATEGORIA_BENEFICIO_PRINCIPAL;
	}

	public static By getSelectBeneficioPrincipal() {
		return SELECT_BENEFICIO_PRINCIPAL;
	}

	public static By getSelectMotivoPrincipal() {
		return SELECT_MOTIVOPRINCIPAL;
	}

	public static By getSelectMotivoPrincipalNet() {
		return SELECT_MOTIVOPRINCIPALNET;
	}

	public static By getSelectTipoRetenido() {
		return SELECT_TIPO_RETENIDO;
	}

	public static By getTxtObservaciones() {
		return TXT_OBSERVACIONES;
	}

	public static By getBtnContinuar() {
		return BTN_CONTINUAR;
	}

	public static By getBtnProducto() {
		return BTN_PRODUCTO;
	}

	public static By getBtnVolver() {
		return BTN_VOLVER;
	}

	public static By getCmbSegundaCategoria() {
		return CMB_SEGUNDA_CATEGORIA;
	}

	public static By getTblProductoComercial() {
		return TBL_PRODUCTO_COMERCIAL;
	}

	public static By getRdbProductoComercial() {
		return RDB_PRODUCTO_COMERCIAL;
	}

	public static By getSelectAccion() {
		return SELECT_ACCION;
	}

	public static By getSelectListaProductos() {
		return SELECT_LISTA_PRODUCTO;
	}

	public static By getBtnRegistrar() {
		return BTN_REGISTRAR;
	}

	public static By getRdbOroHd() {
		return RBD_ORO_HD;
	}

	public static By getRdbOroMix() {
		return RBD_ORO_MIX;
	}

	public static By getRdbOroPlus() {
		return RBD_ORO_PLUS;
	}

	public static By getRdbPlataHd() {
		return RBD_PLATA_HD;
	}

	public static By getRdbPlatino() {
		return RBD_PLATINNO;
	}

	public static By getRdbOroHdK() {
		return RBD_ORO_HD_K;
	}

	public static By getRdbRdbPlata() {
		return RBD_PLATA;
	}

	public static By getOpcionCategoriaBeneficioPrincipal() {
		return OPCION_CATEGORIA_BENEFICIO_PRINCIPAL;
	}

	public static By getOpcionBeneficioPrincipal() {
		return OPCION_BENEFICIO_PRINCIPAL;
	}

	public static By getSelectSubmovtivo() {
		return SELECT_SUBMOVTIVO;
	}

	public static By getSelectListaProducto() {
		return SELECT_LISTA_PRODUCTO;
	}

	public static By getRbdOroHd() {
		return RBD_ORO_HD;
	}

	public static By getRbdOroMix() {
		return RBD_ORO_MIX;
	}

	public static By getRbdOroPlus() {
		return RBD_ORO_PLUS;
	}

	public static By getRbdPlataHd() {
		return RBD_PLATA_HD;
	}

	public static By getRbdPlatinno() {
		return RBD_PLATINNO;
	}

	public static By getRbdOroHdK() {
		return RBD_ORO_HD_K;
	}

	public static By getRbdPlata() {
		return RBD_PLATA;
	}

	public static By getSelectSubsubmovtivo() {
		return SELECT_SUBSUBMOVTIVO;
	}

	public static By getBtnReIntentarContinuar() {
		return BTN_REINTENTAR_CONTINUAR;
	}

	public static String getXpathFrameListaProductos() {
		return XPATH_FRAME_LISTA_PRODUCTOS;
	}

	public static String getXpathSelectAccion() {
		return XPATH_FRAME_LISTA_ACCIONES;
	}

	public static By getSelectCategoriaBeneficioPrincipalPeru() {
		return SELECT_CATEGORIA_BENEFICIO_PRINCIPAL_PERU;
	}

	public static By getBtnAgregarBeneficio() {
		return BTN_AGREGAR_BENEFICIO;
	}

	public static By getRbtnProductoInbound() {
		return RDB_PRODUCTO_INBOUND;
	}

	public static By getOpcionesCategoriaBeneficioPrincipal() {
		return OPCIONES_CATEGORIA_BENEFICIO_PRINCIPAL;
	}

	public static By getInputSubmotivoBajaUy() {
		return INPUT_SUBMOTIVO_INTENCION_BAJA_UY;
	}

	public static By getInputSubSubmotivoBajaUy() {
		return INPUT_SUBSUBMOTIVO_INTENCION_BAJA_UY;
	}

}
