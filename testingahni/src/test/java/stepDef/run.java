package stepDef;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
  features = "src/test/resources/features", 
  glue = {"stepDef"},
  plugin = {"html:src/main/reportbyAhni.html"}
  )

public class run {

}
