package regional.utilities;

public class UtilDatosEstaticos {


	private static final String[] PRODUCTOS_PREMIUN_PE = {"236","245","270","228","226","227","283","284","244","225","262","211","146","138","140","180","148","131"};
	public static final String PAIS_UY = "UY";
	public static final String PAIS_CO = "CO";
	public static final String PAIS_EC = "EC";
	public static final String PAIS_CL = "CL";
	public static final String PAIS_PE = "PE";
	
	private UtilDatosEstaticos() {
	    
	}
	
	public static String[] getProductosPremiumPE() {
		return PRODUCTOS_PREMIUN_PE;
	}

}