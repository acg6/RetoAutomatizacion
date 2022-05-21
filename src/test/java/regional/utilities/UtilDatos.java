package regional.utilities;

import static org.junit.Assert.fail;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class UtilDatos {
	
	private UtilDatos() {}
	
	private static String pais = "";
	private static String[] arrayConexionBd = new String[10];
	private static String ambiente ="";
	private static String clientePospago = "";
	private static String clientePrepago = "";
	private static String direccion = "";
	private static String telefono = "";
	private static String telefonoHogar = "";
	private static String telefonoTrabajo = "";
	private static String faxTelefono = "";
	private static String celular = "";
	private static String usuarioCorreo = "";
	private static String dominio = "";
	private static String dns = "";
	private static String dominioPais = "";
	
	private static final String ID_FRAME_ACTIVIDAD = "Actividad";	
	private static final String SUPER_CATEGORIA = "Reclamos 1ra linea / escalamiento normal";
	private static final String MOTIVO_ENVIO_DE_CONTROL_REMOTO="Control Remoto";
	private static final String SUBMOTIVO_ENVIO_DE_CONTROL_REMOTO="Falla Control Remoto";
	private static final String MOTIVO_PROBLEMAS_IRD="Problemas IRD";
	private static final String SUBMOTIVO_PROBLEMAS_IRD="IRD No Enciende";
	private static final String OPCION_ASISTENCIA_TECNICA="Asistencia Tecnica";
	private static final String OPCION_FALLAS_EQUIPO="Fallas Equipos/Productos";
	private static final String OPCION_SERVICE="SERVICE";
	private static final String MODIFICACION_TELEFONOS="Modificación de Teléfonos";
	private static final String MODIFICACION_DATOS="Modificar Datos";
	private static final String SELECCIONA_SUBMOTIVO="A petición del cliente";
	private static final String MODIFICACION_EMAIL="Modificación de Email";
	private static final String MODIFICACION_DIRECCIONES="Modificación De Direcciones";
	private static final String MUDANZA_CON_WO="Mudanza con WO";
	private static final String USUARIO_CORREO="testing";
	private static final String SET_DOMINIO="directv";
	private static final String SET_DNS=".com";
	private static final String WORK_ORDER_CONTROL_REMOTO="L34-Entrega Control Remoto / Cable HDMI";
	private static final String WORK_ORDER_IRD="S06-Problemas del IRD";
	
	private static final String CLIENTE = "Cliente";
	private static final String WINBACK = "WinBack";
	private static final String INFORMACION_CLIENTE = "informacion del cliente";
	
	private static final String OBSERVACION = "Robot Directv";
	private static final String INFORMACION = "No retenido";
	private static final String FRAME_ID = "link:ctl_";

	

	public static String getObservacion() {
		return OBSERVACION;
	}
	
	public static String getInformacion() {
		return INFORMACION;
	}
	
	public static String getFrameID() {
		return FRAME_ID;
	}

	public static String getCliente() {
		return CLIENTE;
	}
	
	public static String getInformacionCliente() {
		return INFORMACION_CLIENTE;
	}
	
	public static String getWinback() {
		return WINBACK;
	}
	
	public static String getAmbiente() {
		return ambiente;
	}
	
	public static String getUsuariCorreo() {
		return USUARIO_CORREO;
	}
	
	public static String getWorkOrderControlRemoto() {
		return WORK_ORDER_CONTROL_REMOTO;
	}
	
	public static String getUWorkOrderIRD() {
		return WORK_ORDER_IRD;
	}
	
	public static String getSetDominio() {
		return SET_DOMINIO;
	}
	
	public static String getSetDNS() {
		return SET_DNS;
	}

	public static void setAmbiente(String ambiente) {
		UtilDatos.ambiente = ambiente;
		UtilDatos.pais = ambiente.substring(0,ambiente.indexOf("-"));
	}
	

	/**
	 * Metodo para obtener un numero de datos de un archivo
	 * @param strPath
	 * @param strPalabraABuscar
	 * @param intCantidadLineas
	 * @return
	 */
	public static String[] obtenerConfig(String strPath,String strPalabraABuscar,int intCantidadLineas) {
		try {
			
			
			File file = new File(strPath);
			int cantidadDato=0;
			try(Scanner sc = new Scanner(file)){
				while  (sc.hasNextLine()) {					
					String linea=sc.nextLine();
					if(linea.contains(strPalabraABuscar)) {			 
						int encontrarIgual = linea.indexOf("=");
						arrayConexionBd[cantidadDato] = linea.substring(encontrarIgual+1).trim();
						cantidadDato++;
						if(cantidadDato==intCantidadLineas)
							return arrayConexionBd;	
					}									
				}				
			}
		} catch (Exception e) {
			fail("Error en la clase: DatabaseConnect, y el metodo: obtenerConfig, ERROR: " + e);
		}
		
		return arrayConexionBd;		
	}
	
	/**
	 * Metodo que lee un archivo  y extrae los datos
	 
	 * 
	 */
	
	public static String obtenerDireccion(String strDireccionABuscar) {

		String datoEncontrado = "";
		try {
			File file = new File("src/test/resources/archivos/Direcciones_reg.txt");
			try (Scanner sc = new Scanner(file)) {
				while (sc.hasNextLine()) {
					String linea = sc.nextLine();
					if (linea.contains(strDireccionABuscar)) {
						int encontrarIgual = linea.indexOf('=');
						datoEncontrado =linea.substring(encontrarIgual + 1).trim();
					}
				}
			}
		} catch (Exception e) {
			fail("Error en la clase: UtilDatos, y el metodo: obtenerDireccion, ERROR: " + e);
		}
		
		return datoEncontrado;
	}

	
	/**
	 * Método que lee un txt
	 * 
	 * @return List<String> donde se almacena el contenido del archivo txt
	 */
	public static List<String> leerDatosTxt(String path) {
		List<String> arrDatos = new ArrayList<>();
		try {
			File file = new File(path);
			try(Scanner sc = new Scanner(file)){
				while (sc.hasNextLine()) {
					String linea = sc.nextLine();
					arrDatos.add(linea);
				}
			}
			return arrDatos;			
		}catch(Exception e) {
			fail("Error en la clase: UtilDatos, y el metodo: obtenerDireccion, ERROR: " + e);
		}
		return arrDatos;
	}

	public static String getClientePospago() {
		return clientePospago;
	}

	public static String getClientePrepago() {
		return clientePrepago;
	}
	
	public static void setClientePospago(String clientePospago) {
		UtilDatos.clientePospago = clientePospago;
		
	}
	
	public static void setClientePrepago(String clientePrepago) {
		UtilDatos.clientePrepago = clientePrepago;
		
	}

	public static String getPais() {
		return pais;
	}

	public static void setPais(String pais) {
		UtilDatos.pais = pais;
	}

	public static String getDireccion() {
		return direccion;
	}

	public static void setDireccion(String direccion) {
		UtilDatos.direccion = direccion;
	}

	public static String getTelefono() {
		return telefono;
	}

	public static void setTelefono(String telefono) {
		UtilDatos.telefono = telefono;
	}

	public static String getTelefonoHogar() {
		return telefonoHogar;
	}
	
	public static void setTelefonoHogar(String telefonoHogar) {
		UtilDatos.telefonoHogar = telefonoHogar;
	}
	
	public static String getTelefonoTrabajo() {
		return telefonoTrabajo;
	}
	
	public static void setTelefonoTrabajo(String telefonoTrabajo) {
		UtilDatos.telefonoTrabajo = telefonoTrabajo;
	}
	
	public static String getCelular() {
		return celular;
	}

	public static void setCelular(String celular) {
		UtilDatos.celular = celular;
	}

	public static String getFaxTelefono() {
		return faxTelefono;
	}
	
	public static void setFaxTelefono(String faxTelefono) {
		UtilDatos.faxTelefono = faxTelefono;
	}
	public static String getUsuarioCorreo() {
		return usuarioCorreo;
	}

	public static void setUsuarioCorreo(String usuarioCorreo) {
		UtilDatos.usuarioCorreo = usuarioCorreo;
	}

	public static String getDominio() {
		return dominio;
	}

	public static void setDominio(String dominio) {
		UtilDatos.dominio = dominio;
	}

	public static String getDns() {
		return dns;
	}

	public static void setDns(String dns) {
		UtilDatos.dns = dns;
	}

	public static String getDominioPais() {
		return dominioPais;
	}

	public static void setDominioPais(String dominioPais) {
		UtilDatos.dominioPais = dominioPais;
	}

	/**
	 * Metodo que valida en que ambiente se esta ejecutando
	 * @return retorna el ambiente segun la condicion aceptada
	 */
	public static String getAmbienteSesamo() {
		String ambienteSesamo = "";
		if(getAmbiente().contains("DEVM-OCI")) {
			ambienteSesamo = "qam";
		}
		else if(getAmbiente().contains("DEVP-OCI")) {
			ambienteSesamo = "qcp";
		}
		else {
			ambienteSesamo = UtilDatos.getAmbiente().split("-")[1].toLowerCase();
		}

		return ambienteSesamo;
	}

	 /**
	  * Método que remplaza un string con unos datos almacenado en un mapa  
	 * @param mapDatosParaReemplazar mapa a remplazar los datos
	 * @param strJsonBody string a remplazar
	 * @return String remplazado
	 */
	public static String reemplazarMapEnString(Map<String, String> mapDatosParaReemplazar, String strJsonBody) {
      String jsonBodyNuevo;
     
      for (Map.Entry<String,String> entry : mapDatosParaReemplazar.entrySet()) {
          jsonBodyNuevo = strJsonBody.replace("#$" + entry.getKey(),mapDatosParaReemplazar.get(entry.getKey()));
          strJsonBody = jsonBodyNuevo;
      }
      return strJsonBody;
  }
	
	public static String getIdFrameActividad() {
		return ID_FRAME_ACTIVIDAD;
	}
	
	public static String getSuperCategoria() {
		return SUPER_CATEGORIA;
	}
	
	public static String getMotivoControlRemoto() {
		return MOTIVO_ENVIO_DE_CONTROL_REMOTO;
	}
	
	public static String getSubmotivoContronRemoto() {
		return SUBMOTIVO_ENVIO_DE_CONTROL_REMOTO;
	}
	
	public static String getMotivoProblemasIRD() {
		return MOTIVO_PROBLEMAS_IRD;
	}
	
	public static String getSubmotivoProblemasIRD() {
		return SUBMOTIVO_PROBLEMAS_IRD;
	}
	
	public static String getOpcionAsistenciaTecnica() {
		return OPCION_ASISTENCIA_TECNICA;
	}
	
	public static String getOpcionFallasEquipos() {
		return OPCION_FALLAS_EQUIPO;
	}
	
	public static String getOpcionService() {
		return OPCION_SERVICE;
	}
	
	public static String getModificacionTelefonos() {
		return MODIFICACION_TELEFONOS;
	}
	
	public static String getModificacionDatos() {
		return MODIFICACION_DATOS;
	}
	
	public static String getSeleccionaSubmotivo() {
		return SELECCIONA_SUBMOTIVO;
	}
	
	public static String getModificacionEmail() {
		return MODIFICACION_EMAIL;
	}
	
	public static String getModificacionDomicilio() {
		return MODIFICACION_DIRECCIONES;
	}
	
	public static String getModificacionConWO() {
		return MUDANZA_CON_WO;
	}
		
}
