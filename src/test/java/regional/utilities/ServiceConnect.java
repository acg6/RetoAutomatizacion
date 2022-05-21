package regional.utilities;

import java.io.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.response.Response;
import io.restassured.http.Header;
import net.serenitybdd.rest.SerenityRest;
import exceptions.ExceptionsProyecto;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.Map;


public class ServiceConnect {

	private static final String GRAPHQL_URL = "https://sesamo.dtvpan.com:8443/graphql";
	private static final String SERVICE_PATH= "src/test/resources/archivos/Servicios/";
	private Response response;
	private Logger logger = LoggerFactory.getLogger(ServiceConnect.class);
	private static final String CONSULTA_NO_ENCONTRO_INFORMACION_COMENTARIO = "La consulta de sesamo no encontro ninguna informacion del Customer, la consulta respondio: ";
	private static final String CONSULTA_NO_ENCONTRO_CLIENTE_COMENTARIO = "La consulta sesamo no encontro ningun Customer para el caso, respondio: ";
	private static final String CUSTOMER = "customers";
	private static final String PAIS = "#$pais";
	private static final String AMBIENTE = "#$ambiente";
	private static final String CONTENT_TYPE = "Content-type";
	private static final String APPLICATION_JSON = "application/json";
	private static final String GRAPHQL = ".graphql";
	private static final String SESAMO = "sesamo";
	private static final String STR_AUTHORIZATION_SESAMO="Authorization";
	private static final String STR_AUTHORIZATION_SESAMO_CONTRASENA="Basic cGV0ZXI6cGV0ZXI=";
	private static final String STR_FIND_LOYALTY_PROMOTION = "findLoyaltyPromotionForCustomer";
	/**
	 * Método que consulta el web service de sesamo para obtener un numero de documento de un cliente que cumpla con los parametros indicados
	 * @param ambiente
	 * @param pais
	 * @param strConsulta
	 * @throws IOException
	 */
	public void conexionDelServicoCostumer(String ambiente, String pais,  String strConsulta) throws IOException {

		File file = new File(SERVICE_PATH+strConsulta+GRAPHQL);
		String graphqlPayload = parseGraphql(file);
		String detailStatus = "";
		switch (pais) 
		{	
		case "uy":  
			detailStatus = "1";        
			break;
		case "pe":  
			detailStatus = "1";
			break;
		case "co":  
			detailStatus = "4";  
			break;
		default: 
			detailStatus = "1";
			break;
		}	
		graphqlPayload=graphqlPayload.replace(AMBIENTE, ambiente).replace(PAIS, pais).replace("#$detailStatus", detailStatus);
		logger.info(graphqlPayload);
		response= SerenityRest.given()
				.header(new Header(CONTENT_TYPE, APPLICATION_JSON)).header(new Header(STR_AUTHORIZATION_SESAMO, STR_AUTHORIZATION_SESAMO_CONTRASENA))
				.body(graphqlPayload)
				.when()
				.post(new URL(GRAPHQL_URL));
		response.then().statusCode(HttpStatus.SC_OK);

		ExceptionsProyecto.validaEnElServicioElResponseOK(GRAPHQL_URL,strConsulta, response.getStatusCode(), response.getStatusCode()==HttpStatus.SC_OK);

	}
	
	/**
	 * Método ejecuta la querry tipo graphql con Serenity Rest
	 * @param ambiente ambiente con el que se va a ejecutar la prueba
	 * @param pais pais con el que se va a ejecutar la prueba 
	 * @param strConsulta nombre de la consulta que debe estar ubicado en la ruta {@value #SERVICE_PATH}
	 * @param mapDatosParaReemplazar datos a remplazar en la consulta de graphql
	 * @throws IOException excepción
	 */
	public void conexionDelServicoSesamo(String ambiente, String pais,  String strConsulta, Map<String, String> mapDatosParaReemplazar) throws IOException {

		File file = new File(SERVICE_PATH+strConsulta+GRAPHQL);
		String graphqlPayload = parseGraphql(file);
		
		graphqlPayload=graphqlPayload.replace(AMBIENTE, ambiente).replace(PAIS, pais);
		graphqlPayload = UtilDatos.reemplazarMapEnString(mapDatosParaReemplazar, graphqlPayload);
		
		logger.info(graphqlPayload);
		response= SerenityRest.given()
				.header(new Header(CONTENT_TYPE, APPLICATION_JSON)).header(new Header(STR_AUTHORIZATION_SESAMO, STR_AUTHORIZATION_SESAMO_CONTRASENA))
				.body(graphqlPayload)
				.when()
				.post(new URL(GRAPHQL_URL));
		response.then().statusCode(HttpStatus.SC_OK);

		ExceptionsProyecto.validaEnElServicioElResponseOK(GRAPHQL_URL,strConsulta, response.getStatusCode(), response.getStatusCode()==HttpStatus.SC_OK);

	}

