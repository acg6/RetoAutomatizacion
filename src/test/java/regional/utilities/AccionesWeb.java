package regional.utilities;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class AccionesWeb extends PageObject {
	private Logger logger = LoggerFactory.getLogger(AccionesWeb.class);

	private String bordeRojo = "arguments[0].style.border='3px dashed red'";

	/**
	 * Este metodo espera a que un elemento este visible
	 * 
	 * @param xpath elemento que se requiere esperar a que sea visible
	 * 
	 * @return retorna true o false si el elemento esta o no presente
	 */
	public boolean esperoElementoVisible(By xpath) {
		try {
			WebDriverWait espera = new WebDriverWait(getDriver(), 50);
			espera.until(ExpectedConditions.visibilityOfElementLocated(xpath));
			if (element(xpath).isCurrentlyVisible()) {
				return true;
			}
		} catch (Exception e) {
			System.out.print("en la clase AccionesWeb en el metodo esperoElementoVisible" + e);
		}
		return false;
	}
	
	/**
	 * Metodo para escribir Texto
	 * 
	 * @param element  elemento a escribir
	 * @param strTexto texto que se va a escribir
	 */
	public void escribirTexto(By element, String strTexto) {
		try {

			WebDriverWait wait = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			WebElementFacade input = element(element);
			waitFor(input).isEnabled();

			input.type(strTexto);

		} catch (Exception e) {
			logger.error("en la clase AccionesWeb en el metodo escribirTexto" + e);
		}

	}
	
	/**
	 * Metodo que selecciona una opcion de un select
	 * 
	 * @param select
	 * @param stgOpcion
	 */
	public void seleccionarOpcion(By select, String stgOpcion) {
		try {
			WebElementFacade dropbox = element(select);
			dropbox.selectByVisibleText(stgOpcion);
		} catch (Exception e) {
			logger.error("en la clase AccionesWeb en el metodo seleccionarOpcion" + e);

		}
	}
	
	/**
	 * Método de una aserción la cual valida que con
	 * 
	 * @param mensaje
	 * @param elemet
	 * @param textoaComparar
	 */
	public void validarTextoDeUnElemetoContieneTexto(String mensaje, String textoaComparar) {
		try {
			String textoElemet = mensaje;
			Serenity.takeScreenshot();
			assertTrue(textoElemet, containsText(textoaComparar));
		}catch(Exception e) {
			logger.error("en la clase AccionesWeb en el metodo validarTextoDeUnElemetoContieneTexto " + e);
		}
	}
	
	/**
	 * Metodo diseñado para extraer el texto de un elemento
	 * 
	 * @param webElemet elemento al que se requiere extraerle el texto
	 * @return retorna el texto extraido del elemento
	 */
	public String extraerTextodeLabel(By element) {
		
		String texto = "";
		
		try {
			if (element(element).isCurrentlyVisible() && element(element).isCurrentlyEnabled()) {
				WebDriverWait wait = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
				wait.until(ExpectedConditions.elementToBeClickable(element));
				texto =  element(element).getText().toString();
			}
		} catch (Exception e) {

			logger.error("en la clase AccionesWeb en el metodo extraerTextodeLabel" + e);
			fail(" Error en la clase AccionesWeb en el metodo extraerTextodeLabel" + e);
		}
		
		return texto;
	}
	
	/**
	 * Metodo para resaltar el elemento enviado como parametro
	 * 
	 * @param webLocalizador elemento a resaltar oguzmans 27/10/2021
	 */

	public void bordearElemento(By webLocalizador) {
		try {
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px dashed red'",
					element(webLocalizador));
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.background='#cc8f94'",
					element(webLocalizador));
		} catch (Exception e) {
			logger.error("en la clase AccionesWeb en el metodo bordearElemento " + e);
		}
	}
	
	/**
	 * Metodo para tomar evidencia de la pantalla actual
	 */
	public void tomarEvidencia() {
		try {
			Serenity.takeScreenshot();
		} catch (Exception e) {
			logger.error("en la clase AccionesWeb en el metodo tomarEvidencia " + e);
			
		}
	}
	
	/**
	 * 
	 * @param xpath
	 * @return
	 */
	public boolean esperoElementoVisible(String strXpath) {
		try {
			WebDriverWait espera = new WebDriverWait(getDriver(), 50);
			espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strXpath)));
			if (element(strXpath).isCurrentlyVisible()) {
				return true;
			}
		} catch (Exception e) {
			System.out.print("en la clase AccionesWeb en el metodo esperoElementoVisible" + e);
		}
		return false;
	}

	/**
	 * Este metodo espera a que un elemento este visible
	 * 
	 * @param WebElementFacade elemento que se requiere esperar a que sea visible
	 * @return retorna true o false si el elemento esta o no presente
	 */
	public boolean esperoElementoVisible(WebElementFacade wbElemento) {
		try {
			element(wbElemento).waitUntilVisible();
			if (element(wbElemento).isCurrentlyVisible()) {
				return true;
			}
		} catch (Exception e) {
			System.out.print("en la clase AccionesWeb en el metodo esperoElementoVisible" + e);
		}
		return false;
	}

	/**
	 * Este metodo espera a que un elemento este Habilitado
	 * 
	 * @param xpath elemento que se requiere esperar a que sea visible
	 * @return retorna true o false si el elemento esta o no presente
	 */
	public boolean esperoElementoHabilitado(By xpath) {
		try {
			WebDriverWait espera = new WebDriverWait(getDriver(), 50);
			espera.until(ExpectedConditions.visibilityOfElementLocated(xpath));
			if (element(xpath).isCurrentlyEnabled()) {
				return true;
			}

		} catch (Exception e) {
			System.out.print("en la clase AccionesWeb en el metodo esperoElementoHabilitado " + e);
		}
		return false;
	}
	
	/**
	 * 
	 * @param xpath
	 * @return
	 */
	public boolean esperoElementoHabilitado(String strXpath) {
		try {
			WebDriverWait espera = new WebDriverWait(getDriver(), 50);
			espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strXpath)));
			if (element(strXpath).isCurrentlyEnabled()) {
				return true;
			}

		} catch (Exception e) {
			System.out.print("en la clase AccionesWeb en el metodo esperoElementoHabilitado " + e);
		}
		return false;
	}

	/**
	 * Este metodo espera a que un elemento este Habilitado
	 * 
	 * @param WebElementFacader elemento que se requiere esperar a que sea visible
	 * @return retorna true o false si el elemento esta o no presente
	 */
	public boolean esperoElementoHabilitado(WebElementFacade wbElemento) {
		try {
			element(wbElemento).waitUntilEnabled();
			if (element(wbElemento).isCurrentlyEnabled()) {
				return true;
			}

		} catch (Exception e) {
			System.out.print("en la clase AccionesWeb en el metodo esperoElementoHabilitado " + e);
		}
		return false;
	}

	public void click(WebElementFacade wbElement, boolean blnTomarPantalla) {
		esperoElementoVisible(wbElement);
		esperoElementoHabilitado(wbElement);
		if (blnTomarPantalla) {
			Serenity.takeScreenshot();
		}
		wbElement.click();
	}
	
	public void clickBoton(By strBoton) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
			wait.until(ExpectedConditions.elementToBeClickable(strBoton));
			element(strBoton).click();
		} catch (Exception e) {
			logger.error("en la clase AccionesWeb en el metodo clickBoton " + e);
			
		}
	}
	

	
	/**
	 * Metodo para calcular el tiempo del serenity properties
	 * 
	 * @return retorna el tiempo en segundo del serenity
	 */
	public int obtenerTiempoSerenity() {
		Duration tiempo = getImplicitWaitTimeout();
		return (int) tiempo.getSeconds();
	}
	
	public void click(String strxpath, boolean blnTomarPantalla) {
		esperoElementoVisible(strxpath);
		esperoElementoHabilitado(strxpath);
		if (blnTomarPantalla) {
			Serenity.takeScreenshot();
		}
		find(By.xpath(strxpath)).click();
	}
	

	/**
	 * Metodo encargado de abrir la url
	 *
	 * @param strURL
	 */
	public void abrirURL(String strURL) {
		openAt(strURL);
		espera_implicita(2);
		getDriver().navigate().refresh();
		//getDriver().manage().deleteAllCookies();
	}

	/**
	 * Método de una aserción la cual valida que el elemeto contenga un texto
	 *
	 * @param mensaje
	 * @param elemet
	 * @param textoaComparar
	 */
	public void validarTextoDeUnElemetoContieneTexto(WebElementFacade elemet, String textoaComparar, String mensaje) {
		String textoElemet = element(elemet).getText();
		Serenity.takeScreenshot();
		assertTrue(mensaje, textoElemet.contains(textoaComparar));

	}
	

	/**
	 * Metodo generico para las funciones de limpiar campos y escribir
	 * 
	 * @param wbElement
	 * @param dato
	 */
	public void clear_sendKeys(WebElementFacade wbElement, String dato) {
		wbElement.click();
		wbElement.clear();
		wbElement.sendKeys(dato);
		Serenity.takeScreenshot();
	}
	
	

	/**
	 * 
	 * @param webElementFac
	 * @param bordearElemento
	 * @param tomarScreenshot
	 */
	public void moverPantallahastaElemento(WebElementFacade webElementFac, boolean bordearElemento,
			boolean tomarScreenshot) {
		
		try {
			esperoElementoVisible(webElementFac);
			esperoElementoHabilitado(webElementFac);
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", webElementFac);
		} catch (Exception ex) {
			System.out.println("No se movio la pantalla hacia el elemento con xpath: " + webElementFac);
		}
		if (bordearElemento)
			bordearElemento(webElementFac);
		if (tomarScreenshot)
			Serenity.takeScreenshot();
	}

	/**
	 * Este metodo crea un borde rojo sobre un elemento de la pagina
	 * 
	 * @param strXptElemento xpath del elemento que se bordea
	 */
	public void bordearElemento(String strXptElemento) {
		try {
			WebElement webElemeBordear = find(By.xpath(strXptElemento));
			((JavascriptExecutor) getDriver()).executeScript(bordeRojo, webElemeBordear);
		} catch (Exception ex) {
			System.out.println("No se pudo bordear el elemento con xpath: " + strXptElemento);
		}
	}

	/**
	 * Este metodo crea un borde rojo sobre un elemento de la pagina
	 * 
	 * @param webElementFac Elemento que se bordeara
	 */
	public void bordearElemento(WebElementFacade webElementFac) {
		try {
			((JavascriptExecutor) getDriver()).executeScript(bordeRojo, webElementFac);
		} catch (Exception ex) {
			System.out.println("No se pudo bordear el elemento con xpath: " + webElementFac);
		}
	}

	/**
	 * Mueve la pantalla hasta la parte final de la pagina
	 */
	public void moverScrollHastaFinal() {

		try {
			((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		} catch (Exception jE) {
			System.out.println("No Movio la pantalla: " + jE.getMessage());
		}
	}
	
	/**
	 * Metodo para una espera
	 * @param segundos
	 */
	public void espera_implicita(int segundos) {
		waitFor(segundos).second();
	}
	
	/**
	 * 
	 * @param wbOrdenarLista
	 */
	public void ordenar_lista(WebElementFacade wbOrdenarLista) {
		esperoElementoVisible(wbOrdenarLista);
		wbOrdenarLista.click();
		espera_implicita(2);
		wbOrdenarLista.click();
		espera_implicita(2);
	}
	
	public void validar_reunion(String textoComparar,By wbElement) {
		espera_implicita(2);
		WebElementFacade wbfElement= find(wbElement);

		//System.out.print("*********"+xpathNombre+"**********");
		validarTextoDeUnElemetoContieneTexto(wbfElement, textoComparar, textoComparar);

	}
	
}
