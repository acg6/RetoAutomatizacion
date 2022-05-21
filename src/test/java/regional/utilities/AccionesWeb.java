package regional.utilities;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gargoylesoftware.htmlunit.javascript.host.Console;
import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.util.Calendar;

import exceptions.ExceptionsProyecto;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import regional.ui.AsistenciaTecnicaUI;
import regional.ui.RetencionesPrepagoUI;

public class AccionesWeb extends PageObject {
	
	public AccionesWeb() {
		//constructor
	}

	private Logger logger = LoggerFactory.getLogger(AccionesWeb.class);
	private static Map<String, String> mapDatosCasoPrueba = new LinkedHashMap<>();
	private static final String IGNORE = "<IGNORE>";
	private static final String FORMATO_FECHA = "dd/MM/yyyy";
	private static final int ESPERA_TIEMPO_FIJO_CORTO = 4;
	private static final int ESPERA_TIEMPO_FIJO_LARGO = 60;
	private static final String ARGUMENTOS_SCRIPT = "arguments[0].scrollIntoViewIfNeeded(true);";

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
			excepcionAccionesWeb(e);
		}

	}

	/**
	 * Metodo para escribir Texto
	 * 
	 * @param element  elemento a escribir
	 * @param strTexto texto que se va a escribir
	 */
	public void escribirTextoSendKeys(By element, String strTexto) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			WebElementFacade input = element(element);
			waitFor(input).isEnabled();
			input.sendKeys(strTexto);
		} catch (Exception e) {
			logger.error("en la clase AccionesWeb en el metodo escribirTextoSendKey" + e);
			excepcionAccionesWeb(e);
		}

	}

	/**
	 * metodo que limpia el campo
	 * 
	 * @param element elemento a limpiar
	 */
	public void limpiarCampo(By element) {
		try {
			WebElementFacade input = element(element);
			waitFor(input).isEnabled();
			input.clear();
		} catch (Exception e) {
			logger.error("en la clase AccionesWeb en el metodo limpiarCampo" + e);
			excepcionAccionesWeb(e);
		}
	}

	/**
	 * Metodo para der click a un boton
	 * 
	 * @param strBoton el elemento a interactuar
	 */
	public void clickBoton(By strBoton) {
		try {
		
			WebElementFacade btn = element(strBoton);
			waitFor(btn).isCurrentlyVisible();
			element(strBoton).click();

		} catch (Exception e) {
			logger.error("en la clase AccionesWeb en el metodo clickBoton" + e);
			excepcionAccionesWeb(e);
		}
	}

	/**
	 * Metodo de cambio de frame segun el numero del frame
	 * 
	 * @param frame numero del frame
	 */
	public void cambioDeFrame(int frame) {
		try {
		getDriver().switchTo().frame(frame);
		} catch(Exception e) {
			logger.error("en la clase AccionesWeb en el metodo cambioDeFrame" + e);
			excepcionAccionesWeb(e);
		}
	}
	
	/**
	 * Metodo de cambio de frame segun el ID del frame
	 * 
	 * @param frame numero del frame
	 */
	public void cambioDeFramePorId(String id) {
		try {
		getDriver().switchTo().frame(id);
		}catch(Exception e) {
			logger.error("en la clase AccionesWeb en el metodo cambioDeFramePorId" + e);
			excepcionAccionesWeb(e);
		}
	}

	/**
	 * Metodo de cambio de frame al de defecto
	 */
	public void cambioDeFrameDefault() {
		try {
		getDriver().switchTo().defaultContent();
		}catch(Exception e) {
			logger.error("en la clase AccionesWeb en el metodo cambioDeFrameDefault " + e);
			excepcionAccionesWeb(e);
		}

	}

	/**
	 * Espera a que carge todos los objetos de la pagina
	 */
	public void esperaCargarPagina() {
		try {
			getDriver().manage().timeouts().setScriptTimeout(ESPERA_TIEMPO_FIJO_LARGO, TimeUnit.SECONDS);
			getDriver().manage().timeouts().pageLoadTimeout(ESPERA_TIEMPO_FIJO_LARGO, TimeUnit.SECONDS);
			new WebDriverWait(getDriver(), ESPERA_TIEMPO_FIJO_LARGO)
					.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
							.executeScript("return document.readyState").equals("complete"));
			restauraTiempoImplicitoPorDefecto();
		} catch (Exception e) {
			logger.error("ERROR: en la clase AccionesWeb en el metodo esperarCargaPagina: " + e);
			excepcionAccionesWeb(e);
		}
	}

	/**
	 * Metodo encargado de abrir la url
	 * 
	 * @param strURL
	 */
	public void abrirURL(String strURL) {

		openAt(strURL);
		getDriver().manage().deleteAllCookies();

	}
	
	public void abrirPagina(String strURL) {
		getDriver().get(strURL);
		getDriver().manage().deleteAllCookies();
	}

	/**
	 * Metodo de esperar tiempo en segundos
	 * 
	 * @param tiempo
	 */
	public void esperaTiempoSegundos(int tiempo) {
		waitFor(tiempo).seconds();
	}

	/**
	 * Metodo que espera a que desaparezca el elemento
	 * 
	 * @param element
	 * @param tiempo
	 */
	public void esperaDesaparezcaElemento(By element, int tiempo) {
		try {
			editaTiempoImplicito(tiempo);
			while (element(element).isCurrentlyVisible()) {
				waitFor(200).milliseconds();
			}
			restauraTiempoImplicitoPorDefecto();
		} catch (Exception e) {

			logger.info("clase AccionesWeb en el metodo esperaDesaparezcaElemento");
			resetImplicitTimeout();
		}
	}
	
	/**
	 * Metodo que espera a que desaparezca elemento
	 * @param element elemento de tipo By 
	 * @param int maxNumeroIntentos numero de intentos por espera
	 * Por Joboterog
	 * Octube 5/2021
	 */
	public void esperaDesaparezcaElementoIntentos(By element, int maxNumeroIntentos) {
	 
		int numeroIntentos = 0;
		try {			
			WebDriverWait espera = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
				while (Boolean.TRUE.equals(element(element).isCurrentlyVisible()) && numeroIntentos < maxNumeroIntentos) {
					espera.until(ExpectedConditions.visibilityOfElementLocated(element));
					numeroIntentos++;
			}

		} catch (Exception e) {
			logger.info("error en clase AccionesWeb en el metodo esperaDesaparezcaElemento");
			restauraTiempoImplicitoPorDefecto();
		}
	}

	/**
	 * Este metodo espera a que un elemento este visible
	 * 
	 * @param xpath elemento que se requiere esperar a que sea visible
	 * @return retorna true o false si el elemento esta o no presente
	 */
	public boolean esperoElementoVisible(By xpath) {

		try {
	
			WebDriverWait espera = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
			espera.until(ExpectedConditions.visibilityOfElementLocated(xpath));
			
			if (element(xpath).isCurrentlyVisible())
				return true;
		} catch (Exception e) {

			logger.info("en la clase AccionesWeb en el metodo esperoElementoVisible" + e);

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
			WebDriverWait espera = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
			espera.until(ExpectedConditions.visibilityOfElementLocated(xpath));
			if (element(xpath).isCurrentlyEnabled())
				return true;
		} catch (Exception e) {
			logger.error("en la clase AccionesWeb en el metodo esperoElementoHabilitado" + e);
			excepcionAccionesWeb(e);
		}
		return false;
	}
	
	/**
	 * Este metodo espera a que un elemento este Clickable
	 * @param xpath elemento que se requiere esperar a que sea  Clickable
	 * @return retorna true o false si el elemento esta o no Clickable
	 * @author acastanog
	 */
	public boolean esperoElementoClickable(By xpath) {
		
		try {
			WebDriverWait espera = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
			espera.until(ExpectedConditions.elementToBeClickable(xpath));
			if (element(xpath).isClickable())
				return true;
		} catch (Exception e) {
			logger.error("en la clase AccionesWeb en el metodo esperoElementoHabilitado" + e);
			excepcionAccionesWeb(e);
		}
		return false;
	}

	/**
	 * Metodo que elige una fecha para hacer un agendamiento
	 * 
	 * @param xpath lista de objetos
	 * @param dato  texto que contiene el objeto
	 */
	public void eligirFecha(By element) {
		try {
			List<WebElement> lstOpcionesAgenda = getDriver().findElements(element);
			int numRdb = UtilDatosAleatorios.obtenerIntAleatorio(lstOpcionesAgenda.size());
			posicionarElementoweb(lstOpcionesAgenda.get(numRdb));
			waitFor(lstOpcionesAgenda.get(numRdb)).click();
			tomarEvidencia();
		} catch (Exception e) {
			logger.error("ERROR: en la clase CapturaPospagoNuevoPageObject, en el método eligirFechaAgendamiento");
			excepcionAccionesWeb(e);
		}
	}

	/**
	 * Metodo que se le da click a un elemento de una lista de elementos dependiendo
	 * del texto de este
	 * 
	 * @param xpath lista de objetos
	 * @param dato  texto que contiene el objeto
	 */
	public void clickElementoLista(By xpath, String dato) {
		try {
			Boolean encontreoElemento = false;
            List<WebElement> elemetos = getDriver().findElements(xpath);            
			for (int i = 0; i < elemetos.size(); i++) {

                if (elemetos.get(i).getText().trim().toLowerCase().contains(dato.trim().toLowerCase()))  {
					elemetos.get(i).click();
					encontreoElemento = true;
					break;
				}
			}
			if (Boolean.FALSE.equals(encontreoElemento))
				throw new NullPointerException();

		} catch (Exception e) {

			logger.error("en la clase AccionesWeb en el metodo clickElementoLista" + e);
			excepcionAccionesWeb(e);
		}

	}

	/**
	 * Metodo que cuenta los elementos de una lista y genera un numero aleatorio
	 * dependiendo de la cantidad de lineas encontradas y seleccionar un dato
	 * 
	 * @param xpath lista de objetos
	 */
	public void contarClickElementoLista(By xpath) {
		try {
			List<WebElement> elemetos = getDriver().findElements(xpath);
			int tam = elemetos.size();
			SecureRandom random = new SecureRandom();
			Integer dato = random.nextInt(tam);
			((JavascriptExecutor) getDriver()).executeScript(ARGUMENTOS_SCRIPT,
					elemetos.get(dato));
			elemetos.get(dato).click();
		}catch(Exception e) {
			logger.error("en la clase AccionesWeb en el metodo contarClickElementoLista " + e);
			excepcionAccionesWeb(e);
		}
	}
	
	/**
	 * Metodo que cuenta los elementos de una lista y genera un numero aleatorio
	 * dependiendo de la cantidad de lineas encontrada, ubica el elemnto si es de una tabla y seleccionar un dato
	 * 
	 * @param xpath lista de objetos
	 */
	public void elegirElementoListaUbicaClick(By xpath) {
		try {
			
			esperoElementoVisible(xpath);
			
			List<WebElement> elemetos = getDriver().findElements(xpath);
			int tam = elemetos.size();
			SecureRandom random = new SecureRandom();
			Integer dato = random.nextInt(tam);
			posicionarElementoScroll(elemetos.get(dato));
			
			elemetos.get(dato).click();
		}catch(Exception e) {
			logger.error("en la clase AccionesWeb en el metodo elegirElementoListaUbicaClick " + e);
			excepcionAccionesWeb(e);
		}
	}
	/**
	 * Método que obtiene una lista de datos de la tabla categoria
	 * 
	 * @return List<String> donde se almacena la lista de elementos presentes en la tabla
	 */
	public int obtenerListaCategoria(By xpath){
		List<WebElement> categoria = getDriver().findElements(xpath);
		return categoria.size();
	}

	/**
	 * Metodo para resaltar el elemento enviado como parametro
	 * 
	 * @param webLocalizador elemento a resaltar
	 */

	public void bordearElemento(By webLocalizador) {
		try {
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='2px dashed red'",
				element(webLocalizador));
		}catch(Exception e) {
			logger.error("en la clase AccionesWeb en el metodo bordearElemento " + e);
			excepcionAccionesWeb(e);
		}
	}

	public void posicionarElementoweb(WebElement strWebElement) {
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", strWebElement);
	}

	/**
	 * Metodo para tomar evidencia de la pantalla actual
	 */
	public void tomarEvidencia() {
		try {
			Serenity.takeScreenshot();
		}catch(Exception e) {
			logger.error("en la clase AccionesWeb en el metodo tomarEvidencia " + e);
			excepcionAccionesWeb(e);
		}
	}

	/**
	 * Metodo para esperar a que aparezca un posible elemento, como por ejemplo un
	 * PopUp
	 * 
	 * @param elemento a ser esperado
	 * @param tiempo   tiempo en segundos que se va a esperar el elemento
	 */
	public void clickPosibleElemento(By elemento, int tiempo) {
		By objeto = elemento;
		try {
			
			WebDriverWait espera = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
			espera.until(ExpectedConditions.visibilityOfElementLocated(elemento));
			
			if(find(objeto).isVisible() ) { 
				element(elemento).withTimeoutOf(Duration.ofSeconds(tiempo)).waitUntilClickable();
				element(elemento).click();
			}
		} catch (Exception e) {
			logger.info("No aparecio posibe emergente: " + elemento.toString());
	
			}
	}
	

	/**
	 * Metodo de posicionar Elemento,
	 * 
	 * @param element
	 */
	public void posicionarElementoScroll(By element) {
		try {
		((JavascriptExecutor) getDriver()).executeScript(ARGUMENTOS_SCRIPT,	element(element));
		}catch(Exception e) {
			logger.error("en la clase AccionesWeb en el metodo posicionarElementoScroll" + e);
			excepcionAccionesWeb(e);
		}
	}
	/**
	 * Metodo de posicionar Elemento,
	 * 
	 * @param element WebElement 
	 */
	public void posicionarElementoScroll(WebElement element) {
		try {
		((JavascriptExecutor) getDriver()).executeScript(ARGUMENTOS_SCRIPT, element);
		}catch(Exception e) {
			logger.error("en la clase AccionesWeb en el metodo posicionarElementoScroll" + e);
			excepcionAccionesWeb(e);
		}
	}

	/**
	 * Metodo de posicionar el scroll en un punto especifico
	 * 
	 * @param x
	 * @param y
	 */
	public void desplazarScroll(String x, String y) {
		((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(" + x + "," + y + ")");
	}

	/**
	 * Posiciona el Scroll en la parte superior del aplicativo
	 */
	public void desplazarScrollArriba() {
		try {
			((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		}catch(Exception e) {
			logger.error("en la clase AccionesWeb en el metodo desplazarScrollArriba " + e);
			excepcionAccionesWeb(e);
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
			excepcionAccionesWeb(e);

		}
	}

	/**
	 * 
	 * 
	 * /** Metodo que en un elemento se oprime una keyboard
	 * 
	 * @param elemento que al que se le realiza la accion
	 * @param strTexto tipo de keyboar que se necesita
	 */
	public void keyboaraAElemento(By element, String strTexto) {
		try {

			WebDriverWait wait = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			WebElementFacade input = element(element);

			waitFor(input).isEnabled();
			switch (strTexto) {
			case "Keys.UP":
				input.sendKeys(Keys.UP);
				break;
			case "Keys.ENTER":
				input.sendKeys(Keys.ENTER);
				break;
			case "Keys.ESPACIO":
				input.sendKeys(Keys.SPACE);
				break;
			default:
				break;
			}

		} catch (Exception e) {
			logger.error("en la clase AccionesWeb en el metodo keyboaraAElemento" + e);
			excepcionAccionesWeb(e);
		}
	}

	/**
	 * Método de una aserción el cual valida que 2 textos no son iguales
	 * 
	 * @param mensaje        que aparece si la comparacion es igual
	 * @param textoaComparar texto a comprar
	 * @param elemet         elemeto que se le extrae el texto
	 */
	public void validarTextoDeUnElemetoNoEsigual(String mensaje, String textoaComparar, By elemet) {
		try {
			String textoElemet = element(elemet).getTextValue();
			Serenity.takeScreenshot();
			assertNotEquals(mensaje, textoaComparar, textoElemet);
		}catch(Exception e) {
			logger.error("en la clase AccionesWeb en el metodo validarTextoDeUnElemetoNoEsigual" + e);
			excepcionAccionesWeb(e);
		}
	}

	public static String getValue(String strValue) {
		String strDato = "";
		try {
			strDato = mapDatosCasoPrueba.get(strValue);
			return strDato;
		} catch (Exception e) {
			fail("Error: en la clase AccionesWeb, en el metodo getValue:" + e);
			
		}

		return strDato;
	}

	/**
	 * Metodo que escribe una observación para el proceso de agendamiento
	 * 
	 * @param xpath lista de objetos
	 * @param dato  texto que contiene el objeto
	 */
	public void escribirObservacionAgendamiento(Boolean dato, By element) {
		try {
			if (Boolean.TRUE.equals(dato) && !getValue("observacion_agenda").equalsIgnoreCase(IGNORE)) {
				WebElementFacade dropbox = element(element);
				waitFor(dropbox).sendKeys(getValue("observacion_agenda"));
			}
		} catch (Exception e) {
			logger.error(
					"ERROR: en la clase CapturaPospagoNuevoPageObject, en el metodo escribirObservacionAgendamiento");
			fail("ERROR: en la clase CapturaPospagoNuevoPageObject, en el metodo escribirObservacionAgendamiento: "
					+ e);
		}
	}

	/**
	 * Método de una aserción la cual valida que con
	 * 
	 * @param mensaje
	 * @param elemet
	 * @param textoaComparar
	 */
	public void validarTextoDeUnElemetoContieneTexto(By elemet, String textoaComparar) {
		try {
			String textoElemet = element(elemet).getText();
			Serenity.takeScreenshot();
			assertTrue(textoElemet, containsText(textoaComparar));
		}catch(Exception e) {
			logger.error("en la clase AccionesWeb en el metodo validarTextoDeUnElemetoContieneTexto " + e);
			excepcionAccionesWeb(e);
		}
	}
	
	public void validarTextoDeUnElemeto(By elemet, String textoaComparar) {
		try {
			String textoElemet = element(elemet).getText();
			Serenity.takeScreenshot();
			assertTrue(textoaComparar, containsText(textoElemet));
		}catch(Exception e) {
			logger.error("en la clase AccionesWeb en el metodo validarTextoDeUnElemeto " + e);
			excepcionAccionesWeb(e);
		}
	}

	
	public void validarTextoDeUnElemetoModificacion(By elemet, String textoaComparar) {
		try {
			String textoElemet = element(elemet).getText();
			if(UtilDatos.getPais().equals("CO")) {
				String[] parts = textoElemet.split("LA");
				 textoElemet = parts[0];
				String[] parts1 = textoaComparar.split(",");
				 textoaComparar = parts1[0];	
			}					
			Serenity.takeScreenshot();
			assertTrue(textoaComparar, containsText(textoElemet));
		}catch(Exception e) {
			logger.error("en la clase AccionesWeb en el metodo validarTextoDeUnElemeto " + e);
			excepcionAccionesWeb(e);
		}
	}

	/**
	 * Método de una aserción la cual valida que el elemeto contenga un texto
	 * 
	 * @param mensaje
	 * @param elemet
	 * @param textoaComparar
	 */
	public void validarTextoDeUnElemetoContieneTexto(By elemet, String textoaComparar, String mensaje) {
		try {
			String textoElemet = element(elemet).getText();
			Serenity.takeScreenshot();
			assertTrue(mensaje, textoElemet.contains(textoaComparar));
		}catch(Exception e) {
			logger.error("en la clase AccionesWeb en el metodo validarTextoDeUnElemetoContieneTexto " + e);
			excepcionAccionesWeb(e);
		}
	}


	/**
	 * Método de una aserción la cual valida que el elemento este visible
	 * 
	 * @param mensaje
	 * @param elemet
	 * @param textoaComparar
	 */
	public void validarElementoEsteVisible(By elemet, String mensaje) {

		Serenity.takeScreenshot();
		assertTrue(mensaje, element(elemet).isCurrentlyVisible());

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
	 * Metodo diseñado para extraer el value de un elemento
	 * 
	 * @param webElemet elemento al que se requiere extraerle el texto
	 * @return retorna el texto extraido del elemento
	 */
	public String extraerValuedeLabel(By element) {
		try {
			if (element(element).isCurrentlyVisible() && element(element).isCurrentlyEnabled()) {
				WebDriverWait wait = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
				wait.until(ExpectedConditions.elementToBeClickable(element));
				return element(element).getTextValue().toString();
			}
			return "";
		} catch (Exception e) {
			logger.error("en la clase AccionesWeb en el metodo extraerValuedeLabel" + e);
			excepcionAccionesWeb(e);
		}
		return null;
	}
	
	/**
	 * Metodo diseñado para extraer el value de un elemento seleccionado
	 * 
	 * @param webElemet elemento al que se requiere extraerle el texto
	 * @return retorna el texto extraido del elemento seleccionado
	 */
	public String extraerValuedeSelected(By element) {
		try {
			if (element(element).isCurrentlyVisible() && element(element).isCurrentlyEnabled()) {
				WebDriverWait wait = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
				wait.until(ExpectedConditions.elementToBeClickable(element));
				return element(element).getSelectedVisibleTextValue();
			}
			return "";
		} catch (Exception e) {
			logger.error("en la clase AccionesWeb en el metodo extraerValuedeSelec" + e);
			excepcionAccionesWeb(e);
		}
		return null;
	}


	/**
	 * Metodo alternativo para extraer el value de un elemento
	 * 
	 * @param webelement elemento al que se quiere extraer el texto
	 * @return retorna el value extraido del elemento
	 */
	public String obtenerValorXpath(By element) {
		int iteracion = 0;
		while (iteracion < 5) {
			iteracion++;
			try {
				waitForRenderedElementsToBePresent(element);
				String strValor = "";
				strValor = find(element).getValue();
				return strValor;
			} catch (Exception e) {
				logger.error("en la clase AccionesWeb en el metodo obtenerValorXpath" + e);
				excepcionAccionesWeb(e);
			}
		}
		return null;
	}

	/**
	 * Método que toma evidencia y genera el fallo
	 * 
	 * @param mensaje de la razon del fallo
	 */
	public void tomarEvidenciaFallo(String mensaje) {
		tomarEvidencia();
		logger.error(mensaje);
		fail(mensaje);

	}

	/**
	 * Metodo que confirma si un elemento esta habilitado retornando un true o un
	 * false si no lo esta
	 * 
	 * @param element elemento a confirmar
	 * @return si el elemento esta habilitado devuelve un true, de lo contrario un
	 *         false
	 */
	public boolean confirmarElementoHabilitado(By element) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), ESPERA_TIEMPO_FIJO_CORTO);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			if (element(element).isEnabled())
				return true;
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	/**
	 * Metodo diseñado para saber la cantidad de elementos existentes por un xpath
	 * general
	 * 
	 * @param elementXpath ruta del xpath general
	 * @return retorna el numero de elementos
	 */
	public int obtenerCantidadDeElementosPorXpath(By elementXpath) {
		try {
			
			WebDriverWait wait = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
			wait.until(ExpectedConditions.visibilityOfElementLocated(elementXpath));
			List<WebElement> elementos = getDriver().findElements(elementXpath);
			return elementos.size();
		} catch (Exception e) {
			logger.error("en la clase AccionesWeb en el metodo obtenerCantidadDeElementosPorXpath" + e);
			excepcionAccionesWeb(e);
			return 0;
		}
	}

	/**
	 * Metodo para poder usar el logger desde cualquier clase que instancie
	 * AccionesWeb
	 * 
	 * @return retorna el objeto Logger
	 */
	public Logger getLogger() {
		return logger;
	}

	public String fechaNacimientoMayorEdad() {
		Date fecha = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(FORMATO_FECHA);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.YEAR, -21);

		return formatter.format(calendar.getTime());

	}

	/**
	 * Este metodo genera la fecha del dia actual
	 * 
	 * @return retorna la fecha en el formato dd/MM/yyyy
	 */
	public String generarFecha() {
		Date fecha = new Date();
		String strDateFormat = FORMATO_FECHA;
		SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
		logger.info(String.valueOf(objSDF.format(fecha)));
		return String.valueOf(objSDF.format(fecha));
	}

	/**
	 * Método que aumenta los días, meses o años de una fecha inicial y retorna un
	 * string con la fecha en el formato dd/MM/yyyy
	 * 
	 * @param fecha         String de la fecha a aumentar días debe ingresar con el
	 *                      formato dd/MM/yyyy
	 * @param aumentarDias  si el número es diferente de 0 aumenta la cantidad de
	 *                      dias determinado
	 * @param aumentarMeses si el número es diferente de 0 aumenta la cantidad de
	 *                      meses determinado
	 * @param aumentarAnios si el número es diferente de 0 aumenta la cantidad de
	 *                      años determinado
	 * @return fechaCambiada retorna la fecha en el formato dd/MM/yyyy
	 */
	public String aumentarFecha(String fecha, int aumentarDias, int aumentarMeses, int aumentarAnios) {
		try {

			SimpleDateFormat objSDF = new SimpleDateFormat(FORMATO_FECHA);

			String[] fechaACambiar = fecha.split("/");
			Calendar fechaNueva = Calendar.getInstance();
			fechaNueva.set(Integer.parseInt(fechaACambiar[2]), Integer.parseInt(fechaACambiar[1]) - 1,
					Integer.parseInt(fechaACambiar[0]));
			fechaNueva.add(Calendar.DAY_OF_YEAR, aumentarDias);
			fechaNueva.add(Calendar.MONTH, aumentarMeses);
			fechaNueva.add(Calendar.YEAR, aumentarAnios);
			return String.valueOf(objSDF.format(fechaNueva.getTime()));

		} catch (Exception e) {
			logger.error("en la clase AccionesWeb en el metodo aumentarFecha" + e);
			fail("en la clase AccionesWeb en el metodo aumentarFecha" + e);
			return null;
		}
	}

	/**
	 * Metodo que confirma si un elemento esta seleccionado retornando un true o un
	 * false si no lo esta
	 * 
	 * @param element elemento a confirmar
	 * @return si el elemento esta seleccionado devuelve un true, de lo contrario un
	 *         false
	 */
	public boolean confirmarElementoSeleccionado(By element) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), ESPERA_TIEMPO_FIJO_CORTO);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			if (element(element).isSelected())
				return true;
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	/**
	 * Metodo que selecciona una opcion de un select con un index
	 * 
	 * @param select    el elemento a seleccionar
	 * @param stgOpcion el numero de la opcion
	 */
	public void seleccionarOpcionIndex(By select, int stgOpcion) {
		try {
			WebElementFacade dropbox = element(select);
			dropbox.selectByIndex(stgOpcion);
		} catch (Exception e) {
			logger.error("en la clase AccionesWeb en el metodo seleccionarOpcionIndex" + e);
			excepcionAccionesWeb(e);
		}
	}
	
	
	/**
	 * Metodo que se le da click a un elemento de un dropdown que contenga parte de
	 * un texto
	 * 
	 * @param xpath select de los objetos a dar click
	 * @param dato  texto que contiene el objeto
	 */
	public void seleccionaOpcionContengaTexto(By xpath, String dato) {
		try {
			List<String> elemetos = element(xpath).getSelectOptions();
			
			WebDriverWait wait = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
			wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
			
			for (int i = 0; i < elemetos.size(); i++) {
				if (elemetos.get(i).contains(dato)) {
					element(xpath).selectByIndex(i);
					break;
				}
			}
		} catch (Exception e) {
			logger.error("en la clase AccionesWeb en el metodo seleccionaOpcionContengaTexto" + e);
			excepcionAccionesWeb(e);

		}

	}
	
	/**
	 * Metodo que valida si existe opciones en un elemento 	
	 * @param xpath
	 * @param dato
	 * @return true o false 
	 */
	public Boolean existeOpcion(By xpath, String dato) {
		
		Boolean blnResult = false;
		try {
			
			WebElementFacade dropbox = element(xpath);
			List<String> elementos = dropbox.getSelectOptions();

			for ( int i= 0; i< elementos.size(); i++) {
				if (elementos.get(i).trim().contains(dato)) {
					blnResult=true;
					break;
				}
			}
			
		} catch (Exception e) {
			logger.error("en la clase AccionesWeb en el metodo existeOpcion" + e);
			excepcionAccionesWeb(e);

		}
		
		return blnResult;

	}
	


	/**
	 * Metodo diseñado para dar click a un ckecBox
	 * 
	 * @param xpath direccion del elemento a dar click
	 */
	public void darClickCheckBox(By xpath) {
		try {
			esperoElementoVisible(xpath);
			element(xpath).click();
		}catch(Exception e) {
			logger.error("en la clase AccionesWeb en el metodo darClickCheckBox " + e);
			excepcionAccionesWeb(e);
		}
	}

	/**
	 * Metodo diseñado para validar un elemento
	 * 
	 * @param bandera este es el parametro que recibe el metodo de acuerdo al
	 *                elemento
	 */
	public void validarElemento(boolean bandera) {
		tomarEvidencia();
		assertTrue(bandera);
	}

	/**
	 * Metodo que edita el tiempo implisito predeterminado
	 * 
	 * @param intTime tiempo
	 */
	public void editaTiempoImplicito(int intTime) {
		setImplicitTimeout(intTime, ChronoUnit.SECONDS);
	}

	/**
	 * restaura el tiempo cambiado con el metodo editaTiempoImplicito
	 */
	public void restauraTiempoImplicitoPorDefecto() {
		resetImplicitTimeout();
	}

	/**
	 * Metodo diseñado para actualizar la pagina (simula un F5)
	 */
	public void actualizarPagina() {
		try {
			getDriver().navigate().refresh();
		}catch(Exception e) {
			logger.error("en la clase AccionesWeb en el metodo actualizarPagina " + e);
			excepcionAccionesWeb(e);
		}
	}

	/**
	 * Metodo diseñado para aceptar una alerta que contenga parte del mensaje
	 * enviado
	 * 
	 * @param String parte del mensaje de la alerta
	 */
	public void aceptarAlertaPorMensaje(String strMensajeAcertado) {
		int cont = 0;
		Alert alert;
		boolean banderaAlerta = false;
		String mensaje = "";
		WebDriverWait wait = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
		while ((!banderaAlerta) && (cont < 3)) {
			try {
				if (wait.until(ExpectedConditions.alertIsPresent()) != null) {
					alert = getDriver().switchTo().alert();
					if (alert.getText().contains(strMensajeAcertado)) {
						alert.accept();
					} else {
						mensaje = alert.getText();
						alert.dismiss();
						logger.error("Alerta Cancelada");
						Assert.fail("Error en alerta: " + mensaje);
					}
					banderaAlerta = true;
				}
				if ((cont >= 3) && (!banderaAlerta)) {
					Assert.fail(" No se encontro alerta con mensaje " + strMensajeAcertado);
				}
			} catch (Exception e) {
				logger.error(" No se encontro alerta con mensaje " + strMensajeAcertado);
				cont++;
			}
		}
	}

	/**
	 * Metodo que obtiene el costo de la solicitud
	 * 
	 * @param xpath select de los objetos a dar click
	 * @param dato  texto que contiene el objeto
	 */
	public String obtenerFormatoCosto(String dato) {
		try {
			String strDato = dato.replace(",", "");
			StringBuilder strValor = new StringBuilder(strDato);
			while (strValor.length() < 7) {
				strValor.insert(0, "0");
			}
			logger.info(strValor.toString());
			return strValor.toString();
		} catch (Exception e) {
			logger.info("ERROR: en la clase AccionesWeb, en metodo obtenerFormatoCosto: " + e);
			excepcionAccionesWeb(e);
		}
		return null;
	}

	/**
	 * Metodo para escribir Texto en un TXT
	 * 
	 * @param element  elemento a escribir
	 * @param strTexto texto que se va a escribir
	 */
	public void escribirArchivoTxt(String texto, String path) {
		try (FileWriter fileWriter = new FileWriter(path)) {
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			PrintWriter pw = new PrintWriter(bufferedWriter);
			logger.info("Se escribe en txt Exitosamente");
			pw.write(texto);
			pw.close();
			bufferedWriter.close();
		} catch (Exception e) {
			logger.info("ERROR: en la clase AccionesWeb, en metodo escribirArchivoTxt: " + e);
			excepcionAccionesWeb(e);
		}
	}

	/**
	 * Metodo para generar fecha conciliacion
	 * 
	 * @param element  elemento a escribir
	 * @param strTexto texto que se va a escribir
	 */
	public String generarFechaConciliacion() {
		return new SimpleDateFormat("ddMMyyyy").format(new Date());
	}
	
	/**
	 * Metodo que cambia de una ventana a otra 
	 * @param numVentanas
	 */
	public void cambiarVentana(int numVentanas) {
		WebDriverWait wait = new WebDriverWait(getDriver(), obtenerTiempoSerenity()); 
		wait.until(ExpectedConditions.numberOfWindowsToBe(numVentanas));
		if(getDriver().getWindowHandles().size()!=numVentanas) {
			Assert.fail("La ventana número "+numVentanas+" no se abrió");
		}
		ArrayList<String> ventanas = new ArrayList<>(getDriver().getWindowHandles());
		getDriver().switchTo().window(ventanas.get(numVentanas-1));
		getDriver().manage().window().maximize();
	}
	
	/**
	 * Metodo que cambia un frame por un elemento
	 * @param strXpath
	 */
	public void cambiarFramePorelemento (String strXpath) {
		getDriver().switchTo().frame(getDriver().findElement(By.xpath(strXpath)));
	}
	
	/**
	 * Metodo que valida si existe un elemento 
	 * @param xpath
	 * @return retorna false o true
	 */
	public Boolean chequearExistenciaElemento (By xpath) {
		Boolean respuesta = false;
		respuesta = getDriver().findElements(xpath).size() != 0;
		return respuesta;
	}
	
	/**
	 * Método para obtener el nombre de la excepción
	 * @param e Texto generado por la excepcion e
	 */
	private void excepcionAccionesWeb(Exception e) {
		String[]strException = e.getClass().getCanonicalName().replace(".", "-").split("-");
		ExceptionsProyecto.validaExcepcion(strException[strException.length-1]);
	}

	/**
	 * Método para dar click 
	 * @param boton elemento al que se quiere dar click
	 */
	public void darClickEnBotonEspecial(By boton) {
		try {
			withAction().moveToElement(getDriver().findElement(boton)).click().build().perform();
		} 
		catch (Exception e) {
			logger.info("ERROR: en la clase AccionesWeb, en metodo darClickEnBotonEspecial: " + e);
			excepcionAccionesWeb(e);
		}
	}
	public void darClickJavaScript(By boton) {
		try {
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",
	                getDriver().findElements((boton)).get(0));
		} 
		catch (Exception e) {
			logger.info("ERROR: en la clase AccionesWeb, en metodo darClickJavaScript: " + e);
			excepcionAccionesWeb(e);
		}
	
	}
	
	
	/**
	* Metodo para calcular el tiempo del serenity properties
	* @return retorna el tiempo en segundo del serenity
	*/
	public long obtenerTiempoSerenity() {
		return getImplicitWaitTimeout().getSeconds();
	}
	
	/**
	* Metodo para obtener url de aplicativo
	* @return url de aplicativo
	*/
	public String obtenerUrlAplicativo() {
		return getDriver().getCurrentUrl();
	}
	
    /**
     * Metodo que selecciona un frame generico para el pais de Peru 
     * @return retorna el frame 
     */
	public String seleccionarFrameGenerico() {
		
        String xpathGenerico = "";
        
        xpathGenerico = RetencionesPrepagoUI.getXpathFrameGenerico();
        if (UtilDatos.getPais().equals(UtilDatosEstaticos.PAIS_PE)) {
        	xpathGenerico = AsistenciaTecnicaUI.getXpathFrameGenericoEngage();
        }
        
        return xpathGenerico;		
	}
	
	 
	/**
	 * Metodo que espera que elemento se pueda slelecionar
	 * @param xpath del elemento 
	 * @return verdadero si es seleccionable
	 */
	public boolean esperoElementoSelect(By xpath) {

		try {
	
			esperoElementoVisible(xpath);
			
			if (element(xpath).isSelected())
				return true;
		} catch (Exception e) {

			logger.info("en la clase AccionesWeb en el metodo esperoElementoSelect" + e);

		}
		return false;

	}

	/**
	 * Metodo que valida que una lista contenga un dato 
	 * @param xpath elemento que se va a mapear
	 * @param dato a comparar si existe en la lista 
	 * @return
	 */
	public boolean validarListaContineDato(By xpath, String dato) {
		try {
            List<WebElement> elemetos = getDriver().findElements(xpath);            
			for (int i = 0; i < elemetos.size(); i++) {
			  if (elemetos.get(i).getText().trim().toLowerCase().contains(dato.trim().toLowerCase()))  {
					return true;
				}
			}
			return false;
		} catch (Exception e) {

			logger.error("en la clase AccionesWeb en el metodo validarListaContineDato" + e);
			excepcionAccionesWeb(e);
			return true;
		}
	}
}
