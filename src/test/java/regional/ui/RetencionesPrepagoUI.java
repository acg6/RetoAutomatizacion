package regional.ui;

import org.openqa.selenium.By;

public class RetencionesPrepagoUI {
	
	private RetencionesPrepagoUI() {}
	
	private static By motivoNoRecarga = By.xpath("//div[@id='divActivity']//div[@name='parameterDiv']");
	private static By submotivoNoRecarga = By.xpath("//div[@id='divActivity']//div[@name='parameterDiv']/div[@class='scroller']");
	private static By propuestasComerciales = By.xpath("//div[contains (@class, 'scroller2')]//tr");
	private static By contenido = By.xpath("//*[@id=\"TABLE.97A1_MUESTRA_KW:ctl_231\"]/tbody/tr");
	private static final String XPATH_FRAME_GENERICO = "(//iframe[contains(@id,'link:ctl_')])[2]";
				
	private static By motivoNoRecargaOpcion;
	private static By submotivoNoRecargaOpcion;
	private static By propuestasComercialesOpcion;
	private static By contenidoOpcion;
	
	
	public static By getMotivoNoRecarga() {
		return motivoNoRecarga;
	}
	
	public static By getSubmotivoNoRecarga() {
		return submotivoNoRecarga;
	}

	public static By getMotivoNoRecargaOpcion() {
		return motivoNoRecargaOpcion;
	}
	
	public static By getSubmotivoNoRecargaOpcion() {
		return submotivoNoRecargaOpcion;
	} 
	
	public static By getPropuestasComerciales() {
		return propuestasComerciales;
	}
	
	public static By getPropuestasComercialesOpcion() {
		return propuestasComercialesOpcion;
	}
	
	public static By getContenido() {
		return contenido;
	}
	
	public static By getContenidoOpcion() {
		return contenidoOpcion;
	}
	
	public static void setMotivoNoRecargaOpcion(int numeroOpcion) {
		RetencionesPrepagoUI.motivoNoRecargaOpcion = By.xpath("//div[@id='divActivity']//div[@name='parameterDiv']//table//tbody//tr[**]".replace("**", Integer.toString(numeroOpcion)));
	}
	
	public static void setSubmotivoNoRecargaOpcion(int numeroOpcion) {
		RetencionesPrepagoUI.submotivoNoRecargaOpcion = By.xpath("(//table[contains(@id,'scroll_table')]//div)[**]".replace("**", Integer.toString(numeroOpcion)));
	}
	
	public static void setPropuestasComercialesOpcion(int numeroOpcion) {
		RetencionesPrepagoUI.propuestasComercialesOpcion = By.xpath("//div[contains(@class,'scroller2')]//tr[**]//td[1]".replace("**", Integer.toString(numeroOpcion)));
	}

	public static void setContenidoOpcion(int numeroOpcion) {
		RetencionesPrepagoUI.contenidoOpcion = By.xpath("(//div//input[contains(@onclick,'almacenarSelecMulti')])[**]".replace("**", Integer.toString(numeroOpcion)));
	}
	
	public static String getXpathFrameGenerico() {
		return XPATH_FRAME_GENERICO;
	}
	
	
}
