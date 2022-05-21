package regional.utilities;

import static org.junit.Assert.fail;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import exceptions.ExceptionsProyecto;
import net.serenitybdd.core.pages.PageObject;

public class UtilConsulta extends PageObject {

	private ServiceConnect serviceConnect = new ServiceConnect();
	private Logger logger = LoggerFactory.getLogger(UtilConsulta.class);
	
	/**
	 * Método para verificar que la consulta a Sesamo haya sido efectiva
	 * @param strConsulta
	 */
	public void verificarConexionSesamo(String strConsulta) {
		try {
			serviceConnect.conexionDelServicoCostumer(
					UtilDatos.getAmbienteSesamo(), 
					UtilDatos.getAmbiente().split("-")[0].toLowerCase(),
					strConsulta);
		} catch (Exception e) {
			fail("Error en la clase: UtilConsulta en el metodo: verificarConexionSesamo, ERROR: " + e.getMessage());
		}
	}

	/**
	 * Obtiene un numero de cliente que cumpla con los parametros dados para realizar flujo de PospagoNormal
	 * @param ambiente
	 * @param pais
	 * @return
	 * @throws IOException
	 */
	public String extraeIdClientePospagoNormal(String ambiente, String pais) throws IOException{
			serviceConnect.conexionDelServicoCostumer(ambiente, pais, "ClientePospagoNormal");
			return serviceConnect.consultaCostumerGraph("id").replace("[", "").replace("]", "");
	}
	
	/**
	 * Obtiene un numero de cliente que cumpla con los parametros dados para realizar flujo de PospagoNormalBundle
	 * @param ambiente
	 * @param pais
	 * @return
	 * @throws IOException
	 * Creado por Alex Castaño
	 */
	public String extraeIdClientePospagoBundleTVNormal(String ambiente, String pais) throws IOException{
			serviceConnect.conexionDelServicoCostumer(ambiente, pais, "ClienteBundleNetYNetActivoPospago");
			return serviceConnect.consultaCostumerGraph("id").replace("[", "").replace("]", "");
	}
	/**
	 * Obtiene un numero de cliente que cumpla con los parametros dados para realizar flujo de PospagoNormalNetOnly
	 * @param ambiente
	 * @param pais
	 * @return
	 * @throws IOException
	 * Creado por Alex Castaño
	 */
	public String extraeIdClientePospagoOnlyNet(String ambiente, String pais) throws IOException{
			serviceConnect.conexionDelServicoCostumer(ambiente, pais, "ClienteOnlyNet");
			return serviceConnect.consultaCostumerGraph("id").replace("[", "").replace("]", "");
	}
	/**
	 * Obtiene un numero de cliente que cumpla con los parametros dados para realizar flujo de PospagoNormalNetOnly con producto cancelado
	 * @param ambiente
	 * @param pais
	 * @return
	 * @throws IOException
	 * Creado por Alex Castaño
	 */
	public String extraeIdClientePospagoOnlyNetCancelado(String ambiente, String pais) throws IOException{
			serviceConnect.conexionDelServicoCostumer(ambiente, pais, "ClienteOnlyNetProductoCancelado");
			return serviceConnect.consultaCostumerGraph("id").replace("[", "").replace("]", "");
	}
	public String extraeIdClienteCorporativo(String ambiente, String pais) throws IOException{
		serviceConnect.conexionDelServicoCorporativo(ambiente, pais, "ClienteCorporativo");
		return serviceConnect.consultaCostumerGraph("id").replace("[", "").replace("]", "").replace("]", "").replace("]", "");
	}

	/**
	 * Obtiene un numero de cliente en Poswinback que cumpla con los parametros dados para realizar Intencion de Baja
	 * @param ambiente
	 * @param pais
	 * @param nombreConsulta
	 * @return
	 * @throws IOException
	 */
	public String clienteCanceladoPendiente(String ambiente, String pais,  String nombreConsulta) throws IOException {
		serviceConnect.conexionDelServicoCorporativoYPoswinback(ambiente, pais, nombreConsulta);
        return serviceConnect.consultaCostumerGraph("id").replace("[", "").replace("]", "").replace("]", "");
	}
	
	
	/**
	 * Método para obterner el Id de un cliente para flujos de Prepago Normal según los parametros dados
	 * @param ambiente
	 * @param pais
	 * @return
	 * @throws IOException
	 */
	public String extraeIdClientePrepagoNormalConPropuestas(String ambiente, String pais) throws IOException{		
		 String[] idCustomer = new String[4];
		String idAgrementOFFPrePago ="5";
		
		 if(UtilDatos.getPais().equals("CO")) {
			 idAgrementOFFPrePago = "18";
		 }
		
		Map<String, String> datosParaConsulta = new HashMap<>();
		datosParaConsulta.put("idAgreementOFFPrePago", idAgrementOFFPrePago);
		
		int cantidadDePruebas = 0;
		boolean encontroCliente = false;
		while(cantidadDePruebas<=20 && !encontroCliente){
			serviceConnect.conexionDelServicoSesamo(ambiente, pais, "ClientePrepagoConPropuesta",datosParaConsulta);
			
			for(int i=0 ;i<serviceConnect.extraeCantidadDeClientesConsultados("findLoyaltyPromotionForCustomer");i++) {
				idCustomer = serviceConnect.extraInformacionDelCliente(i);
				
				if(idCustomer[1].equals("0")) {
					encontroCliente = true;
					break;
				}
			}
			cantidadDePruebas++;
			logger.info("Se realizo "+cantidadDePruebas+" intentos para encontrar un cliente con los parametros necesarios");
			
		}
		if(cantidadDePruebas<0)	
			ExceptionsProyecto.excepcionComprometidoServicios("No se encontro Cliente con los parámetros establecidos");
		
		
		
		return idCustomer[0];
	}
	
	
	
}
