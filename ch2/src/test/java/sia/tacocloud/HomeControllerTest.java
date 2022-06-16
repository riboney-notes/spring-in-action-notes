package sia.tacocloud;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
//import sia.tacocloud.controllers.HomeController;

//@WebMvcTest(HomeController.class) //1
//public class HomeControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void testHomePage() throws Exception {
//        mockMvc.perform(get("/")) //2
//                .andExpect(status().isOk())
//                .andExpect(view().name("home"))
//                .andExpect(content().string(containsString("Welcome to...")));
//    }
//}

/**
 * 1: @WebMVcTest(HomeController.class)
 *  - annotation provided by Spring Boot to arrange the test to run in the context of Spring MVC app
 *  - also arranges HomeController to be registered in Spring MVC so you can send requests to it
 *  - Sets up Spring support for tesing Spring MVC
 */

/**
 * 2: MockMvc
 *  - Mocks HTTP requests
 */

// run this test by: `./mvnw test`