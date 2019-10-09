package no.zendera.FreightApplication;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.event.EventListener;

import java.lang.invoke.MethodHandles;

@SpringBootApplication
public class FreightApplication {

	private static Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	private BuildProperties buildProperties;

	public static void main(String[] args) {
		SpringApplication.run(FreightApplication.class, args);
	}
	@EventListener(FreightApplication.class)
	public void testing() {
		logger.info(buildProperties.getArtifact() + '-' + buildProperties.getVersion());
	}
}
