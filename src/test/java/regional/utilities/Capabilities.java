package regional.utilities;
 
import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.util.SystemEnvironmentVariables;
 
public class Capabilities {
 
	/**
	 * Metodo que verifica si la versión del driver de los navegadores es la más reciente y en caso de no estar actualizada
	 * lo actualizada a la versión mas reciente disponible
	 */
	
    public static void actualizarDriverNavegadores() {  
            
        switch (SystemEnvironmentVariables.createEnvironmentVariables().getProperty("webdriver.driver")) {
        
        case "chrome":            
            WebDriverManager.chromedriver().setup();    
            break;      
        case "iexplorer":
            WebDriverManager.iedriver().setup();
            break;
        case "firefox":
            WebDriverManager.firefoxdriver().setup();
            break;
        default:            
            WebDriverManager.chromedriver().setup();
            break;
        }
    }
 
  

	private Capabilities() {}
}