package stepDefinitions;

import au.com.telstra.simcardactivator.SimCardActivator;
import au.com.telstra.simcardactivator.model.Sim;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = SimCardActivator.class, loader = SpringBootContextLoader.class)
public class SimCardActivatorStepDefinitions {
    @Autowired
    private TestRestTemplate restTemplate;

    private Sim simCard;

    @Given("Proper sim card")
    public void properSimCard(){
        simCard=new Sim("1255789453849037777","yusifshirinzade98@gmail.com",true);
    }

    @Given("Improper sim card")
    public void improperSimCard(){
        simCard=new Sim("8944500102198304826","yusifshirinzade98@gmail.com",false);
    }

    @When("A request is sent to activate the Sim card")
    public void aRequestIsSentToActivateTheSimCard(){
        restTemplate.postForObject("http://localhost:8080/activate", simCard, String.class);
    }

    @Then("Sim card is activated")
    public void simCardIsActivated(){
        Sim firstSimCard=restTemplate.getForObject("http://localhost:8080/query/{simCardId}", Sim.class, 1);
        assertTrue(firstSimCard.isActive());
    }

    @Then("Sim card is not activated")
    public void simCardIsNotActivated(){
        Sim secondSimCard=restTemplate.getForObject("http://localhost:8080/query?simCardId={simCardId}", Sim.class,2);
        assertFalse(secondSimCard.isActive());
    }

}