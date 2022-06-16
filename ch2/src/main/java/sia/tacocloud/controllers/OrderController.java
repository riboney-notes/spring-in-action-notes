package sia.tacocloud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import sia.tacocloud.models.TacoOrder;

import javax.validation.Valid;

@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DesignTacoController.class);


    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

/*
  @PostMapping
  public String processOrder(TacoOrder order, SessionStatus sessionStatus) {
    log.info("Order submitted: {}", order);
    sessionStatus.setComplete();
    return "redirect:/";
  }
*/

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors, SessionStatus sessionStatus) { // #1
        if (errors.hasErrors()) {
            return "orderForm";
        }

        log.info("Order submitted: {}", order);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}

// 1: @Valid
/*
    - rather than performing validation checks within the controller, the JavaBean Validation API can be used instead
      - this allows us to declare validation rules rather than writing declaration logic in controllers
      - requires the Spring Validation Starter dependency
      - See TacoOrder.java for how the rules are declared
 */