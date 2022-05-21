package regional.ui;

import org.openqa.selenium.By;

public class ClientesUI {
	
	private ClientesUI() {}
	
	private static final By TABS_ENGAGE_CLIENTES = By.xpath("//span[contains(text(),'Clientes')]");
	private static final By SELECCIONAR_TIPO_CLIENTE = By.xpath("//input[contains(@id,'cmbCustomerTypes_Input')]");  																
	private static final By TXT_PAIS = By.xpath("//input[contains(@id,'T1_text')]");
	private static final By TXT_NUMERO_CLIENTE = By.xpath("//input[contains(@id,'T3_text')]");
	private static final By BTN_BUSCAR = By.xpath("//a[contains(@id,'lnkBuscar')]");
	private static final By CMB_PROCESO = By.xpath("//div[@class='FilterElement']//*[contains(@id, 'cmbProcesses_Input')]");
	private static final By SELECT_PROCESO = By.xpath("//form[@id='frmCustomers']//div[contains(@id,'cmbProcesses_DropDown')]//ul[contains(@class,'rcbList')]//li");
	
	private static final By BTN_NUEVO_PROCESO = By.xpath("//a[contains(@id,'lnkNewProces')]");
	private static By selectCliente;
	private static final By BTN_CONTINUAR_RESULTADO = By.xpath("//img[contains(@id,'dtv_continuar')]");
	private static final By CMB_RESULTADO = By.xpath("//select[contains(@name,'RESULTADOS')]");
	private static final By ACTIVIDAD = By.xpath("//span[text()='Actividad']");
	private static final By LBL_BUSQUEDA_CLIENTE = By.xpath("//div[contains(text(),'Búsqueda de Clientes')]");
	private static final By ESTADO_CLIENTE = By.xpath("//tr[contains(@id,'grdCustomers_ctl')]/td[13]");
	private static final By TIPO_CLIENTE = By.xpath("//tr[contains(@id,'grdCustomers_ctl')]/td[12]");
	private static final By SELECT_PERFIL = By.xpath("//input[contains(@id,'cmbUnits_Input')]");
	private static final By GRD_PRODUCTO_COMERCIAL = By.xpath("(//table//tr//td[contains(text(),'Activo')])//preceding::td[contains(text(),'DIRECTV') or contains(text(),'ORO') or contains(text(),'FULL') or contains(text(),'BRONCE') or contains(text(),'PLATA') ]//preceding::input[1]");
	private static final By GRD_PRODUCTO_ACTIVO = By.xpath("(//table//tr//td[contains(text(),'Activo')])[1]");
	private static final By BTN_AGREGAR = By.xpath("//img[contains(@id,'dtv_agre')]");
	private static final By TXT_DIREECION = By.xpath("//tr[contains(@id,'grdCustomers_ctl')]/td[15]");
	private static final By TXT_USUARIO_MODIFICACION_EMAIL = By.xpath("//input[contains(@name,'CALL.USUARIO_MAIL:ctl')]");  
	private static final By TXT_DOMINIO_MODIFICACION_EMAIL = By.xpath("//input[contains(@name,'CALL.NOMB_DOMI_MAIL:ctl')]");
	private static final By SELECT_TIPO_DOMINIO_MODIFICACION_EMAIL = By.xpath("//select[contains(@name,'CALL.TIPO_DOMI_MAIL:ctl')]");
	private static final By SELECT_TIPO_REGION_MODIFICACION_EMAIL = By.xpath("//select[contains(@name,'CALL.TIPO_REGION_MAIL:ctl')]");
	private static final By LBL_EMAIL_CLIENTE = By.xpath("//*[@id=\"TABLENOHEADER.INF_DATOS_FILIATOR:ctl_45\"]/tbody/tr[5]/td[2]");
	private static final By LBL_EMAIL_CLIENTE_UY = By.xpath("/html/body/form/div[8]/div/div[20]/table/tbody/tr[5]/td[2]/font");
	private static final By LBL_DOMICILIO_TEL_FIJO = By.xpath("/html/body/form/div[8]/div/div[21]/table/tbody/tr[7]/td[2]");
	private static final By LBL_PRODUCTO_CANCELADO = By.xpath("//*[@id=\"TABLE.87A1_MUESTRA_SCH_PRO:ctl_32\"]/tbody/tr/td[3]");
	private static final By LBL_FECHA_CANCELADO = By.xpath("//*[@id=\"TABLE.87A1_MUESTRA_SCH_PRO:ctl_32\"]/thead/tr/td[3]");
	private static final By LBL_DOMICILIO_TEL_LAB = By.xpath("/html/body/form/div[8]/div/div[21]/table/tbody/tr[8]/td[2]");
	private static final By TXT_TELEFONO_MODIFICACION_UY = By.xpath("//input[contains(@name,'CALL.HP_DIGITOS4')]");
	private static final By TXT_TELEFONO_MODIFICACION_PREFIJO_EC = By.xpath("//div[contains(@name,'textDiv')]//input[contains(@name,'CALL.HP_DIGITOS2')]");
	private static final By TXT_TELEFONO_HOGAR_MODIFICACION_PREFIJO = By.xpath("//input[contains(@name,'CALL.HP_DIGITOS1')]");
	private static final By TXT_TELEFONO_HOGAR_MODIFICACION_CODAREA_CO = By.xpath("//input[contains(@name,'CALL.HP_DIGITOS2')]");
	private static final By TXT_TELEFONO_HOGAR_MODIFICACION = By.xpath("//input[contains(@name,'CALL.HP_DIGITOS3')]");
	private static final By BTN_PROCESO_ACTIVO = By.xpath("//span[@class='rwInnerSpan'][normalize-space()='OK']");
	private static final By TXT_TELEFONO_TRABAJO_MODIFICACION = By.xpath("//input[contains(@name,'CALL.WP_DIGITOS4:ctl')]");
	private static final By TXT_TELEFONO_TRABAJO_MODIFICACION_EC = By.xpath("//input[contains(@name,'CALL.WP_DIGITOS3:ctl_')]");
	private static final By TXT_TELEFONO_TRABAJO_MODIFICACION_PREFIJO = By.xpath("//input[contains(@name,'CALL.WP_DIGITOS2:ctl')]");
	private static final By TXT_PREFIJO_TELEFONO_FIJO_MODIFICACION_AR = By.xpath("//input[contains(@name,'CALL.HOME_PHONE_A')]");
	private static final By TXT_TELEFONO_FIJO_MODIFICACION_AR = By.xpath("//input[contains(@name,'CALL.HOME_PHONE_B')]  ");
	private static final By CMB_TELEFONO_MODIFICACION = By.xpath("//input[contains(@name,'campologico_CALL.CHECK_HOME_PHONE:ctl_258')]"); 
	private static final By CMB_TELEFONO_FIJO_AR = By.xpath("//input[contains(@name,'campologico_CALL.ACT_HOME_PHONE')]");
	private static final By CMB_TELEFONO_TRABAJO_MODIFICACION = By.xpath("//input[contains(@name,'campologico_CALL.CHECK_WORK_PHONE:ctl')]");
	private static final By CMB_CELULAR_MODIFICACION_CO = By.xpath("// input[contains(@name,'campologico_CALL.CHECK_MOBILE_PHONE:ctl_')]");
	private static final By BTN_CONTINUAR_MODIFICACION = By.xpath("//a[contains(@class,'button')]/span[contains(text(),'Continuar')]");
	private static final By CMB_TELEFONO_TRABAJO_MODIFICACION_EC = By.xpath("//*[@id='divActivity']/div[12]/input[2]");
	private static final By BTN_CONTINUAR_PRODUCTO_CANCELADO = By.xpath("//*[@id='dtv_continuar']");
	private static final By TXT_EMAIL_CLIENTE = By.xpath("//table[contains(@id,'TABLENOHEADER.87A1_DATOS_FILIATO')]/tbody/tr[5]/td[2]/font");
	private static final By TXT_EMAIL_CLIENTE_UY = By.xpath("//table[contains(@id,'TABLENOHEADER.RET_PSW_DATOS_FILIAT')]/tbody/tr[6]/td[2]/font");
	private static final By TXT_EMAIL_CLIENTE_PQR = By.xpath("//table[contains(@id,'TABLENOHEADER.INF_DATOS_FILIATOR')]/tbody/tr[5]/td[2]/font");
	private static final By IMG_MODIFICAR_EMIAL = By.xpath("//table[contains(@id, 'DATOS_FILIATO')]/tbody/tr[5]/td[2]/font/img");
	private static final By IMG_MODIFICAR_EMIAL_UY = By.xpath("//table[contains(@id, 'DATOS_FILIAT')]/tbody/tr[6]/td[2]/font/img");
	private static final By IMG_MODIFICAR_EMAIL_PQR_AR = By.xpath("//i[contains(@title,'Modificar el Email')]");
	private static final By TXT_EMAIL_CLIENTE_PQR_AR = By.xpath("//table[contains(@id,'TABLENOHEADER.INFO_MUESTRA_ENCABEZ')]/tbody/tr/td/div/div/div/table/tbody/tr[2]/td[4]");
	private static final By TXT_EMAIL_CLIENTE_PQR_AR_A = By.xpath("//input[contains(@name,'CALL.EMAIL_A')]");
	private static final By TXT_EMAIL_CLIENTE_PQR_AR_B = By.xpath("//input[contains(@name,'CALL.EMAIL_B')]");
	private static final By CMB_EMAIL_CLIENTE_PQR_AR = By.xpath("//input[contains(@name,'campologico_CALL.ACT_EMAIL')]");
	private static final By SELECT_TIPO_DOMINIO_PQR_AR = By.xpath("//select[contains(@name,'CALL.EMAIL_C')]");
	private static final By SELECT_TIPO_PAIS_PQR_AR = By.xpath("//select[contains(@name,'CALL.EMAIL_D')]");
	private static final By SPINNER_INFO_CLIENTE= By.xpath("//div[@id='ralpCustomersgrdCustomers']//div[@class='LoadingImage']");
	
