package sia.tacocloud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 1
public class HomeController {

    @GetMapping("/")      // 2
    public String home(){
        return "home";    // 3
    }
}


/**
 * 1: @Controller
 *  - Identifies the class as a component for component scanning
 *  - This allows Spring to discover it and instantiate `HomeController`
 *        as a bean in the Spring Application Context
 */

/**
 * 2: @GetMapping("/")
 *  - handles GET requests for `/` path
 */

/**
 * 3: return "home";
 *  - returns name of view
 *  - view is the template file with the same filename 
 */