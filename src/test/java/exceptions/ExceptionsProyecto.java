package exceptions;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.serenitybdd.core.exceptions.TestCompromisedException;


public class ExceptionsProyecto {

	private ExceptionsProyecto() {
		//constructor
	}

	private static final String ELEMENT_CLICK_INTERCEPTED_COMENTARIO = "No se pudo clickear el elemento porque estaba oculto  ";
	private static final String ELEMENT_NOT_SELECTABLE_COMENTARIO = "El elemento está deshabilitado, no se puede hacer clic o seleccionar  ";
	private static final String ELEMENT_NOT_VISIBLE_COMENTARIO = "El elemento no es visible y, por lo tanto, no se puede interactuar con él.  ";
	private static final String ELEMENT_NOT_INTERACTABLE_COMENTARIO = "El elemento estaba presente pero se encuentra en un estado en el que no se puede interactuar con el  ";
	private static final String INVALID_ELEMENT_STATE_COMENTARIO = "El elemento está oculto por otro elemento o no es visible en la ventana actual  ";
	private static final String STATE_ELEMENT_REFERENCE_COMENTARIO = "El elemento pertenece a un frame diferente al actual  ";
	private static final String TIME_OUT_COMENTARIO = "El elemento no se mostró en el tiempo establecido  ";
	private static final String SCRIPT_TIMEOUT_EXCEPTION_COMENTARIO = "El comando no se pudo ejecutar en el tiempo establecido ";
	private static final String NO_SUNCH_FRAME_COMENTARIO = "Se presentó un problema al intentar cambiar de frame";
	private static final String NO_SUCH_ELEMENT = "El webdriver no pudo determinar el elemento durante el tiempo de ejecución ";
	private static final String NO_ALERT_PRESENT_EXCEPTION_COMENTARIO = "Se esta intentando acceder a una alerta que no se encuentra disponible";
	private static final String STR_NULLPOINTEREXCEPTION= "NullPointerException";
	private static final String STR_ASSERTIONERROR= "Error al realizar la consulta a la BD";
	private static final String STR_INDEX_OUT_OF_BOUNDS_EXCEPTION = "IndexOutOfBoundsException";
	private static final String STR_ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION = "ArrayIndexOutOfBoundsException";
	private static final String STR_CLASS_CAST_EXCEPTION = "ClassCastException";
	private static final String STR_RUN_TIME_EXCEPTION = "RuntimeException";
	private static final String STR_TEST_COMPROMISED_EXCEPTION = "TestCompromisedException";
	private static final String MENSAJE_ERROR_POR_CONSULTA_ARRAY =", se está intentando consultar un parámetro está fuera de rango en un arreglo o lista ";
	private static final String STR_MENSAJE_EXEPCION_NO_ENCONTRADA = " estatus no detectado contactar con el Automatizador ";


	private static final String COD_400 = "Solicitud incorrecta";
	private static final String COD_401 = "No autorizado";
	private static final String COD_403 = "Sin permisos";
	private static final String COD_404 = "No encontro contenido";
	private static final String COD_409 = "Conflicto";
	private static final String COD_500 = "Error de servidor interno";
	private static final String COD_503 = "Servicio no disponible";
	private static final String MENSAJE_SIN_DATOS_SESAMO = "Consulta de cliente NO trae resultados";
	private static final Logger logger = LoggerFactory.getLogger(ExceptionsProyecto.class);


	public static void validaExcepcion(String strExcepcion) {
		switch(strExcepcion) {
		case "ElementClickInterceptedException" :
			lanzarExcepcion(ELEMENT_CLICK_INTERCEPTED_COMENTARIO);
			break;
		case "ElementNotSelectableException":
			lanzarExcepcion(ELEMENT_NOT_SELECTABLE_COMENTARIO);
			break;
		case "ElementNotVisibleException":
			lanzarExcepcion(ELEMENT_NOT_VISIBLE_COMENTARIO);
			break;
		case "ElementNotInteractableException":
			lanzarExcepcion(ELEMENT_NOT_INTERACTABLE_COMENTARIO);
			break;
		case "InvalidElementStateException":
			lanzarExcepcion(INVALID_ELEMENT_STATE_COMENTARIO);
			break;
		case "StaleElementReferenceException":
			lanzarExcepcion(STATE_ELEMENT_REFERENCE_COMENTARIO);
			break;
		case "TimeoutException":
			lanzarExcepcion(TIME_OUT_COMENTARIO);
			break;
		case "ScriptTimeoutException":
			lanzarExcepcion(SCRIPT_TIMEOUT_EXCEPTION_COMENTARIO);
			break;
		case "NoSuchFrameException":
			lanzarExcepcion(NO_SUNCH_FRAME_COMENTARIO);
			break;
		case "NoSuchElementException":
			lanzarExcepcion(NO_SUCH_ELEMENT);
			break;
		case "NoAlertPresentException":
			lanzarExcepcion(NO_ALERT_PRESENT_EXCEPTION_COMENTARIO);
			break;
		default:
			fail(strExcepcion + " Se presento un problema inesperado");
			break;
		}
	}

