package regional.runners;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

public class SmokeTestEngageRunner {

private static final Logger logger = LoggerFactory.getLogger(SmokeTestEngageRunner.class);

	

	@Test
	public void subrunner() {
		try {	
			JUnitCore.runClasses(TestRunnerSmokeTest.class);
		} 
		catch (Exception e) {
			logger.error("Error runnertags");
		}
	}
	
	@RunWith(CucumberWithSerenity.class)
	@CucumberOptions(
			plugin = {"pretty","json:target/cucumber.json", "rerun:target/rerun.txt"}
			,features = "src/test/resources/features"
			,tags = "@EnvioSolicitudFormulario"
			,snippets = CAMELCASE
			,glue = {"regional.definitions"})
	public class TestRunnerSmokeTest{

	}
}
