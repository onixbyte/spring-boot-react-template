package com.onixbyte.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Application entry.
 *
 * @author zihluwang
 */
@SpringBootApplication
public class ServerApplication {

    /**
     * Logger instance.
     */
    private static final Logger log = LoggerFactory.getLogger(ServerApplication.class);

    /**
     * Spring Boot entry point.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

}
