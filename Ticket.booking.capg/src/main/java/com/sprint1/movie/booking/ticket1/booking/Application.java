package com.sprint1.movie.booking.ticket1.booking;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
	static final org.slf4j.Logger log = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx= SpringApplication.run(Application.class, args);
		log.info("Before Starting application");
		log.debug("Starting my application in debug with {} args", args.length);
	    log.info("Starting my application with {} args.", args.length);  
	  //  ctx.close();
	}
}

