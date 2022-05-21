package regional.utilities;

import static org.junit.Assert.fail;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibm.icu.text.SimpleDateFormat;

import nl.flotsam.xeger.Xeger;


public class UtilDatosAleatorios {
	
	private UtilDatosAleatorios() {}
	
	private static Logger logger = LoggerFactory.getLogger(UtilDatosAleatorios.class);
	
	/**
	 * Método que obtiene un DNI aleatorio
	 * 
	 * @return int DNI aleatorio que se obtuvo
	 */
	public static int dniAleatorio() {
		SecureRandom random = new SecureRandom();	
		int min = 19000000;
		int max = 44500000;
		int range  = max-min+1;
		return random.nextInt(range)+ min;
	}
	/**
	 * Método que obtiene un DNI aleatorio 
	 * 
	 * @return retorna un String DNI aleatorio que se obtuvo
	 */
	public static String dniAleatorioT() {
		SecureRandom random = new SecureRandom();	
		int min = 19000000;
		int max = 44500000;
		int range  = max-min+1;
		int result = random.nextInt(range)+ min;
		return String.valueOf(result);
	}
	
	/**
	 * Metodo que obtiene un numero fijo Aleatorio
	 * @param prefijo
	 * @return retorna un String de Numero aleatorio
	 */
	public static String fijoAleatorioT(String prefijo) {
		SecureRandom random = new SecureRandom();	
		int min = 190000;
		int max = 445000;
		int range  = max-min+1;
		int result = random.nextInt(range)+ min;
		return prefijo + String.valueOf(result);
	}
	
	/**
	 * Metodo que obtiene un numero celular Aleatorio
	 * @param prefijo
	 * @return retorna un String de celular aleatorio
	 */
	public static String celAleatorioT(String prefijo) {
		SecureRandom random = new SecureRandom();	
		int min = 19000000;
		int max = 44500000;
		int range  = max-min+1;
		int result = random.nextInt(range)+ min;
		return prefijo + String.valueOf(result);
	}
	
	/**
	 * Metodo que obtiene un numero telefono Aleatorio
	 * @param prefijo
	 * @return retorna un String de Numero telefono aleatorio
	 */
	public static String obtenerNumeroTelefonoAleatorio(int prefijo, int tamanio) {
		String numeroTelefono = "";
		try {
		String expRegular = "[1-9]{"+tamanio+"}";
		Xeger generator = new Xeger(expRegular);
		numeroTelefono = prefijo + generator.generate();
		}
		catch (Exception e) {
		logger.error("ERROR: al generar numero de telefono: " + e);
		fail("ERROR: al generar numero de telefono: " + e);
		}
		return numeroTelefono;
		}
	
	/**
	 * Método que obtiene un dato de manera aleatoria de un archivo txt
	 * 
	 * @param String path donde se encuentra el archivo txt
	 * @return String del dato aleatorio que se obtuvo del archivo txt
	 */
	public static String obtenerDatoAleatorioTxt(String path) {
		try {
			List<String> arrDatosObtenido = UtilDatos.leerDatosTxt(path);
			Random rand = SecureRandom.getInstanceStrong();
			String datoAleatorio = arrDatosObtenido.get(rand.nextInt(arrDatosObtenido.size()));
			arrDatosObtenido.clear();
			return datoAleatorio;
		} 
		catch (Exception e) { 
			logger.error("ERROR: en la clase UtilDatosAleatorios, en el método obtenerDatoAleatorioTxt: " + e);
			fail("ERROR: en la clase UtilDatosAleatorios, en el método obtenerDatoAleatorioTxt: " + e);
		}
		return null;
	}
	
	/**
	 * Método que obtiene un número de celular de manera aleatoria
	 * 
	 * @return List<String> donde se almacena el prefijo y el número del celular aleatorios
	 */
	public static List<String> obtenerCelAleatorio(){
		List<String> celular = new ArrayList<>();
		String[] prefijo = { "300","301","302","304","305","310","311","312","313","314","320","323","350","354"};
		SecureRandom random = new SecureRandom();
		celular.add(obtenerAleatorio(prefijo));
		int min = 1000000;
		int max = 9999999;
		int range  = max-min+1;
		celular.add(Integer.toString(random.nextInt(range)+ min));
		return celular;
	}
	