    private static final By SELECT_LISTA_PROCESO= By.xpath("//div[contains(@class,'FilterElement')]//a[@id='cmbProcesses_Arrow']");
	public static By getSelectListaProceso() {
		return SELECT_LISTA_PROCESO;
	}
	public static By getBtnContinuarResultado() {
		return BTN_CONTINUAR_RESULTADO;
	}
	public static By getBtnAgregar() {
		return BTN_AGREGAR;
	}
	
	public static By getLblBusquedaCliente() {
		return LBL_BUSQUEDA_CLIENTE;
	}

	public static By getTabsEngage() {
		return TABS_ENGAGE_CLIENTES;
	}
	public static By getSeleccionarTipoCliente() {
		return SELECCIONAR_TIPO_CLIENTE;
	}
	public static By getTxtPais() {
		return TXT_PAIS;
	}
	
	public static By getTxtNumeroCliente() {
		return TXT_NUMERO_CLIENTE;
	}
	public static By getBtnBuscar() {
		return BTN_BUSCAR;
	}
	public static By getCmbProceso() {
		return CMB_PROCESO;
	}
	public static By getSelectProceso() {
		return SELECT_PROCESO;
	}
	public static By getBtnNuevoProceso() {
		return BTN_NUEVO_PROCESO;
	}
	
