package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                // features we use to provide the path of all the features files
                features = "src/test/resources/features",
                //glue means attached all the files
                glue = "steps",
                //when you set dryRun == true means its stop all the other steps
                //it will execute only new scenarios
                //dryRun =true
                //when we set dryRun to false will execute all again
                dryRun= false,
                //to execute test cases from different sprint's like below
                tags="@test1",
                // to remove irrelevant info from concole you need to say monochrome to true
                monochrome = true,
                plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json",
                        //this failed.txt file holds all the scenarios which are failed  during execution
                        "rerun:target/failed.txt"}
        )

public class SmokeRunner {

}