	/**
	 * Metodo el cual valida la conexion y el resultado obtenido al consulta una BD
	 * @param strMensaje mensaje de la excepción
	 */

	public static void validaExcepcionConsultas(String strExcepcion) {
		switch(strExcepcion) {
		case STR_NULLPOINTEREXCEPTION:			
			lanzarExcepcion(STR_NULLPOINTEREXCEPTION);
			break;
		case "AssertionError":
			lanzarExcepcion(STR_ASSERTIONERROR);
			break;
		case "SQLServerException":
			lanzarExcepcion("Presento un error en la conexión a la base de datos");
			break;
		default:
			fail(strExcepcion + " Se presento un problema inesperado");
			break;
		}
	}




	public static void validaEnElServicioElResponseOK(String strURL,String tipodeServicio, int strResponse, Boolean condicion) {
		assertTrue("Para el servicio "+tipodeServicio+" con la url "+ strURL+" se esperaba un <200> pero la respuesta fue <"
				+strResponse+">"+" ("+tiposEstadosServicios(strResponse)+")" , condicion);
	}
	private static String  tiposEstadosServicios(int response) {
		String strMensaje = "";
		switch (response) {
		case 400:
			strMensaje = COD_400;
			break;
		case 401:
			strMensaje = COD_401;
			break;
		case 403:
			strMensaje = COD_403;
			break;
		case 404:
			strMensaje = COD_404;
			break;
		case 409:
			strMensaje = COD_409;
			break;
		case 500:
			strMensaje = COD_500;
			break;
		case 503:
			strMensaje = COD_503;
			break;
		default:
			strMensaje = "estatus no detectado contactar con el Automatizador";
			break;
		}
		return strMensaje;
	}


	public static void lanzarExcepcion(String strMensaje) {
		fail(strMensaje);
	}

	public static void validaLaCondicion(String strMensaje,Boolean condicion) {
		assertTrue(strMensaje, condicion);
	}

	/**
	 * Método que lanza excepción cuando hay algun error en la data que devuelve un servicio
	 * @param error error que se presenta
	 * @param tipoError tipo del error
	 * @mensajeExcepcion mensaje que va a mostrar la excepcion
	*/
	public static void lanzarExcepcionCunsultaDataServicios(String error, String tipoError,String mensajeExcepcion) {

		switch (tipoError) {
		case STR_ASSERTIONERROR:
			lanzarExcepcion(error);
			break;
		case STR_INDEX_OUT_OF_BOUNDS_EXCEPTION:
			lanzarExcepcion(error+MENSAJE_ERROR_POR_CONSULTA_ARRAY);
			break;
		case STR_NULLPOINTEREXCEPTION:			
			lanzarExcepcion(error+" se está intentando consultar un parámetro que no está o tiene otro nombre \n  el mensaje de la excepción,"+tipoError+": "+mensajeExcepcion);
			break;
		case STR_ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION:
			lanzarExcepcion(error+MENSAJE_ERROR_POR_CONSULTA_ARRAY);
			break;
		case STR_CLASS_CAST_EXCEPTION:
			lanzarExcepcion(error+" se está intentando consultar un parámetro en la respues que es otro tipo Json \n  el mensaje de la excepción"+tipoError+" :"+mensajeExcepcion);				
			break;
		case STR_RUN_TIME_EXCEPTION:
			if(error.contains("sesamo"))
				excepcionComprometidoServicios("Problemas con la ejecución de servicio "+error);
			else
				lanzarExcepcion("Problemas con la ejecución de servicio " + error);
			break;
		case STR_TEST_COMPROMISED_EXCEPTION:
			excepcionComprometidoServicios(mensajeExcepcion);
			break; 
		default:
			lanzarExcepcion(error+"\n"+STR_MENSAJE_EXEPCION_NO_ENCONTRADA+tipoError+" "+mensajeExcepcion);

			break;
		}
	}


	/**
	 * Método que muestra el mensaje de fallo por data y genera el fallo en estado compromised 
	 * @param message se refiere al mensaje de la razon del fallo
	*/
	public static void excepcionComprometidoServicios(String message) {
		logger.error(message);
		throw new TestCompromisedException(message);
	}
	
	
	public static void verificarResultadoVacioConsultaCliente(String resultadoConsulta) {
		if(resultadoConsulta.equals("")){
			logger.error(MENSAJE_SIN_DATOS_SESAMO);
			ExceptionsProyecto.excepcionComprometidoServicios(MENSAJE_SIN_DATOS_SESAMO);
		}
	}
	
}