	/**
	 * Metodo ejecuta la query para el servicio de cliente corporativo
	 * @param ambiente  ambiente con el que se va a ejecutar la prueba
	 * @param pais pais con el que se va a ejecutar la prueba 
	 * @param strConsulta nombre de la consulta que debe estar ubicado en la ruta {@value #SERVICE_PATH}
	 * @throws IOException
	 */
	public void conexionDelServicoCorporativo(String ambiente, String pais,  String strConsulta) throws IOException {
		File file = new File(SERVICE_PATH+strConsulta+GRAPHQL);
		String graphqlPayload = parseGraphql(file);
		String segId = "";
		String agreementTypeInput = "";
		if(pais.equals("cl")) {
			segId = "67,68,69,70";
			agreementTypeInput = "24,25";
		}else {
			segId = "65,66,67,68";
			agreementTypeInput = "17,18";
		}
		graphqlPayload=graphqlPayload.replace(AMBIENTE, ambiente).replace(PAIS, pais).replace("#$segId", segId).replace("#$agreementTypeInput", agreementTypeInput);
		logger.info(graphqlPayload);
		response= SerenityRest.given()
				.header(new Header(CONTENT_TYPE, APPLICATION_JSON)).header(new Header(STR_AUTHORIZATION_SESAMO, STR_AUTHORIZATION_SESAMO_CONTRASENA))
				.body(graphqlPayload)
				.when()
				.post(new URL(GRAPHQL_URL));
		response.then().statusCode(HttpStatus.SC_OK);

		ExceptionsProyecto.validaEnElServicioElResponseOK(GRAPHQL_URL,strConsulta, response.getStatusCode(), response.getStatusCode()==HttpStatus.SC_OK);


	}

	/**
	 * Método que consulta el web service de Costumer Poswinback y tambien aplica para cliente corporativo
	 * @param ambiente ambiente el el que se va a ejecutar
	 * @param pais     pais donde se va a ejecutar
	 * @param strConsulta  nombre de la query
	 * @throws IOException
	 */
	public void conexionDelServicoCorporativoYPoswinback(String ambiente, String pais,  String strConsulta) throws IOException {
		try {
			File file = new File(SERVICE_PATH+strConsulta+GRAPHQL);
			String graphqlPayload = parseGraphql(file);
			graphqlPayload=graphqlPayload.replace(AMBIENTE, ambiente).replace(PAIS, pais);
			logger.info(graphqlPayload);
			response= SerenityRest.given()
					.header(new Header(CONTENT_TYPE, APPLICATION_JSON)).header(new Header(STR_AUTHORIZATION_SESAMO, STR_AUTHORIZATION_SESAMO_CONTRASENA))
					.body(graphqlPayload)
					.when()
					.post(new URL(GRAPHQL_URL));
			response.then().statusCode(HttpStatus.SC_OK);

			ExceptionsProyecto.validaEnElServicioElResponseOK(GRAPHQL_URL,strConsulta, response.getStatusCode(), response.getStatusCode()==HttpStatus.SC_OK);
		}
		catch (Exception e) {
			ExceptionsProyecto.lanzarExcepcionCunsultaDataServicios(SESAMO, e.getClass().getSimpleName(),e.getMessage());
		}
	}
	
