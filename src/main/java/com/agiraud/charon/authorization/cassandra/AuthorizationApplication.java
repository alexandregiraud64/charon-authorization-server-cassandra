package com.agiraud.charon.authorization.cassandra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication(scanBasePackages={"com.agiraud.charon"})
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class AuthorizationApplication extends SpringBootServletInitializer {
	/* ************************************************************************* */
	// MAIN
	/* ************************************************************************* */
	public static void main(String[] args) {
		SpringApplication.run(AuthorizationApplication.class, args);
	}
}