	/**
	 * Método que obtiene un número de telefono de manera aleatoria
	 * 
	 * @return List<String> donde se almacena el prefijo y el número del telefono aleatorios
	 */
	public static List<String> obtenerTelAleatorio(){
		List<String> telefono = new ArrayList<>();
		SecureRandom random = new SecureRandom();
		String prefijo = Integer.toString(random.nextInt(9))+Integer.toString(random.nextInt(9));
		telefono.add(prefijo);
		int min = 10000000;
		int max = 99999999;
		int range  = max-min+1;
		telefono.add(Integer.toString(random.nextInt(range)+ min));
		return telefono;
	}
	
	/**
	 * Método que selecciona un dato de manera aleatoria de un arreglo
	 * 
	 * @param arrDatos arreglo de datos que se busca seleccionar uno
	 * @return datoAleatorio que se obtuvo
	 */
	public static String obtenerAleatorio(String[] arrDatos) {
		try {
			Random rand = SecureRandom.getInstanceStrong();
			String datoAleatorio = arrDatos[rand.nextInt(arrDatos.length)];
			logger.info("dato aleatorio: " + datoAleatorio);
			return datoAleatorio;
		} catch (Exception e) {
			logger.error("ERROR: en la clase AccionesWeb, en el metodo obtenerAleatorio: " + e);
			fail("ERROR: en la clase AccionesWeb, en el metodo obtenerAleatorio: " + e);
		}

		return null;
	}
	
	/**
	 * Metodo que genera numero aleatorio dependiendo del tamaño
	 * 
	 * @param tamanio
	 * @return
	 */
	public static int obtenerIntAleatorio(int tamanio) {
		try {
			Random aleatorio = SecureRandom.getInstanceStrong();
			return aleatorio.nextInt(tamanio);
		} catch (Exception e) {
			logger.error("ERROR: en la clase UtilidadesSDS en el metodo obtenerIntAleatorio: " + e);
			fail("ERROR: en la clase UtilidadesSDS, en el metodo obtenerIntAleatorio: " + e);
		}
		return 0;
	}
	
	/**
	 * Método para generar número aleatorio con un rango de 1 hasta el numero que se envie en 
	 * el parametro "tamanio"
	 * 
	 * @param tamanio
	 * @return
	 */
	public static int obtenerIntAleatorioRango(int tamanio) {
		SecureRandom random = new SecureRandom();	
		int min = 1;
		int max = tamanio;
		int range  = max-min+1;
		return random.nextInt(range)+ min;
	}
	