	/**
	 * Método para estraer la información obtenida en un response
	 * @param strDatoAExtraer
	 * @return
	 */
	public String consultaCostumerGraph(String strDatoAExtraer ) {
		logger.info(response.jsonPath().getString("data.customers.ibsCustomer.id"));
		ExceptionsProyecto.validaLaCondicion(CONSULTA_NO_ENCONTRO_INFORMACION_COMENTARIO+response.asString(), !JsonParser.parseString(response.asString()).getAsJsonObject().getAsJsonObject("data").get(CUSTOMER).isJsonNull());
		ExceptionsProyecto.validaLaCondicion(CONSULTA_NO_ENCONTRO_CLIENTE_COMENTARIO+response.asString(), JsonParser.parseString(response.asString()).getAsJsonObject().getAsJsonObject("data").getAsJsonArray(CUSTOMER).size()!=0);
		return response.jsonPath().getString("data.customers.ibsCustomer."+strDatoAExtraer+".");

	}

	  /**
     * Metodo para convertir dato tipo File a String
     * @param file dato de tipo file donde se encuentra el archivo con su respectivo nombre
     * @return retorna lo que contiene el archivo como String
     */
	public static String parseGraphql(File file) throws IOException {
		String graphqlFileContent = convertInputStreamToString(new FileInputStream(file));
		return convertToGraphqlString(graphqlFileContent);
	}
	
	/**
	 * Método que convierte los datos obtenidos en un graphql a un String
	 * @param graphql
	 * @return
	 * @throws JsonProcessingException
	 */
	private static String convertToGraphqlString(String graphql) throws JsonProcessingException {
		ObjectMapper oMapper = new ObjectMapper();
		ObjectNode oNode = oMapper.createObjectNode();
		oNode.put("query", graphql);
		return oMapper.writeValueAsString(oNode);
	}
	
	/**
	 * Método que convierte los datos obtenidos en un inputStream en un String
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	private static String convertInputStreamToString(InputStream inputStream) throws IOException {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				sb.append(line).append("\n");
			}
		}
		return sb.toString();
	}

	/**
	 * Metodo que extrae la cantidad de clientes consultados 
	 * @param tipoconsulta
	 * @return
	 */
	public int extraeCantidadDeClientesConsultados(String tipoconsulta) {
		try {
			JsonArray jsondeviceSameStatusIbsOscm = null ;
			JsonObject jsonResponse =  JsonParser.parseString(response.asString()).getAsJsonObject();
			if(tipoconsulta.contains(STR_FIND_LOYALTY_PROMOTION)) {
				jsondeviceSameStatusIbsOscm = jsonResponse.getAsJsonObject("data").getAsJsonArray(STR_FIND_LOYALTY_PROMOTION);
			}else {
				jsondeviceSameStatusIbsOscm = jsonResponse.getAsJsonObject("data").getAsJsonArray(CUSTOMER);
			}
			
			return jsondeviceSameStatusIbsOscm.size();
		} catch (Exception e) {
			
			return 0;
		}
	}

	/**
	 * Metodo que extrae la informacion del cliente consultada
	 * @param dato
	 * @return
	 */
	public String[] extraInformacionDelCliente(int dato) {
		try {
			String[] infomacionCliente = new String[3];
			JsonObject jsonResponse =  JsonParser.parseString(response.asString()).getAsJsonObject();
			infomacionCliente[0] = jsonResponse.getAsJsonObject("data").getAsJsonArray(STR_FIND_LOYALTY_PROMOTION).
					get(dato).getAsJsonObject().getAsJsonObject("ibsCustomer").getAsJsonObject("ibsCustomer").
					getAsJsonPrimitive("id").getAsString();
			infomacionCliente[1] = jsonResponse.getAsJsonObject("data").getAsJsonArray(STR_FIND_LOYALTY_PROMOTION).
					get(dato).getAsJsonObject().getAsJsonObject("responseMetadataTypeFindLoyalty").
					getAsJsonPrimitive("returnMessage").getAsString();
			return infomacionCliente;
		} catch (Exception e) {
			
			ExceptionsProyecto.lanzarExcepcionCunsultaDataServicios(SESAMO, e.getClass().getSimpleName(),e.getMessage());
			return new String[0];
		}
	}

	
}
