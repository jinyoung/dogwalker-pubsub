package dog.walker.common;

import dog.walker.WalkerApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { WalkerApplication.class })
public class CucumberSpingConfiguration {}