	/**
	 * Metodo que ontiene el año de vencimiento de la tarjeta de credito
	 * 
	 * @return año de vencimiento de la tarjeta
	 */
	public static String obtenerAnioVencimiento() {
		int timestamp = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));
		int anioVencimiento = timestamp + obtenerIntAleatorio(3) + 1;

		return String.valueOf(anioVencimiento);
	}
	
	/**
	 * Genera una tarjeta de crédito aleatorio
	 * 
	 * @param tipoTC Tipo de la tarjeta de credito AMEX,VISA,
	 * @return tarjeta
	 */
	public static String generarNumeroTC(String tipoTC) {

		try {
			
			String[] arrAmex = { "377795", "377777", "376632" };
			String[] arrVisa = { "424967", "492043","425822" };
			String[] arrMasterCard = { "531015", "522244","553494" };
			String[] arrDiners = { "360937"};

			String strExpTCVisaMaster = "[0-9]{9}";
			String strExpTCAmex = "[0-9]{8}";
			String strExpTCDiners = "[0-9]{7}";

			String tarjeta = null;
			switch (tipoTC) {
			case "AMEX":
				tarjeta = obtenerAleatorio(arrAmex) + obtenerDatoExpReg(strExpTCAmex);
				tarjeta = tarjeta + calcularDigitoVerificacionTarjeta(tarjeta);
				break;

			case "VISA":
				tarjeta = obtenerAleatorio(arrVisa) + obtenerDatoExpReg(strExpTCVisaMaster);
				tarjeta = tarjeta + calcularDigitoVerificacionTarjeta(tarjeta);
				break;
			case "MASTERCARD":
				tarjeta = obtenerAleatorio(arrMasterCard) + obtenerDatoExpReg(strExpTCVisaMaster);
				tarjeta = tarjeta + calcularDigitoVerificacionTarjeta(tarjeta);
				break;
			case "DINERS":
				tarjeta = obtenerAleatorio(arrDiners) + obtenerDatoExpReg(strExpTCDiners);
				tarjeta = tarjeta + calcularDigitoVerificacionTarjeta(tarjeta);
				break;

			default:
				break;
			}
			logger.info("Numero generado para  la TC: " + tarjeta);

		
			return tarjeta;
		} catch (Exception e) {
			logger.info("ERROR: en la clase UtilidadesSDS, en metodo generarNumeroTC: " + e);
			fail("ERROR: en la clase UtilidadesSDS, en el metodo generarNumeroTC: " + e);

		}
		return null;
	}
	
	/**
	 * Método calculador del digito de verificación de la tarjeta basándose en el
	 * Algoritmo de luhn
	 * 
	 * @param numTarjeta
	 * @return digito
	 */
	private static String calcularDigitoVerificacionTarjeta(String numTarjeta) {
		try {
			if (numTarjeta == null)
				return null;
			String digito;
			int[] digitos = new int[numTarjeta.length()];
			for (int i = 0; i < numTarjeta.length(); i++) {
				digitos[i] = Character.getNumericValue(numTarjeta.charAt(i));
			}
			for (int i = digitos.length - 1; i >= 0; i -= 2) {
				digitos[i] += digitos[i];
				if (digitos[i] >= 10) {
					digitos[i] = digitos[i] - 9;
				}
			}
			int sum = 0;
			for (int i = 0; i < digitos.length; i++) {
				sum += digitos[i];
			}
			sum = sum * 9;
			digito = sum + "";
			return digito.substring(digito.length() - 1);
		} catch (Exception e) {
			logger.info("ERROR: en la clase UtilidadesSDS, en metodo calculaDigitoVerificador: " + e);
			fail("ERROR: en la clase UtilidadesSDS, en el metodo calculaDigitoVerificador: " + e);
		}
		return null;
	}
	
	/**

	 * Método que genera aleatoriamente un texto aleatorio dependiendo de la
	 * expresión regular
	 * 
	 * @param nombreExpresionRegular expresión regular

	 */
	public static String obtenerDatoExpReg(String nombreExpresionRegular) {
		try {
			Xeger generator = new Xeger(nombreExpresionRegular);
			return generator.generate();
		} catch (Exception e) {
			logger.error("ERROR: en la clase UtilidadesSDS, en el metodo obtenerDatoExpReg: " + e);
			fail("ERROR: en la clase UtilidadesSDS, en el metodo obtenerDatoExpReg: " + e);
		}
		return null;
	}
	
	/**
	 * Metodo que obtiene numero de cuenta 
	 * @return
	 */
	public static String obtenerNumeroCuenta() {
		
		String numeroCuenta = "";		
		try {
			
			numeroCuenta = String.valueOf(obtenerIntAleatorio(1000000000)) + "00000000000";
			numeroCuenta = numeroCuenta.substring(0,11);

		} catch (Exception e) {
			logger.error("ERROR: en la clase UtilidadesSDS, en el metodo obtenerNumeroCuenta: " + e);
			fail("ERROR: en la clase UtilidadesSDS, en el metodo obtenerNumeroCuenta: " + e);
		}
		return numeroCuenta;
	}
	
	/**
	 * Método que obtiene un tipo de categoria principal
	 * 
	 * @return List<String> donde se almacena la lista de elementos presentes en el select
	 */
	public static List<String> obtenerCategoriaAleatoria(){
		List<String> categoria = new ArrayList<>();
		String[] lista = { "Abono","Adicionales","Programacion"};
		categoria.add(obtenerAleatorio(lista));
		return categoria;
	}
	
	/**
	 * Método que obtiene un tipo de categoria para realizar el proceso de derivacion de un PQR
	 * 
	 * @return List<String> donde se almacena la lista de elementos presentes en el select
	 */
	public static List<String> obtenerCategoriaDerivacionAleatoria(){
		List<String> categoriaDerivacion = new ArrayList<>();
		String[] lista = { "02-Equipamiento","03-Fidelización","04-Finanzas", "05-Instalación", "06-Programación y Productos", "07-Requerimientos Técnicos", "09-Seguridad de Señal", "10-Trámites Adm e Información Gral"};
		categoriaDerivacion.add(obtenerAleatorio(lista));
		return categoriaDerivacion;
	}
	
	/**
     * Método para generar número aleatorio con un rango de 1 hasta el numero que se
     * envie en el parametro "tamanio"
     *
     * @param tamanio
     * @return
     */
    public static int obtenerIntAleatorioRango(int minimo , int tamanio) {
        SecureRandom random = new SecureRandom();
        int max = tamanio;
        int range = max - minimo + 1;
        return random.nextInt(range) + minimo;
    }

}
