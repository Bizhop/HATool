package fi.bizhop.hatool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableAutoConfiguration
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	public static ConfigurableApplicationContext start(String[] args) {
	    ConfigurableApplicationContext context;

	    context = SpringApplication.run(Application.class, args);
	    log.info("Application started");
	    return context;
	  }

	  public static void main(String[] args) {
	    start(args);
	  }
}
