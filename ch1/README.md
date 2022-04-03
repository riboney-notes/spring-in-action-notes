# 1: Getting started with Spring

[link](https://www.manning.com/books/spring-in-action-sixth-edition)

- Spring application context
  - container that instantiates, assembles, and manages application components (beans) through dependency injection

- Example of ways to "wire up" beans
  - XML files

  ```xml
  <bean id="inventoryService"
        class="com.example.InventoryService" />

  <bean id="productService"
        class="com.example.ProductService" />
    <constructor-arg ref="inventoryService" />
  </bean>
  ```

  - java annotations

  ```java
  @Configuration
  public class ServiceConfiguration {
    @Bean
    public InventoryService inventoryService() {
      return new InventoryService();
    }

    @Bean
    public ProductService productService() {
      return new ProductService(inventoryService());
    }
  }
  ```
  
- Component scanning
  - where Spring can automatically discover components from an application's classpath and create them as beans in the Spring Application context

- Autowiring
  - where Spring automatically injects the components with other beans that they depend on

- Autoconfiguration
  - feature of Spring boot that reduces amount of explicit configuration needed to build an application
  - Some things it does for you:
    - configures beans in the Spring application context to enable spring MVC
    - configures embedded tomcat server in the spring application context
    - configures thymeleaf view resolver for rendering Spring MVC views with thymeleaf templates

- Running Spring application
  - Building and running
    - `./mvnw package` then `java -jar target/app-name-SNAPSHOT.jar`
  
  - Spring boot maven plugin
    - `./mvnw spring-boot:run`

  - Running tests: 
    - `./mvnw test`

- Spring Boot Devtools
  - application restart when code changes
    - doesn't restart for changes to dependencies
  - browser refresh when static files changes
    - requires setting up livereload plugin for browser
  - disables template caches
    - by default, template engines cache the results of template parsing to avoid re-parsing for every request served which is good for production performance
    - this is disabled in development by DevTools to allow browser refresh when changes to templates or static resources are made
  - provides H2 console for H2 databases if in use
    - found at `http:/ /localhost:8080/h2-console`
  - works in any IDEs

### Spring Libraries

- Core Spring Framework
  - core container
  - dependency injection framework
  - Spring MVC
  - data persistance support
  - Spring Webflux

- Spring Boot
  - Starter dependencies
  - Autoconfiguration
  - Actuator
    - runtime insght, metrics, environment properties, etc
  - Spring Boot CLI

- Spring Data
  - Extends capabilities of core Spring Framework data persistance support:
    - Define data repositories as interfaces using naming conventions
    - Support for different kinds of databases (nosql, graph, etc)

- Spring Security
  - Authentication
  - Authorization
  - API Security

- Spring Integration
  - realtime integration where data is processed as its made available

- Spring Batch
  - batched integration where data is allowed to collect for a time until some trigger signals for the batch of data to be processed

- Spring Cloud
  - microservices

- Spring Native 
  - Compilation of Spring boot projects into native executuables 