	public static By getSelectCliente() {
		return selectCliente;
	}
	public static void setConsultaCliente(String cliente) {
		ClientesUI.selectCliente = By.xpath("//td[text()='*']".replace("*", cliente));
	}

	public static By getCmbResultado() {
		return CMB_RESULTADO;
	}

	public static By getActividad() {
		return ACTIVIDAD;
	}

	public static By getTabsEngageClientes() {
		return TABS_ENGAGE_CLIENTES;
	}

	public static By getEstadocliente() {
		return ESTADO_CLIENTE;
	}
	
	public static By getTipocliente() {
		return TIPO_CLIENTE;
	}
	
	public static By getSelectPerfil() {
		return SELECT_PERFIL;
	}

	public static By getGrdProductoComercial() {
		return GRD_PRODUCTO_COMERCIAL;
	}

	public static By getEstadoDeCliente() {
		return ESTADO_CLIENTE;
	}

	public static By getTipoDeCliente() {
		return TIPO_CLIENTE;
	}

	public static By getGrdProductoActivo() {
		return GRD_PRODUCTO_ACTIVO;
	}

	public static By getDireccioncliente() {
        return TXT_DIREECION;
    }
    public static By getTelefonoModificacion() {
        return TXT_TELEFONO_MODIFICACION_UY;
    }
    public static By getTelefonoTrabajoModificacion() {
        return TXT_TELEFONO_TRABAJO_MODIFICACION;
    }
    
    public static By getTelefonoHogarModificacion() {
    	return TXT_TELEFONO_HOGAR_MODIFICACION;
    }
    
    public static By getCmbTelefonoModificacion() {
        return CMB_TELEFONO_MODIFICACION;
    }
    public static By getCmbTelefonoTrabajoModificacion() {
        return CMB_TELEFONO_TRABAJO_MODIFICACION;
    }
 
    public static By getCmbCelularModificacionCO() {
    	return CMB_CELULAR_MODIFICACION_CO;
    }
    public static By getBtnContinuarModificacion() {
        return BTN_CONTINUAR_MODIFICACION;
    }
   
    public static By getTxtUsuarioModificacionEmail() {
        return TXT_USUARIO_MODIFICACION_EMAIL;
    }
    public static By getTxtDominioModificacionEmail() {
        return TXT_DOMINIO_MODIFICACION_EMAIL;
    }
    public static By getSelTipoDominioModificacionEmail() {
        return SELECT_TIPO_DOMINIO_MODIFICACION_EMAIL;
    }
    public static By getSelTipoRegionModificacionEmail() {
        return SELECT_TIPO_REGION_MODIFICACION_EMAIL;
    }

