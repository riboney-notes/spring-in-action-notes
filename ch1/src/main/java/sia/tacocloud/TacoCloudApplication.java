package sia.tacocloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //1
public class TacoCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacoCloudApplication.class, args); //2
	}

}


/**
 * 1: @SpringBootApplication
 * 	- Composite annotation that combines three annotations:
 *     - `@SpringBootConfiguration` - Designates the class as a configuration class
 *     - `@EnableAutoConfiguration` - Enables Spring Boot automatic configuration
 *     - `@ComponentScan` - Allows you to declare other classes with spring annotations
 *        - ex: `@Component, @Controller, @Service` to have Spring
 */

/**
 * 2: SpringApplication.run(...)
 * 	 - performs the bootstrapping of the spring application by creating the application context
 *   - Parameters passed into it are a configuration class and CLI arguments
 */
