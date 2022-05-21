package regional.runners;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import regional.utilities.ActualizacionDataDriven;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = {"json:target/cucumber.json", "rerun:target/rerun.txt"},
					features = "src/test/resources/features",
					tags = "@TEST_TACS-2044",
					snippets = CAMELCASE,
					glue = {"regional.definitions"})
public class RetencionesInboundRunner extends ActualizacionDataDriven {
		
}

