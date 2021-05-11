package automationcraft.delivery.runners.lineal;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/automationcraft/testcreation/jetsmart/G4/featuresG4"},
        glue = {"automationcraft.testcreation.jetsmart.G4.steps","automationcraft.engine.bdd"},
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread"}
        ,tags = "@G4"
)
public class jetSmartG4 {
}