   	public static By getTxtDireecion() {
		return TXT_DIREECION;
	}
	public static By getTxtTelefonoModificacion() {
		return TXT_TELEFONO_MODIFICACION_UY;
	}
	
	public static By getTxtTelefonoTrabajoModificacion() {
		return TXT_TELEFONO_TRABAJO_MODIFICACION;
	}
	
	public static By getSelectTipoDominioModificacionEmail() {
		return SELECT_TIPO_DOMINIO_MODIFICACION_EMAIL;
	}
	public static By getSelectTipoRegionModificacionEmail() {
		return SELECT_TIPO_REGION_MODIFICACION_EMAIL;
	}
	
	public static By getBtnProcesoActivo() {
         return BTN_PROCESO_ACTIVO;
	}
	public static By getLblDomicilioTelFijo() {
		return LBL_DOMICILIO_TEL_FIJO;
	}
	public static By getLblDomicilioTelLab() {
		return LBL_DOMICILIO_TEL_LAB;
	}
	public static By getLblEmailCliente() {
		return LBL_EMAIL_CLIENTE;
	}
	public static By getLblEmailClienteUy() {
		return LBL_EMAIL_CLIENTE_UY;
	}
	public static By getTelefonoModificacionPrefijo() {
		return TXT_TELEFONO_MODIFICACION_PREFIJO_EC;
	}
	
	public static By getTelefonoTrabajoModificacionPrefijo() {
		return TXT_TELEFONO_TRABAJO_MODIFICACION_PREFIJO;
	}
	
	public static By getPrefijoTelefonoHogarModificacion() {
		return TXT_TELEFONO_HOGAR_MODIFICACION_PREFIJO;
	}
	
	public static By getCodAreaTelefonoHogarModificacionCO() {
		return TXT_TELEFONO_HOGAR_MODIFICACION_CODAREA_CO;
	}
	
	
	public static By getTelefonoTrabajoModificacionEc() {
		return TXT_TELEFONO_TRABAJO_MODIFICACION_EC;
	}
		
	public static void setSelectCliente(By selectCliente) {
		ClientesUI.selectCliente = selectCliente;
	}

	public static By getCmbTelefonoTrabajoModificacionEc() {
		return CMB_TELEFONO_TRABAJO_MODIFICACION_EC;
	}
	public static By getLblProductoCancelado() {
		return LBL_PRODUCTO_CANCELADO;
	}
	public static By getLblFechaCancelado() {
		return LBL_FECHA_CANCELADO;
	}
	public static By getBtnProductoCancelado() {
		return BTN_CONTINUAR_PRODUCTO_CANCELADO;
	}
	public static By getTxtPrefijoArgentina() {
		return TXT_PREFIJO_TELEFONO_FIJO_MODIFICACION_AR;
	}
	public static By getTxtNumeroFijoArgentina() {
		return TXT_TELEFONO_FIJO_MODIFICACION_AR;
	}
	public static By getCmbTelefonoFijoAr() {
		return CMB_TELEFONO_FIJO_AR;
	}
	public static By getTxtEmailCliente() {
		return TXT_EMAIL_CLIENTE;
	}
	public static By getTxtEmailClientePqr() {
		return TXT_EMAIL_CLIENTE_PQR;
	}
	public static By getImgModificarEmailCliente() {
		return IMG_MODIFICAR_EMIAL;
	}
	public static By getImgModificarEmailClientePqrAr() {
		return IMG_MODIFICAR_EMAIL_PQR_AR;
	}
	public static By getTxtEmailClientePqrAr() {
		return TXT_EMAIL_CLIENTE_PQR_AR;
	}
	public static By getTxtEmailClientePqrArA() {
		return TXT_EMAIL_CLIENTE_PQR_AR_A;
	}
	public static By getTxtEmailClientePqrArB() {
		return TXT_EMAIL_CLIENTE_PQR_AR_B;
	}
	public static By getCmbEmailClientePqrAr() {
		return CMB_EMAIL_CLIENTE_PQR_AR;
	}
	public static By getSelectTipoDiominioPqrAr() {
		return SELECT_TIPO_DOMINIO_PQR_AR;
	}
	public static By getSelectTipoPaisPqrAr() {
		return SELECT_TIPO_PAIS_PQR_AR;
	}
	public static By getSpinnerInfoCliente() {
		return SPINNER_INFO_CLIENTE;
	}
	public static By getImgModificarEmialUy() {
		return IMG_MODIFICAR_EMIAL_UY;
	}
	public static By getTxtEmailClienteUy() {
		return TXT_EMAIL_CLIENTE_UY;
	}
	
}


