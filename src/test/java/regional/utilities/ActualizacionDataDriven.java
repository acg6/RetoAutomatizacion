package regional.utilities;

import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ActualizacionDataDriven {

	private static final Logger logger = LoggerFactory.getLogger(ActualizacionDataDriven.class);
	
	@Before
	public void setup() {
		try {	
			Capabilities.actualizarDriverNavegadores();	
		} 
		catch (Exception e) {
			logger.error("error about setup of Driver ");
		}
	}

	
}
